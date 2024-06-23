package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;

/* compiled from: Taobao */
final class y implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f81a;

    y(Context context, Intent intent) {
        this.a = context;
        this.f81a = intent;
    }

    public void run() {
        try {
            this.a.startService(this.f81a);
        } catch (Exception e) {
            b.m182a(e.getMessage());
        }
    }
}
