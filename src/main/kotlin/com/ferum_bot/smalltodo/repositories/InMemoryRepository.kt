package com.ferum_bot.smalltodo.repositories

import com.ferum_bot.smalltodo.entities.ToDoModel
import com.ferum_bot.smalltodo.enums.DeleteResult
import org.springframework.stereotype.Repository

@Repository
class InMemoryRepository: CommonRepository<ToDoModel> {

    private val models: MutableSet<ToDoModel> = mutableSetOf()

    override fun safe(model: ToDoModel): ToDoModel {
        models.add(model)
        return model
    }

    override fun safe(models: Iterable<ToDoModel>): Iterable<ToDoModel> {
        this.models.addAll(models)
        return models
    }

    override fun delete(model: ToDoModel): DeleteResult {
        val result = models.remove(model)
        return if (result) {
            DeleteResult.MODEL_DELETED
        } else {
            DeleteResult.MODEL_WAS_NOT_DELETED
        }
    }

    override fun delete(models: Iterable<ToDoModel>): DeleteResult {
        val result = this.models.removeAll(models)
        return if (result) {
            DeleteResult.MODEL_DELETED
        } else {
            DeleteResult.MODEL_WAS_NOT_DELETED
        }
    }

    override fun findById(id: String): ToDoModel? {
        return models.find { it.id == id }
    }

    override fun getAll(): Iterable<ToDoModel> {
        return models
    }

}