package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import baseClass.BasePage;

public class SacolaDeComprasPage extends BasePage {
	public SacolaDeComprasPage(WebDriver _browser) {
		super(_browser);
	}

	private String url 						= "sacola.magazineluiza.com.br";
	private By txtTituloDaPagina 			= By.cssSelector("#root > div > div.App.clearfix > div > div.BasketPage-title");
	private By txtNomeProdutoAdicionado 	= By.cssSelector("#root > div > div.App.clearfix > div > div:nth-child(2) > div > div.BasketTable > div.BasketTable-items > div:nth-child(1) > div > div.BasketItemProduct > div > a > p:nth-child(1)");
	private By btnExcluirProdutoAdicionado 	= By.cssSelector("#root > div > div.App.clearfix > div > div:nth-child(2) > div > div.BasketTable > div.BasketTable-items > div:nth-child(1) > div > div.BasketItemProduct-quantity > button > span");

	public void verificaSeEstouNaPagina() throws InterruptedException {
		Thread.sleep(2500); 
		waitForPageLoad(20);
		waitElementVisible(txtTituloDaPagina, 10);
		String paginaAtual = browser.getCurrentUrl();
		Assert.assertEquals(true, paginaAtual.contains(url));
	}
	
	public String verNomeProdutoAdicionado() {
		try {
			WebDriverWait wait = new WebDriverWait(browser, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(txtNomeProdutoAdicionado));
			
			WebElement element 	= browser.findElement(txtNomeProdutoAdicionado);
			String result 		= element.getText().trim();
			String ultimsLetra 	= ( result.substring( result.length() - 1, result.length()) ).trim();
			if(ultimsLetra.equals("-"))
				result = (result.substring(0, result.length() - 1)).trim(); 
			return result;
		} 
		catch (WebDriverException e) {
			return null;
		}
	}

	public void clicaNoBotaoExcluirProduto() {
		waitElementClickable(btnExcluirProdutoAdicionado, 5);
		browser.findElement(btnExcluirProdutoAdicionado).click();
	}
}
