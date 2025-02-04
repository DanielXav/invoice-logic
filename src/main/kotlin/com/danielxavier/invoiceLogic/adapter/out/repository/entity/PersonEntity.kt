package com.danielxavier.invoiceLogic.adapter.out.repository.entity

import java.time.LocalDate

data class PersonEntity(
    val id: Long,
    val name: String,
    val age: LocalDate
)
