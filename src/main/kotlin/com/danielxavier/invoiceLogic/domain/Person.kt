package com.danielxavier.invoiceLogic.domain

import java.time.LocalDate

data class Person(
    val id: Long,
    val name: String,
    val age: LocalDate
)
