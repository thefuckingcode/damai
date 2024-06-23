package com.youku.network.call;

import com.youku.network.a;
import com.youku.network.d;

/* compiled from: Taobao */
public class c {
    private a a;
    private e b;

    public c(a aVar) {
        this.a = aVar;
        c();
    }

    private void c() {
        this.b = this.a instanceof g ? new i() : new j();
    }

    public d a() {
        b();
        d a2 = this.a.a();
        a(a2);
        return a2;
    }

    public void a(a aVar) {
        b();
        this.a.a(new d(aVar, this.b));
    }

    public void a(d dVar) {
        this.b.a(dVar);
    }

    public void b() {
        this.b.a(this.a);
    }

    public void b(a aVar) {
        b();
        this.a.b(new d(aVar, this.b));
    }
}
