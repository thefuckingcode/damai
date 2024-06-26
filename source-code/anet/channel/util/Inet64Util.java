package anet.channel.util;

import android.text.TextUtils;
import anet.channel.statist.NetTypeStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.android.netutil.UdpConnectType;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import tb.h9;
import tb.ss0;
import tb.ug1;
import tb.w6;

/* compiled from: Taobao */
public class Inet64Util {
    public static final int IPV4_ONLY = 1;
    public static final int IPV6_ONLY = 2;
    public static final int IP_DUAL_STACK = 3;
    public static final int IP_STACK_UNKNOWN = 0;
    static final byte[][] a = {new byte[]{-64, 0, 0, -86}, new byte[]{-64, 0, 0, -85}};
    static volatile String b;
    static ug1 c;
    public static volatile String d = null;
    public static volatile String e = null;
    public static volatile int f;
    public static volatile int g;
    static ConcurrentHashMap<String, ug1> h = new ConcurrentHashMap<>();
    static ConcurrentHashMap<String, Integer> i = new ConcurrentHashMap<>();

    static {
        b = null;
        c = null;
        try {
            c = new ug1((Inet6Address) InetAddress.getAllByName("64:ff9b::")[0], 96);
            b = i(NetworkStatusHelper.i());
        } catch (Exception unused) {
        }
    }

