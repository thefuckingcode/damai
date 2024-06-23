package tb;

import com.alibaba.analytics.core.sync.ITnetHostPortStrategy;

/* compiled from: Taobao */
public class rm2 {
    public static final String TAG_STATIC_TNET_HOST_PORT = "utanalytics_static_tnet_host_port";
    private static rm2 e;
    private lm2 a;
    private jm2 b;
    private int c = 0;
    private int d = -1;

    public static synchronized rm2 b() {
        rm2 rm2;
        synchronized (rm2.class) {
            if (e == null) {
                e = new rm2();
            }
            rm2 = e;
        }
        return rm2;
    }

    public int a() {
        jm2 jm2 = this.b;
        if (jm2 != null) {
            return jm2.a();
        }
        return 0;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public ITnetHostPortStrategy e() {
        if (w32.d().g()) {
            if (this.b == null) {
                this.b = new jm2();
            }
            this.c = 2;
            return this.b;
        } else if (w32.d().h()) {
            if (this.a == null) {
                this.a = new lm2();
            }
            this.c = 1;
            return this.a;
        } else {
            this.c = 0;
            return null;
        }
    }

    public void f() {
        w32.d().f();
    }

    /* access modifiers changed from: package-private */
    public void g(int i) {
        this.d = i;
    }
}
