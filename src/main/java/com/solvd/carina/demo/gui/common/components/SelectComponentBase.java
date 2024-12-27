package com.solvd.carina.demo.gui.common.components;

import com.solvd.carina.demo.gui.common.enums.Category;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class SelectComponentBase extends AbstractUIObject {
    public SelectComponentBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOption(Category category);

}
