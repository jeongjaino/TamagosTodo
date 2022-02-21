package com.example.wap.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.wap.databinding.DialogCalendarBinding
import java.text.SimpleDateFormat


class CalendarDialog : DialogFragment() {
    private val binding by lazy{ DialogCalendarBinding.inflate(layoutInflater)}

    private lateinit var dialogViewModel: DialogViewModel

    private var sdf: SimpleDateFormat = SimpleDateFormat("yy/MM/dd")

    override fun onCreateView( 
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        dialogViewModel = ViewModelProvider(requireActivity())[DialogViewModel::class.java]

        dialogViewModel.currentTime.observe(this){
            binding.calendarTime.text = it
        }

        binding.calendarCardView.setOnClickListener{
            val dialog = TimePickerDialog()
            dialog.show(activity!!.supportFragmentManager, "time_picker_dialog")
        }

        binding.calendarPositiveButton.setOnClickListener {
            dialogViewModel.setDate(sdf.format(binding.calendarView.date))
            dismiss()
        }
        binding.calendarNegativeButton.setOnClickListener {
            dismiss()
        }
        return binding.root
    }
}