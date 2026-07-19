package org.example.concorrencia_e_corroutines_assincronismo

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun painelInvestidor() = runBlocking {
    /*
        Você está criando a lógica de um painel que consolida os investimentos de um usuário.
        Para montar o relatório, você precisa buscar dados de 3 fontes diferentes:
            - Renda Fixa: Busca os contratos de títulos públicos (Demora 2 segundos).
            - Renda Variável: Busca as ações na bolsa de valores (Demora 2 segundos).
            - Criptoativos: Busca o saldo de moedas digitais (Demora 1 segundo).

        Regras do Negócio:
            - As 3 buscas de dados não dependem uma da outra, portanto devem rodar em paralelo para não deixar o cliente esperando.
            - Assim que os 3 resultados estiverem em mãos, você deve calcular e printar a soma total do patrimônio.
            - Logo após a exibição na tela, você deve disparar um launch ("disparar e esquecer") para simular a geração de um arquivo PDF desse relatório em segundo plano (essa função de PDF demora 3 segundos).
            - Você deve medir e exibir no console apenas o tempo de busca e consolidação dos dados, garantindo que as variáveis estejam disponíveis no escopo do launch.
     */
    val rendaFixa : Deferred<Double>
    val rendaVariavel : Deferred<Double>
    val cripto : Deferred<Double>
    val soma : Double

    val tempo = measureTimeMillis {
        rendaFixa = async { buscarRendaFixa() }
        rendaVariavel = async { buscarRendaVariavel() }
        cripto = async { buscarCripto() }

        soma = rendaFixa.await() + rendaVariavel.await() + cripto.await()
    }

    println("Soma $soma")

    println("Tempo ${tempo / 1000} segundos.")

    launch {
        gerarPdfRelatorio(soma)
    }
}

suspend fun buscarRendaFixa(): Double {
    delay(2000)
    return 50000.0
}

suspend fun buscarRendaVariavel(): Double {
    delay(2000)
    return 35000.0
}

suspend fun buscarCripto(): Double {
    delay(1000)
    return 15000.0
}

suspend fun gerarPdfRelatorio(total: Double) {
    delay(3000)
    println("PDF do relatório de R$ $total gerado com sucesso!")
}