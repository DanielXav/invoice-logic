package com.danielxavier.invoiceLogic.adapter.out.repository.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class InvoiceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val idEvent: String = "",
    val invoiceValue: Double = 0.0,
    val date: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "invoice", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    val items: List<InvoiceItemEntity> = mutableListOf()
)

