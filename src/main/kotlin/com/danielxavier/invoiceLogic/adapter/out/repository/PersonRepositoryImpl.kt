package com.danielxavier.invoiceLogic.adapter.out.repository

import com.danielxavier.invoiceLogic.application.ports.out.PersonRepository
import com.danielxavier.invoiceLogic.domain.Person

class PersonRepositoryImpl(): PersonRepository {
    override fun findById(personId: Int): Person? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Person> {
        TODO("Not yet implemented")
    }

    override fun insert(person: Person) {
        TODO("Not yet implemented")
    }

    override fun deleteById(personId: Int) {
        TODO("Not yet implemented")
    }
}