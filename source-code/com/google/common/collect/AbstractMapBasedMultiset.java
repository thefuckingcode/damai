package com.google.common.collect;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public abstract class AbstractMapBasedMultiset<E> extends d<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    transient c0<E> backingMap;
    transient long size;

    /* compiled from: Taobao */
    class a extends AbstractMapBasedMultiset<E>.c {
        a() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        public E b(int i) {
            return AbstractMapBasedMultiset.this.backingMap.i(i);
        }
    }

    /* compiled from: Taobao */
    class b extends AbstractMapBasedMultiset<E>.c {
        b() {
            super();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public Multiset.Entry<E> b(int i) {
            return AbstractMapBasedMultiset.this.backingMap.g(i);
        }
    }

    /* compiled from: Taobao */
    abstract class c<T> implements Iterator<T> {
        int a;
        int b = -1;
        int c;

        c() {
            this.a = AbstractMapBasedMultiset.this.backingMap.e();
            this.c = AbstractMapBasedMultiset.this.backingMap.d;
        }

        private void a() {
            if (AbstractMapBasedMultiset.this.backingMap.d != this.c) {
                throw new ConcurrentModificationException();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract T b(int i);

        public boolean hasNext() {
            a();
            return this.a >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T b2 = b(this.a);
                int i = this.a;
                this.b = i;
                this.a = AbstractMapBasedMultiset.this.backingMap.s(i);
                return b2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            a();
            k.e(this.b != -1);
            AbstractMapBasedMultiset abstractMapBasedMultiset = AbstractMapBasedMultiset.this;
            abstractMapBasedMultiset.size -= (long) abstractMapBasedMultiset.backingMap.x(this.b);
            this.a = AbstractMapBasedMultiset.this.backingMap.t(this.a, this.b);
            this.b = -1;
            this.c = AbstractMapBasedMultiset.this.backingMap.d;
        }
    }

    AbstractMapBasedMultiset(int i) {
        init(i);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h = f0.h(objectInputStream);
        init(3);
        f0.g(this, objectInputStream, h);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        f0.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    @CanIgnoreReturnValue
    public final int add(@NullableDecl E e, int i) {
        if (i == 0) {
            return count(e);
        }
        boolean z = true;
        ds1.f(i > 0, "occurrences cannot be negative: %s", i);
        int m = this.backingMap.m(e);
        if (m == -1) {
            this.backingMap.u(e, i);
            this.size += (long) i;
            return 0;
        }
        int k = this.backingMap.k(m);
        long j = (long) i;
        long j2 = ((long) k) + j;
        if (j2 > 2147483647L) {
            z = false;
        }
        ds1.h(z, "too many occurrences: %s", j2);
        this.backingMap.B(m, (int) j2);
        this.size += j;
        return k;
    }

    /* access modifiers changed from: package-private */
    public void addTo(Multiset<? super E> multiset) {
        ds1.p(multiset);
        int e = this.backingMap.e();
        while (e >= 0) {
            multiset.add(this.backingMap.i(e), this.backingMap.k(e));
            e = this.backingMap.s(e);
        }
    }

    @Override // com.google.common.collect.d
    public final void clear() {
        this.backingMap.a();
        this.size = 0;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(@NullableDecl Object obj) {
        return this.backingMap.f(obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public final int distinctElements() {
        return this.backingMap.C();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public final Iterator<E> elementIterator() {
        return new a();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public final Iterator<Multiset.Entry<E>> entryIterator() {
        return new b();
    }

    /* access modifiers changed from: package-private */
    public abstract void init(int i);

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    @CanIgnoreReturnValue
    public final int remove(@NullableDecl Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        ds1.f(i > 0, "occurrences cannot be negative: %s", i);
        int m = this.backingMap.m(obj);
        if (m == -1) {
            return 0;
        }
        int k = this.backingMap.k(m);
        if (k > i) {
            this.backingMap.B(m, k - i);
        } else {
            this.backingMap.x(m);
            i = k;
        }
        this.size -= (long) i;
        return k;
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    @CanIgnoreReturnValue
    public final int setCount(@NullableDecl E e, int i) {
        k.b(i, AdUtConstants.XAD_UT_ARG_COUNT);
        c0<E> c0Var = this.backingMap;
        int v = i == 0 ? c0Var.v(e) : c0Var.u(e, i);
        this.size += (long) (i - v);
        return v;
    }

    @Override // com.google.common.collect.Multiset
    public final int size() {
        return Ints.j(this.size);
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    public final boolean setCount(@NullableDecl E e, int i, int i2) {
        k.b(i, "oldCount");
        k.b(i2, "newCount");
        int m = this.backingMap.m(e);
        if (m == -1) {
            if (i != 0) {
                return false;
            }
            if (i2 > 0) {
                this.backingMap.u(e, i2);
                this.size += (long) i2;
            }
            return true;
        } else if (this.backingMap.k(m) != i) {
            return false;
        } else {
            if (i2 == 0) {
                this.backingMap.x(m);
                this.size -= (long) i;
            } else {
                this.backingMap.B(m, i2);
                this.size += (long) (i2 - i);
            }
            return true;
        }
    }
}
