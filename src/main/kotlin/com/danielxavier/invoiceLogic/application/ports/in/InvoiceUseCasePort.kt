package com.danielxavier.invoiceLogic.application.ports.`in`

import com.danielxavier.invoiceLogic.adapter.`in`.queue.event.InvoiceEvent

interface InvoiceUseCasePort {

    fun execute(invoiceEvent: InvoiceEvent)
}