package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.math.c;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import tb.ds1;

@GwtIncompatible
/* compiled from: Taobao */
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {
    @LazyInit
    transient ImmutableSortedMultiset<E> descendingMultiset;

    /* compiled from: Taobao */
    private static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        SerializedForm(SortedMultiset<E> sortedMultiset) {
            this.comparator = sortedMultiset.comparator();
            int size = sortedMultiset.entrySet().size();
            this.elements = (E[]) new Object[size];
            this.counts = new int[size];
            int i = 0;
            for (Multiset.Entry<E> entry : sortedMultiset.entrySet()) {
                this.elements[i] = entry.getElement();
                this.counts[i] = entry.getCount();
                i++;
            }
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            int length = this.elements.length;
            a aVar = new a(this.comparator);
            for (int i = 0; i < length; i++) {
                aVar.j(this.elements[i], this.counts[i]);
            }
            return aVar.k();
        }
    }

    /* compiled from: Taobao */
    public static class a<E> extends ImmutableMultiset.b<E> {
        private final Comparator<? super E> d;
        @VisibleForTesting
        E[] e = ((E[]) new Object[4]);
        private int[] f = new int[4];
        private int g;
        private boolean h;

        public a(Comparator<? super E> comparator) {
            super(true);
            this.d = (Comparator) ds1.p(comparator);
        }

        private void s(boolean z) {
            int i = this.g;
            if (i != 0) {
                E[] eArr = (E[]) Arrays.copyOf(this.e, i);
                Arrays.sort(eArr, this.d);
                int i2 = 1;
                for (int i3 = 1; i3 < eArr.length; i3++) {
                    if (this.d.compare(eArr[i2 - 1], eArr[i3]) < 0) {
                        eArr[i2] = eArr[i3];
                        i2++;
                    }
                }
                Arrays.fill(eArr, i2, this.g, (Object) null);
                if (z) {
                    int i4 = i2 * 4;
                    int i5 = this.g;
                    if (i4 > i5 * 3) {
                        eArr = (E[]) Arrays.copyOf(eArr, c.f(i5, (i5 / 2) + 1));
                    }
                }
                int[] iArr = new int[eArr.length];
                for (int i6 = 0; i6 < this.g; i6++) {
                    int binarySearch = Arrays.binarySearch(eArr, 0, i2, this.e[i6], this.d);
                    int[] iArr2 = this.f;
                    if (iArr2[i6] >= 0) {
                        iArr[binarySearch] = iArr[binarySearch] + iArr2[i6];
                    } else {
                        iArr[binarySearch] = ~iArr2[i6];
                    }
                }
                this.e = eArr;
                this.f = iArr;
                this.g = i2;
            }
        }

        private void t() {
            s(false);
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = this.g;
                if (i < i3) {
                    int[] iArr = this.f;
                    if (iArr[i] > 0) {
                        E[] eArr = this.e;
                        eArr[i2] = eArr[i];
                        iArr[i2] = iArr[i];
                        i2++;
                    }
                    i++;
                } else {
                    Arrays.fill(this.e, i2, i3, (Object) null);
                    Arrays.fill(this.f, i2, this.g, 0);
                    this.g = i2;
                    return;
                }
            }
        }

        private void u() {
            int i = this.g;
            E[] eArr = this.e;
            if (i == eArr.length) {
                s(true);
            } else if (this.h) {
                this.e = (E[]) Arrays.copyOf(eArr, eArr.length);
            }
            this.h = false;
        }

        @CanIgnoreReturnValue
        /* renamed from: m */
        public a<E> f(E e2) {
            return j(e2, 1);
        }

        @CanIgnoreReturnValue
        /* renamed from: n */
        public a<E> g(E... eArr) {
            for (E e2 : eArr) {
                f(e2);
            }
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.ImmutableSortedMultiset$a<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        /* renamed from: o */
        public a<E> h(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                for (Multiset.Entry<E> entry : ((Multiset) iterable).entrySet()) {
                    j(entry.getElement(), entry.getCount());
                }
            } else {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
            }
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.ImmutableSortedMultiset$a<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        /* renamed from: p */
        public a<E> i(Iterator<? extends E> it) {
            while (it.hasNext()) {
                f(it.next());
            }
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: q */
        public a<E> j(E e2, int i) {
            ds1.p(e2);
            k.b(i, "occurrences");
            if (i == 0) {
                return this;
            }
            u();
            E[] eArr = this.e;
            int i2 = this.g;
            eArr[i2] = e2;
            this.f[i2] = i;
            this.g = i2 + 1;
            return this;
        }

        /* renamed from: r */
        public ImmutableSortedMultiset<E> k() {
            t();
            int i = this.g;
            if (i == 0) {
                return ImmutableSortedMultiset.emptyMultiset(this.d);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.d, i, this.e);
            long[] jArr = new long[(this.g + 1)];
            int i2 = 0;
            while (i2 < this.g) {
                int i3 = i2 + 1;
                jArr[i3] = jArr[i2] + ((long) this.f[i2]);
                i2 = i3;
            }
            this.h = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.g);
        }
    }

    ImmutableSortedMultiset() {
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> copyOf(E[] eArr) {
        return copyOf(Ordering.natural(), Arrays.asList(eArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> sortedMultiset) {
        return copyOfSortedEntries(sortedMultiset.comparator(), Lists.j(sortedMultiset.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<Multiset.Entry<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.a aVar = new ImmutableList.a(collection.size());
        long[] jArr = new long[(collection.size() + 1)];
        int i = 0;
        for (Multiset.Entry<E> entry : collection) {
            aVar.a(entry.getElement());
            int i2 = i + 1;
            jArr[i2] = jArr[i] + ((long) entry.getCount());
            i = i2;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(aVar.j(), comparator), jArr, 0, collection.size());
    }

    static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        return Ordering.natural().equals(comparator) ? (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET : new RegularImmutableSortedMultiset(comparator);
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a<>(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        return new a<>(comparator);
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a<>(Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.common.collect.SortedMultisetBridge, com.google.common.collect.Multiset, com.google.common.collect.SortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableMultiset
    public abstract ImmutableSortedSet<E> elementSet();

    @Override // com.google.common.collect.SortedMultiset
    public abstract ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType);

    @Override // com.google.common.collect.SortedMultiset
    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    public abstract ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType);

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection, com.google.common.collect.ImmutableMultiset
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of((Comparable) e), new long[]{0, 1}, 0, 1);
    }

    @Override // com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            immutableSortedMultiset = isEmpty() ? emptyMultiset(Ordering.from(comparator()).reverse()) : new DescendingImmutableSortedMultiset<>(this);
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    @Override // com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        ds1.l(comparator().compare(e, e2) <= 0, "Expected lowerBound <= upperBound but %s > %s", e, e2);
        return tailMultiset((Object) e, boundType).headMultiset((Object) e2, boundType2);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2) {
        return copyOf(Ordering.natural(), Arrays.asList(e, e2));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        ds1.p(comparator);
        return new a(comparator).i(it).k();
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2, E e3) {
        return copyOf(Ordering.natural(), Arrays.asList(e, e2, e3));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2, E e3, E e4) {
        return copyOf(Ordering.natural(), Arrays.asList(e, e2, e3, e4));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        return new a(comparator).h(iterable).k();
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2, E e3, E e4, E e5) {
        return copyOf(Ordering.natural(), Arrays.asList(e, e2, e3, e4, e5));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        ArrayList l = Lists.l(eArr.length + 6);
        Collections.addAll(l, e, e2, e3, e4, e5, e6);
        Collections.addAll(l, eArr);
        return copyOf(Ordering.natural(), l);
    }
}
