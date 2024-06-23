package com.vivo.push.b;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.ArrayList;

/* compiled from: Taobao */
public final class a extends c {
    private ArrayList<String> a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2002 : 2003, str);
        this.a = arrayList;
    }

    @Override // com.vivo.push.o, com.vivo.push.b.c
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(IRequestConst.TAGS, this.a);
    }

    @Override // com.vivo.push.o, com.vivo.push.b.c
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.c(IRequestConst.TAGS);
    }

    @Override // com.vivo.push.o, com.vivo.push.b.c
    public final String toString() {
        return "AliasCommand:" + b();
    }
}
