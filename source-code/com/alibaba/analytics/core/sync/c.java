package com.alibaba.analytics.core.sync;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.analytics.utils.Logger;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.HashMap;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.bc;
import tb.mm2;
import tb.nm2;
import tb.pm2;
import tb.rm2;
import tb.u81;
import tb.yq2;

/* compiled from: Taobao */
public class c {
    private static c g;
    private boolean a = false;
    private mm2 b = null;
    private mm2 c = null;
    private boolean d = false;
    private ITnetHostPortStrategy e = null;
    private int f = 0;

    private c() {
    }

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            if (g == null) {
                g = new c();
            }
            cVar = g;
        }
        return cVar;
    }

    public int a() {
        mm2 mm2 = this.c;
        if (mm2 == null || this.b == null || !this.d) {
            return 0;
        }
        this.d = false;
        Logger.f("TnetHostPortMgrCenter", "LastTnetHostPort type", Integer.valueOf(mm2.d()), "TnetHostPort type", Integer.valueOf(this.b.d()));
        if (this.c.d() != 2 || this.b.d() == 2) {
            return 0;
        }
        return 1;
    }

    public int c() {
        mm2 mm2 = this.b;
        if (mm2 != null && mm2.d() == 2 && this.b.d() == 2) {
            return this.b.c();
        }
        return 0;
    }

    public int d() {
        return this.f;
    }

    public mm2 e() {
        mm2 tnetHostPort;
        this.d = true;
        this.c = this.b;
        this.e = rm2.b().e();
        this.f = rm2.b().d();
        ITnetHostPortStrategy iTnetHostPortStrategy = this.e;
        if (iTnetHostPortStrategy == null || (tnetHostPort = iTnetHostPortStrategy.getTnetHostPort()) == null) {
            if (this.a && f.i().j() < 50) {
                f.i().k();
                this.a = false;
            }
            mm2 tnetHostPort2 = pm2.b().getTnetHostPort();
            if (tnetHostPort2 != null) {
                this.b = tnetHostPort2;
                return tnetHostPort2;
            }
            mm2 tnetHostPort3 = nm2.a().getTnetHostPort();
            this.b = tnetHostPort3;
            return tnetHostPort3;
        }
        this.a = true;
        this.b = tnetHostPort;
        return tnetHostPort;
    }

    public mm2 f() {
        if (this.b == null) {
            this.b = e();
        }
        return this.b;
    }

    public void g(bc bcVar) {
        if (bcVar != null && !Variables.n().J() && this.b != null) {
            h(bcVar);
            if (this.b.d() == 2) {
                ITnetHostPortStrategy iTnetHostPortStrategy = this.e;
                if (iTnetHostPortStrategy != null) {
                    iTnetHostPortStrategy.response(bcVar);
                }
            } else if (this.b.d() == 1) {
                pm2.b().response(bcVar);
            } else {
                nm2.a().response(bcVar);
            }
        }
    }

    public void h(bc bcVar) {
        if (bcVar.f && b.a().b() && yq2.d().f(19997, "_ut_nw")) {
            HashMap hashMap = new HashMap();
            hashMap.put(IRequestConst.CT, "" + bcVar.b);
            hashMap.put("rt", "" + bcVar.c);
            hashMap.put("rs", "" + bcVar.d);
            hashMap.put("success", "" + (bcVar.a() ? 1 : 0));
            int d2 = d();
            if (d2 == 2) {
                int c2 = rm2.b().c();
                if (c2 <= 0) {
                    c2 = 0;
                }
                hashMap.put("sip", "" + c2);
            }
            LogStoreMgr.l().d(new u81(BizTime.UT, "19997", "_ut_nw", "" + c(), "" + d2, hashMap));
        }
    }
}
