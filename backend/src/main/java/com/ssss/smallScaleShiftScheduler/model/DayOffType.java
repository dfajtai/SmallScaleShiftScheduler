package com.ssss.smallScaleShiftScheduler.model;

public enum DayOffType {
    VACATION("Szabadság", 8, true),
    SICK_LEAVE("Táppénz", 8, true),
    CERTIFIED_ABSENCE("Igazolt távollét", 8, false);

    private final String displayName;
    private final int defaultHours;
    private final boolean paid;

    // ... (konstruktor, getterek)
}