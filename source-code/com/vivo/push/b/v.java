package com.vivo.push.b;

import com.vivo.push.a;

/* compiled from: Taobao */
public abstract class v extends s {
    private String a;
    private long b;

    public v(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public void c(a aVar) {
        super.c(aVar);
        aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.a);
        aVar.a("notify_id", this.b);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public void d(a aVar) {
        super.d(aVar);
        this.a = aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.b = aVar.b("notify_id", -1L);
    }

    public final long f() {
        return this.b;
    }

    public final String i() {
        return this.a;
    }
}
