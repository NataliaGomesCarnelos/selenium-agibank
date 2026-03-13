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

    private By searchIcon = By.cssSelector("button[aria-label='Search']");
    private By searchInput = By.cssSelector("input.search-field");
    private By firstResult = By.cssSelector("article h2 a");
    private By noResults = By.cssSelector("section.no-results");

    public BlogAgibankPageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void open() {

        driver.get(URL);

        wait.until(driver ->
                ((org.openqa.selenium.JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchIcon));
    }

    public void clickLupa() {
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
    }

    public void sendTextInputLupa(String word) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(word + Keys.ENTER);
    }

    public String getTextResultFirst() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstResult)).getText();
    }

    public boolean noResultsFound() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(noResults)).getText();

        return text.contains("Lamentamos");
    }
}