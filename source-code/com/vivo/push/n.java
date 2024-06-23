package com.vivo.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.p;

/* compiled from: Taobao */
final class n extends Handler {
    n(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        Object obj = message.obj;
        if (obj instanceof l) {
            l lVar = (l) obj;
            p.c("PushClientThread", "PushClientThread-handleMessage, task = ".concat(String.valueOf(lVar)));
            lVar.run();
        }
    }
}
