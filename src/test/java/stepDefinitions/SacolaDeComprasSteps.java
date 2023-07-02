package stepDefinitions;

import org.junit.Assert;
import baseClass.BaseSteps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
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
	@Dado("^que o usuario escolhe um produto na lista$")
	public void o_usuario_escolhe_um_produto_na_lista() {
		screenshot();
		paginaResultadoBusca.selecionaProdutoDesejado();
	}

	@Quando("^o usuario adiciona o produto na Sacola de Compras$")
	public void o_usuario_adiciona_o_produto_na_Sacola_de_Compras() {
		paginaDoProduto.esperarCarregarPagina();
		screenshot();
		paginaDoProduto.adicionarProduto();
	}

	@Entao("^o sistema mostra a Sacola de Compras com o produto adicionado$")
	public void o_sistema_mostra_a_Sacola_de_Compras_com_o_produto_adicionado() throws Throwable {
		Assert.assertTrue(paginaSacolaDeCompras.verificaSeEstouNaPagina());
		String produtoNaBusca 	= paginaResultadoBusca.verNomeProdutoSelecionado();
		String produtoNaSacola	= paginaSacolaDeCompras.verNomeProdutoAdicionado();
		Assert.assertTrue(produtoNaSacola.contains(produtoNaBusca));
		screenshot();
	}

	
	
	/**
	 * FluxoAlternativo_01_SacolaDeCompras
	 **/
	@Dado("^que o usuario adiciona um produto na Sacola de Compras$")
	public void o_usuario_adiciona_um_produto_na_Sacola_de_Compras() throws Throwable {
		this.o_usuario_escolhe_um_produto_na_lista();
		this.o_usuario_adiciona_o_produto_na_Sacola_de_Compras();
		this.o_sistema_mostra_a_Sacola_de_Compras_com_o_produto_adicionado();
	}
	
	@Quando("^o usuario exclui o produto da Sacola de Compras$")
	public void o_usuario_exclui_o_produto_da_Sacola_de_Compras() {
		paginaSacolaDeCompras.clicaNoBotaoExcluirProduto();
	}
	
	@Entao("^o sistema mostra a Sacola de Compras sem o produto adicionado$")
	public void o_sistema_mostra_a_Sacola_de_Compras_sem_o_produto_adicionado() throws Throwable {
		Assert.assertTrue(paginaSacolaDeCompras.verificaSeEstouNaPagina());
		String produtoNaSacola	= paginaSacolaDeCompras.verNomeProdutoAdicionado();
		Assert.assertNull(produtoNaSacola);
		screenshot();
	}
}
