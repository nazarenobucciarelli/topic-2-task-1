package com.solvd.carina.demo.gui.desktop.pages;

import com.solvd.carina.demo.gui.common.pages.ShoppingCartPageBase;
import com.solvd.carina.demo.gui.desktop.components.CartProductComponent;
import com.solvd.carina.demo.gui.desktop.components.HeaderComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ShoppingCartPageBase.class)
public class ShoppingCartPage extends ShoppingCartPageBase {
    @FindBy(css = "div.cart-bucket")
    private List<CartProductComponent> cartProductComponents;

    @FindBy(css = "header")
    private HeaderComponent header;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return header;
    }

    public List<CartProductComponent> getCartProducts() {
        waitUntil(webDriver -> !cartProductComponents.isEmpty(),5);
        return cartProductComponents;
    }
}