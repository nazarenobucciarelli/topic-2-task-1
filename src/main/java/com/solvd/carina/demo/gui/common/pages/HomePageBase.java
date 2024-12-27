package com.solvd.carina.demo.gui.common.pages;

import com.solvd.carina.demo.gui.common.enums.Category;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public abstract class HomePageBase extends PageBase implements IMobileUtils {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CategoryPageBase selectCategory(Category category);
}
