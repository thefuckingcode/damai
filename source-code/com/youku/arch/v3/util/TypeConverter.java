package com.youku.arch.v3.util;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class TypeConverter {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean parseBoolean(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "247632276")) {
            return parseBoolean(str, false);
        }
        return ((Boolean) ipChange.ipc$dispatch("247632276", new Object[]{str})).booleanValue();
    }

    public static double parseDouble(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1373694749")) {
            return parseDouble(str, 0.0d);
        }
        return ((Double) ipChange.ipc$dispatch("-1373694749", new Object[]{str})).doubleValue();
    }

    public static float parseFloat(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1148247564")) {
            return parseFloat(str, 0.0f);
        }
        return ((Float) ipChange.ipc$dispatch("1148247564", new Object[]{str})).floatValue();
    }

    public static int parseInt(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1261331300")) {
            return parseInt(str, 0);
        }
        return ((Integer) ipChange.ipc$dispatch("-1261331300", new Object[]{str})).intValue();
    }

    public static long parseLong(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-875949858")) {
            return parseLong(str, 0);
        }
        return ((Long) ipChange.ipc$dispatch("-875949858", new Object[]{str})).longValue();
    }

    public static Short parseShort(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1757785637")) {
            return Short.valueOf(parseShort(str, 0));
        }
        return (Short) ipChange.ipc$dispatch("1757785637", new Object[]{str});
    }

    public static boolean parseBoolean(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-913288376")) {
            return ((Boolean) ipChange.ipc$dispatch("-913288376", new Object[]{str, Boolean.valueOf(z)})).booleanValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            return Boolean.parseBoolean(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return z;
        }
    }

    public static double parseDouble(String str, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "365160919")) {
            return ((Double) ipChange.ipc$dispatch("365160919", new Object[]{str, Double.valueOf(d)})).doubleValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return d;
            }
            return Double.parseDouble(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return d;
        }
    }

    public static float parseFloat(String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1235963156")) {
            return ((Float) ipChange.ipc$dispatch("1235963156", new Object[]{str, Float.valueOf(f)})).floatValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return f;
            }
            return Float.parseFloat(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return f;
        }
    }

    public static int parseInt(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446534803")) {
            return ((Integer) ipChange.ipc$dispatch("-446534803", new Object[]{str, Integer.valueOf(i)})).intValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            return Integer.parseInt(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return i;
        }
    }

    public static long parseLong(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1384611058")) {
            return ((Long) ipChange.ipc$dispatch("-1384611058", new Object[]{str, Long.valueOf(j)})).longValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return j;
            }
            return Long.parseLong(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return j;
        }
    }

    public static short parseShort(String str, short s) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-411138034")) {
            return ((Short) ipChange.ipc$dispatch("-411138034", new Object[]{str, Short.valueOf(s)})).shortValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return s;
            }
            return Short.parseShort(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return s;
        }
    }
}
