package org.example.achatamento_estruturas_flatmap

fun agrupamentoMetricasServidores() {
        /*
            Imagine que você gerencia a infraestrutura em nuvem de um banco. O seu sistema de monitoramento coleta um fluxo contínuo de métricas textuais
            de uso de hardware no formato: "NOME_DO_SERVIDORE,TIPO_DE_METRICA,VALOR".

            Você recebeu uma lista dessas métricas e o seu objetivo é:
                - Filtrar e ignorar qualquer linha que pertença ao servidor "Servidor-Teste" (não queremos métricas de homologação/teste misturadas).
                - Transformar (mapear) a string quebrando os elementos com split(",").
                - Agrupar os dados pelo Nome do Servidor.
                - Transformar o resultado para que cada servidor tenha apenas a lista dos valores numéricos (Double) das suas métricas, ignorando o resto do texto.
         */

    val metricasBrutas = listOf(
        "Servidor-Prod-1,CPU,85.5",
        "Servidor-Prod-2,MEMORIA,42.0",
        "Servidor-Teste,CPU,12.0",      // Ignorar! É servidor de teste
        "Servidor-Prod-1,MEMORIA,60.2",
        "Servidor-Prod-2,CPU,90.1"
    )

    val metricasProducao = metricasBrutas.asSequence()
        .filter { !it.startsWith("Servidor-Teste") }
        .map { it.split(",") }
        .groupBy(
            keySelector = { it[0] },
            valueTransform = { it[2].toDouble() },
        )
        .toList()

    println(metricasProducao)
}