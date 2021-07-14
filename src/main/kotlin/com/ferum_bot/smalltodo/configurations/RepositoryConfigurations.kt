package com.ferum_bot.smalltodo.configurations

import com.ferum_bot.smalltodo.entities.ToDoModel
import com.ferum_bot.smalltodo.repositories.CommonRepository
import com.ferum_bot.smalltodo.repositories.InMemoryRepository
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


@Configuration
@ComponentScan("com.ferum_bot.smalltodo.controllers")
class RepositoryConfigurations {

    @Bean
    fun provideInMemoryRepository(): CommonRepository<ToDoModel> {
        return InMemoryRepository()
    }

}