package framework.driver;

import framework.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            String browser = ConfigReader.get("browser");

            switch (browser.toLowerCase()) {

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                default:

                    WebDriverManager.chromedriver().setup();

                    ChromeOptions options = new ChromeOptions();

                    // Flags necessárias para CI (GitHub Actions)
                    boolean headless = Boolean.parseBoolean(System.getenv("CI"));

                    if (headless) {
                        options.addArguments("--headless=new");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--window-size=1920,1080");
                    }

                    driver = new ChromeDriver(options);
            }

            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}