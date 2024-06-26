package com.youku.android.liveservice.utils;

import android.util.Log;

/* compiled from: Taobao */
public class Logger {
    public static boolean DEBUG = true;
    public static boolean ERROR = true;
    public static boolean INFO = true;
    public static int LOGLEVEL = 5;
    public static String TAG = "LivePlayer";
    public static boolean VERBOSE = true;
    public static boolean WARN = true;

    public static void d(String str, String str2) {
        if (DEBUG) {
            if (str2 == null) {
                str2 = "";
            }
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
            if (str2 == null) {
                str2 = "";
            }
            Log.e(str, str2);
        }
    }

    public static void setDebugMode(boolean z) {
        boolean z2 = false;
        int i = z ? 5 : 0;
        LOGLEVEL = i;
        VERBOSE = i > 4;
        DEBUG = i > 3;
        INFO = i > 2;
        WARN = i > 1;
        if (i > 0) {
            z2 = true;
        }
        ERROR = z2;
    }

    public static void v(String str, String str2) {
        if (DEBUG) {
            if (str2 == null) {
                str2 = "";
            }
            Log.v(str, str2);
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

    public static void v(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (str2 == null) {
                str2 = "";
            }
            Log.v(str, str2, th);
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

    public static void v(String str) {
        if (DEBUG) {
            String str2 = TAG;
            if (str == null) {
                str = "";
            }
            Log.v(str2, str);
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

    public static void v(String str, Throwable th) {
        if (DEBUG) {
            String str2 = TAG;
            if (str == null) {
                str = "";
            }
            Log.v(str2, str, th);
        }
    }
}
