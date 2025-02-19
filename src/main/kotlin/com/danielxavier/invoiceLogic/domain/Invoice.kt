package com.danielxavier.invoiceLogic.domain

import java.time.LocalDateTime

data class Invoice(
    val idEvent: String,
    var invoiceValue: Double,
    val date: LocalDateTime,
    val items: List<InvoiceItem>
)

data class InvoiceItem(
    val establishment: String,
    val invoiceValue: Double
)