package com.solvd.carina.demo.gui.desktop.components;

import com.solvd.carina.demo.gui.common.components.ProductCategoryComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CategoryItemComponent extends ProductCategoryComponentBase {

    @FindBy(xpath = "//span")
    private ExtendedWebElement name;

    public CategoryItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getName() {
        return name.getText();
    }

}
