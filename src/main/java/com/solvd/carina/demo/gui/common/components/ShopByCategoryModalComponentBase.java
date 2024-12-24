package com.solvd.carina.demo.gui.common.components;

import com.solvd.carina.demo.gui.common.pages.CategoryPageBase;
import com.solvd.carina.demo.gui.desktop.pages.CategoryPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class ShopByCategoryModalComponentBase extends AbstractUIObject {
    public ShopByCategoryModalComponentBase(WebDriver driver) {
        super(driver);
    }

    public abstract CategoryPageBase clickRandomCategory();
}

