package com.ferum_bot.smalltodo.responses

import com.fasterxml.jackson.annotation.JsonInclude

data class ErrorResponseBody<T>(

    val statusCode: Int,

    val errorMessage: String,

    val errors: Collection<String>,

    @JsonInclude(JsonInclude.Include.ALWAYS)
    val additionalInfo: T?

)
