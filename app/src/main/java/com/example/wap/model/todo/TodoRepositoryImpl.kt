package com.example.wap.model.todo

import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val dao: TodoDao
) : TodoRepository{
    override suspend fun insertTodo(todo: TodoData) {
        dao.insertTodo(todo)
    }

    override suspend fun deleteTodo(todo: TodoData) {
        dao.deleteTodo(todo)
    }

    override suspend fun getTodoById(id: Int): TodoData? {
        return dao.getTodoById(id)
    }

    override fun getTodos(): Flow<List<TodoData>> {
        return dao.getTodos()
    }

    override suspend fun updateTodo(todo: TodoData) {
        dao.updateTodo(todo)
    }
}