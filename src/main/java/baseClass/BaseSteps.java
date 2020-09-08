package baseClass;

import org.openqa.selenium.WebDriver;
import support.BrowserTypes;

public class BaseSteps {
	
	public static WebDriver browser;
	
	public static void OpenBrowser() throws Throwable {
		if (browser != null) return;
		browser = BrowserTypes.GetBrownser();
	}
	
	public static void CloseBrowser() throws Throwable {
		if (browser == null) return;
		browser.close();
		browser.quit();
		browser = null;
		Thread.sleep(1500);
	}
}
