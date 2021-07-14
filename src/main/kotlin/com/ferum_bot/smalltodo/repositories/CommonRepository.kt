package com.ferum_bot.smalltodo.repositories

import com.ferum_bot.smalltodo.enums.DeleteResult

interface CommonRepository<Model> {

    fun safe(model: Model): Model

    fun safe(models: Iterable<Model>): Iterable<Model>

    fun delete(model: Model): DeleteResult

    fun delete(models: Iterable<Model>): DeleteResult

    fun findById(id: String): Model?

    fun getAll(): Iterable<Model>
}