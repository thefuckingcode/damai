package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.concurrent.TimeUnit;
import tb.ds1;

@GwtCompatible
/* compiled from: Taobao */
public final class g {
    private final j a = j.b();
    private boolean b;
    private long c;
    private long d;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[TimeUnit.values().length];
            a = iArr;
            iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            a[TimeUnit.SECONDS.ordinal()] = 4;
            a[TimeUnit.MINUTES.ordinal()] = 5;
            a[TimeUnit.HOURS.ordinal()] = 6;
            try {
                a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    g() {
    }

    private static String a(TimeUnit timeUnit) {
        switch (a.a[timeUnit.ordinal()]) {
            case 1:
                return NotificationStyle.NOTIFICATION_STYLE;
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    private static TimeUnit b(long j) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j, timeUnit2) > 0) {
            return timeUnit;
        }
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        if (timeUnit3.convert(j, timeUnit2) > 0) {
            return timeUnit3;
        }
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        if (timeUnit4.convert(j, timeUnit2) > 0) {
            return timeUnit4;
        }
        TimeUnit timeUnit5 = TimeUnit.SECONDS;
        if (timeUnit5.convert(j, timeUnit2) > 0) {
            return timeUnit5;
        }
        TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(j, timeUnit2) > 0) {
            return timeUnit6;
        }
        TimeUnit timeUnit7 = TimeUnit.MICROSECONDS;
        return timeUnit7.convert(j, timeUnit2) > 0 ? timeUnit7 : timeUnit2;
    }

    public static g c() {
        return new g().g();
    }

    public static g d() {
        return new g();
    }

    private long f() {
        return this.b ? (this.a.a() - this.d) + this.c : this.c;
    }

    public long e(TimeUnit timeUnit) {
        return timeUnit.convert(f(), TimeUnit.NANOSECONDS);
    }

    @CanIgnoreReturnValue
    public g g() {
        ds1.x(!this.b, "This stopwatch is already running.");
        this.b = true;
        this.d = this.a.a();
        return this;
    }

    @CanIgnoreReturnValue
    public g h() {
        long a2 = this.a.a();
        ds1.x(this.b, "This stopwatch is already stopped.");
        this.b = false;
        this.c += a2 - this.d;
        return this;
    }

    public String toString() {
        long f = f();
        TimeUnit b2 = b(f);
        double convert = ((double) f) / ((double) TimeUnit.NANOSECONDS.convert(1, b2));
        return f.b(convert) + " " + a(b2);
    }
}
