package com.ssss.smallScaleShiftScheduler.model;


public enum ShiftType {
    // Jelenléti típusok
    WORK_CUSTOM("Munka (x óra)", Category.PRESENCE, 8, false),
    WORK_8H("Munka (8 óra)", Category.PRESENCE, 8, true),

    // Távmunka
    ON_CALL_8H("Ügyelet (8 óra)", Category.REMOTE, 8, true),
    ON_CALL_12H("Ügyelet (12 óra)", Category.REMOTE, 12, true),
    TRAINING("Képzés", Category.REMOTE, 8, false),
    BUSINESS_TRIP("Kiküldetés", Category.REMOTE, 8, false),


    public enum Category { PRESENCE, REMOTE }

    private final String displayName;
    private final Category category;
    private final int defaultHours;
    private final boolean fixedDuration;

    ShiftType(String displayName, Category category, int defaultHours, boolean fixedDuration) {
        this.displayName = displayName;
        this.category = category;
        this.defaultHours = defaultHours;
        this.fixedDuration = fixedDuration;
    }

    // Getters
    public String getDisplayName() { return displayName; }
    public Category getCategory() { return category; }
    public int getDefaultHours() { return defaultHours; }
    public boolean isFixedDuration() { return fixedDuration; }
}