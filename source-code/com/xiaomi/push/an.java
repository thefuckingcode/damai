package com.xiaomi.push;

import com.xiaomi.push.al;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class an extends al.b {
    final /* synthetic */ al a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    an(al alVar, al.a aVar) {
        super(aVar);
        this.a = alVar;
    }

    /* access modifiers changed from: package-private */
    @Override // com.xiaomi.push.al.b
    public void b() {
        synchronized (al.a(this.a)) {
            al.a(this.a).remove(super.a.a());
        }
    }
}
