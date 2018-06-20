package www.george.com.myEnum;

import java.util.EnumSet;

public enum WeekdayCatalog {
    SUNDAY(0, "Sunday"),
    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday");
    private static EnumSet<WeekdayCatalog> WEEKDAY_SET = EnumSet.allOf(WeekdayCatalog.class);
    private Integer value;
    private String name;
    WeekdayCatalog(Integer value, String name){
        this.value = value;
        this.name = name;
    }

    public static String getValue(int value){
        for(WeekdayCatalog weekdayCatalog : WEEKDAY_SET){
            if(weekdayCatalog.value.equals(value)){
                return weekdayCatalog.name;
            }
        }
        return null;
    }
}
