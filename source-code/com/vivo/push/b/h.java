package com.vivo.push.b;

import com.vivo.push.a;
import com.vivo.push.o;

/* compiled from: Taobao */
public final class h extends o {
    private String a;

    public h() {
        super(2013);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public final void c(a aVar) {
        aVar.a("MsgArriveCommand.MSG_TAG", this.a);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public final void d(a aVar) {
        this.a = aVar.a("MsgArriveCommand.MSG_TAG");
    }

    public h(String str) {
        this();
        this.a = str;
    }
}
