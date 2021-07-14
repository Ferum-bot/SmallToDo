package com.ferum_bot.smalltodo.factories

import com.ferum_bot.smalltodo.responses.ErrorResponseBody
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.net.http.HttpRequest

object ErrorResponseBodyFactory {

    fun toDoNotFound(): ErrorResponseBody<Nothing> =
        ErrorResponseBody(
            statusCode = HttpStatus.NOT_FOUND.value(),
            errorMessage = "ToDo not found!",
            errors = emptyList(),
            additionalInfo = null,
        )

}