package org.example.recursos_linguagem_e_poo_kotlin

data class PerfilCliente(
    val id: String,
    val email: String,
    val pontuaçãoFidelidade: Int,
    val vip: Boolean
)

fun atualizadorImutavelPerfil() {
    atualizarEConcederVip()
}

fun atualizarEConcederVip() {
    val clienteInicial = PerfilCliente(id = "CLI-101", email = "email@teste", pontuaçãoFidelidade = 450, vip = false)
    val clienteAtualizado = clienteInicial.copy(pontuaçãoFidelidade = clienteInicial.pontuaçãoFidelidade + 150, vip = true)
    val (_, email, pontuaçãoFidelidade) = clienteAtualizado

    println("O cliente $email agora possui $pontuaçãoFidelidade pontos e é VIP!")
}