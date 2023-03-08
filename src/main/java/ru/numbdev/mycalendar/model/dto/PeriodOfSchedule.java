package ru.numbdev.mycalendar.model.dto;

public enum PeriodOfSchedule {
    YEAR,
    HALF_YEAR,
    MONTH;

    public static PeriodOfSchedule getPeriod(String period) {
        return valueOf(period.toUpperCase());
    }
}
