package com.alibaba.security.biometrics.c.c;

import android.content.Context;
import android.view.Window;
import com.alibaba.security.common.c.a;
import com.uc.crashsdk.export.LogType;

/* compiled from: Taobao */
public class c {
    public static final int a = 256;
    public static final int b = 512;
    public static final int c = 1024;
    private static final String d = "c";

    public static boolean a(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            if (((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0)).intValue() == 1) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            a.b();
            return false;
        }
    }

    public static void a(Window window) {
        try {
            Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(window, Integer.valueOf((int) LogType.UNEXP_OTHER));
        } catch (Exception unused) {
        }
    }
}
