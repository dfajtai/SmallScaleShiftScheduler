package com.ssss.smallScaleShiftScheduler.model;

public enum DayType {
    WORKDAY("Munkanap"),
    UNUSUAL_WORKDAY("Áthelyezett munkanap"),
    HOLIDAY("Munkaszüneti nap"),
    DAY_OFF("Szabadnap");

    private final String displayName;

    DayType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

