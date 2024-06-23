package com.vivo.push.d;

import com.vivo.push.l;
import com.vivo.push.model.UPSNotificationMessage;

/* compiled from: Taobao */
final class w implements Runnable {
    final /* synthetic */ UPSNotificationMessage a;
    final /* synthetic */ u b;

    w(u uVar, UPSNotificationMessage uPSNotificationMessage) {
        this.b = uVar;
        this.a = uPSNotificationMessage;
    }

    public final void run() {
        u uVar = this.b;
        ((z) uVar).b.onNotificationMessageClicked(((l) uVar).a, this.a);
    }
}
