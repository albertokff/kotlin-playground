package org.example.estruturas_dados_puras_sets_maps

fun aquecimento() {
    val usuariosLogadosWeb = listOf("USR-101", "USR-102", "USR-103", "USR-104", "USR-101", "USR-105").toSet()
    val usuariosLogadosApp = listOf("USR-103", "USR-105", "USR-106", "USR-107", "USR-103").toSet()

    val intersecao = usuariosLogadosApp.intersect(usuariosLogadosWeb)
    println("Intersecção dos acessos: $intersecao")

    val acessosWeb = usuariosLogadosWeb.subtract(usuariosLogadosApp)
    println("Acesso Web: $acessosWeb")

    val ambosAcessos = usuariosLogadosWeb.union(usuariosLogadosApp)
    println("Quantidade de acessos em ambas plataformas: ${ambosAcessos.size}")
}