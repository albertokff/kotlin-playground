package org.example.recursos_linguagem_e_poo_kotlin

sealed class EstadoPagamento {
    object Pendente : EstadoPagamento()
    data class Aprovado(val idTransacao: String, val valor: Double) : EstadoPagamento()
    data class Recusado(val motivo: String) : EstadoPagamento()
}

fun exibirResultadoPagamento(estado: EstadoPagamento) {
    when (estado) {
        is EstadoPagamento.Pendente -> {
            println("Aguarde, processando pagamento...")
        }
        is EstadoPagamento.Aprovado -> {
            println("Pagamento de R$ ${estado.valor} APROVADO! ID: ${estado.idTransacao}")
        }
        is EstadoPagamento.Recusado -> {
            println("Pagamento RECUSADO. Motivo: ${estado.motivo}")
        }
    }
}