package com.uc.crashsdk.a;

import android.util.Log;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.b;
import com.uc.crashsdk.g;

/* compiled from: Taobao */
public final class a {
    public static void a(String str) {
        if (g.M()) {
            Log.d("crashsdk", str);
        }
    }

    public static void b(String str) {
        if (g.M()) {
            Log.w("crashsdk", str);
        }
    }

    public static void c(String str, String str2) {
        if (b.d) {
            JNIBridge.nativeLog(5, str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (b.d) {
            JNIBridge.nativeLog(6, str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public static void a(String str, String str2) {
        if (g.M()) {
            Log.i(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (b.d) {
            JNIBridge.nativeLog(4, str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (!g.M()) {
            return;
        }
        if (th == null) {
            Log.e(str, str2);
        } else {
            Log.e(str, str2, th);
        }
    }
}
