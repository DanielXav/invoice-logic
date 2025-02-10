package com.danielxavier.invoiceLogic.adapter.`in`.controller

import com.danielxavier.invoiceLogic.application.usecase.PersonUseCase
import com.danielxavier.invoiceLogic.domain.Person
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController(
    private val personUseCase: PersonUseCase
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Person? {
        return personUseCase.findById(id)
    }

    @GetMapping
    fun findAll(): List<Person> {
        return personUseCase.findAll()
    }

    @PostMapping
    fun insert(@RequestBody person: Person): Person? {
        return personUseCase.insert(person)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody person: Person): Person? {
        return personUseCase.update(id, person)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        personUseCase.delete(id)
    }
}