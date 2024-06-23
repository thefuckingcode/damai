package com.amap.api.col.s;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.motu.crashreporter.Constants;
import com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.taobao.weex.annotation.JSMethod;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import tb.jl1;
import tb.v;

/* compiled from: Taobao */
public final class bo {
    private static String A = "";
    private static String B = "";
    private static boolean C = false;
    private static boolean D = false;
    private static String E = "";
    private static boolean F = false;
    private static boolean G = false;
    private static long H = 0;
    private static int I = 0;
    private static String J = null;
    private static String K = "";
    private static boolean L = true;
    private static boolean M = false;
    private static String N = "";
    private static boolean O = false;
    private static int P = -1;
    private static boolean Q = false;
    private static int R = -1;
    private static boolean S = false;
    private static volatile b T = null;
    static String a = "";
    static String b = "";
    static volatile boolean c = true;
    public static boolean d = false;
    static String e = "";
    static boolean f = false;
    public static a g = null;
    static int h = -1;
    static String i = "";
    static String j = "";
    private static String k = null;
    private static boolean l = false;
    private static volatile boolean m = false;
    private static String n = "";
    private static boolean o = false;
    private static boolean p = false;
    private static boolean q = false;
    private static String r = "";
    private static String s = "";
    private static boolean t = false;
    private static boolean u = false;
    private static String v = "";
    private static boolean w = false;
    private static String x = "";
    private static boolean y = false;
    private static String z = "";

    /* compiled from: Taobao */
    public interface a {
        df a(byte[] bArr, Map<String, String> map);

        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    /* compiled from: Taobao */
    public static class b {
        private static Context a;
        private static BroadcastReceiver b;
        private static ConnectivityManager c;
        private static NetworkRequest d;
        private static ConnectivityManager.NetworkCallback e;

