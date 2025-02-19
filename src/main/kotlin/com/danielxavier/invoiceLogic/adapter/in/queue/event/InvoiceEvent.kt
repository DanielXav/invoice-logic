package com.danielxavier.invoiceLogic.adapter.`in`.queue.event

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class InvoiceEvent(
    @JsonProperty("id") val idEvent: String,
    @JsonProperty("value") val invoiceValue: Double,
    val date: LocalDateTime,
    val items: List<InvoiceItemEvent>
)

data class InvoiceItemEvent(
    val establishment: String,
    @JsonProperty("value") val invoiceValue: Double
)
