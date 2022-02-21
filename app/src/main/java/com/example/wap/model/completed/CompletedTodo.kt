package com.example.wap.model.completed

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CompletedTodo(
    val todo: String?,
    val date: String?,
    val time: String?,
    val level: Int?,
    val completedTime: String?,
    @PrimaryKey val id: Int? = null
)
