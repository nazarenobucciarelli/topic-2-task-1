package com.solvd.carina.demo.gui.common.enums;

public enum Category {
    VEHICLE_PARTS("Vehicle Parts & Accessories","Motors"),
    SOUND_VISION("Sound & Vision","Electronics");

    private final String displayName;
    private final String parentCategory;

    Category(String displayName, String parentCategory) {
        this.displayName = displayName;
        this.parentCategory = parentCategory;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getParentCategory() {
        return parentCategory;
    }
}
