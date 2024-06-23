package com.taobao.uikit.utils;

import android.app.Application;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class UIKITLog {
    public static boolean isDebuggable = isDebuggable();

    public static void d(String str, String str2, Object... objArr) {
        if (isDebuggable) {
            Log.d(str, formatString(str2, objArr));
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        Log.e(str, formatString(str2, objArr));
    }

    private static String formatString(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        if (isDebuggable) {
            Log.i(str, formatString(str2, objArr));
        }
    }

    public static boolean isDebuggable() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            if ((((Application) declaredField.get(declaredMethod.invoke(null, new Object[0]))).getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (isDebuggable) {
            Log.v(str, formatString(str2, objArr));
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (isDebuggable) {
            Log.w(str, formatString(str2, objArr));
        }
    }
}
