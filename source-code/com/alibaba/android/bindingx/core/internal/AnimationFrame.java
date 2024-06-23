package com.alibaba.android.bindingx.core.internal;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import androidx.annotation.NonNull;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class AnimationFrame {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface Callback {
        void doFrame();
    }

    /* access modifiers changed from: private */
    @TargetApi(16)
    /* compiled from: Taobao */
    public static class ChoreographerAnimationFrameImpl extends AnimationFrame implements Choreographer.FrameCallback {
        private Choreographer a;
        private Callback b;
        private boolean c;

        @TargetApi(16)
        ChoreographerAnimationFrameImpl() {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.alibaba.android.bindingx.core.internal.AnimationFrame.ChoreographerAnimationFrameImpl.AnonymousClass1 */

                    public void run() {
                        ChoreographerAnimationFrameImpl.this.a = Choreographer.getInstance();
                        countDownLatch.countDown();
                    }
                });
                try {
                    if (!countDownLatch.await(500, TimeUnit.MILLISECONDS)) {
                        this.a = Choreographer.getInstance();
                    }
                } catch (InterruptedException unused) {
                }
            } else {
                this.a = Choreographer.getInstance();
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        public void a() {
            Choreographer choreographer = this.a;
            if (choreographer != null) {
                choreographer.removeFrameCallback(this);
            }
            this.c = false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        public void c(@NonNull Callback callback) {
            this.b = callback;
            this.c = true;
            Choreographer choreographer = this.a;
            if (choreographer != null) {
                choreographer.postFrameCallback(this);
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        public void d() {
            a();
            this.a = null;
        }

        public void doFrame(long j) {
            Callback callback = this.b;
            if (callback != null) {
                callback.doFrame();
            }
            Choreographer choreographer = this.a;
            if (choreographer != null && this.c) {
                choreographer.postFrameCallback(this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a extends AnimationFrame implements Handler.Callback {
        private Handler a = new Handler(Looper.getMainLooper(), this);
        private Callback b;
        private boolean c;

        a() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        public void a() {
            Handler handler = this.a;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.c = false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        public void c(@NonNull Callback callback) {
            this.b = callback;
            this.c = true;
            Handler handler = this.a;
            if (handler != null) {
                handler.sendEmptyMessage(100);
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        public void d() {
            a();
            this.a = null;
        }

        public boolean handleMessage(Message message) {
            if (message == null || message.what != 100 || this.a == null) {
                return false;
            }
            Callback callback = this.b;
            if (callback != null) {
                callback.doFrame();
            }
            if (!this.c) {
                return true;
            }
            this.a.sendEmptyMessageDelayed(100, 16);
            return true;
        }
    }

    AnimationFrame() {
    }

    static AnimationFrame b() {
        if (Build.VERSION.SDK_INT >= 16) {
            return new ChoreographerAnimationFrameImpl();
        }
        return new a();
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: package-private */
    public abstract void c(@NonNull Callback callback);

    /* access modifiers changed from: package-private */
    public abstract void d();
}
