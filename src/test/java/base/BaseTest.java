
package base;

import framework.driver.DriverFactory;
import framework.utils.ScreenshotUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setup() {
        driver = DriverFactory.getDriver();
    }

    @AfterEach
    void teardown(TestInfo testInfo) {

        ScreenshotUtil.takeScreenshot(driver, testInfo.getDisplayName());

        DriverFactory.quitDriver();
    }
}
