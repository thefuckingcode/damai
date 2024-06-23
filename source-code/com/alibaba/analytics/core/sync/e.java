package com.alibaba.analytics.core.sync;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.network.NetworkUtil;
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
import tb.i82;
import tb.mm2;
import tb.pm2;
import tb.u81;
import tb.xq2;

/* compiled from: Taobao */
public class e extends UploadLog {
    private static e k;
    public final i82 d = new i82();
    private int e = 0;
    private boolean f = false;
    private int g = 0;
    private volatile boolean h = false;
    private List<u81> i = new ArrayList();
    private List<u81> j = new ArrayList();

    private Map<String, String> g() {
        int i2;
        if (this.i.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            this.j.clear();
            int f2 = xq2.g().f() * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            i2 = 0;
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                u81 u81 = this.i.get(i3);
                if (currentTimeMillis - Long.parseLong(u81.d) > ((long) f2)) {
                    arrayList.add(u81);
                } else {
                    this.j.add(u81);
                    StringBuilder sb = (StringBuilder) hashMap.get("" + u81.c());
                    if (sb == null) {
                        sb = new StringBuilder();
                        hashMap.put("" + u81.c(), sb);
                    } else {
                        sb.append((char) 1);
                        i2++;
                    }
                    String b = this.i.get(i3).b();
                    sb.append(b);
                    i2 += b.length();
                }
            }
            if (!arrayList.isEmpty()) {
                if (Variables.n().O()) {
                    this.d.onEvent(h82.a(h82.s, null, Double.valueOf((double) arrayList.size())));
                }
                this.i.removeAll(arrayList);
            }
        }
        HashMap hashMap2 = new HashMap();
        this.e = i2;
        for (String str : hashMap.keySet()) {
            hashMap2.put(str, ((StringBuilder) hashMap.get(str)).toString());
        }
        if (Logger.n()) {
            Logger.f("", "mUploadByteSize", Integer.valueOf(this.e), AdUtConstants.XAD_UT_ARG_COUNT, Integer.valueOf(this.j.size()), "timeoutLogs count", Integer.valueOf(arrayList.size()));
        }
        return hashMap2;
    }

    public static e h() {
        if (k == null) {
            synchronized (e.class) {
                if (k == null) {
                    k = new e();
                }
            }
        }
        return k;
    }

    private void i() {
        synchronized (this) {
            this.i.removeAll(this.j);
            this.j.clear();
        }
    }

    private boolean k() throws Exception {
        byte[] bArr;
        Logger.d();
        Map<String, String> g2 = g();
        if (g2 == null || g2.size() == 0) {
            this.h = false;
            return true;
        }
        try {
            bArr = a.f(g2);
        } catch (Exception e2) {
            Logger.h(null, e2, new Object[0]);
            bArr = null;
        }
        if (bArr == null) {
            Logger.f("", "packRequest is null");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (d.w()) {
            mm2 e3 = c.b().e();
            Logger.f("UploadLogFromCache", "CreateSession tnet host", e3.a(), "port", Integer.valueOf(e3.b()), "type", Integer.valueOf(e3.d()));
            if (e3.d() == 1) {
                pm2.b().g(true);
            } else {
                pm2.b().g(false);
            }
        }
        bc v = d.v(bArr);
        boolean a = v.a();
        if (a) {
            Variables.n().t0();
            this.f = true;
            this.g = 0;
            i();
            try {
                b(v.e);
            } catch (Exception e4) {
                Logger.f(null, e4);
            }
        } else {
            this.g++;
            if (Variables.n().J()) {
                return true;
            }
            if (Variables.n().O() && this.f && this.g <= 10) {
                HashMap hashMap = new HashMap();
                hashMap.put("rt", String.valueOf(v.c));
                hashMap.put("pSize", String.valueOf(this.e));
                hashMap.put("errCode", String.valueOf(v.a));
                hashMap.put("type", "2");
                this.d.onEvent(h82.a(h82.j, JSON.toJSONString(hashMap), Double.valueOf(1.0d)));
            }
        }
        if (Logger.n()) {
            Logger.f("", "isSendSuccess", Boolean.valueOf(a), "cost time", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        try {
            Thread.sleep(100);
        } catch (Throwable th) {
            Logger.v(null, "thread sleep interrupted", th);
        }
        return false;
    }

    private void l() {
        Logger.d();
        if (NetworkUtil.m(Variables.n().j())) {
            UploadLog.NetworkStatus networkStatus = UploadLog.NetworkStatus.ALL;
            UploadLog.NetworkStatus networkStatus2 = this.c;
            if (networkStatus != networkStatus2 && networkStatus2 != a()) {
                Logger.v("network not match,return", "current networkstatus", a(), "mAllowedNetworkStatus", this.c);
            } else if (!this.h) {
                this.h = true;
                int i2 = 0;
                while (true) {
                    try {
                        if (i2 >= this.a) {
                            break;
                        } else if (this.i.size() == 0) {
                            this.h = false;
                            break;
                        } else if (k()) {
                            break;
                        } else {
                            i2++;
                        }
                    } catch (Throwable th) {
                        this.h = false;
                        throw th;
                    }
                }
                this.h = false;
            }
        }
    }

    public void f(u81 u81) {
        synchronized (this) {
            if (this.i.size() >= 300) {
                for (int i2 = 99; i2 >= 0; i2--) {
                    this.i.remove(i2);
                }
            }
            this.i.add(u81);
        }
        UploadQueueMgr.getInstance().add(UploadQueueMgr.MSGTYPE_REALTIME);
    }

    /* access modifiers changed from: package-private */
    public void j() {
        Logger.d();
        try {
            if (!xq2.g().j()) {
                l();
            }
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }
}
