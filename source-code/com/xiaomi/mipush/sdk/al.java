package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class al implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f42a;

    al(Context context, Intent intent) {
        this.a = context;
        this.f42a = intent;
    }

    public void run() {
        PushMessageHandler.b(this.a, this.f42a);
    }
}
