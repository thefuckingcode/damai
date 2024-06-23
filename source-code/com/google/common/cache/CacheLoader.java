package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import tb.ds1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public abstract class CacheLoader<K, V> {

    /* compiled from: Taobao */
    private static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Function<K, V> computingFunction;

        public FunctionToCacheLoader(Function<K, V> function) {
            this.computingFunction = (Function) ds1.p(function);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.base.Function<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.cache.CacheLoader
        public V load(K k) {
            return (V) this.computingFunction.apply(ds1.p(k));
        }
    }

    /* compiled from: Taobao */
    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    private static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<V> computingSupplier;

        public SupplierToCacheLoader(Supplier<V> supplier) {
            this.computingSupplier = (Supplier) ds1.p(supplier);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object obj) {
            ds1.p(obj);
            return this.computingSupplier.get();
        }
    }

    /* compiled from: Taobao */
    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        UnsupportedLoadingOperationException() {
        }
    }

    /* compiled from: Taobao */
    static class a extends CacheLoader<K, V> {
        final /* synthetic */ CacheLoader a;
        final /* synthetic */ Executor b;

        /* renamed from: com.google.common.cache.CacheLoader$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        class CallableC0156a implements Callable<V> {
            final /* synthetic */ Object a;
            final /* synthetic */ Object b;

            CallableC0156a(Object obj, Object obj2) {
                this.a = obj;
                this.b = obj2;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.cache.CacheLoader */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public V call() throws Exception {
                return (V) a.this.a.reload(this.a, this.b).get();
            }
        }

        a(CacheLoader cacheLoader, Executor executor) {
            this.a = cacheLoader;
            this.b = executor;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k) throws Exception {
            return (V) this.a.load(k);
        }

        @Override // com.google.common.cache.CacheLoader
        public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
            return this.a.loadAll(iterable);
        }

        @Override // com.google.common.cache.CacheLoader
        public ListenableFuture<V> reload(K k, V v) throws Exception {
            ListenableFutureTask create = ListenableFutureTask.create(new CallableC0156a(k, v));
            this.b.execute(create);
            return create;
        }
    }

    protected CacheLoader() {
    }

    @GwtIncompatible
    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> cacheLoader, Executor executor) {
        ds1.p(cacheLoader);
        ds1.p(executor);
        return new a(cacheLoader, executor);
    }

    public static <K, V> CacheLoader<K, V> from(Function<K, V> function) {
        return new FunctionToCacheLoader(function);
    }

    public abstract V load(K k) throws Exception;

    public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    @GwtIncompatible
    public ListenableFuture<V> reload(K k, V v) throws Exception {
        ds1.p(k);
        ds1.p(v);
        return Futures.f(load(k));
    }

    public static <V> CacheLoader<Object, V> from(Supplier<V> supplier) {
        return new SupplierToCacheLoader(supplier);
    }
}
