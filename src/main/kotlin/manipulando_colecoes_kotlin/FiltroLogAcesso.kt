package org.example.manipulando_colecoes_kotlin

fun filtroLogAcesso() {
    /*
    Imagine que a sua aplicação gera um arquivo de texto gigante com milhões de linhas de log. Cada linha representa um acesso e está formatada como uma string simples: "NÍVEL:Mensagem de erro".
    Você recebeu uma lista enorme de logs e precisa:
        - Filtrar apenas os logs que sejam do nível "ERRO".
        - Transformar (mapear) esses logs para extrair apenas a mensagem (ou seja, remover o prefixo "ERRO:").
        - Obter apenas as 3 primeiras mensagens de erro para exibir em um painel rápido.
     */

    val logs = listOf(
        "INFO:Usuário fez login",
        "ERRO:Conexão com o banco falhou",
        "INFO:Página carregada em 150ms",
        "ERRO:Token de autenticação expirado",
        "INFO:Upload de imagem concluído",
        "ERRO:Falha ao salvar arquivo",
        "INFO:Logout realizado",
        "ERRO:Limite de requisições excedido",
        "INFO:Sessão encerrada"
    )

    val logsErro = logs.asSequence()
                       .filter { it.startsWith("ERRO:") }
                       .map { it.substring(5) }
                       .take(3).toList()
    println("os logs de erro são: $logsErro")
}