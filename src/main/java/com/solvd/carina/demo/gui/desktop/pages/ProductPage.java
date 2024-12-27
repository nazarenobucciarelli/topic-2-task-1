package com.solvd.carina.demo.gui.desktop.pages;

import com.solvd.carina.demo.gui.common.pages.ProductPageBase;
import com.solvd.carina.demo.gui.common.pages.ShoppingCartPageBase;
import com.solvd.carina.demo.gui.desktop.components.DialogComponent;
import com.solvd.carina.demo.gui.desktop.components.HeaderComponent;
import com.solvd.carina.demo.gui.desktop.components.SelectOptionModalComponent;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(css = "div.x-atc-action")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[@data-testid='x-msku-evo']/div[not(@hidden)]")
    private List<ExtendedWebElement> selectOptionButtons;

    @FindBy(css = "h1.x-item-title__mainTitle span")
    private ExtendedWebElement productName;

    @FindBy(css = "span.listbox-button--expanded")
    private SelectOptionModalComponent selectOptionModalComponent;

    @FindBy(css = "div.confirm-dialog__window")
    private DialogComponent confirmationDialogComponent;

    @FindBy(css = "div[role=\"dialog\"]:not([hidden]) a[data-testid=\"ux-call-to-action\"]")
    private List<ExtendedWebElement> actionButtons;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return null;
    }

    public void selectRandomOptions() {
        waitUntil(webDriver -> selectOptionButtons.get(0).isVisible(), 5);
        for (ExtendedWebElement button : selectOptionButtons) {
            SelectOptionModalComponent selectModal = clickOptionButton(button);
            selectModal.selectFirstOption();
        }
    }

    public SelectOptionModalComponent clickOptionButton(ExtendedWebElement button) {
        button.click();
        return selectOptionModalComponent;
    }

    public ShoppingCartPageBase clickAddToCartButton() {
        addToCartButton.click();
        waitUntil(webDriver -> actionButtons.get(0).isClickable(), 2);
        clickOnSeeInBasketButton();
        pause(15); //to solve captcha
        return initPage(ShoppingCartPageBase.class);
    }

    public boolean isAddToCartButtonPresent() {
        return addToCartButton.isPresent();
    }

    public String getProductName() {
        return productName.getText();
    }

    public DialogComponent getConfirmationDialog() {
        return confirmationDialogComponent;
    }

    public boolean isConfirmationDialogDisplayed() {
        waitUntil(webDriver -> confirmationDialogComponent.isUIObjectPresent(), 2);
        return confirmationDialogComponent.isUIObjectPresent();
    }

    public ShoppingCartPage clickOnSeeInBasketButton() {
        waitUntil(webDriver -> !actionButtons.isEmpty(), 2);
        ExtendedWebElement seeInBasketButton = actionButtons.get(1);
        seeInBasketButton.click();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        waitUntil(webDriver -> !shoppingCartPage.getCaptcha().isVisible(),20);
        return shoppingCartPage;
    }
}