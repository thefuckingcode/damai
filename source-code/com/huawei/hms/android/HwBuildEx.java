package com.huawei.hms.android;

import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
public class HwBuildEx {

    /* compiled from: Taobao */
    public static class VERSION {
        public static final int EMUI_SDK_INT = HwBuildEx.getSystemPropertiesInt("ro.build.hw_emui_api_level", 0);
    }

    /* compiled from: Taobao */
    public static class VersionCodes {
        public static final int CUR_DEVELOPMENT = 10000;
        public static final int EMUI_10_0 = 21;
        public static final int EMUI_1_0 = 1;
        public static final int EMUI_1_5 = 2;
        public static final int EMUI_1_6 = 3;
        public static final int EMUI_2_0_JB = 4;
        public static final int EMUI_2_0_KK = 5;
        public static final int EMUI_2_3 = 6;
        public static final int EMUI_3_0 = 7;
        public static final int EMUI_3_0_5 = 8;
        public static final int EMUI_3_1 = 8;
        public static final int EMUI_4_0 = 9;
        public static final int EMUI_4_1 = 10;
        public static final int EMUI_5_0 = 11;
        public static final int EMUI_5_1 = 12;
        public static final int EMUI_5_1_b10x = 13;
        public static final int EMUI_5_1_b200 = 13;
        public static final int EMUI_6_0 = 14;
        public static final int EMUI_9_0 = 17;
        public static final int UNKNOWN_EMUI = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002e, code lost:
        android.util.Log.e("HwBuildEx", "An exception occurred while reading: EMUI_SDK_INT");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0035, code lost:
        return r8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:5:? A[ExcHandler: ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:1:0x0009] */
    public static int getSystemPropertiesInt(String str, int i) {
        Class<?> cls = Class.forName("android.os.SystemProperties");
        try {
            return ((Integer) cls.getDeclaredMethod("getInt", String.class, Integer.TYPE).invoke(cls, str, Integer.valueOf(i))).intValue();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }
}
