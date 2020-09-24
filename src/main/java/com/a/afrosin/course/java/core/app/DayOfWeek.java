package com.a.afrosin.course.java.core.app;

enum DayOfWeek {
    MONDAY("Понедельник", 0, false),
    TUESDAY("Вторник", 1, false),
    WEDNESDAY("Среда", 2, false),
    THURSDAY("Четверг", 3, false),
    FRIDAY("Пятница", 4, false),
    SATURDAY("Суббота", 5, true),
    SUNDAY("Воскресенье", 6, true);

    private static final int WEEK_WORK_HOURS = 40;
    private static final int DAY_WORK_HOURS = 8;

    private String russianTitle;
    private int dayNumber;
    private boolean isHoliday;


    DayOfWeek(String russianTitle, int dayNumber, boolean isHoliday) {
        this.russianTitle = russianTitle;
        this.dayNumber = dayNumber;
        this.isHoliday = isHoliday;
    }

    public static String getWorkingHours(DayOfWeek day){
        if (day.isHoliday){
            return String.format("%s - выходной день", day.russianTitle);
        }
        int hoursToEnd = WEEK_WORK_HOURS - day.dayNumber * DAY_WORK_HOURS;
        return String.format("%s - осталось %d ч до окончания рабочей недели", day.russianTitle, hoursToEnd);
    }

}
