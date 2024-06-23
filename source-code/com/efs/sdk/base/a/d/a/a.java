package com.efs.sdk.base.a.d.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import tb.j53;
import tb.s23;
import tb.t43;
import tb.u33;

/* compiled from: Taobao */
public final class a extends BroadcastReceiver implements Runnable {
    public final void onReceive(Context context, Intent intent) {
        u33.a(this);
    }

    public final void run() {
        s23 a = s23.a.a();
        String b = j53.b(com.efs.sdk.base.a.d.a.a().c);
        t43.b("efs.info.manager", "network change: ".concat(String.valueOf(b)), null);
        a.a.b("net", b);
    }
}