        @SuppressLint({"WrongConstant"})
        public final void a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context != null && b == null) {
                    b = new BroadcastReceiver() {
                        /* class com.amap.api.col.s.bo.b.AnonymousClass1 */

                        public final void onReceive(Context context, Intent intent) {
                            if (bw.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                                bo.g();
                            }
                        }
                    };
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(bw.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                    context.registerReceiver(b, intentFilter);
                }
            } else if (bo.c(context, bw.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && c == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                c = connectivityManager;
                if (connectivityManager != null) {
                    d = new NetworkRequest.Builder().addCapability(0).addCapability(1).build();
                    AnonymousClass2 r0 = new ConnectivityManager.NetworkCallback() {
                        /* class com.amap.api.col.s.bo.b.AnonymousClass2 */

                        public final void onAvailable(Network network) {
                            super.onAvailable(network);
                            bo.g();
                        }

                        public final void onLost(Network network) {
                            super.onLost(network);
                            bo.g();
                        }
                    };
                    e = r0;
                    c.registerNetworkCallback(d, r0);
                    a = context;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c implements ServiceConnection {
        private static String a;
        private Context b;
        private int c;

        c(Context context, int i) {
            this.b = context;
            this.c = i;
        }

        private String a() {
            try {
                if (!TextUtils.isEmpty(a)) {
                    return a;
                }
                byte[] digest = MessageDigest.getInstance(bw.c("IU0hBMQ")).digest(this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64).signatures[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    stringBuffer.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                }
                String stringBuffer2 = stringBuffer.toString();
                if (!TextUtils.isEmpty(stringBuffer2)) {
                    a = stringBuffer2;
                }
                return stringBuffer2;
            } catch (Throwable unused) {
                return "";
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0050 A[Catch:{ all -> 0x0064, all -> 0x0077 }] */
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean z;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                int i = this.c;
                if (i == 2) {
                    obtain.writeInterfaceToken(bw.c("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U"));
                } else if (i == 4) {
                    obtain.writeInterfaceToken(bw.c("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ"));
                } else if (i != 5) {
                    z = false;
                    if (z) {
                        iBinder.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        String unused = bo.n = obtain2.readString();
                    }
                } else {
                    obtain.writeInterfaceToken(bw.c("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));
                    obtain.writeString(this.b.getPackageName());
                    obtain.writeString(a());
                    obtain.writeString(bw.c("IT1VJRA"));
                }
                z = true;
                if (z) {
                }
            } catch (Throwable th) {
                ci.a(th, "oac", String.valueOf(this.c));
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static String A(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(bw.c("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= columnCount) {
                            break;
                        } else if (bw.c("IdmFsdWU").equals(query.getColumnName(i2))) {
                            n = query.getString(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                query.close();
            }
        } catch (Throwable th) {
            o = true;
            ci.a(th, "oa", "vivo");
        }
        return n;
    }

    /* access modifiers changed from: private */
    public static String B(Context context) {
        String c2 = bw.c("IeGlhb21p");
        String manufacturer = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
        if (!c2.equalsIgnoreCase(manufacturer)) {
            String c3 = bw.c("IeGlhb21p");
            String brand = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND();
            if (!c3.equalsIgnoreCase(brand) && !bw.c("IUkVETUk=").equalsIgnoreCase(manufacturer) && !bw.c("IUkVETUk=").equalsIgnoreCase(brand)) {
                if (bw.c("Idml2bw").equalsIgnoreCase(manufacturer) || bw.c("Idml2bw").equalsIgnoreCase(brand)) {
                    return A(context);
                }
                if (bw.c("IaHVhd2Vp").equalsIgnoreCase(manufacturer) || bw.c("IaHVhd2Vp").equalsIgnoreCase(brand) || bw.c("ISE9OT1I=").equalsIgnoreCase(manufacturer)) {
                    return a(context, 2);
                }
                if (bw.c("Mc2Ftc3VuZw").equalsIgnoreCase(manufacturer) || bw.c("Mc2Ftc3VuZw").equalsIgnoreCase(brand)) {
                    return a(context, 4);
                }
                if (bw.c("IT1BQTw").equalsIgnoreCase(manufacturer) || bw.c("IT1BQTw").equalsIgnoreCase(brand) || bw.c("MT25lUGx1cw").equalsIgnoreCase(manufacturer) || bw.c("MT25lUGx1cw").equalsIgnoreCase(brand) || bw.c("IUkVBTE1F").equalsIgnoreCase(brand)) {
                    return a(context, 5);
                }
                o = true;
                return n;
            }
        }
        return z(context);
    }

    private static String C(Context context) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] bArr = null;
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 9 && (i2 < 30 || context.getApplicationInfo().targetSdkVersion < 30)) {
                        bArr = com.alibaba.wireless.security.aopsdk.replace.java.net.NetworkInterface.getHardwareAddress(networkInterface);
                    }
                    if (bArr == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : bArr) {
                        String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                        if (upperCase.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(upperCase);
                        sb.append(":");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static String D(Context context) {
        if (!TextUtils.isEmpty(E)) {
            return E;
        }
        try {
            String b2 = co.b(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(b2)) {
                E = "amap" + UUID.randomUUID().toString().replace(JSMethod.NOT_SET, "").toLowerCase();
                SharedPreferences.Editor a2 = co.a(context, "open_common");
                co.a(a2, "a1", bw.b(E));
                co.a(a2);
            } else {
                E = bw.c(b2);
            }
        } catch (Throwable unused) {
        }
        return E;
    }

    private static boolean E(Context context) {
        int simState;
        TelephonyManager K2 = K(context);
        if (K2 == null || (simState = K2.getSimState()) == 0 || simState == 1) {
            return false;
        }
        return true;
    }

    private static String F(Context context) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        boolean E2 = E(context);
        if (L != E2) {
            if (E2) {
                K = "";
                M = false;
            }
            L = E2;
        }
        String str = K;
        if (str != null && !"".equals(str)) {
            return K;
        }
        if (M) {
            return K;
        }
        if (!L) {
            return "";
        }
        if (!c(context, bw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return K;
        }
        TelephonyManager K2 = K(context);
        if (K2 == null) {
            return "";
        }
        Method a2 = bw.a(K2.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
        if (a2 != null) {
            K = (String) a2.invoke(K2, new Object[0]);
        }
        if (K == null) {
            K = "";
        }
        M = true;
        return K;
    }

    private static String G(Context context) {
        if (O) {
            return N;
        }
        P(context);
        if (!c(context, bw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return N;
        }
        TelephonyManager K2 = K(context);
        if (K2 == null) {
            return N;
        }
        String simOperatorName = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimOperatorName(K2);
        N = simOperatorName;
        if (TextUtils.isEmpty(simOperatorName)) {
            N = K2.getNetworkOperatorName();
        }
        O = true;
        return N;
    }

    private static int H(Context context) {
        if (Q) {
            return P;
        }
        P(context);
        if (context == null || !c(context, bw.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return P;
        }
        ConnectivityManager I2 = I(context);
        if (I2 == null) {
            return P;
        }
        NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(I2);
        if (activeNetworkInfo == null) {
            Q = true;
            return P;
        }
        int type = activeNetworkInfo.getType();
        P = type;
        Q = true;
        return type;
    }

    private static ConnectivityManager I(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static int J(Context context) {
        if (S) {
            return R;
        }
        P(context);
        if (!c(context, bw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return R;
        }
        TelephonyManager K2 = K(context);
        if (K2 == null) {
            return R;
        }
        int networkType = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(K2);
        R = networkType;
        S = true;
        return networkType;
    }

    private static TelephonyManager K(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static String L(Context context) {
        if (!c) {
            return "";
        }
        String str = null;
        try {
            str = M(context);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str)) {
            c = false;
            return "";
        }
        try {
            byte[] bytes = bw.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new String(bp.a(bw.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), bp.b(str), bytes), "UTF-8");
        } catch (Throwable unused2) {
            c = false;
            return "";
        }
    }

    private static String M(Context context) {
        String str;
        try {
            str = N(context);
        } catch (Throwable unused) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (context == null) {
            return "";
        }
        return context.getSharedPreferences(bw.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(bs.a(bw.c("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static String N(Context context) {
        RandomAccessFile randomAccessFile;
        String[] split;
        if (Build.VERSION.SDK_INT >= 19 && !c(context, bw.c("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="))) {
            return "";
        }
        String a2 = bs.a(bw.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String O2 = O(context);
        if (TextUtils.isEmpty(O2)) {
            return "";
        }
        File file = new File(O2 + File.separator + bw.c("KYmFja3Vwcw"), bw.c("MLmFkaXU"));
        if (file.exists() && file.canRead()) {
            if (file.length() == 0) {
                file.delete();
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                randomAccessFile = new RandomAccessFile(file, UploadQueueMgr.MSGTYPE_REALTIME);
                try {
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = randomAccessFile.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        } catch (Throwable unused) {
                            byteArrayOutputStream = byteArrayOutputStream2;
                            a(byteArrayOutputStream);
                            a(randomAccessFile);
                            return "";
                        }
                    }
                    String str = new String(byteArrayOutputStream2.toByteArray(), "UTF-8");
                    if (TextUtils.isEmpty(str) || !str.contains(bw.c("SIw")) || (split = str.split(bw.c("SIw"))) == null || split.length != 2 || !TextUtils.equals(a2, split[0])) {
                        a(byteArrayOutputStream2);
                        a(randomAccessFile);
                    } else {
                        String str2 = split[1];
                        a(byteArrayOutputStream2);
                        a(randomAccessFile);
                        return str2;
                    }
                } catch (Throwable unused2) {
                    a(byteArrayOutputStream);
                    a(randomAccessFile);
                    return "";
                }
            } catch (Throwable unused3) {
                randomAccessFile = null;
                a(byteArrayOutputStream);
                a(randomAccessFile);
                return "";
            }
        }
        return "";
    }

    private static String O(Context context) {
        if (Build.VERSION.SDK_INT < 9) {
            return null;
        }
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName(bw.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(bw.c("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(bw.c("FZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(bw.c("DaXNSZW1vdmFibGU"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = Array.get(invoke, i2);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static synchronized b P(Context context) {
        synchronized (bo.class) {
            if (T == null) {
                if (context == null) {
                    return null;
                }
                b bVar = new b();
                T = bVar;
                bVar.a(context.getApplicationContext());
            }
            return T;
        }
    }

    public static a c() {
        return g;
    }

    public static int d(Context context) {
        try {
            return J(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int e(Context context) {
        try {
            return H(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String f(Context context) {
        try {
            return F(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String g(final Context context) {
        try {
            if (o) {
                return "";
            }
            if (!TextUtils.isEmpty(n)) {
                return n;
            }
            if (p) {
                return n;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                ed.a().b(new ee() {
                    /* class com.amap.api.col.s.bo.AnonymousClass2 */

                    @Override // com.amap.api.col.s.ee
                    public final void a() {
                        bo.B(context);
                        boolean unused = bo.p = true;
                    }
                });
                return n;
            }
            p = true;
            return B(context);
        } catch (Throwable unused) {
        }
    }

    public static String i(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return "";
        }
        if (!TextUtils.isEmpty(s)) {
            return s;
        }
        if (t) {
            return s;
        }
        if (!c(context, bw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return "";
        }
        if (i2 >= 26) {
            try {
                String str = (String) bw.a(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
                t = true;
                return str;
            } catch (Throwable unused) {
            }
        } else {
            if (i2 >= 9) {
                s = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getSERIAL();
                t = true;
            }
            String str2 = s;
            if (str2 == null) {
                return "";
            }
            return str2;
        }
    }

    public static String j(Context context) {
        if (!TextUtils.isEmpty(r)) {
            return r;
        }
        if (u) {
            return r;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), bw.c(new String(cf.a(13))));
            r = string;
            u = true;
            return string == null ? "" : string;
        } catch (Throwable unused) {
            return r;
        }
    }

    public static String k(Context context) {
        if (Build.VERSION.SDK_INT < 30 || context.getApplicationInfo().targetSdkVersion < 30) {
            try {
                String str = v;
                if (str != null && !"".equals(str)) {
                    return v;
                }
                if (w) {
                    return v;
                }
                if (!c(context, bw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    return v;
                }
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager == null) {
                    return "";
                }
                v = WifiInfo.getMacAddress(wifiManager.getConnectionInfo());
                if (bw.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(v) || bw.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(v)) {
                    v = C(context);
                }
                w = true;
            } catch (Throwable unused) {
            }
        }
        return v;
    }

    static String l(Context context) {
        if (y) {
            return x;
        }
        try {
            P(context);
            TelephonyManager K2 = K(context);
            if (K2 == null) {
                return x;
            }
            String networkOperator = K2.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                if (networkOperator.length() >= 3) {
                    x = networkOperator.substring(3);
                    y = true;
                    return x;
                }
            }
            y = true;
            return x;
        } catch (Throwable unused) {
        }
    }

    public static int m(Context context) {
        try {
            return J(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int n(Context context) {
        try {
            return H(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    static String o(Context context) {
        StringBuilder sb;
        try {
            String str = z;
            if (str != null && !"".equals(str)) {
                return z;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW);
            if (windowManager == null) {
                return "";
            }
            Display.getMetrics(windowManager.getDefaultDisplay(), displayMetrics);
            int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
            int i3 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
            if (i3 > i2) {
                sb = new StringBuilder();
                sb.append(i2);
                sb.append(jl1.MUL);
                sb.append(i3);
            } else {
                sb = new StringBuilder();
                sb.append(i3);
                sb.append(jl1.MUL);
                sb.append(i2);
            }
            z = sb.toString();
            return z;
        } catch (Throwable unused) {
        }
    }

    public static String p(Context context) {
        ConnectivityManager I2;
        NetworkInfo activeNetworkInfo;
        try {
            if (!c(context, bw.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (I2 = I(context)) == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(I2)) == null) {
                return "";
            }
            return activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String q(Context context) {
        try {
            String r2 = r(context);
            try {
                if (TextUtils.isEmpty(r2)) {
                    r2 = a(context);
                }
                if (TextUtils.isEmpty(r2)) {
                    r2 = h(context);
                }
                if (TextUtils.isEmpty(r2)) {
                    r2 = g(context);
                }
                if (TextUtils.isEmpty(r2)) {
                    r2 = j(context);
                }
                return TextUtils.isEmpty(r2) ? D(context) : r2;
            } catch (Throwable unused) {
                return r2;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String r(Context context) {
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                return "";
            }
            String str = A;
            if (str != null && !"".equals(str)) {
                return A;
            }
            if (F) {
                return A;
            }
            if (!c(context, bw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return A;
            }
            TelephonyManager K2 = K(context);
            if (K2 == null) {
                return "";
            }
            Method a2 = bw.a(K2.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
            if (i2 >= 26) {
                a2 = bw.a(K2.getClass(), "QZ2V0SW1laQ==", new Class[0]);
            }
            if (a2 != null) {
                A = (String) a2.invoke(K2, new Object[0]);
            }
            if (A == null) {
                A = "";
            }
            F = true;
            return A;
        } catch (Throwable unused) {
        }
    }

    public static String s(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return "";
        }
        try {
            String str = B;
            if (str != null && !"".equals(str)) {
                return B;
            }
            if (!c(context, bw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return B;
            }
            TelephonyManager K2 = K(context);
            if (K2 == null) {
                return "";
            }
            if (G) {
                return B;
            }
            if (i2 >= 26) {
                Method a2 = bw.a(K2.getClass(), "QZ2V0TWVpZA==", new Class[0]);
                if (a2 != null) {
                    B = (String) a2.invoke(K2, new Object[0]);
                }
                if (B == null) {
                    B = "";
                }
                G = true;
            }
            return B;
        } catch (Throwable unused) {
        }
    }

    public static String t(Context context) {
        try {
            return F(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054 A[Catch:{ IOException -> 0x0057 }] */
    public static int u(Context context) {
        int i2 = I;
        if (i2 != 0) {
            return i2;
        }
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return 0;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            i3 = (int) (memoryInfo.totalMem / 1024);
        } else {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File("/proc/meminfo")));
                try {
                    i3 = Integer.valueOf(bufferedReader2.readLine().split("\\s+")[1]).intValue();
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused) {
                    }
                } catch (Throwable unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    int i4 = i3 / 1024;
                    I = i4;
                    return i4;
                }
            } catch (Throwable unused3) {
                if (bufferedReader != null) {
                }
                int i42 = i3 / 1024;
                I = i42;
                return i42;
            }
        }
        int i422 = i3 / 1024;
        I = i422;
        return i422;
    }

    static String v(Context context) {
        try {
            return G(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String x(Context context) {
        try {
            String b2 = co.b(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(b2) ? co.b(context, "Alvin2", Constants.UTDID, "") : b2;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    private static String y(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (bw.a(context, "android.permission.READ_EXTERNAL_STORAGE") && "mounted".equals(Environment.getExternalStorageState())) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(absolutePath + "/.UTSystemConfig/Global/Alvin2.xml");
                XmlPullParser newPullParser = Xml.newPullParser();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    newPullParser.setInput(fileInputStream2, "utf-8");
                    boolean z2 = false;
                    for (int eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                        if (eventType != 2) {
                            if (eventType == 3) {
                                z2 = false;
                            } else if (eventType == 4) {
                                if (z2) {
                                    String text = newPullParser.getText();
                                    try {
                                        fileInputStream2.close();
                                    } catch (Throwable unused) {
                                    }
                                    return text;
                                }
                            }
                        } else if (newPullParser.getAttributeCount() > 0) {
                            int attributeCount = newPullParser.getAttributeCount();
                            for (int i2 = 0; i2 < attributeCount; i2++) {
                                String attributeValue = newPullParser.getAttributeValue(i2);
                                if ("UTDID2".equals(attributeValue) || Constants.UTDID.equals(attributeValue)) {
                                    z2 = true;
                                }
                            }
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream == null) {
                    }
                    fileInputStream.close();
                    return "";
                }
            }
            if (fileInputStream == null) {
                return "";
            }
        } catch (Throwable unused3) {
            if (fileInputStream == null) {
                return "";
            }
            fileInputStream.close();
            return "";
        }
        try {
            fileInputStream.close();
            return "";
        } catch (Throwable unused4) {
            return "";
        }
    }

    private static String z(Context context) {
        try {
            Class<?> cls = Class.forName(bw.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object newInstance = cls.newInstance();
            Object invoke = cls.getMethod(bw.c("MZ2V0T0FJRA"), Context.class).invoke(newInstance, context);
            if (invoke != null) {
                String str = (String) invoke;
                n = str;
                return str;
            }
        } catch (Throwable th) {
            ci.a(th, "oa", "xm");
            o = true;
        }
        return n;
    }

    public static String a() {
        return k;
    }

    public static String b() {
        try {
            if (!TextUtils.isEmpty(e)) {
                return e;
            }
            a aVar = g;
            if (aVar == null) {
                return "";
            }
            return aVar.a();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String t2 = t(context);
            if (t2 != null) {
                if (t2.length() >= 5) {
                    return t2.substring(3, 5);
                }
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:14|(1:16)|17|(2:19|20)|21|22|(2:24|25)|(2:26|27)|29|(1:31)(1:32)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0050 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b A[Catch:{ all -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005f A[RETURN] */
    public static String h(Context context) {
        if (q) {
            String str = a;
            if (str == null) {
                return "";
            }
            return str;
        }
        String str2 = a;
        if (str2 != null && !"".equals(str2)) {
            return a;
        }
        if (c(context, bw.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!TextUtils.isEmpty(a)) {
            q = true;
            return a;
        }
        String x2 = x(context);
        a = x2;
        if (!TextUtils.isEmpty(x2)) {
            q = true;
            return a;
        }
        try {
            a = y(context);
            q = true;
        } catch (Throwable unused) {
        }
        String str3 = a;
        if (str3 == null) {
            return "";
        }
        return str3;
    }

    public static void a(a aVar) {
        if (g == null) {
            g = aVar;
        }
    }

    static String[] d() {
        return new String[]{"", ""};
    }

    public static long e() {
        long j2;
        long j3;
        long j4 = H;
        if (j4 != 0) {
            return j4;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                j3 = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576;
                j2 = (statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576;
            } else {
                j3 = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1048576;
                j2 = (((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize())) / 1048576;
            }
            H = j3 + j2;
        } catch (Throwable unused) {
        }
        return H;
    }

    public static String f() {
        if (!TextUtils.isEmpty(J)) {
            return J;
        }
        String property = System.getProperty("os.arch");
        J = property;
        return property;
    }

    public static String a(final Context context) {
        try {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            if (context == null) {
                return "";
            }
            String L2 = L(context);
            b = L2;
            if (!TextUtils.isEmpty(L2)) {
                return b;
            }
            if (c() == null || m) {
                return "";
            }
            m = true;
            ed.a().b(new ee() {
                /* class com.amap.api.col.s.bo.AnonymousClass1 */

                @Override // com.amap.api.col.s.ee
                public final void a() {
                    try {
                        Map<String, String> b = bo.g.b();
                        String a2 = bo.g.a(bo.h(context), "", "", bo.t(context));
                        if (!TextUtils.isEmpty(a2)) {
                            cz.a();
                            String a3 = bo.g.a(context, new String(cz.a(bo.g.a(a2.getBytes(), b)).a));
                            if (!TextUtils.isEmpty(a3)) {
                                bo.b = a3;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
            return "";
        } catch (Throwable unused) {
        }
    }

    public static String b(Context context) {
        try {
            return G(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: private */
    public static boolean c(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static void g() {
        P = -1;
        Q = false;
        R = -1;
        S = false;
        N = "";
        O = false;
        x = "";
        y = false;
    }

    private static String a(Context context, int i2) {
        try {
            Intent intent = new Intent();
            if (i2 == 2) {
                intent.setAction(bw.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(bw.c("UY29tLmh1YXdlaS5od2lk"));
            } else if (i2 == 4) {
                intent.setClassName(bw.c("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), bw.c("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else if (i2 != 5) {
                o = true;
                return n;
            } else {
                intent.setClassName(bw.c("YY29tLmhleXRhcC5vcGVuaWQ"), bw.c("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(bw.c("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            c cVar = new c(context, i2);
            if (context.bindService(intent, cVar, 1)) {
                int i3 = 0;
                while (i3 < 100 && TextUtils.isEmpty(n)) {
                    i3++;
                    Thread.sleep(15);
                }
                context.unbindService(cVar);
            }
            return n;
        } catch (Throwable th) {
            ci.a(th, "oa", String.valueOf(i2));
            o = true;
            return n;
        }
    }

    public static String a(Context context, String str) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29 || i2 < 21) {
            return "";
        }
        try {
            if (!TextUtils.isEmpty(i)) {
                return i;
            }
            if (D) {
                return i;
            }
            TelephonyManager K2 = K(context);
            if (h == -1) {
                Method a2 = bw.a(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
                if (a2 != null) {
                    try {
                        h = ((Integer) a2.invoke(K2, new Object[0])).intValue();
                    } catch (Throwable unused) {
                    }
                }
                h = 0;
            }
            Method a3 = bw.a(TelephonyManager.class, "MZ2V0SW1laQ=", Integer.TYPE);
            if (a3 == null) {
                h = 0;
                D = true;
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < h; i3++) {
                try {
                    sb.append((String) a3.invoke(K2, Integer.valueOf(i3)));
                    sb.append(str);
                } catch (Throwable unused2) {
                }
            }
            String sb2 = sb.toString();
            if (sb2.length() == 0) {
                h = 0;
                D = true;
                return "";
            }
            String substring = sb2.substring(0, sb2.length() - 1);
            i = substring;
            D = true;
            return substring;
        } catch (Throwable unused3) {
            return "";
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
