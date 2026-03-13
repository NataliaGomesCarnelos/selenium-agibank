package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.BlogAgibankPageObject;

import static org.junit.jupiter.api.Assertions.*;

public class BlogAgibankTest extends BaseTest {

	@Test
	public void testSearchExistingArticle() {
		BlogAgibankPageObject blogPage = new BlogAgibankPageObject(driver);
		
		blogPage.open();
		blogPage.waitClickSearchIconLupa();
		blogPage.clickLupa();
		blogPage.waitInputLupa();
		blogPage.sendTextInputLupa("crédito consignado é mais barato");
		blogPage.waitVisibilityResult();
		
		assertTrue(blogPage.getTextResultFirst().contains("Por que o crédito consignado é mais barato?"));
	}

	@Test
	public void testSearchNonExistingArticle() {
		BlogAgibankPageObject blogPage = new BlogAgibankPageObject(driver);
		
		blogPage.open();
		blogPage.waitClickSearchIconLupa();
		blogPage.clickLupa();
		blogPage.waitInputLupa();
		blogPage.sendTextInputLupa("xyz123");
		blogPage.waitNoResultFound();

		assertTrue(blogPage.noResultsFound(), "Mensagem esperada não encontrada");
	}
}
