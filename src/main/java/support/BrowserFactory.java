package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.service.DriverService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserFactory {
    public static enum Browser {
        CHROME,
        CHROME_HEADLESS,
        FIREFOX,
        FIREFOX_HEADLESS
    }

    public static WebDriver getBrownser() {
        return getBrownser(Browser.CHROME_HEADLESS); // Browser Default
    }

    public static WebDriver getBrownser(Browser browserUser) {
        ChromeOptions options;
        WebDriver resultBrowser;

        // reduzindo output do webdriver
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

        switch (browserUser) {
            case CHROME:
                // reduzindo output do webdriver
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

                options = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-crash-reporter");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-in-process-stack-traces");
                options.addArguments("--disable-logging");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-notifications");
                options.addArguments("--log-level=3");
                options.addArguments("--output=/dev/null");
                resultBrowser = new ChromeDriver(options);
                resultBrowser.manage().window().maximize();
                break;
            case CHROME_HEADLESS:
                // reduzindo output do webdriver
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

                options = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                options.addArguments("--lang=pt-BR");
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-crash-reporter");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-in-process-stack-traces");
                options.addArguments("--disable-logging");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-notifications");
                options.addArguments("--log-level=3");
                options.addArguments("--output=/dev/null");
                resultBrowser = new ChromeDriver(options);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                resultBrowser = new FirefoxDriver();
                resultBrowser.manage().window().maximize();
                break;
            case FIREFOX_HEADLESS:
                WebDriverManager.firefoxdriver().setup();
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
