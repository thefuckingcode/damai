package com.youku.alixplayer.opensdk.utils;

import android.annotation.TargetApi;
import android.os.Looper;
import android.util.Log;

/* compiled from: Taobao */
public class Logger {
    public static boolean DEBUG = false;
    public static boolean ERROR = false;
    public static boolean INFO = false;
    public static int LOGLEVEL = 0;
    public static final String SYSTEM_PROP_KEY_LOG_LEVEL = "debug.aliplayer.loglevel";
    public static String TAG = "PLAYER";
    public static boolean VERBOSE;
    public static boolean WARN;

    public static void d(String str, String str2) {
        if (DEBUG) {
            Log.d(str, str2);
        }
    }

    public static void d_long(String str, String str2) {
        String str3;
        if (DEBUG) {
            String trim = str2.trim();
            int i = 0;
            while (i < trim.length()) {
                int i2 = i + 4000;
                if (trim.length() <= i2) {
                    str3 = trim.substring(i);
                } else {
                    str3 = trim.substring(i, i2);
                }
                d(str, str3.trim());
                i = i2;
            }
        }
    }

    public static void e(String str, String str2) {
        if (ERROR) {
            if (str.contains("PlayFlow")) {
                str2 = str2 + " --isMainthread:" + isMainThread();
            }
            if (str2 == null) {
                str2 = "";
            }
            Log.e(str, str2);
        }
    }

    public static boolean getDebugMode() {
        return getLogLevelCode() == 1;
    }

    private static int getLogLevelCode() {
        return SystemUtils.getInt(SYSTEM_PROP_KEY_LOG_LEVEL, 0);
    }

    @TargetApi(3)
    private static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void setDebugMode(boolean z) {
        boolean z2 = true;
        int i = z ? 5 : 1;
        LOGLEVEL = i;
        VERBOSE = i > 4;
        DEBUG = i > 3;
        INFO = i > 2;
        WARN = i > 1;
        if (i <= 0) {
            z2 = false;
        }
        ERROR = z2;
    }

    public static void v(String str, String str2) {
        if (DEBUG) {
            Log.v(str, str2);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (DEBUG) {
            Log.d(str, String.format(str2, objArr));
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (DEBUG) {
            Log.d(str, str2, th);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (str2 == null) {
                str2 = "";
            }
            Log.d(str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (ERROR) {
            if (str2 == null) {
                str2 = "";
            }
            Log.e(str, str2, th);
        }
    }

    public static void v(String str) {
        if (DEBUG) {
            Log.v(TAG, str);
        }
    }

    public static void d(String str) {
        if (DEBUG) {
            String str2 = TAG;
            if (str == null) {
                str = "";
            }
            Log.d(str2, str);
        }
    }

    public static void e(String str) {
        if (ERROR) {
            String str2 = TAG;
            if (str == null) {
                str = "";
            }
            Log.e(str2, str);
        }
    }

    public static void v(String str, Throwable th) {
        if (DEBUG) {
            Log.v(TAG, str, th);
        }
    }

    public static void d(String str, Throwable th) {
        if (DEBUG) {
            String str2 = TAG;
            if (str == null) {
                str = "";
            }
            Log.d(str2, str, th);
        }
    }

    public static void e(String str, Throwable th) {
        if (ERROR) {
            String str2 = TAG;
            if (str == null) {
                str = "";
            }
            Log.e(str2, str, th);
        }
    }
}
