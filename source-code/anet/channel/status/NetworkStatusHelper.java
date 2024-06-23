package anet.channel.status;

import android.content.Context;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.ag2;
import tb.ov1;

/* compiled from: Taobao */
public class NetworkStatusHelper {
    private static boolean a;
    static CopyOnWriteArraySet<INetworkStatusChangeListener> b = new CopyOnWriteArraySet<>();

    /* compiled from: Taobao */
    public interface INetworkStatusChangeListener {
        void onNetworkStatusChanged(NetworkStatus networkStatus);
    }

    /* compiled from: Taobao */
    public enum NetworkStatus {
        NONE,
        NO,
        G2,
        G3,
        G4,
        WIFI,
        G5;

        public String getType() {
            if (this == G2) {
                return "2G";
            }
            if (this == G3) {
                return "3G";
            }
            if (this == G4) {
                return "4G";
            }
            if (this == G5) {
                return "5G";
            }
            return toString();
        }

        public boolean isMobile() {
            return this == G2 || this == G3 || this == G4 || this == G5;
        }

        public boolean isWifi() {
            return this == WIFI;
        }
    }

    public static void a(INetworkStatusChangeListener iNetworkStatusChangeListener) {
        b.add(iNetworkStatusChangeListener);
    }

    public static String b() {
        return NetworkStatusMonitor.e;
    }

    public static String c() {
        return NetworkStatusMonitor.h;
    }

    public static Network d() {
        return NetworkStatusMonitor.c();
    }

    public static String e() {
        return NetworkStatusMonitor.d;
    }

    public static String f() {
        NetworkStatus networkStatus = NetworkStatusMonitor.c;
        if (networkStatus == NetworkStatus.WIFI && l() != null) {
            return "proxy";
        }
        if (networkStatus.isMobile() && NetworkStatusMonitor.e.contains("wap")) {
            return "wap";
        }
        if (!networkStatus.isMobile()) {
            return "";
        }
        ov1.a();
        return "";
    }

    public static int g() {
        return NetworkStatusMonitor.e();
    }

    public static String h() {
        return NetworkStatusMonitor.i;
    }

    public static NetworkStatus i() {
        return NetworkStatusMonitor.c;
    }

    public static String j(NetworkStatus networkStatus) {
        String str = "";
        if (networkStatus.isWifi()) {
            String h = ag2.h(k());
            if (!TextUtils.isEmpty(h)) {
                str = h;
            }
            return "WIFI$" + str;
        } else if (!networkStatus.isMobile()) {
            return str;
        } else {
            return networkStatus.getType() + "$" + b();
        }
    }

    public static String k() {
        return NetworkStatusMonitor.g;
    }

    public static Pair<String, Integer> l() {
        if (NetworkStatusMonitor.c != NetworkStatus.WIFI) {
            return null;
        }
        return NetworkStatusMonitor.j;
    }

    public static String m() {
        return NetworkStatusMonitor.f;
    }

    public static boolean n() {
        if (Build.VERSION.SDK_INT >= 24) {
            if (NetworkStatusMonitor.b) {
                return true;
            }
        } else if (NetworkStatusMonitor.c != NetworkStatus.NO) {
            return true;
        }
        try {
            NetworkInfo d = NetworkStatusMonitor.d();
            if (d == null || !d.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean o() {
        NetworkStatus networkStatus = NetworkStatusMonitor.c;
        String str = NetworkStatusMonitor.e;
        if (networkStatus == NetworkStatus.WIFI && l() != null) {
            return true;
        }
        if (!networkStatus.isMobile()) {
            return false;
        }
        if (str.contains("wap")) {
            return true;
        }
        ov1.a();
        return false;
    }

    public static boolean p() {
        return NetworkStatusMonitor.k;
    }

    static void q(final NetworkStatus networkStatus) {
        ThreadPoolExecutorFactory.i(new Runnable() {
            /* class anet.channel.status.NetworkStatusHelper.AnonymousClass1 */

            public void run() {
                try {
                    Iterator<INetworkStatusChangeListener> it = NetworkStatusHelper.b.iterator();
                    while (it.hasNext()) {
                        INetworkStatusChangeListener next = it.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        next.onNetworkStatusChanged(networkStatus);
                        if (System.currentTimeMillis() - currentTimeMillis > 500) {
                            ALog.e("awcn.NetworkStatusHelper", "call back cost too much time", null, "listener", next);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public static void r() {
        try {
            NetworkStatus i = i();
            StringBuilder sb = new StringBuilder(128);
            sb.append("\nNetwork detail*******************************\n");
            sb.append("Status: ");
            sb.append(i.getType());
            sb.append('\n');
            sb.append("Subtype: ");
            sb.append(e());
            sb.append('\n');
            if (i != NetworkStatus.NO) {
                if (i.isMobile()) {
                    sb.append("Apn: ");
                    sb.append(b());
                    sb.append('\n');
                    sb.append("Carrier: ");
                    sb.append(c());
                    sb.append('\n');
                } else {
                    sb.append("BSSID: ");
                    sb.append(k());
                    sb.append('\n');
                    sb.append("SSID: ");
                    sb.append(m());
                    sb.append('\n');
                }
            }
            if (o()) {
                sb.append("Proxy: ");
                sb.append(f());
                sb.append('\n');
                Pair<String, Integer> l = l();
                if (l != null) {
                    sb.append("ProxyHost: ");
                    sb.append((String) l.first);
                    sb.append('\n');
                    sb.append("ProxyPort: ");
                    sb.append(l.second);
                    sb.append('\n');
                }
            }
            sb.append("*********************************************");
            ALog.f("awcn.NetworkStatusHelper", sb.toString(), null, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static void s(INetworkStatusChangeListener iNetworkStatusChangeListener) {
        b.remove(iNetworkStatusChangeListener);
    }

    public static synchronized void t(Context context) {
        synchronized (NetworkStatusHelper.class) {
            if (context == null) {
                throw new NullPointerException("context is null");
            } else if (!a) {
                NetworkStatusMonitor.a = context;
                NetworkStatusMonitor.m();
                try {
                    NetworkStatusMonitor.l();
                } catch (Throwable unused) {
                    ALog.e("awcn.NetworkStatusHelper", "[registerNetworkCallback]error.", null, new Object[0]);
                }
                a = true;
            }
        }
    }
}
