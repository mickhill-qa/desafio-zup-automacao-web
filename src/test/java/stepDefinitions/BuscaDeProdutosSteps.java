package stepDefinitions;

import org.junit.Assert;
import baseClass.BaseSteps;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
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
	@Dado("^que o usuario acesse o site do Magazine Luiza$")
	public void que_o_usuario_acesse_o_site_do_Magazine_Luiza() {
		paginaInicial.abrirPagina();
		paginaInicial.verificaSeEstouNaPagina();
		BaseSteps.screenShotNow();
	}

	@Quando("^o usuario buscar por \"([^\"]*)\"$")
	public void o_usuario_buscar_por(String produto) {
		paginaInicial.preencheCampoPesquisa(produto);
		BaseSteps.screenShotNow();
		paginaInicial.clicaNoBotaoPesquisar();
	}

	@Entao("^o sistema mostra resultado maior que Zero$")
	public void o_sistema_mostra_resultado_maior_que_Zero() {
		paginaResultadoBusca.verificaSeEstouNaPagina();
		int quantidadeProdutosListados = paginaResultadoBusca.verQuantidadeResultados();
		Assert.assertTrue(quantidadeProdutosListados > 0);
	}

	@E("^o sistema mostra a lista de produto\\(s\\) encontrado\\(s\\)$")
	public void oSistemaMostraAListaDeProdutoSEncontradoS() {
		boolean existeProduto = paginaResultadoBusca.verSeExisteProdutosListados();
		Assert.assertTrue(existeProduto);
		BaseSteps.screenShotNow();
	}

	
	
	/**
	 * FluxoAlternativo_01_BuscaDeProdutos
	 **/
	@Entao("^o sistema nao mostra resultado de produto\\(s\\) encontrado\\(s\\)$")
	public void oSistemaNaoMostraResultadoDeProdutoSEncontradoS() {
		boolean existeProduto = paginaResultadoBusca.verSeExisteProdutosListados();
		Assert.assertFalse(existeProduto);
		BaseSteps.screenShotNow();
	}

	
	
	/**
	 * FluxoAlternativo_03_BuscaDeProdutos
	 **/
	@Quando("^buscar sem preencher o campo de pesquisa$")
	public void buscarSemPreencherOCampoDePesquisa() {
		paginaInicial.preencheCampoPesquisa("");
		BaseSteps.screenShotNow();
		paginaInicial.clicaNoBotaoPesquisar();
	}

	@Entao("^o sistema continuara na mesma pagina$")
	public void oSistemaContinuaraNaMesmaPagina() {
		paginaInicial.verificaSeEstouNaPagina();
	}

	@E("^o sistema nao fara a busca$")
	public void oSistemaNaoFaraABusca() {
		boolean existeProdutoListado = paginaResultadoBusca.verSeExisteProdutosListados();
		Assert.assertFalse(existeProdutoListado);
		BaseSteps.screenShotNow();
	}
}
