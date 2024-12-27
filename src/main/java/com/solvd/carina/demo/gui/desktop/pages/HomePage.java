package com.solvd.carina.demo.gui.desktop.pages;

import com.solvd.carina.demo.gui.common.enums.Category;
import com.solvd.carina.demo.gui.common.pages.CategoryPageBase;
import com.solvd.carina.demo.gui.common.pages.HomePageBase;
import com.solvd.carina.demo.gui.desktop.components.HeaderComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(css = ".vl-flyout-nav__container li a")
    private List<ExtendedWebElement> categories;

    @FindBy(css = "header")
    private HeaderComponent header;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return header;
    }

    public CategoryPageBase selectCategory(Category category) {
        ExtendedWebElement cat = categories.stream().filter(extendedWebElement -> extendedWebElement.getText()
                .equalsIgnoreCase(category.getParentCategory())).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Category not found for: " + category.getParentCategory()));
        cat.hover();
        ExtendedWebElement element = findExtendedWebElement(By.cssSelector("li.vl-flyout-nav__js-show"));
        List<ExtendedWebElement> subcategories = element.findExtendedWebElements(By.cssSelector("nav li a"));
        ExtendedWebElement subcategory = subcategories.stream()
                .filter(extendedWebElement -> extendedWebElement.getText()
                        .equalsIgnoreCase(category.getDisplayName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Subcategory not found for: " + category.getDisplayName()));

        subcategory.click();
        return initPage(CategoryPageBase.class);
    }
}