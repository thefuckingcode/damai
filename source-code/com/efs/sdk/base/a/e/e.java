package com.efs.sdk.base.a.e;

import tb.g23;
import tb.vy0;

/* compiled from: Taobao */
public final class e implements Runnable {
    private g23 a;
    private c b;
    private String c;

    public e(g23 g23, c cVar, String str) {
        this.a = g23;
        this.b = cVar;
        this.c = str;
    }

    public final void run() {
        c cVar;
        g23 g23 = this.a;
        vy0 vy0 = (g23 == null || (cVar = this.b) == null) ? new vy0() : cVar.a(g23, true);
        a.a().b(this.c, vy0.a ? 0 : vy0.b());
        this.c = null;
        this.b = null;
    }
}
