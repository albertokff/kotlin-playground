package org.example.recursos_linguagem_e_poo_kotlin

fun String.mascararCpf(): String {
    //if (this.length != 11) return this

    val bloco1 = this.substring(3, 6)
    val bloco2 = this.substring(6, 9)
    val cpfFormatado = "***.${bloco1}.${bloco2}-**"

    return cpfFormatado
}

fun Int.ehPar(): Boolean {
    return this % 2 == 0
}

fun formatadorDocumentosValidador() {
    val cpf = "03177167001"
    val numero = 8

    println("Cpf mascarado: ${cpf.mascararCpf()}")
    println("O número 8 é par? ${numero.ehPar()}")
}