package org.example

import org.example.achatamento_estruturas_flatmap.agrupamentoMetricasServidores
import org.example.achatamento_estruturas_flatmap.consolidacaoAlertasSeguranca
import org.example.achatamento_estruturas_flatmap.consolidacaoItensPedidos
import org.example.achatamento_estruturas_flatmap.filtroPassagensAltaPrioridades
import org.example.achatamento_estruturas_flatmap.vendasLoja
import org.example.concorrencia_e_corroutines_assincronismo.agregadorPerfilCliente
import org.example.concorrencia_e_corroutines_assincronismo.painelInvestidor
import org.example.concorrencia_e_corroutines_assincronismo.processarFechamentoVenda
import org.example.concorrencia_e_corroutines_assincronismo.sistemaPagamentos
import org.example.estruturas_dados_puras_sets_maps.aquecimento
import org.example.estruturas_dados_puras_sets_maps.categoriasVip
import org.example.estruturas_dados_puras_sets_maps.dicionarioFrequenciaPalavras
import org.example.estruturas_dados_puras_sets_maps.permissoesUsuarios
import org.example.manipulando_colecoes_kotlin.filtroEstoqueAltaPrioridade
import org.example.manipulando_colecoes_kotlin.filtroLogAcesso
import org.example.manipulando_colecoes_kotlin.processamentoPerfilUsuarioEcommerce
import org.example.manipulando_colecoes_kotlin.processamentoTransacaoSuspeita


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /* Manipulando Coleções Kotlin */
        //filtroLogAcesso()
        //processamentoTransacaoSuspeita()
        //processamentoPerfilUsuarioEcommerce()
        //filtroEstoqueAltaPrioridade()

    /* Achatamento de Estruturas com FlatMap */
        //consolidacaoItensPedidos()
        //filtroPassagensAltaPrioridades()
        //consolidacaoAlertasSeguranca()
        //agrupamentoMetricasServidores()
        //vendasLoja()

    /* Concorrência e Corroutines - Assincronismo */
        //agregadorPerfilCliente()
        //painelInvestidor()
        //processarFechamentoVenda() //Esse aqui não vai funcionar porque precisa da UI
        //sistemaPagamentos()

    /* Estruturas de Dados Puras - Sets e Maps */
        //aquecimento()
        //dicionarioFrequenciaPalavras()
        //permissoesUsuarios()
        categoriasVip()
}