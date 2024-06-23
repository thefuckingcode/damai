package com.loc;

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
import tb.t13;
import tb.u13;
import tb.v;
import tb.v13;
import tb.y13;

/* compiled from: Taobao */
public final class o {
    private static boolean A = false;
    private static boolean B = false;
    private static long C = 0;
    private static int D = 0;
    private static String E = null;
    private static String F = "";
    private static boolean G = true;
    private static boolean H = false;
    private static String I = "";
    private static boolean J = false;
    private static int K = -1;
    private static boolean L = false;
    private static int M = -1;
    private static boolean N = false;
    private static volatile b O = null;
    static String a = "";
    static String b = "";
    static volatile boolean c = true;
    static String d = "";
    private static String e = null;
    public static a f = null;
    private static volatile boolean g = false;
    private static String h = "";
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static String l = "";
    private static String m = "";
    private static boolean n = false;
    private static boolean o = false;
    private static String p = "";
    private static boolean q = false;
    private static String r = "";
    private static boolean s = false;
    private static String t = "";
    private static String u = "";
    private static String v = "";
    static int w = -1;
    static String x = "";
    private static boolean y = false;
    private static String z = "";

    /* compiled from: Taobao */
    public interface a {
        bl a(byte[] bArr, Map<String, String> map);

        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    /* compiled from: Taobao */
    public static class b {
        private static BroadcastReceiver a;
        private static ConnectivityManager b;
        private static NetworkRequest c;
        private static ConnectivityManager.NetworkCallback d;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a extends ConnectivityManager.NetworkCallback {
            a(b bVar) {
            }

            public final void onAvailable(Network network) {
                super.onAvailable(network);
                o.S();
            }

            public final void onLost(Network network) {
                super.onLost(network);
                o.S();
            }
        }

