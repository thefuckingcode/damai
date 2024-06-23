package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: AppUtil */
public class b {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";

    private static String a(String str) {
        return str == null ? "" : str;
    }

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String a(Context context, String str) {
        String str2;
        try {
            try {
                return String.valueOf(Integer.toHexString(Integer.parseInt(String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str)))));
            } catch (Exception unused) {
                return str2;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static void b(Context context, String str) {
        Log.d("0816", "saveGuid guid is " + str);
        try {
            TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_GUID, str);
            instance.commit();
        } catch (Exception unused) {
        }
    }

    public static String c(Context context) {
        String str = "";
        try {
            str = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_GUID, str);
        } catch (Exception unused) {
        }
        Log.d("0816", "getGuid guid is " + str);
        return str;
    }

    public static String d(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String e(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|5|6|(7:7|8|9|10|(1:12)(1:13)|14|15)|16|17|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
        if (r3 == null) goto L_0x0068;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0044 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0060 A[SYNTHETIC, Splitter:B:26:0x0060] */
    public static String a() {
        String str;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    if (bufferedReader.readLine().contains("x86")) {
                        str = a("i686");
                    } else {
                        str = a(System.getProperty("os.arch"));
                    }
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        str = a(System.getProperty("os.arch"));
                        th.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (Throwable th3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
                str = a(System.getProperty("os.arch"));
                th.printStackTrace();
                if (bufferedReader != null) {
                }
            }
        } catch (Throwable th5) {
            inputStreamReader = null;
            th = th5;
            bufferedReader = null;
            str = a(System.getProperty("os.arch"));
            th.printStackTrace();
            if (bufferedReader != null) {
            }
        }
        inputStreamReader.close();
        return str;
    }

    public static String f(Context context) {
        WifiInfo wifiInfo;
        String str;
        if (TextUtils.isEmpty(d)) {
            if (Build.VERSION.SDK_INT < 23) {
                try {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                    if (wifiManager == null) {
                        wifiInfo = null;
                    } else {
                        wifiInfo = wifiManager.getConnectionInfo();
                    }
                    if (wifiInfo == null) {
                        str = "";
                    } else {
                        str = wifiInfo.getMacAddress();
                    }
                    d = str;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                d = b();
            }
        }
        return d;
    }

    public static String b() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception unused) {
            return "02:00:00:00:00:00";
        }
    }

    public static String g(Context context) {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        try {
            e = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0066 A[Catch:{ all -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    public static String a(Context context, boolean z, File file) {
        String a2;
        Throwable th;
        Exception e2;
        RandomAccessFile randomAccessFile;
        if (file == null || !file.exists()) {
            return "";
        }
        if (z) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                byte[] bArr = new byte[2];
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    randomAccessFile.read(bArr);
                    if (!new String(bArr).equalsIgnoreCase("PK")) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return "";
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    try {
                        e2.printStackTrace();
                        randomAccessFile.close();
                        if (context.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
                        }
                        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
                        a2 = a(context, file, false);
                        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=" + a2);
                        if (a2 == null) {
                        }
                        if (a2 != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile2 = randomAccessFile;
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                        throw th;
                    }
                }
            } catch (Exception e7) {
                randomAccessFile = null;
                e2 = e7;
                e2.printStackTrace();
                randomAccessFile.close();
                if (context.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
                }
                TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
                a2 = a(context, file, false);
                TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=" + a2);
                if (a2 == null) {
                }
                if (a2 != null) {
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile2.close();
                throw th;
            }
        }
        try {
            if (context.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
                TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #1");
                String a3 = a(file);
                if (a3 != null) {
                    TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #2");
                    return a3;
                }
            }
        } catch (Throwable unused) {
            TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #3");
        }
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
        a2 = a(context, file, false);
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=" + a2);
        if (a2 == null) {
            a2 = a(file);
            TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  java get signature=" + a2);
        }
        if (a2 != null) {
            return a2;
        }
        String a4 = a(context, file, true);
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android reflection signature=" + a4);
        return a4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035 A[Catch:{ Exception -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    private static String a(Context context, File file, boolean z) {
        PackageInfo packageInfo;
        Signature signature;
        if (z) {
            try {
                packageInfo = a(file.getAbsolutePath(), 65);
            } catch (Exception unused) {
                TbsLog.i("AppUtil", "getSign " + file + "failed");
                return null;
            }
        } else {
            packageInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 65);
        }
        if (packageInfo != null) {
            if (packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
            } else {
                signature = packageInfo.signatures[0];
                if (signature == null) {
                    return signature.toCharsString();
                }
                return null;
            }
        }
        signature = null;
        if (signature == null) {
        }
    }

    private static String a(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            byte[] bArr = new byte[8192];
            String a2 = a(a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), bArr)[0].getEncoded());
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (name != null) {
                    Certificate[] a3 = a(jarFile, nextElement, bArr);
                    String a4 = a3 != null ? a(a3[0].getEncoded()) : null;
                    if (a4 == null) {
                        if (!name.startsWith("META-INF/")) {
                            return null;
                        }
                    } else if (!a4.equals(a2)) {
                        return null;
                    }
                }
            }
            return a2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static PackageInfo a(String str, int i) {
        Class<?> cls;
        try {
            Class<?> cls2 = Class.forName("android.content.pm.PackageParser");
            Class<?>[] declaredClasses = cls2.getDeclaredClasses();
            int length = declaredClasses.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    cls = null;
                    break;
                }
                cls = declaredClasses[i2];
                if (cls.getName().compareTo("android.content.pm.PackageParser$Package") == 0) {
                    break;
                }
                i2++;
            }
            Constructor<?> constructor = cls2.getConstructor(String.class);
            Method declaredMethod = cls2.getDeclaredMethod("parsePackage", File.class, String.class, DisplayMetrics.class, Integer.TYPE);
            Method declaredMethod2 = cls2.getDeclaredMethod("collectCertificates", cls, Integer.TYPE);
            Method declaredMethod3 = cls2.getDeclaredMethod("generatePackageInfo", cls, int[].class, Integer.TYPE, Long.TYPE, Long.TYPE);
            constructor.setAccessible(true);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            declaredMethod3.setAccessible(true);
            Object newInstance = constructor.newInstance(str);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            Object invoke = declaredMethod.invoke(newInstance, new File(str), str, displayMetrics, 0);
            if (invoke == null) {
                return null;
            }
            if ((i & 64) != 0) {
                declaredMethod2.invoke(newInstance, invoke, 0);
            }
            return (PackageInfo) declaredMethod3.invoke(null, invoke, null, Integer.valueOf(i), 0, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) throws Exception {
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, bArr.length) != -1);
        inputStream.close();
        if (jarEntry != null) {
            return jarEntry.getCertificates();
        }
        return null;
    }

    private static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            byte b2 = bArr[i];
            int i2 = (b2 >> 4) & 15;
            int i3 = i * 2;
            cArr[i3] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            int i4 = b2 & 15;
            cArr[i3 + 1] = (char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
        }
        return new String(cArr);
    }

    public static boolean c() {
        Class<?> cls;
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        try {
            if (Build.VERSION.SDK_INT < 21 || (cls = Class.forName("dalvik.system.VMRuntime")) == null || (declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0])) == null || (invoke = declaredMethod.invoke(null, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0])) == null) {
                return false;
            }
            Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
            if (invoke2 instanceof Boolean) {
                return ((Boolean) invoke2).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
