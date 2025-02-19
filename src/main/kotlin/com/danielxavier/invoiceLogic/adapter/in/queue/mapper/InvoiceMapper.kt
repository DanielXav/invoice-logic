package com.danielxavier.invoiceLogic.adapter.`in`.queue.mapper

import com.danielxavier.invoiceLogic.adapter.`in`.queue.event.InvoiceEvent
import com.danielxavier.invoiceLogic.adapter.`in`.queue.event.InvoiceItemEvent
import com.danielxavier.invoiceLogic.domain.Invoice
import com.danielxavier.invoiceLogic.domain.InvoiceItem

object InvoiceMapper {

    fun InvoiceEvent.toDomain(): Invoice {
        return Invoice(
            idEvent = this.idEvent,
            invoiceValue = this.invoiceValue,
            date = this.date,
            items = this.items.map { it.toDomain() }
        )
    }

    fun InvoiceItemEvent.toDomain(): InvoiceItem {
        return InvoiceItem(
            establishment = this.establishment,
            invoiceValue = this.invoiceValue
        )
    }
}