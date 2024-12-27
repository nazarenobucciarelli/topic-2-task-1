package com.solvd.carina.demo.gui.common.pages;

import com.solvd.carina.demo.gui.common.models.Product;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductListPageBase extends PageBase {

    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<Product> getProducts();

    public abstract ProductPageBase clickOnRandomProduct();

    public abstract String selectPriceLimit();
}
