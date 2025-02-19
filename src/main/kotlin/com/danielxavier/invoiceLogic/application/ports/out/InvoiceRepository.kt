package com.danielxavier.invoiceLogic.application.ports.out

import com.danielxavier.invoiceLogic.domain.Invoice

interface InvoiceRepository {

    fun insert(invoice: Invoice): Invoice?

}