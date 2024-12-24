package com.solvd.carina.demo.gui.android.pages;

import com.solvd.carina.demo.gui.common.models.Product;
import com.solvd.carina.demo.gui.common.pages.CategoryPageBase;
import com.solvd.carina.demo.gui.android.components.HeaderComponent;
import com.solvd.carina.demo.gui.android.components.ProductCategoryComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CategoryPageBase.class)
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

    public List<Product> getProducts() {
        waitUntil(webDriver -> !items.isEmpty(),5);
        return items.stream()
                .map(productCategoryComponent -> new Product(
                        productCategoryComponent.getTitle(),
                        productCategoryComponent.getPrice()))
                .collect(Collectors.toList());
    }
}
