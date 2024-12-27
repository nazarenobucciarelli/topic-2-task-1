package com.solvd.carina.demo.gui.android.components;

import com.solvd.carina.demo.gui.common.components.ProductListComponentBase;
import com.solvd.carina.demo.gui.android.pages.ProductPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductListComponent extends ProductListComponentBase implements IMobileUtils, ICustomTypePageFactory {

    @FindBy(xpath = "//android.view.View[2]//android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,\"£\")][1]")
    private ExtendedWebElement price;

    @FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View[1]")
    private ExtendedWebElement picture;

    public ProductListComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        swipe(title);
        return title.getText();
    }

    public String getPrice() {
        swipe(price);
        return price.getText();
    }

    public ProductPage openProductEbay() {
        picture.click();
        return new ProductPage(driver);
    }

}