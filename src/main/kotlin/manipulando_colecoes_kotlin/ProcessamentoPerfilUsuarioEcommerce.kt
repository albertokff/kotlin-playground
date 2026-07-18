package org.example.manipulando_colecoes_kotlin

fun processamentoPerfilUsuarioEcommerce() {
    /*
    Imagine que você está otimizando o sistema de recomendações de um e-commerce. Você recebe uma lista massiva de strings contendo dados brutos de usuários no formato: "NOME;IDADE;CIDADE".

    No entanto, a base de dados tem problemas:
    - Algumas idades estão em branco ou inválidas (o que pode gerar erros ao converter).
    - Algumas pessoas moram em cidades que não possuem cobertura de entrega.

    O seu objetivo é criar um pipeline que:
    - Filtre e ignore qualquer linha que não tenha a idade preenchida corretamente (valores inválidos/nulos).
    - Transforme (mapear) a string para extrair apenas o Nome e a Idade (como número inteiro).
    - Filtre novamente para manter apenas usuários que sejam maiores de idade (Idade $\ge 18$).
    - Encontre o primeiro usuário que se encaixe nesse critério e pare a execução na hora.
    */

    val usuariosBrutos = listOf(
        "Ana;25;São Paulo",
        "Carlos;;Rio de Janeiro",       // Idade em branco!
        "Bruno;17;Belo Horizonte",      // Menor de idade
        "Daniel;32;Curitiba",           // 1º Válido (Maior de idade)
        "Elena;40;Salvador",            // Também seria válido, mas o programa deve parar antes!
        "Fernando;abc;Recife"           // Idade inválida!
    )

    val somenteLinhasComIdade = usuariosBrutos.asSequence()
        .map {
            it.split(";")
        }.filter { partes -> partes[1].toIntOrNull() != null
        }.filter { partes -> partes[1].toInt() > 18
        }.map { partes -> "${partes[0]}, ${partes[1]}" }
        .take(1)
        .toList()

    println(somenteLinhasComIdade)
}