package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClass.BasePage;

public class DetalhesDoProdutoPage extends BasePage {
	public DetalhesDoProdutoPage(WebDriver _browser) {
		super(_browser);
	}
	
	private By btnAdicionarASacola 	= By.cssSelector("body > div.wrapper__main > div.wrapper__content.js-wrapper-content > div.wrapper__control > div.wrapper-product__content.wrapper-product__box-prime > div.wrapper-product__informations.js-block-product > button.button__buy.button__buy-product-detail.js-add-cart-button.js-main-add-cart-button.js-add-box-prime");
	private By btnContinuarGarantia = By.cssSelector("a.price-warranty__btn--continue.btn-buy-warranty");

	public void esperarCarregarPagina() {
		waitForPageLoad(20);
		waitElementVisible(btnAdicionarASacola, 10);
	}
	
	public boolean adicionarProduto() {
		waitElementVisible(btnAdicionarASacola, 3);
		browser.findElement(btnAdicionarASacola).click();
		
		try {
			waitForPageLoad(20);
			WebElement element = browser.findElement(btnContinuarGarantia);
			JavascriptExecutor jse2 = (JavascriptExecutor)browser;
			jse2.executeScript("arguments[0].scrollIntoView()", element); 
			jse2.executeScript("arguments[0].click()", element); 
			return true;
	    }
		catch (NoSuchElementException e) {
			return false;
		}
	}
}
