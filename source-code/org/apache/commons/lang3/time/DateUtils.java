package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;

/* compiled from: Taobao */
public class DateUtils {
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    private static final int[][] fields = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class DateIterator implements Iterator<Calendar> {
        private final Calendar endFinal;
        private final Calendar spot;

        DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public Calendar next() {
            if (!this.spot.equals(this.endFinal)) {
                this.spot.add(5, 1);
                return (Calendar) this.spot.clone();
            }
            throw new NoSuchElementException();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum ModifyType {
        TRUNCATE,
        ROUND,
        CEILING
    }

    private static Date add(Date date, int i, int i2) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(i, i2);
        return instance.getTime();
    }

    public static Date addDays(Date date, int i) {
        return add(date, 5, i);
    }

    public static Date addHours(Date date, int i) {
        return add(date, 11, i);
    }

    public static Date addMilliseconds(Date date, int i) {
        return add(date, 14, i);
    }

    public static Date addMinutes(Date date, int i) {
        return add(date, 12, i);
    }

    public static Date addMonths(Date date, int i) {
        return add(date, 2, i);
    }

    public static Date addSeconds(Date date, int i) {
        return add(date, 13, i);
    }

    public static Date addWeeks(Date date, int i) {
        return add(date, 3, i);
    }

    public static Date addYears(Date date, int i) {
        return add(date, 1, i);
    }

    public static Date ceiling(Date date, int i) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        modify(instance, i, ModifyType.CEILING);
        return instance.getTime();
    }

