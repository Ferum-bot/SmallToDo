package com.ferum_bot.smalltodo.application

import com.ferum_bot.smalltodo.configurations.RepositoryConfigurations
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(RepositoryConfigurations::class)
class SmallToDoApplication

fun main(args: Array<String>) {
    runApplication<SmallToDoApplication>(*args)
}
