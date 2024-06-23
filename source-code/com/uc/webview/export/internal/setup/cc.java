package com.uc.webview.export.internal.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.j;
import com.uc.webview.export.internal.utility.p;

/* compiled from: Taobao */
final class cc implements Runnable {
    final /* synthetic */ bq a;
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ Pair c;
    final /* synthetic */ by d;

    cc(by byVar, bq bqVar, ValueCallback valueCallback, Pair pair) {
        this.d = byVar;
        this.a = bqVar;
        this.b = valueCallback;
        this.c = pair;
    }

    public final void run() {
        try {
            if (this.a.a()) {
                String d2 = j.d(this.d.getContext().getApplicationContext());
                String str = by.a;
                Log.d(str, ".shareCoreWaitTimeout localDir:" + d2 + " isWaitting:" + this.a.a());
                if (!p.a(d2) && this.a.a()) {
                    this.d.d = d2;
                    this.b.onReceiveValue(this.d);
                    this.a.a(8, null);
                } else if (this.a.a()) {
                    String e = j.e(this.d.getContext().getApplicationContext());
                    String str2 = by.a;
                    Log.d(str2, ".shareCoreWaitTimeout decFile:" + e + " isWaitting:" + this.a.a());
                    if (!p.a(e) && this.a.a()) {
                        this.d.e = e;
                        this.b.onReceiveValue(this.d);
                        this.a.a(8, null);
                    } else if (((Integer) this.c.first).intValue() != 1) {
                        this.a.a(((Integer) this.c.first).intValue(), this.c.second);
                    }
                }
            }
        } catch (Throwable th) {
            Log.d(by.a, ".shareCoreWaitTimeout Thread ", th);
            if (((Integer) this.c.first).intValue() != 1) {
                this.a.a(((Integer) this.c.first).intValue(), this.c.second);
            }
        }
    }
}
