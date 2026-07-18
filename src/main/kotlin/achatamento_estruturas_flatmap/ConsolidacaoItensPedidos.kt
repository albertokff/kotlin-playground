package org.example.achatamento_estruturas_flatmap

data class Pedido(val idPedido: Int, val itens: List<String>)

fun consolidacaoItensPedidos() {

    /*
      Imagine que você está desenvolvendo uma API para o painel de logística de um e-commerce.
      Você recebeu uma lista de pedidos feitos por clientes. Cada Pedido possui um identificador
      e uma lista interna de strings representando os itens comprados.

      O seu objetivo é gerar uma única lista linear e sem duplicatas contendo todos os produtos exclusivos
      que precisam ser separados no estoque hoje, independentemente de qual pedido eles pertencem.
    */

    val pedidosDoDia = listOf(
        Pedido(101, listOf("Mouse de Computador", "Teclado Mecânico", "Monitor 4K")),
        Pedido(102, listOf("Fone Bluetooth", "Mouse de Computador")), // "Mouse" está repetido!
        Pedido(103, listOf("Monitor 4K", "Cabo HDMI", "Carregador Tipo-C")) // "Monitor" está repetido!
    )

    val itens = pedidosDoDia.asSequence()
        .flatMap { it.itens }
        .distinct()
        .toList()

    println(itens)
}