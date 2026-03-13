package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlogAgibankPageObeject {

	private WebDriver driver;

	private final String URL = "https://blogdoagi.com.br/";

	private By searchIconLupa = By.cssSelector("a.slide-search.astra-search-icon");
	private By searchInputLupa = By.cssSelector("input.search-field"); 
	private By searchResultFirst = By.id("post-20420");
	private By noResultsMessage = By.xpath("//main[@id='main']/section[@class='no-results not-found']/div[@class='page-content']/p");

	public BlogAgibankPageObeject(WebDriver driver) {
	        this.driver = driver;
	    }

	public void open() {
		driver.get(URL);
	}

	public void clickLupa() {
		driver.findElement(searchIconLupa).click();
	}
	
	public void sendTextInputLupa(String word) {
		WebElement input = driver.findElement(searchInputLupa);
		input.sendKeys(word);
		input.sendKeys(Keys.ENTER);
	}

	public String getTextResultFirst() {
		return driver.findElement(searchResultFirst).getText();
	}

	public boolean noResultsFound() {
		WebElement messageElement = driver.findElement(noResultsMessage);
        String expectedText = "Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras.";
        return messageElement.getText().trim().equals(expectedText);
        }
	
	public void waitClickSearchIconLupa() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchIconLupa));
    }
	
	public void waitInputLupa() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchInputLupa));
    }
	
	public void waitVisibilityResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchResultFirst));
        }
}