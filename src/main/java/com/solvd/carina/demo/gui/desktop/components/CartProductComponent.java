package com.solvd.carina.demo.gui.desktop.components;

import com.solvd.carina.demo.gui.common.components.CartProductComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartProductComponent extends CartProductComponentBase {

    @FindBy(css = "button[data-test-id='cart-remove-item']")
    private ExtendedWebElement removeButton;

    @FindBy(css = ".item-title a")
    private ExtendedWebElement title;

    public CartProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickRemoveButton() {
        removeButton.click();
        waitUntil(webDriver -> !removeButton.isElementPresent(),5);
    }

    public String getTitle() {
        return title.getText();
    }
}