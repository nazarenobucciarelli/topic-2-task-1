package com.solvd.carina.demo.gui.android.pages;

import com.solvd.carina.demo.gui.common.pages.ProductPageBase;
import com.solvd.carina.demo.gui.android.components.DialogComponent;
import com.solvd.carina.demo.gui.android.components.HeaderComponent;
import com.solvd.carina.demo.gui.android.components.SelectOptionModalComponent;
import com.solvd.carina.demo.gui.android.components.ShoppingCartOverlayComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
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

    @FindBy(css = "div[data-testid='ux-overlay'][aria-hidden='false']")
    private ShoppingCartOverlayComponent shoppingCartOverlayComponent;

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
            selectModal.selectRandomOption();
        }
    }

    public SelectOptionModalComponent clickOptionButton(ExtendedWebElement button) {
        button.click();
        return selectOptionModalComponent;
    }

    public ShoppingCartOverlayComponent clickAddToCartButton() {
        addToCartButton.click();
        waitUntil(webDriver -> shoppingCartOverlayComponent.isUIObjectPresent(), 2);
        return shoppingCartOverlayComponent;
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
}