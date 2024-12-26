package com.solvd.carina.demo.gui.android.pages;

import com.solvd.carina.demo.gui.android.components.CartProductComponent;
import com.solvd.carina.demo.gui.common.components.CartProductComponentBase;
import com.solvd.carina.demo.gui.common.pages.ShoppingCartPageBase;
import com.solvd.carina.demo.gui.android.components.HeaderComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ShoppingCartPageBase.class)
public class ShoppingCartPage extends ShoppingCartPageBase {

    @FindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View[.//android.widget.Button" +
            "[contains(@text, \"Remove\")]]\n")
    private List<CartProductComponent> cartProductComponents;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return null;
    }

    @Override
    public List<CartProductComponent> getCartProducts() {
        pause(3);
        return cartProductComponents;
    }
}