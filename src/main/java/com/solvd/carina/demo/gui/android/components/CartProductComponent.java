package com.solvd.carina.demo.gui.android.components;

import com.solvd.carina.demo.gui.common.components.CartProductComponentBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartProductComponent extends CartProductComponentBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.Button[contains(@text,\"Remove\")][1]")
    private ExtendedWebElement removeButton;

    @FindBy(xpath = "//android.view.View[@content-desc]")
    private ExtendedWebElement title;

    public CartProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickRemoveButton() {
        tap(removeButton.getLocation().x, removeButton.getLocation().y,2);
        waitUntil(webDriver -> !removeButton.isElementPresent(),5);
    }

    public String getTitle() {
        return title.getText();
    }
}