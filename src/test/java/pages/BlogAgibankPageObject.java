package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlogAgibankPageObject {

    private WebDriver driver;
    private WebDriverWait wait;

    private final String URL = "https://blogdoagi.com.br/";

    private By searchIcon = By.cssSelector(".ast-search-icon");
    private By searchInput = By.cssSelector("input.search-field");
    private By firstResult = By.cssSelector("h2.entry-title a");
    private By noResults = By.xpath("//section[contains(@class,'no-results')]//p");

    public BlogAgibankPageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void open() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchIcon));
    }

    public void search(String term) {
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(term + Keys.ENTER);
        wait.until(ExpectedConditions.urlContains("?s="));
    }

    public String getFirstResultText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstResult)).getText();
    }

    public boolean isNoResultsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(noResults)).getText().toLowerCase().contains("lamentamos");
    }
}