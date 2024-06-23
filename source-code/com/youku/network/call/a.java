package com.youku.network.call;

import android.os.Handler;
import android.os.Looper;
import com.youku.network.a.b;
import com.youku.network.c;
import com.youku.network.d;

/* compiled from: Taobao */
public class a {
    protected static Handler a = new Handler(Looper.getMainLooper());
    public static boolean b = true;
    protected c c;
    protected b d;

    public d a() {
        return null;
    }

    public void a(Handler handler, com.youku.network.a aVar, d dVar) {
        if (aVar == null) {
            return;
        }
        if (handler != null) {
            handler.post(new BaseCall$1(this, aVar, dVar));
        } else {
            aVar.a(dVar);
        }
    }

    public void a(com.youku.network.a aVar) {
    }

    /* access modifiers changed from: protected */
    public void a(c cVar) {
    }

    public void b() {
    }

    public void b(com.youku.network.a aVar) {
    }

    public c c() {
        return this.c;
    }
}
