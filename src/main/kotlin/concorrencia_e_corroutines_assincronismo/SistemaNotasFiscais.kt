package org.example.concorrencia_e_corroutines_assincronismo

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun processarFechamentoVenda() = runBlocking {
    val tempo = measureTimeMillis {
        rodando()
    }
    println("Fechamento concluído em ${tempo / 1000.0} segundos.")
}

suspend fun rodando() {
    // 1. Envolva esta chamada no Dispatcher correto para operações de Banco/Rede!
    val dadosBrutos = withContext(Dispatchers.IO ) {
        delay(1000)
        "DADOS_BRUTOS_Venda_10293"
    }

    // 2. Envolva esta chamada no Dispatcher correto para Processamento/Cálculo Pesado de CPU!
    val vendaProcessada = withContext(Dispatchers.Default ) {
        delay(1000)
        "$dadosBrutos -> IMPOSTOS_CALCULADOS"
    }

    // 3. Envolva esta chamada no Dispatcher focado em exibição/Main!
    withContext(Dispatchers.Main ) {
        println("SUCESSO: $vendaProcessada")
    }
}