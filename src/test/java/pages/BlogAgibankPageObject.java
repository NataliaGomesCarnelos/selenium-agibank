package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlogAgibankPageObject {

    private WebDriver driver;
    private final String URL = "https://blogdoagi.com.br/";
    private By searchIconLupa = By.cssSelector("a.ast-search-icon");
    private By searchInputLupa = By.cssSelector("input.search-field");
    private By searchResultFirst = By.cssSelector("article h2 a");
    private By noResultsMessage = By.cssSelector("section.no-results p");

    public BlogAgibankPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(driver ->
                ((org.openqa.selenium.JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchIconLupa));
    }

    public void clickLupa() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement lupa = wait.until(ExpectedConditions.elementToBeClickable(searchIconLupa));
        lupa.click();
    }

    public void sendTextInputLupa(String word) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputLupa));
        input.sendKeys(word);
        input.sendKeys(Keys.ENTER);
    }

    public String getTextResultFirst() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultFirst));

        return result.getText();
    }

    public boolean noResultsFound() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(noResultsMessage));
        String expectedText = "Lamentamos, mas nada foi encontrado";

        return messageElement.getText().contains(expectedText);
    }
}