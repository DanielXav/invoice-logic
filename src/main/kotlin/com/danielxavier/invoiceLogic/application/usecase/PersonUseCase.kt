package com.danielxavier.invoiceLogic.application.usecase

import com.danielxavier.invoiceLogic.application.ports.out.PersonRepository
import com.danielxavier.invoiceLogic.domain.Person
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PersonUseCase(
    private val personRepository: PersonRepository
) {

    fun findById(id: Long): Person? =
        try {
            personRepository.findById(id)
        } catch (ex: Exception) {
            logger.error("Erro ao encontrar a pessoa com o id $id", ex)
            throw ex
        }

    fun findAll(): List<Person> =
        try {
            personRepository.findAll()
        } catch (ex: Exception) {
            logger.error("Ocorreu um erro ao buscar todos os registros. ", ex)
            throw ex
        }

    fun insert(person: Person): Person? =
        try {
            personRepository.insert(person)
        } catch (ex: Exception) {
            logger.error("Erro ao inserir pessoa na base.", ex)
            throw ex
        }

    fun update(id: Long, person: Person): Person? =
        try {
            personRepository.update(id, person)
        } catch (ex: Exception) {
            logger.error("Erro ao atualizar pessoa com o id $id", ex)
            throw ex
        }

    fun delete(id: Long) =
        try {
            personRepository.deleteById(id)
        } catch (ex: Exception) {
            logger.error("Erro ao deletar pessoa com o id $id", ex)
            throw ex
        }

    companion object {
        private val logger = LoggerFactory.getLogger(PersonUseCase::class.java)
    }
}