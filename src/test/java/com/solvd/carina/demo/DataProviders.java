package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.common.enums.Category;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "categories")
    public Object[][] categories() {
        return new Object[][]{
                {Category.SOUND_VISION},
                {Category.VEHICLE_PARTS}
        };
    }
}
