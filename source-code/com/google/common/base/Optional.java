package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtCompatible(serializable = true)
/* compiled from: Taobao */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* compiled from: Taobao */
    static class a implements Iterable<T> {
        final /* synthetic */ Iterable a;

        /* renamed from: com.google.common.base.Optional$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        class C0155a extends AbstractIterator<T> {
            private final Iterator<? extends Optional<? extends T>> c;

            C0155a() {
                this.c = (Iterator) ds1.p(a.this.a.iterator());
            }

            /* access modifiers changed from: protected */
            @Override // com.google.common.base.AbstractIterator
            public T a() {
                while (this.c.hasNext()) {
                    Optional optional = (Optional) this.c.next();
                    if (optional.isPresent()) {
                        return (T) optional.get();
                    }
                }
                return (T) b();
            }
        }

        a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C0155a();
        }
    }

    Optional() {
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(@NullableDecl T t) {
        return t == null ? absent() : new Present(t);
    }

    public static <T> Optional<T> of(T t) {
        return new Present(ds1.p(t));
    }

    @Beta
    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        ds1.p(iterable);
        return new a(iterable);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@NullableDecl Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    @Beta
    public abstract T or(Supplier<? extends T> supplier);

    public abstract T or(T t);

    @NullableDecl
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);
}
