package com.solvd.carina.demo.gui.desktop.pages;

import com.solvd.carina.demo.gui.common.pages.ProductListPageBase;
import com.solvd.carina.demo.gui.desktop.components.HeaderComponent;
import com.solvd.carina.demo.gui.desktop.components.ProductListComponent;
import com.solvd.carina.demo.gui.desktop.components.ProductListLeftSideBarComponent;
import com.solvd.carina.demo.gui.common.models.Product;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase {

    @FindBy(css = ".srp-results li.s-item")
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
        waitUntil(webDriver -> !productListComponentElements.isEmpty(), 5);
        int randomIndex = new Random().nextInt(productListComponentElements.size());
        ProductListComponent productListComponent = productListComponentElements.get(randomIndex);
        ProductPage productPage = productListComponent.openProductEbay();

        Set<String> windowHandles = driver.getWindowHandles();
        String currentWindowHandle = driver.getWindowHandle();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        return productPage;
    }

    public ProductListLeftSideBarComponent getLeftSideBar() {
        return leftSideBar;
    }

    @Override
    public String selectPriceLimit() {
        return leftSideBar.selectRandomLimitPrice();
    }
}