package com.solvd.carina.demo.gui.android.pages;

import com.solvd.carina.demo.gui.common.models.Product;
import com.solvd.carina.demo.gui.common.pages.ProductListPageBase;
import com.solvd.carina.demo.gui.android.components.HeaderComponent;
import com.solvd.carina.demo.gui.android.components.ProductListComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.webkit.WebView[@text]/android.view.View/android.view.View[2]/android.view.View[2]" +
            "/android.view.View/android.widget.ListView/android.view.View[position() > 1]")
    private List<ProductListComponent> productListComponentElements;


    @FindBy(xpath = "//android.widget.Button[@text=\"Price\"]")
    private ExtendedWebElement priceButton;

    @FindBy(xpath = "//android.app.Dialog[@text=\"Price\"]/android.view.View[2]/android.widget.ListView/" +
            "android.view.View")
    private List<ExtendedWebElement> priceFilters;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return null;
    }

    public List<Product> getProducts() {
        waitUntil((webDriver) -> !productListComponentElements.isEmpty(),10);
        return productListComponentElements.stream()
                .map(productListComponent -> new Product(
                        productListComponent.getTitle(),
                        productListComponent.getPrice()))
                .collect(Collectors.toList());
    }

    public ProductPage clickOnRandomProduct() {
        waitUntil(webDriver -> !productListComponentElements.isEmpty(),5);
        int randomIndex = new Random().nextInt(productListComponentElements.size());
        ProductListComponent productListComponent = productListComponentElements.get(0);
        return productListComponent.openProductEbay();
    }

    @Override
    public String selectPriceLimit() {
        priceButton.click();
        waitUntil(webDriver -> priceFilters.get(0).isVisible(),5);
        ExtendedWebElement priceFilterButton = priceFilters.get(new Random().nextInt(priceFilters.size()));
        priceFilterButton.click();
        return priceFilterButton.getText();
    }
}