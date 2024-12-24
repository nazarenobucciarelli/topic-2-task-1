package com.solvd.carina.demo.gui.common.pages;

import com.solvd.carina.demo.gui.common.components.ProductListLeftSideBarComponentBase;
import com.solvd.carina.demo.gui.common.models.Product;
import com.solvd.carina.demo.gui.desktop.components.ProductListComponent;
import com.solvd.carina.demo.gui.desktop.components.ProductListLeftSideBarComponent;
import com.solvd.carina.demo.gui.desktop.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class ProductListPageBase extends PageBase {

    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<Product> getProducts();

    public abstract ProductPageBase clickOnRandomProduct();

    public abstract ProductListLeftSideBarComponentBase getLeftSideBar();
}
