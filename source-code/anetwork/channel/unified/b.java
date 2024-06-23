package anetwork.channel.unified;

import anetwork.channel.interceptor.Callback;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.b02;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class b {
    public final b02 a;
    public Callback b;
    public final String c;
    public volatile AtomicBoolean d = new AtomicBoolean();
    public volatile IUnifiedTask e = null;
    public volatile MultiPathTask f = null;
    public volatile Future g = null;

    public b(b02 b02, Callback callback) {
        this.a = b02;
        this.c = b02.i;
        this.b = callback;
    }

    public void a() {
        if (this.f != null) {
            this.f.cancel();
            this.f = null;
        }
    }

    public void b() {
        if (this.e != null) {
            this.e.cancel();
            this.e = null;
        }
    }

    public void c() {
        Future future = this.g;
        if (future != null) {
            future.cancel(true);
            this.g = null;
        }
    }
}
