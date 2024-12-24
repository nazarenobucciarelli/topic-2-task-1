package com.solvd.carina.demo.gui.android.components;

import com.solvd.carina.demo.gui.common.components.ShopByCategoryModalComponentBase;
import com.solvd.carina.demo.gui.desktop.pages.CategoryPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ShopByCategoryModalComponent extends ShopByCategoryModalComponentBase {

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