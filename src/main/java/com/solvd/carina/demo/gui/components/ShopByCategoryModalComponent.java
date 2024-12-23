package com.solvd.carina.demo.gui.components;

import com.solvd.carina.demo.gui.pages.desktop.CategoryPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ShopByCategoryModalComponent extends AbstractUIObject {

    @FindBy(css = ".scnd")
    private List<ExtendedWebElement> categories;

    public ShopByCategoryModalComponent(WebDriver driver) {
        super(driver);
    }

    public CategoryPage clickRandomCategory() {
        int randomIndex = new Random().nextInt(categories.size());
        categories.get(randomIndex).click();
        return new CategoryPage(driver);
    }
}