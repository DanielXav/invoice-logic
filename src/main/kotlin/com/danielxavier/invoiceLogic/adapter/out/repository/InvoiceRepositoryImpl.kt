package com.danielxavier.invoiceLogic.adapter.out.repository

import com.danielxavier.invoiceLogic.adapter.out.repository.mapper.InvoiceMapper.toDomain
import com.danielxavier.invoiceLogic.adapter.out.repository.mapper.InvoiceMapper.toEntity
import com.danielxavier.invoiceLogic.adapter.out.repository.provider.InvoiceProvider
import com.danielxavier.invoiceLogic.application.ports.out.InvoiceRepository
import com.danielxavier.invoiceLogic.domain.Invoice
import org.springframework.stereotype.Component

@Component
class InvoiceRepositoryImpl(
    private val invoiceProvider: InvoiceProvider
): InvoiceRepository {

    override fun insert(invoice: Invoice): Invoice? {
        val entity = invoice.toEntity()
        entity.items.forEach { it.invoice = entity }
        return invoiceProvider.save(entity).toDomain()
    }
}