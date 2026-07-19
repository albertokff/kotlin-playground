package org.example.concorrencia_e_corroutines_assincronismo

import kotlinx.coroutines.*

fun sistemaPagamentos() = runBlocking {
    finalizarCompra()
}

fun finalizarCompra() = runBlocking {
    // 🟢 Envelopamos as tarefas com o supervisorScope para isolar as falhas!
    supervisorScope {

        // 1. TAREFA ASYNC
        val pagamentoDeferred = async {
            delay(500)
            throw Exception("Cartão de Crédito Recusado!")
            "ID_TRANSACAO_12345"
        }

        // 2. TAREFA LAUNCH (Seu try/catch perfeito aqui dentro)
        launch {
            try {
                delay(300)
                throw Exception("Falha de conexão com o servidor de Auditoria!")
            } catch (e: Exception) {
                println("Erro encontrado no Launch: ${e.message}")
            }
        }

        // 3. SEU TRATAMENTO DO ASYNC (Seu try/catch perfeito envolvendo o await)
        try {
            pagamentoDeferred.await()
        } catch (e: Exception) {
            println("Erro encontrado no Async: ${e.message}")
        }
    }

    println("Fim do processo de checkout seguro!")
}