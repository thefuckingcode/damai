package cn.damai.uikit.calendar;

@Experimental
/* compiled from: Taobao */
public enum CalendarMode {
    MONTHS(6),
    MONTHS_LABEL(5),
    MONTHS_CATEGORY(5),
    WEEKS(1);
    
    final int visibleWeeksCount;

    private CalendarMode(int i) {
        this.visibleWeeksCount = i;
    }
}
