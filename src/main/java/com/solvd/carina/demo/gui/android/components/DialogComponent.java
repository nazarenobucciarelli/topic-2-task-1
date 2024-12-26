package com.solvd.carina.demo.gui.android.components;

import com.solvd.carina.demo.gui.common.components.DialogComponentBase;
import com.solvd.carina.demo.gui.common.pages.ShoppingCartPageBase;
import com.solvd.carina.demo.gui.desktop.pages.ShoppingCartPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DialogComponent extends DialogComponentBase implements ICustomTypePageFactory {

    @FindBy(xpath = "//android.widget.Button[@text=\"Yes, continue\"]")
    private ExtendedWebElement confirmButton;

    public DialogComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ShoppingCartPageBase clickConfirmButton() {
        waitUntil(webDriver -> confirmButton.isVisible(),5);
        confirmButton.click();
        return initPage(ShoppingCartPageBase.class);
    }
}