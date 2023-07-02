package baseClass;

import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void waitElementVisible(By element, int seconds) {
        wait = new WebDriverWait(browser, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitElementClickable(By element, int seconds) {
        wait = new WebDriverWait(browser, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
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

    public void positionScreenOn(By element) {
        WebElement webElement = browser.findElement(element);
        JavascriptExecutor jse2 = (JavascriptExecutor)browser;
        jse2.executeScript("arguments[0].scrollIntoView()", webElement);
    }

    public void javascriptClick(By element) {
        WebElement webElement = browser.findElement(element);
        JavascriptExecutor jse2 = (JavascriptExecutor)browser;
        jse2.executeScript("arguments[0].click()", webElement);
    }
}
