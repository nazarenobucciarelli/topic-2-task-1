package com.solvd.carina.demo.gui.android.pages;

import com.solvd.carina.demo.gui.common.models.CategoryItem;
import com.solvd.carina.demo.gui.common.pages.CategoryPageBase;
import com.solvd.carina.demo.gui.android.components.HeaderComponent;
import com.solvd.carina.demo.gui.android.components.CategoryItemComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CategoryPageBase.class)
public class CategoryPage extends CategoryPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Shop by category\"]/parent::android.view.View" +
            "//android.view.View[@content-desc]")
    private List<CategoryItemComponent> items;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Shop by category\"]/parent::android.view.View/" +
            "following-sibling::android.view.View[1]")
    private ExtendedWebElement shopByCategorySection;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<CategoryItem> getProducts() {
        swipe(shopByCategorySection);
        return items.stream().map(categoryItemComponent ->
                new CategoryItem(categoryItemComponent.getName())).collect(Collectors.toList());
    }

    @Override
    public HeaderComponent getHeader() {
        return null;
    }
}
