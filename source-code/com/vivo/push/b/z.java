package com.vivo.push.b;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.vivo.push.a;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
public final class z extends c {
    private ArrayList<String> a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2004 : 2005, str);
        this.a = arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.c
    public final void c(a aVar) {
        super.c(aVar);
        aVar.a(IRequestConst.TAGS, (Serializable) this.a);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.c
    public final void d(a aVar) {
        super.d(aVar);
        this.a = aVar.c(IRequestConst.TAGS);
    }

    @Override // com.vivo.push.o, com.vivo.push.b.c
    public final String toString() {
        return "TagCommand";
    }
}
