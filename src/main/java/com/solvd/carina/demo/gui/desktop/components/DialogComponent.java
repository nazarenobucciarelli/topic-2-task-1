package com.solvd.carina.demo.gui.desktop.components;

import com.solvd.carina.demo.gui.common.components.DialogComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DialogComponent extends DialogComponentBase {

    @FindBy(css = ".confirm-dialog__confirm")
    private ExtendedWebElement confirmButton;

    public DialogComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }
}