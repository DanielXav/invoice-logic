package com.danielxavier.invoiceLogic.application.ports.out

import com.danielxavier.invoiceLogic.domain.Person

interface PersonRepository {

    fun findById(personId: Long): Person?

    fun findAll(): List<Person>

    fun insert(person: Person): Person?

    fun update(personId: Long, person: Person): Person?

    fun deleteById(personId: Long)
}