package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseClass.BasePage;

public class SacolaDeComprasPage extends BasePage {
	public SacolaDeComprasPage(WebDriver _browser) {
		super(_browser);
	}

	private String url 			= "sacola.magazineluiza.com.br";
	private By txtTituloDaPagina = By.cssSelector("#root > div > div.App.clearfix > div > div.BasketPage-title");
	private By txtNomeProdutoAdicionado = By.cssSelector("#root > div > div.App.clearfix > div > div:nth-child(2) > div > div.BasketTable > div.BasketTable-items > div:nth-child(1) > div > div.BasketItemProduct > div > a > p:nth-child(1)");
	private By btnExcluirProdutoAdicionado = By.id("");


	public void verificaSeEstouNaPagina() {
		waitForPageLoad(10);
		waitElementVisible(txtTituloDaPagina, 10);
		String paginaAtual = browser.getCurrentUrl();
		Assert.assertEquals(true, paginaAtual.contains(url));
	}
	
	public String verNomeProdutoAdicionado() {
		waitElementVisible(txtNomeProdutoAdicionado, 5);
		String result 		= browser.findElement(txtNomeProdutoAdicionado).getText().trim();
		String ultimsLetra 	= ( result.substring( result.length() - 1, result.length()) ).trim();
		if(ultimsLetra.equals("-"))
			result = (result.substring(0, result.length() - 1)).trim(); 

		return result;
	}
}
