package com.vivo.push.b;

import com.vivo.push.a;
import com.vivo.push.o;

/* compiled from: Taobao */
public final class w extends o {
    private int a = 0;

    public w() {
        super(2011);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public final void c(a aVar) {
        aVar.a("com.bbk.push.ikey.MODE_TYPE", this.a);
    }

    @Override // com.vivo.push.o
    public final boolean c() {
        return true;
    }

    public final int d() {
        return this.a;
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "PushModeCommand";
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public final void d(a aVar) {
        this.a = aVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
