package com.danielxavier.invoiceLogic.application.usecase

import com.danielxavier.invoiceLogic.adapter.`in`.queue.event.InvoiceEvent
import com.danielxavier.invoiceLogic.application.ports.`in`.InvoiceUseCasePort
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class InvoiceUseCase(): InvoiceUseCasePort {
    override fun execute(invoiceEvent: InvoiceEvent) {
        logger.info("Itens:  ${invoiceEvent.id}, ${invoiceEvent.date}, ${invoiceEvent.value}, ${invoiceEvent.items}")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(InvoiceUseCase::class.java)
    }
}