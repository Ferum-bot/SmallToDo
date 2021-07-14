package com.ferum_bot.smalltodo.factories

import com.ferum_bot.smalltodo.errorHandlers.ToDoValidationError
import org.springframework.validation.Errors

object ToDoValidationErrorFactory {

    fun bindFromErrors(errors: Errors): ToDoValidationError {
        val validationError = ToDoValidationError(
            "Validation Failed with ${errors.errorCount} error(s)"
        )
        errors.allErrors.forEach { error ->
            validationError.addError(error.defaultMessage.orEmpty())
        }

        return validationError
    }

}