package org.example.manipulando_colecoes_kotlin

fun filtroEstoqueAltaPrioridade() {

    /*
    Imagine que você gerencia o sistema de logística de um grande e-commerce.
    Você recebe uma sequência massiva de dados textuais com as informações dos produtos no formato: "NOME_PRODUTO,QUANTIDADE,PRECO,CATEGORIA".

    Alguns registros estão inconsistentes (com preços inválidos ou quantidades zeradas), e você precisa gerar um alerta rápido de reposição. O seu pipeline deve:
    - Transformar (mapear) a string quebrando os elementos com split(",").
    - Filtrar e remover produtos que tenham dados corrompidos (onde o preço ou a quantidade não sejam números válidos).
    - Filtrar novamente para manter apenas os produtos da categoria "Eletrônicos" e que estejam com a quantidade menor que 5 (necessitam de reposição urgente).
    - Transformar (mapear) o resultado para uma string formatada contendo apenas o nome do produto e o valor total necessário para repor 10 unidades deles ($\text{Preço} \times 10$).
    - Obter apenas os 2 primeiros produtos críticos para exibir no painel principal.
     */

    val inventarioBruto = listOf(
        "Mouse Gamer,3,150.0,Eletrônicos",     // 1º Crítico (Eletrônico, Qtd < 5)
        "Camiseta Algodão,2,40.0,Vestuário",   // Qtd < 5, mas é Vestuário
        "Teclado Mecânico,,250.0,Eletrônicos", // Quantidade inválida!
        "Monitor 4K,1,2500.0,Eletrônicos",     // 2º Crítico (Eletrônico, Qtd < 5)
        "Fone Bluetooth,10,300.0,Eletrônicos", // É eletrônico, mas estoque está alto (10)
        "Notebook Pro,2,abc,Eletrônicos"       // Preço inválido!
    )

    val inventarioCritico = inventarioBruto.asSequence()
        .map {it.split(",") }
        .filter { item -> (item[1].toIntOrNull() != null) && item[2].toDoubleOrNull() != null  }
        .filter { item -> item[3].endsWith("Eletrônicos") && item[1].toInt() < 5 }
        .map { "${it[0]} - Total Reposição: ${it[2].toDouble() * 10}" }
        .take(2).toList()

    println(inventarioCritico)
}