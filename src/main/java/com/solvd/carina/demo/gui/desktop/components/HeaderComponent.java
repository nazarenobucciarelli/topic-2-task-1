package com.solvd.carina.demo.gui.desktop.components;

import com.solvd.carina.demo.gui.common.enums.Category;
import com.solvd.carina.demo.gui.common.components.HeaderComponentBase;
import com.solvd.carina.demo.gui.common.components.SelectComponentBase;
import com.solvd.carina.demo.gui.common.pages.CategoryPageBase;
import com.solvd.carina.demo.gui.common.pages.ProductListPageBase;
import com.solvd.carina.demo.gui.desktop.pages.CategoryPage;
import com.solvd.carina.demo.gui.desktop.pages.SignInPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends HeaderComponentBase {

    @FindBy(id = "gh-ac")
    private ExtendedWebElement searchBox;

    @FindBy(css = ".gh-spr")
    private ExtendedWebElement searchButton;

    @FindBy(id = "gh-shop-a")
    private ExtendedWebElement shopByCategoryButton;

    @FindBy(id = "gh-minicart-hover")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = ".//span[@id='gh-ug']/a")
    private ExtendedWebElement signInButton;

    @FindBy(id = "gh-cat")
    private ExtendedWebElement categoriesSelect;

    @FindBy(id = "gh-as-a")
    private ExtendedWebElement advancedButton;

    @FindBy(id = "gh-logo")
    private ExtendedWebElement logo;

    @FindBy(xpath = ".//span[@id='gh-ug']//a[contains(text(), 'register')]")
    private ExtendedWebElement registerButton;

    @FindBy(id = "gh-eb-Alerts")
    private ExtendedWebElement notificationButton;
    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeSearchBox(String text) {
        searchBox.type(text);
    }

    public ProductListPageBase clickSearchButton() {
        searchButton.click();
        return initPage(ProductListPageBase.class);
    }

    public CategoryPage clickSearchButtonByCategory() {
        searchButton.click();
        return new CategoryPage(driver);
    }

    public ShopByCategoryModalComponent clickShopByCategoryButton() {
        shopByCategoryButton.click();
        return new ShopByCategoryModalComponent(driver);
    }

    public SignInPage clickSignInButton() {
        signInButton.click();
        SignInPage signInPage = new SignInPage(driver);
        if (signInPage.getCaptcha().isVisible()) {
            System.out.println("captcha is visible");
            waitUntil(webDriver -> !signInPage.getCaptcha().isVisible(), 20);
        }
        return signInPage;
    }

    @Override
    public CategoryPageBase selectCategory(Category category) {
        return null;
    }

    public boolean areAllHeaderElementsDisplayed() {
        return signInButton.isVisible() && shopByCategoryButton.isVisible() && categoriesSelect.isVisible() &&
                advancedButton.isVisible() && logo.isVisible() && registerButton.isVisible() &&
                notificationButton.isVisible() && searchButton.isVisible() && searchBox.isVisible() &&
                cartButton.isVisible();
    }
}
