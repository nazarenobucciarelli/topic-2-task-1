package com.solvd.carina.demo.gui.desktop.components;

import com.solvd.carina.demo.gui.common.components.DialogComponentBase;
import com.solvd.carina.demo.gui.common.pages.ShoppingCartPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DialogComponent extends DialogComponentBase {

    @FindBy(css = ".confirm-dialog__confirm")
    private ExtendedWebElement confirmButton;

    public DialogComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ShoppingCartPageBase clickConfirmButton() {
        confirmButton.click();
        return null;
    }
}