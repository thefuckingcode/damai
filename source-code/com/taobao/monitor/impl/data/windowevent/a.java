package com.taobao.monitor.impl.data.windowevent;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.taobao.monitor.impl.data.windowevent.WindowCallbackProxy;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import java.lang.reflect.Proxy;
import tb.b0;
import tb.dm2;
import tb.e90;

/* compiled from: Taobao */
public class a implements WindowCallbackProxy.DispatchEventListener {
    private WindowEventDispatcher a = null;
    private WindowCallbackProxy b;
    private final Activity c;

    public a(Activity activity) {
        this.c = activity;
        IDispatcher a2 = b0.a(b0.WINDOW_EVENT_DISPATCHER);
        if (a2 instanceof WindowEventDispatcher) {
            this.a = (WindowEventDispatcher) a2;
        }
    }

    public a a() {
        Window window;
        Window.Callback callback;
        Activity activity = this.c;
        if (!(activity == null || (window = activity.getWindow()) == null || this.b != null || (callback = window.getCallback()) == null)) {
            this.b = new WindowCallbackProxy(callback);
            try {
                window.setCallback((Window.Callback) Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{Window.Callback.class}, this.b));
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.b.a(this);
        }
        return this;
    }

    public void b() {
        WindowCallbackProxy windowCallbackProxy = this.b;
        if (windowCallbackProxy != null) {
            windowCallbackProxy.b(this);
            this.b = null;
        }
    }

    @Override // com.taobao.monitor.impl.data.windowevent.WindowCallbackProxy.DispatchEventListener
    public void dispatchKeyEvent(KeyEvent keyEvent) {
        if (!e90.c(this.a)) {
            this.a.f(this.c, keyEvent, dm2.a());
        }
    }

    @Override // com.taobao.monitor.impl.data.windowevent.WindowCallbackProxy.DispatchEventListener
    public void dispatchTouchEvent(MotionEvent motionEvent) {
        if (!e90.c(this.a)) {
            this.a.g(this.c, motionEvent, dm2.a());
        }
    }
}
