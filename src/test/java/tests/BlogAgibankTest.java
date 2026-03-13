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
        blogPage.clickLupa();
        blogPage.sendTextInputLupa("crédito consignado é mais barato");

        assertTrue(blogPage.getTextResultFirst().contains("crédito consignado"),"Resultado esperado não encontrado");
    }

    @Test
    public void testSearchNonExistingArticle() {

        BlogAgibankPageObject blogPage = new BlogAgibankPageObject(driver);

        blogPage.open();
        blogPage.clickLupa();
        blogPage.sendTextInputLupa("xyz123");

        assertTrue(blogPage.noResultsFound(),"Mensagem esperada não encontrada");
    }
}