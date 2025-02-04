package com.danielxavier.invoiceLogic.application.ports.out

import com.danielxavier.invoiceLogic.domain.Person

interface PersonRepository {

    fun findById(personId: Int): Person?

    fun findAll(): List<Person>

    fun insert(person: Person)

    fun deleteById(personId: Int)
}