package com.xiaomi.push;

import com.xiaomi.push.ao;
import com.xiaomi.push.df;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class dh extends ao.b {
    ao.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ df f211a;

    dh(df dfVar) {
        this.f211a = dfVar;
    }

    @Override // com.xiaomi.push.ao.b
    public void b() {
        df.b bVar = (df.b) this.f211a.f199a.peek();
        if (bVar != null && bVar.a()) {
            if (this.f211a.f199a.remove(bVar)) {
                this.a = bVar;
            }
            ao.b bVar2 = this.a;
            if (bVar2 != null) {
                bVar2.b();
            }
        }
    }

    @Override // com.xiaomi.push.ao.b
    public void c() {
        ao.b bVar = this.a;
        if (bVar != null) {
            bVar.c();
        }
    }
}
