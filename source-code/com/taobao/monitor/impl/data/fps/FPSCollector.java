package com.taobao.monitor.impl.data.fps;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.taobao.monitor.impl.trace.FPSDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import java.lang.ref.WeakReference;
import tb.b0;
import tb.dm2;
import tb.e90;
import tb.ws0;

@TargetApi(16)
/* compiled from: Taobao */
public class FPSCollector implements ViewTreeObserver.OnDrawListener, WindowEventDispatcher.OnEventListener {
    private long a = dm2.a();
    public int b = 0;
    public int c = 0;
    private long d = 0;
    private int e = 0;
    private int f = 0;
    private long g;
    private FPSDispatcher h;
    private WindowEventDispatcher i;
    private final WeakReference<Activity> j;

    public FPSCollector(Activity activity) {
        this.j = new WeakReference<>(activity);
        b();
        a(activity);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r3 = r3.getDecorView();
     */
    private void a(Activity activity) {
        final View decorView;
        Window window = activity.getWindow();
        if (window != null && decorView != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.taobao.monitor.impl.data.fps.FPSCollector.AnonymousClass1 */

                public void run() {
                    ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnDrawListener(FPSCollector.this);
                    }
                }
            });
        }
    }

    private void b() {
        IDispatcher b2 = e90.b(b0.ACTIVITY_FPS_DISPATCHER);
        if (b2 instanceof FPSDispatcher) {
            this.h = (FPSDispatcher) b2;
        }
        IDispatcher b3 = e90.b(b0.WINDOW_EVENT_DISPATCHER);
        if (b3 instanceof WindowEventDispatcher) {
            WindowEventDispatcher windowEventDispatcher = (WindowEventDispatcher) b3;
            this.i = windowEventDispatcher;
            windowEventDispatcher.addListener(this);
        }
    }

    public void c() {
        Window window;
        View decorView;
        if (!e90.c(this.i)) {
            this.i.removeListener(this);
        }
        Activity activity = this.j.get();
        if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            decorView.getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public void onDraw() {
        long a2 = dm2.a();
        long j2 = a2 - this.a;
        if (a2 - this.g <= 2000) {
            if (j2 > 16) {
                this.c++;
                if (j2 > 700) {
                    this.b++;
                }
            }
            if (j2 < 200) {
                long j3 = this.d + j2;
                this.d = j3;
                int i2 = this.f + 1;
                this.f = i2;
                if (j2 > 32) {
                    this.e++;
                }
                if (j3 > 1000) {
                    if (i2 > 60) {
                        this.f = 60;
                    }
                    if (!e90.c(this.h)) {
                        this.h.f(this.f, this.e, this.b, this.c, null);
                    }
                    this.d = 0;
                    this.f = 0;
                    this.e = 0;
                    this.b = 0;
                    this.c = 0;
                }
            }
            this.a = a2;
        }
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onKey(Activity activity, KeyEvent keyEvent, long j2) {
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onTouch(Activity activity, MotionEvent motionEvent, long j2) {
        ws0.o = dm2.a();
        if (motionEvent.getAction() == 2) {
            this.g = dm2.a();
        }
    }
}
