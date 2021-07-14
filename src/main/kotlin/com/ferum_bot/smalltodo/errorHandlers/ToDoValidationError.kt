package com.ferum_bot.smalltodo.errorHandlers

import com.fasterxml.jackson.annotation.JsonInclude

class ToDoValidationError(
    val errorMessage: String,
) {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private val _errors = mutableListOf<String>()
    val errors: List<String> = _errors

    fun addError(error: String) {
        _errors.add(error)
    }

    fun addErrors(errors: Collection<String>) {
        this._errors.addAll(errors)
    }

}