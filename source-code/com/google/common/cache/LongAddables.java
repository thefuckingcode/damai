package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
final class LongAddables {
    private static final Supplier<LongAddable> a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        @Override // com.google.common.cache.LongAddable
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // com.google.common.cache.LongAddable
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.LongAddable
        public long sum() {
            return get();
        }

        /* synthetic */ PureJavaLongAddable(a aVar) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements Supplier<LongAddable> {
        a() {
        }

        /* renamed from: a */
        public LongAddable get() {
            return new LongAdder();
        }
    }

    /* compiled from: Taobao */
    static class b implements Supplier<LongAddable> {
        b() {
        }

        /* renamed from: a */
        public LongAddable get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new a();
        } catch (Throwable unused) {
            supplier = new b();
        }
        a = supplier;
    }

    public static LongAddable a() {
        return a.get();
    }
}
