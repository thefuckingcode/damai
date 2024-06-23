package com.taobao.android.dinamic.log;

import android.util.Log;
import com.taobao.android.dinamic.a;
import tb.ry;

/* compiled from: Taobao */
public class DinamicLog {
    public static boolean a;

    public static void a(String str, String... strArr) {
        Log.d(str, f(strArr));
    }

    public static void b(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    public static void c(String str, Throwable th, String... strArr) {
        Log.e(str, f(strArr), th);
    }

    public static void d(String str, String... strArr) {
        Log.e(str, f(strArr));
    }

    public static void e(String str, String... strArr) {
        Log.i(str, f(strArr));
    }

    private static String f(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        if (strArr.length == 1) {
            return strArr[0];
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void g(String str, String str2, long j) {
        a.h().d();
    }

    public static void h(String str) {
        if (a) {
            a(ry.TAG, str);
        }
    }

    public static void i(String str, Throwable th, String... strArr) {
        Log.w(str, f(strArr), th);
    }

    public static void j(String str, String... strArr) {
        Log.w(str, f(strArr));
    }
}
