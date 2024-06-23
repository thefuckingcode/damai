package com.taobao.android.dinamicx.widget.calander;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Pair;
import com.taobao.android.dinamicx.widget.calander.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public final class a {
    public static int a(int i, int i2, int i3, int i4, int i5, int i6) {
        Calendar calendar = new Calendar();
        calendar.setYear(i);
        calendar.setMonth(i2);
        calendar.setDay(i3);
        Calendar calendar2 = new Calendar();
        calendar2.setYear(i4);
        calendar2.setMonth(i5);
        calendar2.setDay(i6);
        return calendar.compareTo(calendar2);
    }

    public static int b(Calendar calendar, Calendar calendar2) {
        if (calendar == null) {
            return Integer.MIN_VALUE;
        }
        if (calendar2 == null) {
            return Integer.MAX_VALUE;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0, 0);
        long timeInMillis = instance.getTimeInMillis();
        instance.set(calendar2.getYear(), calendar2.getMonth() - 1, calendar2.getDay(), 12, 0, 0);
        return (int) ((timeInMillis - instance.getTimeInMillis()) / 86400000);
    }

    public static int c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @SuppressLint({"SimpleDateFormat"})
    static int d(String str, Date date) {
        return Integer.parseInt(new SimpleDateFormat(str).format(date));
    }

    static Calendar e(int i, b bVar) {
        Calendar calendar = new Calendar();
        boolean z = true;
        calendar.setYear((((bVar.v() + i) - 1) / 12) + bVar.t());
        calendar.setMonth((((i + bVar.v()) - 1) % 12) + 1);
        if (bVar.m() != 0) {
            int g = g(calendar.getYear(), calendar.getMonth());
            Calendar calendar2 = bVar.M;
            if (calendar2 == null || calendar2.getDay() == 0) {
                g = 1;
            } else if (g >= calendar2.getDay()) {
                g = calendar2.getDay();
            }
            calendar.setDay(g);
        } else {
            calendar.setDay(1);
        }
        if (!q(calendar, bVar)) {
            if (t(calendar, bVar)) {
                calendar = bVar.s();
            } else {
                calendar = bVar.o();
            }
        }
        if (!(calendar.getYear() == bVar.g().getYear() && calendar.getMonth() == bVar.g().getMonth())) {
            z = false;
        }
        calendar.setCurrentMonth(z);
        calendar.setCurrentDay(calendar.equals(bVar.g()));
        return calendar;
    }

    public static String f(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("-");
        sb.append(i2 < 10 ? "0" : "");
        sb.append(i2);
        sb.append("-01");
        return sb.toString();
    }

    public static int g(int i, int i2) {
        int i3 = (i2 == 1 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 8 || i2 == 10 || i2 == 12) ? 31 : 0;
        if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
            i3 = 30;
        }
        if (i2 == 2) {
            return s(i) ? 29 : 28;
        }
        return i3;
    }

    static int h(int i, int i2, int i3) {
        return i(i, i2, g(i, i2), i3);
    }

    private static int i(int i, int i2, int i3, int i4) {
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2 - 1, i3);
        int i5 = instance.get(7);
        if (i4 == 1) {
            return 7 - i5;
        }
        if (i4 == 2) {
            if (i5 == 1) {
                return 0;
            }
            return (7 - i5) + 1;
        } else if (i5 == 7) {
            return 6;
        } else {
            return (7 - i5) - 1;
        }
    }

    public static int j(int i, int i2, int i3, int i4) {
        Calendar.getInstance().set(i, i2 - 1, 1, 12, 0, 0);
        int l = l(i, i2, i4);
        int g = g(i, i2);
        return (((l + g) + i(i, i2, g, i4)) / 7) * i3;
    }

    public static int k(int i, int i2, int i3, int i4, int i5) {
        return i5 == 0 ? i3 * 6 : j(i, i2, i3, i4);
    }

    static int l(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2 - 1, 1, 12, 0, 0);
        int i4 = instance.get(7);
        if (i3 == 1) {
            return i4 - 1;
        }
        if (i3 == 2) {
            if (i4 == 1) {
                return 6;
            }
            return i4 - i3;
        } else if (i4 == 7) {
            return 0;
        } else {
            return i4;
        }
    }

    static Calendar m(Calendar calendar, b bVar) {
        if (q(bVar.g(), bVar) && bVar.m() != 2) {
            return bVar.a();
        }
        if (q(calendar, bVar)) {
            return calendar;
        }
        if (bVar.s().isSameMonth(calendar)) {
            return bVar.s();
        }
        return bVar.o();
    }

    static List<Calendar> n(int i, int i2, b bVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = i2 - 1;
        Calendar.getInstance().set(i, i11, 1);
        int l = l(i, i2, bVar.E());
        int g = g(i, i2);
        ArrayList arrayList = new ArrayList();
        int i12 = 12;
        if (i2 == 1) {
            i6 = i - 1;
            int i13 = i2 + 1;
            if (l == 0) {
                i10 = 0;
            } else {
                i10 = g(i6, 12);
            }
            i3 = i10;
            i4 = i13;
            i5 = i;
        } else if (i2 == 12) {
            int i14 = i + 1;
            if (l == 0) {
                i9 = 0;
            } else {
                i9 = g(i, i11);
            }
            i5 = i14;
            i3 = i9;
            i4 = 1;
            i12 = i11;
            i6 = i;
        } else {
            int i15 = i2 + 1;
            if (l == 0) {
                i8 = 0;
            } else {
                i8 = g(i, i11);
            }
            i12 = i11;
            i3 = i8;
            i6 = i;
            i4 = i15;
            i5 = i6;
        }
        Calendar[] calendarArr = new Calendar[2];
        int i16 = 0;
        int i17 = 1;
        while (i16 < 42) {
            Calendar calendar = new Calendar();
            if (i16 < l) {
                calendar.setYear(i6);
                calendar.setMonth(i12);
                i7 = i6;
                calendar.setDay((i3 - l) + i16 + 1);
            } else {
                i7 = i6;
                if (i16 >= g + l) {
                    calendar.setYear(i5);
                    calendar.setMonth(i4);
                    calendar.setDay(i17);
                    i17++;
                } else {
                    calendar.setYear(i);
                    calendar.setMonth(i2);
                    calendar.setCurrentMonth(true);
                    calendar.setDay((i16 - l) + 1);
                }
            }
            if (calendar.equals(bVar.g())) {
                calendar.setCurrentDay(true);
            }
            u(calendar, bVar);
            v(i16 % 7 == 0 ? null : (Calendar) arrayList.get(i16 - 1), calendar);
            arrayList.add(calendar);
            if (i16 == 0) {
                calendarArr[0] = calendar;
            } else if (i16 == 41) {
                calendarArr[1] = calendar;
            }
            i16++;
            i6 = i7;
        }
        bVar.L(i, i2, calendarArr[0], calendarArr[1]);
        return arrayList;
    }

    static boolean o(Calendar calendar, List<Pair<Calendar, Calendar>> list) {
        if (list == null) {
            return false;
        }
        for (Pair<Calendar, Calendar> pair : list) {
            if (calendar.compareTo((Calendar) pair.first) >= 0 && calendar.compareTo((Calendar) pair.second) <= 0) {
                return true;
            }
        }
        return false;
    }

    static boolean p(Calendar calendar, int i, int i2, int i3, int i4, int i5, int i6) {
        if (calendar == null) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2 - 1, i3);
        long timeInMillis = instance.getTimeInMillis();
        instance.set(i4, i5 - 1, i6);
        long timeInMillis2 = instance.getTimeInMillis();
        instance.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        long timeInMillis3 = instance.getTimeInMillis();
        if (timeInMillis3 < timeInMillis || timeInMillis3 > timeInMillis2) {
            return false;
        }
        return true;
    }

    static boolean q(Calendar calendar, b bVar) {
        return p(calendar, bVar.t(), bVar.v(), bVar.u(), bVar.p(), bVar.r(), bVar.q()) && !o(calendar, bVar.n());
    }

    public static boolean r(List<Pair<Calendar, Calendar>> list) {
        if (list == null) {
            return false;
        }
        for (Pair<Calendar, Calendar> pair : list) {
            if (((Calendar) pair.second).compareTo((Calendar) pair.first) < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean s(int i) {
        return (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
    }

    private static boolean t(Calendar calendar, b bVar) {
        Calendar instance = Calendar.getInstance();
        instance.set(bVar.t(), bVar.v() - 1, bVar.u(), 12, 0);
        long timeInMillis = instance.getTimeInMillis();
        instance.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0);
        if (instance.getTimeInMillis() < timeInMillis) {
            return true;
        }
        return false;
    }

    static void u(Calendar calendar, b bVar) {
        HashMap<String, Calendar> c;
        Calendar calendar2;
        if (q(calendar, bVar) && (c = bVar.c()) != null) {
            String dateString = calendar.getDateString();
            if (c.containsKey(dateString) && (calendar2 = c.get(dateString)) != null) {
                calendar.setBooked(calendar2.isBooked());
                calendar.setCalendarInfo(calendar2.getCalendarInfo());
            }
        }
    }

    static void v(Calendar calendar, Calendar calendar2) {
        boolean z = calendar != null && calendar.containHighLightCalendarInfo();
        boolean containHighLightCalendarInfo = calendar2.containHighLightCalendarInfo();
        if (z) {
            if (containHighLightCalendarInfo) {
                if (calendar.getRoundRectType() == Calendar.RoundRectType.ALL) {
                    calendar.setRoundRectType(Calendar.RoundRectType.LEFT);
                } else if (calendar.getRoundRectType() == Calendar.RoundRectType.RIGHT) {
                    calendar.setRoundRectType(Calendar.RoundRectType.NONE);
                }
                calendar2.setRoundRectType(Calendar.RoundRectType.RIGHT);
            }
        } else if (containHighLightCalendarInfo) {
            calendar2.setRoundRectType(containHighLightCalendarInfo ? Calendar.RoundRectType.ALL : Calendar.RoundRectType.NONE);
        }
    }
}
