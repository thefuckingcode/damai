package com.taobao.monitor.impl.trace;

import com.taobao.monitor.impl.trace.AbsDispatcher;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
public class ApplicationBackgroundChangedDispatcher extends AbsDispatcher<BackgroundChangedListener> {
    public static final int B2F = 0;
    public static final int F2B = 1;

    /* compiled from: Taobao */
    public interface BackgroundChangedListener {
        void onChanged(int i, long j);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface Status {
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements AbsDispatcher.ListenerCaller<BackgroundChangedListener> {
        final /* synthetic */ int a;
        final /* synthetic */ long b;

        a(ApplicationBackgroundChangedDispatcher applicationBackgroundChangedDispatcher, int i, long j) {
            this.a = i;
            this.b = j;
        }

        /* renamed from: a */
        public void callListener(BackgroundChangedListener backgroundChangedListener) {
            backgroundChangedListener.onChanged(this.a, this.b);
        }
    }

    public void f(int i, long j) {
        c(new a(this, i, j));
    }
}
