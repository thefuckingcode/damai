package com.loc;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.alipay.sdk.m.u.c;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.playerservice.axp.utils.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONObject;
import tb.x53;

/* compiled from: Taobao */
public final class m1 {
    private static int a;
    private static String[] b;
    static WifiManager c;
    private static String d;

    public static int A(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            i |= (bArr[i2] & 255) << ((1 - i2) * 8);
        }
        return i;
    }

    public static long B() {
        return SystemClock.elapsedRealtime();
    }

    private static FileInputStream C(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    public static String D(Context context) {
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(j1.j)) {
            return j1.j;
        }
        CharSequence charSequence = null;
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(l.g(context), 64);
        } catch (Throwable th) {
            j1.h(th, Utils.TAG, "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(j1.k)) {
                j1.k = null;
            }
        } catch (Throwable th2) {
            j1.h(th2, Utils.TAG, "getAppName");
        }
        StringBuilder sb = new StringBuilder();
        if (packageInfo != null) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                charSequence = applicationInfo.loadLabel(context.getPackageManager());
            }
            if (charSequence != null) {
                sb.append(charSequence.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb.append(packageInfo.versionName);
            }
        }
        String g = l.g(context);
        if (!TextUtils.isEmpty(g)) {
            sb.append(",");
            sb.append(g);
        }
        if (!TextUtils.isEmpty(j1.k)) {
            sb.append(",");
            sb.append(j1.k);
        }
        String sb2 = sb.toString();
        j1.j = sb2;
        return sb2;
    }

    public static ArrayList<String> E(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains(",nb") || split[i].contains(",access")) {
                    arrayList.add(split[i]);
                }
            }
        }
        return arrayList;
    }

    public static boolean F(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 256);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean G(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }

    public static byte[] H(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    public static double I(double d2) {
        return ((double) ((long) (d2 * 100.0d))) / 100.0d;
    }

    public static double J(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    public static int K() {
        int i = a;
        if (i > 0) {
            return i;
        }
        try {
            return k1.g("android.os.Build$VERSION", "SDK_INT");
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static NetworkInfo L(Context context) {
        try {
            return o.b0(context);
        } catch (Throwable th) {
            j1.h(th, Utils.TAG, "getNetWorkInfo");
            return null;
        }
    }

    private static FileOutputStream M(File file) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                if (parentFile.mkdirs() || parentFile.isDirectory()) {
                    file.createNewFile();
                } else {
                    throw new IOException("Directory '" + parentFile + "' could not be created");
                }
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file, false);
    }

    public static boolean N(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                if (context == null || context.checkSelfPermission(v1.v(str)) != 0) {
                    return false;
                }
            } else if (context == null || context.checkCallingOrSelfPermission(v1.v(str)) != 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static float O(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    public static int P() {
        return new Random().nextInt(65536) - 32768;
    }

    public static boolean Q(Context context) {
        try {
            NetworkInfo L = L(context);
            return L != null && L.isConnectedOrConnecting();
        } catch (Throwable unused) {
        }
    }

    private static boolean R(Context context, String str) throws Throwable {
        return ((Integer) k1.e(str, "getInt", new Object[]{context.getContentResolver(), ((String) k1.d(str, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static int S(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static String T() {
        try {
            return p1.f("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean U(Context context) {
        int i;
        if (Build.VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
            for (String str : ej.O) {
                if (context.checkCallingOrSelfPermission(str) == 0) {
                }
            }
            return true;
        }
        Application application = (Application) context;
        for (String str2 : ej.O) {
            try {
                i = k1.f(application.getBaseContext(), "checkSelfPermission", str2);
            } catch (Throwable unused) {
                i = 0;
            }
            if (i == 0) {
            }
        }
        return true;
        return false;
    }

    public static int V(String str) throws NumberFormatException {
        return Integer.parseInt(str, 16);
    }

    public static boolean W(Context context) {
        int i;
        if (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) {
            return true;
        }
        try {
            i = k1.f(((Application) context).getBaseContext(), "checkSelfPermission", ej.P);
        } catch (Throwable unused) {
            i = 0;
        }
        return i == 0;
    }

    public static byte X(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    @SuppressLint({"NewApi"})
    public static boolean Y(Context context) {
        boolean z;
        if (context == null) {
            return true;
        }
        if (c == null) {
            c = (WifiManager) h(context, "wifi");
        }
        try {
            if (N(context, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                z = c.isWifiEnabled();
                if (z && K() > 17) {
                    try {
                        return "true".equals(String.valueOf(k1.c(c, "isScanAlwaysAvailable", new Object[0])));
                    } catch (Throwable unused) {
                        return z;
                    }
                }
            } else {
                j1.h(new Exception("n_aws"), "OPENSDK_UTS", "iwfal_n_aws");
                z = false;
                return z ? z : z;
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static String Z(Context context) {
        NetworkInfo L = L(context);
        if (L == null || !L.isConnectedOrConnecting()) {
            return "DISCONNECTED";
        }
        int type = L.getType();
        if (type == 1) {
            return "WIFI";
        }
        if (type != 0) {
            return "UNKNOWN";
        }
        String subtypeName = L.getSubtypeName();
        switch (L.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                break;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
                return "4G";
            default:
                if (!"GSM".equalsIgnoreCase(subtypeName)) {
                    return ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) ? "3G" : subtypeName;
                }
                break;
        }
        return "2G";
    }

    public static double a(double d2) {
        return z(d2);
    }

    private static boolean a0(String str) {
        try {
            return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER().equalsIgnoreCase(str) || com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND().toLowerCase().contains(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static float b(float f) {
        return (float) (((double) ((long) (((double) f) * 100.0d))) / 100.0d);
    }

    public static String b0(Context context) {
        String W = o.W(context);
        if (TextUtils.isEmpty(W) || W.equals(c.b)) {
            W = x53.d(context);
        }
        return TextUtils.isEmpty(W) ? c.b : W;
    }

    public static float c(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return e(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static boolean c0(Context context) {
        return Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static float d(DPoint dPoint, DPoint dPoint2) {
        return e(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    public static boolean d0(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (Throwable unused) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }

    public static float e(double[] dArr) {
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static String e0(Context context) {
        if (d == null) {
            d = e1.b(MessageDigestAlgorithms.MD5, l.g(context));
        }
        return d;
    }

    public static int f(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static boolean f0(Context context) {
        try {
            return h0(context) || g0(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static long g() {
        return System.currentTimeMillis();
    }

    private static boolean g0(Context context) {
        return a0("vivo") && i0(context) && j0(context);
    }

    public static Object h(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            j1.h(th, Utils.TAG, "getServ");
            return null;
        }
    }

    private static boolean h0(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 31 && context != null && context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String i(int i) {
        if (i == 33) {
            return "补偿定位失败，未命中缓存";
        }
        switch (i) {
            case 0:
                return "success";
            case 1:
                return "重要参数为空";
            case 2:
                return "WIFI信息不足";
            case 3:
                return "请求参数获取出现异常";
            case 4:
                return "网络连接异常";
            case 5:
                return "解析数据异常";
            case 6:
                return "定位结果错误";
            case 7:
                return "KEY错误";
            case 8:
                return "其他错误";
            case 9:
                return "初始化异常";
            case 10:
                return "定位服务启动失败";
            case 11:
                return "错误的基站信息，请检查是否插入SIM卡";
            case 12:
                return "缺少定位权限";
            case 13:
                return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
            case 14:
                return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
            case 15:
                return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
            default:
                switch (i) {
                    case 18:
                        return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
                    case 19:
                        return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
                    case 20:
                        return "模糊定位失败，具体可查看错误信息/详细信息描述";
                    default:
                        return "其他错误";
                }
        }
    }

    private static boolean i0(Context context) {
        try {
            int i = Build.VERSION.SDK_INT;
            int i2 = context.getApplicationInfo().targetSdkVersion;
            return ((i == 30) && (i2 >= 23)) || ((i == 31) && (i2 <= 30 && i2 >= 23));
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    public static String j(long j, String str) {
        SimpleDateFormat simpleDateFormat;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat2 = null;
        try {
            simpleDateFormat = new SimpleDateFormat(str, Locale.CHINA);
            try {
                simpleDateFormat.applyPattern(str);
            } catch (Throwable th2) {
                th = th2;
                simpleDateFormat2 = simpleDateFormat;
            }
        } catch (Throwable th3) {
            th = th3;
            j1.h(th, Utils.TAG, "formatUTC");
            simpleDateFormat = simpleDateFormat2;
            if (j <= 0) {
            }
            if (simpleDateFormat != null) {
            }
        }
        if (j <= 0) {
            j = g();
        }
        return simpleDateFormat != null ? "NULL" : simpleDateFormat.format(Long.valueOf(j));
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0045  */
    private static boolean j0(Context context) {
        Cursor cursor;
        boolean z = false;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"), new String[]{"package_name", "selected_fuzzy"}, "package_name=?", new String[]{context.getPackageName()}, null);
            boolean z2 = false;
            while (cursor != null) {
                try {
                    if (!cursor.moveToNext()) {
                        break;
                    } else if (cursor.getString(0) != null && cursor.getInt(1) == 1) {
                        z2 = true;
                    }
                } catch (Throwable unused) {
                    z = z2;
                    if (cursor != null) {
                    }
                    return z;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return z2;
        } catch (Throwable unused2) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            return z;
        }
    }

    public static String k(Context context, TelephonyManager telephonyManager) {
        int i = 0;
        if (telephonyManager != null) {
            try {
                if (context.getApplicationInfo().targetSdkVersion < 29 && Build.VERSION.SDK_INT < 30) {
                    i = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(telephonyManager);
                }
            } catch (Throwable unused) {
            }
        }
        switch (i) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKWN";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034 A[Catch:{ IOException -> 0x0038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003c A[Catch:{ IOException -> 0x0038 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0041 A[Catch:{ IOException -> 0x0038 }] */
    public static List<String> l(File file) {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = C(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, Charset.defaultCharset());
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null) {
                                arrayList.add(readLine);
                            } else {
                                try {
                                    break;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (Throwable unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            return arrayList;
                        }
                    }
                    bufferedReader2.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                } catch (Throwable unused2) {
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    return arrayList;
                }
            } catch (Throwable unused3) {
                inputStreamReader = null;
                if (bufferedReader != null) {
                }
                if (inputStreamReader != null) {
                }
                if (fileInputStream != null) {
                }
                return arrayList;
            }
        } catch (Throwable unused4) {
            fileInputStream = null;
            inputStreamReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return arrayList;
        }
        return arrayList;
    }

    public static void m(File file, String str) {
        OutputStream outputStream = null;
        try {
            FileOutputStream M = M(file);
            if (str != null) {
                M.write(str.getBytes());
            }
            try {
                M.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean n(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return K() < 17 ? R(context, "android.provider.Settings$System") : R(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean o(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = "2.0.201501131131".replace(".", "");
        Cursor cursor = null;
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    Cursor query = sQLiteDatabase.query("sqlite_master", new String[]{"count(*) as c"}, "type = 'table' AND name = '" + str.trim() + replace + "'", null, null, null, null);
                    if (query != null && query.moveToFirst() && query.getInt(0) > 0) {
                        z = true;
                    }
                    if (query != null) {
                        query.close();
                    }
                    return z;
                }
            } catch (Throwable unused) {
                if (0 == 0) {
                    return true;
                }
                cursor.close();
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0010 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0011  */
    public static boolean p(Location location, int i) {
        boolean z;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    z = location.isFromMockProvider();
                } catch (Throwable unused) {
                }
                if (!z) {
                    return true;
                }
                Bundle extras = location.getExtras();
                if ((extras != null ? extras.getInt("satellites") : 0) <= 0) {
                    return true;
                }
                return i == 0 && com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getAltitude(location) == 0.0d && location.getBearing() == 0.0f && location.getSpeed() == 0.0f;
            }
            z = false;
            if (!z) {
            }
        } catch (Throwable unused2) {
        }
    }

    public static boolean q(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return G(aMapLocation);
        }
        return false;
    }

    public static boolean r(eo eoVar) {
        if (eoVar != null && !"8".equals(eoVar.d()) && !"5".equals(eoVar.d()) && !"6".equals(eoVar.d())) {
            return G(eoVar);
        }
        return false;
    }

    public static boolean s(String str) {
        return !TextUtils.isEmpty(str) && !c.b.equals(str) && !"02:00:00:00:00:00".equals(str) && !str.contains(" :");
    }

    public static boolean t(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList<String> E = E(str);
            String[] split = str2.toString().split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < split.length; i3++) {
                if (split[i3].contains(",nb") || split[i3].contains(",access")) {
                    i++;
                    if (E.contains(split[i3])) {
                        i2++;
                    }
                }
            }
            if (((double) (i2 * 2)) >= ((double) (E.size() + i)) * 0.618d) {
                return true;
            }
        }
        return false;
    }

    public static boolean u(JSONObject jSONObject, String str) {
        return v1.n(jSONObject, str);
    }

    public static byte[] v(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        return bArr;
    }

    public static byte[] w(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
        }
        return bArr;
    }

    public static byte[] x(byte[] bArr) {
        return v1.u(bArr);
    }

    public static String[] y(TelephonyManager telephonyManager) {
        int i;
        String[] strArr;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr2 = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                i2++;
            }
            strArr2[1] = networkOperator.substring(3, i2 + 3);
        }
        try {
            i = Integer.parseInt(strArr2[0]);
        } catch (Throwable th) {
            j1.h(th, Utils.TAG, "getMccMnc");
            i = 0;
        }
        if (i == 0) {
            strArr2[0] = "0";
        }
        if ("0".equals(strArr2[0]) || "0".equals(strArr2[1])) {
            return (!"0".equals(strArr2[0]) || !"0".equals(strArr2[1]) || (strArr = b) == null) ? strArr2 : strArr;
        }
        b = strArr2;
        return strArr2;
    }

    public static double z(double d2) {
        return ((double) ((long) (d2 * 1000000.0d))) / 1000000.0d;
    }
}
