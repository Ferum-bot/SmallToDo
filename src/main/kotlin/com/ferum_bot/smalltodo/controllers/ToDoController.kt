package com.ferum_bot.smalltodo.controllers

import com.ferum_bot.smalltodo.entities.ToDoModel
import com.ferum_bot.smalltodo.errorHandlers.ToDoValidationError
import com.ferum_bot.smalltodo.factories.ErrorResponseBodyFactory
import com.ferum_bot.smalltodo.factories.ToDoValidationErrorFactory
import com.ferum_bot.smalltodo.repositories.CommonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todo")
class ToDoController {

    @Autowired
    private lateinit var repository: CommonRepository<ToDoModel>



    @GetMapping("/all")
    fun getAllToDos(): ResponseEntity<Iterable<ToDoModel>> {
        return ResponseEntity.ok(repository.getAll())
    }

    @GetMapping("/{id}")
    fun getToDo(
        @PathVariable
        id: String
    ): ResponseEntity<ToDoModel> {
        val result = repository.findById(id)
        return if (result == null) {
            val body = ErrorResponseBodyFactory.toDoNotFound()
            ResponseEntity<ToDoModel>(HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity.ok(result)
        }
    }

    @PostMapping("/complete/{id}")
    fun todoCompleted(
        @PathVariable
        id: String,
    ): ResponseEntity<ToDoModel> {
        val result = repository.findById(id)
            ?: return ResponseEntity(HttpStatus.NOT_FOUND)

        result.isComplete = true
        repository.safe(result)
        return ResponseEntity.ok(result)
    }

    @RequestMapping("/create", method = [RequestMethod.POST, RequestMethod.PUT])
    fun createToDo(
        @Validated
        @RequestBody
        toDoModel: ToDoModel,
        errors: Errors,
    ): ResponseEntity<*> {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ToDoValidationErrorFactory.bindFromErrors(errors))
        }

        val result = repository.safe(toDoModel)
        return  ResponseEntity.ok(result)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteToDo(
        @PathVariable
        id: String,
    ): ResponseEntity<*> {
        val result = repository.findById(id)
            ?: return ResponseEntity.notFound().build<ToDoModel>()
        repository.delete(result)
        return ResponseEntity.ok().body("deleted")
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleException(
        exception: Exception
    ): ResponseEntity<*> {
        return ResponseEntity.badRequest().body(ToDoValidationError(exception.localizedMessage))
    }
}