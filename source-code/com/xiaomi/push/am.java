package com.xiaomi.push;

import com.xiaomi.push.al;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class am extends al.b {
    final /* synthetic */ al a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f91a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f92a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    am(al alVar, al.a aVar, boolean z, String str) {
        super(aVar);
        this.a = alVar;
        this.f92a = z;
        this.f91a = str;
    }

    /* access modifiers changed from: package-private */
    @Override // com.xiaomi.push.al.b
    public void a() {
        super.a();
    }

    /* access modifiers changed from: package-private */
    @Override // com.xiaomi.push.al.b
    public void b() {
        if (!this.f92a) {
            al.a(this.a).edit().putLong(this.f91a, System.currentTimeMillis()).commit();
        }
    }
}
