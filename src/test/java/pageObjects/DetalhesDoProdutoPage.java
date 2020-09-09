package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import baseClass.BasePage;

public class DetalhesDoProdutoPage extends BasePage {
	public DetalhesDoProdutoPage(WebDriver _browser) {
		super(_browser);
	}
	
	private By btnAdicionarASacola 	= By.cssSelector("button.button__buy.button__buy-product-detail.js-add-cart-button.js-main-add-cart-button.js-add-box-prime");
	private By btnContinuarGarantia = By.cssSelector("a.price-warranty__btn--continue.btn-buy-warranty");

	public void esperarCarregarPagina() {
		waitForPageLoad(20);
		waitElementVisible(btnAdicionarASacola, 10);
	}
	
	public boolean adicionarProduto() {
		waitForPageLoad(20);
		waitElementClickable(btnAdicionarASacola, 5);
		javascriptClick(btnAdicionarASacola);
		
		try {
			waitForPageLoad(20);
			waitElementClickable(btnContinuarGarantia, 5);
			positionScreenOn(btnContinuarGarantia);
			javascriptClick(btnContinuarGarantia);
			return true;
	    }
		catch (Exception e) {
			return false;
		}
	}
}
