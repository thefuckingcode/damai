package com.alibaba.android.bindingx.core;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import tb.f91;

/* compiled from: Taobao */
public class WeakRunnable implements Runnable {
    private final WeakReference<Runnable> mDelegateRunnable;

    public WeakRunnable(@NonNull Runnable runnable) {
        this.mDelegateRunnable = new WeakReference<>(runnable);
    }

    public void run() {
        Runnable runnable = this.mDelegateRunnable.get();
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                f91.b(th.getMessage());
            }
        }
    }
}
