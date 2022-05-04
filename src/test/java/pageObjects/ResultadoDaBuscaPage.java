package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import baseClass.BasePage;

public class ResultadoDaBuscaPage extends BasePage {
	public ResultadoDaBuscaPage(WebDriver _browser) {
		super(_browser);
	}

	private String uri 			= "magazineluiza.com.br/busca";
	private By txtComResultado 	= By.cssSelector("[data-testid=mod-p] > div > p");
	private By intenList_01 	= By.cssSelector("a[data-testid=product-card-container] h2[data-testid=product-title]");
	private String nomeProdutoSelecionado;
	
	public boolean verificaSeEstouNaPagina() {
		waitElementVisible(txtComResultado,10);
		String paginaAtual = browser.getCurrentUrl();
		return paginaAtual.contains(uri);
	}
	
	public int verQuantidadeResultados() {
		waitElementVisible(txtComResultado, 10);
		String texto = browser.findElement(txtComResultado).getText();
		texto = (texto.split(" "))[0].trim();
		return Integer.parseInt(texto);
	}

	public Boolean verSeExisteProdutosListados() {
		try {
			browser.findElement(intenList_01);
			return true;
	    }
		catch (NoSuchElementException e) {
	        return false;
	    }
	}
	
	public void selecionaProdutoDesejado() {
		waitElementVisible(intenList_01, 5);
		nomeProdutoSelecionado = browser.findElement(intenList_01).getText();
		waitElementClickable(intenList_01, 5);
		browser.findElement(intenList_01).click();
	}

	public String verNomeProdutoSelecionado() {
		return nomeProdutoSelecionado;
	}
}
