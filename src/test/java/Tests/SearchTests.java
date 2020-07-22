package Tests;

import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;

    @Test
    public void testingSearch() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.setSearchTB("MacBoo");
        Thread.sleep(500);
        homePage.clickSearchBtn();
        Thread.sleep(500);
        Assert.assertTrue(driver.getCurrentUrl().contains("MacBoo"));
    }


    @Test
    public void testingSearchWithSuggestion() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.setSearchTB("MacBook");
        Thread.sleep(500);
        homePage.clickSuggestedList();
        Thread.sleep(500);
        productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.getProductName().contains("MacBook"));
    }
}
