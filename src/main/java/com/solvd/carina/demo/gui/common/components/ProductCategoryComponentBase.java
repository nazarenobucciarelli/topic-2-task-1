package com.solvd.carina.demo.gui.common.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductCategoryComponentBase extends AbstractUIObject {
    public ProductCategoryComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getName();

}
