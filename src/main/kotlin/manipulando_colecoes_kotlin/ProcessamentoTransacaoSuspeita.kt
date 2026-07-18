package org.example.manipulando_colecoes_kotlin

fun processamentoTransacaoSuspeita() {
    /*
        Imagine que você está construindo um sistema de detecção de fraudes para um banco.
        Você tem uma lista de transações financeiras representadas por strings.
        Cada string segue o formato "ID_CLIENTE,VALOR,STATUS".

        Você precisa analisar uma lista enorme dessas transações e realizar o seguinte pipeline:
            - Filtrar apenas as transações com o status "PENDENTE".
            - Transformar (mapear) cada transação válida para obter apenas o VALOR (como um número decimal Double).
            - Filtrar novamente para manter apenas os valores considerados "altos" (maiores que $500.0$).
            - Obter apenas as 2 primeiras transações suspeitas encontradas.
     */

    val listaTransacoes = listOf(
        "REAL1, 410, PENDENTE",
        "REAL2, 222, RECUSADO",
        "REAL3, 105, PENDENTE",
        "REAL4, 980, APROVADO",
        "REAL5, 745, PENDENTE",
        "REAL6, 520, APROVADO",
        "REAL7, 850, PENDENTE",
        "REAL8, 999, APROVADO",
        "REAL9, 555, RECUSADO",
        "REAL10, 600, PENDENTE"
    )

    val transacoesPendentes = listaTransacoes.asSequence()
                                             .filter{ it.endsWith("PENDENTE") }
                                             .map { it.split(',')[1].toDouble() }
                                             .filter { it > 500 }
                                             .take(2).toList()

    println(transacoesPendentes)
}