    public static String d(Inet4Address inet4Address) throws Exception {
        if (inet4Address != null) {
            ug1 m = m();
            if (m != null) {
                byte[] address = inet4Address.getAddress();
                byte[] address2 = m.b.getAddress();
                int i2 = m.a / 8;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    int i5 = i3 + i2;
                    if (i5 <= 15 && i4 < 4) {
                        if (i5 != 8) {
                            address2[i5] = (byte) (address[i4] | address2[i5]);
                            i4++;
                        }
                        i3++;
                    }
                }
                return InetAddress.getByAddress(address2).getHostAddress();
            }
            throw new Exception("cannot get nat64 prefix");
        }
        throw new InvalidParameterException("address in null");
    }

    public static String e(String str) throws Exception {
        return d((Inet4Address) Inet4Address.getByName(str));
    }

    /* access modifiers changed from: private */
    public static int f() {
        int i2;
        Throwable th;
        int k;
        try {
            i2 = l();
            try {
                if (h9.F() && i2 == 3 && (k = k()) == 1) {
                    ALog.e("awcn.Inet64Util", "startIpStackDetect", null, "ip stack", Integer.valueOf(i2), "new stack", Integer.valueOf(k));
                    i2 = k;
                }
            } catch (Throwable th2) {
                th = th2;
                ALog.d("awcn.Inet64Util", "[detectIpStack]error.", null, th, new Object[0]);
                ALog.e("awcn.Inet64Util", "startIpStackDetect", null, "ip stack", Integer.valueOf(i2), "detectType", "udp_connect");
                return i2;
            }
        } catch (Throwable th3) {
            th = th3;
            i2 = 0;
            ALog.d("awcn.Inet64Util", "[detectIpStack]error.", null, th, new Object[0]);
            ALog.e("awcn.Inet64Util", "startIpStackDetect", null, "ip stack", Integer.valueOf(i2), "detectType", "udp_connect");
            return i2;
        }
        ALog.e("awcn.Inet64Util", "startIpStackDetect", null, "ip stack", Integer.valueOf(i2), "detectType", "udp_connect");
        return i2;
    }

    /* access modifiers changed from: private */
    public static ug1 g() throws UnknownHostException {
        InetAddress inetAddress;
        boolean z;
        try {
            inetAddress = InetAddress.getByName("ipv4only.arpa");
        } catch (Exception unused) {
            inetAddress = null;
        }
        if (inetAddress instanceof Inet6Address) {
            ALog.f("awcn.Inet64Util", "Resolved AAAA: " + inetAddress.toString(), null, new Object[0]);
            byte[] address = inetAddress.getAddress();
            if (address.length != 16) {
                return null;
            }
            int i2 = 12;
            while (true) {
                z = true;
                if (i2 < 0) {
                    z = false;
                    break;
                }
                byte b2 = address[i2];
                byte[][] bArr = a;
                if ((b2 & bArr[0][0]) != 0 && address[i2 + 1] == 0 && address[i2 + 2] == 0) {
                    int i3 = i2 + 3;
                    if (address[i3] == bArr[0][3] || address[i3] == bArr[1][3]) {
                        break;
                    }
                }
                i2--;
            }
            if (z) {
                address[i2 + 3] = 0;
                address[i2 + 2] = 0;
                address[i2 + 1] = 0;
                address[i2] = 0;
                return new ug1(Inet6Address.getByAddress("ipv4only.arpa", address, 0), i2 * 8);
            }
        } else if (inetAddress instanceof Inet4Address) {
            ALog.f("awcn.Inet64Util", "Resolved A: " + inetAddress.toString(), null, new Object[0]);
        }
        return null;
    }

    private static boolean h(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    /* access modifiers changed from: private */
    public static String i(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (networkStatus.isWifi()) {
            String k = NetworkStatusHelper.k();
            if (TextUtils.isEmpty(k)) {
                k = "";
            }
            return "WIFI$" + k;
        } else if (!networkStatus.isMobile()) {
            return "UnknownNetwork";
        } else {
            return networkStatus.getType() + "$" + NetworkStatusHelper.b();
        }
    }

    public static void j() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    ALog.f("awcn.Inet64Util", "find NetworkInterface:" + displayName, null, new Object[0]);
                    if (displayName.toLowerCase().startsWith("wlan0") && NetworkStatusHelper.i().isWifi()) {
                        for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                            InetAddress address = interfaceAddress.getAddress();
                            if (address instanceof Inet6Address) {
                                e = address.getHostAddress();
                                g = networkInterface.getMTU();
                            } else if (address instanceof Inet4Address) {
                                d = address.getHostAddress();
                                f = networkInterface.getMTU();
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private static int k() throws SocketException {
        String str;
        int i2;
        TreeMap treeMap = new TreeMap();
        Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        while (true) {
            str = null;
            i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            NetworkInterface networkInterface = (NetworkInterface) it.next();
            if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                String displayName = networkInterface.getDisplayName();
                ALog.f("awcn.Inet64Util", "find NetworkInterface:" + displayName, null, new Object[0]);
                int i3 = 0;
                for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                    InetAddress address = interfaceAddress.getAddress();
                    if (address instanceof Inet6Address) {
                        Inet6Address inet6Address = (Inet6Address) address;
                        if (!h(inet6Address)) {
                            ALog.e("awcn.Inet64Util", "Found IPv6 address:" + inet6Address.toString(), null, new Object[0]);
                            i3 |= 2;
                        }
                    } else if (address instanceof Inet4Address) {
                        Inet4Address inet4Address = (Inet4Address) address;
                        if (!h(inet4Address) && !inet4Address.getHostAddress().startsWith("192.168.43.")) {
                            ALog.e("awcn.Inet64Util", "Found IPv4 address:" + inet4Address.toString(), null, new Object[0]);
                            i3 |= 1;
                        }
                    }
                }
                if (i3 != 0) {
                    treeMap.put(displayName.toLowerCase(), Integer.valueOf(i3));
                }
            }
        }
        if (treeMap.isEmpty()) {
            return 0;
        }
        if (treeMap.size() == 1) {
            return ((Integer) treeMap.firstEntry().getValue()).intValue();
        }
        if (NetworkStatusHelper.i().isWifi()) {
            str = "wlan";
        } else if (NetworkStatusHelper.i().isMobile()) {
            str = "rmnet";
        }
        if (str != null) {
            Iterator it2 = treeMap.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it2.next();
                if (((String) entry.getKey()).startsWith(str)) {
                    i2 = ((Integer) entry.getValue()).intValue();
                    break;
                }
            }
        }
        return (i2 != 2 || !treeMap.containsKey("v4-wlan0")) ? i2 : i2 | ((Integer) treeMap.remove("v4-wlan0")).intValue();
    }

    private static int l() {
        SpdyAgent.getInstance(ss0.c(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        boolean a2 = UdpConnectType.a();
        if (UdpConnectType.b()) {
            return (a2 ? 1 : 0) | 2;
        }
        return a2 ? 1 : 0;
    }

    public static ug1 m() {
        ug1 ug1 = h.get(b);
        return ug1 == null ? c : ug1;
    }

    public static int n() {
        Integer num = i.get(b);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static boolean o() {
        Integer num = i.get(b);
        if (num == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public static boolean p() {
        Integer num;
        if (h9.D() && (num = i.get(b)) != null && num.intValue() == 2) {
            return true;
        }
        return false;
    }

    public static void q() {
        b = i(NetworkStatusHelper.i());
        if (i.putIfAbsent(b, 0) == null) {
            int f2 = f();
            i.put(b, Integer.valueOf(f2));
            final NetTypeStat netTypeStat = new NetTypeStat();
            netTypeStat.ipStackType = f2;
            final String str = b;
            if (f2 == 2 || f2 == 3) {
                ThreadPoolExecutorFactory.j(new Runnable() {
                    /* class anet.channel.util.Inet64Util.AnonymousClass1 */

                    public void run() {
                        ThreadPoolExecutorFactory.g(new Runnable() {
                            /* class anet.channel.util.Inet64Util.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                ug1 g;
                                try {
                                    if (str.equals(Inet64Util.i(NetworkStatusHelper.i()))) {
                                        ALog.e("awcn.Inet64Util", "startIpStackDetect double check", null, new Object[0]);
                                        int f = Inet64Util.f();
                                        AnonymousClass1 r1 = AnonymousClass1.this;
                                        if (netTypeStat.ipStackType != f) {
                                            Inet64Util.i.put(str, Integer.valueOf(f));
                                            NetTypeStat netTypeStat = netTypeStat;
                                            netTypeStat.lastIpStackType = netTypeStat.ipStackType;
                                            netTypeStat.ipStackType = f;
                                        }
                                        if ((f == 2 || f == 3) && (g = Inet64Util.g()) != null) {
                                            Inet64Util.h.put(str, g);
                                            netTypeStat.nat64Prefix = g.toString();
                                        }
                                        if (ss0.j()) {
                                            w6.b().commitStat(netTypeStat);
                                        }
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }, ThreadPoolExecutorFactory.b.c);
                    }
                }, 1500, TimeUnit.MILLISECONDS);
            } else if (ss0.j()) {
                w6.b().commitStat(netTypeStat);
            }
        }
    }
}
