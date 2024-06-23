package com.xiaomi.push;

import android.content.Context;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ea implements Runnable {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f291a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f292a;
    final /* synthetic */ String b;

    ea(Context context, String str, int i, String str2) {
        this.f291a = context;
        this.f292a = str;
        this.a = i;
        this.b = str2;
    }

    public void run() {
        dz.b(this.f291a, this.f292a, this.a, this.b);
    }
}
