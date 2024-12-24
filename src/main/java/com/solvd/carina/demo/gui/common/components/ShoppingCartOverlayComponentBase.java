package com.solvd.carina.demo.gui.common.components;

import com.solvd.carina.demo.gui.common.pages.ShoppingCartPageBase;
import com.solvd.carina.demo.gui.desktop.pages.ShoppingCartPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ShoppingCartOverlayComponentBase extends AbstractUIObject {
    public ShoppingCartOverlayComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ShoppingCartPageBase clickOnSeeInBasketButton();

}
