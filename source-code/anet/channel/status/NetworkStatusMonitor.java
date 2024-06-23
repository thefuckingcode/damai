package anet.channel.status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import anet.channel.util.c;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import tb.h9;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class NetworkStatusMonitor {
    static volatile Context a = null;
    static volatile boolean b = false;
    static volatile NetworkStatusHelper.NetworkStatus c = NetworkStatusHelper.NetworkStatus.NONE;
    static volatile String d = "unknown";
    static volatile String e = "";
    static volatile String f = "";
    static volatile String g = "";
    static volatile String h = "unknown";
    static volatile String i = "";
    static volatile Pair<String, Integer> j = null;
    static volatile boolean k = false;
    static volatile List<InetAddress> l = Collections.EMPTY_LIST;
    private static volatile boolean m = false;
    private static volatile boolean n = false;
    private static ConnectivityManager o = null;
    private static TelephonyManager p = null;
    private static WifiManager q = null;
    private static SubscriptionManager r = null;
    private static Method s;
    private static Network t;
    private static BroadcastReceiver u = new BroadcastReceiver() {
        /* class anet.channel.status.NetworkStatusMonitor.AnonymousClass3 */

        public void onReceive(Context context, Intent intent) {
            if (ALog.g(1)) {
                ALog.c("awcn.NetworkStatusMonitor", "receiver:" + intent.getAction(), null, new Object[0]);
            }
            ThreadPoolExecutorFactory.i(new Runnable() {
                /* class anet.channel.status.NetworkStatusMonitor.AnonymousClass3.AnonymousClass1 */

                public void run() {
                    NetworkStatusMonitor.b();
                }
            });
        }
    };

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        public void onAvailable(Network network) {
            super.onAvailable(network);
            ALog.f("awcn.NetworkStatusMonitor", "network onAvailable", null, new Object[0]);
            NetworkStatusMonitor.b = true;
        }

        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            super.onLinkPropertiesChanged(network, linkProperties);
            NetworkStatusMonitor.l = new ArrayList(linkProperties.getDnsServers());
        }

        public void onLost(Network network) {
            super.onLost(network);
            ALog.f("awcn.NetworkStatusMonitor", "network onLost", null, new Object[0]);
            NetworkStatusMonitor.b = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        public void onAvailable(Network network) {
            super.onAvailable(network);
            Network unused = NetworkStatusMonitor.t = network;
            ALog.e("awcn.NetworkStatusMonitor", "TRANSPORT_CELLULAR onAvailable", null, new Object[0]);
        }

        public void onLost(Network network) {
            super.onLost(network);
            Network unused = NetworkStatusMonitor.t = null;
            ALog.e("awcn.NetworkStatusMonitor", "TRANSPORT_CELLULAR onLost", null, new Object[0]);
        }
    }

    static void b() {
        boolean z;
        NetworkInfo networkInfo;
        ALog.c("awcn.NetworkStatusMonitor", "[checkNetworkStatus]", null, new Object[0]);
        NetworkStatusHelper.NetworkStatus networkStatus = c;
        String str = e;
        String str2 = f;
        try {
            networkInfo = d();
            z = false;
        } catch (Exception e2) {
            try {
                ALog.d("awcn.NetworkStatusMonitor", "getNetworkInfo exception", null, e2, new Object[0]);
                n(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                networkInfo = null;
                z = true;
            } catch (Exception e3) {
                ALog.d("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, e3, new Object[0]);
                return;
            }
        }
        if (!z) {
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    ALog.f("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "info.isConnected", Boolean.valueOf(networkInfo.isConnected()), "info.isAvailable", Boolean.valueOf(networkInfo.isAvailable()), "info.getType", Integer.valueOf(networkInfo.getType()));
                    if (networkInfo.getType() == 0) {
                        String subtypeName = networkInfo.getSubtypeName();
                        String str3 = "";
                        if (!TextUtils.isEmpty(subtypeName)) {
                            str3 = subtypeName.replace(" ", str3);
                        }
                        n(i(networkInfo.getSubtype(), str3), str3);
                        e = h(networkInfo.getExtraInfo());
                        g();
                    } else if (networkInfo.getType() == 1) {
                        n(NetworkStatusHelper.NetworkStatus.WIFI, "wifi");
                        WifiInfo f2 = f();
                        if (f2 != null) {
                            g = f2.getBSSID();
                            f = f2.getSSID();
                        }
                        h = "wifi";
                        i = "wifi";
                        j = j();
                    } else {
                        n(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                    }
                    k = networkInfo.isRoaming();
                    Inet64Util.q();
                }
            }
            n(NetworkStatusHelper.NetworkStatus.NO, "no network");
            ALog.f("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "no network");
        }
        if (c != networkStatus || !e.equalsIgnoreCase(str) || !f.equalsIgnoreCase(str2)) {
            if (ALog.g(2)) {
                NetworkStatusHelper.r();
            }
            NetworkStatusHelper.q(c);
        }
    }

    static Network c() {
        if (c == NetworkStatusHelper.NetworkStatus.WIFI) {
            return t;
        }
        return null;
    }

    static NetworkInfo d() {
        if (o == null) {
            o = (ConnectivityManager) a.getSystemService("connectivity");
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(o);
    }

    static int e() {
        ConnectivityManager connectivityManager = o;
        if (connectivityManager == null || Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        return connectivityManager.getRestrictBackgroundStatus();
    }

    private static WifiInfo f() {
        try {
            if (q == null) {
                q = (WifiManager) a.getSystemService("wifi");
            }
            return q.getConnectionInfo();
        } catch (Throwable th) {
            ALog.d("awcn.NetworkStatusMonitor", "getWifiInfo", null, th, new Object[0]);
            return null;
        }
    }

    private static void g() {
        try {
            if (p == null) {
                p = (TelephonyManager) a.getSystemService("phone");
            }
            i = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimOperator(p);
            if (Build.VERSION.SDK_INT >= 22) {
                if (r == null) {
                    SubscriptionManager from = SubscriptionManager.from(a);
                    r = from;
                    s = from.getClass().getDeclaredMethod("getDefaultDataSubscriptionInfo", new Class[0]);
                }
                Method method = s;
                if (method != null) {
                    h = ((SubscriptionInfo) method.invoke(r, new Object[0])).getCarrierName().toString();
                }
            }
        } catch (Exception unused) {
        }
    }

    private static String h(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.contains("cmwap")) {
                return "cmwap";
            }
            if (lowerCase.contains("uniwap")) {
                return "uniwap";
            }
            if (lowerCase.contains("3gwap")) {
                return "3gwap";
            }
            if (lowerCase.contains("ctwap")) {
                return "ctwap";
            }
            if (lowerCase.contains("cmnet")) {
                return "cmnet";
            }
            if (lowerCase.contains("uninet")) {
                return "uninet";
            }
            if (lowerCase.contains("3gnet")) {
                return "3gnet";
            }
            if (lowerCase.contains("ctnet")) {
                return "ctnet";
            }
        }
        return "unknown";
    }

    private static NetworkStatusHelper.NetworkStatus i(int i2, String str) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkStatusHelper.NetworkStatus.G2;
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
                return NetworkStatusHelper.NetworkStatus.G3;
            case 13:
            case 18:
            case 19:
                return NetworkStatusHelper.NetworkStatus.G4;
            case 20:
                return NetworkStatusHelper.NetworkStatus.G5;
            default:
                if (str.equalsIgnoreCase("TD-SCDMA") || str.equalsIgnoreCase("WCDMA") || str.equalsIgnoreCase("CDMA2000")) {
                    return NetworkStatusHelper.NetworkStatus.G3;
                }
                return NetworkStatusHelper.NetworkStatus.NONE;
        }
    }

    private static Pair<String, Integer> j() {
        try {
            String property = System.getProperty("http.proxyHost");
            if (!TextUtils.isEmpty(property)) {
                return Pair.create(property, Integer.valueOf(Integer.parseInt(System.getProperty("http.proxyPort"))));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static void k() {
        if (h9.I()) {
            if (!c.k() || h9.y(c.d())) {
                ALog.e("awcn.NetworkStatusMonitor", "[registerCellularNetworkCallback]", null, new Object[0]);
                o.requestNetwork(new NetworkRequest.Builder().addTransportType(0).addCapability(12).build(), new b());
                return;
            }
            ALog.e("awcn.NetworkStatusMonitor", "close multi path in harmonyOS system.", null, new Object[0]);
        }
    }

    static void l() {
        if (Build.VERSION.SDK_INT >= 24 && !n) {
            NetworkInfo d2 = d();
            b = d2 != null && d2.isConnected();
            o.registerDefaultNetworkCallback(new a());
            try {
                k();
            } catch (Throwable unused) {
                ALog.e("awcn.NetworkStatusMonitor", "[registerCellularNetworkCallback]error.", null, new Object[0]);
            }
            n = true;
        }
    }

    static void m() {
        if (!m && a != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            try {
                a.registerReceiver(u, intentFilter);
            } catch (Exception unused) {
                ALog.e("awcn.NetworkStatusMonitor", "registerReceiver failed", null, new Object[0]);
            }
            b();
            m = true;
        }
    }

    private static void n(NetworkStatusHelper.NetworkStatus networkStatus, String str) {
        c = networkStatus;
        d = str;
        e = "";
        f = "";
        g = "";
        j = null;
        h = "";
        i = "";
    }
}
