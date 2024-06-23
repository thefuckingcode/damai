package cn.damai.uikit.calendar.format;

import androidx.annotation.NonNull;
import cn.damai.uikit.calendar.CalendarDay;
import tb.x20;

/* compiled from: Taobao */
public interface DayFormatter {
    public static final DayFormatter DEFAULT = new x20();

    @NonNull
    String format(@NonNull CalendarDay calendarDay);
}
