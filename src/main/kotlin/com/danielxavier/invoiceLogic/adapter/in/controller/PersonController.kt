package com.danielxavier.invoiceLogic.adapter.`in`.controller

import com.danielxavier.invoiceLogic.application.usecase.PersonUseCase
import com.danielxavier.invoiceLogic.domain.Person
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController(
    private val personUseCase: PersonUseCase
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Person> {
        val person = personUseCase.findById(id)
        return person?.let {
            ResponseEntity.ok(person)
        } ?: ResponseEntity.notFound().build()
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<Person>> {
        val persons = personUseCase.findAll()
        return persons.takeIf { it.isNotEmpty() }?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun insert(@RequestBody person: Person): ResponseEntity<Person> {
        val createdPerson = personUseCase.insert(person)
        return createdPerson?.let {
            ResponseEntity.status(HttpStatus.CREATED).body(it)
        } ?: ResponseEntity.badRequest().build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody person: Person): ResponseEntity<Person> {
        val updatedPerson = personUseCase.update(id, person)
        return updatedPerson?.let {
            ResponseEntity.ok(updatedPerson)
        } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> =
        runCatching { personUseCase.delete(id) }
            .fold(
                onSuccess = { ResponseEntity.noContent().build() },
                onFailure = { ResponseEntity.badRequest().build() }
            )
}