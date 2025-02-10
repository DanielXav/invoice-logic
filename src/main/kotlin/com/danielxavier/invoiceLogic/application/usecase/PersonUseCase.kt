package com.danielxavier.invoiceLogic.application.usecase

import com.danielxavier.invoiceLogic.application.ports.out.PersonRepository
import com.danielxavier.invoiceLogic.domain.Person
import org.springframework.stereotype.Component

@Component
class PersonUseCase(
    private val personRepository: PersonRepository
) {

    fun findById(id: Long): Person? {
        return personRepository.findById(id)
    }

    fun findAll(): List<Person> {
        return personRepository.findAll()
    }

    fun insert(person: Person): Person? {
        return personRepository.insert(person)
    }

    fun update(id: Long, person: Person): Person? {
        return personRepository.update(id, person)
    }

    fun delete(id: Long) {
        personRepository.deleteById(id)
    }
}