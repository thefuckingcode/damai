package com.google.common.collect;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.rk1;

@GwtCompatible
/* compiled from: Taobao */
public final class Multisets {

    /* compiled from: Taobao */
    static class ImmutableEntry<E> extends b<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;
        @NullableDecl
        private final E element;

        ImmutableEntry(@NullableDecl E e, int i) {
            this.element = e;
            this.count = i;
            k.b(i, AdUtConstants.XAD_UT_ARG_COUNT);
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.Multiset.Entry
        @NullableDecl
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class UnmodifiableMultiset<E> extends s<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multiset<? extends E> delegate;
        @MonotonicNonNullDecl
        transient Set<E> elementSet;
        @MonotonicNonNullDecl
        transient Set<Multiset.Entry<E>> entrySet;

        UnmodifiableMultiset(Multiset<? extends E> multiset) {
            this.delegate = multiset;
        }

        @Override // com.google.common.collect.Multiset, java.util.Collection, com.google.common.collect.o
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, com.google.common.collect.o
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.o
        public void clear() {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // com.google.common.collect.Multiset, com.google.common.collect.s
        public Set<E> elementSet() {
            Set<E> set = this.elementSet;
            if (set != null) {
                return set;
            }
            Set<E> createElementSet = createElementSet();
            this.elementSet = createElementSet;
            return createElementSet;
        }

        @Override // com.google.common.collect.Multiset, com.google.common.collect.s
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<Multiset.Entry<E>> unmodifiableSet = Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = unmodifiableSet;
            return unmodifiableSet;
        }

        @Override // com.google.common.collect.Multiset, java.util.Collection, com.google.common.collect.o, java.lang.Iterable
        public Iterator<E> iterator() {
            return Iterators.x(this.delegate.iterator());
        }

        @Override // com.google.common.collect.Multiset, com.google.common.collect.o
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multiset, java.util.Collection, com.google.common.collect.o
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multiset, java.util.Collection, com.google.common.collect.o
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multiset, com.google.common.collect.s
        public int setCount(E e, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multiset, com.google.common.collect.s
        public int add(E e, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multiset, com.google.common.collect.s
        public int remove(Object obj, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multiset, com.google.common.collect.s
        public boolean setCount(E e, int i, int i2) {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: com.google.common.collect.Multiset<? extends E>, com.google.common.collect.Multiset<E> */
        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.s, com.google.common.collect.s, com.google.common.collect.s, com.google.common.collect.t
        public Multiset<E> delegate() {
            return (Multiset<? extends E>) this.delegate;
        }
    }

    /* compiled from: Taobao */
    static class a extends j0<Multiset.Entry<E>, E> {
        a(Iterator it) {
            super(it);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public E a(Multiset.Entry<E> entry) {
            return entry.getElement();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class b<E> implements Multiset.Entry<E> {
        b() {
        }

        @Override // com.google.common.collect.Multiset.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            if (getCount() != entry.getCount() || !rk1.a(getElement(), entry.getElement())) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int hashCode() {
            int i;
            E element = getElement();
            if (element == null) {
                i = 0;
            } else {
                i = element.hashCode();
            }
            return i ^ getCount();
        }

        @Override // com.google.common.collect.Multiset.Entry
        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            return valueOf + " x " + count;
        }
    }

    /* compiled from: Taobao */
    static abstract class c<E> extends Sets.a<E> {
        c() {
        }

        /* access modifiers changed from: package-private */
        public abstract Multiset<E> a();

        public void clear() {
            a().clear();
        }

        public boolean contains(Object obj) {
            return a().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return a().containsAll(collection);
        }

        public boolean isEmpty() {
            return a().isEmpty();
        }

        public boolean remove(Object obj) {
            return a().remove(obj, Integer.MAX_VALUE) > 0;
        }

        public int size() {
            return a().entrySet().size();
        }
    }

    /* compiled from: Taobao */
    static abstract class d<E> extends Sets.a<Multiset.Entry<E>> {
        d() {
        }

        /* access modifiers changed from: package-private */
        public abstract Multiset<E> a();

        public void clear() {
            a().clear();
        }

        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            if (entry.getCount() > 0 && a().count(entry.getElement()) == entry.getCount()) {
                return true;
            }
            return false;
        }

        public boolean remove(Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                E e = (E) entry.getElement();
                int count = entry.getCount();
                if (count != 0) {
                    return a().setCount(e, count, 0);
                }
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    static final class e<E> implements Iterator<E> {
        private final Multiset<E> a;
        private final Iterator<Multiset.Entry<E>> b;
        @MonotonicNonNullDecl
        private Multiset.Entry<E> c;
        private int d;
        private int e;
        private boolean f;

        e(Multiset<E> multiset, Iterator<Multiset.Entry<E>> it) {
            this.a = multiset;
            this.b = it;
        }

        public boolean hasNext() {
            return this.d > 0 || this.b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                if (this.d == 0) {
                    Multiset.Entry<E> next = this.b.next();
                    this.c = next;
                    int count = next.getCount();
                    this.d = count;
                    this.e = count;
                }
                this.d--;
                this.f = true;
                return this.c.getElement();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            k.e(this.f);
            if (this.e == 1) {
                this.b.remove();
            } else {
                this.a.remove(this.c.getElement());
            }
            this.e--;
            this.f = false;
        }
    }

    private static <E> boolean a(Multiset<E> multiset, AbstractMapBasedMultiset<? extends E> abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.addTo(multiset);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.Multiset<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private static <E> boolean b(Multiset<E> multiset, Multiset<? extends E> multiset2) {
        if (multiset2 instanceof AbstractMapBasedMultiset) {
            return a(multiset, (AbstractMapBasedMultiset) multiset2);
        }
        if (multiset2.isEmpty()) {
            return false;
        }
        for (Multiset.Entry<? extends E> entry : multiset2.entrySet()) {
            multiset.add(entry.getElement(), entry.getCount());
        }
        return true;
    }

    static <E> boolean c(Multiset<E> multiset, Collection<? extends E> collection) {
        ds1.p(multiset);
        ds1.p(collection);
        if (collection instanceof Multiset) {
            return b(multiset, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.a(multiset, collection.iterator());
    }

    static <T> Multiset<T> d(Iterable<T> iterable) {
        return (Multiset) iterable;
    }

    static <E> Iterator<E> e(Iterator<Multiset.Entry<E>> it) {
        return new a(it);
    }

    static boolean f(Multiset<?> multiset, @NullableDecl Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (obj instanceof Multiset) {
            Multiset multiset2 = (Multiset) obj;
            if (multiset.size() == multiset2.size() && multiset.entrySet().size() == multiset2.entrySet().size()) {
                for (Multiset.Entry entry : multiset2.entrySet()) {
                    if (multiset.count(entry.getElement()) != entry.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> Multiset.Entry<E> g(@NullableDecl E e2, int i) {
        return new ImmutableEntry(e2, i);
    }

    static int h(Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).elementSet().size();
        }
        return 11;
    }

    static <E> Iterator<E> i(Multiset<E> multiset) {
        return new e(multiset, multiset.entrySet().iterator());
    }

    static int j(Multiset<?> multiset) {
        long j = 0;
        for (Multiset.Entry<?> entry : multiset.entrySet()) {
            j += (long) entry.getCount();
        }
        return Ints.j(j);
    }

    static boolean k(Multiset<?> multiset, Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().removeAll(collection);
    }

    static boolean l(Multiset<?> multiset, Collection<?> collection) {
        ds1.p(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().retainAll(collection);
    }

    static <E> int m(Multiset<E> multiset, E e2, int i) {
        k.b(i, AdUtConstants.XAD_UT_ARG_COUNT);
        int count = multiset.count(e2);
        int i2 = i - count;
        if (i2 > 0) {
            multiset.add(e2, i2);
        } else if (i2 < 0) {
            multiset.remove(e2, -i2);
        }
        return count;
    }

    static <E> boolean n(Multiset<E> multiset, E e2, int i, int i2) {
        k.b(i, "oldCount");
        k.b(i2, "newCount");
        if (multiset.count(e2) != i) {
            return false;
        }
        multiset.setCount(e2, i2);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.Multiset<? extends E> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Multiset<E> o(Multiset<? extends E> multiset) {
        return ((multiset instanceof UnmodifiableMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new UnmodifiableMultiset((Multiset) ds1.p(multiset));
    }

    @Beta
    public static <E> SortedMultiset<E> p(SortedMultiset<E> sortedMultiset) {
        return new UnmodifiableSortedMultiset((SortedMultiset) ds1.p(sortedMultiset));
    }
}
