package com.ferum_bot.smalltodo.repositories

import com.ferum_bot.smalltodo.entities.ToDoModel
import com.ferum_bot.smalltodo.enums.DeleteResult
import org.springframework.stereotype.Repository

@Repository
class InMemoryRepository: CommonRepository<ToDoModel> {
    
    override fun safe(model: ToDoModel): ToDoModel {
        TODO("Not yet implemented")
    }

    override fun safe(models: Iterable<ToDoModel>): Iterable<ToDoModel> {
        TODO("Not yet implemented")
    }

    override fun delete(model: ToDoModel): DeleteResult {
        TODO("Not yet implemented")
    }

    override fun delete(models: Iterable<ToDoModel>): Iterable<DeleteResult> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): ToDoModel? {
        TODO("Not yet implemented")
    }

    override fun getAll(): Iterable<ToDoModel> {
        TODO("Not yet implemented")
    }

}