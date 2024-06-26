package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

/* access modifiers changed from: package-private */
@GwtCompatible
/* compiled from: Taobao */
public final class Absent<T> extends Optional<T> {
    static final Absent<Object> INSTANCE = new Absent<>();
    private static final long serialVersionUID = 0;

    private Absent() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    static <T> Optional<T> withType() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.emptySet();
    }

    @Override // com.google.common.base.Optional
    public boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return 2040732332;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // com.google.common.base.Optional
    public T or(T t) {
        return (T) ds1.q(t, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // com.google.common.base.Optional
    @NullableDecl
    public T orNull() {
        return null;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(Function<? super T, V> function) {
        ds1.p(function);
        return Optional.absent();
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        return (Optional) ds1.p(optional);
    }

    @Override // com.google.common.base.Optional
    public T or(Supplier<? extends T> supplier) {
        return (T) ds1.q(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }
}
