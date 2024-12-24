package com.solvd.carina.demo.gui.android.pages;

import com.solvd.carina.demo.gui.common.pages.HomePageBase;
import com.solvd.carina.demo.gui.android.components.HeaderComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @FindBy(xpath = "//android.webkit.WebView[@text=\"Electronics, Cars, Fashion, Collectibles & More | eBay\"]/android.view.View/android.view.View[1]")
    private HeaderComponent header;

    @FindBy(css = ".vl-flyout-nav__container li a")
    private List<ExtendedWebElement> categories;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponent getHeader() {
        return header;
    }

    public List<ExtendedWebElement> getCategories() {
        return categories.stream()
                .filter(category -> category.isVisible()
                        && !category.getText().equals("Explore (New!)") && !category.getText().equals("Saved"))
                .collect(Collectors.toList());
    }
}
