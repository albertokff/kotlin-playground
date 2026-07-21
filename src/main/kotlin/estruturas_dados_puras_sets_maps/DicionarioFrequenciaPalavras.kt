package org.example.estruturas_dados_puras_sets_maps

fun dicionarioFrequenciaPalavras() {
    /*
        Uma das perguntas de código mais famosas em entrevistas técnicas (LeetCode / Exercism / Testes de Empresas)
        é criar um Contador de Frequência.

        Imagine que você está construindo o motor de busca de um site de notícias. Você recebe uma lista de tags/palavras-chave
        que os usuários pesquisaram hoje e precisa saber quantas vezes cada palavra foi buscada.
     */

    val buscasDoDia = listOf(
        "kotlin", "java", "kotlin", "python",
        "android", "kotlin", "java", "spring"
    )

    /*
    // ESSA É A ABORDAGEM BÁSICA
    val frequencia = mutableMapOf<String, Int>()

    for (busca in buscasDoDia) {
        frequencia[busca] = frequencia.getOrDefault(busca, 0) + 1
    }
     */

    // ABORDAGEM SÊNIOR
    val frequencia = buscasDoDia.groupingBy { it }.eachCount()


    println(frequencia)
}