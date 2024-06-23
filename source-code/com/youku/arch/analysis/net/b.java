package com.youku.arch.analysis.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.taobao.weex.annotation.JSMethod;
import com.youku.arch.probe.plugins.c;
import com.youku.arch.probe.plugins.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class b {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private int c;
    private int d;
    private double e;
    private double f;
    private double g;
    private double h;
    private String i;
    private String j;
    private int k;
    private List<Integer> l;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final b a = new b();
    }

    private b() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 1.0d;
        this.f = 2.0d;
        this.g = 2.0d;
        this.h = 1.0d;
        this.k = 0;
        this.l = new ArrayList();
    }

    private int a(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "923607165")) {
            return i2 == 0 ? i3 : i3 == 0 ? i2 : Math.min(i2, i3);
        }
        return ((Integer) ipChange.ipc$dispatch("923607165", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)})).intValue();
    }

    public static b a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1971820263") ? (b) ipChange.ipc$dispatch("-1971820263", new Object[0]) : a.a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x012c  */
    private void d() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j2;
        long j3;
        long j4;
        int i8;
        int i9;
        long j5;
        long j6;
        int i10;
        long j7;
        long j8;
        long j9;
        int i11;
        long currentTimeMillis;
        long longValue;
        char c2;
        int i12;
        char c3;
        double d2;
        int i13;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-316268601")) {
            ipChange.ipc$dispatch("-316268601", new Object[]{this});
            return;
        }
        String str = d.c;
        Map<String, Integer> map = null;
        Map<String, Integer> e2 = c.a(str) != null ? ((d) c.a(str)).e() : null;
        String str2 = com.youku.arch.probe.plugins.b.c;
        Map<String, Long> f2 = c.a(str2) != null ? ((com.youku.arch.probe.plugins.b) c.a(str2)).f() : null;
        if (c.a(com.youku.arch.probe.plugins.a.c) != null) {
            map = ((com.youku.arch.probe.plugins.a) c.a(com.youku.arch.probe.plugins.a.c)).c();
        }
        int i14 = -1;
        if (e2 != null) {
            i4 = e2.get("isWifi").intValue();
            if (i4 > 0) {
                i2 = e2.get("rssi").intValue();
                i3 = e2.get("rtt").intValue();
                i5 = -1;
            } else {
                i5 = e2.get("signalStrength").intValue();
                i3 = -1;
                i2 = 0;
            }
            if (i4 > 0) {
                int i15 = com.youku.arch.probe.a.a.a;
                i13 = a(i2 <= i15 ? 1 : (i2 <= i15 || i2 >= com.youku.arch.probe.a.a.b) ? (i2 < com.youku.arch.probe.a.a.b || i2 >= 0) ? 0 : 3 : 2, i3 >= com.youku.arch.probe.a.a.c ? 1 : (i3 <= com.youku.arch.probe.a.a.d || i3 >= com.youku.arch.probe.a.a.c) ? (i3 > com.youku.arch.probe.a.a.d || i3 < 0) ? 0 : 3 : 2);
            } else {
                i13 = (i5 <= 0 || i5 > com.youku.arch.probe.a.a.e) ? (i5 <= com.youku.arch.probe.a.a.e || i5 >= com.youku.arch.probe.a.a.f) ? i5 >= com.youku.arch.probe.a.a.f ? 3 : 0 : 2 : 1;
            }
            this.a = i13;
        } else {
            i5 = -1;
            i4 = -1;
            i3 = -1;
            i2 = 0;
        }
        if (map != null) {
            int intValue = com.youku.arch.probe.a.a.o > 0 ? map.get("hmsQoe").intValue() : -1;
            if (intValue != -1) {
                if (intValue == 4) {
                    i6 = 3;
                } else if (intValue == 5) {
                    i6 = 1;
                }
                if (intValue == -1) {
                    i14 = map.get("hmsBw").intValue() / 8;
                    i7 = map.get("hmsRt").intValue();
                } else {
                    i7 = -1;
                }
                if (com.youku.arch.probe.a.a.o != 1) {
                    this.d = i6;
                } else {
                    this.d = 0;
                }
            }
            i6 = 0;
            if (intValue == -1) {
            }
            if (com.youku.arch.probe.a.a.o != 1) {
            }
        } else {
            i7 = -1;
            i6 = 0;
        }
        if (f2 != null) {
            long longValue2 = f2.get("mtop_rt").longValue();
            long longValue3 = f2.get("mtop_time").longValue();
            f2.get("isNtk").longValue();
            long longValue4 = f2.get("ntk_rt").longValue();
            long longValue5 = f2.get("ntk_last_rc").longValue();
            int i16 = com.youku.arch.probe.a.a.j;
            int i17 = longValue4 >= ((long) i16) ? 1 : (longValue4 >= ((long) i16) || longValue4 <= ((long) com.youku.arch.probe.a.a.i)) ? (longValue4 <= 0 || longValue4 > ((long) com.youku.arch.probe.a.a.i)) ? 0 : 3 : 2;
            if (longValue4 > 0) {
                if (longValue5 >= ((long) com.youku.arch.probe.a.a.l)) {
                    i11 = 1;
                } else if (longValue5 > ((long) com.youku.arch.probe.a.a.k) && longValue5 < ((long) com.youku.arch.probe.a.a.l)) {
                    i11 = 2;
                } else if (longValue5 >= 0 && longValue5 <= ((long) com.youku.arch.probe.a.a.k)) {
                    i11 = 3;
                }
                currentTimeMillis = (System.currentTimeMillis() / 1000) - longValue3;
                i9 = i14;
                i8 = i6;
                if (i17 == 0 && i11 == 0) {
                    if (currentTimeMillis > 60) {
                        this.f = 1.0d;
                    }
                    if (currentTimeMillis > 180) {
                        this.f = 0.5d;
                    }
                }
                this.b = a(a(longValue2 < ((long) com.youku.arch.probe.a.a.h) ? 1 : (longValue2 <= ((long) com.youku.arch.probe.a.a.g) || longValue2 >= ((long) com.youku.arch.probe.a.a.h)) ? (longValue2 <= 0 || longValue2 > ((long) com.youku.arch.probe.a.a.g)) ? 0 : 3 : 2, i17), i11);
                longValue = f2.get("lastSpeed").longValue();
                long longValue6 = f2.get("lastSpeedTime").longValue();
                long longValue7 = f2.get("historySpeed").longValue();
                long longValue8 = f2.get("traffic").longValue();
                long longValue9 = f2.get("tcpSpeed").longValue();
                int i18 = com.youku.arch.probe.a.a.n;
                c2 = longValue8 < ((long) i18) ? (char) 3 : 0;
                int i19 = longValue9 < ((long) i18) ? 3 : (longValue9 <= ((long) com.youku.arch.probe.a.a.m) || longValue9 >= ((long) com.youku.arch.probe.a.a.n)) ? (longValue9 <= 0 || longValue9 > ((long) com.youku.arch.probe.a.a.m)) ? 0 : 1 : 2;
                long currentTimeMillis2 = (System.currentTimeMillis() / 1000) - longValue6;
                if (currentTimeMillis2 > 60 || longValue <= 0) {
                    if (c2 == 0 || i19 != 0) {
                        longValue = -1;
                    } else {
                        this.g = 1.0d;
                        if (longValue > 0 || longValue7 <= 0) {
                            d2 = 0.5d;
                        } else {
                            d2 = 0.5d;
                            this.g = 0.5d;
                            longValue = longValue7;
                        }
                        if (currentTimeMillis2 > 180) {
                            this.g = d2;
                            int i20 = (longValue > 0 ? 1 : (longValue == 0 ? 0 : -1));
                            longValue = (i20 <= 0 || longValue7 <= 0) ? (i20 > 0 || longValue7 > 0) ? Math.max(longValue, longValue7) : 0 : Math.min(longValue, longValue7);
                        }
                    }
                }
                if (longValue < ((long) com.youku.arch.probe.a.a.n)) {
                    c3 = 3;
                    i12 = 3;
                } else if (longValue > ((long) com.youku.arch.probe.a.a.m) && longValue < ((long) com.youku.arch.probe.a.a.n)) {
                    c3 = 3;
                    i12 = 2;
                } else if (longValue <= 0 || longValue > ((long) com.youku.arch.probe.a.a.m)) {
                    c3 = 3;
                    i12 = 0;
                } else {
                    c3 = 3;
                    i12 = 1;
                }
                this.c = a(c2 != c3 ? 3 : i12, i19);
                i10 = i7;
                j9 = longValue;
                j2 = currentTimeMillis2;
                j5 = longValue2;
                j8 = longValue4;
                j7 = longValue5;
                j4 = longValue8;
                j3 = longValue9;
                j6 = currentTimeMillis;
            }
            i11 = 0;
            currentTimeMillis = (System.currentTimeMillis() / 1000) - longValue3;
            i9 = i14;
            i8 = i6;
            if (currentTimeMillis > 60) {
            }
            if (currentTimeMillis > 180) {
            }
            this.b = a(a(longValue2 < ((long) com.youku.arch.probe.a.a.h) ? 1 : (longValue2 <= ((long) com.youku.arch.probe.a.a.g) || longValue2 >= ((long) com.youku.arch.probe.a.a.h)) ? (longValue2 <= 0 || longValue2 > ((long) com.youku.arch.probe.a.a.g)) ? 0 : 3 : 2, i17), i11);
            longValue = f2.get("lastSpeed").longValue();
            long longValue62 = f2.get("lastSpeedTime").longValue();
            long longValue72 = f2.get("historySpeed").longValue();
            long longValue82 = f2.get("traffic").longValue();
            long longValue92 = f2.get("tcpSpeed").longValue();
            int i182 = com.youku.arch.probe.a.a.n;
            if (longValue82 < ((long) i182)) {
            }
            if (longValue92 < ((long) i182)) {
            }
            long currentTimeMillis22 = (System.currentTimeMillis() / 1000) - longValue62;
            if (c2 == 0) {
            }
            longValue = -1;
            if (longValue < ((long) com.youku.arch.probe.a.a.n)) {
            }
            this.c = a(c2 != c3 ? 3 : i12, i19);
            i10 = i7;
            j9 = longValue;
            j2 = currentTimeMillis22;
            j5 = longValue2;
            j8 = longValue4;
            j7 = longValue5;
            j4 = longValue82;
            j3 = longValue92;
            j6 = currentTimeMillis;
        } else {
            i9 = i14;
            i8 = i6;
            i10 = i7;
            j9 = -1;
            j8 = -1;
            j7 = -1;
            j6 = -1;
            j5 = -1;
            j4 = -1;
            j3 = -1;
            j2 = -1;
        }
        this.j = ",Signal:" + i4 + JSMethod.NOT_SET + i2 + JSMethod.NOT_SET + i3 + JSMethod.NOT_SET + i5 + ",Rt:" + j5 + JSMethod.NOT_SET + j8 + JSMethod.NOT_SET + j7 + JSMethod.NOT_SET + j6 + ",Speed:" + j9 + JSMethod.NOT_SET + j4 + JSMethod.NOT_SET + j3 + JSMethod.NOT_SET + j2 + ",Hms:" + i8 + JSMethod.NOT_SET + i9 + JSMethod.NOT_SET + i10;
    }

    public int b() {
        Exception e2;
        int i2;
        IpChange ipChange = $ipChange;
        int i3 = 1;
        int i4 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-316328196")) {
            return ((Integer) ipChange.ipc$dispatch("-316328196", new Object[]{this})).intValue();
        }
        try {
            d();
            double d2 = this.f;
            double d3 = this.g;
            if (d2 > d3) {
                i2 = this.b;
            } else if (d2 < d3) {
                i2 = this.c;
            } else {
                i2 = a(this.b, this.c);
                if (this.f < 1.0d && this.g < 1.0d) {
                    i2 = 0;
                }
            }
            if (a(a(this.a, i2), this.d) != 1) {
                if (i2 == 0) {
                    i2 = Math.max(this.a, this.d);
                }
                i3 = i2;
            }
            try {
                double d4 = this.f;
                double d5 = this.g;
                this.e = 1.0d;
                this.f = 2.0d;
                this.g = 2.0d;
                this.h = 1.0d;
                StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append(this.b);
                sb.append(this.c);
                sb.append(this.d);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("newNetScore:");
                sb3.append(i3);
                sb3.append(",detailQuality:");
                sb3.append(sb2);
                sb3.append(",scoreWeight:");
                sb3.append(d4);
                sb3.append(JSMethod.NOT_SET);
                sb3.append(d5);
                sb3.append(this.j);
                this.l.add(Integer.valueOf(i3));
                if (this.l.size() > 10) {
                    this.l.remove(0);
                }
                sb3.append(",scoreList:");
                for (Integer num : this.l) {
                    sb3.append(num.intValue());
                }
                String sb4 = sb3.toString();
                this.i = sb4;
                this.k = i3;
                AdapterForTLog.loge("NewNetScore", sb4);
                return i3;
            } catch (Exception e3) {
                e2 = e3;
                i4 = i3;
                e2.printStackTrace();
                return i4;
            }
        } catch (Exception e4) {
            e2 = e4;
            e2.printStackTrace();
            return i4;
        }
    }

    public int c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-316298405")) {
            return this.k;
        }
        return ((Integer) ipChange.ipc$dispatch("-316298405", new Object[]{this})).intValue();
    }
}
