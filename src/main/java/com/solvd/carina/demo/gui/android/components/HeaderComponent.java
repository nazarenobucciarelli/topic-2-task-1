package com.solvd.carina.demo.gui.android.components;

import com.solvd.carina.demo.gui.common.components.HeaderComponentBase;
import com.solvd.carina.demo.gui.common.components.SelectComponentBase;
import com.solvd.carina.demo.gui.common.pages.ProductListPageBase;
import com.solvd.carina.demo.gui.android.pages.CategoryPage;
import com.solvd.carina.demo.gui.android.pages.ProductListPage;
import com.solvd.carina.demo.gui.android.pages.SignInPage;
import com.solvd.carina.demo.gui.common.pages.SignInPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends HeaderComponentBase implements IMobileUtils {

    @FindBy(xpath = "//android.app.Dialog/android.view.View/android.view.View/android.widget.EditText")
    private ExtendedWebElement searchBox;

    @FindBy(xpath = "//android.widget.Button[@text=\"Search\"]")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Sign in\"]")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//android.widget.Button[@text=\"Open menu\"]")
    private ExtendedWebElement openMenuButton;

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
    public SelectComponentBase openCategoriesSelect() {
        return null;
    }

    @Override
    public boolean areAllHeaderElementsDisplayed() {
        return false;
    }
}