        @SuppressLint({"WrongConstant"})
        public final void a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context != null && a == null) {
                    a = new BroadcastReceiver(this) {
                        /* class com.loc.o.b.AnonymousClass1 */

                        public final void onReceive(Context context, Intent intent) {
                            if (v1.v("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                                o.S();
                            }
                        }
                    };
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(v1.v("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                    context.registerReceiver(a, intentFilter);
                }
            } else if (o.I(context, v1.v("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && b == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                b = connectivityManager;
                if (connectivityManager != null) {
                    c = new NetworkRequest.Builder().addCapability(0).addCapability(1).build();
                    a aVar = new a(this);
                    d = aVar;
                    b.registerNetworkCallback(c, aVar);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c implements ServiceConnection {
        private static String c;
        private Context a;
        private int b;

        c(Context context, int i) {
            this.a = context;
            this.b = i;
        }

        private String a() {
            try {
                if (!TextUtils.isEmpty(c)) {
                    return c;
                }
                byte[] digest = MessageDigest.getInstance(v1.v("IU0hBMQ")).digest(this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 64).signatures[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    stringBuffer.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                }
                String stringBuffer2 = stringBuffer.toString();
                if (!TextUtils.isEmpty(stringBuffer2)) {
                    c = stringBuffer2;
                }
                return stringBuffer2;
            } catch (Throwable unused) {
                return "";
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004e A[Catch:{ all -> 0x0062, all -> 0x0075 }] */
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean z;
            String v;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                int i = this.b;
                if (i == 2) {
                    v = v1.v("UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U");
                } else if (i == 4) {
                    v = v1.v("UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ");
                } else if (i != 5) {
                    z = false;
                    if (z) {
                        iBinder.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        String unused = o.h = obtain2.readString();
                    }
                } else {
                    obtain.writeInterfaceToken(v1.v("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));
                    obtain.writeString(this.a.getPackageName());
                    obtain.writeString(a());
                    obtain.writeString(v1.v("IT1VJRA"));
                    z = true;
                    if (z) {
                    }
                }
                obtain.writeInterfaceToken(v);
                z = true;
                if (z) {
                }
            } catch (Throwable th) {
                v13.e(th, "oac", String.valueOf(this.b));
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static void A(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void B(String str) {
        e = str;
    }

    public static String C() {
        try {
            if (!TextUtils.isEmpty(d)) {
                return d;
            }
            a aVar = f;
            return aVar == null ? "" : aVar.a();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String D(Context context) {
        try {
            return l(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static a G() {
        return f;
    }

    public static String H(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String k0 = k0(context);
            if (k0 != null) {
                if (k0.length() >= 5) {
                    return k0.substring(3, 5);
                }
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: private */
    public static boolean I(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static int J(Context context) {
        try {
            return o(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    static String[] K() {
        return new String[]{"", ""};
    }

    public static int L(Context context) {
        try {
            return m(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static void M() {
        try {
            u13.a();
        } catch (Throwable unused) {
        }
    }

    public static long N() {
        long j2;
        long j3;
        long j4 = C;
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
            C = j3 + j2;
        } catch (Throwable unused) {
        }
        return C;
    }

    public static String O(Context context) {
        try {
            return k(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String P() {
        if (!TextUtils.isEmpty(E)) {
            return E;
        }
        String property = System.getProperty("os.arch");
        E = property;
        return property;
    }

    public static String Q(final Context context) {
        try {
            if (i) {
                return "";
            }
            if (!TextUtils.isEmpty(h)) {
                return h;
            }
            if (j) {
                return h;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                o0.f().d(new ck() {
                    /* class com.loc.o.AnonymousClass2 */

                    @Override // com.loc.ck
                    public final void a() {
                        o.g(context);
                        boolean unused = o.j = true;
                    }
                });
                return h;
            }
            j = true;
            return g(context);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:14|(1:16)|17|(2:19|20)|21|22|(2:24|25)|(2:26|27)|29|(1:31)(1:32)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0050 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b A[Catch:{ all -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005f A[RETURN] */
    public static String R(Context context) {
        if (k) {
            String str = a;
            return str == null ? "" : str;
        }
        String str2 = a;
        if (str2 != null && !"".equals(str2)) {
            return a;
        }
        if (I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!TextUtils.isEmpty(a)) {
            k = true;
            return a;
        }
        String c2 = c(context);
        a = c2;
        if (!TextUtils.isEmpty(c2)) {
            k = true;
            return a;
        }
        try {
            a = d(context);
            k = true;
        } catch (Throwable unused) {
        }
        String str3 = a;
        return str3 == null ? "" : str3;
    }

    public static void S() {
        K = -1;
        L = false;
        M = -1;
        N = false;
        I = "";
        J = false;
        r = "";
        s = false;
    }

    public static String T(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return "";
        }
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        if (n) {
            return m;
        }
        if (!I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return "";
        }
        if (i2 >= 26) {
            try {
                String str = (String) v1.h(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
                n = true;
                return str;
            } catch (Throwable unused) {
            }
        } else {
            if (i2 >= 9) {
                m = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getSERIAL();
                n = true;
            }
            String str2 = m;
            return str2 == null ? "" : str2;
        }
    }

    public static String V(Context context) {
        if (!TextUtils.isEmpty(l)) {
            return l;
        }
        if (o) {
            return l;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), v1.v(new String(t13.c(13))));
            l = string;
            o = true;
            return string == null ? "" : string;
        } catch (Throwable unused) {
            return l;
        }
    }

    public static String W(Context context) {
        if (Build.VERSION.SDK_INT < 30 || context.getApplicationInfo().targetSdkVersion < 30) {
            try {
                String str = p;
                if (str != null && !"".equals(str)) {
                    return p;
                }
                if (q) {
                    return p;
                }
                if (!I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    return p;
                }
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager == null) {
                    return "";
                }
                p = WifiInfo.getMacAddress(wifiManager.getConnectionInfo());
                if (v1.v("YMDI6MDA6MDA6MDA6MDA6MDA").equals(p) || v1.v("YMDA6MDA6MDA6MDA6MDA6MDA").equals(p)) {
                    p = h(context);
                }
                q = true;
            } catch (Throwable unused) {
            }
        }
        return p;
    }

    static String X(Context context) {
        try {
            TelephonyManager p2 = p(context);
            if (p2 == null) {
                return "";
            }
            String networkOperator = p2.getNetworkOperator();
            return !TextUtils.isEmpty(networkOperator) ? networkOperator.length() < 3 ? "" : networkOperator.substring(0, 3) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    static String Y(Context context) {
        if (s) {
            return r;
        }
        try {
            u(context);
            TelephonyManager p2 = p(context);
            if (p2 == null) {
                return r;
            }
            String networkOperator = p2.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                if (networkOperator.length() >= 3) {
                    r = networkOperator.substring(3);
                    s = true;
                    return r;
                }
            }
            s = true;
            return r;
        } catch (Throwable unused) {
        }
    }

    public static int Z(Context context) {
        try {
            return o(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    static String a(Context context) {
        try {
            return l(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int a0(Context context) {
        try {
            return m(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static NetworkInfo b0(Context context) {
        ConnectivityManager n2;
        if (I(context, v1.v("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (n2 = n(context)) != null) {
            return com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(n2);
        }
        return null;
    }

    private static String c(Context context) {
        try {
            String o2 = y13.o(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(o2) ? y13.o(context, "Alvin2", Constants.UTDID, "") : o2;
        } catch (Throwable unused) {
            return "";
        }
    }

    static String c0(Context context) {
        try {
            NetworkInfo b0 = b0(context);
            if (b0 == null) {
                return null;
            }
            return b0.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    private static String d(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (v1.m(context, "android.permission.READ_EXTERNAL_STORAGE") && "mounted".equals(Environment.getExternalStorageState())) {
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

    static String d0(Context context) {
        StringBuilder sb;
        try {
            String str = t;
            if (str != null && !"".equals(str)) {
                return t;
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
            t = sb.toString();
            return t;
        } catch (Throwable unused) {
        }
    }

    private static String e(Context context) {
        try {
            Class<?> cls = Class.forName(v1.v("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object newInstance = cls.newInstance();
            Object invoke = cls.getMethod(v1.v("MZ2V0T0FJRA"), Context.class).invoke(newInstance, context);
            if (invoke != null) {
                String str = (String) invoke;
                h = str;
                return str;
            }
        } catch (Throwable th) {
            v13.e(th, "oa", "xm");
            i = true;
        }
        return h;
    }

    public static String e0(Context context) {
        try {
            if (!I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return F;
            }
            TelephonyManager p2 = p(context);
            return p2 == null ? "" : p2.getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String f(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(v1.v("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= columnCount) {
                            break;
                        } else if (v1.v("IdmFsdWU").equals(query.getColumnName(i2))) {
                            h = query.getString(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                query.close();
            }
        } catch (Throwable th) {
            i = true;
            v13.e(th, "oa", "vivo");
        }
        return h;
    }

    public static String f0(Context context) {
        ConnectivityManager n2;
        NetworkInfo activeNetworkInfo;
        try {
            return (!I(context, v1.v("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (n2 = n(context)) == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(n2)) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public static String g(Context context) {
        String v2 = v1.v("IeGlhb21p");
        String manufacturer = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
        if (!v2.equalsIgnoreCase(manufacturer)) {
            String v3 = v1.v("IeGlhb21p");
            String brand = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND();
            if (!v3.equalsIgnoreCase(brand) && !v1.v("IUkVETUk=").equalsIgnoreCase(manufacturer) && !v1.v("IUkVETUk=").equalsIgnoreCase(brand)) {
                if (v1.v("Idml2bw").equalsIgnoreCase(manufacturer) || v1.v("Idml2bw").equalsIgnoreCase(brand)) {
                    return f(context);
                }
                if (v1.v("IaHVhd2Vp").equalsIgnoreCase(manufacturer) || v1.v("IaHVhd2Vp").equalsIgnoreCase(brand) || v1.v("ISE9OT1I=").equalsIgnoreCase(manufacturer)) {
                    return x(context, 2);
                }
                if (v1.v("Mc2Ftc3VuZw").equalsIgnoreCase(manufacturer) || v1.v("Mc2Ftc3VuZw").equalsIgnoreCase(brand)) {
                    return x(context, 4);
                }
                if (v1.v("IT1BQTw").equalsIgnoreCase(manufacturer) || v1.v("IT1BQTw").equalsIgnoreCase(brand) || v1.v("MT25lUGx1cw").equalsIgnoreCase(manufacturer) || v1.v("MT25lUGx1cw").equalsIgnoreCase(brand) || v1.v("IUkVBTE1F").equalsIgnoreCase(brand)) {
                    return x(context, 5);
                }
                i = true;
                return h;
            }
        }
        return e(context);
    }

    public static String g0(Context context) {
        try {
            String h0 = h0(context);
            try {
                if (TextUtils.isEmpty(h0)) {
                    h0 = w(context);
                }
                if (TextUtils.isEmpty(h0)) {
                    h0 = R(context);
                }
                if (TextUtils.isEmpty(h0)) {
                    h0 = Q(context);
                }
                if (TextUtils.isEmpty(h0)) {
                    h0 = V(context);
                }
                return TextUtils.isEmpty(h0) ? i(context) : h0;
            } catch (Throwable unused) {
                return h0;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static String h(Context context) {
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

    public static String h0(Context context) {
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                return "";
            }
            String str = u;
            if (str != null && !"".equals(str)) {
                return u;
            }
            if (A) {
                return u;
            }
            if (!I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return u;
            }
            TelephonyManager p2 = p(context);
            if (p2 == null) {
                return "";
            }
            Method h2 = v1.h(p2.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
            if (i2 >= 26) {
                h2 = v1.h(p2.getClass(), "QZ2V0SW1laQ==", new Class[0]);
            }
            if (h2 != null) {
                u = (String) h2.invoke(p2, new Object[0]);
            }
            if (u == null) {
                u = "";
            }
            A = true;
            return u;
        } catch (Throwable unused) {
        }
    }

    private static String i(Context context) {
        if (!TextUtils.isEmpty(z)) {
            return z;
        }
        try {
            String o2 = y13.o(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(o2)) {
                z = "amap" + UUID.randomUUID().toString().replace(JSMethod.NOT_SET, "").toLowerCase();
                SharedPreferences.Editor b2 = y13.b(context, "open_common");
                y13.i(b2, "a1", v1.r(z));
                y13.e(b2);
            } else {
                z = v1.v(o2);
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static String i0(Context context) {
        return h0(context) + com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + w(context) + com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + g0(context);
    }

    private static boolean j(Context context) {
        int simState;
        TelephonyManager p2 = p(context);
        return (p2 == null || (simState = p2.getSimState()) == 0 || simState == 1) ? false : true;
    }

    public static String j0(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return "";
        }
        try {
            String str = v;
            if (str != null && !"".equals(str)) {
                return v;
            }
            if (!I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return v;
            }
            TelephonyManager p2 = p(context);
            if (p2 == null) {
                return "";
            }
            if (B) {
                return v;
            }
            if (i2 >= 26) {
                Method h2 = v1.h(p2.getClass(), "QZ2V0TWVpZA==", new Class[0]);
                if (h2 != null) {
                    v = (String) h2.invoke(p2, new Object[0]);
                }
                if (v == null) {
                    v = "";
                }
                B = true;
            }
            return v;
        } catch (Throwable unused) {
        }
    }

    private static String k(Context context) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        boolean j2 = j(context);
        if (G != j2) {
            if (j2) {
                F = "";
                H = false;
            }
            G = j2;
        }
        String str = F;
        if (str != null && !"".equals(str)) {
            return F;
        }
        if (H) {
            return F;
        }
        if (!G) {
            return "";
        }
        if (!I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return F;
        }
        TelephonyManager p2 = p(context);
        if (p2 == null) {
            return "";
        }
        Method h2 = v1.h(p2.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
        if (h2 != null) {
            F = (String) h2.invoke(p2, new Object[0]);
        }
        if (F == null) {
            F = "";
        }
        H = true;
        return F;
    }

    public static String k0(Context context) {
        try {
            return k(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String l(Context context) {
        if (J) {
            return I;
        }
        u(context);
        if (!I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return I;
        }
        TelephonyManager p2 = p(context);
        if (p2 == null) {
            return I;
        }
        String simOperatorName = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimOperatorName(p2);
        I = simOperatorName;
        if (TextUtils.isEmpty(simOperatorName)) {
            I = p2.getNetworkOperatorName();
        }
        J = true;
        return I;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054 A[Catch:{ IOException -> 0x0057 }] */
    public static int l0(Context context) {
        int i2 = D;
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
                    D = i4;
                    return i4;
                }
            } catch (Throwable unused3) {
                if (bufferedReader != null) {
                }
                int i42 = i3 / 1024;
                D = i42;
                return i42;
            }
        }
        int i422 = i3 / 1024;
        D = i422;
        return i422;
    }

    private static int m(Context context) {
        if (L) {
            return K;
        }
        u(context);
        if (context == null || !I(context, v1.v("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return K;
        }
        ConnectivityManager n2 = n(context);
        if (n2 == null) {
            return K;
        }
        NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(n2);
        if (activeNetworkInfo == null) {
            L = true;
            return K;
        }
        int type = activeNetworkInfo.getType();
        K = type;
        L = true;
        return type;
    }

    private static ConnectivityManager n(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static int o(Context context) {
        if (N) {
            return M;
        }
        u(context);
        if (!I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return M;
        }
        TelephonyManager p2 = p(context);
        if (p2 == null) {
            return M;
        }
        int networkType = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(p2);
        M = networkType;
        N = true;
        return networkType;
    }

    private static TelephonyManager p(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static String q(Context context) {
        if (!c) {
            return "";
        }
        String str = null;
        try {
            str = r(context);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str)) {
            c = false;
            return "";
        }
        try {
            byte[] bytes = v1.v("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new String(p1.e(v1.v("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), p1.g(str), bytes), "UTF-8");
        } catch (Throwable unused2) {
            c = false;
            return "";
        }
    }

    private static String r(Context context) {
        String str;
        try {
            str = s(context);
        } catch (Throwable unused) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(v1.v("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(r1.a(v1.v("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static String s(Context context) {
        RandomAccessFile randomAccessFile;
        String[] split;
        if (Build.VERSION.SDK_INT >= 19 && !I(context, v1.v("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="))) {
            return "";
        }
        String a2 = r1.a(v1.v("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String t2 = t(context);
        if (TextUtils.isEmpty(t2)) {
            return "";
        }
        File file = new File(t2 + File.separator + v1.v("KYmFja3Vwcw"), v1.v("MLmFkaXU"));
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
                            A(byteArrayOutputStream);
                            A(randomAccessFile);
                            return "";
                        }
                    }
                    String str = new String(byteArrayOutputStream2.toByteArray(), "UTF-8");
                    if (TextUtils.isEmpty(str) || !str.contains(v1.v("SIw")) || (split = str.split(v1.v("SIw"))) == null || split.length != 2 || !TextUtils.equals(a2, split[0])) {
                        A(byteArrayOutputStream2);
                        A(randomAccessFile);
                    } else {
                        String str2 = split[1];
                        A(byteArrayOutputStream2);
                        A(randomAccessFile);
                        return str2;
                    }
                } catch (Throwable unused2) {
                    A(byteArrayOutputStream);
                    A(randomAccessFile);
                    return "";
                }
            } catch (Throwable unused3) {
                randomAccessFile = null;
                A(byteArrayOutputStream);
                A(randomAccessFile);
                return "";
            }
        }
        return "";
    }

    private static String t(Context context) {
        if (Build.VERSION.SDK_INT < 9) {
            return null;
        }
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName(v1.v("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(v1.v("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(v1.v("FZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(v1.v("DaXNSZW1vdmFibGU"), new Class[0]);
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

    private static synchronized b u(Context context) {
        synchronized (o.class) {
            if (O == null) {
                if (context == null) {
                    return null;
                }
                b bVar = new b();
                O = bVar;
                bVar.a(context.getApplicationContext());
            }
            return O;
        }
    }

    public static String v() {
        return e;
    }

    public static String w(final Context context) {
        try {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            if (context == null) {
                return "";
            }
            String q2 = q(context);
            b = q2;
            if (!TextUtils.isEmpty(q2)) {
                return b;
            }
            if (G() == null || g) {
                return "";
            }
            g = true;
            o0.f().d(new ck() {
                /* class com.loc.o.AnonymousClass1 */

                @Override // com.loc.ck
                public final void a() {
                    try {
                        Map<String, String> b = o.f.b();
                        String a2 = o.f.a(o.R(context), "", "", o.k0(context));
                        if (!TextUtils.isEmpty(a2)) {
                            bg.b();
                            String a3 = o.f.a(context, new String(bg.c(o.f.a(a2.getBytes(), b)).a));
                            if (!TextUtils.isEmpty(a3)) {
                                o.b = a3;
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

    private static String x(Context context, int i2) {
        try {
            Intent intent = new Intent();
            if (i2 == 2) {
                intent.setAction(v1.v("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(v1.v("UY29tLmh1YXdlaS5od2lk"));
            } else if (i2 == 4) {
                intent.setClassName(v1.v("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), v1.v("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else if (i2 != 5) {
                i = true;
                return h;
            } else {
                intent.setClassName(v1.v("YY29tLmhleXRhcC5vcGVuaWQ"), v1.v("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(v1.v("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            c cVar = new c(context, i2);
            if (context.bindService(intent, cVar, 1)) {
                int i3 = 0;
                while (i3 < 100 && TextUtils.isEmpty(h)) {
                    i3++;
                    Thread.sleep(15);
                }
                context.unbindService(cVar);
            }
            return h;
        } catch (Throwable th) {
            v13.e(th, "oa", String.valueOf(i2));
            i = true;
            return h;
        }
    }

    public static String y(Context context, String str) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29 || i2 < 21) {
            return "";
        }
        try {
            if (!TextUtils.isEmpty(x)) {
                return x;
            }
            if (y) {
                return x;
            }
            TelephonyManager p2 = p(context);
            if (w == -1) {
                Method h2 = v1.h(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
                if (h2 != null) {
                    try {
                        w = ((Integer) h2.invoke(p2, new Object[0])).intValue();
                    } catch (Throwable unused) {
                    }
                }
                w = 0;
            }
            Method h3 = v1.h(TelephonyManager.class, "MZ2V0SW1laQ=", Integer.TYPE);
            if (h3 == null) {
                w = 0;
                y = true;
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < w; i3++) {
                try {
                    sb.append((String) h3.invoke(p2, Integer.valueOf(i3)));
                    sb.append(str);
                } catch (Throwable unused2) {
                }
            }
            String sb2 = sb.toString();
            if (sb2.length() == 0) {
                w = 0;
                y = true;
                return "";
            }
            String substring = sb2.substring(0, sb2.length() - 1);
            x = substring;
            y = true;
            return substring;
        } catch (Throwable unused3) {
            return "";
        }
    }

    public static void z(a aVar) {
        if (f == null) {
            f = aVar;
        }
    }
}
