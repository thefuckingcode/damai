package com.taobao.android.dinamicx.widget.calander;

import java.io.Serializable;

/* compiled from: Taobao */
public final class Calendar implements Serializable, Comparable<Calendar> {
    private static final long serialVersionUID = 141315161718191143L;
    private boolean booked;
    private a calendarInfo;
    private int day;
    private boolean isCurrentDay;
    private boolean isCurrentMonth;
    private boolean isLeapYear;
    private boolean isWeekend;
    private int leapMonth;
    private int month;
    public RoundRectType roundRectType = RoundRectType.NONE;
    private int week;
    private int year;

    /* compiled from: Taobao */
    public enum RoundRectType {
        NONE,
        LEFT,
        RIGHT,
        ALL
    }

    /* compiled from: Taobao */
    public static class a {
        public String a;
        public String b;
    }

    public boolean containHighLightCalendarInfo() {
        return isBooked() || this.calendarInfo != null;
    }

    public final int differ(Calendar calendar) {
        return a.b(this, calendar);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Calendar)) {
            Calendar calendar = (Calendar) obj;
            if (calendar.getYear() == this.year && calendar.getMonth() == this.month && calendar.getDay() == this.day) {
                return true;
            }
        }
        return super.equals(obj);
    }

    public a getCalendarInfo() {
        return this.calendarInfo;
    }

    public String getDateString() {
        Object obj;
        Object obj2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.year);
        sb.append("-");
        int i = this.month;
        if (i < 10) {
            obj = "0" + this.month;
        } else {
            obj = Integer.valueOf(i);
        }
        sb.append(obj);
        sb.append("-");
        int i2 = this.day;
        if (i2 < 10) {
            obj2 = "0" + this.day;
        } else {
            obj2 = Integer.valueOf(i2);
        }
        sb.append(obj2);
        return sb.toString();
    }

    public int getDay() {
        return this.day;
    }

    public int getLeapMonth() {
        return this.leapMonth;
    }

    public int getMonth() {
        return this.month;
    }

    public RoundRectType getRoundRectType() {
        return this.roundRectType;
    }

    public long getTimeInMillis() {
        java.util.Calendar instance = java.util.Calendar.getInstance();
        instance.set(1, this.year);
        instance.set(2, this.month - 1);
        instance.set(5, this.day);
        return instance.getTimeInMillis();
    }

    public int getWeek() {
        return this.week;
    }

    public int getYear() {
        return this.year;
    }

    public boolean isAvailable() {
        int i = this.year;
        boolean z = true;
        boolean z2 = i > 0;
        int i2 = this.month;
        boolean z3 = z2 & (i2 > 0);
        int i3 = this.day;
        boolean z4 = z3 & (i3 > 0) & (i3 <= 31) & (i2 <= 12) & (i >= 1900);
        if (i > 2099) {
            z = false;
        }
        return z4 & z;
    }

    public boolean isBooked() {
        return this.booked;
    }

    public boolean isCurrentDay() {
        return this.isCurrentDay;
    }

    public boolean isCurrentMonth() {
        return this.isCurrentMonth;
    }

    public boolean isLeapYear() {
        return this.isLeapYear;
    }

    public boolean isSameMonth(Calendar calendar) {
        return calendar != null && this.year == calendar.getYear() && this.month == calendar.getMonth();
    }

    public boolean isWeekend() {
        return this.isWeekend;
    }

    public void setBooked(boolean z) {
        this.booked = z;
    }

    public void setCalendarInfo(a aVar) {
        this.calendarInfo = aVar;
    }

    public void setCurrentDay(boolean z) {
        this.isCurrentDay = z;
    }

    public void setCurrentMonth(boolean z) {
        this.isCurrentMonth = z;
    }

    public void setDay(int i) {
        this.day = i;
    }

    public void setLeapMonth(int i) {
        this.leapMonth = i;
    }

    public void setLeapYear(boolean z) {
        this.isLeapYear = z;
    }

    public void setMonth(int i) {
        this.month = i;
    }

    public void setRoundRectType(RoundRectType roundRectType2) {
        this.roundRectType = roundRectType2;
    }

    public void setWeek(int i) {
        this.week = i;
    }

    public void setWeekend(boolean z) {
        this.isWeekend = z;
    }

    public void setYear(int i) {
        this.year = i;
    }

    public String toString() {
        Object obj;
        Object obj2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.year);
        sb.append("");
        int i = this.month;
        if (i < 10) {
            obj = "0" + this.month;
        } else {
            obj = Integer.valueOf(i);
        }
        sb.append(obj);
        sb.append("");
        int i2 = this.day;
        if (i2 < 10) {
            obj2 = "0" + this.day;
        } else {
            obj2 = Integer.valueOf(i2);
        }
        sb.append(obj2);
        return sb.toString();
    }

    public int compareTo(Calendar calendar) {
        if (calendar == null) {
            return 1;
        }
        return toString().compareTo(calendar.toString());
    }
}
