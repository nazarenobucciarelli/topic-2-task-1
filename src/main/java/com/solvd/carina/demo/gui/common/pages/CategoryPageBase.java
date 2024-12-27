package com.solvd.carina.demo.gui.common.pages;

import com.solvd.carina.demo.gui.common.models.CategoryItem;
import com.solvd.carina.demo.gui.common.models.Product;
import com.solvd.carina.demo.gui.desktop.components.ProductCategoryComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CategoryPageBase extends PageBase {

    public CategoryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<CategoryItem> getProducts();
}
