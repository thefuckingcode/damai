package com.ali.user.open.cookies;

import android.text.format.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class HttpDateTime {
    private static final Pattern HTTP_DATE_ANSIC_PATTERN = Pattern.compile(HTTP_DATE_ANSIC_REGEXP);
    private static final String HTTP_DATE_ANSIC_REGEXP = "[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})";
    private static final Pattern HTTP_DATE_RFC_PATTERN = Pattern.compile(HTTP_DATE_RFC_REGEXP);
    private static final String HTTP_DATE_RFC_REGEXP = "([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])";

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class TimeOfDay {
        int hour;
        int minute;
        int second;

        TimeOfDay(int i, int i2, int i3) {
            this.hour = i;
            this.minute = i2;
            this.second = i3;
        }
    }

    private static int getDate(String str) {
        if (str.length() == 2) {
            return ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
        }
        return str.charAt(0) - '0';
    }

    private static int getMonth(String str) {
        int lowerCase = ((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - 291;
        if (lowerCase == 9) {
            return 11;
        }
        if (lowerCase == 10) {
            return 1;
        }
        if (lowerCase == 22) {
            return 0;
        }
        if (lowerCase == 26) {
            return 7;
        }
        if (lowerCase == 29) {
            return 2;
        }
        if (lowerCase == 32) {
            return 3;
        }
        if (lowerCase == 40) {
            return 6;
        }
        if (lowerCase == 42) {
            return 5;
        }
        if (lowerCase == 48) {
            return 10;
        }
        switch (lowerCase) {
            case 35:
                return 9;
            case 36:
                return 4;
            case 37:
                return 8;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static TimeOfDay getTime(String str) {
        int i;
        int charAt = str.charAt(0) - '0';
        if (str.charAt(1) != ':') {
            i = 2;
            charAt = (charAt * 10) + (str.charAt(1) - '0');
        } else {
            i = 1;
        }
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = i3 + 1 + 1;
        return new TimeOfDay(charAt, ((str.charAt(i2) - '0') * 10) + (str.charAt(i3) - '0'), ((str.charAt(i4) - '0') * 10) + (str.charAt(i4 + 1) - '0'));
    }

    private static int getYear(String str) {
        if (str.length() == 2) {
            int charAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            return charAt >= 70 ? charAt + 1900 : charAt + 2000;
        } else if (str.length() == 3) {
            return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + 1900;
        } else {
            if (str.length() == 4) {
                return ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
            }
            return 1970;
        }
    }

    public static long parse(String str) throws IllegalArgumentException {
        int i;
        int i2;
        int i3;
        TimeOfDay timeOfDay;
        int i4;
        int i5;
        int i6;
        Matcher matcher = HTTP_DATE_RFC_PATTERN.matcher(str);
        if (matcher.find()) {
            i = getDate(matcher.group(1));
            i3 = getMonth(matcher.group(2));
            i2 = getYear(matcher.group(3));
            timeOfDay = getTime(matcher.group(4));
        } else {
            Matcher matcher2 = HTTP_DATE_ANSIC_PATTERN.matcher(str);
            if (matcher2.find()) {
                i3 = getMonth(matcher2.group(1));
                int date = getDate(matcher2.group(2));
                TimeOfDay time = getTime(matcher2.group(3));
                i2 = getYear(matcher2.group(4));
                i = date;
                timeOfDay = time;
            } else {
                throw new IllegalArgumentException();
            }
        }
        if (i2 >= 2038) {
            i6 = 1;
            i5 = 0;
            i4 = 2038;
        } else {
            i6 = i;
            i5 = i3;
            i4 = i2;
        }
        Time time2 = new Time("UTC");
        time2.set(timeOfDay.second, timeOfDay.minute, timeOfDay.hour, i6, i5, i4);
        return time2.toMillis(false);
    }
}
