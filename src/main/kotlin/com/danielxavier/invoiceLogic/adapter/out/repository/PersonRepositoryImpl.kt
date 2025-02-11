package com.danielxavier.invoiceLogic.adapter.out.repository

import com.danielxavier.invoiceLogic.adapter.out.repository.mapper.PersonMapper.toDomain
import com.danielxavier.invoiceLogic.adapter.out.repository.mapper.PersonMapper.toEntity
import com.danielxavier.invoiceLogic.adapter.out.repository.provider.PersonProvider
import com.danielxavier.invoiceLogic.application.ports.out.PersonRepository
import com.danielxavier.invoiceLogic.domain.Person
import org.springframework.stereotype.Component

@Component
class PersonRepositoryImpl(
    private val personProvider: PersonProvider
) : PersonRepository {
    override fun findById(personId: Long): Person? {
        return personProvider.findById(personId).map { it.toDomain() }.orElse(null)
    }

    override fun findAll(): List<Person> {
        return personProvider.findAll().map { it.toDomain() }
    }

    override fun insert(person: Person): Person {
        val entity = personProvider.save(person.toEntity())
        return entity.toDomain()
    }

    override fun update(personId: Long, person: Person): Person? {
        val entity = personProvider.findById(personId).orElse(null) ?: return null

        entity.apply {
            name = person.name
            age = person.age
        }

        return personProvider.save(entity).toDomain()
    }

    override fun deleteById(personId: Long) {
        personProvider.deleteById(personId)
    }
}