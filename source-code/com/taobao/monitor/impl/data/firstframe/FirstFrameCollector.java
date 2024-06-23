package com.taobao.monitor.impl.data.firstframe;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import tb.dm2;
import tb.on1;

@RequiresApi(api = 16)
/* compiled from: Taobao */
public class FirstFrameCollector implements ViewTreeObserver.OnDrawListener {
    private WeakReference<on1> a;
    private boolean b = false;

    public FirstFrameCollector(on1 on1) {
        this.a = new WeakReference<>(on1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ViewTreeObserver c() {
        on1 on1;
        View o;
        WeakReference<on1> weakReference = this.a;
        if (weakReference == null || (on1 = weakReference.get()) == null || (o = on1.o()) == null) {
            return null;
        }
        return o.getViewTreeObserver();
    }

    public void d() {
        ViewTreeObserver c = c();
        if (c != null) {
            this.b = false;
            c.addOnDrawListener(this);
        }
    }

    public void e() {
        this.b = true;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.taobao.monitor.impl.data.firstframe.FirstFrameCollector.AnonymousClass1 */

            public void run() {
                ViewTreeObserver c = FirstFrameCollector.this.c();
                if (c != null) {
                    c.removeOnDrawListener(FirstFrameCollector.this);
                }
                FirstFrameCollector.this.a = null;
            }
        });
    }

    public void onDraw() {
        if (!this.b) {
            long a2 = dm2.a();
            e();
            on1 on1 = this.a.get();
            if (on1 != null) {
                on1.y(a2);
            }
        }
    }
}
