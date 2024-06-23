package com.meizu.cloud.pushsdk.c.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.meizu.cloud.pushsdk.c.d.a;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class d extends Handler {
    private final WeakReference<a> a;

    public d(a aVar) {
        super(Looper.getMainLooper());
        this.a = new WeakReference<>(aVar);
    }

    public void handleMessage(Message message) {
        a aVar = this.a.get();
        if (message.what != 1) {
            super.handleMessage(message);
        } else if (aVar != null) {
            com.meizu.cloud.pushsdk.c.f.a aVar2 = (com.meizu.cloud.pushsdk.c.f.a) message.obj;
            aVar.a(aVar2.a, aVar2.b);
        }
    }
}
