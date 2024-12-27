package com.solvd.carina.demo.gui.common.components;

import com.solvd.carina.demo.gui.common.enums.Category;

import com.solvd.carina.demo.gui.common.pages.CategoryPageBase;
import com.solvd.carina.demo.gui.common.pages.ProductListPageBase;
import com.solvd.carina.demo.gui.common.pages.SignInPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderComponentBase extends AbstractUIObject implements ICustomTypePageFactory {

    public HeaderComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void typeSearchBox(String text);

    public abstract ProductListPageBase clickSearchButton();

    public abstract CategoryPageBase clickSearchButtonByCategory();

    public abstract ShopByCategoryModalComponentBase clickShopByCategoryButton();

    public abstract SignInPageBase clickSignInButton();

    public abstract CategoryPageBase selectCategory(Category category);

    public abstract boolean areAllHeaderElementsDisplayed();

}
