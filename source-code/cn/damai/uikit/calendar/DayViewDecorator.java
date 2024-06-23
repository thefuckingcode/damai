package cn.damai.uikit.calendar;

/* compiled from: Taobao */
public interface DayViewDecorator {
    void decorate(a aVar);

    boolean shouldDecorate(CalendarDay calendarDay);

    boolean updateFacade();

    String updateFacadeDesc(CalendarDay calendarDay);
}
