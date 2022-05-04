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
	private By inputPesrquisa 	= By.cssSelector("[data-testid=input-search]");
	private By btnPesquisar 	= By.cssSelector("[data-testid=search-submit]");

	public void abrirPagina() {
		browser.get(url);
	}

	public boolean verificaSeEstouNaPagina() {
		String paginaAtual = browser.getCurrentUrl();
		return url.equals(paginaAtual);
	}

	public void preencheCampoPesquisa(String produto) {
		waitForPageLoad(20);
		waitElementVisible(inputPesrquisa, 10);
		waitElementClickable(inputPesrquisa, 5);
		browser.findElement(inputPesrquisa).sendKeys(produto);
	}

	public void clicaNoBotaoPesquisar() {
		waitElementClickable(btnPesquisar, 5);
		browser.findElement(btnPesquisar).click();
	}
}
