package com.vivo.push.b;

import com.vivo.push.a;
import java.util.ArrayList;

/* compiled from: Taobao */
public final class m extends s {
    private ArrayList<String> a;

    public m() {
        super(8);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final void c(a aVar) {
        super.c(aVar);
        aVar.a("tags_list", this.a);
    }

    public final ArrayList<String> d() {
        return this.a;
    }

    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final String toString() {
        return "OnListTagCommand";
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final void d(a aVar) {
        super.d(aVar);
        this.a = aVar.c("tags_list");
    }
}
