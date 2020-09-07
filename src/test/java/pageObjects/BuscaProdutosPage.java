package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseClass.BasePage;

public class BuscaProdutosPage extends BasePage {
	public BuscaProdutosPage(WebDriver _browser) {
		super(_browser);
	}

	private String url 			= "https://www.magazineluiza.com.br/";
	private By inputPesrquisa 	= By.xpath("//*[@id='inpHeaderSearch']");
	private By btnPesquisar 	= By.xpath("//*[@id='btnHeaderSearch']");

	public void abrirPagina() {
		browser.get(url);
	}

	public void verificaSeEstouNaPagina() {
		String paginaAtual = browser.getCurrentUrl();
		Assert.assertEquals(true, url.equals(paginaAtual));
	}

	public void preencheCampoPesquisa(String produto) {
		waitForPageLoad(10);
		waitElementVisible(inputPesrquisa, 10);
		browser.findElement(inputPesrquisa).sendKeys(produto);
	}

	public void clicaNoBotaoPesquisar() {
		waitElementVisible(btnPesquisar, 5);
		browser.findElement(btnPesquisar).click();
	}
}
