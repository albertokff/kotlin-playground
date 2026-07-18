package org.example.achatamento_estruturas_flatmap

data class Servidor(
    val nome: String,
    val status: String,
    val vulnerabilidades: List<String>? // Atenção: Pode ser nulo se o servidor não reportou nada!
)

fun consolidacaoAlertasSeguranca() {
    /*
        Imagine que você está construindo um painel de monitoramento de infraestrutura em nuvem.
        Você recebe uma lista de objetos Servidor. Cada servidor possui um nome, um status de conexão (ex: "ATIVO", "MANUTENCAO")
        e uma lista de strings opcional (pode ser nula - List<String>?) que contém os logs de vulnerabilidades encontrados.

        Além disso, as strings de log de vulnerabilidades estão mal formatadas e contêm espaços extras nas pontas, e algumas
        podem estar completamente vazias.

        O seu objetivo é gerar uma única lista linear e limpa (sem espaços) de todas as vulnerabilidades que contêm a palavra-chave
        "CRITICA", mas apenas dos servidores que estão "ATIVO".
     */

    val servidores = listOf(
        Servidor("Servidor-Web", "ATIVO", listOf("  Alerta: Vulnerabilidade CRITICA de Injeção  ", "Aviso de porta aberta")),
        Servidor("Servidor-Banco", "MANUTENCAO", listOf("Falha CRITICA de Acesso")), // Está em manutenção!
        Servidor("Servidor-Cache", "ATIVO", null), // Nulo! Sem vulnerabilidades reportadas
        Servidor("Servidor-Auth", "ATIVO", listOf("   Aviso de expiração de certificado  ", "  Ameaça CRITICA: Vazamento de memória "))
    )

    val servidoresAtivosCritica = servidores.asSequence()
        .filter { it.status == "ATIVO" && !it.vulnerabilidades.isNullOrEmpty() }
        .mapNotNull { it.vulnerabilidades }
        .flatMap { it }
        .map { it.trim() }
        .filter { it.contains("CRITICA") }
        .toList()

    println(servidoresAtivosCritica)
}