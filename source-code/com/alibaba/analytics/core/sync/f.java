package com.alibaba.analytics.core.sync;

import android.os.SystemClock;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.logbuilder.a;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.analytics.core.sync.UploadLog;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.bc;
import tb.h82;
import tb.hg1;
import tb.i82;
import tb.mm2;
import tb.pm2;
import tb.rm2;
import tb.u81;

/* compiled from: Taobao */
public class f extends UploadLog {
    private static f o;
    private volatile boolean d = false;
    private int e = -1;
    private int f = 0;
    private float g = 200.0f;
    private int h = 0;
    private long i = 0;
    private boolean j = false;
    protected int k = -1;
    public final i82 l = new i82();
    private boolean m = true;
    private boolean n = true;

    private List<u81> f(List<u81> list, u81 u81) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(u81);
        return list;
    }

    private Map<String, String> g(List<u81> list) {
        HashMap hashMap = null;
        List<u81> list2 = null;
        hashMap = null;
        if (!(list == null || list.size() == 0)) {
            HashMap hashMap2 = new HashMap();
            ArrayList arrayList = null;
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                u81 u81 = list.get(i3);
                if (i2 > 5242880) {
                    list2 = f(list2, u81);
                    Logger.f("UploadLogFromDB", "log delay to upload because totalUploadSize Exceed. log", u81, "totalUploadSize", Integer.valueOf(i2));
                } else if (!SystemConfigMgr.i().g() || !SystemConfigMgr.i().e(a.e(u81.b()))) {
                    StringBuilder sb = (StringBuilder) hashMap2.get(u81.a);
                    if (sb == null) {
                        sb = new StringBuilder();
                        hashMap2.put(u81.a, sb);
                    } else {
                        sb.append((char) 1);
                        i2++;
                    }
                    String b = list.get(i3).b();
                    sb.append(b);
                    i2 += b.length();
                } else {
                    list2 = f(list2, u81);
                    if (list.get(i3).b.compareToIgnoreCase("3") >= 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(list.get(i3));
                    }
                    Logger.f("UploadLogFromDB", "log delay to upload because delay config. log", u81);
                }
            }
            if (list2 != null) {
                list.removeAll(list2);
            }
            if (arrayList != null) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    ((u81) arrayList.get(i4)).b = "2";
                }
                LogStoreMgr.l().p(arrayList);
            }
            hashMap = new HashMap();
            this.h = i2;
            for (String str : hashMap2.keySet()) {
                hashMap.put(str, ((StringBuilder) hashMap2.get(str)).toString());
            }
            if (list.size() > 0) {
                this.g = ((float) this.h) / ((float) list.size());
            }
            Logger.f("UploadLogFromDB", "averagePackageSize", Float.valueOf(this.g), "mUploadByteSize", Integer.valueOf(this.h), AdUtConstants.XAD_UT_ARG_COUNT, Integer.valueOf(list.size()));
        }
        return hashMap;
    }

    private int h(Boolean bool, long j2) {
        if (j2 < 0) {
            return this.e;
        }
        float f2 = ((float) this.h) / ((float) j2);
        if (!bool.booleanValue()) {
            this.e /= 2;
            this.f++;
        } else if (j2 > 45000) {
            return this.e;
        } else {
            this.e = (int) ((((double) (f2 * 45000.0f)) / ((double) this.g)) - ((double) this.f));
        }
        int i2 = this.e;
        if (i2 < 1) {
            this.e = 1;
            this.f = 0;
        } else if (i2 > 350) {
            this.e = 350;
        }
        Logger.f("UploadLogFromDB", "winsize", Integer.valueOf(this.e));
        return this.e;
    }

    public static f i() {
        if (o == null) {
            synchronized (f.class) {
                if (o == null) {
                    o = new f();
                }
            }
        }
        return o;
    }

    private void l() {
        int i2 = this.e / 2;
        this.e = i2;
        if (i2 < 1) {
            this.e = 1;
            this.f = 0;
        } else if (i2 > 350) {
            this.e = 350;
        }
        Logger.f("UploadLogFromDB", "winsize", Integer.valueOf(this.e));
    }

    private void n() {
        Logger.d();
        if (!NetworkUtil.m(Variables.n().j())) {
            Logger.f("UploadLogFromDB", "Network is Disconnected");
            return;
        }
        UploadLog.NetworkStatus networkStatus = UploadLog.NetworkStatus.ALL;
        UploadLog.NetworkStatus networkStatus2 = this.c;
        if (networkStatus != networkStatus2 && networkStatus2 != a()) {
            Logger.v("UploadLogFromDB", "current networkstatus", a(), "mAllowedNetworkStatus", this.c);
        } else if (!this.d) {
            this.d = true;
            try {
                this.i = 0;
                if (!hg1.a(Variables.n().j())) {
                    Logger.f("UploadLogFromDB", "Other Process is Uploading, break");
                    this.d = false;
                    hg1.b();
                    return;
                }
                List<u81> k2 = LogStoreMgr.l().k(j());
                if (k2 == null || k2.size() == 0) {
                    Logger.f("UploadLogFromDB", "logs is null");
                    this.k = this.a;
                    this.d = false;
                    this.d = false;
                    hg1.b();
                    return;
                }
                if (this.k <= 0) {
                    this.k = this.a;
                }
                Logger.f("UploadLogFromDB", "mUploadIndex", Integer.valueOf(this.k), "mMaxUploadTimes", Integer.valueOf(this.a));
                if (o(k2, this.k == this.a)) {
                    this.k = this.a;
                } else {
                    int i2 = this.k - 1;
                    this.k = i2;
                    if (i2 > 0) {
                        UploadQueueMgr.getInstance().add("i");
                    } else {
                        this.k = this.a;
                    }
                }
                this.d = false;
                hg1.b();
            } catch (Throwable th) {
                this.d = false;
                hg1.b();
                throw th;
            }
        }
    }

    private boolean o(List<u81> list, boolean z) throws Exception {
        byte[] bArr;
        bc bcVar;
        String str;
        Logger.f("UploadLogFromDB", "firstRequest", Boolean.valueOf(z), "firstLaunch", Boolean.valueOf(this.m));
        this.m = false;
        Map<String, String> g2 = g(list);
        if (g2 == null || g2.size() == 0) {
            Logger.f("UploadLogFromDB", "postDataMap is null");
            this.d = false;
            return true;
        }
        if (!Variables.n().J()) {
            if (this.n && z && c.b().d() == 2 && c.b().c() == 0 && rm2.b().c() == 0 && rm2.b().a() > 0) {
                Logger.f("UploadLogFromDB", "forceCloseSession");
                d.q();
                this.n = false;
            }
            if (d.w()) {
                mm2 e2 = c.b().e();
                Logger.f("UploadLogFromDB", "CreateSession tnet host", e2.a(), "port", Integer.valueOf(e2.b()), "type", Integer.valueOf(e2.d()));
                if (e2.d() == 1) {
                    pm2.b().g(true);
                } else {
                    pm2.b().g(false);
                }
            } else {
                mm2 f2 = c.b().f();
                Logger.f("UploadLogFromDB", "TempSession tnet host", f2.a(), "port", Integer.valueOf(f2.b()), "type", Integer.valueOf(f2.d()));
            }
        } else {
            pm2.b().g(false);
        }
        try {
            bArr = a.d(g2);
        } catch (Exception e3) {
            Logger.i(null, e3.toString());
            bArr = null;
        }
        if (bArr == null) {
            l();
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (Variables.n().J()) {
            bcVar = h.a(bArr);
        } else {
            bcVar = d.v(bArr);
            bcVar.f = z;
        }
        boolean a = bcVar.a();
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        long j2 = elapsedRealtime2 - elapsedRealtime;
        h(Boolean.valueOf(a), j2);
        c.b().g(bcVar);
        if (a) {
            Variables.n().t0();
            this.j = true;
            str = "UploadLogFromDB";
            this.i += (long) LogStoreMgr.l().i(list);
            if (Variables.n().O()) {
                this.l.onEvent(h82.a(h82.k, null, Double.valueOf((double) this.h)));
            }
            try {
                b(bcVar.e);
            } catch (Exception unused) {
            }
        } else {
            str = "UploadLogFromDB";
            if (Variables.n().O()) {
                if (!this.j || Variables.n().J()) {
                    Variables.n().q0();
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("rt", String.valueOf(bcVar.c));
                    hashMap.put("pSize", String.valueOf(this.h));
                    hashMap.put("errCode", String.valueOf(bcVar.a));
                    hashMap.put("type", "1");
                    this.l.onEvent(h82.a(h82.j, JSON.toJSONString(hashMap), Double.valueOf(1.0d)));
                }
            }
        }
        Logger.m(str, "isSendSuccess", Boolean.valueOf(a), "upload log count", Integer.valueOf(list.size()), "upload consume", Long.valueOf(j2), "delete consume", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime2));
        try {
            Thread.sleep(100);
        } catch (Throwable th) {
            Logger.u(str, th, new Object[0]);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        if (this.e == -1) {
            k();
        }
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        String h2 = NetworkUtil.h();
        if ("Wi-Fi".equalsIgnoreCase(h2)) {
            this.e = 50;
        } else if ("4G".equalsIgnoreCase(h2)) {
            this.e = 40;
        } else if ("3G".equalsIgnoreCase(h2)) {
            this.e = 30;
        } else {
            this.e = 40;
        }
        this.f = 0;
    }

    public void m() {
        try {
            if (!Variables.n().F()) {
                n();
            } else {
                Logger.v("UploadLogFromDB", "isAllServiceClosed");
            }
        } catch (Throwable th) {
            Logger.h("UploadLogFromDB", th, new Object[0]);
        }
        try {
            IUploadExcuted iUploadExcuted = this.b;
            if (iUploadExcuted != null) {
                iUploadExcuted.onUploadExcuted(this.i);
            }
        } catch (Throwable th2) {
            Logger.h("UploadLogFromDB", th2, new Object[0]);
        }
    }
}
