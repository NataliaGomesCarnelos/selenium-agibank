package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BlogAgibankPageObject {

    private WebDriver driver;
    private WebDriverWait wait;

    private final String URL = "https://blogdoagi.com.br";

    private By firstResult = By.cssSelector("article h2 a");
    private By noResults = By.xpath("//*[contains(text(),'nada foi encontrado')]");

    public BlogAgibankPageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void search(String term) {

        driver.get(URL + "/?s=" + term.replace(" ", "+"));

        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(firstResult),
                ExpectedConditions.visibilityOfElementLocated(noResults)
        ));
    }

    public String getFirstResultText() {
        return driver.findElement(firstResult).getText();
    }

    public boolean isNoResultsDisplayed() {
        return driver.findElement(noResults).isDisplayed();
    }
}