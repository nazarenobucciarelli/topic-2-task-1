package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.common.components.CartProductComponentBase;
import com.solvd.carina.demo.gui.common.components.DialogComponentBase;
import com.solvd.carina.demo.gui.common.components.HeaderComponentBase;
import com.solvd.carina.demo.gui.common.components.ProductListLeftSideBarComponentBase;
import com.solvd.carina.demo.gui.common.enums.Category;
import com.solvd.carina.demo.gui.common.models.Product;
import com.solvd.carina.demo.gui.common.pages.*;
import com.solvd.carina.demo.gui.desktop.components.*;
import com.solvd.carina.demo.gui.desktop.pages.*;
import com.solvd.carina.demo.gui.utils.MobileContextUtils;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;


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

    @Test(enabled = false)
    public void testShoppingCartRemove() {
        ShoppingCartPageBase shoppingCartPage = addProductToShoppingCart("t-shirt");
        shoppingCartPage.getCartProducts().forEach(CartProductComponentBase::clickRemoveButton);
        Assert.assertEquals(shoppingCartPage.getCartProducts().size(), 0, "There should be 0 products");
    }


    @Test(enabled = false)
    public void testWrongLoginAttempt() {
        SignInPageBase signInPage = login("christian", "christianPassword");
        Assert.assertTrue(signInPage.isSignInErrorMsgDisplayed(), "Sign in message must be displayed");
    }

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

    @Test(enabled = true)
    public void testSearchFilteringFunctionality() {
        HomePageBase homePage = initPage(HomePageBase.class);
        homePage.open();
        HeaderComponentBase headerComponent = homePage.getHeader();
        headerComponent.typeSearchBox("guitars");
        ProductListPageBase productListPage = headerComponent.clickSearchButton();
        ProductListLeftSideBarComponentBase productListLeftSideBar = productListPage.getLeftSideBar();
        String brandName = productListLeftSideBar.selectRandomBrand();
        AtomicInteger counter = new AtomicInteger();
        productListPage.getProducts().forEach(productListComponent -> {
            if (productListComponent.getTitle().toLowerCase().contains(brandName.toLowerCase())) {
                counter.getAndIncrement();
            }
        });
        Assert.assertTrue(counter.get() > 10, "Number of products found with the brand on their title " +
                "was lower than 10");
    }

        /*
    @Test(enabled = true)
    public void testAreHeaderElementsDisplayed() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderComponent headerComponent = homePage.getHeader();
        Assert.assertTrue(headerComponent.areAllHeaderElementsDisplayed(), "Not all header elements were displayed");
    }


    @Test(enabled = true, dataProvider = "categories", dataProviderClass = DataProviders.class)
    public void testCategoryShowResults(Category category) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderComponent headerComponent = homePage.getHeader();
        SelectComponent selectComponent = headerComponent.openCategoriesSelect();
        selectComponent.clickOption(category);
        CategoryPage categoryPage = headerComponent.clickSearchButtonByCategory();
        Assert.assertFalse(categoryPage.getProducts().isEmpty(), "Category " + category.getDisplayName() +
                " didn't show items");
    }

    // Helper methods


*/
}
