package com.solvd.carina.demo.gui.desktop.pages;

import com.solvd.carina.demo.gui.common.models.CategoryItem;
import com.solvd.carina.demo.gui.common.pages.CategoryPageBase;
import com.solvd.carina.demo.gui.desktop.components.CategoryItemComponent;
import com.solvd.carina.demo.gui.desktop.components.HeaderComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CategoryPageBase.class)
public class CategoryPage extends CategoryPageBase {

    @FindBy(xpath = "//section[contains(@class, \"seo-gallery-view\") and  .//h2[text()=\"Shop by category\"]]//li")
    private List<CategoryItemComponent> shopByCategoryItems;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return null;
    }

    public List<CategoryItem> getProducts() {
        waitUntil(webDriver -> !shopByCategoryItems.isEmpty(), 3);
        shopByCategoryItems.get(0).getRootExtendedElement().scrollTo();
        return shopByCategoryItems.stream()
                .map(categoryItemComponent -> new CategoryItem(categoryItemComponent.getName()))
                .collect(Collectors.toList());
    }
}