package com.youku.usercenter.passport.util;

import android.util.Log;

/* compiled from: Taobao */
public final class Logger {
    public static final boolean DEBUG_DEBUG = true;
    public static final boolean DEBUG_ERROR = true;
    public static final boolean DEBUG_EXCEPT = true;
    public static final boolean DEBUG_INFO = true;
    public static final boolean DEBUG_PERFORMANCE = true;
    public static final boolean DEBUG_VERBOSE = true;
    public static final boolean DEBUG_WARN = true;
    public static final String LOG_TAG = "PassportSDK";
    private static boolean sDebug = true;
    private static boolean sDebugPerformance;

    /* access modifiers changed from: package-private */
    /* renamed from: com.youku.usercenter.passport.util.Logger$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel = iArr;
            iArr[LogLevel.DEBUG.ordinal()] = 1;
            $SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel[LogLevel.ERROR.ordinal()] = 2;
            $SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel[LogLevel.INFO.ordinal()] = 3;
            $SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel[LogLevel.VERBOSE.ordinal()] = 4;
            $SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel[LogLevel.WARN.ordinal()] = 5;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum LogLevel {
        DEBUG,
        ERROR,
        INFO,
        VERBOSE,
        WARN
    }

    private Logger() {
    }

    public static void d(String str, String str2) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, str, str2, null);
        }
    }

    private static void doLog(LogLevel logLevel, String str, String str2, Throwable th) {
        if (str2 == null) {
            str2 = "";
        }
        int i = AnonymousClass1.$SwitchMap$com$youku$usercenter$passport$util$Logger$LogLevel[logLevel.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            if (th == null) {
                                Log.w(str, str2);
                            } else {
                                Log.w(str, str2, th);
                            }
                        }
                    } else if (th == null) {
                        Log.v(str, str2);
                    } else {
                        Log.v(str, str2, th);
                    }
                } else if (th == null) {
                    Log.i(str, str2);
                } else {
                    Log.i(str, str2, th);
                }
            } else if (th == null) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, th);
            }
        } else if (th == null) {
            Log.d(str, str2);
        } else {
            Log.d(str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        doLog(LogLevel.ERROR, str, str2, null);
    }

    public static void i(String str, String str2) {
        if (sDebug) {
            doLog(LogLevel.INFO, str, str2, null);
        }
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static boolean isDebugPerformance() {
        return sDebugPerformance;
    }

    public static void p(String str) {
        if (sDebug || sDebugPerformance) {
            doLog(LogLevel.INFO, LOG_TAG, str, null);
        }
    }

    public static void printInvokeTrace(String str) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (int i = 1; i < stackTrace.length; i++) {
            d(str + ":  " + stackTrace[i].toString());
        }
    }

    public static void printStackTrace(Throwable th) {
        if (sDebug) {
            th.printStackTrace();
        }
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static void setDebugPerformance(boolean z) {
        sDebugPerformance = z;
    }

    public static void v(String str, String str2) {
        if (sDebug) {
            doLog(LogLevel.VERBOSE, str, str2, null);
        }
    }

    public static void w(String str) {
        if (sDebug) {
            doLog(LogLevel.WARN, LOG_TAG, str, null);
        }
    }

    public static void e(String str) {
        doLog(LogLevel.ERROR, LOG_TAG, str, null);
    }

    public static void d(String str) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, LOG_TAG, str, null);
        }
    }

    public static void e(String str, Throwable th) {
        doLog(LogLevel.ERROR, LOG_TAG, str, th);
    }

    public static void i(String str) {
        if (sDebug) {
            doLog(LogLevel.INFO, LOG_TAG, str, null);
        }
    }

    public static void p(String str, String str2) {
        if (sDebug || sDebugPerformance) {
            doLog(LogLevel.INFO, str, str2, null);
        }
    }

    public static void v(String str) {
        if (sDebug) {
            doLog(LogLevel.VERBOSE, LOG_TAG, str, null);
        }
    }

    public static void w(String str, String str2) {
        if (sDebug) {
            doLog(LogLevel.WARN, str, str2, null);
        }
    }

    public static void printInvokeTrace(String str, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i, stackTrace.length);
        for (int i2 = 1; i2 < min; i2++) {
            d(str + ":  " + stackTrace[i2].toString());
        }
    }

    public static void d(String str, Throwable th) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, LOG_TAG, str, th);
        }
    }

    public static void i(String str, Throwable th) {
        if (sDebug) {
            doLog(LogLevel.INFO, LOG_TAG, str, th);
        }
    }

    public static void v(String str, Throwable th) {
        if (sDebug) {
            doLog(LogLevel.VERBOSE, LOG_TAG, str, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (sDebug) {
            doLog(LogLevel.WARN, str, str2, th);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, str, str2, th);
        }
    }

    public static void w(String str, Throwable th) {
        if (sDebug) {
            doLog(LogLevel.WARN, LOG_TAG, str, th);
        }
    }
}
