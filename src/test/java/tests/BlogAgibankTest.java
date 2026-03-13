package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.BlogAgibankPageObeject;

import static org.junit.jupiter.api.Assertions.*;

public class BlogAgibankTest extends BaseTest {

	@Test
	public void testSearchExistingArticle() {
		BlogAgibankPageObeject blogPage = new BlogAgibankPageObeject(driver);
		
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
		BlogAgibankPageObeject blogPage = new BlogAgibankPageObeject(driver);
		
		blogPage.open();
		blogPage.waitClickSearchIconLupa();
		blogPage.clickLupa();
		blogPage.waitInputLupa();
		blogPage.sendTextInputLupa("xyz123");


		assertTrue(blogPage.noResultsFound(), "Mensagem esperada não encontrada");
	}
}
