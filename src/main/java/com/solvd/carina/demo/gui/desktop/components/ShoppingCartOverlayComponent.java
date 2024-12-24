package com.solvd.carina.demo.gui.desktop.components;

import com.solvd.carina.demo.gui.common.components.ShoppingCartOverlayComponentBase;
import com.solvd.carina.demo.gui.desktop.pages.ShoppingCartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartOverlayComponent extends ShoppingCartOverlayComponentBase {

    @FindBy(css = "a[data-testid='ux-call-to-action']")
    private List<ExtendedWebElement> actionButtons;

    public ShoppingCartOverlayComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ShoppingCartPage clickOnSeeInBasketButton() {
        waitUntil(webDriver -> !actionButtons.isEmpty(), 2);
        ExtendedWebElement seeInBasketButton = actionButtons.get(1);
        seeInBasketButton.click();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        waitUntil(webDriver -> !shoppingCartPage.getCaptcha().isVisible(),20);
        return shoppingCartPage;
    }
}
