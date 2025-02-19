package com.danielxavier.invoiceLogic.adapter.`in`.queue

import com.danielxavier.invoiceLogic.adapter.`in`.queue.event.InvoiceEvent
import com.danielxavier.invoiceLogic.adapter.`in`.queue.mapper.InvoiceMapper.toDomain
import com.danielxavier.invoiceLogic.application.usecase.InvoiceUseCase
import io.awspring.cloud.sqs.annotation.SqsListener
import io.awspring.cloud.sqs.listener.acknowledgement.Acknowledgement
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class InvoiceWorkerListener(
    private val invoiceUseCase: InvoiceUseCase
) {

    @SqsListener("\${aws.queue.listener.name}")
    fun invoiceWorker(
        invoiceEvent: InvoiceEvent,
        ack: Acknowledgement
    ) {
        logger.info("Iniciando consumo da fila da fatura.")
        runCatching {
            invoiceUseCase.execute(invoiceEvent.toDomain())
        }.onSuccess {
            ack.acknowledge()
            logger.info("Fluxo de consumo finalizado com sucesso.")
        }.onFailure {
            logger.error("Erro ao processar mensagem: ${it.message}")
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(InvoiceWorkerListener::class.java)
    }
}