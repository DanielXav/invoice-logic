package com.danielxavier.invoiceLogic.adapter.out.repository.mapper

import com.danielxavier.invoiceLogic.adapter.out.repository.entity.InvoiceEntity
import com.danielxavier.invoiceLogic.adapter.out.repository.entity.InvoiceItemEntity
import com.danielxavier.invoiceLogic.domain.Invoice
import com.danielxavier.invoiceLogic.domain.InvoiceItem

object InvoiceMapper {

    fun Invoice.toEntity(): InvoiceEntity {
        return InvoiceEntity(
            idEvent = this.idEvent,
            invoiceValue = this.invoiceValue,
            date = this.date,
            items = this.items.map { it.toEntity() }
        )
    }

    fun InvoiceItem.toEntity(): InvoiceItemEntity {
        return InvoiceItemEntity(
            establishment = this.establishment,
            invoiceValue = this.invoiceValue
        )
    }

    fun InvoiceEntity.toDomain(): Invoice {
        return Invoice(
            idEvent = this.idEvent,
            invoiceValue = this.invoiceValue,
            date = this.date,
            items = this.items.map {it.toDomain()}
        )
    }

    fun InvoiceItemEntity.toDomain(): InvoiceItem {
        return InvoiceItem(
            establishment = this.establishment,
            invoiceValue = this.invoiceValue,
        )
    }
}