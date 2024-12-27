package com.solvd.carina.demo.gui.android.components;

import com.solvd.carina.demo.gui.common.enums.Category;
import com.solvd.carina.demo.gui.common.components.HeaderComponentBase;
import com.solvd.carina.demo.gui.common.pages.CategoryPageBase;
import com.solvd.carina.demo.gui.common.pages.ProductListPageBase;
import com.solvd.carina.demo.gui.android.pages.CategoryPage;
import com.solvd.carina.demo.gui.common.pages.SignInPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderComponent extends HeaderComponentBase implements IMobileUtils {

    @FindBy(xpath = "//android.app.Dialog/android.view.View/android.view.View/android.widget.EditText")
    private ExtendedWebElement searchBox;

    @FindBy(xpath = "//android.widget.Button[@text=\"Search\"]")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Sign in\"]")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//android.widget.Button[@text=\"Open menu\"]")
    private ExtendedWebElement openMenuButton;

    @FindBy(xpath = "//android.widget.Button[@text=\"Categories\"]")
    private ExtendedWebElement categoriesButton;

    @FindBy(xpath = "//android.widget.ListView//android.widget.Button")
    private List<ExtendedWebElement> categories;

    @FindBy(xpath = "//android.widget.ListView//android.view.View[@content-desc]//android.widget.TextView")
    private List<ExtendedWebElement> subcategories;

    @FindBy(xpath = "//android.view.View[@content-desc=\"My eBay\"]")
    private ExtendedWebElement myEBayButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"eBay Home\"]")
    private ExtendedWebElement eBayHomeButton;

    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        setUiLoadedMarker(searchBox);
    }

    @Override
    public void typeSearchBox(String text) {
        searchBox.type(text);
    }

    @Override
    public ProductListPageBase clickSearchButton() {
        searchButton.click();
        return initPage(ProductListPageBase.class);
    }

    @Override
    public CategoryPage clickSearchButtonByCategory() {
        return null;
    }

    @Override
    public ShopByCategoryModalComponent clickShopByCategoryButton() {
        return null;
    }

    @Override
    public SignInPageBase clickSignInButton() {
        openMenuButton.click();
        waitUntil(webDriver -> signInButton.isVisible(),5);
        signInButton.click();
        return initPage(SignInPageBase.class);
    }

    @Override
    public CategoryPageBase selectCategory(Category category) {
        System.out.println(category.getParentCategory() + " " + category.getDisplayName());
        openMenuButton.click();
        waitUntil(webDriver -> openMenuButton.isVisible(),5);
        categoriesButton.click();
        categories.stream().filter(element -> element.getText()
                        .equalsIgnoreCase(category.getParentCategory()))
                .findFirst().ifPresent(ExtendedWebElement::click);
        waitUntil(webDriver -> categories.isEmpty(),5);
        waitUntil(webDriver -> !subcategories.isEmpty(),5);
        subcategories.stream().filter(element -> element.getText()
                        .equalsIgnoreCase(category.getDisplayName()))
                .findFirst().ifPresent(ExtendedWebElement::click);
        waitUntil(webDriver -> subcategories.isEmpty(),5);
        return initPage(CategoryPageBase.class);
    }

    @Override
    public boolean areAllHeaderElementsDisplayed() {
        return searchBox.isVisible() && searchButton.isVisible() && myEBayButton.isVisible() &&
                openMenuButton.isVisible() && eBayHomeButton.isVisible();
    }
}
