package com.alipay.sdk.m.a0;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.alibaba.motu.crashreporter.Constants;
import com.alibaba.security.common.track.model.a;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alipay.sdk.m.z.a;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import mtopsdk.mtop.intf.Mtop;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.gl1;
import tb.jl1;

/* compiled from: Taobao */
public final class b {
    public static b j = new b();
    public long a = 0;
    public long b = 0;
    public long c = 0;
    public long d = 0;
    public long e = 0;
    public String f;
    public String g;
    public String h;
    public String i;

    public static boolean a(long j2) {
        return System.currentTimeMillis() - j2 < DateUtils.MILLIS_PER_HOUR;
    }

    public static boolean a(Context context, String str) {
        return !(context.getPackageManager().checkPermission(str, context.getPackageName()) == 0);
    }

    public static b b() {
        return j;
    }

    public static String c() {
        long j2;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j2 = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            j2 = 0;
        }
        return String.valueOf(j2);
    }

    public static String d() {
        long j2;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j2 = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
                return String.valueOf(j2);
            }
        } catch (Throwable unused) {
        }
        j2 = 0;
        return String.valueOf(j2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0061, code lost:
        if (r2 != null) goto L_0x0063;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0049 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0063 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055 A[SYNTHETIC, Splitter:B:29:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005c A[SYNTHETIC, Splitter:B:33:0x005c] */
    public static String e() {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        String str = "0000000000000000";
        LineNumberReader lineNumberReader = null;
        try {
            fileInputStream = new FileInputStream(new File("/proc/cpuinfo"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
            } catch (Throwable unused) {
                inputStreamReader = null;
                if (lineNumberReader != null) {
                }
                if (inputStreamReader != null) {
                }
            }
            try {
                LineNumberReader lineNumberReader2 = new LineNumberReader(inputStreamReader);
                int i2 = 1;
                while (true) {
                    if (i2 < 100) {
                        try {
                            String readLine = lineNumberReader2.readLine();
                            if (readLine != null) {
                                if (readLine.indexOf("Serial") >= 0) {
                                    str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                                    break;
                                }
                                i2++;
                            }
                        } catch (Throwable unused2) {
                            lineNumberReader = lineNumberReader2;
                            if (lineNumberReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                        }
                    }
                }
            } catch (Throwable unused3) {
                if (lineNumberReader != null) {
                }
                if (inputStreamReader != null) {
                }
            }
        } catch (Throwable unused4) {
            fileInputStream = null;
            inputStreamReader = null;
            if (lineNumberReader != null) {
                try {
                    lineNumberReader.close();
                } catch (Throwable unused5) {
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Throwable unused6) {
                }
            }
        }
        try {
            fileInputStream.close();
        } catch (Throwable unused7) {
        }
        return str == null ? "" : str;
    }

    public static String e(Context context) {
        int i2 = 0;
        try {
            i2 = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Throwable unused) {
        }
        return i2 == 1 ? "1" : "0";
    }

    public static String f() {
        String u = u();
        return !a.a(u) ? u : v();
    }

    public static String f(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int i2 = audioManager.getRingerMode() == 0 ? 1 : 0;
            int streamVolume = audioManager.getStreamVolume(0);
            int streamVolume2 = audioManager.getStreamVolume(1);
            int streamVolume3 = audioManager.getStreamVolume(2);
            int streamVolume4 = audioManager.getStreamVolume(3);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("ringermode", String.valueOf(i2));
            jSONObject.put("call", String.valueOf(streamVolume));
            jSONObject.put("system", String.valueOf(streamVolume2));
            jSONObject.put("ring", String.valueOf(streamVolume3));
            jSONObject.put("music", String.valueOf(streamVolume4));
            jSONObject.put(NotificationCompat.CATEGORY_ALARM, String.valueOf(streamVolume5));
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0023 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0038 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0031 A[SYNTHETIC, Splitter:B:26:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    public static String g() {
        BufferedReader bufferedReader;
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2);
                try {
                    String[] split = bufferedReader.readLine().split(":\\s+", 2);
                    if (split == null || split.length <= 1) {
                        fileReader2.close();
                        try {
                            bufferedReader.close();
                            return "";
                        } catch (Throwable unused) {
                            return "";
                        }
                    } else {
                        String str = split[1];
                        fileReader2.close();
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused2) {
                        }
                        return str;
                    }
                } catch (Throwable unused3) {
                    fileReader = fileReader2;
                    if (fileReader != null) {
                    }
                    if (bufferedReader == null) {
                    }
                    bufferedReader.close();
                    return "";
                }
            } catch (Throwable unused4) {
                bufferedReader = null;
                fileReader = fileReader2;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused5) {
                    }
                }
                if (bufferedReader == null) {
                    return "";
                }
                bufferedReader.close();
                return "";
            }
        } catch (Throwable unused6) {
            bufferedReader = null;
            if (fileReader != null) {
            }
            if (bufferedReader == null) {
            }
            bufferedReader.close();
            return "";
        }
    }

    public static String g(Context context) {
        String str;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getNetworkOperatorName();
                    return (str != null || "null".equals(str)) ? "" : str;
                }
            } catch (Throwable unused) {
            }
        }
        str = null;
        if (str != null) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        if (r0 == null) goto L_0x0039;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002f A[SYNTHETIC, Splitter:B:19:0x002f] */
    public static String h() {
        BufferedReader bufferedReader;
        FileReader fileReader = null;
        long j2 = 0;
        try {
            FileReader fileReader2 = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader2, 8192);
            } catch (Throwable unused) {
                bufferedReader = null;
                fileReader = fileReader2;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused2) {
                    }
                }
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    j2 = (long) Integer.parseInt(readLine.split("\\s+")[1]);
                }
                fileReader2.close();
            } catch (Throwable unused3) {
                fileReader = fileReader2;
                if (fileReader != null) {
                }
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
            if (fileReader != null) {
            }
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused5) {
        }
        return String.valueOf(j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    public static String h(Context context) {
        String str;
        List<Sensor> sensorList;
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (!(sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0)) {
                    StringBuilder sb = new StringBuilder();
                    for (Sensor sensor : sensorList) {
                        sb.append(sensor.getName());
                        sb.append(sensor.getVersion());
                        sb.append(sensor.getVendor());
                    }
                    str = a.e(sb.toString());
                    return str != null ? "" : str;
                }
            } catch (Throwable unused) {
            }
        }
        str = null;
        if (str != null) {
        }
    }

    public static String i() {
        long j2;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j2 = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            j2 = 0;
        }
        return String.valueOf(j2);
    }

    public static String i(Context context) {
        List<Sensor> sensorList;
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (!(sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0)) {
                    for (Sensor sensor : sensorList) {
                        if (sensor != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("name", sensor.getName());
                            jSONObject.put("version", sensor.getVersion());
                            jSONObject.put("vendor", sensor.getVendor());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONArray.toString();
    }

    public static String j() {
        long j2;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j2 = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
                return String.valueOf(j2);
            }
        } catch (Throwable unused) {
        }
        j2 = 0;
        return String.valueOf(j2);
    }

    public static String j(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Integer.toString(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics)) + jl1.MUL + Integer.toString(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String k() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String k(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics));
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String l() {
        String str;
        try {
            str = Locale.getDefault().toString();
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String l(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String m() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String m(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String n() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            StringBuilder sb = new StringBuilder();
            sb.append(currentTimeMillis - (currentTimeMillis % 1000));
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String n(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? String.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(telephonyManager)) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String o() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    public static String o(Context context) {
        String str;
        int i2 = context.getApplicationInfo().targetSdkVersion;
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                str = "";
                return str != null ? "" : str;
            }
            str = (i3 < 26 || i2 < 28) ? com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getSERIAL() : com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getSerial();
            if (str != null) {
            }
        } catch (Throwable unused) {
        }
    }

    public static String p() {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
            sb.append("00" + ":");
            for (int i2 = 0; i2 < 7; i2++) {
                sb.append(new File(strArr[i2]).exists() ? "1" : "0");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String p(Context context) {
        try {
            long j2 = 0;
            if (!((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure()) {
                return "0:0";
            }
            String[] strArr = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};
            for (int i2 = 0; i2 < 5; i2++) {
                long j3 = -1;
                try {
                    j3 = new File(strArr[i2]).lastModified();
                } catch (Throwable unused) {
                }
                j2 = Math.max(j3, j2);
            }
            return "1:" + j2;
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String q() {
        String[] strArr = {"dalvik.system.Taint"};
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(":");
        for (int i2 = 0; i2 <= 0; i2++) {
            try {
                Class.forName(strArr[0]);
                sb.append("1");
            } catch (Throwable unused) {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
    public static String q(Context context) {
        boolean z;
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("status", -1);
            if (intExtra2 != 2) {
                if (intExtra2 != 5) {
                    z = false;
                    StringBuilder sb = new StringBuilder();
                    sb.append(!z ? "1" : "0");
                    sb.append(":");
                    sb.append(intExtra);
                    return sb.toString();
                }
            }
            z = true;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(!z ? "1" : "0");
            sb2.append(":");
            sb2.append(intExtra);
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003b A[SYNTHETIC] */
    public static String r() {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("/system/build.prop", "ro.product.name=sdk");
        linkedHashMap.put("/proc/tty/drivers", "goldfish");
        linkedHashMap.put("/proc/cpuinfo", "goldfish");
        sb.append("00" + ":");
        for (String str : linkedHashMap.keySet()) {
            LineNumberReader lineNumberReader = null;
            char c2 = YKUpsConvert.CHAR_ZERO;
            try {
                LineNumberReader lineNumberReader2 = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String readLine = lineNumberReader2.readLine();
                        if (readLine != null) {
                            if (readLine.toLowerCase().contains((CharSequence) linkedHashMap.get(str))) {
                                c2 = '1';
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (Throwable unused) {
                        lineNumberReader = lineNumberReader2;
                        sb.append(YKUpsConvert.CHAR_ZERO);
                        if (lineNumberReader == null) {
                            lineNumberReader.close();
                        }
                    }
                }
                sb.append(c2);
                try {
                    lineNumberReader2.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                sb.append(YKUpsConvert.CHAR_ZERO);
                if (lineNumberReader == null) {
                }
            }
        }
        return sb.toString();
    }

    public static String r(Context context) {
        if (a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return "";
        }
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0) {
                return null;
            }
            int subtype = activeNetworkInfo.getSubtype();
            return (subtype == 4 || subtype == 1 || subtype == 2 || subtype == 7 || subtype == 11) ? "2G" : (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : "UNKNOW";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String s() {
        StringBuilder sb = new StringBuilder();
        sb.append("00" + ":");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Constants.BRAND, "generic");
        linkedHashMap.put("BOARD", "unknown");
        linkedHashMap.put("DEVICE", "generic");
        linkedHashMap.put("HARDWARE", "goldfish");
        linkedHashMap.put(Mtop.Id.PRODUCT, a.C0103a.a);
        linkedHashMap.put("MODEL", a.C0103a.a);
        for (String str : linkedHashMap.keySet()) {
            char c2 = YKUpsConvert.CHAR_ZERO;
            try {
                String str2 = null;
                String str3 = (String) Build.class.getField(str).get(null);
                String str4 = (String) linkedHashMap.get(str);
                if (str3 != null) {
                    str2 = str3.toLowerCase();
                }
                if (str2 != null && str2.contains(str4)) {
                    c2 = '1';
                }
            } catch (Throwable unused) {
            }
            sb.append(c2);
        }
        return sb.toString();
    }

    public static String t() {
        StringBuilder sb = new StringBuilder();
        sb.append("00" + ":");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", a.C0103a.a);
        linkedHashMap.put("ro.product.brand", "generic");
        linkedHashMap.put("ro.product.name", a.C0103a.a);
        linkedHashMap.put("ro.build.fingerprint", "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str : linkedHashMap.keySet()) {
            char c2 = YKUpsConvert.CHAR_ZERO;
            String str2 = (String) linkedHashMap.get(str);
            String b2 = com.alipay.sdk.m.z.a.b(str, "");
            if (b2 != null && b2.contains(str2)) {
                c2 = '1';
            }
            sb.append(c2);
        }
        return sb.toString();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0020 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x002f A[SYNTHETIC, Splitter:B:23:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    public static String u() {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                try {
                    String readLine = bufferedReader2.readLine();
                    if (!com.alipay.sdk.m.z.a.a(readLine)) {
                        String trim = readLine.trim();
                        bufferedReader2.close();
                        try {
                            fileReader.close();
                        } catch (Throwable unused) {
                        }
                        return trim;
                    }
                    bufferedReader2.close();
                    try {
                        fileReader.close();
                        return "";
                    } catch (Throwable unused2) {
                        return "";
                    }
                } catch (Throwable unused3) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    if (fileReader == null) {
                        return "";
                    }
                    fileReader.close();
                    return "";
                }
            } catch (Throwable unused5) {
                if (bufferedReader != null) {
                }
                if (fileReader == null) {
                }
                fileReader.close();
                return "";
            }
        } catch (Throwable unused6) {
            fileReader = null;
            if (bufferedReader != null) {
            }
            if (fileReader == null) {
            }
            fileReader.close();
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0049, code lost:
        if (r0 == null) goto L_0x004e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x004b */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0044 A[SYNTHETIC, Splitter:B:26:0x0044] */
    public static String v() {
        BufferedReader bufferedReader;
        String[] split;
        String str = "";
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2, 8192);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (!com.alipay.sdk.m.z.a.a(readLine) && (split = readLine.split(":")) != null && split.length > 1 && split[0].contains("BogoMIPS")) {
                                str = split[1].trim();
                                break;
                            }
                        }
                    } catch (Throwable unused) {
                        fileReader = fileReader2;
                        if (fileReader != null) {
                        }
                    }
                }
            } catch (Throwable unused2) {
                bufferedReader = null;
                fileReader = fileReader2;
                if (fileReader != null) {
                }
            }
        } catch (Throwable unused3) {
            bufferedReader = null;
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Throwable unused4) {
                }
            }
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused5) {
        }
        return str;
    }

    private String w() {
        String str;
        if (a(this.e) && (str = this.i) != null) {
            return str;
        }
        this.i = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements() && this.i == null) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        break;
                    }
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        this.i = nextElement.getHostAddress().toString();
                        break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if (this.i == null) {
            this.i = "";
        }
        this.e = System.currentTimeMillis();
        return this.i;
    }

    public final String a() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new c(this)).length);
        } catch (Throwable unused) {
            return "1";
        }
    }

    public final synchronized String a(Context context) {
        String str;
        if (a(this.b) && (str = this.g) != null) {
            return str;
        }
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    this.g = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDeviceId(telephonyManager);
                }
            } catch (Throwable unused) {
            }
        }
        if (this.g == null) {
            this.g = "";
        }
        this.b = System.currentTimeMillis();
        return this.g;
    }

    public final synchronized String b(Context context) {
        String str;
        if (a(this.a) && (str = this.f) != null) {
            return str;
        }
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    this.f = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSubscriberId(telephonyManager);
                }
            } catch (Throwable unused) {
            }
        }
        if (this.f == null) {
            this.f = "";
        }
        this.a = System.currentTimeMillis();
        return this.f;
    }

    public final synchronized String c(Context context) {
        String str;
        if (a(this.c) && (str = this.h) != null) {
            return str;
        }
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            String simSerialNumber = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimSerialNumber((TelephonyManager) context.getSystemService("phone"));
            this.h = simSerialNumber;
            if (simSerialNumber == null || simSerialNumber.length() == 0) {
                this.h = "";
            }
        } catch (Throwable unused) {
        }
        this.c = System.currentTimeMillis();
        return this.h;
    }

    public final String d(Context context) {
        try {
            String r = r(context);
            String w = w();
            if (com.alipay.sdk.m.z.a.b(r) && com.alipay.sdk.m.z.a.b(w)) {
                return r + ":" + w();
            }
        } catch (Throwable unused) {
        }
        return "";
    }
}
