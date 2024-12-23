package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.enums.Category;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "categories")
    public Object[][] categories() {
        return new Object[][]{
                {Category.WHOLESALE_JOB_LOTS},
                {Category.CRAFTS},
                {Category.HOME_FURNITURE_DIY}
        };
    }
}
