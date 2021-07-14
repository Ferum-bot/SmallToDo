package com.ferum_bot.smalltodo.entities

import org.hibernate.Hibernate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class ToDoModel(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: String,

    val description: String,

    val createdDate: LocalDateTime = LocalDateTime.now(),

    val lastModifiedDate: LocalDateTime = LocalDateTime.now(),

    var isComplete: Boolean = false,
): Comparable<ToDoModel> {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) {
            return false
        }
        other as ToDoModel

        return id == other.id
    }

    override fun hashCode(): Int = 2124660814

    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }

    override fun compareTo(other: ToDoModel): Int {
        return id.compareTo(other.id)
    }
}
