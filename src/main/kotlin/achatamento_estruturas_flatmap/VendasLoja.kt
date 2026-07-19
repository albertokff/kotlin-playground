package org.example.achatamento_estruturas_flatmap

fun vendasLoja() {
    /*
        Para treinar o uso do groupBy, imagine o seguinte cenário: você tem uma lista de vendas de uma loja no formato "CATEGORIA,NOME_PRODUTO,PRECO".

        Você precisa:
            - Usar a Sequence.
            - Filtrar para ignorar qualquer produto que custe menos que 10.0 (produtos muito baratos).
            - Agrupar os produtos por Categoria.
            - O resultado do grupo deve conter apenas os Nomes dos Produtos (Strings), ignorando o preço.

        O resultado esperado deve ser um Map com as categorias e as listas de nomes limpas:
        {Eletrônicos=[Mouse Gamer], Vestuário=[Camiseta Algodão, Meias Confort], Livros=[Kotlin em Ação]}
     */

    val vendasBrutas = listOf(
        "Eletrônicos,Mouse Gamer,150.0",
        "Vestuário,Camiseta Algodão,40.0",
        "Eletrônicos,Pilhas AA,8.5",       // Ignorar! Preço menor que 10.0
        "Vestuário,Meias Confort,12.0",
        "Livros,Kotlin em Ação,95.0"
    )

    val nomeCategoriaLimpa = vendasBrutas.asSequence()
        .map { it.split(",") }
        .filter { it[2].toDouble() > 10 }
        .groupBy(
            keySelector = { it[0] },
            valueTransform = { it[1] }
        )

    println(nomeCategoriaLimpa)
}