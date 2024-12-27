package com.solvd.carina.demo.gui.desktop.components;

import com.solvd.carina.demo.gui.common.components.ProductListLeftSideBarComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductListLeftSideBarComponent extends ProductListLeftSideBarComponentBase {

    @FindBy(css = ".x-refine__price > :first-child a input")
    private List<ExtendedWebElement> priceLimitSelectors;

    public ProductListLeftSideBarComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String selectRandomLimitPrice() {
        ExtendedWebElement priceSelector = priceLimitSelectors.get(new Random().nextInt(priceLimitSelectors.size() -1));
        String priceRange = priceSelector.getAttribute("aria-label");
        priceSelector.click();
        priceSelector.scrollTo();
        System.out.println(priceRange);
        return priceRange;
    }


}