    private static long getFragment(Date date, int i, TimeUnit timeUnit) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return getFragment(instance, i, timeUnit);
    }

    public static long getFragmentInDays(Date date, int i) {
        return getFragment(date, i, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Date date, int i) {
        return getFragment(date, i, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Date date, int i) {
        return getFragment(date, i, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Date date, int i) {
        return getFragment(date, i, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Date date, int i) {
        return getFragment(date, i, TimeUnit.SECONDS);
    }

    public static boolean isSameDay(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        return isSameDay(instance, instance2);
    }

    public static boolean isSameInstant(Date date, Date date2) {
        if (date != null && date2 != null) {
            return date.getTime() == date2.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(11) == calendar2.get(11) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Iterator<Calendar> iterator(Date date, int i) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return iterator(instance, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0132 A[SYNTHETIC] */
    private static void modify(Calendar calendar, int i, ModifyType modifyType) {
        int i2;
        boolean z;
        char c;
        if (calendar.get(1) > 280000000) {
            throw new ArithmeticException("Calendar value too large for accurate calculations");
        } else if (i != 14) {
            Date time = calendar.getTime();
            long time2 = time.getTime();
            int i3 = calendar.get(14);
            ModifyType modifyType2 = ModifyType.TRUNCATE;
            if (modifyType2 == modifyType || i3 < 500) {
                time2 -= (long) i3;
            }
            boolean z2 = i == 13;
            int i4 = calendar.get(13);
            if (!z2 && (modifyType2 == modifyType || i4 < 30)) {
                time2 -= ((long) i4) * 1000;
            }
            if (i == 12) {
                z2 = true;
            }
            int i5 = calendar.get(12);
            if (!z2 && (modifyType2 == modifyType || i5 < 30)) {
                time2 -= ((long) i5) * MILLIS_PER_MINUTE;
            }
            if (time.getTime() != time2) {
                time.setTime(time2);
                calendar.setTime(time);
            }
            int[][] iArr = fields;
            boolean z3 = false;
            for (int[] iArr2 : iArr) {
                for (int i6 : iArr2) {
                    if (i6 == i) {
                        if (modifyType != ModifyType.CEILING && (modifyType != ModifyType.ROUND || !z3)) {
                            return;
                        } else {
                            if (i == 1001) {
                                if (calendar.get(5) == 1) {
                                    calendar.add(5, 15);
                                    return;
                                }
                                calendar.add(5, -15);
                                calendar.add(2, 1);
                                return;
                            } else if (i != 9) {
                                calendar.add(iArr2[0], 1);
                                return;
                            } else if (calendar.get(11) == 0) {
                                calendar.add(11, 12);
                                return;
                            } else {
                                calendar.add(11, -12);
                                calendar.add(5, 1);
                                return;
                            }
                        }
                    }
                }
                if (i != 9) {
                    if (i == 1001 && iArr2[0] == 5) {
                        int i7 = calendar.get(5) - 1;
                        if (i7 >= 15) {
                            i7 -= 15;
                        }
                        z3 = i7 > 7;
                        i2 = i7;
                        z = true;
                        if (!z) {
                            c = 0;
                            int actualMinimum = calendar.getActualMinimum(iArr2[0]);
                            int actualMaximum = calendar.getActualMaximum(iArr2[0]);
                            int i8 = calendar.get(iArr2[0]) - actualMinimum;
                            z3 = i8 > (actualMaximum - actualMinimum) / 2;
                            i2 = i8;
                        } else {
                            c = 0;
                        }
                        if (i2 != 0) {
                            calendar.set(iArr2[c], calendar.get(iArr2[c]) - i2);
                        }
                    }
                } else if (iArr2[0] == 11) {
                    int i9 = calendar.get(11);
                    if (i9 >= 12) {
                        i9 -= 12;
                    }
                    z3 = i9 >= 6;
                    i2 = i9;
                    z = true;
                    if (!z) {
                    }
                    if (i2 != 0) {
                    }
                }
                z = false;
                i2 = 0;
                if (!z) {
                }
                if (i2 != 0) {
                }
            }
            throw new IllegalArgumentException("The field " + i + " is not supported");
        }
    }

    public static Date parseDate(String str, String... strArr) throws ParseException {
        return parseDate(str, null, strArr);
    }

    public static Date parseDateStrictly(String str, String... strArr) throws ParseException {
        return parseDateStrictly(str, null, strArr);
    }

    private static Date parseDateWithLeniency(String str, Locale locale, String[] strArr, boolean z) throws ParseException {
        if (str == null || strArr == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        TimeZone timeZone = TimeZone.getDefault();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Calendar instance = Calendar.getInstance(timeZone, locale);
        instance.setLenient(z);
        for (String str2 : strArr) {
            FastDateParser fastDateParser = new FastDateParser(str2, timeZone, locale);
            instance.clear();
            try {
                if (fastDateParser.parse(str, parsePosition, instance) && parsePosition.getIndex() == str.length()) {
                    return instance.getTime();
                }
            } catch (IllegalArgumentException unused) {
            }
            parsePosition.setIndex(0);
        }
        throw new ParseException("Unable to parse the date: " + str, -1);
    }

    public static Date round(Date date, int i) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        modify(instance, i, ModifyType.ROUND);
        return instance.getTime();
    }

    private static Date set(Date date, int i, int i2) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setLenient(false);
        instance.setTime(date);
        instance.set(i, i2);
        return instance.getTime();
    }

    public static Date setDays(Date date, int i) {
        return set(date, 5, i);
    }

    public static Date setHours(Date date, int i) {
        return set(date, 11, i);
    }

    public static Date setMilliseconds(Date date, int i) {
        return set(date, 14, i);
    }

    public static Date setMinutes(Date date, int i) {
        return set(date, 12, i);
    }

    public static Date setMonths(Date date, int i) {
        return set(date, 2, i);
    }

    public static Date setSeconds(Date date, int i) {
        return set(date, 13, i);
    }

    public static Date setYears(Date date, int i) {
        return set(date, 1, i);
    }

    public static Calendar toCalendar(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance;
    }

    public static Date truncate(Date date, int i) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        modify(instance, i, ModifyType.TRUNCATE);
        return instance.getTime();
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i) {
        return truncate(calendar, i).compareTo(truncate(calendar2, i));
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i) {
        return truncatedCompareTo(calendar, calendar2, i) == 0;
    }

    private static void validateDateNotNull(Date date) {
        Validate.isTrue(date != null, "The date must not be null", new Object[0]);
    }

    public static long getFragmentInDays(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.SECONDS);
    }

    public static Date parseDate(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, true);
    }

    public static Date parseDateStrictly(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, false);
    }

    public static boolean truncatedEquals(Date date, Date date2, int i) {
        return truncatedCompareTo(date, date2, i) == 0;
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.getTime().getTime() == calendar2.getTime().getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar toCalendar(Date date, TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(date);
        return instance;
    }

    public static int truncatedCompareTo(Date date, Date date2, int i) {
        return truncate(date, i).compareTo(truncate(date2, i));
    }

    private static long getFragment(Calendar calendar, int i, TimeUnit timeUnit) {
        long j;
        if (calendar != null) {
            long j2 = 0;
            TimeUnit timeUnit2 = TimeUnit.DAYS;
            int i2 = timeUnit == timeUnit2 ? 0 : 1;
            if (i != 1) {
                if (i == 2) {
                    j = timeUnit.convert((long) (calendar.get(5) - i2), timeUnit2);
                }
                if (i != 1 || i == 2 || i == 5 || i == 6) {
                    j2 += timeUnit.convert((long) calendar.get(11), TimeUnit.HOURS);
                } else {
                    switch (i) {
                        case 11:
                            break;
                        case 12:
                            j2 += timeUnit.convert((long) calendar.get(13), TimeUnit.SECONDS);
                            break;
                        case 13:
                            break;
                        case 14:
                            return j2;
                        default:
                            throw new IllegalArgumentException("The fragment " + i + " is not supported");
                    }
                    return j2 + timeUnit.convert((long) calendar.get(14), TimeUnit.MILLISECONDS);
                }
                j2 += timeUnit.convert((long) calendar.get(12), TimeUnit.MINUTES);
                j2 += timeUnit.convert((long) calendar.get(13), TimeUnit.SECONDS);
                return j2 + timeUnit.convert((long) calendar.get(14), TimeUnit.MILLISECONDS);
            }
            j = timeUnit.convert((long) (calendar.get(6) - i2), timeUnit2);
            j2 = 0 + j;
            if (i != 1) {
            }
            j2 += timeUnit.convert((long) calendar.get(11), TimeUnit.HOURS);
            j2 += timeUnit.convert((long) calendar.get(12), TimeUnit.MINUTES);
            j2 += timeUnit.convert((long) calendar.get(13), TimeUnit.SECONDS);
            return j2 + timeUnit.convert((long) calendar.get(14), TimeUnit.MILLISECONDS);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Iterator<Calendar> iterator(Calendar calendar, int i) {
        int i2;
        Calendar calendar2;
        Calendar calendar3;
        if (calendar != null) {
            int i3 = 2;
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    calendar3 = truncate(calendar, 5);
                    calendar2 = truncate(calendar, 5);
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                i2 = calendar.get(7) + 3;
                                i3 = calendar.get(7) - 3;
                                break;
                            } else {
                                i2 = 7;
                                i3 = 1;
                                break;
                            }
                        } else {
                            i3 = calendar.get(7);
                            i2 = i3 - 1;
                            break;
                        }
                    }
                    i2 = 1;
                    break;
                case 5:
                case 6:
                    Calendar truncate = truncate(calendar, 2);
                    Calendar calendar4 = (Calendar) truncate.clone();
                    calendar4.add(2, 1);
                    calendar4.add(5, -1);
                    if (i != 6) {
                        calendar2 = calendar4;
                        i3 = 1;
                        calendar3 = truncate;
                        i2 = 7;
                        break;
                    } else {
                        calendar2 = calendar4;
                        calendar3 = truncate;
                        i2 = 1;
                        break;
                    }
                default:
                    throw new IllegalArgumentException("The range style " + i + " is not valid.");
            }
            if (i3 < 1) {
                i3 += 7;
            }
            if (i3 > 7) {
                i3 -= 7;
            }
            if (i2 < 1) {
                i2 += 7;
            }
            if (i2 > 7) {
                i2 -= 7;
            }
            while (calendar3.get(7) != i3) {
                calendar3.add(5, -1);
            }
            while (calendar2.get(7) != i2) {
                calendar2.add(5, 1);
            }
            return new DateIterator(calendar3, calendar2);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar ceiling(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, ModifyType.CEILING);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar round(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, ModifyType.ROUND);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar truncate(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, ModifyType.TRUNCATE);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date ceiling(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return ceiling((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return ceiling((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not find ceiling of for type: " + obj.getClass());
        }
    }

    public static Date round(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return round((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return round((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not round " + obj);
        }
    }

    public static Date truncate(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return truncate((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return truncate((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not truncate " + obj);
        }
    }

    public static Iterator<?> iterator(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return iterator((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return iterator((Calendar) obj, i);
            }
            throw new ClassCastException("Could not iterate based on " + obj);
        }
    }
}
