package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.common.components.*;
import com.solvd.carina.demo.gui.common.enums.Category;
import com.solvd.carina.demo.gui.common.models.Product;
import com.solvd.carina.demo.gui.common.pages.*;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GUITests implements IAbstractTest {

    @Test(enabled = false)
    public void testSearchResults() {
        HomePageBase homePage = initPage(HomePageBase.class);
        homePage.open();
        HeaderComponentBase headerComponent = homePage.getHeader();
        headerComponent.typeSearchBox("football jerseys");
        ProductListPageBase searchResultsPage = headerComponent.clickSearchButton();
        List<Product> products = searchResultsPage.getProducts();
        products.forEach(product -> {
            Assert.assertTrue(!product.getTitle().isEmpty() &&
                    !product.getPrice().isEmpty(), "Not all products have a title and price");
        });
    }

    @Test(enabled = false)
    public void testShoppingCartAdd() {
        ShoppingCartPageBase shoppingCartPage = addProductToShoppingCart("t-shirts");
        Assert.assertEquals(shoppingCartPage.getCartProducts().size(), 1, "There should be one product");
    }

    @Test(enabled = false)
    public void testShoppingCartRemove() {
        ShoppingCartPageBase shoppingCartPage = addProductToShoppingCart("ball");
        shoppingCartPage.getCartProducts().forEach(CartProductComponentBase::clickRemoveButton);
        Assert.assertEquals(shoppingCartPage.getCartProducts().size(), 0, "There should be 0 products");
    }

    @Test(enabled = false)
    public void testWrongLoginAttempt() {
        SignInPageBase signInPage = login("christian", "christianPassword");
        Assert.assertTrue(signInPage.isSignInErrorMsgDisplayed(), "Sign in message must be displayed");
    }

    @Test(enabled = false)
    public void testSearchFilteringFunctionality() {
        HomePageBase homePage = initPage(HomePageBase.class);
        homePage.open();
        HeaderComponentBase headerComponent = homePage.getHeader();
        headerComponent.typeSearchBox("guitars");
        ProductListPageBase productListPage = headerComponent.clickSearchButton();

        String priceRange = productListPage.selectPriceLimit();
        if (priceRange.contains("to")){
            String[] priceRangeArray = priceRange.split("to");
            float firstPrice = Float.parseFloat(priceRangeArray[0].trim().substring(1));
            float lastPrice = Float.parseFloat(priceRangeArray[1].trim().substring(1));
            productListPage.getProducts().forEach(productListComponent -> {
                String currentPriceString = productListComponent.getPrice().substring(1);
                if (currentPriceString.contains("to")){
                    currentPriceString = currentPriceString.split(" ")[0];
                }
                float currentPrice = Float.parseFloat(currentPriceString);
                System.out.println(currentPrice);
                System.out.println("First price: " + firstPrice);
                System.out.println("Last price: " + lastPrice);
                Assert.assertTrue( currentPrice <= lastPrice && currentPrice >= firstPrice ,
                        "All products must have their price between the selected price range");
            });
        } else if (priceRange.contains("Over")){
            String limitPrice = priceRange.split("£")[1];
            float limitPriceFloat = Float.parseFloat(limitPrice);
            productListPage.getProducts().forEach(productListComponent -> {
                String currentPriceString = productListComponent.getPrice().substring(1);
                if (currentPriceString.contains("to")){
                    currentPriceString = currentPriceString.split(" ")[0];
                }
                float currentPrice = Float.parseFloat(currentPriceString);
                Assert.assertTrue( currentPrice <= limitPriceFloat, "All products must have their price" +
                        " lower or equal to the selected price");
            });
        } else if (priceRange.contains("Under")){
            String basePrice = priceRange.split("£")[1];
            float basePriceFloat = Float.parseFloat(basePrice);
            productListPage.getProducts().forEach(productListComponent -> {
                String currentPriceString = productListComponent.getPrice().substring(1);
                if (currentPriceString.contains("to")){
                    currentPriceString = currentPriceString.split(" ")[0];
                }
                float currentPrice = Float.parseFloat(currentPriceString);
                Assert.assertTrue( currentPrice <= basePriceFloat, "All products must have their price" +
                        " higher or equal to the selected price");
            });
        }
    }

    @Test(enabled = false)
    public void testAreHeaderElementsDisplayed() {
        HomePageBase homePage = initPage(HomePageBase.class);
        homePage.open();
        HeaderComponentBase headerComponent = homePage.getHeader();
        Assert.assertTrue(headerComponent.areAllHeaderElementsDisplayed(), "Not all header elements were displayed");
    }

    @Test(enabled = true, dataProvider = "categories", dataProviderClass = DataProviders.class)
    public void testCategoryShowResults(Category category) {
        HomePageBase homePage = initPage(HomePageBase.class);
        homePage.open();
        HeaderComponentBase headerComponent = homePage.getHeader();
        CategoryPageBase categoryPage;
        if (homePage.getDevice().isPhone()) {
            categoryPage = headerComponent.selectCategory(category);
            System.out.println("ENTRA");
        } else {
            categoryPage = homePage.selectCategory(category);
        }
        Assert.assertFalse(categoryPage.getProducts().isEmpty(), "Category " + category.getDisplayName() +
                " didn't show items");
    }

    // Helper methods

    public SignInPageBase login(String username, String password) {
        HomePageBase homePage = initPage(HomePageBase.class);
        homePage.open();
        HeaderComponentBase headerComponent = homePage.getHeader();
        SignInPageBase signInPage = headerComponent.clickSignInButton();
        signInPage.typeUserId(username);
        signInPage.clickSignInContinueBtn();
        signInPage.typePassword(password);
        signInPage.clickSignInBtn();
        return signInPage;
    }

    public ShoppingCartPageBase addProductToShoppingCart(String search) {
        HomePageBase homePage = initPage(HomePageBase.class);
        homePage.open();
        HeaderComponentBase headerComponent = homePage.getHeader();
        headerComponent.typeSearchBox(search);
        ProductListPageBase searchResultsPage = headerComponent.clickSearchButton();
        ProductPageBase productPage = searchResultsPage.clickOnRandomProduct();
        boolean isAddToCartButtonPresent = productPage.isAddToCartButtonPresent();
        while (!isAddToCartButtonPresent) {
            getDriver().navigate().back();

            productPage = searchResultsPage.clickOnRandomProduct();
            isAddToCartButtonPresent = productPage.isAddToCartButtonPresent();
        }

        productPage.selectRandomOptions();

        return productPage.clickAddToCartButton();
    }

}
