package com.ferum_bot.smalltodo.builders

import com.ferum_bot.smalltodo.entities.ToDoModel
import java.time.LocalDateTime
import java.util.*

object ToDoModelBuilder {

    var description: String = ""

    fun build(): ToDoModel {
        val id = UUID.randomUUID().toString()

        return ToDoModel(
            id = id, description = description,
            createdDate = LocalDateTime.now(),
            lastModifiedDate = LocalDateTime.now(),
            isComplete = false,
        )
    }

}