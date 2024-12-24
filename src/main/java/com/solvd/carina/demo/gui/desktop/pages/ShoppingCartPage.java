package com.solvd.carina.demo.gui.desktop.pages;

import com.solvd.carina.demo.gui.common.components.CartProductComponentBase;
import com.solvd.carina.demo.gui.common.pages.ShoppingCartPageBase;
import com.solvd.carina.demo.gui.android.components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends ShoppingCartPageBase {
    @FindBy(css = "div.cart-bucket")
    private List<CartProductComponentBase> cartProductComponents;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return null;
    }

    public List<CartProductComponentBase> getCartProducts() {
        waitUntil(webDriver -> !cartProductComponents.isEmpty(),5);
        return cartProductComponents;
    }
}