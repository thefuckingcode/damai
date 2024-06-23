package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.huawei.hms.aaid.utils.PushPreferences;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
public class u {
    public static boolean a(Context context) {
        if (new PushPreferences(context, "push_notify_flag").getBoolean("notify_msg_enable")) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return b(context);
        }
        if (i >= 19) {
            return b(context);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:6:? A[ExcHandler: ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:1:0x0024] */
    @SuppressLint({"NewApi", "InlinedApi"})
    public static boolean b(Context context) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        Class<?> cls = Class.forName(AppOpsManager.class.getName());
        try {
            Class<?> cls2 = Integer.TYPE;
            if (((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
        }
    }
}
