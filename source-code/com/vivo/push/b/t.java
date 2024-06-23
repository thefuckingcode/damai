package com.vivo.push.b;

import com.vivo.push.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public final class t extends s {
    private ArrayList<String> a = null;
    private ArrayList<String> b = null;

    public t(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final void c(a aVar) {
        super.c(aVar);
        aVar.a("content", this.a);
        aVar.a("error_msg", this.b);
    }

    public final ArrayList<String> d() {
        return this.a;
    }

    public final List<String> e() {
        return this.b;
    }

    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final String toString() {
        return "OnSetTagsCommand";
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final void d(a aVar) {
        super.d(aVar);
        this.a = aVar.c("content");
        this.b = aVar.c("error_msg");
    }
}
