package com.uc.webview.export;

import android.util.Pair;
import java.lang.reflect.Constructor;

/* compiled from: Taobao */
final class f implements Runnable {
    final /* synthetic */ Constructor a;
    final /* synthetic */ e b;

    f(e eVar, Constructor constructor) {
        this.b = eVar;
        this.a = constructor;
    }

    public final void run() {
        try {
            this.b.d.onReceiveValue(new Pair((WebView) this.a.newInstance(this.b.c), null));
        } catch (Throwable th) {
            this.b.d.onReceiveValue(new Pair(null, th));
        }
    }
}
