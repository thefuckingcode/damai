package cn.damai.uikit.calendar.format;

import tb.af;
import tb.ye;

/* compiled from: Taobao */
public interface WeekDayFormatter {
    public static final WeekDayFormatter DEFAULT = new af(ye.d());

    CharSequence format(int i);
}
