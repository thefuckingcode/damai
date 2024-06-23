package com.uc.webview.export.internal.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.uc.startup.b;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
public abstract class a implements Runnable {
    protected String a;
    protected Pair<Integer, Integer> b;
    private int c;
    private Throwable d;
    private ValueCallback<a> e;

    a() {
        this.c = 0;
        this.d = null;
        this.e = null;
        this.a = a.class.getSimpleName();
        this.b = null;
        this.e = null;
    }

    private void a(int i) {
        String str = this.a;
        Log.i(str, "notifyStatusChange status:" + i);
        this.c = i;
        ValueCallback<a> valueCallback = this.e;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(this);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public void run() {
        long d2 = b.d();
        a(1);
        Pair<Integer, Integer> pair = this.b;
        if (pair != null) {
            b.a(((Integer) pair.first).intValue());
        }
        a();
        a(2);
        Pair<Integer, Integer> pair2 = this.b;
        if (pair2 != null) {
            b.a(((Integer) pair2.second).intValue());
        }
        String str = this.a;
        Log.i(str, "execute cost:" + (b.d() - d2));
    }
}
