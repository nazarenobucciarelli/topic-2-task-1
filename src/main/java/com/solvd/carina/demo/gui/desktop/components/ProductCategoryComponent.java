package com.solvd.carina.demo.gui.desktop.components;

import com.solvd.carina.demo.gui.common.components.ProductCategoryComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCategoryComponent extends ProductCategoryComponentBase {

    @FindBy(css = "h3")
    private ExtendedWebElement productName;

    @FindBy(css = ".brwrvr__item-card__signals__body")
    private ExtendedWebElement productPrice;

    public ProductCategoryComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getName() {
        return productName.getText();
    }

    public String getPrice() {
        return productPrice.getText();
    }
}
