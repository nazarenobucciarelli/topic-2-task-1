package com.solvd.carina.demo.gui.android.components;

import com.solvd.carina.demo.gui.common.components.ProductListLeftSideBarComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class ProductListLeftSideBarComponent extends ProductListLeftSideBarComponentBase {

    @FindBy(css = "ul.x-refine__left__nav li ul.x-refine__left__nav > li")
    private List<ExtendedWebElement> filterGroups;

    public ProductListLeftSideBarComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String selectRandomLimitPrice() {
        List<ExtendedWebElement> checkBoxes = filterGroups.get(0).findExtendedWebElements(By.cssSelector("a"));
        int randomIndex = new Random().nextInt(checkBoxes.size());
        ExtendedWebElement checkBox = checkBoxes.get(randomIndex);

        while (true) {
            String value = checkBox.getAttribute("href");

            ExtendedWebElement inputElement = null;
            String brandName = null;
            try {
                inputElement = checkBox.findExtendedWebElement(By.cssSelector("input[aria-label]"));
                if (inputElement != null) {
                    brandName = inputElement.getAttribute("aria-label");
                }
            } catch (NoSuchElementException ex) {
                continue;
            }

            if (brandName == null) {
                continue;
            }

            if (!value.contains("Unbranded")) {
                checkBox.click();
                return brandName;
            }

            checkBoxes = filterGroups.get(0).findExtendedWebElements(By.cssSelector("a"));
            randomIndex = new Random().nextInt(checkBoxes.size());
            checkBox = checkBoxes.get(randomIndex);
        }
    }
}
