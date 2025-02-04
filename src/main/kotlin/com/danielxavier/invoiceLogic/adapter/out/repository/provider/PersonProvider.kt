package com.danielxavier.invoiceLogic.adapter.out.repository.provider

import com.danielxavier.invoiceLogic.adapter.out.repository.entity.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonProvider : JpaRepository<PersonEntity, Long>