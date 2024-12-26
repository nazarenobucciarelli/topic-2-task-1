package com.solvd.carina.demo.gui.common.pages;

import com.solvd.carina.demo.gui.common.components.CartProductComponentBase;
import com.solvd.carina.demo.gui.desktop.components.CartProductComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class ShoppingCartPageBase extends PageBase {

    public ShoppingCartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<? extends CartProductComponentBase> getCartProducts();
}
