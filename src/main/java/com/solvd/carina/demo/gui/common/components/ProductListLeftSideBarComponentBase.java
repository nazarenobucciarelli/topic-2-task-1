package com.solvd.carina.demo.gui.common.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductListLeftSideBarComponentBase extends AbstractUIObject {
    public ProductListLeftSideBarComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String selectRandomBrand();
}
