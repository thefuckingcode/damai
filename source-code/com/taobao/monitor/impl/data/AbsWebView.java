package com.taobao.monitor.impl.data;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import tb.dm2;
import tb.t91;

/* compiled from: Taobao */
public abstract class AbsWebView implements IWebView {
    private int a = 0;
    private int b = 0;
    private long c;
    private long d;

    public abstract int d(View view);

    @Override // com.taobao.monitor.impl.data.IWebView
    public int webViewProgress(final View view) {
        if (view.hashCode() != this.b) {
            this.b = view.hashCode();
            this.a = 0;
            this.c = dm2.a();
            this.d = 0;
            return this.a;
        }
        if (this.a != 100) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.taobao.monitor.impl.data.AbsWebView.AnonymousClass1 */

                public void run() {
                    try {
                        AbsWebView absWebView = AbsWebView.this;
                        absWebView.a = absWebView.d(view);
                        if (AbsWebView.this.a == 100) {
                            AbsWebView.this.d = dm2.a();
                        }
                    } catch (Exception e) {
                        t91.f(e);
                        AbsWebView.this.a = 0;
                    }
                }
            });
        }
        long a2 = dm2.a();
        long j = this.d;
        if (j != 0) {
            long j2 = this.d;
            if (((float) (a2 - j2)) > ((((float) (10 - Math.min(10L, j - this.c))) * 1.5f) / 10.0f) * ((float) (j2 - this.c))) {
                return this.a;
            }
        }
        return this.a - 1;
    }
}
