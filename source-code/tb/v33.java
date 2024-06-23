package tb;

import com.efs.sdk.base.a.d.a;
import java.util.concurrent.atomic.AtomicInteger;
import tb.k53;

/* compiled from: Taobao */
public final class v33 extends t03 {
    private AtomicInteger b = new AtomicInteger(0);
    private AtomicInteger c = new AtomicInteger(0);
    public AtomicInteger d = new AtomicInteger(0);
    private AtomicInteger e = new AtomicInteger(0);
    private AtomicInteger f = new AtomicInteger(0);

    @Override // tb.t03
    public final void a() {
        if ((this.b.get() != 0 || this.c.get() != 0 || this.d.get() != 0 || this.f.get() != 0 || this.e.get() != 0) && this.a != null && a.a().d) {
            a aVar = this.a;
            int i = this.b.get();
            int i2 = this.c.get();
            int i3 = this.d.get();
            int i4 = this.f.get();
            int i5 = this.e.get();
            l23 l23 = new l23("efs_core", "lf_st", k53.a.a.a.c);
            l23.a("create_cnt", Integer.valueOf(i));
            l23.a("cache_cnt", Integer.valueOf(i2));
            l23.a("req_cnt", Integer.valueOf(i3));
            l23.a("err_cnt", Integer.valueOf(i4));
            l23.a("expire_cnt", Integer.valueOf(i5));
            this.b.addAndGet(i * -1);
            this.c.addAndGet(i2 * -1);
            this.d.addAndGet(i3 * -1);
            this.f.addAndGet(i4 * -1);
            this.e.addAndGet(i5 * -1);
            aVar.b(l23);
        }
    }

    public final void b() {
        this.b.incrementAndGet();
    }

    public final void c() {
        this.c.incrementAndGet();
    }

    public final void d() {
        this.e.incrementAndGet();
    }

    public final void e() {
        this.f.incrementAndGet();
    }
}
