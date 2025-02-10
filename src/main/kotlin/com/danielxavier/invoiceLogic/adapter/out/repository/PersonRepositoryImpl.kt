package com.danielxavier.invoiceLogic.adapter.out.repository

import com.danielxavier.invoiceLogic.adapter.out.repository.mapper.PersonMapper.toDomain
import com.danielxavier.invoiceLogic.adapter.out.repository.mapper.PersonMapper.toEntity
import com.danielxavier.invoiceLogic.adapter.out.repository.provider.PersonProvider
import com.danielxavier.invoiceLogic.application.ports.out.PersonRepository
import com.danielxavier.invoiceLogic.domain.Person
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PersonRepositoryImpl(
    private val personProvider: PersonProvider
): PersonRepository {
    override fun findById(personId: Long): Person? {
        try {
            return personProvider.getReferenceById(personId).toDomain()
        } catch (ex: Exception) {
            logger.error("Erro ao encontrar a pessoa com o id $personId", ex)
            throw ex
        }
    }

    override fun findAll(): List<Person> {
        try {
            return personProvider.findAll().map { it.toDomain() }
        } catch (ex: Exception) {
            logger.error("Ocorreu um erro ao buscar todos os registros. ", ex)
            throw ex
        }
    }

    override fun insert(person: Person): Person {
        try {
            val entity = personProvider.save(person.toEntity())
            return entity.toDomain()
        } catch (ex: Exception) {
            logger.error("Erro ao inserir pessoa na base.", ex)
            throw ex
        }
    }

    override fun update(personId: Long, person: Person): Person {
        try {

            val entity = personProvider.findById(personId).orElseThrow {
                throw IllegalArgumentException("Pessoa com ID $personId não encontrada.")
            }

            val updatedEntity = entity.copy(
                name = person.name,
                age = person.age
            )

            return personProvider.save(updatedEntity).toDomain()
        } catch (ex: Exception) {
            logger.error("Erro ao atualizar pessoa com o id $personId", ex)
            throw ex
        }
    }

    override fun deleteById(personId: Long) {
        try {
            personProvider.deleteById(personId)
        } catch (ex: Exception) {
            logger.error("Erro ao deletar pessoa com o id $personId", ex)
            throw ex
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(PersonRepositoryImpl::class.java)
    }
}