package com.taobao.weex.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXConfigAdapter;
import com.taobao.weex.common.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
public class WXUtils {
    public static final char PERCENT = '%';
    static final LruCache<String, Integer> a = new LruCache<>(64);
    private static final long b = (System.currentTimeMillis() - SystemClock.uptimeMillis());

    private static int a(String str, int i) {
        int indexOf = str.indexOf(StringUtils.CR, i);
        if (indexOf == -1) {
            indexOf = str.indexOf(StringUtils.LF, i);
        }
        return indexOf == -1 ? str.indexOf(SocketClient.NETASCII_EOL, i) : indexOf;
    }

    private static int b(String str, int i) {
        return (int) ((Float.parseFloat(str) / 100.0f) * ((float) i));
    }

    private static String[] c(String str) {
        String[] split = str.split(StringUtils.CR);
        if (split.length == 1) {
            split = str.split(StringUtils.LF);
        }
        return split.length == 1 ? str.split(SocketClient.NETASCII_EOL) : split;
    }

    public static boolean checkGreyConfig(String str, String str2, String str3) {
        IWXConfigAdapter J = WXSDKManager.v().J();
        if (J == null) {
            return false;
        }
        double d = 100.0d;
        double random = Math.random() * 100.0d;
        try {
            d = Double.valueOf(J.getConfig(str, str2, str3)).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (random < d) {
            return true;
        }
        return false;
    }

    private static float d(String str, int i) {
        if (str == null) {
            return 0.0f;
        }
        if (str.endsWith(BQCCameraParam.FOCUS_TYPE_WX)) {
            str = str.substring(0, str.indexOf(BQCCameraParam.FOCUS_TYPE_WX));
        }
        return ((WXEnvironment.sApplication.getResources().getDisplayMetrics().density * Float.valueOf(Float.parseFloat(str)).floatValue()) * ((float) i)) / ((float) WXViewUtils.getScreenWidth());
    }

    public static float fastGetFloat(String str, int i) {
        boolean z;
        int i2;
        char charAt;
        char charAt2;
        float f = 0.0f;
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        int i3 = 0;
        if (str.charAt(0) == '-') {
            i2 = 1;
            z = false;
        } else {
            i2 = str.charAt(0) == '+' ? 1 : 0;
            z = true;
        }
        while (i2 < str.length() && (charAt2 = str.charAt(i2)) >= '0' && charAt2 <= '9') {
            f = ((f * 10.0f) + ((float) charAt2)) - 48.0f;
            i2++;
        }
        if (i2 < str.length() && str.charAt(i2) == '.') {
            int i4 = i2 + 1;
            int i5 = 10;
            while (i4 < str.length() && i3 < i && (charAt = str.charAt(i4)) >= '0' && charAt <= '9') {
                f += ((float) (charAt - '0')) / ((float) i5);
                i5 *= 10;
                i4++;
                i3++;
            }
        }
        return !z ? f * -1.0f : f;
    }

    public static long getAvailMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        WXLogUtils.w("app AvailMemory ---->>>" + (memoryInfo.availMem / 1048576));
        return memoryInfo.availMem / 1048576;
    }

    public static Boolean getBoolean(@Nullable Object obj, @Nullable Boolean bool) {
        if (obj == null) {
            return bool;
        }
        if (TextUtils.equals("false", obj.toString())) {
            return Boolean.FALSE;
        }
        return TextUtils.equals("true", obj.toString()) ? Boolean.TRUE : bool;
    }

    public static String getBundleBanner(String str) {
        int i;
        int a2;
        int indexOf = str.indexOf("/*!");
        if (indexOf == -1 || (a2 = a(str, (i = indexOf + 3))) == -1) {
            return null;
        }
        int i2 = a2 + 1;
        String substring = str.substring(i2, Integer.parseInt(str.substring(i, a2)) + i2);
        int lastIndexOf = substring.lastIndexOf("!*/");
        if (lastIndexOf == -1) {
            return null;
        }
        String substring2 = substring.substring(0, lastIndexOf);
        StringBuilder sb = new StringBuilder();
        for (String str2 : c(substring2)) {
            sb.append(str2.replaceFirst("\\*", ""));
        }
        return sb.toString();
    }

