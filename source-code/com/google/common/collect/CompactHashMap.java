package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.rk1;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* compiled from: Taobao */
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final float LOAD_FACTOR = 1.0f;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;
    @VisibleForTesting
    @MonotonicNonNullDecl
    transient long[] entries;
    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> entrySetView;
    @MonotonicNonNullDecl
    private transient Set<K> keySetView;
    @VisibleForTesting
    @MonotonicNonNullDecl
    transient Object[] keys;
    transient int modCount;
    private transient int size;
    @MonotonicNonNullDecl
    private transient int[] table;
    @VisibleForTesting
    @MonotonicNonNullDecl
    transient Object[] values;
    @MonotonicNonNullDecl
    private transient Collection<V> valuesView;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends CompactHashMap<K, V>.e {
        a() {
            super(CompactHashMap.this, null);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.CompactHashMap.e
        public K b(int i) {
            return (K) CompactHashMap.this.keys[i];
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends CompactHashMap<K, V>.e {
        b() {
            super(CompactHashMap.this, null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public Map.Entry<K, V> b(int i) {
            return new g(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c extends CompactHashMap<K, V>.e {
        c() {
            super(CompactHashMap.this, null);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.CompactHashMap.e
        public V b(int i) {
            return (V) CompactHashMap.this.values[i];
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        d() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int indexOf = CompactHashMap.this.indexOf(entry.getKey());
            if (indexOf == -1 || !rk1.a(CompactHashMap.this.values[indexOf], entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int indexOf = CompactHashMap.this.indexOf(entry.getKey());
            if (indexOf == -1 || !rk1.a(CompactHashMap.this.values[indexOf], entry.getValue())) {
                return false;
            }
            CompactHashMap.this.removeEntry(indexOf);
            return true;
        }

        public int size() {
            return CompactHashMap.this.size;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class f extends AbstractSet<K> {
        f() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        public boolean remove(@NullableDecl Object obj) {
            int indexOf = CompactHashMap.this.indexOf(obj);
            if (indexOf == -1) {
                return false;
            }
            CompactHashMap.this.removeEntry(indexOf);
            return true;
        }

        public int size() {
            return CompactHashMap.this.size;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class g extends b<K, V> {
        @NullableDecl
        private final K a;
        private int b;

        g(int i) {
            this.a = (K) CompactHashMap.this.keys[i];
            this.b = i;
        }

        private void a() {
            int i = this.b;
            if (i == -1 || i >= CompactHashMap.this.size() || !rk1.a(this.a, CompactHashMap.this.keys[this.b])) {
                this.b = CompactHashMap.this.indexOf(this.a);
            }
        }

        @Override // java.util.Map.Entry, com.google.common.collect.b
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry, com.google.common.collect.b
        public V getValue() {
            a();
            int i = this.b;
            if (i == -1) {
                return null;
            }
            return (V) CompactHashMap.this.values[i];
        }

        @Override // java.util.Map.Entry, com.google.common.collect.b
        public V setValue(V v) {
            a();
            int i = this.b;
            if (i == -1) {
                CompactHashMap.this.put(this.a, v);
                return null;
            }
            Object[] objArr = CompactHashMap.this.values;
            V v2 = (V) objArr[i];
            objArr[i] = v;
            return v2;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class h extends AbstractCollection<V> {
        h() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        public int size() {
            return CompactHashMap.this.size;
        }
    }

    CompactHashMap() {
        init(3);
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactHashMap<>(i);
    }

    private static int getHash(long j) {
        return (int) (j >>> 32);
    }

    private static int getNext(long j) {
        return (int) j;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int indexOf(@NullableDecl Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int d2 = z.d(obj);
        int i = this.table[hashTableMask() & d2];
        while (i != -1) {
            long j = this.entries[i];
            if (getHash(j) == d2 && rk1.a(obj, this.keys[i])) {
                return i;
            }
            i = getNext(j);
        }
        return -1;
    }

    private static long[] newEntries(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] newTable(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.CompactHashMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i = 0; i < readInt; i++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @CanIgnoreReturnValue
    private V removeEntry(int i) {
        return remove(this.keys[i], getHash(this.entries[i]));
    }

    private void resizeMeMaybe(int i) {
        int length = this.entries.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    private void resizeTable(int i) {
        int[] newTable = newTable(i);
        long[] jArr = this.entries;
        int length = newTable.length - 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            int hash = getHash(jArr[i2]);
            int i3 = hash & length;
            int i4 = newTable[i3];
            newTable[i3] = i2;
            jArr[i2] = (((long) hash) << 32) | (((long) i4) & NEXT_MASK);
        }
        this.table = newTable;
    }

    private static long swapNext(long j, int i) {
        return (j & HASH_MASK) | (((long) i) & NEXT_MASK);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            objectOutputStream.writeObject(this.keys[firstEntryIndex]);
            objectOutputStream.writeObject(this.values[firstEntryIndex]);
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
    }

    /* access modifiers changed from: package-private */
    public void accessEntry(int i) {
    }

    /* access modifiers changed from: package-private */
    public int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    /* access modifiers changed from: package-private */
    public void allocArrays() {
        ds1.x(needsAllocArrays(), "Arrays already allocated");
        int i = this.modCount;
        this.table = newTable(z.a(i, 1.0d));
        this.entries = newEntries(i);
        this.keys = new Object[i];
        this.values = new Object[i];
    }

    public void clear() {
        if (!needsAllocArrays()) {
            this.modCount++;
            Arrays.fill(this.keys, 0, this.size, (Object) null);
            Arrays.fill(this.values, 0, this.size, (Object) null);
            Arrays.fill(this.table, -1);
            Arrays.fill(this.entries, 0, this.size, -1L);
            this.size = 0;
        }
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        for (int i = 0; i < this.size; i++) {
            if (rk1.a(obj, this.values[i])) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> createEntrySet() {
        return new d();
    }

    /* access modifiers changed from: package-private */
    public Set<K> createKeySet() {
        return new f();
    }

    /* access modifiers changed from: package-private */
    public Collection<V> createValues() {
        return new h();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new b();
    }

    /* access modifiers changed from: package-private */
    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        int indexOf = indexOf(obj);
        accessEntry(indexOf);
        if (indexOf == -1) {
            return null;
        }
        return (V) this.values[indexOf];
    }

    /* access modifiers changed from: package-private */
    public int getSuccessor(int i) {
        int i2 = i + 1;
        if (i2 < this.size) {
            return i2;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void init(int i) {
        ds1.e(i >= 0, "Expected size must be non-negative");
        this.modCount = Math.max(1, i);
    }

    /* access modifiers changed from: package-private */
    public void insertEntry(int i, @NullableDecl K k, @NullableDecl V v, int i2) {
        this.entries[i] = (((long) i2) << 32) | NEXT_MASK;
        this.keys[i] = k;
        this.values[i] = v;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    /* access modifiers changed from: package-private */
    public Iterator<K> keySetIterator() {
        return new a();
    }

    /* access modifiers changed from: package-private */
    public void moveLastEntry(int i) {
        int size2 = size() - 1;
        if (i < size2) {
            Object[] objArr = this.keys;
            objArr[i] = objArr[size2];
            Object[] objArr2 = this.values;
            objArr2[i] = objArr2[size2];
            objArr[size2] = null;
            objArr2[size2] = null;
            long[] jArr = this.entries;
            long j = jArr[size2];
            jArr[i] = j;
            jArr[size2] = -1;
            int hash = getHash(j) & hashTableMask();
            int[] iArr = this.table;
            int i2 = iArr[hash];
            if (i2 == size2) {
                iArr[hash] = i;
                return;
            }
            while (true) {
                long j2 = this.entries[i2];
                int next = getNext(j2);
                if (next == size2) {
                    this.entries[i2] = swapNext(j2, i);
                    return;
                }
                i2 = next;
            }
        } else {
            this.keys[i] = null;
            this.values[i] = null;
            this.entries[i] = -1;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean needsAllocArrays() {
        return this.table == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V put(@NullableDecl K k, @NullableDecl V v) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int d2 = z.d(k);
        int hashTableMask = hashTableMask() & d2;
        int i = this.size;
        int[] iArr = this.table;
        int i2 = iArr[hashTableMask];
        if (i2 == -1) {
            iArr[hashTableMask] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (getHash(j) != d2 || !rk1.a(k, objArr[i2])) {
                    int next = getNext(j);
                    if (next == -1) {
                        jArr[i2] = swapNext(j, i);
                        break;
                    }
                    i2 = next;
                } else {
                    V v2 = (V) objArr2[i2];
                    objArr2[i2] = v;
                    accessEntry(i2);
                    return v2;
                }
            }
        }
        if (i != Integer.MAX_VALUE) {
            int i3 = i + 1;
            resizeMeMaybe(i3);
            insertEntry(i, k, v, d2);
            this.size = i3;
            int length = this.table.length;
            if (z.b(i, length, 1.0d)) {
                resizeTable(length * 2);
            }
            this.modCount++;
            return null;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        if (needsAllocArrays()) {
            return null;
        }
        return remove(obj, z.d(obj));
    }

    /* access modifiers changed from: package-private */
    public void resizeEntries(int i) {
        this.keys = Arrays.copyOf(this.keys, i);
        this.values = Arrays.copyOf(this.values, i);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.entries = copyOf;
    }

    public int size() {
        return this.size;
    }

    public void trimToSize() {
        if (!needsAllocArrays()) {
            int i = this.size;
            if (i < this.entries.length) {
                resizeEntries(i);
            }
            int a2 = z.a(i, 1.0d);
            if (a2 < this.table.length) {
                resizeTable(a2);
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> valuesIterator() {
        return new c();
    }

    CompactHashMap(int i) {
        init(i);
    }

    @NullableDecl
    private V remove(@NullableDecl Object obj, int i) {
        int hashTableMask = hashTableMask() & i;
        int i2 = this.table[hashTableMask];
        if (i2 == -1) {
            return null;
        }
        int i3 = -1;
        while (true) {
            if (getHash(this.entries[i2]) != i || !rk1.a(obj, this.keys[i2])) {
                int next = getNext(this.entries[i2]);
                if (next == -1) {
                    return null;
                }
                i3 = i2;
                i2 = next;
            } else {
                V v = (V) this.values[i2];
                if (i3 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i2]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i3] = swapNext(jArr[i3], getNext(jArr[i2]));
                }
                moveLastEntry(i2);
                this.size--;
                this.modCount++;
                return v;
            }
        }
    }

    /* compiled from: Taobao */
    private abstract class e<T> implements Iterator<T> {
        int a;
        int b;
        int c;

        private e() {
            this.a = CompactHashMap.this.modCount;
            this.b = CompactHashMap.this.firstEntryIndex();
            this.c = -1;
        }

        private void a() {
            if (CompactHashMap.this.modCount != this.a) {
                throw new ConcurrentModificationException();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract T b(int i);

        public boolean hasNext() {
            return this.b >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (hasNext()) {
                int i = this.b;
                this.c = i;
                T b2 = b(i);
                this.b = CompactHashMap.this.getSuccessor(this.b);
                return b2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            a();
            k.e(this.c >= 0);
            this.a++;
            CompactHashMap.this.removeEntry(this.c);
            this.b = CompactHashMap.this.adjustAfterRemove(this.b, this.c);
            this.c = -1;
        }

        /* synthetic */ e(CompactHashMap compactHashMap, a aVar) {
            this();
        }
    }
}
