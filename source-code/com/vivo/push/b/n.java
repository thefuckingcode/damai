package com.vivo.push.b;

import com.vivo.push.a;

/* compiled from: Taobao */
public final class n extends s {
    private String a;
    private int b = 0;
    private boolean c = false;

    public n() {
        super(7);
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void b(String str) {
        this.a = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final void c(a aVar) {
        super.c(aVar);
        aVar.a("content", this.a);
        aVar.a("log_level", this.b);
        aVar.a("is_server_log", this.c);
    }

    public final String d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        return this.c;
    }

    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final String toString() {
        return "OnLogCommand";
    }

    public final void a(boolean z) {
        this.c = z;
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final void d(a aVar) {
        super.d(aVar);
        this.a = aVar.a("content");
        this.b = aVar.b("log_level", 0);
        this.c = aVar.e("is_server_log");
    }
}
