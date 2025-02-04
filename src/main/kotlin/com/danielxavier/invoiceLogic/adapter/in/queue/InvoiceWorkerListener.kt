package com.danielxavier.invoiceLogic.adapter.`in`.queue

import com.danielxavier.invoiceLogic.adapter.`in`.queue.event.InvoiceEvent
import com.danielxavier.invoiceLogic.application.ports.`in`.InvoiceUseCasePort
import io.awspring.cloud.sqs.annotation.SqsListener
import io.awspring.cloud.sqs.listener.acknowledgement.Acknowledgement
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class InvoiceWorkerListener(
    private val invoiceUseCasePort: InvoiceUseCasePort
) {

    @SqsListener("\${aws.queue.listener.name}")
    fun invoiceWorker(
        invoiceEvent: InvoiceEvent,
        ack: Acknowledgement
    ) {
        logger.info("Iniciando consumo da fila da fatura.")
        runCatching {
            invoiceUseCasePort.execute(invoiceEvent)
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