package com.solvd.carina.demo.gui.common.components;

import com.solvd.carina.demo.gui.common.pages.CategoryPageBase;
import com.solvd.carina.demo.gui.common.pages.ProductListPageBase;
import com.solvd.carina.demo.gui.common.pages.SignInPageBase;
import com.solvd.carina.demo.gui.desktop.components.SelectComponent;
import com.solvd.carina.demo.gui.desktop.components.ShopByCategoryModalComponent;
import com.solvd.carina.demo.gui.desktop.pages.CategoryPage;
import com.solvd.carina.demo.gui.desktop.pages.ProductListPage;
import com.solvd.carina.demo.gui.desktop.pages.SignInPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HeaderComponentBase extends AbstractUIObject implements ICustomTypePageFactory {

    public HeaderComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void typeSearchBox(String text);

    public abstract ProductListPageBase clickSearchButton();

    public abstract CategoryPageBase clickSearchButtonByCategory();

    public abstract ShopByCategoryModalComponentBase clickShopByCategoryButton();

    public abstract SignInPageBase clickSignInButton();

    public abstract SelectComponentBase openCategoriesSelect();

    public abstract boolean areAllHeaderElementsDisplayed();

}