    @Deprecated
    public static double getDouble(Object obj) {
        if (obj == null) {
            return 0.0d;
        }
        String trim = obj.toString().trim();
        if (trim.endsWith(BQCCameraParam.FOCUS_TYPE_WX)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.w("the value of " + obj + " use wx unit, which will be not supported soon after.");
            }
            try {
                return (double) d(trim, FeatureFactory.PRIORITY_ABOVE_NORMAL);
            } catch (NumberFormatException e) {
                WXLogUtils.e("Argument format error! value is " + obj, e);
                return 0.0d;
            } catch (Exception e2) {
                WXLogUtils.e("Argument error! value is " + obj, e2);
                return 0.0d;
            }
        } else if (trim.endsWith("px")) {
            try {
                return Double.parseDouble(trim.substring(0, trim.indexOf("px")));
            } catch (NumberFormatException e3) {
                WXLogUtils.e("Argument format error! value is " + obj, e3);
                return 0.0d;
            } catch (Exception e4) {
                WXLogUtils.e("Argument error! value is " + obj, e4);
                return 0.0d;
            }
        } else {
            try {
                return Double.parseDouble(trim);
            } catch (NumberFormatException e5) {
                WXLogUtils.e("Argument format error! value is " + obj, e5);
                return 0.0d;
            } catch (Exception e6) {
                WXLogUtils.e("Argument error! value is " + obj, e6);
                return 0.0d;
            }
        }
    }

    public static long getFixUnixTime() {
        return b + SystemClock.uptimeMillis();
    }

    public static float getFloat(Object obj) {
        return getFloat(obj, Float.valueOf(Float.NaN)).floatValue();
    }

    public static float getFloatByViewport(Object obj, int i) {
        if (obj == null) {
            return Float.NaN;
        }
        String trim = obj.toString().trim();
        if ("auto".equals(trim) || Constants.Name.UNDEFINED.equals(trim) || TextUtils.isEmpty(trim)) {
            WXLogUtils.e("Argument Warning ! value is " + trim + "And default Value:" + Float.NaN);
            return Float.NaN;
        } else if (trim.endsWith(BQCCameraParam.FOCUS_TYPE_WX)) {
            try {
                return d(trim, i);
            } catch (NumberFormatException e) {
                WXLogUtils.e("Argument format error! value is " + obj, e);
                return Float.NaN;
            } catch (Exception e2) {
                WXLogUtils.e("Argument error! value is " + obj, e2);
                return Float.NaN;
            }
        } else if (trim.endsWith("px")) {
            try {
                return Float.parseFloat(trim.substring(0, trim.indexOf("px")));
            } catch (NumberFormatException e3) {
                WXLogUtils.e("Argument format error! value is " + obj, e3);
                return Float.NaN;
            } catch (Exception e4) {
                WXLogUtils.e("Argument error! value is " + obj, e4);
                return Float.NaN;
            }
        } else {
            try {
                return Float.parseFloat(trim);
            } catch (NumberFormatException e5) {
                WXLogUtils.e("Argument format error! value is " + obj, e5);
                return Float.NaN;
            } catch (Exception e6) {
                WXLogUtils.e("Argument error! value is " + obj, e6);
                return Float.NaN;
            }
        }
    }

    public static int getInt(Object obj) {
        return getInteger(obj, 0).intValue();
    }

    @Nullable
    public static Integer getInteger(@Nullable Object obj, @Nullable Integer num) {
        Integer num2;
        if (obj == null) {
            return num;
        }
        String trim = obj.toString().trim();
        Integer num3 = a.get(trim);
        if (num3 != null) {
            return num3;
        }
        String substring = trim.length() >= 2 ? trim.substring(trim.length() - 2, trim.length()) : "";
        if (TextUtils.equals(BQCCameraParam.FOCUS_TYPE_WX, substring)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.w("the value of " + obj + " use wx unit, which will be not supported soon after.");
            }
            try {
                num2 = Integer.valueOf((int) d(trim, FeatureFactory.PRIORITY_ABOVE_NORMAL));
            } catch (NumberFormatException e) {
                WXLogUtils.e("Argument format error! value is " + obj, e);
            } catch (Exception e2) {
                WXLogUtils.e("Argument error! value is " + obj, e2);
            }
        } else if (TextUtils.equals("px", substring)) {
            try {
                String substring2 = trim.substring(0, trim.length() - 2);
                if (TextUtils.isEmpty(substring2) || !substring2.contains(".")) {
                    num2 = Integer.valueOf(Integer.parseInt(substring2));
                } else {
                    num2 = Integer.valueOf((int) parseFloat(substring2));
                }
            } catch (NumberFormatException e3) {
                WXLogUtils.e("Argument format error! value is " + obj, e3);
            } catch (Exception e4) {
                WXLogUtils.e("Argument error! value is " + obj, e4);
            }
        } else {
            try {
                if (TextUtils.isEmpty(trim)) {
                    if (WXEnvironment.isApkDebugable()) {
                        WXLogUtils.e("Argument value is null, df is" + num);
                    }
                    num2 = num;
                } else if (trim.contains(".")) {
                    num2 = Integer.valueOf((int) parseFloat(trim));
                } else {
                    num2 = Integer.valueOf(Integer.parseInt(trim));
                }
            } catch (NumberFormatException e5) {
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.w("The parameter format is not supported", e5);
                }
            } catch (Exception e6) {
                WXLogUtils.e("Argument error! value is " + obj, e6);
            }
        }
        if (num2 != null && !num2.equals(num)) {
            a.put(trim, num2);
        }
        return num2;
    }

    @Deprecated
    public static long getLong(Object obj) {
        if (obj == null) {
            return 0;
        }
        String trim = obj.toString().trim();
        if (trim.endsWith(BQCCameraParam.FOCUS_TYPE_WX)) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.w("the value of " + obj + " use wx unit, which will be not supported soon after.");
            }
            try {
                return (long) d(trim, FeatureFactory.PRIORITY_ABOVE_NORMAL);
            } catch (NumberFormatException e) {
                WXLogUtils.e("Argument format error! value is " + obj, e);
                return 0;
            } catch (Exception e2) {
                WXLogUtils.e("Argument error! value is " + obj, e2);
                return 0;
            }
        } else if (trim.endsWith("px")) {
            try {
                return Long.parseLong(trim.substring(0, trim.indexOf("px")));
            } catch (NumberFormatException e3) {
                WXLogUtils.e("Argument format error! value is " + obj, e3);
                return 0;
            } catch (Exception e4) {
                WXLogUtils.e("Argument error! value is " + obj, e4);
                return 0;
            }
        } else {
            try {
                return Long.parseLong(trim);
            } catch (NumberFormatException e5) {
                WXLogUtils.e("Argument format error! value is " + obj, e5);
                return 0;
            } catch (Exception e6) {
                WXLogUtils.e("Argument error! value is " + obj, e6);
                return 0;
            }
        }
    }

    public static int getNumberInt(Object obj, int i) {
        if (obj == null) {
            return i;
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        try {
            String obj2 = obj.toString();
            if (obj2.indexOf(46) >= 0) {
                return (int) Float.parseFloat(obj.toString());
            }
            return Integer.parseInt(obj2);
        } catch (Exception unused) {
            return i;
        }
    }

    public static String getString(@Nullable Object obj, @Nullable String str) {
        if (obj == null) {
            return str;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj.toString();
    }

    @Deprecated
    public static boolean isTabletDevice() {
        try {
            return (WXEnvironment.getApplication().getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isUiThread() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    public static boolean isUndefined(float f) {
        return Float.isNaN(f);
    }

    public static float parseFloat(Object obj) {
        return parseFloat(String.valueOf(obj));
    }

    public static int parseInt(String str) {
        try {
            if (TextUtils.isEmpty(str) || str.contains(".")) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            if (!WXEnvironment.isApkDebugable()) {
                return 0;
            }
            WXLogUtils.e(WXLogUtils.getStackTrace(e));
            return 0;
        }
    }

    public static int parseUnitOrPercent(String str, int i) {
        int lastIndexOf = str.lastIndexOf(37);
        if (lastIndexOf != -1) {
            return b(str.substring(0, lastIndexOf), i);
        }
        return parseInt(str);
    }

    public static Float getFloat(Object obj, @Nullable Float f) {
        if (obj == null) {
            return f;
        }
        String trim = obj.toString().trim();
        if ("auto".equals(trim) || Constants.Name.UNDEFINED.equals(trim) || TextUtils.isEmpty(trim)) {
            WXLogUtils.e("Argument Warning ! value is " + trim + "And default Value:" + Float.NaN);
            return f;
        } else if (trim.endsWith(BQCCameraParam.FOCUS_TYPE_WX)) {
            try {
                return Float.valueOf(d(trim, FeatureFactory.PRIORITY_ABOVE_NORMAL));
            } catch (NumberFormatException e) {
                WXLogUtils.e("Argument format error! value is " + obj, e);
                return f;
            } catch (Exception e2) {
                WXLogUtils.e("Argument error! value is " + obj, e2);
                return f;
            }
        } else if (trim.endsWith("px")) {
            try {
                return Float.valueOf(Float.parseFloat(trim.substring(0, trim.indexOf("px"))));
            } catch (NumberFormatException e3) {
                WXLogUtils.e("Argument format error! value is " + obj, e3);
                return f;
            } catch (Exception e4) {
                WXLogUtils.e("Argument error! value is " + obj, e4);
                return f;
            }
        } else {
            try {
                return Float.valueOf(Float.parseFloat(trim));
            } catch (NumberFormatException e5) {
                WXLogUtils.e("Argument format error! value is " + obj, e5);
                return f;
            } catch (Exception e6) {
                WXLogUtils.e("Argument error! value is " + obj, e6);
                return f;
            }
        }
    }

    public static float parseFloat(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "null")) {
                return Float.parseFloat(str);
            }
            if (!WXEnvironment.isApkDebugable()) {
                return 0.0f;
            }
            WXLogUtils.e("WXUtils parseFloat illegal value is " + str);
            return 0.0f;
        } catch (NumberFormatException e) {
            if (!WXEnvironment.isApkDebugable()) {
                return 0.0f;
            }
            WXLogUtils.e(WXLogUtils.getStackTrace(e));
            return 0.0f;
        }
    }

    public static int parseInt(Object obj) {
        return parseInt(String.valueOf(obj));
    }

    public static float fastGetFloat(String str) {
        return fastGetFloat(str, Integer.MAX_VALUE);
    }
}
