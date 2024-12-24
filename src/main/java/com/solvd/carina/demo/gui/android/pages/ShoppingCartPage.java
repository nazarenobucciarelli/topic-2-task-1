package com.solvd.carina.demo.gui.android.pages;

import com.solvd.carina.demo.gui.common.components.CartProductComponentBase;
import com.solvd.carina.demo.gui.common.pages.ShoppingCartPageBase;
import com.solvd.carina.demo.gui.android.components.HeaderComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ShoppingCartPageBase.class)
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

    @Override
    public List<CartProductComponentBase> getCartProducts() {
        waitUntil(webDriver -> !cartProductComponents.isEmpty(),5);
        return cartProductComponents;
    }
}