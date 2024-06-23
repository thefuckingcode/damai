package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;
import tb.rk1;

@GwtCompatible
/* compiled from: Taobao */
public final class Suppliers {

    @VisibleForTesting
    /* compiled from: Taobao */
    static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;
        final long durationNanos;
        volatile transient long expirationNanos;
        @NullableDecl
        volatile transient T value;

        ExpiringMemoizingSupplier(Supplier<T> supplier, long j, TimeUnit timeUnit) {
            this.delegate = (Supplier) ds1.p(supplier);
            this.durationNanos = timeUnit.toNanos(j);
            ds1.j(j > 0, "duration (%s %s) must be > 0", j, timeUnit);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            long j = this.expirationNanos;
            long f = f.f();
            if (j == 0 || f - j >= 0) {
                synchronized (this) {
                    if (j == this.expirationNanos) {
                        T t = this.delegate.get();
                        this.value = t;
                        long j2 = f + this.durationNanos;
                        if (j2 == 0) {
                            j2 = 1;
                        }
                        this.expirationNanos = j2;
                        return t;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.delegate + AVFSCacheConstants.COMMA_SEP + this.durationNanos + ", NANOS)";
        }
    }

    @VisibleForTesting
    /* compiled from: Taobao */
    static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;
        volatile transient boolean initialized;
        @NullableDecl
        transient T value;

        MemoizingSupplier(Supplier<T> supplier) {
            this.delegate = (Supplier) ds1.p(supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        T t = this.delegate.get();
                        this.value = t;
                        this.initialized = true;
                        return t;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.initialized) {
                obj = "<supplier that returned " + ((Object) this.value) + jl1.G;
            } else {
                obj = this.delegate;
            }
            sb.append(obj);
            sb.append(jl1.BRACKET_END_STR);
            return sb.toString();
        }
    }

    /* compiled from: Taobao */
    private static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Function<? super F, T> function;
        final Supplier<F> supplier;

        SupplierComposition(Function<? super F, T> function2, Supplier<F> supplier2) {
            this.function = (Function) ds1.p(function2);
            this.supplier = (Supplier) ds1.p(supplier2);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof SupplierComposition)) {
                return false;
            }
            SupplierComposition supplierComposition = (SupplierComposition) obj;
            if (!this.function.equals(supplierComposition.function) || !this.supplier.equals(supplierComposition.supplier)) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            return this.function.apply(this.supplier.get());
        }

        public int hashCode() {
            return rk1.b(this.function, this.supplier);
        }

        public String toString() {
            return "Suppliers.compose(" + this.function + AVFSCacheConstants.COMMA_SEP + this.supplier + jl1.BRACKET_END_STR;
        }
    }

    /* compiled from: Taobao */
    private interface SupplierFunction<T> extends Function<Supplier<T>, T> {
    }

    /* compiled from: Taobao */
    private enum SupplierFunctionImpl implements SupplierFunction<Object> {
        INSTANCE;

        public String toString() {
            return "Suppliers.supplierFunction()";
        }

        public Object apply(Supplier<Object> supplier) {
            return supplier.get();
        }
    }

    /* compiled from: Taobao */
    private static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        @NullableDecl
        final T instance;

        SupplierOfInstance(@NullableDecl T t) {
            this.instance = t;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return rk1.a(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return rk1.b(this.instance);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + ((Object) this.instance) + jl1.BRACKET_END_STR;
        }
    }

    /* compiled from: Taobao */
    private static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;

        ThreadSafeSupplier(Supplier<T> supplier) {
            this.delegate = (Supplier) ds1.p(supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            T t;
            synchronized (this.delegate) {
                t = this.delegate.get();
            }
            return t;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.delegate + jl1.BRACKET_END_STR;
        }
    }

    public static <T> Supplier<T> a(@NullableDecl T t) {
        return new SupplierOfInstance(t);
    }
}
