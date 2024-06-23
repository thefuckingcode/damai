package com.youku.arch.probe.plugins;

import android.net.TrafficStats;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.arch.analysis.net.d;
import com.youku.arch.probe.a.c;
import com.youku.arch.probe.plugins.BasePlugin;
import com.youku.network.c.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import ntk.dns.DnsEngine;

/* compiled from: Taobao */
public class b extends BasePlugin implements a.AbstractC0258a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String c = "b";
    public static int h = 2;
    private volatile String A;
    private volatile String B;
    private int C;
    private Map<String, String> D;
    private boolean E;
    private volatile int F;
    private int G;
    private volatile String H;
    private int I;
    private int J;
    private int K;
    private List<Integer> L;
    private double M;
    private double N;
    private double O;
    public volatile int d;
    public volatile int e;
    public volatile int f;
    public volatile int g;
    int i;
    private List<com.youku.arch.probe.b.b> j;
    private volatile com.youku.arch.probe.b.b k;
    private volatile int l;
    private volatile int m;
    private volatile double n;
    private volatile long o;
    private List<Integer> p;
    private List<Integer> q;
    private volatile double r;
    private volatile double s;
    private double t;
    private double u;
    private double v;
    private int w;
    private volatile int x;
    private volatile String y;
    private volatile String z;

    /* compiled from: Taobao */
    public class a {
        public String a;
        public String b;
        public long c;
        public long d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public int j;
    }

    public static String a(ArrayList<Double> arrayList, double d2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1904505113")) {
            return (String) ipChange.ipc$dispatch("-1904505113", new Object[]{arrayList, Double.valueOf(d2)});
        }
        int size = arrayList.size();
        if (size == 0) {
            return "-1";
        }
        if (size == 1) {
            return arrayList.get(0).toString();
        }
        double d3 = (((double) (size - 1)) * (d2 / 100.0d)) + 1.0d;
        int i2 = (int) d3;
        int i3 = i2 - 1;
        return String.format(Locale.ENGLISH, "%.2f", Double.valueOf(arrayList.get(i3).doubleValue() + ((arrayList.get(i2).doubleValue() - arrayList.get(i3).doubleValue()) * (d3 - ((double) i2)))));
    }

    private void a(com.youku.arch.probe.b.b bVar, String str) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "753542253")) {
            ipChange.ipc$dispatch("753542253", new Object[]{this, bVar, str});
        } else if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(";");
            if (split.length > 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                for (String str2 : split) {
                    String[] split2 = str2.split("&");
                    for (String str3 : split2) {
                        if (str3.contains("tcpi_rtt=") && !TextUtils.isEmpty(str3.substring(9))) {
                            arrayList.add(Long.valueOf(Long.parseLong(str3.substring(9))));
                        }
                        if (str3.contains("tcpi_rttvar=") && !TextUtils.isEmpty(str3.substring(12))) {
                            arrayList2.add(Long.valueOf(Long.parseLong(str3.substring(12))));
                        }
                        if (str3.contains("tcpi_speed=") && !TextUtils.isEmpty(str3.substring(11))) {
                            arrayList3.add(Long.valueOf((long) (Double.parseDouble(str3.substring(11)) / 1000.0d)));
                        }
                        if (str3.contains("tcpi_lastrev=") && !TextUtils.isEmpty(str3.substring(13))) {
                            arrayList4.add(Long.valueOf(Long.parseLong(str3.substring(13))));
                        }
                    }
                }
                Collections.sort(arrayList);
                Collections.sort(arrayList3);
                Collections.sort(arrayList4);
                Collections.sort(arrayList2);
                if (arrayList.size() > 0) {
                    bVar.b = ((Long) arrayList.get(arrayList.size() / 2)).longValue();
                }
                if (arrayList2.size() > 0) {
                    bVar.c = ((Long) arrayList2.get(arrayList2.size() / 2)).longValue();
                }
                if (arrayList3.size() > 0) {
                    i2 = 1;
                    bVar.d = ((Long) arrayList3.get(arrayList3.size() - 1)).longValue();
                } else {
                    i2 = 1;
                }
                if (arrayList4.size() > 0) {
                    bVar.e = ((Long) arrayList4.get(arrayList4.size() - i2)).longValue();
                }
            }
        }
    }

    private String g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-363966591")) {
            return (String) ipChange.ipc$dispatch("-363966591", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder("mtop_rt:");
        StringBuilder sb2 = new StringBuilder("nc_rt:");
        StringBuilder sb3 = new StringBuilder("nc_rt_var:");
        StringBuilder sb4 = new StringBuilder("tcpi_speed:");
        StringBuilder sb5 = new StringBuilder("tcpi_last_recv:");
        StringBuilder sb6 = new StringBuilder("rx_byte:");
        for (com.youku.arch.probe.b.b bVar : this.j) {
            sb.append(bVar.a);
            sb.append("|");
            sb2.append(bVar.b);
            sb2.append("|");
            sb3.append(bVar.c);
            sb3.append("|");
            sb4.append(bVar.d);
            sb4.append("|");
            sb5.append(bVar.e);
            sb5.append("|");
            sb6.append(bVar.f);
            sb6.append("|");
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append((CharSequence) sb);
        sb7.append(",");
        sb7.append((CharSequence) sb2);
        sb7.append(",");
        sb7.append((CharSequence) sb3);
        sb7.append(",");
        sb7.append((CharSequence) sb4);
        sb7.append(",");
        sb7.append((CharSequence) sb5);
        sb7.append(",");
        sb7.append("traffic_info:");
        sb7.append(this.q);
        sb7.append(",");
        sb7.append((CharSequence) sb6);
        sb7.append(",");
        sb7.append("nc_type:");
        sb7.append(this.d);
        sb7.append(",last_speed:");
        sb7.append(this.r);
        sb7.append(",cur_hh_bw:");
        sb7.append(this.z);
        sb7.append(",bw_day:");
        sb7.append(this.C);
        if (com.youku.arch.probe.a.a.r > 0) {
            sb7.append(",fre_4G_bw:");
            sb7.append(this.A);
            sb7.append(",fre_4G_t:");
            sb7.append(this.B);
        }
        return sb7.toString();
    }

    /* access modifiers changed from: private */
    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751081310")) {
            ipChange.ipc$dispatch("751081310", new Object[]{this});
        } else if (this.b != null) {
            File file = new File(this.b.getFilesDir().getAbsolutePath(), "NetBW.log");
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public com.youku.arch.analysis.net.a a(com.youku.arch.analysis.net.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1656040053")) {
            return (com.youku.arch.analysis.net.a) ipChange.ipc$dispatch("-1656040053", new Object[]{this, aVar});
        } else if (aVar == null) {
            return null;
        } else {
            aVar.c = this.e;
            aVar.d = this.f;
            aVar.e = this.g;
            return aVar;
        }
    }

    public String a(boolean z2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1454883065")) {
            return (String) ipChange.ipc$dispatch("-1454883065", new Object[]{this, Boolean.valueOf(z2), str});
        }
        if (this.E) {
            if (!z2) {
                str = "4G";
            } else if (str == null || !com.youku.arch.probe.a.b.a(str)) {
                str = "unknown";
            }
            String str2 = this.D.containsKey(str) ? this.D.get(str) : "";
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return "";
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "750872773")) {
            ipChange.ipc$dispatch("750872773", new Object[]{this});
            return;
        }
        com.youku.network.c.a.a(this);
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public void a(BasePlugin.NotiType notiType) {
        int i2;
        Integer num;
        List list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "557916471")) {
            ipChange.ipc$dispatch("557916471", new Object[]{this, notiType});
            return;
        }
        this.I++;
        com.youku.arch.probe.b.b bVar = new com.youku.arch.probe.b.b();
        synchronized (this) {
            bVar.a = this.l;
            this.l = 0;
            Collections.sort(this.L);
            if (this.L.size() > 0) {
                List<Integer> list2 = this.L;
                i2 = list2.get(list2.size() / 2).intValue();
            } else {
                i2 = 0;
            }
            this.L.clear();
        }
        if (i2 > 0) {
            this.m = i2;
            this.n = (double) (System.currentTimeMillis() / 1000);
        }
        if (this.F == 1) {
            long totalRxBytes = TrafficStats.getTotalRxBytes();
            if (this.o > totalRxBytes) {
                this.o = 0;
            }
            if (this.o > 0) {
                long j2 = ((totalRxBytes - this.o) / 1000) / ((long) this.J);
                bVar.f = j2;
                if (j2 >= ((long) c.j) && this.p.size() < 6) {
                    this.p.add(Integer.valueOf((int) bVar.f));
                } else if (!this.p.isEmpty()) {
                    int i3 = 0;
                    for (Integer num2 : this.p) {
                        i3 += num2.intValue();
                    }
                    if (i3 * this.J > c.i) {
                        Collections.sort(this.p);
                        if (this.p.size() == 6) {
                            list = this.q;
                            List<Integer> list3 = this.p;
                            num = list3.get(list3.size() / 2);
                        } else {
                            list = this.q;
                            List<Integer> list4 = this.p;
                            num = list4.get(list4.size() - 1);
                        }
                        list.add(num);
                        if (this.q.size() > 3) {
                            this.q.remove(0);
                        }
                    }
                    this.p.clear();
                }
            }
            this.o = totalRxBytes;
        } else {
            this.o = -1;
            this.p.clear();
        }
        if (this.k != null) {
            this.k.f = bVar.f;
        }
        if (notiType == BasePlugin.NotiType.LOOP && this.I % h == 1) {
            a(bVar, DnsEngine.getInstance().dumpTcpInfo());
            this.j.add(bVar);
            this.k = bVar;
            if (this.j.size() > this.G) {
                this.j.remove(0);
            }
            c();
            this.H = g();
            AdapterForTLog.loge("speedtest", b());
        }
    }

    public String b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1420721156")) {
            return this.H;
        }
        return (String) ipChange.ipc$dispatch("-1420721156", new Object[]{this});
    }

    public void c() {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "750932355")) {
            ipChange.ipc$dispatch("750932355", new Object[]{this});
            return;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < this.j.size(); i7++) {
            if (this.j.get(i7).a > 0) {
                if (this.j.get(i7).a > c.d) {
                    i4++;
                }
                i3++;
            }
            if (this.j.get(i7).b > 0) {
                if (this.j.get(i7).b > ((long) c.e)) {
                    i6++;
                }
                i5++;
            }
        }
        if (i3 > 0) {
            double d2 = (((double) i4) * 1.0d) / ((double) i3);
            if (d2 > 0.5d) {
                this.e = 1;
            } else if (d2 > 0.2d) {
                this.e = 2;
            } else {
                this.e = 3;
            }
        } else {
            this.e = 0;
        }
        if (i5 > 0) {
            double d3 = (((double) i6) * 1.0d) / ((double) i5);
            if (d3 > 0.5d) {
                this.f = 1;
            } else if (d3 > 0.2d) {
                this.f = 2;
            } else {
                this.f = 3;
            }
            i2 = 0;
        } else {
            i2 = 0;
            this.f = 0;
        }
        this.g = i2;
        if (this.q.size() > 0) {
            ArrayList arrayList = new ArrayList(this.q);
            Collections.sort(arrayList);
            if (((Integer) arrayList.get(this.q.size() / 2)).intValue() < c.f) {
                this.g = 1;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c6, code lost:
        if (r9 > 0.0d) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00cf, code lost:
        if (r9 > 0.0d) goto L_0x00d1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058 A[Catch:{ NumberFormatException -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0105  */
    public double[] d() {
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        int i2;
        int i3;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        NumberFormatException e2;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1804990269")) {
            return (double[]) ipChange.ipc$dispatch("1804990269", new Object[]{this});
        }
        String e3 = e();
        try {
            if (!TextUtils.isEmpty(e3)) {
                String[] split = e3.split("/");
                if (split.length == 3) {
                    d13 = Double.parseDouble(split[0]);
                    try {
                        d6 = Double.parseDouble(split[1]);
                        try {
                            d5 = Double.parseDouble(split[2]);
                            str = this.z;
                            if (!TextUtils.isEmpty(str)) {
                                String[] split2 = str.split("/");
                                if (split2.length == 4) {
                                    d14 = Double.parseDouble(split2[1]);
                                    try {
                                        d12 = Double.parseDouble(split2[2]);
                                        try {
                                            d4 = Double.parseDouble(split2[3]);
                                            d2 = d14;
                                            d3 = d13;
                                            d7 = d12;
                                        } catch (NumberFormatException e4) {
                                            e2 = e4;
                                        }
                                    } catch (NumberFormatException e5) {
                                        e2 = e5;
                                        d12 = -1.0d;
                                        e2.printStackTrace();
                                        d2 = d14;
                                        d3 = d13;
                                        d7 = d12;
                                        d4 = -1.0d;
                                        i2 = (d7 > 0.0d ? 1 : (d7 == 0.0d ? 0 : -1));
                                        if (i2 > 0) {
                                        }
                                        i3 = this.K;
                                        if (i3 != 1) {
                                        }
                                        d8 = d6;
                                        d9 = d3;
                                        if (this.i > 0) {
                                        }
                                        double[] dArr = {d9, d8, d5};
                                        if (this.w > 0) {
                                        }
                                        return dArr;
                                    }
                                    i2 = (d7 > 0.0d ? 1 : (d7 == 0.0d ? 0 : -1));
                                    if (i2 > 0) {
                                        this.N = d7;
                                    } else if (d6 > 0.0d) {
                                        this.N = d6;
                                    }
                                    i3 = this.K;
                                    if (i3 != 1) {
                                        if (i3 != 2) {
                                            if (i3 != 3) {
                                                if (i3 == 4) {
                                                    d10 = this.N;
                                                    d11 = this.O;
                                                } else if (i3 != 5) {
                                                    d9 = -1.0d;
                                                    d5 = -1.0d;
                                                    d8 = -1.0d;
                                                    if (this.i > 0) {
                                                        d8 = d.a().a(d8, d3, d2);
                                                    }
                                                    double[] dArr2 = {d9, d8, d5};
                                                    if (this.w > 0) {
                                                        this.u = dArr2[0];
                                                        this.t = dArr2[1];
                                                        this.v = dArr2[2];
                                                    }
                                                    return dArr2;
                                                } else {
                                                    d10 = this.N;
                                                    d11 = this.M;
                                                }
                                                d8 = d11;
                                                d9 = d3;
                                                if (this.i > 0) {
                                                }
                                                double[] dArr22 = {d9, d8, d5};
                                                if (this.w > 0) {
                                                }
                                                return dArr22;
                                            } else if (this.r > 0.0d) {
                                                d10 = this.r;
                                            }
                                            d8 = d10;
                                            d9 = d3;
                                            if (this.i > 0) {
                                            }
                                            double[] dArr222 = {d9, d8, d5};
                                            if (this.w > 0) {
                                            }
                                            return dArr222;
                                        }
                                    } else if (i2 > 0) {
                                        d5 = d4;
                                        d9 = d2;
                                        d8 = d7;
                                        if (this.i > 0) {
                                        }
                                        double[] dArr2222 = {d9, d8, d5};
                                        if (this.w > 0) {
                                        }
                                        return dArr2222;
                                    }
                                    d8 = d6;
                                    d9 = d3;
                                    if (this.i > 0) {
                                    }
                                    double[] dArr22222 = {d9, d8, d5};
                                    if (this.w > 0) {
                                    }
                                    return dArr22222;
                                }
                            }
                            d14 = -1.0d;
                            d12 = -1.0d;
                            d4 = -1.0d;
                            d2 = d14;
                            d3 = d13;
                            d7 = d12;
                        } catch (NumberFormatException e6) {
                            e2 = e6;
                            d14 = -1.0d;
                        }
                    } catch (NumberFormatException e7) {
                        e2 = e7;
                        d14 = -1.0d;
                        d6 = -1.0d;
                        d5 = -1.0d;
                        d12 = -1.0d;
                        e2.printStackTrace();
                        d2 = d14;
                        d3 = d13;
                        d7 = d12;
                        d4 = -1.0d;
                        i2 = (d7 > 0.0d ? 1 : (d7 == 0.0d ? 0 : -1));
                        if (i2 > 0) {
                        }
                        i3 = this.K;
                        if (i3 != 1) {
                        }
                        d8 = d6;
                        d9 = d3;
                        if (this.i > 0) {
                        }
                        double[] dArr222222 = {d9, d8, d5};
                        if (this.w > 0) {
                        }
                        return dArr222222;
                    }
                    i2 = (d7 > 0.0d ? 1 : (d7 == 0.0d ? 0 : -1));
                    if (i2 > 0) {
                    }
                    i3 = this.K;
                    if (i3 != 1) {
                    }
                    d8 = d6;
                    d9 = d3;
                    if (this.i > 0) {
                    }
                    double[] dArr2222222 = {d9, d8, d5};
                    if (this.w > 0) {
                    }
                    return dArr2222222;
                }
            }
            d13 = -1.0d;
            d6 = -1.0d;
            d5 = -1.0d;
            try {
                str = this.z;
                if (!TextUtils.isEmpty(str)) {
                }
                d14 = -1.0d;
                d12 = -1.0d;
                d4 = -1.0d;
                d2 = d14;
                d3 = d13;
                d7 = d12;
            } catch (NumberFormatException e8) {
                e2 = e8;
                d14 = -1.0d;
                d12 = -1.0d;
                e2.printStackTrace();
                d2 = d14;
                d3 = d13;
                d7 = d12;
                d4 = -1.0d;
                i2 = (d7 > 0.0d ? 1 : (d7 == 0.0d ? 0 : -1));
                if (i2 > 0) {
                }
                i3 = this.K;
                if (i3 != 1) {
                }
                d8 = d6;
                d9 = d3;
                if (this.i > 0) {
                }
                double[] dArr22222222 = {d9, d8, d5};
                if (this.w > 0) {
                }
                return dArr22222222;
            }
        } catch (NumberFormatException e9) {
            e2 = e9;
            d14 = -1.0d;
            d13 = -1.0d;
            d6 = -1.0d;
            d5 = -1.0d;
            d12 = -1.0d;
            e2.printStackTrace();
            d2 = d14;
            d3 = d13;
            d7 = d12;
            d4 = -1.0d;
            i2 = (d7 > 0.0d ? 1 : (d7 == 0.0d ? 0 : -1));
            if (i2 > 0) {
            }
            i3 = this.K;
            if (i3 != 1) {
            }
            d8 = d6;
            d9 = d3;
            if (this.i > 0) {
            }
            double[] dArr222222222 = {d9, d8, d5};
            if (this.w > 0) {
            }
            return dArr222222222;
        }
        i2 = (d7 > 0.0d ? 1 : (d7 == 0.0d ? 0 : -1));
        if (i2 > 0) {
        }
        i3 = this.K;
        if (i3 != 1) {
        }
        d8 = d6;
        d9 = d3;
        if (this.i > 0) {
        }
        double[] dArr2222222222 = {d9, d8, d5};
        if (this.w > 0) {
        }
        return dArr2222222222;
    }

    public String e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-786668417")) {
            return (String) ipChange.ipc$dispatch("-786668417", new Object[]{this});
        }
        String str = this.y;
        return "4G".equals(str) ? a(false, str) : a(true, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ba  */
    public Map<String, Long> f() {
        long j2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-594564907")) {
            return (Map) ipChange.ipc$dispatch("-594564907", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mtop_rt", Long.valueOf((long) this.m));
        hashMap.put("mtop_time", Long.valueOf((long) this.n));
        long j3 = 0;
        hashMap.put("ntk_rt", Long.valueOf(this.k != null ? this.k.b : 0));
        hashMap.put("ntk_last_rc", Long.valueOf(this.k != null ? this.k.e : -1));
        hashMap.put("isNtk", Long.valueOf((long) this.x));
        hashMap.put("lastSpeed", Long.valueOf((long) this.r));
        hashMap.put("lastSpeedTime", Long.valueOf((long) this.s));
        String e2 = e();
        if (e2 != null) {
            String[] split = e2.split("/");
            if (split.length >= 3) {
                j2 = (long) Double.parseDouble(split[1]);
                hashMap.put("historySpeed", Long.valueOf(j2));
                hashMap.put("traffic", Long.valueOf(this.k == null ? this.k.f : 0));
                if (this.k != null) {
                    j3 = this.k.d;
                }
                hashMap.put("tcpSpeed", Long.valueOf(j3));
                return hashMap;
            }
        }
        j2 = 0;
        hashMap.put("historySpeed", Long.valueOf(j2));
        hashMap.put("traffic", Long.valueOf(this.k == null ? this.k.f : 0));
        if (this.k != null) {
        }
        hashMap.put("tcpSpeed", Long.valueOf(j3));
        return hashMap;
    }
}
