package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;
import tb.ds1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class Callables {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements Callable<T> {
        final /* synthetic */ Supplier a;
        final /* synthetic */ Callable b;

        a(Supplier supplier, Callable callable) {
            this.a = supplier;
            this.b = callable;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            boolean d = Callables.d((String) this.a.get(), currentThread);
            try {
                return (T) this.b.call();
            } finally {
                if (d) {
                    Callables.d(name, currentThread);
                }
            }
        }
    }

    @GwtIncompatible
    static Runnable b(final Runnable runnable, final Supplier<String> supplier) {
        ds1.p(supplier);
        ds1.p(runnable);
        return new Runnable() {
            /* class com.google.common.util.concurrent.Callables.AnonymousClass4 */

            public void run() {
                Thread currentThread = Thread.currentThread();
                String name = currentThread.getName();
                boolean d = Callables.d((String) supplier.get(), currentThread);
                try {
                    runnable.run();
                } finally {
                    if (d) {
                        Callables.d(name, currentThread);
                    }
                }
            }
        };
    }

    @GwtIncompatible
    static <T> Callable<T> c(Callable<T> callable, Supplier<String> supplier) {
        ds1.p(supplier);
        ds1.p(callable);
        return new a(supplier, callable);
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    public static boolean d(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
