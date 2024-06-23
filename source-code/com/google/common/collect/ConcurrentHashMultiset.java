package com.google.common.collect;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Multiset;
import com.google.common.collect.f0;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.cn0;
import tb.ds1;

@GwtIncompatible
/* compiled from: Taobao */
public final class ConcurrentHashMultiset<E> extends d<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    /* compiled from: Taobao */
    class b extends AbstractIterator<Multiset.Entry<E>> {
        private final Iterator<Map.Entry<E, AtomicInteger>> c;

        b() {
            this.c = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Multiset.Entry<E> a() {
            while (this.c.hasNext()) {
                Map.Entry<E, AtomicInteger> next = this.c.next();
                int i = next.getValue().get();
                if (i != 0) {
                    return Multisets.g(next.getKey(), i);
                }
            }
            return (Multiset.Entry) b();
        }
    }

    /* compiled from: Taobao */
    class c extends cn0<Multiset.Entry<E>> {
        @NullableDecl
        private Multiset.Entry<E> a;
        final /* synthetic */ Iterator b;

        c(Iterator it) {
            this.b = it;
        }

        /* access modifiers changed from: protected */
        @Override // tb.cn0
        /* renamed from: a */
        public Iterator<Multiset.Entry<E>> delegate() {
            return this.b;
        }

        /* renamed from: b */
        public Multiset.Entry<E> next() {
            Multiset.Entry<E> entry = (Multiset.Entry) super.next();
            this.a = entry;
            return entry;
        }

        public void remove() {
            k.e(this.a != null);
            ConcurrentHashMultiset.this.setCount(this.a.getElement(), 0);
            this.a = null;
        }
    }

    /* compiled from: Taobao */
    private class d extends d<E>.b {
        private d() {
            super();
        }

        private List<Multiset.Entry<E>> c() {
            ArrayList m = Lists.m(size());
            Iterators.a(m, iterator());
            return m;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public ConcurrentHashMultiset<E> a() {
            return ConcurrentHashMultiset.this;
        }

        public Object[] toArray() {
            return c().toArray();
        }

        /* synthetic */ d(ConcurrentHashMultiset concurrentHashMultiset, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) c().toArray(tArr);
        }
    }

    /* compiled from: Taobao */
    private static class e {
        static final f0.b<ConcurrentHashMultiset> a = f0.a(ConcurrentHashMultiset.class, "countMap");
    }

    @VisibleForTesting
    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        ds1.k(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        e.a.b(this, (ConcurrentMap) objectInputStream.readObject());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList m = Lists.m(size());
        for (E e2 : entrySet()) {
            Object element = e2.getElement();
            for (int count = e2.getCount(); count > 0; count--) {
                m.add(element);
            }
        }
        return m;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L_0x006f;
     */
    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    @CanIgnoreReturnValue
    public int add(E e2, int i) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        ds1.p(e2);
        if (i == 0) {
            return count(e2);
        }
        k.d(i, "occurences");
        do {
            atomicInteger = (AtomicInteger) Maps.x(this.countMap, e2);
            if (atomicInteger != null || (atomicInteger = this.countMap.putIfAbsent(e2, new AtomicInteger(i))) != null) {
                while (true) {
                    int i2 = atomicInteger.get();
                    if (i2 == 0) {
                        break;
                    }
                    try {
                        if (atomicInteger.compareAndSet(i2, com.google.common.math.c.a(i2, i))) {
                            return i2;
                        }
                    } catch (ArithmeticException unused) {
                        throw new IllegalArgumentException("Overflow adding " + i + " occurrences to a count of " + i2);
                    }
                }
            } else {
                return 0;
            }
        } while (!this.countMap.replace(e2, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // com.google.common.collect.d
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public Set<E> createElementSet() {
        return new a(this, this.countMap.keySet());
    }

    @Override // com.google.common.collect.d
    @Deprecated
    public Set<Multiset.Entry<E>> createEntrySet() {
        return new d(this, null);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public int distinctElements() {
        return this.countMap.size();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new c(new b());
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.d
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i) {
        int i2;
        int max;
        if (i == 0) {
            return count(obj);
        }
        k.d(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            max = Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, max));
        if (max == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i2;
    }

    @CanIgnoreReturnValue
    public boolean removeExactly(@NullableDecl Object obj, int i) {
        int i2;
        int i3;
        if (i == 0) {
            return true;
        }
        k.d(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 < i) {
                return false;
            }
            i3 = i2 - i;
        } while (!atomicInteger.compareAndSet(i2, i3));
        if (i3 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r6 != 0) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L_0x0044;
     */
    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    @CanIgnoreReturnValue
    public int setCount(E e2, int i) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        ds1.p(e2);
        k.b(i, AdUtConstants.XAD_UT_ARG_COUNT);
        do {
            atomicInteger = (AtomicInteger) Maps.x(this.countMap, e2);
            if (atomicInteger == null && (i == 0 || (atomicInteger = this.countMap.putIfAbsent(e2, new AtomicInteger(i))) == null)) {
                return 0;
            }
            while (true) {
                int i2 = atomicInteger.get();
                if (i2 == 0) {
                    break;
                } else if (atomicInteger.compareAndSet(i2, i)) {
                    if (i == 0) {
                        this.countMap.remove(e2, atomicInteger);
                    }
                    return i2;
                }
            }
        } while (!this.countMap.replace(e2, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // com.google.common.collect.Multiset
    public int size() {
        long j = 0;
        for (AtomicInteger atomicInteger : this.countMap.values()) {
            j += (long) atomicInteger.get();
        }
        return Ints.j(j);
    }

    public Object[] toArray() {
        return snapshot().toArray();
    }

    /* compiled from: Taobao */
    class a extends v<E> {
        final /* synthetic */ Set a;

        a(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
            this.a = set;
        }

        @Override // com.google.common.collect.o
        public boolean contains(@NullableDecl Object obj) {
            return obj != null && l.d(this.a, obj);
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.o
        public boolean remove(Object obj) {
            return obj != null && l.e(this.a, obj);
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t, com.google.common.collect.v, com.google.common.collect.v, com.google.common.collect.v
        public Set<E> delegate() {
            return this.a;
        }
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        a0.a(create, iterable);
        return create;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) snapshot().toArray(tArr);
    }

    @Beta
    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.d
    @CanIgnoreReturnValue
    public boolean setCount(E e2, int i, int i2) {
        ds1.p(e2);
        k.b(i, "oldCount");
        k.b(i2, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, e2);
        if (atomicInteger != null) {
            int i3 = atomicInteger.get();
            if (i3 == i) {
                if (i3 == 0) {
                    if (i2 == 0) {
                        this.countMap.remove(e2, atomicInteger);
                        return true;
                    }
                    AtomicInteger atomicInteger2 = new AtomicInteger(i2);
                    if (this.countMap.putIfAbsent(e2, atomicInteger2) == null || this.countMap.replace(e2, atomicInteger, atomicInteger2)) {
                        return true;
                    }
                    return false;
                } else if (atomicInteger.compareAndSet(i3, i2)) {
                    if (i2 == 0) {
                        this.countMap.remove(e2, atomicInteger);
                    }
                    return true;
                }
            }
            return false;
        } else if (i != 0) {
            return false;
        } else {
            if (i2 == 0 || this.countMap.putIfAbsent(e2, new AtomicInteger(i2)) == null) {
                return true;
            }
            return false;
        }
    }
}
