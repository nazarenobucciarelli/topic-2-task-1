package com.solvd.carina.demo.gui.desktop.pages;

import com.solvd.carina.demo.gui.common.pages.HomePageBase;
import com.solvd.carina.demo.gui.common.pages.PageBase;
import com.solvd.carina.demo.gui.desktop.components.HeaderComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends HomePageBase {
    @FindBy(css = ".vl-flyout-nav__container li a")
    private List<ExtendedWebElement> categories;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return null;
    }

    public List<ExtendedWebElement> getCategories() {
        return categories.stream()
                .filter(category -> category.isVisible()
                        && !category.getText().equals("Explore (New!)") && !category.getText().equals("Saved"))
                .collect(Collectors.toList());
    }
}