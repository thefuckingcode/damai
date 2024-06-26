package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.ls1;

@Immutable(containerOf = {"B"})
@GwtIncompatible
/* compiled from: Taobao */
public final class ImmutableClassToInstanceMap<B> extends q<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.of());
    private final ImmutableMap<Class<? extends B>, B> delegate;

    /* compiled from: Taobao */
    public static final class b<B> {
        private final ImmutableMap.b<Class<? extends B>, B> a = ImmutableMap.builder();

        private static <B, T extends B> T b(Class<T> cls, B b) {
            return (T) ls1.d(cls).cast(b);
        }

        public ImmutableClassToInstanceMap<B> a() {
            ImmutableMap<Class<? extends B>, B> a2 = this.a.a();
            if (a2.isEmpty()) {
                return ImmutableClassToInstanceMap.of();
            }
            return new ImmutableClassToInstanceMap<>(a2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.ImmutableMap$b<java.lang.Class<? extends B>, B> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public <T extends B> b<B> c(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class cls = (Class) entry.getKey();
                this.a.c(cls, b(cls, entry.getValue()));
            }
            return this;
        }
    }

    public static <B> b<B> builder() {
        return new b<>();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        if (map instanceof ImmutableClassToInstanceMap) {
            return (ImmutableClassToInstanceMap) map;
        }
        return new b().c(map).a();
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        return (ImmutableClassToInstanceMap<B>) EMPTY;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T extends B, java.lang.Object] */
    @Override // com.google.common.collect.ClassToInstanceMap
    @NullableDecl
    public <T extends B> T getInstance(Class<T> cls) {
        return this.delegate.get(ds1.p(cls));
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @CanIgnoreReturnValue
    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public Object readResolve() {
        return isEmpty() ? of() : this;
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> cls, T t) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.of(cls, t));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }
}
