package org.example.estruturas_dados_puras_sets_maps

fun carrosVip() {
    val carrosPermitidos = setOf("HYUNDAI", "AUDI", "BMW")

    val paises = mapOf(
        "JAPAO" to listOf("VOLKSWAGEN", "CHEVROLET", "MERCEDES"),
        "EUA" to listOf("NISSAN", "MCLAREN"),
        "ITALIA" to listOf("FIAT", "HYUNDAI", "AUDI"),
        "FRANCA" to listOf("CITROEN", "BMW"),
        "ALEMANHA" to listOf("HYUNDAI", "BMW")
    )

    val carrosAceitos = paises.filter { (pais, marca) ->
        val marcaSet = marca.toSet()
        marcaSet.intersect(carrosPermitidos).size == 2
    }.keys

    println(carrosAceitos)
}