package com.xiaomi.push.service;

import com.xiaomi.push.al;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class am extends al.a {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ax f889a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f890a;

    am(String str, ax axVar, int i) {
        this.f890a = str;
        this.f889a = axVar;
        this.a = i;
    }

    @Override // com.xiaomi.push.al.a
    public String a() {
        return this.f890a;
    }

    public void run() {
        this.f889a.a(this.a);
    }
}
