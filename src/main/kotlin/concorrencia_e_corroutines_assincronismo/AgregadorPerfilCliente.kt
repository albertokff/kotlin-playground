package org.example.concorrencia_e_corroutines_assincronismo

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun agregadorPerfilCliente() = runBlocking {
    val nome: String
    val pontos: Int

    val tempo = measureTimeMillis {
        val defferedNome = async { buscarNomeCliente() }
        val defferedPontos = async { buscarPontosFidelidade() }

        nome = defferedNome.await()
        pontos = defferedPontos.await()
        println("Cliente $nome possui $pontos pontos.")
    }
    println ("O código rodou em ${tempo / 1000} segundos.")

    launch {
        enviarAnalyticsLog("Painel do $nome carregado, com $pontos pontos!")
    }
}

suspend fun buscarNomeCliente(): String {
    delay(1000)
    return "Rodrigo Silva"
}

suspend fun buscarPontosFidelidade(): Int {
    delay(1000)
    return 450
}

suspend fun enviarAnalyticsLog(mensagem: String) {
    delay(1500) // Demora um pouco, mas roda em segundo plano!
    println("LOG ENVIADO: $mensagem")
}