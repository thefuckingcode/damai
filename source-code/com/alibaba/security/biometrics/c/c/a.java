package com.alibaba.security.biometrics.c.c;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

/* compiled from: Taobao */
public final class a {
    public static final int a = 65536;

    public static boolean a(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    private static int[] b(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return iArr;
        }
    }

    public static void a(Window window) {
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
                Object newInstance = cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes);
                cls.getMethod("addHwFlags", Integer.TYPE).invoke(newInstance, 65536);
            } catch (Exception unused) {
            }
        }
    }
}
