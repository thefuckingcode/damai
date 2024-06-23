package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.wr2;

@GwtCompatible(emulated = true, serializable = true)
/* compiled from: Taobao */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, SortedIterable<E> {
    final transient Comparator<? super E> comparator;
    @GwtIncompatible
    @LazyInit
    transient ImmutableSortedSet<E> descendingSet;

    /* compiled from: Taobao */
    private static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator2, Object[] objArr) {
            this.comparator = comparator2;
            this.elements = objArr;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableSortedSet$a */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return new a(this.comparator).n(this.elements).l();
        }
    }

    /* compiled from: Taobao */
    public static final class a<E> extends ImmutableSet.a<E> {
        private final Comparator<? super E> f;

        public a(Comparator<? super E> comparator) {
            this.f = (Comparator) ds1.p(comparator);
        }

        @CanIgnoreReturnValue
        /* renamed from: m */
        public a<E> h(E e) {
            super.a(e);
            return this;
        }

        @CanIgnoreReturnValue
        public a<E> n(E... eArr) {
            super.i(eArr);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: o */
        public a<E> j(Iterator<? extends E> it) {
            super.j(it);
            return this;
        }

        /* renamed from: p */
        public ImmutableSortedSet<E> l() {
            ImmutableSortedSet<E> construct = ImmutableSortedSet.construct(this.f, this.b, this.a);
            this.b = construct.size();
            this.c = true;
            return construct;
        }
    }

    ImmutableSortedSet(Comparator<? super E> comparator2) {
        this.comparator = comparator2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator2, int i, E... eArr) {
        if (i == 0) {
            return emptySet(comparator2);
        }
        b0.c(eArr, i);
        Arrays.sort(eArr, 0, i, comparator2);
        int i2 = 1;
        for (int i3 = 1; i3 < i; i3++) {
            Object obj = (Object) eArr[i3];
            if (comparator2.compare(obj, (Object) eArr[i2 - 1]) != 0) {
                eArr[i2] = obj;
                i2++;
            }
        }
        Arrays.fill(eArr, i2, i, (Object) null);
        int length = eArr.length / 2;
        E[] eArr2 = eArr;
        if (i2 < length) {
            eArr2 = (E[]) Arrays.copyOf(eArr, i2);
        }
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr2, i2), comparator2);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> copyOf(E[] eArr) {
        return construct(Ordering.natural(), eArr.length, (Object[]) eArr.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator a2 = g0.a(sortedSet);
        ImmutableList copyOf = ImmutableList.copyOf((Collection) sortedSet);
        if (copyOf.isEmpty()) {
            return emptySet(a2);
        }
        return new RegularImmutableSortedSet(copyOf, a2);
    }

    static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator2) {
        return Ordering.natural().equals(comparator2) ? (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.NATURAL_EMPTY_SET : new RegularImmutableSortedSet<>(ImmutableList.of(), comparator2);
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a<>(Ordering.natural());
    }

    public static <E> ImmutableSortedSet<E> of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator2) {
        return new a<>(comparator2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a<>(Collections.reverseOrder());
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public E ceiling(E e) {
        return (E) a0.e(tailSet((Object) e, true), null);
    }

    @Override // java.util.SortedSet, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public abstract ImmutableSortedSet<E> createDescendingSet();

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public abstract wr2<E> descendingIterator();

    @Override // java.util.SortedSet
    public E first() {
        return iterator().next();
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public E floor(E e) {
        return (E) Iterators.m(headSet((Object) e, true).descendingIterator(), null);
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> headSetImpl(E e, boolean z);

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public E higher(E e) {
        return (E) a0.e(tailSet((Object) e, false), null);
    }

    /* access modifiers changed from: package-private */
    public abstract int indexOf(@NullableDecl Object obj);

    @Override // java.util.AbstractCollection, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableSet, com.google.common.collect.SortedIterable, java.util.Collection, com.google.common.collect.ImmutableCollection, com.google.common.collect.ImmutableCollection, java.util.Set, java.util.NavigableSet, java.lang.Iterable
    public abstract wr2<E> iterator();

    @Override // java.util.SortedSet
    public E last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public E lower(E e) {
        return (E) Iterators.m(headSet((Object) e, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    @Deprecated
    @CanIgnoreReturnValue
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    @Deprecated
    @CanIgnoreReturnValue
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> subSetImpl(E e, boolean z, E e2, boolean z2);

    /* access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> tailSetImpl(E e, boolean z);

    /* access modifiers changed from: package-private */
    public int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e) {
        return new RegularImmutableSortedSet(ImmutableList.of(e), Ordering.natural());
    }

    static int unsafeCompare(Comparator<?> comparator2, Object obj, Object obj2) {
        return comparator2.compare(obj, obj2);
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
        this.descendingSet = createDescendingSet;
        createDescendingSet.descendingSet = this;
        return createDescendingSet;
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2) {
        return construct(Ordering.natural(), 2, e, e2);
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public ImmutableSortedSet<E> headSet(E e) {
        return headSet((Object) e, false);
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public ImmutableSortedSet<E> subSet(E e, E e2) {
        return subSet((Object) e, true, (Object) e2, false);
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public ImmutableSortedSet<E> tailSet(E e) {
        return tailSet((Object) e, true);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        return copyOf((Comparator) Ordering.natural(), (Collection) collection);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3) {
        return construct(Ordering.natural(), 3, e, e2, e3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableSortedSet<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    @GwtIncompatible
    public ImmutableSortedSet<E> headSet(E e, boolean z) {
        return headSetImpl(ds1.p(e), z);
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public ImmutableSortedSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        ds1.p(e);
        ds1.p(e2);
        ds1.d(this.comparator.compare(e, e2) <= 0);
        return subSetImpl(e, z, e2, z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableSortedSet<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    @GwtIncompatible
    public ImmutableSortedSet<E> tailSet(E e, boolean z) {
        return tailSetImpl(ds1.p(e), z);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3, E e4) {
        return construct(Ordering.natural(), 4, e, e2, e3, e4);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3, E e4, E e5) {
        return construct(Ordering.natural(), 5, e, e2, e3, e4, e5);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        int length = eArr.length + 6;
        Comparable[] comparableArr = new Comparable[length];
        comparableArr[0] = e;
        comparableArr[1] = e2;
        comparableArr[2] = e3;
        comparableArr[3] = e4;
        comparableArr[4] = e5;
        comparableArr[5] = e6;
        System.arraycopy(eArr, 0, comparableArr, 6, eArr.length);
        return construct(Ordering.natural(), length, comparableArr);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator2, Iterator<? extends E> it) {
        return new a(comparator2).j(it).l();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator2, Iterable<? extends E> iterable) {
        ds1.p(comparator2);
        if (g0.b(comparator2, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.isPartialView()) {
                return immutableSortedSet;
            }
        }
        Object[] k = a0.k(iterable);
        return construct(comparator2, k.length, k);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator2, Collection<? extends E> collection) {
        return copyOf((Comparator) comparator2, (Iterable) collection);
    }
}
