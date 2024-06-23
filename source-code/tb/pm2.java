package tb;

import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.sync.ITnetHostPortStrategy;

/* compiled from: Taobao */
public class pm2 implements ITnetHostPortStrategy {
    public static pm2 f;
    private aj a = new aj();
    private v32 b = new v32();
    private om2 c = new om2();
    private boolean d = false;
    private boolean e = false;

    private pm2() {
    }

    private mm2 a() {
        return this.c.a();
    }

    public static synchronized pm2 b() {
        pm2 pm2;
        synchronized (pm2.class) {
            if (f == null) {
                f = new pm2();
            }
            pm2 = f;
        }
        return pm2;
    }

    private void f(boolean z, int i, long j) {
        o21.c(z, i, j);
        if (!z && this.e) {
            this.d = true;
            g(false);
            o21.b(i, j);
        }
    }

    public boolean c() {
        if (this.d || this.a.a() || a() == null) {
            return false;
        }
        int a2 = v01.a();
        if (a2 == 2) {
            return true;
        }
        if (a2 == 3) {
            return this.b.a();
        }
        return false;
    }

    public boolean d() {
        return this.e;
    }

    public void e() {
        SystemConfigMgr.i().l("close_detect_ipv6", this.a);
        SystemConfigMgr.i().l("sample_ipv6", this.b);
    }

    public void g(boolean z) {
        this.e = z;
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public mm2 getTnetHostPort() {
        if (c()) {
            return a();
        }
        return null;
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public void response(bc bcVar) {
        if (bcVar != null) {
            f(bcVar.a(), bcVar.a, bcVar.c);
        }
    }
}
