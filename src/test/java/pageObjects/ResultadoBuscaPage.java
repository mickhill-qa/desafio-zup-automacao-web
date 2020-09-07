package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import baseClass.BasePage;

public class ResultadoBuscaPage extends BasePage {
	public ResultadoBuscaPage(WebDriver _browser) {
		super(_browser);
	}

	private String uri 		= "magazineluiza.com.br/busca";
	private By txtComResultado = By.xpath("//h1[@itemprop='description']/small");
	private By intenList_01 = By.cssSelector("ul > li:nth-child(1) > a.product-li");
	
	public void verificaSeEstouNaPagina() {
		waitForPageLoad(10);
		String paginaAtual = browser.getCurrentUrl();
		Assert.assertEquals(true, paginaAtual.contains(uri));
	}
	
	public int verQuantidadeResultados() {
		waitElementVisible(txtComResultado, 10);
		String texto = browser.findElement(txtComResultado).getText();
		texto = texto.substring(1);
		texto = (texto.split(" produto"))[0];
		texto = texto.trim();
		return Integer.parseInt(texto);
	}

	public Boolean verSeExisteProdutosListados() {
		try {
			browser.findElement(intenList_01);
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
}
