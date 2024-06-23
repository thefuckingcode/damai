package com.google.common.util.concurrent;

import com.google.common.base.i;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
class WrappingExecutorService$1 implements Runnable {
    final /* synthetic */ r this$0;
    final /* synthetic */ Callable val$wrapped;

    WrappingExecutorService$1(r rVar, Callable callable) {
        this.this$0 = rVar;
        this.val$wrapped = callable;
    }

    public void run() {
        try {
            this.val$wrapped.call();
        } catch (Exception e) {
            i.f(e);
            throw new RuntimeException(e);
        }
    }
}
