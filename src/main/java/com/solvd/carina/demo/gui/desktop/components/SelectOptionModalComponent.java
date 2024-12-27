package com.solvd.carina.demo.gui.desktop.components;

import com.solvd.carina.demo.gui.common.components.SelectOptionModalComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class SelectOptionModalComponent extends SelectOptionModalComponentBase {

    @FindBy(css = "div[role='listbox'] div[role='option']:not([aria-disabled])")
    private List<ExtendedWebElement> availableOptions;

    public SelectOptionModalComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void selectFirstOption() {
        availableOptions.get(availableOptions.size() - 1).click();
    }

}