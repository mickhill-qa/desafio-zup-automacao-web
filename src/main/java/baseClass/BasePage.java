package baseClass;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver browser;
	protected WebDriverWait wait;
	protected Actions actions;

	public BasePage(WebDriver _browser) {
		browser = _browser;
		actions = new Actions(browser);
	}

	public void waitLocalizedElementToBeVisible(By element) {
		wait = new WebDriverWait(browser, 10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public void waitForPageLoad(int seconds) {
		Wait<WebDriver> wait = new WebDriverWait(browser, seconds);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver browser) {
				String result = String.valueOf(((JavascriptExecutor) browser).executeScript("return document.readyState"));
				return result.equals("complete");
			}
		});
	}
}
