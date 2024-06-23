package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.wr2;

@GwtCompatible(emulated = true, serializable = true)
/* compiled from: Taobao */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;
    @NullableDecl
    @RetainedWith
    @LazyInit
    private transient ImmutableList<E> asList;

    /* compiled from: Taobao */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    /* compiled from: Taobao */
    public static class a<E> extends ImmutableCollection.a<E> {
        @VisibleForTesting
        @NullableDecl
        Object[] d;
        private int e;

        public a() {
            super(4);
        }

        private void k(E e2) {
            int length = this.d.length - 1;
            int hashCode = e2.hashCode();
            int c = z.c(hashCode);
            while (true) {
                int i = c & length;
                Object[] objArr = this.d;
                Object obj = objArr[i];
                if (obj == null) {
                    objArr[i] = e2;
                    this.e += hashCode;
                    super.f(e2);
                    return;
                } else if (!obj.equals(e2)) {
                    c = i + 1;
                } else {
                    return;
                }
            }
        }

        @CanIgnoreReturnValue
        /* renamed from: h */
        public a<E> a(E e2) {
            ds1.p(e2);
            if (this.d == null || ImmutableSet.chooseTableSize(this.b) > this.d.length) {
                this.d = null;
                super.f(e2);
                return this;
            }
            k(e2);
            return this;
        }

        @CanIgnoreReturnValue
        public a<E> i(E... eArr) {
            if (this.d != null) {
                for (E e2 : eArr) {
                    a(e2);
                }
            } else {
                super.b(eArr);
            }
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.ImmutableSet$a<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public a<E> j(Iterator<? extends E> it) {
            ds1.p(it);
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public ImmutableSet<E> l() {
            ImmutableSet<E> immutableSet;
            int i = this.b;
            if (i == 0) {
                return ImmutableSet.of();
            }
            if (i == 1) {
                return ImmutableSet.of(this.a[0]);
            }
            if (this.d == null || ImmutableSet.chooseTableSize(i) != this.d.length) {
                immutableSet = ImmutableSet.construct(this.b, this.a);
                this.b = immutableSet.size();
            } else {
                Object[] copyOf = ImmutableSet.shouldTrim(this.b, this.a.length) ? Arrays.copyOf(this.a, this.b) : this.a;
                int i2 = this.e;
                Object[] objArr = this.d;
                immutableSet = new RegularImmutableSet<>(copyOf, i2, objArr, objArr.length - 1, this.b);
            }
            this.c = true;
            this.d = null;
            return immutableSet;
        }

        a(int i) {
            super(i);
            this.d = new Object[ImmutableSet.chooseTableSize(i)];
        }
    }

    ImmutableSet() {
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    @Beta
    public static <E> a<E> builderWithExpectedSize(int i) {
        k.b(i, "expectedSize");
        return new a<>(i);
    }

    @VisibleForTesting
    static int chooseTableSize(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < CUTOFF) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * DESIRED_LOAD_FACTOR < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z = false;
        }
        ds1.e(z, "collection too large");
        return 1073741824;
    }

    /* access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i, Object... objArr) {
        if (i == 0) {
            return of();
        }
        if (i == 1) {
            return of(objArr[0]);
        }
        int chooseTableSize = chooseTableSize(i);
        Object[] objArr2 = new Object[chooseTableSize];
        int i2 = chooseTableSize - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object a2 = b0.a(objArr[i5], i5);
            int hashCode = a2.hashCode();
            int c = z.c(hashCode);
            while (true) {
                int i6 = c & i2;
                Object obj = objArr2[i6];
                if (obj == null) {
                    objArr[i4] = a2;
                    objArr2[i6] = a2;
                    i3 += hashCode;
                    i4++;
                    break;
                } else if (obj.equals(a2)) {
                    break;
                } else {
                    c++;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new SingletonImmutableSet(objArr[0], i3);
        }
        if (chooseTableSize(i4) < chooseTableSize / 2) {
            return construct(i4, objArr);
        }
        if (shouldTrim(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new RegularImmutableSet(objArr, i3, objArr2, i2, i4);
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    /* access modifiers changed from: private */
    public static boolean shouldTrim(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> createAsList = createAsList();
        this.asList = createAsList;
        return createAsList;
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableSet) || !isHashCodeFast() || !((ImmutableSet) obj).isHashCodeFast() || hashCode() == obj.hashCode()) {
            return Sets.a(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return Sets.b(this);
    }

    /* access modifiers changed from: package-private */
    public boolean isHashCodeFast() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.ImmutableCollection, com.google.common.collect.ImmutableCollection, java.util.Set, java.lang.Iterable
    public abstract wr2<E> iterator();

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e) {
        return new SingletonImmutableSet(e);
    }

    public static <E> ImmutableSet<E> of(E e, E e2) {
        return construct(2, e, e2);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3) {
        return construct(3, e, e2, e3);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4) {
        return construct(4, e, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5) {
        return construct(5, e, e2, e3, e4, e5);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        ds1.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.google.common.collect.ImmutableSet$a */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return of(next);
        }
        return new a().a(next).j(it).l();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return construct(eArr.length, (Object[]) eArr.clone());
        }
        return of(eArr[0]);
    }
}
