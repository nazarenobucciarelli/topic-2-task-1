package com.solvd.carina.demo.gui.android.components;

import com.solvd.carina.demo.gui.common.components.SelectOptionModalComponentBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class SelectOptionModalComponent extends SelectOptionModalComponentBase implements IMobileUtils {

    @FindBy(xpath = "//android.view.View[position() > 1][@enabled='true' and @selected='false']")
    private List<ExtendedWebElement> availableOptions;

    public SelectOptionModalComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void selectFirstOption() {
        ExtendedWebElement option = availableOptions.get(0);
        option.click();
    }

}