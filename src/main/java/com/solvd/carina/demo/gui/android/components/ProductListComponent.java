package com.solvd.carina.demo.gui.android.components;

import com.solvd.carina.demo.gui.common.components.ProductListComponentBase;
import com.solvd.carina.demo.gui.desktop.pages.ProductPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductListComponent extends ProductListComponentBase {

    @FindBy(xpath = "//android.view.View[2]//android.widget.TextView")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[3]")
    private ExtendedWebElement price;

    public ProductListComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public ProductPage openProductEbay() {
        price.scrollTo();
        title.click();
        return new ProductPage(driver);
    }
}