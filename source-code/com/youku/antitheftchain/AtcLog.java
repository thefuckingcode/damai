package com.youku.antitheftchain;

import android.util.Log;

/* compiled from: Taobao */
public class AtcLog {
    public static final String PREFIX = "Atc_";
    public static boolean enableDebug = false;
    public static boolean enableError = true;
    public static boolean enableInfo = true;
    public static boolean enableWarning = true;

    /* renamed from: com.youku.antitheftchain.AtcLog$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$antitheftchain$AtcLog$LogLevel;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$youku$antitheftchain$AtcLog$LogLevel = iArr;
            iArr[LogLevel.info.ordinal()] = 1;
            $SwitchMap$com$youku$antitheftchain$AtcLog$LogLevel[LogLevel.debug.ordinal()] = 2;
            $SwitchMap$com$youku$antitheftchain$AtcLog$LogLevel[LogLevel.warning.ordinal()] = 3;
            try {
                $SwitchMap$com$youku$antitheftchain$AtcLog$LogLevel[LogLevel.error.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public enum LogLevel {
        error,
        warning,
        debug,
        info
    }

    public static void d(String str, String str2) {
        if (enableDebug) {
            Log.d(PREFIX + str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (enableDebug) {
            Log.d(PREFIX + str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        if (enableError) {
            Log.e(PREFIX + str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (enableError) {
            Log.e(PREFIX + str, str2, th);
        }
    }

    public static void i(String str, String str2) {
        if (enableInfo) {
            Log.i(PREFIX + str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (enableInfo) {
            Log.i(PREFIX + str, str2, th);
        }
    }

    public static void setLogLevel(LogLevel logLevel) {
        enableInfo = false;
        enableError = false;
        enableWarning = false;
        enableDebug = false;
        int i = AnonymousClass1.$SwitchMap$com$youku$antitheftchain$AtcLog$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            enableInfo = true;
        } else if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    enableError = true;
                    enableWarning = true;
                    enableDebug = true;
                    return;
                }
                enableError = true;
            }
            enableWarning = true;
            enableError = true;
        }
        enableDebug = true;
        enableWarning = true;
        enableError = true;
    }

    public static void w(String str, String str2) {
        if (enableWarning) {
            Log.w(PREFIX + str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (enableWarning) {
            Log.w(PREFIX + str, str2, th);
        }
    }
}
