package org.example.achatamento_estruturas_flatmap

data class Passageiro(val nome: String, val classe: String)
data class Voo(val codigo: String, val status: String, val passageiros: List<Passageiro>)

fun filtroPassagensAltaPrioridades() {
    /*
        Imagine que você está trabalhando na API de uma companhia aérea. Você recebeu uma lista de objetos Voo.
        Cada Voo possui um status (ex: "ATRASADO" ou "CONFIRMADO") e uma lista interna de passageiros.
        Cada Passageiro possui um nome e o tipo de assento (ex: "EXECUTIVA" ou "ECONOMICA").

        O seu objetivo é gerar uma única lista linear contendo o nome de todos os passageiros da Classe Executiva que estão em voos Atrasados,
        para que a equipe de solo possa oferecer um voucher de sala VIP imediatamente.
     */

    val voosDoDia = listOf(
        Voo("AA123", "ATRASADO", listOf(
            Passageiro("Alice", "EXECUTIVA"),  // 1ª na lista de prioridade
            Passageiro("Bob", "ECONOMICA")     // Voo atrasado, mas é econômica
        )),
        Voo("BB456", "CONFIRMADO", listOf(
            Passageiro("Carlos", "EXECUTIVA")  // É executiva, mas o voo está no horário
        )),
        Voo("CC789", "ATRASADO", listOf(
            Passageiro("Daniela", "ECONOMICA"),
            Passageiro("Eduardo", "EXECUTIVA") // 2º na lista de prioridade
        ))
    )

    val passageirosAtrasadosExecutiva = voosDoDia.asSequence()
        .filter { it.status == "ATRASADO" }
        .flatMap { it.passageiros }
        .filter { it.classe == "EXECUTIVA" }
        .map { it.nome }
        .toList()

    println(passageirosAtrasadosExecutiva)
}