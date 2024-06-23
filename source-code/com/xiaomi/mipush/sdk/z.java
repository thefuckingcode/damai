package com.xiaomi.mipush.sdk;

import android.content.Context;

/* compiled from: Taobao */
final class z implements Runnable {
    final /* synthetic */ Context a;

    z(Context context) {
        this.a = context;
    }

    public void run() {
        MessageHandleService.a(this.a);
    }
}
