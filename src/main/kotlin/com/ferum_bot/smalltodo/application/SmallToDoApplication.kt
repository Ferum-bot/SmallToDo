package com.ferum_bot.smalltodo.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmallToDoApplication

fun main(args: Array<String>) {
    runApplication<SmallToDoApplication>(*args)
}
