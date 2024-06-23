package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

/* compiled from: Taobao */
public abstract class s {
    public static final Object a = new Object();
    public static int b = -1;

    public static boolean a(Context context) {
        HMSLog.d("CommFun", "existFrameworkPush:" + b);
        try {
            File file = new File("/system/framework/" + "hwpush.jar");
            if (a()) {
                HMSLog.d("CommFun", "push jarFile is exist");
                return true;
            } else if (!file.isFile()) {
                return false;
            } else {
                HMSLog.d("CommFun", "push jarFile is exist");
                return true;
            }
        } catch (Exception e) {
            HMSLog.e("CommFun", "get Apk version faild ,Exception e= " + e.toString());
            return false;
        }
    }

    public static long b(Context context) {
        try {
            return (long) context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception unused) {
            HMSLog.e("CommFun", "get nc versionCode error");
            return -1;
        }
    }

    public static boolean c() {
        return HwBuildEx.VERSION.EMUI_SDK_INT < 19;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (1 != com.huawei.hms.push.s.b) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return false;
     */
    public static boolean d(Context context) {
        HMSLog.d("CommFun", "existFrameworkPush:" + b);
        synchronized (a) {
            int i = b;
            boolean z = false;
            if (-1 != i) {
                if (1 == i) {
                    z = true;
                }
                return z;
            } else if (a(context)) {
                b = 1;
            } else {
                b = 0;
            }
        }
    }

    public static String c(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }

    public static boolean b() {
        return HwBuildEx.VERSION.EMUI_SDK_INT >= 21;
    }

    public static boolean a() {
        try {
            Class<?> cls = Class.forName("huawei.cust.HwCfgFilePolicy");
            int intValue = ((Integer) cls.getDeclaredField("CUST_TYPE_CONFIG").get(cls)).intValue();
            File file = (File) cls.getDeclaredMethod("getCfgFile", String.class, Integer.TYPE).invoke(cls, "jars/hwpush.jar", Integer.valueOf(intValue));
            if (file != null && file.exists()) {
                HMSLog.d("CommFun", "get push cust File path success.");
                return true;
            }
        } catch (ClassNotFoundException unused) {
            HMSLog.e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
        } catch (SecurityException unused2) {
            HMSLog.e("CommFun", "check cust exist push SecurityException.");
        } catch (NoSuchFieldException unused3) {
            HMSLog.e("CommFun", "check cust exist push NoSuchFieldException.");
        } catch (NoSuchMethodException unused4) {
            HMSLog.e("CommFun", "check cust exist push NoSuchMethodException.");
        } catch (IllegalArgumentException unused5) {
            HMSLog.e("CommFun", "check cust exist push IllegalArgumentException.");
        } catch (IllegalAccessException unused6) {
            HMSLog.e("CommFun", "check cust exist push IllegalAccessException.");
        } catch (InvocationTargetException unused7) {
            HMSLog.e("CommFun", "check cust exist push InvocationTargetException.");
        }
        return false;
    }

    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        return jSONObject == null || (TextUtils.isEmpty(str) && jSONObject2 == null);
    }
}
