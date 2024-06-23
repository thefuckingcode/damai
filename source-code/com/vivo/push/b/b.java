package com.vivo.push.b;

import com.vivo.push.a;

/* compiled from: Taobao */
public final class b extends c {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(boolean z, String str) {
        super(z ? 2006 : 2007, str);
        this.e = false;
    }

    @Override // com.vivo.push.o, com.vivo.push.b.c
    public final void c(a aVar) {
        super.c(aVar);
        aVar.a("sdk_clients", this.a);
        aVar.a("sdk_version", 323L);
        aVar.a("BaseAppCommand.EXTRA_APPID", this.c);
        aVar.a("BaseAppCommand.EXTRA_APPKEY", this.b);
        aVar.a("PUSH_REGID", this.d);
    }

    public final void d() {
        this.c = null;
    }

    public final void e() {
        this.b = null;
    }

    @Override // com.vivo.push.o, com.vivo.push.b.c
    public final String toString() {
        return "AppCommand:" + b();
    }

    @Override // com.vivo.push.o, com.vivo.push.b.c
    public final void d(a aVar) {
        super.d(aVar);
        this.a = aVar.a("sdk_clients");
        this.c = aVar.a("BaseAppCommand.EXTRA_APPID");
        this.b = aVar.a("BaseAppCommand.EXTRA_APPKEY");
        this.d = aVar.a("PUSH_REGID");
    }
}
