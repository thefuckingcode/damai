package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.sync.ITnetHostPortStrategy;

/* compiled from: Taobao */
public class nm2 implements SystemConfigMgr.IKVChangeListener, ITnetHostPortStrategy {
    public static final String TAG_TNET_HOST_PORT = "utanalytics_tnet_host_port";
    private static nm2 f;
    private mm2 a;
    private boolean b = false;
    private int c = 0;
    private int d = 10;
    private boolean e = false;

    private nm2() {
        try {
            mm2 mm2 = new mm2();
            this.a = mm2;
            mm2.e("adashx.m.taobao.com");
            String f2 = t6.f(Variables.n().j(), TAG_TNET_HOST_PORT);
            if (!TextUtils.isEmpty(f2)) {
                this.b = true;
            }
            f(f2);
            String a2 = zc2.a(Variables.n().j(), TAG_TNET_HOST_PORT);
            if (!TextUtils.isEmpty(a2)) {
                this.b = true;
            }
            f(a2);
            f(SystemConfigMgr.i().h(TAG_TNET_HOST_PORT));
            SystemConfigMgr.i().l(TAG_TNET_HOST_PORT, this);
        } catch (Throwable unused) {
        }
    }

    public static synchronized nm2 a() {
        nm2 nm2;
        synchronized (nm2.class) {
            if (f == null) {
                f = new nm2();
            }
            nm2 = f;
        }
        return nm2;
    }

    private void b() {
        d();
        c();
    }

    private void c() {
        int j = SystemConfigMgr.i().j("tnet_downgrade");
        if (j >= 1 && j <= 10) {
            this.d = j;
        }
    }

    private void d() {
        if (!this.e) {
            String f2 = t6.f(Variables.n().j(), "utanalytics_tnet_downgrade");
            if (!TextUtils.isEmpty(f2)) {
                try {
                    int intValue = Integer.valueOf(f2).intValue();
                    if (intValue >= 1 && intValue <= 10) {
                        this.d = intValue;
                    }
                } catch (Throwable unused) {
                }
            }
            this.e = true;
        }
    }

    private void f(String str) {
        String trim;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = (trim = str.trim()).indexOf(":")) != -1) {
            String substring = trim.substring(0, indexOf);
            int parseInt = Integer.parseInt(trim.substring(indexOf + 1, trim.length()));
            if (!TextUtils.isEmpty(substring) && parseInt > 0) {
                this.a.e(substring);
                this.a.f(parseInt);
            }
        }
    }

    public boolean e() {
        return this.b;
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public mm2 getTnetHostPort() {
        return this.a;
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        f(str2);
    }

    @Override // com.alibaba.analytics.core.sync.ITnetHostPortStrategy
    public void response(bc bcVar) {
        if (bcVar != null) {
            b();
            if (bcVar.a()) {
                this.c = 0;
                return;
            }
            int i = this.c + 1;
            this.c = i;
            if (i > this.d) {
                Variables.n().X(true);
            }
        }
    }
}
