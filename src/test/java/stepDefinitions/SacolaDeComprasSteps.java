package stepDefinitions;

import org.junit.Assert;
import baseClass.BaseSteps;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageObjects.DetalhesDoProdutoPage;
import pageObjects.ResultadoDaBuscaPage;
import pageObjects.SacolaDeComprasPage;

public class SacolaDeComprasSteps extends BaseSteps {

	/**
	 * Paginas necessaria
	 **/
	ResultadoDaBuscaPage paginaResultadoBusca 	= new ResultadoDaBuscaPage(BaseSteps.browser);
	DetalhesDoProdutoPage paginaDoProduto 		= new DetalhesDoProdutoPage(BaseSteps.browser);
	SacolaDeComprasPage paginaSacolaDeCompras	= new SacolaDeComprasPage(BaseSteps.browser);

	
	
	/**
	 * FluxoBase_SacolaDeCompras
	 **/
	@Dado("^que o usuario escolha um produto na lista$")
	public void queOUsuarioEscolhaUmProdutoNaLista() {
		paginaResultadoBusca.selecionaProdutoDesejado();
	}

	@Quando("^o usuario adicionar o produto a Sacola de Compras$")
	public void oUsuarioAdicionarOProdutoASacolaDeCompras() {
		paginaDoProduto.esperarCarregarPagina();
		paginaDoProduto.adicionarProduto();
	}

	@Entao("^o sistema mostra a Sacola de Compras com o produto$")
	public void oSistemaMostraASacolaDeComprasComOProduto() {
		paginaSacolaDeCompras.verificaSeEstouNaPagina();
		
		String produtoNaBusca 	= paginaResultadoBusca.verNomeProdutoSelecionado();
		String produtoNaSacola	= paginaSacolaDeCompras.verNomeProdutoAdicionado();
		Assert.assertTrue(produtoNaBusca.contains(produtoNaSacola));
	}

	
	
	/**
	 * FluxoAlternativo_01_SacolaDeCompras
	 **/
	@Dado("^que o usuario adicione um produto a Sacola de Compras$")
	public void queOUsuarioAdicioneUmProdutoASacolaDeCompras() throws Throwable {
		this.queOUsuarioEscolhaUmProdutoNaLista();
		this.oUsuarioAdicionarOProdutoASacolaDeCompras();
		this.oSistemaMostraASacolaDeComprasComOProduto();
	}
	
	@Quando("^o usuario excluir este produto$")
	public void oUsuarioExcluirEsteProduto() throws Throwable {
		paginaSacolaDeCompras.clicaNoBotaoExcluirProduto();
	}
	
	@Entao("^o sistema mostra a Sacola de Compras sem o produto$")
	public void oSistemaMostraASacolaDeComprasSemOProduto() {
		paginaSacolaDeCompras.verificaSeEstouNaPagina();
		
		String produtoNaSacola	= paginaSacolaDeCompras.verNomeProdutoAdicionado();
		Assert.assertNull(produtoNaSacola);
	}
}
