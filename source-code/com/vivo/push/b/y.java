package com.vivo.push.b;

import com.vivo.push.a;
import com.vivo.push.o;

/* compiled from: Taobao */
public final class y extends o {
    private String a;

    public y(String str) {
        super(2008);
        this.a = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public final void c(a aVar) {
        aVar.a("package_name", this.a);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o
    public final void d(a aVar) {
        this.a = aVar.a("package_name");
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "StopServiceCommand";
    }

    public y() {
        super(2008);
    }
}
