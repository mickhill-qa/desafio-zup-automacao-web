package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import baseClass.BasePage;

public class ResultadoBuscaPage extends BasePage {
	public ResultadoBuscaPage(WebDriver _browser) {
		super(_browser);
	}

	private String uri = "magazineluiza.com.br/busca";
	
	public void verificaSeEstouNaPagina() {
		waitForPageLoad(10);
		String paginaAtual = browser.getCurrentUrl();
		Assert.assertEquals(true, paginaAtual.contains(uri));
	}
}
