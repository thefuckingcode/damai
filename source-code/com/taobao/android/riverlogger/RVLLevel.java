package com.taobao.android.riverlogger;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public enum RVLLevel {
    Off(0),
    Error(1),
    Warn(2),
    Info(3),
    Debug(4),
    Verbose(5);
    
    public final int value;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[RVLLevel.values().length];
            a = iArr;
            iArr[RVLLevel.Error.ordinal()] = 1;
            a[RVLLevel.Warn.ordinal()] = 2;
            a[RVLLevel.Info.ordinal()] = 3;
            try {
                a[RVLLevel.Debug.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private RVLLevel(int i) {
        this.value = i;
    }

    public String toString() {
        int i = a.a[ordinal()];
        if (i == 1) {
            return "error";
        }
        if (i == 2) {
            return "warn";
        }
        if (i != 3) {
            return i != 4 ? "verbose" : "debug";
        }
        return "info";
    }

    public static RVLLevel valueOf(int i) {
        if (i == 1) {
            return Error;
        }
        if (i == 2) {
            return Warn;
        }
        if (i == 3) {
            return Info;
        }
        if (i != 4) {
            return Verbose;
        }
        return Debug;
    }
}
