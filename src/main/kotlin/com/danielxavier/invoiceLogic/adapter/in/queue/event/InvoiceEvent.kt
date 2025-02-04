package com.danielxavier.invoiceLogic.adapter.`in`.queue.event

import java.time.LocalDateTime

data class InvoiceEvent(
    val id: String,
    val value: Double,
    val date: LocalDateTime,
    val items: List<InvoiceItem>
)

data class InvoiceItem(
    val establishment: String,
    val value: Double
)
