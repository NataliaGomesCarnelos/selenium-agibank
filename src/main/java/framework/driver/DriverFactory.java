package framework.driver;

import framework.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Map;

import org.openqa.selenium.Dimension;
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

                    // Detecta se está rodando no GitHub Actions
                    boolean headless = System.getenv("CI") != null;

                    if (headless) {
                        options.addArguments("--headless=new");
                        options.addArguments("--window-size=1920,1080");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--force-device-scale-factor=1");
                        options.addArguments("--high-dpi-support=1");
                    }

                    driver = new ChromeDriver(options);

                    // força viewport grande no CI
                    if (headless) {

                        driver.manage().window().setSize(new Dimension(1920,1080));

                        ((ChromeDriver) driver).executeCdpCommand(
                                "Emulation.setDeviceMetricsOverride",
                                Map.of(
                                        "width", 1920,
                                        "height", 1080,
                                        "deviceScaleFactor", 1,
                                        "mobile", false
                                )
                        );
                    } else {
                        driver.manage().window().maximize();
                    }

                    break;
            }
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