package com.solvd.carina.demo.gui.common.pages;

import com.solvd.carina.demo.gui.android.pages.ShoppingCartPage;
import com.solvd.carina.demo.gui.common.components.DialogComponentBase;
import com.solvd.carina.demo.gui.common.components.SelectOptionModalComponentBase;
import com.solvd.carina.demo.gui.desktop.components.DialogComponent;
import com.solvd.carina.demo.gui.desktop.components.SelectOptionModalComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class ProductPageBase extends PageBase {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void selectRandomOptions() ;

    public abstract SelectOptionModalComponentBase clickOptionButton(ExtendedWebElement button);

    public abstract ShoppingCartPageBase clickAddToCartButton() ;

    public abstract boolean isAddToCartButtonPresent();

    public abstract String getProductName();

    public abstract DialogComponentBase getConfirmationDialog();

    public abstract boolean isConfirmationDialogDisplayed() ;

    public abstract ShoppingCartPageBase clickOnSeeInBasketButton();
}
