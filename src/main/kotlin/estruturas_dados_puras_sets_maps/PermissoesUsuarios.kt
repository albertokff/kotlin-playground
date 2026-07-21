package org.example.estruturas_dados_puras_sets_maps

fun permissoesUsuarios() {
    val permissoesCriticas = setOf("READ", "WRITE", "DELETE")

    val permissoesUsuarios = mapOf(
        "USR-1" to setOf("READ", "WRITE"),
        "USR-2" to setOf("READ", "WRITE", "DELETE", "EXECUTE"),
        "USR-3" to setOf("READ"),
        "USR-4" to setOf("DELETE", "WRITE", "READ")
    )

    val administradoresCompletos = permissoesUsuarios.filter { (idUsuario, permissoes) ->
        permissoes.containsAll(permissoesCriticas)
    }

    println("Usuários com acesso completo: ${administradoresCompletos.keys}")
}