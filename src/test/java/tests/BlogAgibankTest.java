package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.BlogAgibankPageObject;

import static org.junit.jupiter.api.Assertions.*;

public class BlogAgibankTest extends BaseTest {

	@Test
	public void testSearchExistingArticle() {

	    BlogAgibankPageObject blogPage = new BlogAgibankPageObject(driver);

	    blogPage.search("crédito consignado");

	    assertTrue(blogPage.getFirstResultText().toLowerCase().contains("consignado"));
	}

	@Test
	public void testSearchNonExistingArticle() {

	    BlogAgibankPageObject blogPage = new BlogAgibankPageObject(driver);

	    blogPage.search("xyz123");

	    assertTrue(blogPage.isNoResultsDisplayed());
	}
}