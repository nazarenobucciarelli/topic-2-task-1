package com.solvd.carina.demo.gui.common.components;

import com.solvd.carina.demo.gui.common.pages.ProductPageBase;
import com.solvd.carina.demo.gui.desktop.pages.ProductPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductListComponentBase extends AbstractUIObject {
    public ProductListComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getTitle();

    public abstract String getPrice();

    public abstract ProductPageBase openProductEbay();
}
