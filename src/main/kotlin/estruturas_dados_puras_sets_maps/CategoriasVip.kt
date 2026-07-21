package org.example.estruturas_dados_puras_sets_maps

fun categoriasVip() {
    val categoriasVip = setOf("Eletrônicos", "Gamers", "Livros")

    val interessesClientes = mapOf(
        "Cliente_Ana" to listOf("Eletrônicos", "Moda", "Beleza"),
        "Cliente_Bruno" to listOf("Moda", "Esportes"),
        "Cliente_Carla" to listOf("Gamers", "Livros", "Eletrônicos"),
        "Cliente_Daniel" to listOf("Livros", "Decoração")
    )

    val emComum = interessesClientes.filter { (cliente, interesses) ->
        val interesseCliente = interesses.toSet()
        interesseCliente.intersect(categoriasVip).size >= 2
    }.keys

    println(emComum)
}