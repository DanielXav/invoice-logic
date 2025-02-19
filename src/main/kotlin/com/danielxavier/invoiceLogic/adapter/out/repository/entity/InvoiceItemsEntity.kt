package com.danielxavier.invoiceLogic.adapter.out.repository.entity

import jakarta.persistence.*

@Entity
data class InvoiceItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val establishment: String = "",
    val invoiceValue: Double = 0.0,

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    var invoice: InvoiceEntity? = null
)