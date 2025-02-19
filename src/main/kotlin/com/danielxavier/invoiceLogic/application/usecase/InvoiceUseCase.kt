package com.danielxavier.invoiceLogic.application.usecase

import com.danielxavier.invoiceLogic.application.ports.out.InvoiceRepository
import com.danielxavier.invoiceLogic.domain.Invoice
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class InvoiceUseCase(
    private val invoiceRepository: InvoiceRepository
) {
    fun execute(invoice: Invoice) {
        logger.info("Itens:  ${invoice.idEvent}, ${invoice.date}, ${invoice.invoiceValue}, ${invoice.items}")
        invoiceRepository.insert(invoice)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(InvoiceUseCase::class.java)
    }
}