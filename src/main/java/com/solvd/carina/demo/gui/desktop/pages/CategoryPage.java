package com.solvd.carina.demo.gui.desktop.pages;

import com.solvd.carina.demo.gui.common.models.CategoryItem;
import com.solvd.carina.demo.gui.common.pages.CategoryPageBase;
import com.solvd.carina.demo.gui.desktop.components.HeaderComponent;
import com.solvd.carina.demo.gui.desktop.components.ProductCategoryComponent;
import com.solvd.carina.demo.gui.common.models.Product;
import com.solvd.carina.demo.gui.common.pages.PageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryPage extends CategoryPageBase {
    @FindBy(css = "nav[role='navigation']")
    private ExtendedWebElement nav;

    @FindBy(css = "li.brwrvr__item-card--list")
    private List<ProductCategoryComponent> items;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return null;
    }

    public List<CategoryItem> getProducts() {
        waitUntil(webDriver -> !items.isEmpty(),5);
        return null;
    }
}