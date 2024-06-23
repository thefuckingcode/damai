package com.youku.arch.probe.plugins;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.arch.analysis.net.a;
import com.youku.arch.beast.apas.remote.ApasServiceManager;
import com.youku.arch.ntk.a.g;
import com.youku.arch.ntk.a.h;
import com.youku.arch.ntk.a.i;
import com.youku.arch.ntk.a.l;
import com.youku.arch.ntk.b;
import com.youku.arch.ntk.b.f;
import com.youku.arch.probe.a.c;
import com.youku.arch.probe.plugins.BasePlugin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class d extends BasePlugin {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String c = "d";
    private List<Integer> d;
    private boolean e;
    private int f;
    private String g;
    private List<Integer> h;
    private String i;
    private int j;
    private String k;
    private String l;
    private String m;
    private int n;
    private List<Integer> o;
    private List<String> p;
    private int q;
    private volatile int r;
    private volatile int s;
    private volatile int t;
    private int u;
    private int v;
    private int w;
    private volatile String x;
    private PhoneStateListener y;

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58324898")) {
            ipChange.ipc$dispatch("-58324898", new Object[]{this});
            return;
        }
        if (this.e) {
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < this.h.size(); i4++) {
                if (this.h.get(i4).intValue() < -1) {
                    if (this.h.get(i4).intValue() < c.a) {
                        i3++;
                    }
                    i2++;
                }
            }
            if (i2 > 0) {
                double d2 = (((double) i3) * 1.0d) / ((double) i2);
                if (d2 > 0.5d) {
                    this.v = 1;
                } else if (d2 > 0.2d) {
                    this.v = 2;
                } else {
                    this.v = 3;
                }
            } else {
                this.v = 0;
            }
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < this.o.size(); i7++) {
                if (this.o.get(i7).intValue() > 0) {
                    if (this.o.get(i7).intValue() > c.c) {
                        i6++;
                    }
                    i5++;
                }
            }
            if (i5 > 0) {
                double d3 = (((double) i6) * 1.0d) / ((double) i5);
                if (d3 > 0.5d) {
                    this.w = 1;
                    return;
                } else if (d3 > 0.2d) {
                    this.w = 2;
                    return;
                } else {
                    this.w = 3;
                    return;
                }
            }
        } else {
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < this.d.size(); i10++) {
                if (this.d.get(i10).intValue() >= 0 && this.d.get(i10).intValue() < 10) {
                    if (this.d.get(i10).intValue() < c.b) {
                        i9++;
                    }
                    i8++;
                }
            }
            if (i8 > 0) {
                double d4 = (((double) i9) * 1.0d) / ((double) i8);
                if (d4 > 0.5d) {
                    this.v = 1;
                } else if (d4 > 0.2d) {
                    this.v = 2;
                } else {
                    this.v = 3;
                }
            } else {
                this.v = 0;
            }
        }
        this.w = 0;
    }

    private String g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-223417981")) {
            return (String) ipChange.ipc$dispatch("-223417981", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder("netType:");
        sb.append(this.e ? "wifi" : "mobile_" + this.f);
        sb.append(",signalStrength:");
        for (Integer num : this.d) {
            sb.append(num.intValue());
            sb.append("|");
        }
        sb.append(",ipv4:");
        sb.append(this.k);
        sb.append(",ipv6:");
        sb.append(this.l);
        sb.append(",ssid:");
        sb.append(this.g);
        sb.append(",rssi:");
        for (Integer num2 : this.h) {
            sb.append(num2.intValue());
            sb.append("|");
        }
        sb.append(",freq:");
        sb.append(this.i);
        sb.append(",metered:");
        sb.append(this.j);
        sb.append(",gate_ip:");
        sb.append(this.m);
        sb.append(",RTTs:");
        for (Integer num3 : this.o) {
            sb.append(num3.intValue());
            sb.append("|");
        }
        sb.append(",devCnt:");
        sb.append(this.p.size());
        sb.append(",qualityCode:");
        sb.append(this.n);
        return sb.toString();
    }

    private boolean h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-58265312")) {
            return "1".equals(ApasServiceManager.getInstance().getConfig("speed_test", "check_fd_leak", "1")) && b.b().a();
        }
        return ((Boolean) ipChange.ipc$dispatch("-58265312", new Object[]{this})).booleanValue();
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58235525")) {
            ipChange.ipc$dispatch("-58235525", new Object[]{this});
            return;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        if (nextElement instanceof Inet6Address) {
                            this.l = nextElement.getHostAddress();
                        } else {
                            this.k = nextElement.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private int j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58205747")) {
            return ((Integer) ipChange.ipc$dispatch("-58205747", new Object[]{this})).intValue();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.b.getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            int networkType = Build.VERSION.SDK_INT < 30 ? com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(telephonyManager) : com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDataNetworkType(telephonyManager);
            if (networkType == 14 || networkType == 15) {
                return 3;
            }
            if (networkType == 20) {
                return 5;
            }
            switch (networkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                    return 3;
                default:
                    return 4;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public a a(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2146301069")) {
            return (a) ipChange.ipc$dispatch("2146301069", new Object[]{this, aVar});
        } else if (aVar == null) {
            return null;
        } else {
            aVar.a = this.v;
            aVar.b = this.w;
            aVar.f = this.e;
            return aVar;
        }
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58473853")) {
            ipChange.ipc$dispatch("-58473853", new Object[]{this});
            return;
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.b.getSystemService("phone");
        if (telephonyManager != null) {
            telephonyManager.listen(this.y, 0);
        }
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public void a(BasePlugin.NotiType notiType) {
        String extraInfo;
        l[] lVarArr;
        com.youku.arch.ntk.a.b bVar;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "991645557")) {
            ipChange.ipc$dispatch("991645557", new Object[]{this, notiType});
            return;
        }
        this.q++;
        String str2 = c;
        com.youku.b.a.a.a(str2, "trigger begins type:" + notiType);
        ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo.isConnected()) {
                this.e = true;
                WifiManager wifiManager = (WifiManager) this.b.getApplicationContext().getSystemService("wifi");
                if (wifiManager != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    connectionInfo.getIpAddress();
                    if (TextUtils.isEmpty(connectionInfo.getSSID()) || "<unknown ssid>".equals(connectionInfo.getSSID())) {
                        com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
                        extraInfo = TextUtils.isEmpty(networkInfo.getExtraInfo()) ? "unknown" : networkInfo.getExtraInfo();
                    } else {
                        extraInfo = connectionInfo.getSSID();
                    }
                    this.g = extraInfo;
                    this.h.add(Integer.valueOf(connectionInfo.getRssi()));
                    this.t = connectionInfo.getRssi();
                    if (this.h.size() > this.u) {
                        this.h.remove(0);
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        int frequency = connectionInfo.getFrequency();
                        if (frequency >= 2000 && frequency < 3000) {
                            str = "2.4G";
                        } else if (frequency >= 5000) {
                            str = "5G";
                        } else {
                            str = "unknown(" + frequency + jl1.BRACKET_END_STR;
                        }
                        this.i = str;
                    } else {
                        this.i = "unknown";
                    }
                    i();
                    this.m = com.youku.arch.probe.a.b.a((long) wifiManager.getDhcpInfo().gateway);
                    if (h()) {
                        this.o.add(-2);
                        this.s = -2;
                        if (this.o.size() > this.u) {
                            this.o.remove(0);
                        }
                    } else {
                        f.a aVar = new f.a();
                        aVar.b = !TextUtils.isEmpty(this.m) ? this.m : "www.youku.com";
                        aVar.c = 0;
                        aVar.e = 1;
                        aVar.d = "";
                        aVar.f = 5000;
                        aVar.a = 2;
                        JSONObject parseObject = JSON.parseObject(JSON.toJSONString(aVar));
                        i iVar = new i();
                        iVar.f = new JSONObject[]{parseObject};
                        iVar.b = 0;
                        g a = b.b().a(new h(), iVar);
                        if (!(a == null || (lVarArr = a.c) == null || lVarArr.length <= 0 || (bVar = lVarArr[0].a[0]) == null)) {
                            if (TextUtils.isEmpty(bVar.a) && !jl1.MUL.equals(bVar.a)) {
                                this.m = bVar.a;
                            }
                            this.o.add(Integer.valueOf(bVar.b[0]));
                            int[] iArr = bVar.b;
                            if (iArr[0] > 0) {
                                this.s = iArr[0];
                            }
                            if (this.o.size() > this.u) {
                                this.o.remove(0);
                            }
                        }
                        if (notiType == BasePlugin.NotiType.LOOP && this.q % c.g == 1) {
                            d();
                        }
                    }
                }
            } else {
                this.f = j();
                i();
                this.e = false;
            }
            this.d.add(Integer.valueOf(this.r));
            if (this.d.size() > this.u) {
                this.d.remove(0);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.j = connectivityManager.isActiveNetworkMetered() ? 1 : 0;
            }
        }
        this.n = c();
        f();
        this.x = g();
        com.youku.b.a.a.a(str2, "trigger ends");
        AdapterForTLog.loge("speedtest", b());
    }

    public String b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1280172546")) {
            return this.x;
        }
        return (String) ipChange.ipc$dispatch("-1280172546", new Object[]{this});
    }

    public int c() {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-58414284")) {
            return ((Integer) ipChange.ipc$dispatch("-58414284", new Object[]{this})).intValue();
        } else if (this.e) {
            if (!this.h.isEmpty()) {
                List<Integer> list = this.h;
                if (list.get(list.size() - 1).intValue() < c.a) {
                    return 1102;
                }
            }
            if (!this.o.isEmpty()) {
                for (Integer num : this.o) {
                    int intValue = num.intValue();
                    if (intValue < 0 || intValue > c.c) {
                        i2++;
                    }
                }
                if ((((double) i2) * 1.0d) / ((double) this.o.size()) >= 0.5d) {
                    return 1103;
                }
            }
            return 1100;
        } else if (this.r < 2) {
            return SecExceptionCode.SEC_ERROE_OPENSDK_UNSUPPORTED_VERSION;
        } else {
            return 1100;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008e, code lost:
        if (r4 != null) goto L_0x0090;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080 A[Catch:{ SocketException -> 0x0089, UnknownHostException -> 0x0081, IOException -> 0x0079, all -> 0x0076, all -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0088 A[Catch:{ SocketException -> 0x0089, UnknownHostException -> 0x0081, IOException -> 0x0079, all -> 0x0076, all -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bb A[Catch:{ IOException -> 0x00e1, all -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00da A[EDGE_INSN: B:49:0x00da->B:50:? ?: BREAK  , SYNTHETIC, Splitter:B:49:0x00da] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f7 A[SYNTHETIC, Splitter:B:64:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0104  */
    public void d() {
        Throwable th;
        Throwable th2;
        IOException e2;
        BufferedReader bufferedReader;
        String readLine;
        SocketException e3;
        UnknownHostException e4;
        IOException e5;
        IpChange ipChange = $ipChange;
        DatagramSocket datagramSocket = null;
        if (AndroidInstantRuntime.support(ipChange, "-58384480")) {
            ipChange.ipc$dispatch("-58384480", new Object[]{this});
            return;
        }
        com.youku.b.a.a.a(c, "scanDevices begin");
        AdapterForTLog.loge("speedtest", "scanDevices begin");
        if (!TextUtils.isEmpty(this.k)) {
            String str = this.k;
            String substring = str.substring(0, str.lastIndexOf(".") + 1);
            DatagramPacket datagramPacket = new DatagramPacket(new byte[0], 0, 0);
            BufferedReader bufferedReader2 = null;
            DatagramSocket datagramSocket2 = null;
            try {
                datagramSocket = new DatagramSocket();
                int i2 = 2;
                while (i2 < 255) {
                    try {
                        datagramPacket.setAddress(InetAddress.getByName(substring + i2));
                        datagramSocket.send(datagramPacket);
                        i2++;
                        if (i2 == 125) {
                            datagramSocket.close();
                            datagramSocket = new DatagramSocket();
                        }
                    } catch (SocketException e6) {
                        e3 = e6;
                        e3.printStackTrace();
                    } catch (UnknownHostException e7) {
                        e4 = e7;
                        e4.printStackTrace();
                        if (datagramSocket != null) {
                        }
                        new HashMap();
                        bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat proc/net/arp").getInputStream()));
                        this.p.clear();
                        while (true) {
                            readLine = bufferedReader.readLine();
                            if (readLine == null) {
                            }
                        }
                        bufferedReader.close();
                        AdapterForTLog.loge("speedtest", "scanDevices end");
                    } catch (IOException e8) {
                        e5 = e8;
                        e5.printStackTrace();
                        if (datagramSocket != null) {
                        }
                        new HashMap();
                        bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat proc/net/arp").getInputStream()));
                        this.p.clear();
                        while (true) {
                            readLine = bufferedReader.readLine();
                            if (readLine == null) {
                            }
                        }
                        bufferedReader.close();
                        AdapterForTLog.loge("speedtest", "scanDevices end");
                    }
                }
            } catch (SocketException e9) {
                e3 = e9;
                datagramSocket = null;
                e3.printStackTrace();
            } catch (UnknownHostException e10) {
                e4 = e10;
                datagramSocket = null;
                e4.printStackTrace();
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                new HashMap();
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat proc/net/arp").getInputStream()));
                this.p.clear();
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                    }
                }
                bufferedReader.close();
                AdapterForTLog.loge("speedtest", "scanDevices end");
            } catch (IOException e11) {
                e5 = e11;
                datagramSocket = null;
                e5.printStackTrace();
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                new HashMap();
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat proc/net/arp").getInputStream()));
                this.p.clear();
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                    }
                }
                bufferedReader.close();
                AdapterForTLog.loge("speedtest", "scanDevices end");
            } catch (Throwable th3) {
                th = th3;
                datagramSocket2 = datagramSocket;
                if (datagramSocket2 != null) {
                }
                throw th;
            }
            datagramSocket.close();
            new HashMap();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat proc/net/arp").getInputStream()));
                try {
                    this.p.clear();
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            try {
                                break;
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        } else if (!readLine.contains(com.alipay.sdk.m.u.c.b) && !readLine.contains("IP")) {
                            this.p.add(readLine.split("\\s+")[3]);
                        }
                    }
                    bufferedReader.close();
                } catch (IOException e13) {
                    e2 = e13;
                    bufferedReader2 = bufferedReader;
                    try {
                        e2.printStackTrace();
                        if (bufferedReader2 != null) {
                        }
                        AdapterForTLog.loge("speedtest", "scanDevices end");
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e14) {
                                e14.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    throw th2;
                }
            } catch (IOException e15) {
                e2 = e15;
                e2.printStackTrace();
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                AdapterForTLog.loge("speedtest", "scanDevices end");
            }
        }
        AdapterForTLog.loge("speedtest", "scanDevices end");
    }

    public Map<String, Integer> e() {
        String str;
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "621362164")) {
            return (Map) ipChange.ipc$dispatch("621362164", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("isWifi", Integer.valueOf(this.e ? 1 : 0));
        if (this.e) {
            hashMap.put("rssi", Integer.valueOf(this.t));
            num = Integer.valueOf(this.s);
            str = "rtt";
        } else {
            num = Integer.valueOf(this.r);
            str = "signalStrength";
        }
        hashMap.put(str, num);
        return hashMap;
    }
}
