package com.alibaba.analytics.core.network;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.wireless.security.aopsdk.replace.java.net.NetworkInterface;
import com.alipay.sdk.m.u.c;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import tb.gj2;
import tb.tq2;

/* compiled from: Taobao */
public class NetworkUtil {
    public static final String NETWORK_CLASS_2_3_G = "2G/3G";
    public static final String NETWORK_CLASS_2_G = "2G";
    public static final String NETWORK_CLASS_3_G = "3G";
    public static final String NETWORK_CLASS_4_G = "4G";
    public static final String NETWORK_CLASS_5_G = "5G";
    public static final String NETWORK_CLASS_UNKNOWN = "Unknown";
    public static final String NETWORK_CLASS_WIFI = "Wi-Fi";
    private static String[] a = {NETWORK_CLASS_UNKNOWN, NETWORK_CLASS_UNKNOWN};
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static NetworkStatusReceiver e = new NetworkStatusReceiver();
    private static NetWorkStatusChecker f = new NetWorkStatusChecker();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class NetWorkStatusChecker implements Runnable {
        private Context context;

        private NetWorkStatusChecker() {
        }

        public void run() {
            Context context2 = this.context;
            if (context2 != null) {
                NetworkUtil.g(context2);
                NetworkOperatorUtil.f(this.context);
                tq2.k(this.context);
            }
        }

        public NetWorkStatusChecker setContext(Context context2) {
            this.context = context2;
            return this;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class NetworkStatusReceiver extends BroadcastReceiver {
        private NetworkStatusReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            gj2.c().f(NetworkUtil.f.setContext(context));
        }
    }

    public static String c(Context context) {
        try {
            return f(context)[0];
        } catch (Exception unused) {
            return NETWORK_CLASS_UNKNOWN;
        }
    }

    public static String d(Context context) {
        try {
            String[] f2 = f(context);
            if (f2[0].equals(NETWORK_CLASS_2_3_G)) {
                return f2[1];
            }
            return f2[1].equals("5G") ? "5G" : NETWORK_CLASS_UNKNOWN;
        } catch (Exception unused) {
        }
    }

    private static String e(int i) {
        if (i == 20) {
            return "4G";
        }
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return NETWORK_CLASS_UNKNOWN;
        }
    }

    public static String[] f(Context context) {
        if (!b) {
            g(context);
        }
        return a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0095 A[Catch:{ Exception -> 0x0087 }] */
    public static synchronized void g(Context context) {
        synchronized (NetworkUtil.class) {
            if (context != null) {
                try {
                    if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                        String[] strArr = a;
                        strArr[0] = NETWORK_CLASS_UNKNOWN;
                        strArr[1] = NETWORK_CLASS_UNKNOWN;
                        return;
                    }
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        String[] strArr2 = a;
                        strArr2[0] = NETWORK_CLASS_UNKNOWN;
                        strArr2[1] = NETWORK_CLASS_UNKNOWN;
                        return;
                    }
                    NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
                    if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                        String[] strArr3 = a;
                        strArr3[0] = NETWORK_CLASS_UNKNOWN;
                        strArr3[1] = NETWORK_CLASS_UNKNOWN;
                        if (!b) {
                            b = true;
                        }
                    }
                    if (1 == activeNetworkInfo.getType()) {
                        a[0] = "Wi-Fi";
                        if (q(context)) {
                            a[1] = "5G";
                        } else {
                            a[1] = NETWORK_CLASS_UNKNOWN;
                        }
                    } else if (activeNetworkInfo.getType() == 0) {
                        String[] strArr4 = a;
                        strArr4[0] = NETWORK_CLASS_2_3_G;
                        strArr4[1] = activeNetworkInfo.getSubtypeName();
                    }
                    if (!b) {
                    }
                } catch (Exception e2) {
                    Logger.f("NetworkUtil", e2);
                }
            }
        }
    }

    public static String h() {
        NetworkInfo activeNetworkInfo;
        Context j = Variables.n().j();
        if (j == null) {
            return NETWORK_CLASS_UNKNOWN;
        }
        try {
            if (j.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", j.getPackageName()) == 0 && (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo((ConnectivityManager) j.getSystemService("connectivity"))) != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return "Wi-Fi";
                }
                if (activeNetworkInfo.getType() == 0) {
                    return e(activeNetworkInfo.getSubtype());
                }
            }
        } catch (Throwable unused) {
        }
        return NETWORK_CLASS_UNKNOWN;
    }

    public static String i(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return k();
        }
        return j(context);
    }

    private static String j(Context context) {
        if (context == null) {
            return c.b;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null) {
                return c.b;
            }
            String macAddress = com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo.getMacAddress(connectionInfo);
            if (TextUtils.isEmpty(macAddress)) {
                return c.b;
            }
            return macAddress;
        } catch (Throwable unused) {
            return c.b;
        }
    }

    @TargetApi(23)
    private static String k() {
        try {
            byte[] hardwareAddress = NetworkInterface.getHardwareAddress(java.net.NetworkInterface.getByName("wlan0"));
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < hardwareAddress.length) {
                Object[] objArr = new Object[2];
                objArr[0] = Byte.valueOf(hardwareAddress[i]);
                objArr[1] = i < hardwareAddress.length - 1 ? ":" : "";
                sb.append(String.format("%02X%s", objArr));
                i++;
            }
            return sb.toString();
        } catch (Exception unused) {
            return c.b;
        }
    }

    private static boolean l(int i) {
        return i > 4900 && i < 5900;
    }

    public static boolean m(Context context) {
        if (context == null) {
            return true;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return true;
            }
            NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        return com.alibaba.analytics.core.network.NetworkUtil.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        com.alibaba.analytics.core.network.NetworkUtil.c = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        throw r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0029 */
    public static boolean n(Context context) {
        if (c) {
            return d;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (Build.VERSION.SDK_INT >= 21) {
            d = wifiManager.is5GHzBandSupported();
        } else {
            d = false;
        }
        boolean z = d;
        c = true;
        return z;
    }

    public static boolean o(Context context) {
        if (context != null) {
            try {
                String str = f(context)[0];
                if (str.equals("2G") || str.equals("3G") || str.equals("4G") || str.equals(NETWORK_CLASS_2_3_G)) {
                    Logger.f("NetworkUtil", "isMobile");
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean p(Context context) {
        if (context != null) {
            try {
                if (f(context)[0].equals("Wi-Fi")) {
                    Logger.f("NetworkUtil", "isWifi");
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static boolean q(Context context) {
        WifiInfo connectionInfo;
        int i = 0;
        if (context == null || (connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo()) == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            i = connectionInfo.getFrequency();
        }
        return l(i);
    }

    public static void r(Context context) {
        if (context != null) {
            context.registerReceiver(e, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
            try {
                NetworkOperatorUtil.e(context);
            } catch (Exception unused) {
            }
            gj2.c().f(f.setContext(context));
        }
    }

    public static void s(Context context) {
        NetworkStatusReceiver networkStatusReceiver;
        if (context != null && (networkStatusReceiver = e) != null) {
            context.unregisterReceiver(networkStatusReceiver);
        }
    }
}
