package com.solvd.carina.demo.gui.common.pages;

import com.solvd.carina.demo.gui.common.components.HeaderComponentBase;
import com.solvd.carina.demo.gui.desktop.components.HeaderComponent;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;

public abstract class PageBase extends CaptchaPageBase {

    public PageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderComponentBase getHeader();

}
