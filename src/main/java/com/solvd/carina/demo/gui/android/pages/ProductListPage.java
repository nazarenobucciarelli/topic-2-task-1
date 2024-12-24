package com.solvd.carina.demo.gui.android.pages;

import com.solvd.carina.demo.gui.common.models.Product;
import com.solvd.carina.demo.gui.common.pages.PageBase;
import com.solvd.carina.demo.gui.common.pages.ProductListPageBase;
import com.solvd.carina.demo.gui.android.components.HeaderComponent;
import com.solvd.carina.demo.gui.android.components.ProductListComponent;
import com.solvd.carina.demo.gui.android.components.ProductListLeftSideBarComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase {

    @FindBy(xpath = "//android.webkit.WebView[@text]/android.view.View/android.view.View[2]/android.view.View[2]" +
            "/android.view.View/android.widget.ListView/android.view.View[position() > 1]")
    private List<ProductListComponent> productListComponentElements;

    @FindBy(css = "div.srp-rail__left")
    private ProductListLeftSideBarComponent leftSideBar;


    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return null;
    }

    public List<Product> getProducts() {
        return productListComponentElements.stream()
                .map(productListComponent -> new Product(
                        productListComponent.getTitle(),
                        productListComponent.getPrice()))
                .collect(Collectors.toList());
    }

    public ProductPage clickOnRandomProduct() {
        waitUntil(webDriver -> !productListComponentElements.isEmpty(),5);
        return null;
    }

    public ProductListLeftSideBarComponent getLeftSideBar() {
        return leftSideBar;
    }}