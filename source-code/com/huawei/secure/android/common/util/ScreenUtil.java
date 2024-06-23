package com.huawei.secure.android.common.util;

import android.app.Activity;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* compiled from: Taobao */
public class ScreenUtil {
    private static final String a = "ScreenUtil";
    private static final int b = 524288;

    /* compiled from: Taobao */
    private static class a implements PrivilegedAction {
        Method a;

        public a(Method method) {
            this.a = method;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            Method method = this.a;
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return null;
        }
    }

    private static void a(Activity activity, int i) {
        if (activity == null || activity.isFinishing()) {
            LogsUtil.e("", "activity is null");
        } else {
            activity.getWindow().addFlags(i);
        }
    }

    private static void b(Activity activity, int i) {
        if (activity == null || activity.isFinishing()) {
            LogsUtil.e("", "activity is null");
        } else {
            activity.getWindow().clearFlags(i);
        }
    }

    public static void disableScreenshots(Activity activity) {
        a(activity, 8192);
    }

    public static void enableScreenshots(Activity activity) {
        b(activity, 8192);
    }

    public static void hideOverlayWindows(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            try {
                Window window = activity.getWindow();
                Method declaredMethod = Class.forName("android.view.Window").getDeclaredMethod("addPrivateFlags", Integer.TYPE);
                AccessController.doPrivileged(new a(declaredMethod));
                declaredMethod.invoke(window, 524288);
            } catch (ClassNotFoundException unused) {
                LogsUtil.e(a, "hideOverlayWindows ClassNotFoundException");
            } catch (NoSuchMethodException unused2) {
                LogsUtil.e(a, "hideOverlayWindows NoSuchMethodException");
            } catch (InvocationTargetException unused3) {
                LogsUtil.e(a, "hideOverlayWindows InvocationTargetException");
            } catch (IllegalAccessException unused4) {
                LogsUtil.e(a, "hideOverlayWindows IllegalAccessException");
            }
        }
    }
}
