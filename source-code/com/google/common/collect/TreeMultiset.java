package com.google.common.collect;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class TreeMultiset<E> extends g<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 1;
    private final transient e<E> header;
    private final transient GeneralRange<E> range;
    private final transient f<e<E>> rootReference;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum Aggregate {
        SIZE {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return ((e) eVar).b;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(@NullableDecl e<?> eVar) {
                if (eVar == null) {
                    return 0;
                }
                return ((e) eVar).d;
            }
        },
        DISTINCT {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return 1;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(@NullableDecl e<?> eVar) {
                if (eVar == null) {
                    return 0;
                }
                return (long) ((e) eVar).c;
            }
        };

        /* access modifiers changed from: package-private */
        public abstract int nodeAggregate(e<?> eVar);

        /* access modifiers changed from: package-private */
        public abstract long treeAggregate(@NullableDecl e<?> eVar);

        /* synthetic */ Aggregate(a aVar) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends Multisets.b<E> {
        final /* synthetic */ e a;

        a(e eVar) {
            this.a = eVar;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            int x = this.a.x();
            return x == 0 ? TreeMultiset.this.count(getElement()) : x;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public E getElement() {
            return (E) this.a.y();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements Iterator<Multiset.Entry<E>> {
        e<E> a;
        @NullableDecl
        Multiset.Entry<E> b;

        b() {
            this.a = TreeMultiset.this.firstNode();
        }

        /* renamed from: a */
        public Multiset.Entry<E> next() {
            if (hasNext()) {
                Multiset.Entry<E> wrapEntry = TreeMultiset.this.wrapEntry(this.a);
                this.b = wrapEntry;
                if (((e) this.a).i == TreeMultiset.this.header) {
                    this.a = null;
                } else {
                    this.a = ((e) this.a).i;
                }
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooHigh(this.a.y())) {
                return true;
            }
            this.a = null;
            return false;
        }

        public void remove() {
            k.e(this.b != null);
            TreeMultiset.this.setCount(this.b.getElement(), 0);
            this.b = null;
        }
    }

    /* compiled from: Taobao */
    class c implements Iterator<Multiset.Entry<E>> {
        e<E> a;
        Multiset.Entry<E> b = null;

        c() {
            this.a = TreeMultiset.this.lastNode();
        }

        /* renamed from: a */
        public Multiset.Entry<E> next() {
            if (hasNext()) {
                Multiset.Entry<E> wrapEntry = TreeMultiset.this.wrapEntry(this.a);
                this.b = wrapEntry;
                if (((e) this.a).h == TreeMultiset.this.header) {
                    this.a = null;
                } else {
                    this.a = ((e) this.a).h;
                }
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.a == null) {
                return false;
            }
            if (!TreeMultiset.this.range.tooLow(this.a.y())) {
                return true;
            }
            this.a = null;
            return false;
        }

        public void remove() {
            k.e(this.b != null);
            TreeMultiset.this.setCount(this.b.getElement(), 0);
            this.b = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[BoundType.values().length];
            a = iArr;
            iArr[BoundType.OPEN.ordinal()] = 1;
            a[BoundType.CLOSED.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class e<E> {
        @NullableDecl
        private final E a;
        private int b;
        private int c;
        private long d;
        private int e;
        @NullableDecl
        private e<E> f;
        @NullableDecl
        private e<E> g;
        @NullableDecl
        private e<E> h;
        @NullableDecl
        private e<E> i;

        e(@NullableDecl E e2, int i2) {
            ds1.d(i2 > 0);
            this.a = e2;
            this.b = i2;
            this.d = (long) i2;
            this.c = 1;
            this.e = 1;
            this.f = null;
            this.g = null;
        }

        private e<E> A() {
            int s = s();
            if (s == -2) {
                if (this.g.s() > 0) {
                    this.g = this.g.I();
                }
                return H();
            } else if (s != 2) {
                C();
                return this;
            } else {
                if (this.f.s() < 0) {
                    this.f = this.f.H();
                }
                return I();
            }
        }

        private void B() {
            D();
            C();
        }

        private void C() {
            this.e = Math.max(z(this.f), z(this.g)) + 1;
        }

        private void D() {
            this.c = TreeMultiset.distinctElements(this.f) + 1 + TreeMultiset.distinctElements(this.g);
            this.d = ((long) this.b) + L(this.f) + L(this.g);
        }

        private e<E> F(e<E> eVar) {
            e<E> eVar2 = this.g;
            if (eVar2 == null) {
                return this.f;
            }
            this.g = eVar2.F(eVar);
            this.c--;
            this.d -= (long) eVar.b;
            return A();
        }

        private e<E> G(e<E> eVar) {
            e<E> eVar2 = this.f;
            if (eVar2 == null) {
                return this.g;
            }
            this.f = eVar2.G(eVar);
            this.c--;
            this.d -= (long) eVar.b;
            return A();
        }

        private e<E> H() {
            ds1.w(this.g != null);
            e<E> eVar = this.g;
            this.g = eVar.f;
            eVar.f = this;
            eVar.d = this.d;
            eVar.c = this.c;
            B();
            eVar.C();
            return eVar;
        }

        private e<E> I() {
            ds1.w(this.f != null);
            e<E> eVar = this.f;
            this.f = eVar.g;
            eVar.g = this;
            eVar.d = this.d;
            eVar.c = this.c;
            B();
            eVar.C();
            return eVar;
        }

        private static long L(@NullableDecl e<?> eVar) {
            if (eVar == null) {
                return 0;
            }
            return ((e) eVar).d;
        }

        private e<E> q(E e2, int i2) {
            e<E> eVar = new e<>(e2, i2);
            this.f = eVar;
            TreeMultiset.successor(this.h, eVar, this);
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += (long) i2;
            return this;
        }

        private e<E> r(E e2, int i2) {
            e<E> eVar = new e<>(e2, i2);
            this.g = eVar;
            TreeMultiset.successor(this, eVar, this.i);
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += (long) i2;
            return this;
        }

        private int s() {
            return z(this.f) - z(this.g);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @NullableDecl
        private e<E> t(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, this.a);
            if (compare < 0) {
                e<E> eVar = this.f;
                return eVar == null ? this : (e) com.google.common.base.e.a(eVar.t(comparator, e2), this);
            } else if (compare == 0) {
                return this;
            } else {
                e<E> eVar2 = this.g;
                if (eVar2 == null) {
                    return null;
                }
                return eVar2.t(comparator, e2);
            }
        }

        private e<E> v() {
            int i2 = this.b;
            this.b = 0;
            TreeMultiset.successor(this.h, this.i);
            e<E> eVar = this.f;
            if (eVar == null) {
                return this.g;
            }
            e<E> eVar2 = this.g;
            if (eVar2 == null) {
                return eVar;
            }
            if (eVar.e >= eVar2.e) {
                e<E> eVar3 = this.h;
                eVar3.f = eVar.F(eVar3);
                eVar3.g = this.g;
                eVar3.c = this.c - 1;
                eVar3.d = this.d - ((long) i2);
                return eVar3.A();
            }
            e<E> eVar4 = this.i;
            eVar4.g = eVar2.G(eVar4);
            eVar4.f = this.f;
            eVar4.c = this.c - 1;
            eVar4.d = this.d - ((long) i2);
            return eVar4.A();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @NullableDecl
        private e<E> w(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, this.a);
            if (compare > 0) {
                e<E> eVar = this.g;
                return eVar == null ? this : (e) com.google.common.base.e.a(eVar.w(comparator, e2), this);
            } else if (compare == 0) {
                return this;
            } else {
                e<E> eVar2 = this.f;
                if (eVar2 == null) {
                    return null;
                }
                return eVar2.w(comparator, e2);
            }
        }

        private static int z(@NullableDecl e<?> eVar) {
            if (eVar == null) {
                return 0;
            }
            return ((e) eVar).e;
        }

        /* access modifiers changed from: package-private */
        public e<E> E(Comparator<? super E> comparator, @NullableDecl E e2, int i2, int[] iArr) {
            int compare = comparator.compare(e2, this.a);
            if (compare < 0) {
                e<E> eVar = this.f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f = eVar.E(comparator, e2, i2, iArr);
                if (iArr[0] > 0) {
                    if (i2 >= iArr[0]) {
                        this.c--;
                        this.d -= (long) iArr[0];
                    } else {
                        this.d -= (long) i2;
                    }
                }
                return iArr[0] == 0 ? this : A();
            } else if (compare > 0) {
                e<E> eVar2 = this.g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.g = eVar2.E(comparator, e2, i2, iArr);
                if (iArr[0] > 0) {
                    if (i2 >= iArr[0]) {
                        this.c--;
                        this.d -= (long) iArr[0];
                    } else {
                        this.d -= (long) i2;
                    }
                }
                return A();
            } else {
                int i3 = this.b;
                iArr[0] = i3;
                if (i2 >= i3) {
                    return v();
                }
                this.b = i3 - i2;
                this.d -= (long) i2;
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        public e<E> J(Comparator<? super E> comparator, @NullableDecl E e2, int i2, int i3, int[] iArr) {
            int compare = comparator.compare(e2, this.a);
            if (compare < 0) {
                e<E> eVar = this.f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return (i2 != 0 || i3 <= 0) ? this : q(e2, i3);
                }
                this.f = eVar.J(comparator, e2, i2, i3, iArr);
                if (iArr[0] == i2) {
                    if (i3 == 0 && iArr[0] != 0) {
                        this.c--;
                    } else if (i3 > 0 && iArr[0] == 0) {
                        this.c++;
                    }
                    this.d += (long) (i3 - iArr[0]);
                }
                return A();
            } else if (compare > 0) {
                e<E> eVar2 = this.g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    return (i2 != 0 || i3 <= 0) ? this : r(e2, i3);
                }
                this.g = eVar2.J(comparator, e2, i2, i3, iArr);
                if (iArr[0] == i2) {
                    if (i3 == 0 && iArr[0] != 0) {
                        this.c--;
                    } else if (i3 > 0 && iArr[0] == 0) {
                        this.c++;
                    }
                    this.d += (long) (i3 - iArr[0]);
                }
                return A();
            } else {
                int i4 = this.b;
                iArr[0] = i4;
                if (i2 == i4) {
                    if (i3 == 0) {
                        return v();
                    }
                    this.d += (long) (i3 - i4);
                    this.b = i3;
                }
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        public e<E> K(Comparator<? super E> comparator, @NullableDecl E e2, int i2, int[] iArr) {
            int compare = comparator.compare(e2, this.a);
            if (compare < 0) {
                e<E> eVar = this.f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return i2 > 0 ? q(e2, i2) : this;
                }
                this.f = eVar.K(comparator, e2, i2, iArr);
                if (i2 == 0 && iArr[0] != 0) {
                    this.c--;
                } else if (i2 > 0 && iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) (i2 - iArr[0]);
                return A();
            } else if (compare > 0) {
                e<E> eVar2 = this.g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    return i2 > 0 ? r(e2, i2) : this;
                }
                this.g = eVar2.K(comparator, e2, i2, iArr);
                if (i2 == 0 && iArr[0] != 0) {
                    this.c--;
                } else if (i2 > 0 && iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) (i2 - iArr[0]);
                return A();
            } else {
                int i3 = this.b;
                iArr[0] = i3;
                if (i2 == 0) {
                    return v();
                }
                this.d += (long) (i2 - i3);
                this.b = i2;
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        public e<E> p(Comparator<? super E> comparator, @NullableDecl E e2, int i2, int[] iArr) {
            int compare = comparator.compare(e2, this.a);
            boolean z = true;
            if (compare < 0) {
                e<E> eVar = this.f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return q(e2, i2);
                }
                int i3 = eVar.e;
                e<E> p = eVar.p(comparator, e2, i2, iArr);
                this.f = p;
                if (iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) i2;
                return p.e == i3 ? this : A();
            } else if (compare > 0) {
                e<E> eVar2 = this.g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    return r(e2, i2);
                }
                int i4 = eVar2.e;
                e<E> p2 = eVar2.p(comparator, e2, i2, iArr);
                this.g = p2;
                if (iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) i2;
                return p2.e == i4 ? this : A();
            } else {
                int i5 = this.b;
                iArr[0] = i5;
                long j = (long) i2;
                if (((long) i5) + j > 2147483647L) {
                    z = false;
                }
                ds1.d(z);
                this.b += i2;
                this.d += j;
                return this;
            }
        }

        public String toString() {
            return Multisets.g(y(), x()).toString();
        }

        public int u(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, this.a);
            if (compare < 0) {
                e<E> eVar = this.f;
                if (eVar == null) {
                    return 0;
                }
                return eVar.u(comparator, e2);
            } else if (compare <= 0) {
                return this.b;
            } else {
                e<E> eVar2 = this.g;
                if (eVar2 == null) {
                    return 0;
                }
                return eVar2.u(comparator, e2);
            }
        }

        /* access modifiers changed from: package-private */
        public int x() {
            return this.b;
        }

        /* access modifiers changed from: package-private */
        public E y() {
            return this.a;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class f<T> {
        @NullableDecl
        private T a;

        private f() {
        }

        public void a(@NullableDecl T t, T t2) {
            if (this.a == t) {
                this.a = t2;
                return;
            }
            throw new ConcurrentModificationException();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.a = null;
        }

        @NullableDecl
        public T c() {
            return this.a;
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    TreeMultiset(f<e<E>> fVar, GeneralRange<E> generalRange, e<E> eVar) {
        super(generalRange.comparator());
        this.rootReference = fVar;
        this.range = generalRange;
        this.header = eVar;
    }

    private long aggregateAboveRange(Aggregate aggregate, @NullableDecl e<E> eVar) {
        long treeAggregate;
        long aggregateAboveRange;
        if (eVar == null) {
            return 0;
        }
        int compare = comparator().compare(this.range.getUpperEndpoint(), ((e) eVar).a);
        if (compare > 0) {
            return aggregateAboveRange(aggregate, ((e) eVar).g);
        }
        if (compare == 0) {
            int i = d.a[this.range.getUpperBoundType().ordinal()];
            if (i == 1) {
                treeAggregate = (long) aggregate.nodeAggregate(eVar);
                aggregateAboveRange = aggregate.treeAggregate(((e) eVar).g);
            } else if (i == 2) {
                return aggregate.treeAggregate(((e) eVar).g);
            } else {
                throw new AssertionError();
            }
        } else {
            treeAggregate = aggregate.treeAggregate(((e) eVar).g) + ((long) aggregate.nodeAggregate(eVar));
            aggregateAboveRange = aggregateAboveRange(aggregate, ((e) eVar).f);
        }
        return treeAggregate + aggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, @NullableDecl e<E> eVar) {
        long treeAggregate;
        long aggregateBelowRange;
        if (eVar == null) {
            return 0;
        }
        int compare = comparator().compare(this.range.getLowerEndpoint(), ((e) eVar).a);
        if (compare < 0) {
            return aggregateBelowRange(aggregate, ((e) eVar).f);
        }
        if (compare == 0) {
            int i = d.a[this.range.getLowerBoundType().ordinal()];
            if (i == 1) {
                treeAggregate = (long) aggregate.nodeAggregate(eVar);
                aggregateBelowRange = aggregate.treeAggregate(((e) eVar).f);
            } else if (i == 2) {
                return aggregate.treeAggregate(((e) eVar).f);
            } else {
                throw new AssertionError();
            }
        } else {
            treeAggregate = aggregate.treeAggregate(((e) eVar).f) + ((long) aggregate.nodeAggregate(eVar));
            aggregateBelowRange = aggregateBelowRange(aggregate, ((e) eVar).g);
        }
        return treeAggregate + aggregateBelowRange;
    }

    private long aggregateForEntries(Aggregate aggregate) {
        e<E> c2 = this.rootReference.c();
        long treeAggregate = aggregate.treeAggregate(c2);
        if (this.range.hasLowerBound()) {
            treeAggregate -= aggregateBelowRange(aggregate, c2);
        }
        return this.range.hasUpperBound() ? treeAggregate - aggregateAboveRange(aggregate, c2) : treeAggregate;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NullableDecl
    private e<E> firstNode() {
        e<E> eVar;
        if (this.rootReference.c() == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            E lowerEndpoint = this.range.getLowerEndpoint();
            eVar = this.rootReference.c().t(comparator(), lowerEndpoint);
            if (eVar == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(lowerEndpoint, eVar.y()) == 0) {
                eVar = ((e) eVar).i;
            }
        } else {
            eVar = ((e) this.header).i;
        }
        if (eVar == this.header || !this.range.contains(eVar.y())) {
            return null;
        }
        return eVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NullableDecl
    private e<E> lastNode() {
        e<E> eVar;
        if (this.rootReference.c() == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            E upperEndpoint = this.range.getUpperEndpoint();
            eVar = this.rootReference.c().w(comparator(), upperEndpoint);
            if (eVar == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(upperEndpoint, eVar.y()) == 0) {
                eVar = ((e) eVar).h;
            }
        } else {
            eVar = ((e) this.header).h;
        }
        if (eVar == this.header || !this.range.contains(eVar.y())) {
            return null;
        }
        return eVar;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        f0.a(g.class, "comparator").b(this, comparator);
        f0.a(TreeMultiset.class, "range").b(this, GeneralRange.all(comparator));
        f0.a(TreeMultiset.class, "rootReference").b(this, new f(null));
        e eVar = new e(null, 1);
        f0.a(TreeMultiset.class, "header").b(this, eVar);
        successor(eVar, eVar);
        f0.f(this, objectInputStream);
    }

    /* access modifiers changed from: private */
    public static <T> void successor(e<T> eVar, e<T> eVar2) {
        ((e) eVar).i = eVar2;
        ((e) eVar2).h = eVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Multiset.Entry<E> wrapEntry(e<E> eVar) {
        return new a(eVar);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        f0.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    @CanIgnoreReturnValue
    public int add(@NullableDecl E e2, int i) {
        k.b(i, "occurrences");
        if (i == 0) {
            return count(e2);
        }
        ds1.d(this.range.contains(e2));
        e<E> c2 = this.rootReference.c();
        if (c2 == null) {
            comparator().compare(e2, e2);
            e<E> eVar = new e<>(e2, i);
            e<E> eVar2 = this.header;
            successor(eVar2, eVar, eVar2);
            this.rootReference.a(c2, eVar);
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c2, c2.p(comparator(), e2, i, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.d
    public void clear() {
        if (this.range.hasLowerBound() || this.range.hasUpperBound()) {
            Iterators.d(entryIterator());
            return;
        }
        e<E> eVar = ((e) this.header).i;
        while (true) {
            e<E> eVar2 = this.header;
            if (eVar != eVar2) {
                e<E> eVar3 = ((e) eVar).i;
                ((e) eVar).b = 0;
                ((e) eVar).f = null;
                ((e) eVar).g = null;
                ((e) eVar).h = null;
                ((e) eVar).i = null;
                eVar = eVar3;
            } else {
                successor(eVar2, eVar2);
                this.rootReference.b();
                return;
            }
        }
    }

    @Override // com.google.common.collect.g, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        try {
            e<E> c2 = this.rootReference.c();
            if (this.range.contains(obj)) {
                if (c2 != null) {
                    return c2.u(comparator(), obj);
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.g
    public Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new c();
    }

    @Override // com.google.common.collect.g, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public int distinctElements() {
        return Ints.j(aggregateForEntries(Aggregate.DISTINCT));
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public Iterator<E> elementIterator() {
        return Multisets.e(entryIterator());
    }

    @Override // com.google.common.collect.g, com.google.common.collect.g, com.google.common.collect.g, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedMultisetBridge, com.google.common.collect.Multiset, com.google.common.collect.d
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new b();
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.Multiset, com.google.common.collect.d
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.g, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(@NullableDecl E e2, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e2, boundType)), this.header);
    }

    @Override // com.google.common.collect.d
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable, com.google.common.collect.Multiset, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.g, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.g, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.g, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i) {
        k.b(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        e<E> c2 = this.rootReference.c();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj)) {
                if (c2 != null) {
                    this.rootReference.a(c2, c2.E(comparator(), obj, i, iArr));
                    return iArr[0];
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    @CanIgnoreReturnValue
    public int setCount(@NullableDecl E e2, int i) {
        k.b(i, AdUtConstants.XAD_UT_ARG_COUNT);
        boolean z = true;
        if (!this.range.contains(e2)) {
            if (i != 0) {
                z = false;
            }
            ds1.d(z);
            return 0;
        }
        e<E> c2 = this.rootReference.c();
        if (c2 == null) {
            if (i > 0) {
                add(e2, i);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c2, c2.K(comparator(), e2, i, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.Multiset
    public int size() {
        return Ints.j(aggregateForEntries(Aggregate.SIZE));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.g, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(@NullableDecl Object obj, BoundType boundType, @NullableDecl Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(@NullableDecl E e2, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e2, boundType)), this.header);
    }

    public static <E> TreeMultiset<E> create(@NullableDecl Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    static int distinctElements(@NullableDecl e<?> eVar) {
        if (eVar == null) {
            return 0;
        }
        return ((e) eVar).c;
    }

    /* access modifiers changed from: private */
    public static <T> void successor(e<T> eVar, e<T> eVar2, e<T> eVar3) {
        successor(eVar, eVar2);
        successor(eVar2, eVar3);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        a0.a(create, iterable);
        return create;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        e<E> eVar = new e<>(null, 1);
        this.header = eVar;
        successor(eVar, eVar);
        this.rootReference = new f<>(null);
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    @CanIgnoreReturnValue
    public boolean setCount(@NullableDecl E e2, int i, int i2) {
        k.b(i2, "newCount");
        k.b(i, "oldCount");
        ds1.d(this.range.contains(e2));
        e<E> c2 = this.rootReference.c();
        if (c2 != null) {
            int[] iArr = new int[1];
            this.rootReference.a(c2, c2.J(comparator(), e2, i, i2, iArr));
            if (iArr[0] == i) {
                return true;
            }
            return false;
        } else if (i != 0) {
            return false;
        } else {
            if (i2 > 0) {
                add(e2, i2);
            }
            return true;
        }
    }
}
