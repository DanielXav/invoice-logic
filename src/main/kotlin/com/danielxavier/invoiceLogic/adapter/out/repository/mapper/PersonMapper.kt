package com.danielxavier.invoiceLogic.adapter.out.repository.mapper

import com.danielxavier.invoiceLogic.adapter.out.repository.entity.PersonEntity
import com.danielxavier.invoiceLogic.domain.Person

object PersonMapper {

    fun PersonEntity.toDomain(): Person {
        return Person(
            id = this.id,
            name = this.name,
            age = this.age
        )
    }

    fun Person.toEntity(): PersonEntity {
        return PersonEntity(
            id = this.id,
            name = this.name,
            age = this.age
        )
    }
}