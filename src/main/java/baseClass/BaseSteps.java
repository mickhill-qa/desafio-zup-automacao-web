package baseClass;

import org.openqa.selenium.WebDriver;

import support.BrowserTypes;

public class BaseSteps {
	
	public static WebDriver browser;
	
	public static void OpenBrowser() {
		
		if (browser != null) return;
		
		browser = BrowserTypes.GetBrownser();
	}
	
	public static void CloseBrowser() {
		
		if (browser == null) return;
		
		browser.close();
		browser.quit();
		browser = null;
	}
}
