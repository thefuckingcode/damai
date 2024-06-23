package com.taobao.monitor.impl.trace;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.taobao.monitor.impl.trace.AbsDispatcher;

/* compiled from: Taobao */
public class WindowEventDispatcher extends AbsDispatcher<OnEventListener> {

    /* compiled from: Taobao */
    public interface OnEventListener {
        void onKey(Activity activity, KeyEvent keyEvent, long j);

        void onTouch(Activity activity, MotionEvent motionEvent, long j);
    }

    /* compiled from: Taobao */
    class a implements AbsDispatcher.ListenerCaller<OnEventListener> {
        final /* synthetic */ Activity a;
        final /* synthetic */ KeyEvent b;
        final /* synthetic */ long c;

        a(WindowEventDispatcher windowEventDispatcher, Activity activity, KeyEvent keyEvent, long j) {
            this.a = activity;
            this.b = keyEvent;
            this.c = j;
        }

        /* renamed from: a */
        public void callListener(OnEventListener onEventListener) {
            onEventListener.onKey(this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    class b implements AbsDispatcher.ListenerCaller<OnEventListener> {
        final /* synthetic */ Activity a;
        final /* synthetic */ MotionEvent b;
        final /* synthetic */ long c;

        b(WindowEventDispatcher windowEventDispatcher, Activity activity, MotionEvent motionEvent, long j) {
            this.a = activity;
            this.b = motionEvent;
            this.c = j;
        }

        /* renamed from: a */
        public void callListener(OnEventListener onEventListener) {
            onEventListener.onTouch(this.a, this.b, this.c);
        }
    }

    public void f(Activity activity, KeyEvent keyEvent, long j) {
        c(new a(this, activity, keyEvent, j));
    }

    public void g(Activity activity, MotionEvent motionEvent, long j) {
        c(new b(this, activity, motionEvent, j));
    }
}
