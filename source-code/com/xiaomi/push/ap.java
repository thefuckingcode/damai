package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.ao;

/* compiled from: Taobao */
class ap extends Handler {
    final /* synthetic */ ao a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ap(ao aoVar, Looper looper) {
        super(looper);
        this.a = aoVar;
    }

    public void handleMessage(Message message) {
        ao.b bVar = (ao.b) message.obj;
        int i = message.what;
        if (i == 0) {
            bVar.a();
        } else if (i == 1) {
            bVar.c();
        }
        super.handleMessage(message);
    }
}
