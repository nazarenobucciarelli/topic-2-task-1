package com.solvd.carina.demo.gui.android.pages;

import com.solvd.carina.demo.gui.common.pages.ProductPageBase;
import com.solvd.carina.demo.gui.android.components.DialogComponent;
import com.solvd.carina.demo.gui.android.components.HeaderComponent;
import com.solvd.carina.demo.gui.android.components.SelectOptionModalComponent;

import com.solvd.carina.demo.gui.common.pages.ShoppingCartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase implements IMobileUtils {
    @FindBy(xpath = "//android.widget.TextView[@text=\"Add to basket\"]")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.widget.Button[contains(@text, \"Select\")]\n")
    private List<ExtendedWebElement> selectOptionButtons;

    @FindBy(css = "h1.x-item-title__mainTitle span")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//android.webkit.WebView/android.view.View/android.view.View/android.view.View/" +
            "android.view.View/android.view.View//android.widget.ListView[.//android.view.View[@text='Select']]")
    private SelectOptionModalComponent selectOptionModalComponent;

    @FindBy(xpath = "//android.app.Dialog[@text=\"Continue without personalising?\"]/android.view.View")
    private DialogComponent confirmationDialogComponent;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return null;
    }

    public void selectRandomOptions() {
        for (ExtendedWebElement button : selectOptionButtons) {
            SelectOptionModalComponent selectModal = clickOptionButton(button);
            waitUntil(webDriver -> selectModal.isUIObjectPresent(),5);
            selectModal.selectFirstOption();
        }
    }

    public SelectOptionModalComponent clickOptionButton(ExtendedWebElement button) {
        button.click();
        return selectOptionModalComponent;
    }

    public ShoppingCartPageBase clickAddToCartButton() {
        addToCartButton.click();
        pause(15); // to solve captcha
        if (isConfirmationDialogDisplayed()){
            return confirmationDialogComponent.clickConfirmButton();
        }
        return clickOnSeeInBasketButton();
    }

    public boolean isAddToCartButtonPresent() {
        swipe(addToCartButton);
        return addToCartButton.isPresent();
    }

    public String getProductName() {
        return productName.getText();
    }

    public DialogComponent getConfirmationDialog() {
        return confirmationDialogComponent;
    }

    public boolean isConfirmationDialogDisplayed() {
        return confirmationDialogComponent.isUIObjectPresent();
    }

    public ShoppingCartPageBase clickOnSeeInBasketButton(){
        ExtendedWebElement seeInBasketBtn =
                findExtendedWebElement(By.xpath("//android.widget.TextView[@text=\"See in basket\"]"));
        seeInBasketBtn.click();
        return initPage(ShoppingCartPageBase.class);
    }
}