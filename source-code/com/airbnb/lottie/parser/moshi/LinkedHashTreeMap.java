package com.airbnb.lottie.parser.moshi;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new a();
    Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.d entrySet;
    final g<K, V> header;
    private LinkedHashTreeMap<K, V>.e keySet;
    int modCount;
    int size;
    g<K, V>[] table;
    int threshold;

    /* compiled from: Taobao */
    class a implements Comparator<Comparable> {
        a() {
        }

        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class b<K, V> {
        private g<K, V> a;
        private int b;
        private int c;
        private int d;

        b() {
        }

        /* access modifiers changed from: package-private */
        public void a(g<K, V> gVar) {
            gVar.c = null;
            gVar.a = null;
            gVar.b = null;
            gVar.i = 1;
            int i = this.b;
            if (i > 0) {
                int i2 = this.d;
                if ((i2 & 1) == 0) {
                    this.d = i2 + 1;
                    this.b = i - 1;
                    this.c++;
                }
            }
            gVar.a = this.a;
            this.a = gVar;
            int i3 = this.d + 1;
            this.d = i3;
            int i4 = this.b;
            if (i4 > 0 && (i3 & 1) == 0) {
                this.d = i3 + 1;
                this.b = i4 - 1;
                this.c++;
            }
            int i5 = 4;
            while (true) {
                int i6 = i5 - 1;
                if ((this.d & i6) == i6) {
                    int i7 = this.c;
                    if (i7 == 0) {
                        g<K, V> gVar2 = this.a;
                        g<K, V> gVar3 = gVar2.a;
                        g<K, V> gVar4 = gVar3.a;
                        gVar3.a = gVar4.a;
                        this.a = gVar3;
                        gVar3.b = gVar4;
                        gVar3.c = gVar2;
                        gVar3.i = gVar2.i + 1;
                        gVar4.a = gVar3;
                        gVar2.a = gVar3;
                    } else if (i7 == 1) {
                        g<K, V> gVar5 = this.a;
                        g<K, V> gVar6 = gVar5.a;
                        this.a = gVar6;
                        gVar6.c = gVar5;
                        gVar6.i = gVar5.i + 1;
                        gVar5.a = gVar6;
                        this.c = 0;
                    } else if (i7 == 2) {
                        this.c = 0;
                    }
                    i5 *= 2;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i) {
            this.b = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.d = 0;
            this.c = 0;
            this.a = null;
        }

        /* access modifiers changed from: package-private */
        public g<K, V> c() {
            g<K, V> gVar = this.a;
            if (gVar.a == null) {
                return gVar;
            }
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c<K, V> {
        private g<K, V> a;

        c() {
        }

        public g<K, V> a() {
            g<K, V> gVar = this.a;
            if (gVar == null) {
                return null;
            }
            g<K, V> gVar2 = gVar.a;
            gVar.a = null;
            g<K, V> gVar3 = gVar.c;
            while (true) {
                gVar2 = gVar3;
                if (gVar2 != null) {
                    gVar2.a = gVar2;
                    gVar3 = gVar2.b;
                } else {
                    this.a = gVar2;
                    return gVar;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(g<K, V> gVar) {
            g<K, V> gVar2 = null;
            while (gVar != null) {
                gVar.a = gVar2;
                gVar2 = gVar;
                gVar = gVar.b;
            }
            this.a = gVar2;
        }
    }

    /* compiled from: Taobao */
    final class d extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: Taobao */
        class a extends LinkedHashTreeMap<K, V>.f {
            a(d dVar) {
                super();
            }

            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        d() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        public boolean remove(Object obj) {
            g<K, V> findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* compiled from: Taobao */
    final class e extends AbstractSet<K> {

        /* compiled from: Taobao */
        class a extends LinkedHashTreeMap<K, V>.f {
            a(e eVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f;
            }
        }

        e() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(this);
        }

        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public abstract class f<T> implements Iterator<T> {
        g<K, V> a;
        g<K, V> b = null;
        int c;

        f() {
            this.a = LinkedHashTreeMap.this.header.d;
            this.c = LinkedHashTreeMap.this.modCount;
        }

        /* access modifiers changed from: package-private */
        public final g<K, V> a() {
            g<K, V> gVar = this.a;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (gVar == linkedHashTreeMap.header) {
                throw new NoSuchElementException();
            } else if (linkedHashTreeMap.modCount == this.c) {
                this.a = gVar.d;
                this.b = gVar;
                return gVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean hasNext() {
            return this.a != LinkedHashTreeMap.this.header;
        }

        public final void remove() {
            g<K, V> gVar = this.b;
            if (gVar != null) {
                LinkedHashTreeMap.this.removeInternal(gVar, true);
                this.b = null;
                this.c = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    LinkedHashTreeMap() {
        this(null);
    }

    private void doubleCapacity() {
        g<K, V>[] doubleCapacity = doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = (doubleCapacity.length / 2) + (doubleCapacity.length / 4);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(g<K, V> gVar, boolean z) {
        while (gVar != null) {
            g<K, V> gVar2 = gVar.b;
            g<K, V> gVar3 = gVar.c;
            int i = 0;
            int i2 = gVar2 != null ? gVar2.i : 0;
            int i3 = gVar3 != null ? gVar3.i : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                g<K, V> gVar4 = gVar3.b;
                g<K, V> gVar5 = gVar3.c;
                int i5 = gVar5 != null ? gVar5.i : 0;
                if (gVar4 != null) {
                    i = gVar4.i;
                }
                int i6 = i - i5;
                if (i6 == -1 || (i6 == 0 && !z)) {
                    rotateLeft(gVar);
                } else {
                    rotateRight(gVar3);
                    rotateLeft(gVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                g<K, V> gVar6 = gVar2.b;
                g<K, V> gVar7 = gVar2.c;
                int i7 = gVar7 != null ? gVar7.i : 0;
                if (gVar6 != null) {
                    i = gVar6.i;
                }
                int i8 = i - i7;
                if (i8 == 1 || (i8 == 0 && !z)) {
                    rotateRight(gVar);
                } else {
                    rotateLeft(gVar2);
                    rotateRight(gVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                gVar.i = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                gVar.i = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            gVar = gVar.a;
        }
    }

    private void replaceInParent(g<K, V> gVar, g<K, V> gVar2) {
        g<K, V> gVar3 = gVar.a;
        gVar.a = null;
        if (gVar2 != null) {
            gVar2.a = gVar3;
        }
        if (gVar3 == null) {
            int i = gVar.g;
            g<K, V>[] gVarArr = this.table;
            gVarArr[i & (gVarArr.length - 1)] = gVar2;
        } else if (gVar3.b == gVar) {
            gVar3.b = gVar2;
        } else {
            gVar3.c = gVar2;
        }
    }

    private void rotateLeft(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.b;
        g<K, V> gVar3 = gVar.c;
        g<K, V> gVar4 = gVar3.b;
        g<K, V> gVar5 = gVar3.c;
        gVar.c = gVar4;
        if (gVar4 != null) {
            gVar4.a = gVar;
        }
        replaceInParent(gVar, gVar3);
        gVar3.b = gVar;
        gVar.a = gVar3;
        int i = 0;
        int max = Math.max(gVar2 != null ? gVar2.i : 0, gVar4 != null ? gVar4.i : 0) + 1;
        gVar.i = max;
        if (gVar5 != null) {
            i = gVar5.i;
        }
        gVar3.i = Math.max(max, i) + 1;
    }

    private void rotateRight(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.b;
        g<K, V> gVar3 = gVar.c;
        g<K, V> gVar4 = gVar2.b;
        g<K, V> gVar5 = gVar2.c;
        gVar.b = gVar5;
        if (gVar5 != null) {
            gVar5.a = gVar;
        }
        replaceInParent(gVar, gVar2);
        gVar2.c = gVar;
        gVar.a = gVar2;
        int i = 0;
        int max = Math.max(gVar3 != null ? gVar3.i : 0, gVar5 != null ? gVar5.i : 0) + 1;
        gVar.i = max;
        if (gVar4 != null) {
            i = gVar4.i;
        }
        gVar2.i = Math.max(max, i) + 1;
    }

    private static int secondaryHash(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        g<K, V> gVar = this.header;
        g<K, V> gVar2 = gVar.d;
        while (gVar2 != gVar) {
            g<K, V> gVar3 = gVar2.d;
            gVar2.e = null;
            gVar2.d = null;
            gVar2 = gVar3;
        }
        gVar.e = gVar;
        gVar.d = gVar;
    }

    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.d dVar = this.entrySet;
        if (dVar != null) {
            return dVar;
        }
        LinkedHashTreeMap<K, V>.d dVar2 = new d();
        this.entrySet = dVar2;
        return dVar2;
    }

    /* access modifiers changed from: package-private */
    public g<K, V> find(K k, boolean z) {
        int i;
        g<K, V> gVar;
        g<K, V> gVar2;
        int i2;
        Comparator<? super K> comparator2 = this.comparator;
        g<K, V>[] gVarArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = (gVarArr.length - 1) & secondaryHash;
        g<K, V> gVar3 = gVarArr[length];
        if (gVar3 != null) {
            K k2 = comparator2 == NATURAL_ORDER ? k : null;
            while (true) {
                if (k2 != null) {
                    i2 = k2.compareTo(gVar3.f);
                } else {
                    i2 = comparator2.compare(k, gVar3.f);
                }
                if (i2 == 0) {
                    return gVar3;
                }
                g<K, V> gVar4 = i2 < 0 ? gVar3.b : gVar3.c;
                if (gVar4 == null) {
                    gVar = gVar3;
                    i = i2;
                    break;
                }
                gVar3 = gVar4;
            }
        } else {
            gVar = gVar3;
            i = 0;
        }
        if (!z) {
            return null;
        }
        g<K, V> gVar5 = this.header;
        if (gVar != null) {
            gVar2 = new g<>(gVar, k, secondaryHash, gVar5, gVar5.e);
            if (i < 0) {
                gVar.b = gVar2;
            } else {
                gVar.c = gVar2;
            }
            rebalance(gVar, true);
        } else if (comparator2 != NATURAL_ORDER || (k instanceof Comparable)) {
            gVar2 = new g<>(gVar, k, secondaryHash, gVar5, gVar5.e);
            gVarArr[length] = gVar2;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return gVar2;
    }

    /* access modifiers changed from: package-private */
    public g<K, V> findByEntry(Map.Entry<?, ?> entry) {
        g<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.h, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public g<K, V> findByObject(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        g<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.e eVar = this.keySet;
        if (eVar != null) {
            return eVar;
        }
        LinkedHashTreeMap<K, V>.e eVar2 = new e();
        this.keySet = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        g<K, V> find = find(k, true);
        V v2 = find.h;
        find.h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.h;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void removeInternal(g<K, V> gVar, boolean z) {
        int i;
        if (z) {
            g<K, V> gVar2 = gVar.e;
            gVar2.d = gVar.d;
            gVar.d.e = gVar2;
            gVar.e = null;
            gVar.d = null;
        }
        g<K, V> gVar3 = gVar.b;
        g<K, V> gVar4 = gVar.c;
        g<K, V> gVar5 = gVar.a;
        int i2 = 0;
        if (gVar3 == null || gVar4 == null) {
            if (gVar3 != null) {
                replaceInParent(gVar, gVar3);
                gVar.b = null;
            } else if (gVar4 != null) {
                replaceInParent(gVar, gVar4);
                gVar.c = null;
            } else {
                replaceInParent(gVar, null);
            }
            rebalance(gVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        g<K, V> b2 = gVar3.i > gVar4.i ? gVar3.b() : gVar4.a();
        removeInternal(b2, false);
        g<K, V> gVar6 = gVar.b;
        if (gVar6 != null) {
            i = gVar6.i;
            b2.b = gVar6;
            gVar6.a = b2;
            gVar.b = null;
        } else {
            i = 0;
        }
        g<K, V> gVar7 = gVar.c;
        if (gVar7 != null) {
            i2 = gVar7.i;
            b2.c = gVar7;
            gVar7.a = b2;
            gVar.c = null;
        }
        b2.i = Math.max(i, i2) + 1;
        replaceInParent(gVar, b2);
    }

    /* access modifiers changed from: package-private */
    public g<K, V> removeInternalByKey(Object obj) {
        g<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    public int size() {
        return this.size;
    }

    LinkedHashTreeMap(Comparator<? super K> comparator2) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator2 == null ? NATURAL_ORDER : comparator2;
        this.header = new g<>();
        g<K, V>[] gVarArr = new g[16];
        this.table = gVarArr;
        this.threshold = (gVarArr.length / 2) + (gVarArr.length / 4);
    }

    static <K, V> g<K, V>[] doubleCapacity(g<K, V>[] gVarArr) {
        int length = gVarArr.length;
        g<K, V>[] gVarArr2 = new g[(length * 2)];
        c cVar = new c();
        b bVar = new b();
        b bVar2 = new b();
        for (int i = 0; i < length; i++) {
            g<K, V> gVar = gVarArr[i];
            if (gVar != null) {
                cVar.b(gVar);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    g<K, V> a2 = cVar.a();
                    if (a2 == null) {
                        break;
                    } else if ((a2.g & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                bVar.b(i2);
                bVar2.b(i3);
                cVar.b(gVar);
                while (true) {
                    g<K, V> a3 = cVar.a();
                    if (a3 == null) {
                        break;
                    } else if ((a3.g & length) == 0) {
                        bVar.a(a3);
                    } else {
                        bVar2.a(a3);
                    }
                }
                g<K, V> gVar2 = null;
                gVarArr2[i] = i2 > 0 ? bVar.c() : null;
                int i4 = i + length;
                if (i3 > 0) {
                    gVar2 = bVar2.c();
                }
                gVarArr2[i4] = gVar2;
            }
        }
        return gVarArr2;
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class g<K, V> implements Map.Entry<K, V> {
        g<K, V> a;
        g<K, V> b;
        g<K, V> c;
        g<K, V> d;
        g<K, V> e;
        final K f;
        final int g;
        V h;
        int i;

        g() {
            this.f = null;
            this.g = -1;
            this.e = this;
            this.d = this;
        }

        public g<K, V> a() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.b; gVar2 != null; gVar2 = gVar2.b) {
                gVar = gVar2;
            }
            return gVar;
        }

        public g<K, V> b() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.c; gVar2 != null; gVar2 = gVar2.c) {
                gVar = gVar2;
            }
            return gVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.h;
            if (v == null) {
                if (entry.getValue() == null) {
                    return true;
                }
                return false;
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.h;
        }

        public int hashCode() {
            K k = this.f;
            int i2 = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.h;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.h;
            this.h = v;
            return v2;
        }

        public String toString() {
            return ((Object) this.f) + "=" + ((Object) this.h);
        }

        g(g<K, V> gVar, K k, int i2, g<K, V> gVar2, g<K, V> gVar3) {
            this.a = gVar;
            this.f = k;
            this.g = i2;
            this.i = 1;
            this.d = gVar2;
            this.e = gVar3;
            gVar3.d = this;
            gVar2.e = this;
        }
    }
}
