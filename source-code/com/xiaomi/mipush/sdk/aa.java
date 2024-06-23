package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hn;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class aa implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0252a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hn f38a;

    aa(MiTinyDataClient.a.C0252a aVar, hn hnVar) {
        this.a = aVar;
        this.f38a = hnVar;
    }

    public void run() {
        this.a.f33a.add(this.f38a);
        MiTinyDataClient.a.C0252a.a(this.a);
    }
}
