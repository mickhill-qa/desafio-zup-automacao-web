package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserTypes {
	public static enum Browsers {
		CHROME,
		CHROME_HEADLESS,
		FIREFOX,
		FIREFOX_HEADLESS
	}

	public static WebDriver GetBrownser() {
		return GetBrownser(Browsers.CHROME); // Browser Default
	}

	public static WebDriver GetBrownser(Browsers browserUser) {
		WebDriver resultBrowser;
		// System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver",  "src\\test\\resources\\webdrivers\\geckodriver.exe");

		switch (browserUser) {
			case CHROME:
				resultBrowser = new ChromeDriver();
				resultBrowser.manage().window().maximize();
				break;
			case CHROME_HEADLESS:
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				resultBrowser = new ChromeDriver(options);
				break;
			case FIREFOX:
				resultBrowser = new FirefoxDriver();
				resultBrowser.manage().window().maximize();
				break;
			case FIREFOX_HEADLESS:
				FirefoxOptions firefoxOptions = new FirefoxOptions();
		        firefoxOptions.addArguments("--headless");
		        firefoxOptions.addArguments("--window-size=1920,1080");
				resultBrowser = new FirefoxDriver(firefoxOptions);
				break;
			default:
				resultBrowser = null;
				new Exception("Browser Nao Suportado");
		}
		
		return resultBrowser;
	}
}
