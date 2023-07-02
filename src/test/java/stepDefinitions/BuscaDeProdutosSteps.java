package stepDefinitions;

import org.junit.Assert;
import baseClass.BaseSteps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.BuscaProdutosPage;
import pageObjects.ResultadoDaBuscaPage;

public class BuscaDeProdutosSteps extends BaseSteps {

	/**
	 * Paginas necessaria
	 **/
	BuscaProdutosPage paginaInicial 			= new BuscaProdutosPage(BaseSteps.browser);
	ResultadoDaBuscaPage paginaResultadoBusca 	= new ResultadoDaBuscaPage(BaseSteps.browser);

	
	
	/**
	 * FluxoBase_BuscaDeProdutos
	 * FluxoAlternativo_02_BuscaDeProdutos
	 **/
	@Dado("^que o usuario acessa o site do Magazine Luiza$")
	public void o_usuario_acessa_o_site_do_Magazine_Luiza() {
		paginaInicial.abrirPagina();
		Assert.assertTrue(paginaInicial.verificaSeEstouNaPagina());
		screenshot();
	}

	@Quando("^o usuario busca por \"([^\"]*)\"$")
	public void o_usuario_busca_por(String produto) {
		paginaInicial.preencheCampoPesquisa(produto);
		screenshot();
		paginaInicial.clicaNoBotaoPesquisar();
	}

	@Entao("^o sistema mostra resultado maior que Zero$")
	public void o_sistema_mostra_resultado_maior_que_Zero() {
		Assert.assertTrue(paginaResultadoBusca.verificaSeEstouNaPagina());
		int quantidadeProdutosListados = paginaResultadoBusca.verQuantidadeResultados();
		Assert.assertTrue(quantidadeProdutosListados > 0);
	}

	@E("^o sistema mostra a lista de produto\\(s\\) encontrado\\(s\\)$")
	public void o_sistema_mostra_a_lista_de_produto_s_encontrado_s() {
		boolean existeProduto = paginaResultadoBusca.verSeExisteProdutosListados();
		Assert.assertTrue(existeProduto);
		screenshot();
	}

	
	
	/**
	 * FluxoAlternativo_01_BuscaDeProdutos
	 **/
	@Entao("^o sistema nao mostra resultado de produto\\(s\\) encontrado\\(s\\)$")
	public void o_sistema_nao_mostra_resultado_de_produto_s_encontrado_s() {
		boolean existeProduto = paginaResultadoBusca.verSeExisteProdutosListados();
		Assert.assertFalse(existeProduto);
		screenshot();
	}

	
	
	/**
	 * FluxoAlternativo_03_BuscaDeProdutos
	 **/
	@Quando("^o usuario busca sem preencher o campo de pesquisa$")
	public void o_usuario_busca_sem_preencher_o_campo_de_pesquisa() {
		paginaInicial.preencheCampoPesquisa("");
		screenshot();
		paginaInicial.clicaNoBotaoPesquisar();
	}

	@Entao("^o sistema continuara na mesma pagina$")
	public void o_sistema_continuara_na_mesma_pagina() {
		Assert.assertTrue(paginaInicial.verificaSeEstouNaPagina());
	}

	@E("^o sistema nao fara a busca$")
	public void o_sistema_nao_fara_a_busca() {
		boolean existeProdutoListado = paginaResultadoBusca.verSeExisteProdutosListados();
		Assert.assertFalse(existeProdutoListado);
		screenshot();
	}
}
