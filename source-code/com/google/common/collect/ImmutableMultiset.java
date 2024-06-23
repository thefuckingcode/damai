package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.wr2;

@GwtCompatible(emulated = true, serializable = true)
/* compiled from: Taobao */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements Multiset<E> {
    @LazyInit
    private transient ImmutableList<E> asList;
    @LazyInit
    private transient ImmutableSet<Multiset.Entry<E>> entrySet;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class EntrySet extends IndexedImmutableSet<Multiset.Entry<E>> {
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean contains(Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            if (entry.getCount() > 0 && ImmutableMultiset.this.count(entry.getElement()) == entry.getCount()) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        public Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }

        /* synthetic */ EntrySet(ImmutableMultiset immutableMultiset, a aVar) {
            this();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.IndexedImmutableSet
        public Multiset.Entry<E> get(int i) {
            return ImmutableMultiset.this.getEntry(i);
        }
    }

    @GwtIncompatible
    /* compiled from: Taobao */
    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends wr2<E> {
        int a;
        @MonotonicNonNullDecl
        E b;
        final /* synthetic */ Iterator c;

        a(ImmutableMultiset immutableMultiset, Iterator it) {
            this.c = it;
        }

        public boolean hasNext() {
            return this.a > 0 || this.c.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.a <= 0) {
                Multiset.Entry entry = (Multiset.Entry) this.c.next();
                this.b = (E) entry.getElement();
                this.a = entry.getCount();
            }
            this.a--;
            return this.b;
        }
    }

    /* compiled from: Taobao */
    public static class b<E> extends ImmutableCollection.b<E> {
        c0<E> a;
        boolean b;
        boolean c;

        public b() {
            this(4);
        }

        /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: com.google.common.collect.c0<E>, com.google.common.collect.c0<T> */
        /* JADX DEBUG: Type inference failed for r1v5. Raw type applied. Possible types: com.google.common.collect.c0<E>, com.google.common.collect.c0<T> */
        @NullableDecl
        static <T> c0<T> l(Iterable<T> iterable) {
            if (iterable instanceof RegularImmutableMultiset) {
                return (c0<E>) ((RegularImmutableMultiset) iterable).contents;
            }
            if (iterable instanceof AbstractMapBasedMultiset) {
                return (c0<E>) ((AbstractMapBasedMultiset) iterable).backingMap;
            }
            return null;
        }

        @CanIgnoreReturnValue
        /* renamed from: f */
        public b<E> a(E e) {
            return j(e, 1);
        }

        @CanIgnoreReturnValue
        public b<E> g(E... eArr) {
            super.b(eArr);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.ImmutableMultiset$b<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public b<E> h(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                Multiset d = Multisets.d(iterable);
                c0 l = l(d);
                if (l != null) {
                    c0<E> c0Var = this.a;
                    c0Var.d(Math.max(c0Var.C(), l.C()));
                    for (int e = l.e(); e >= 0; e = l.s(e)) {
                        j(l.i(e), l.k(e));
                    }
                } else {
                    Set<Multiset.Entry<E>> entrySet = d.entrySet();
                    c0<E> c0Var2 = this.a;
                    c0Var2.d(Math.max(c0Var2.C(), entrySet.size()));
                    for (Multiset.Entry<E> entry : d.entrySet()) {
                        j(entry.getElement(), entry.getCount());
                    }
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public b<E> i(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        @CanIgnoreReturnValue
        public b<E> j(E e, int i) {
            if (i == 0) {
                return this;
            }
            if (this.b) {
                this.a = new c0<>(this.a);
                this.c = false;
            }
            this.b = false;
            ds1.p(e);
            c0<E> c0Var = this.a;
            c0Var.u(e, i + c0Var.f(e));
            return this;
        }

        public ImmutableMultiset<E> k() {
            if (this.a.C() == 0) {
                return ImmutableMultiset.of();
            }
            if (this.c) {
                this.a = new c0<>(this.a);
                this.c = false;
            }
            this.b = true;
            return new RegularImmutableMultiset(this.a);
        }

        b(int i) {
            this.b = false;
            this.c = false;
            this.a = c0.c(i);
        }

        b(boolean z) {
            this.b = false;
            this.c = false;
            this.a = null;
        }
    }

    ImmutableMultiset() {
    }

    public static <E> b<E> builder() {
        return new b<>();
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        return new b().g(eArr).k();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableMultiset$b */
    /* JADX WARN: Multi-variable type inference failed */
    static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Multiset.Entry<? extends E>> collection) {
        b bVar = new b(collection.size());
        Iterator<? extends Multiset.Entry<? extends E>> it = collection.iterator();
        while (it.hasNext()) {
            Multiset.Entry entry = (Multiset.Entry) it.next();
            bVar.j(entry.getElement(), entry.getCount());
        }
        return bVar.k();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    private ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new EntrySet(this, null);
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> asList2 = super.asList();
        this.asList = asList2;
        return asList2;
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.ImmutableCollection
    public boolean contains(@NullableDecl Object obj) {
        return count(obj) > 0;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public int copyIntoArray(Object[] objArr, int i) {
        wr2<Multiset.Entry<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            Multiset.Entry<E> next = it.next();
            Arrays.fill(objArr, i, next.getCount() + i, next.getElement());
            i += next.getCount();
        }
        return i;
    }

    @Override // com.google.common.collect.Multiset
    public abstract ImmutableSet<E> elementSet();

    @Override // com.google.common.collect.Multiset
    public boolean equals(@NullableDecl Object obj) {
        return Multisets.f(this, obj);
    }

    /* access modifiers changed from: package-private */
    public abstract Multiset.Entry<E> getEntry(int i);

    @Override // com.google.common.collect.Multiset
    public int hashCode() {
        return Sets.b(entrySet());
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int setCount(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    public String toString() {
        return entrySet().toString();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        b bVar = new b(Multisets.h(iterable));
        bVar.h(iterable);
        return bVar.k();
    }

    public static <E> ImmutableMultiset<E> of(E e) {
        return copyFromElements(e);
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset, java.util.Collection, com.google.common.collect.ImmutableCollection, com.google.common.collect.ImmutableCollection, java.lang.Iterable
    public wr2<E> iterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean setCount(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2) {
        return copyFromElements(e, e2);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3) {
        return copyFromElements(e, e2, e3);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4) {
        return copyFromElements(e, e2, e3, e4);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5) {
        return copyFromElements(e, e2, e3, e4, e5);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        return new b().a(e).a(e2).a(e3).a(e4).a(e5).a(e6).g(eArr).k();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new b().i(it).k();
    }
}
