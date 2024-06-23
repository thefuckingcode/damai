package com.xiaomi.push.service.receivers;

import android.content.Context;

/* compiled from: Taobao */
class a implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NetworkStatusReceiver f993a;

    a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f993a = networkStatusReceiver;
        this.a = context;
    }

    public void run() {
        this.f993a.a(this.a);
    }
}
