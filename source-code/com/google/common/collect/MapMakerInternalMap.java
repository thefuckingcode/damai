package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.InternalEntry;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* compiled from: Taobao */
public class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final WeakValueReference<Object, Object, d> UNSET_WEAK_VALUE_REFERENCE = new a();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient InternalEntryHelper<K, V, E, S> entryHelper;
    @MonotonicNonNullDecl
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;
    @MonotonicNonNullDecl
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;
    @MonotonicNonNullDecl
    transient Collection<V> values;

    /* compiled from: Taobao */
    static final class CleanupMapTask implements Runnable {
        final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> mapReference;

        public CleanupMapTask(MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap) {
            this.mapReference = new WeakReference<>(mapMakerInternalMap);
        }

        public void run() {
            MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap = this.mapReference.get();
            if (mapMakerInternalMap != null) {
                for (Segment<K, V, E, S> segment : mapMakerInternalMap.segments) {
                    segment.runCleanup();
                }
                return;
            }
            throw new CancellationException();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
        E copy(S s, E e, @NullableDecl E e2);

        Strength keyStrength();

        E newEntry(S s, K k, int i, @NullableDecl E e);

        S newSegment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2);

        void setValue(S s, E e, V v);

        Strength valueStrength();
    }

    /* compiled from: Taobao */
    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).i();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum Strength {
        STRONG {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        WEAK {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        /* access modifiers changed from: package-private */
        public abstract Equivalence<Object> defaultEquivalence();

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, k<K>, StrongKeyDummyValueSegment<K>> {
        StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, k<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public k<K> castForTesting(InternalEntry<K, MapMaker.Dummy, ?> internalEntry) {
            return (k) internalEntry;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> {
        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public l<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (l) internalEntry;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues = new ReferenceQueue<>();

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, m<K, V>> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry) {
            return castForTesting((InternalEntry) internalEntry).getValueReference();
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<V>, java.lang.ref.ReferenceQueue<T> */
        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<V>) this.queueForValues);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, m<K, V>> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, V v) {
            return new s(this.queueForValues, v, castForTesting((InternalEntry) internalEntry));
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            m<K, V> castForTesting = castForTesting((InternalEntry) internalEntry);
            WeakValueReference weakValueReference2 = ((m) castForTesting).d;
            ((m) castForTesting).d = weakValueReference;
            weakValueReference2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public m<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (m) internalEntry;
        }
    }

    /* compiled from: Taobao */
    interface StrongValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, p<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys = new ReferenceQueue<>();

        WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, p<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<K>, java.lang.ref.ReferenceQueue<T> */
        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public p<K> castForTesting(InternalEntry<K, MapMaker.Dummy, ?> internalEntry) {
            return (p) internalEntry;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys = new ReferenceQueue<>();

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<K>, java.lang.ref.ReferenceQueue<T> */
        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public q<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (q) internalEntry;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys = new ReferenceQueue<>();
        private final ReferenceQueue<V> queueForValues = new ReferenceQueue<>();

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, r<K, V>> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry) {
            return castForTesting((InternalEntry) internalEntry).getValueReference();
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<K>, java.lang.ref.ReferenceQueue<T> */
        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakValueReference<K, V, r<K, V>> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, V v) {
            return new s(this.queueForValues, v, castForTesting((InternalEntry) internalEntry));
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            r<K, V> castForTesting = castForTesting((InternalEntry) internalEntry);
            WeakValueReference weakValueReference2 = ((r) castForTesting).c;
            ((r) castForTesting).c = weakValueReference;
            weakValueReference2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public r<K, V> castForTesting(InternalEntry<K, V, ?> internalEntry) {
            return (r) internalEntry;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
        void clearValue();

        WeakValueReference<K, V, E> getValueReference();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
        void clear();

        WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> referenceQueue, E e);

        @NullableDecl
        V get();

        E getEntry();
    }

    /* compiled from: Taobao */
    static class a implements WeakValueReference<Object, Object, d> {
        a() {
        }

        /* renamed from: a */
        public WeakValueReference<Object, Object, d> copyFor(ReferenceQueue<Object> referenceQueue, d dVar) {
            return this;
        }

        /* renamed from: b */
        public d getEntry() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public Object get() {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class b<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {
        final K a;
        final int b;
        @NullableDecl
        final E c;

        b(K k, int i, @NullableDecl E e) {
            this.a = k;
            this.b = i;
            this.c = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return this.a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E getNext() {
            return this.c;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class c<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {
        final int a;
        @NullableDecl
        final E b;

        c(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl E e) {
            super(k, referenceQueue);
            this.a = i;
            this.b = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            return this.a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public K getKey() {
            return (K) get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public E getNext() {
            return this.b;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class d implements InternalEntry<Object, Object, d> {
        private d() {
            throw new AssertionError();
        }

        /* renamed from: a */
        public d getNext() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* compiled from: Taobao */
    final class e extends MapMakerInternalMap<K, V, E, S>.g {
        e(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        /* renamed from: f */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* compiled from: Taobao */
    final class f extends j<Map.Entry<K, V>> {
        f() {
            super(null);
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            if ((obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.valueEquivalence().equivalent(entry.getValue(), obj2)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e(MapMakerInternalMap.this);
        }

        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            if ((obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue())) {
                return true;
            }
            return false;
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public abstract class g<T> implements Iterator<T> {
        int a;
        int b = -1;
        @MonotonicNonNullDecl
        Segment<K, V, E, S> c;
        @MonotonicNonNullDecl
        AtomicReferenceArray<E> d;
        @NullableDecl
        E e;
        @NullableDecl
        MapMakerInternalMap<K, V, E, S>.t f;
        @NullableDecl
        MapMakerInternalMap<K, V, E, S>.t g;

        g() {
            this.a = MapMakerInternalMap.this.segments.length - 1;
            a();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f = null;
            if (!d() && !e()) {
                while (true) {
                    int i = this.a;
                    if (i >= 0) {
                        Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.segments;
                        this.a = i - 1;
                        Segment<K, V, E, S> segment = segmentArr[i];
                        this.c = segment;
                        if (segment.count != 0) {
                            AtomicReferenceArray<E> atomicReferenceArray = this.c.table;
                            this.d = atomicReferenceArray;
                            this.b = atomicReferenceArray.length() - 1;
                            if (e()) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(E e2) {
            boolean z;
            try {
                Object key = e2.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(e2);
                if (liveValue != null) {
                    this.f = new t(key, liveValue);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.c.postReadCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public MapMakerInternalMap<K, V, E, S>.t c() {
            MapMakerInternalMap<K, V, E, S>.t tVar = this.f;
            if (tVar != null) {
                this.g = tVar;
                a();
                return this.g;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            E e2 = this.e;
            if (e2 == null) {
                return false;
            }
            while (true) {
                this.e = (E) e2.getNext();
                E e3 = this.e;
                if (e3 == null) {
                    return false;
                }
                if (b(e3)) {
                    return true;
                }
                e2 = this.e;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            while (true) {
                int i = this.b;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.d;
                this.b = i - 1;
                E e2 = atomicReferenceArray.get(i);
                this.e = e2;
                if (e2 != null && (b(e2) || d())) {
                    return true;
                }
            }
        }

        public boolean hasNext() {
            return this.f != null;
        }

        public void remove() {
            k.e(this.g != null);
            MapMakerInternalMap.this.remove(this.g.getKey());
            this.g = null;
        }
    }

    /* compiled from: Taobao */
    final class h extends MapMakerInternalMap<K, V, E, S>.g {
        h(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) c().getKey();
        }
    }

    /* compiled from: Taobao */
    final class i extends j<K> {
        i() {
            super(null);
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new h(MapMakerInternalMap.this);
        }

        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* compiled from: Taobao */
    private static abstract class j<E> extends AbstractSet<E> {
        private j() {
        }

        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        /* synthetic */ j(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class k<K> extends b<K, MapMaker.Dummy, k<K>> implements StrongValueEntry<K, MapMaker.Dummy, k<K>> {

        /* compiled from: Taobao */
        static final class a<K> implements InternalEntryHelper<K, MapMaker.Dummy, k<K>, StrongKeyDummyValueSegment<K>> {
            private static final a<?> a = new a<>();

            a() {
            }

            static <K> a<K> b() {
                return (a<K>) a;
            }

            /* renamed from: a */
            public k<K> copy(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, k<K> kVar, @NullableDecl k<K> kVar2) {
                return kVar.a(kVar2);
            }

            /* renamed from: c */
            public k<K> newEntry(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k, int i, @NullableDecl k<K> kVar) {
                return new k<>(k, i, kVar);
            }

            /* renamed from: d */
            public StrongKeyDummyValueSegment<K> newSegment(MapMakerInternalMap<K, MapMaker.Dummy, k<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyDummyValueSegment<>(mapMakerInternalMap, i, i2);
            }

            /* renamed from: e */
            public void setValue(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, k<K> kVar, MapMaker.Dummy dummy) {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }
        }

        k(K k, int i, @NullableDecl k<K> kVar) {
            super(k, i, kVar);
        }

        /* access modifiers changed from: package-private */
        public k<K> a(k<K> kVar) {
            return new k<>(this.a, this.b, kVar);
        }

        /* renamed from: b */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class l<K, V> extends b<K, V, l<K, V>> implements StrongValueEntry<K, V, l<K, V>> {
        @NullableDecl
        private volatile V d = null;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public static final class a<K, V> implements InternalEntryHelper<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> {
            private static final a<?, ?> a = new a<>();

            a() {
            }

            static <K, V> a<K, V> b() {
                return (a<K, V>) a;
            }

            /* renamed from: a */
            public l<K, V> copy(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, l<K, V> lVar, @NullableDecl l<K, V> lVar2) {
                return lVar.a(lVar2);
            }

            /* renamed from: c */
            public l<K, V> newEntry(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k, int i, @NullableDecl l<K, V> lVar) {
                return new l<>(k, i, lVar);
            }

            /* renamed from: d */
            public StrongKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, l<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i, i2);
            }

            /* renamed from: e */
            public void setValue(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, l<K, V> lVar, V v) {
                lVar.b(v);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }
        }

        l(K k, int i, @NullableDecl l<K, V> lVar) {
            super(k, i, lVar);
        }

        /* access modifiers changed from: package-private */
        public l<K, V> a(l<K, V> lVar) {
            l<K, V> lVar2 = new l<>(this.a, this.b, lVar);
            lVar2.d = this.d;
            return lVar2;
        }

        /* access modifiers changed from: package-private */
        public void b(V v) {
            this.d = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @NullableDecl
        public V getValue() {
            return this.d;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class m<K, V> extends b<K, V, m<K, V>> implements WeakValueEntry<K, V, m<K, V>> {
        private volatile WeakValueReference<K, V, m<K, V>> d = MapMakerInternalMap.unsetWeakValueReference();

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public static final class a<K, V> implements InternalEntryHelper<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> {
            private static final a<?, ?> a = new a<>();

            a() {
            }

            static <K, V> a<K, V> b() {
                return (a<K, V>) a;
            }

            /* renamed from: a */
            public m<K, V> copy(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, m<K, V> mVar, @NullableDecl m<K, V> mVar2) {
                if (Segment.isCollected(mVar)) {
                    return null;
                }
                return mVar.c(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, mVar2);
            }

            /* renamed from: c */
            public m<K, V> newEntry(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k, int i, @NullableDecl m<K, V> mVar) {
                return new m<>(k, i, mVar);
            }

            /* renamed from: d */
            public StrongKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, m<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i, i2);
            }

            /* renamed from: e */
            public void setValue(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, m<K, V> mVar, V v) {
                mVar.d(v, ((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.WEAK;
            }
        }

        m(K k, int i, @NullableDecl m<K, V> mVar) {
            super(k, i, mVar);
        }

        /* access modifiers changed from: package-private */
        public m<K, V> c(ReferenceQueue<V> referenceQueue, m<K, V> mVar) {
            m<K, V> mVar2 = new m<>(this.a, this.b, mVar);
            mVar2.d = this.d.copyFor(referenceQueue, mVar2);
            return mVar2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public void clearValue() {
            this.d.clear();
        }

        /* access modifiers changed from: package-private */
        public void d(V v, ReferenceQueue<V> referenceQueue) {
            WeakValueReference<K, V, m<K, V>> weakValueReference = this.d;
            this.d = new s(referenceQueue, v, this);
            weakValueReference.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.d.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public WeakValueReference<K, V, m<K, V>> getValueReference() {
            return this.d;
        }
    }

    /* compiled from: Taobao */
    final class n extends MapMakerInternalMap<K, V, E, S>.g {
        n(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) c().getValue();
        }
    }

    /* compiled from: Taobao */
    final class o extends AbstractCollection<V> {
        o() {
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new n(MapMakerInternalMap.this);
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }

        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class p<K> extends c<K, MapMaker.Dummy, p<K>> implements StrongValueEntry<K, MapMaker.Dummy, p<K>> {

        /* compiled from: Taobao */
        static final class a<K> implements InternalEntryHelper<K, MapMaker.Dummy, p<K>, WeakKeyDummyValueSegment<K>> {
            private static final a<?> a = new a<>();

            a() {
            }

            static <K> a<K> b() {
                return (a<K>) a;
            }

            /* renamed from: a */
            public p<K> copy(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, p<K> pVar, @NullableDecl p<K> pVar2) {
                if (pVar.getKey() == null) {
                    return null;
                }
                return pVar.a(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, pVar2);
            }

            /* renamed from: c */
            public p<K> newEntry(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k, int i, @NullableDecl p<K> pVar) {
                return new p<>(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, k, i, pVar);
            }

            /* renamed from: d */
            public WeakKeyDummyValueSegment<K> newSegment(MapMakerInternalMap<K, MapMaker.Dummy, p<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyDummyValueSegment<>(mapMakerInternalMap, i, i2);
            }

            /* renamed from: e */
            public void setValue(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, p<K> pVar, MapMaker.Dummy dummy) {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }
        }

        p(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl p<K> pVar) {
            super(referenceQueue, k, i, pVar);
        }

        /* access modifiers changed from: package-private */
        public p<K> a(ReferenceQueue<K> referenceQueue, p<K> pVar) {
            return new p<>(referenceQueue, getKey(), this.a, pVar);
        }

        /* renamed from: b */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class q<K, V> extends c<K, V, q<K, V>> implements StrongValueEntry<K, V, q<K, V>> {
        @NullableDecl
        private volatile V c = null;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public static final class a<K, V> implements InternalEntryHelper<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> {
            private static final a<?, ?> a = new a<>();

            a() {
            }

            static <K, V> a<K, V> b() {
                return (a<K, V>) a;
            }

            /* renamed from: a */
            public q<K, V> copy(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, q<K, V> qVar, @NullableDecl q<K, V> qVar2) {
                if (qVar.getKey() == null) {
                    return null;
                }
                return qVar.a(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, qVar2);
            }

            /* renamed from: c */
            public q<K, V> newEntry(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k, int i, @NullableDecl q<K, V> qVar) {
                return new q<>(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k, i, qVar);
            }

            /* renamed from: d */
            public WeakKeyStrongValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, q<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i, i2);
            }

            /* renamed from: e */
            public void setValue(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, q<K, V> qVar, V v) {
                qVar.b(v);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.STRONG;
            }
        }

        q(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl q<K, V> qVar) {
            super(referenceQueue, k, i, qVar);
        }

        /* access modifiers changed from: package-private */
        public q<K, V> a(ReferenceQueue<K> referenceQueue, q<K, V> qVar) {
            q<K, V> qVar2 = new q<>(referenceQueue, getKey(), this.a, qVar);
            qVar2.b(this.c);
            return qVar2;
        }

        /* access modifiers changed from: package-private */
        public void b(V v) {
            this.c = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        @NullableDecl
        public V getValue() {
            return this.c;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class r<K, V> extends c<K, V, r<K, V>> implements WeakValueEntry<K, V, r<K, V>> {
        private volatile WeakValueReference<K, V, r<K, V>> c = MapMakerInternalMap.unsetWeakValueReference();

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public static final class a<K, V> implements InternalEntryHelper<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> {
            private static final a<?, ?> a = new a<>();

            a() {
            }

            static <K, V> a<K, V> b() {
                return (a<K, V>) a;
            }

            /* renamed from: a */
            public r<K, V> copy(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, r<K, V> rVar, @NullableDecl r<K, V> rVar2) {
                if (rVar.getKey() != null && !Segment.isCollected(rVar)) {
                    return rVar.c(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, rVar2);
                }
                return null;
            }

            /* renamed from: c */
            public r<K, V> newEntry(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k, int i, @NullableDecl r<K, V> rVar) {
                return new r<>(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k, i, rVar);
            }

            /* renamed from: d */
            public WeakKeyWeakValueSegment<K, V> newSegment(MapMakerInternalMap<K, V, r<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i, i2);
            }

            /* renamed from: e */
            public void setValue(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, r<K, V> rVar, V v) {
                rVar.d(v, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength keyStrength() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength valueStrength() {
                return Strength.WEAK;
            }
        }

        r(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl r<K, V> rVar) {
            super(referenceQueue, k, i, rVar);
        }

        /* access modifiers changed from: package-private */
        public r<K, V> c(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, r<K, V> rVar) {
            r<K, V> rVar2 = new r<>(referenceQueue, getKey(), this.a, rVar);
            rVar2.c = this.c.copyFor(referenceQueue2, rVar2);
            return rVar2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public void clearValue() {
            this.c.clear();
        }

        /* access modifiers changed from: package-private */
        public void d(V v, ReferenceQueue<V> referenceQueue) {
            WeakValueReference<K, V, r<K, V>> weakValueReference = this.c;
            this.c = new s(referenceQueue, v, this);
            weakValueReference.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public V getValue() {
            return this.c.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public WeakValueReference<K, V, r<K, V>> getValueReference() {
            return this.c;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class s<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {
        @Weak
        final E a;

        s(ReferenceQueue<V> referenceQueue, V v, E e) {
            super(v, referenceQueue);
            this.a = e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public WeakValueReference<K, V, E> copyFor(ReferenceQueue<V> referenceQueue, E e) {
            return new s(referenceQueue, get(), e);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public E getEntry() {
            return this.a;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class t extends b<K, V> {
        final K a;
        V b;

        t(K k, V v) {
            this.a = k;
            this.b = v;
        }

        @Override // com.google.common.collect.b
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!this.a.equals(entry.getKey()) || !this.b.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry, com.google.common.collect.b
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry, com.google.common.collect.b
        public V getValue() {
            return this.b;
        }

        @Override // com.google.common.collect.b
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map.Entry, com.google.common.collect.b
        public V setValue(V v) {
            V v2 = (V) MapMakerInternalMap.this.put(this.a, v);
            this.b = v;
            return v2;
        }
    }

    private MapMakerInternalMap(MapMaker mapMaker, InternalEntryHelper<K, V, E, S> internalEntryHelper) {
        this.concurrencyLevel = Math.min(mapMaker.b(), 65536);
        this.keyEquivalence = mapMaker.d();
        this.entryHelper = internalEntryHelper;
        int min = Math.min(mapMaker.c(), 1073741824);
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.concurrencyLevel) {
            i5++;
            i4 <<= 1;
        }
        this.segmentShift = 32 - i5;
        this.segmentMask = i4 - 1;
        this.segments = newSegmentArray(i4);
        int i6 = min / i4;
        while (i3 < (i4 * i6 < min ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i2 < segmentArr.length) {
                segmentArr[i2] = createSegment(i3, -1);
                i2++;
            } else {
                return;
            }
        }
    }

    static <K, V> MapMakerInternalMap<K, V, ? extends InternalEntry<K, V, ?>, ?> create(MapMaker mapMaker) {
        Strength e2 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e2 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, l.a.b());
        }
        if (mapMaker.e() == strength && mapMaker.f() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, m.a.b());
        }
        Strength e3 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e3 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, q.a.b());
        }
        if (mapMaker.e() == strength2 && mapMaker.f() == strength2) {
            return new MapMakerInternalMap<>(mapMaker, r.a.b());
        }
        throw new AssertionError();
    }

    static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends InternalEntry<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker mapMaker) {
        Strength e2 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e2 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, k.a.b());
        }
        Strength e3 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e3 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, p.a.b());
        }
        if (mapMaker.f() == strength2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    static int rehash(int i2) {
        int i3 = i2 + ((i2 << 15) ^ -12931);
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    /* access modifiers changed from: private */
    public static <E> ArrayList<E> toArrayList(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V, E extends InternalEntry<K, V, E>> WeakValueReference<K, V, E> unsetWeakValueReference() {
        return (WeakValueReference<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    public void clear() {
        for (Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    public boolean containsKey(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>>[] */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.google.common.collect.MapMakerInternalMap$StrongKeyDummyValueSegment */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsValue(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            for (StrongKeyDummyValueSegment strongKeyDummyValueSegment : segmentArr) {
                int i3 = strongKeyDummyValueSegment.count;
                AtomicReferenceArray<E> atomicReferenceArray = strongKeyDummyValueSegment.table;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    for (E e2 = atomicReferenceArray.get(i4); e2 != null; e2 = e2.getNext()) {
                        Object liveValue = strongKeyDummyValueSegment.getLiveValue(e2);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j3 += (long) strongKeyDummyValueSegment.modCount;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public E copyEntry(E e2, E e3) {
        return segmentFor(e2.getHash()).copyEntry(e2, e3);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>, com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
    /* access modifiers changed from: package-private */
    public Segment<K, V, E, S> createSegment(int i2, int i3) {
        return (S) this.entryHelper.newSegment(this, i2, i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.entrySet = fVar;
        return fVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    /* access modifiers changed from: package-private */
    public E getEntry(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    /* access modifiers changed from: package-private */
    public V getLiveValue(E e2) {
        if (e2.getKey() == null) {
            return null;
        }
        return (V) e2.getValue();
    }

    /* access modifiers changed from: package-private */
    public int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j2 = 0;
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].count != 0) {
                return false;
            }
            j2 += (long) segmentArr[i2].modCount;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < segmentArr.length; i3++) {
            if (segmentArr[i3].count != 0) {
                return false;
            }
            j2 -= (long) segmentArr[i3].modCount;
        }
        if (j2 != 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isLiveForTesting(InternalEntry<K, V, ?> internalEntry) {
        return segmentFor(internalEntry.getHash()).getLiveValueForTesting(internalEntry) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        i iVar = new i();
        this.keySet = iVar;
        return iVar;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Strength keyStrength() {
        return this.entryHelper.keyStrength();
    }

    /* access modifiers changed from: package-private */
    public final Segment<K, V, E, S>[] newSegmentArray(int i2) {
        return new Segment[i2];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K k2, V v) {
        ds1.p(k2);
        ds1.p(v);
        int hash = hash(k2);
        return segmentFor(hash).put(k2, hash, v, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k2, V v) {
        ds1.p(k2);
        ds1.p(v);
        int hash = hash(k2);
        return segmentFor(hash).put(k2, hash, v, true);
    }

    /* access modifiers changed from: package-private */
    public void reclaimKey(E e2) {
        int hash = e2.getHash();
        segmentFor(hash).reclaimKey(e2, hash);
    }

    /* access modifiers changed from: package-private */
    public void reclaimValue(WeakValueReference<K, V, E> weakValueReference) {
        E entry = weakValueReference.getEntry();
        int hash = entry.getHash();
        segmentFor(hash).reclaimValue((K) entry.getKey(), hash, weakValueReference);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k2, @NullableDecl V v, V v2) {
        ds1.p(k2);
        ds1.p(v2);
        if (v == null) {
            return false;
        }
        int hash = hash(k2);
        return segmentFor(hash).replace(k2, hash, v, v2);
    }

    /* access modifiers changed from: package-private */
    public Segment<K, V, E, S> segmentFor(int i2) {
        return this.segments[(i2 >>> this.segmentShift) & this.segmentMask];
    }

    public int size() {
        Segment<K, V, E, S>[] segmentArr;
        long j2 = 0;
        for (Segment<K, V, E, S> segment : this.segments) {
            j2 += (long) segment.count;
        }
        return Ints.j(j2);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Equivalence<Object> valueEquivalence() {
        return this.entryHelper.valueStrength().defaultEquivalence();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Strength valueStrength() {
        return this.entryHelper.valueStrength();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        o oVar = new o();
        this.values = oVar;
        return oVar;
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializationProxy(this.entryHelper.keyStrength(), this.entryHelper.valueStrength(), this.keyEquivalence, this.entryHelper.valueStrength().defaultEquivalence(), this.concurrencyLevel, this);
    }

    /* compiled from: Taobao */
    static abstract class AbstractSerializationProxy<K, V> extends p<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i;
            this.delegate = concurrentMap;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.concurrent.ConcurrentMap<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject != null) {
                    this.delegate.put(readObject, objectInputStream.readObject());
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().g(objectInputStream.readInt()).j(this.keyStrength).k(this.valueStrength).h(this.keyEquivalence).a(this.concurrencyLevel);
        }

        /* access modifiers changed from: package-private */
        public void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.p, com.google.common.collect.p, com.google.common.collect.p, com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }
    }

    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k2, V v) {
        ds1.p(k2);
        ds1.p(v);
        int hash = hash(k2);
        return segmentFor(hash).replace(k2, hash, v);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;
        @Weak
        final MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<E> table;
        int threshold;

        Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i2;
            initTable(newEntryArray(i));
        }

        static <K, V, E extends InternalEntry<K, V, E>> boolean isCollected(E e) {
            return e.getValue() == null;
        }

        /* access modifiers changed from: package-private */
        public abstract E castForTesting(InternalEntry<K, V, ?> internalEntry);

        /* access modifiers changed from: package-private */
        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public boolean clearValueForTesting(K k, int i, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((WeakValueEntry) internalEntry).getValueReference() == weakValueReference) {
                            atomicReferenceArray.set(length, removeFromChain(e, internalEntry));
                            return true;
                        } else {
                            unlock();
                            return false;
                        }
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean containsKey(Object obj, int i) {
            try {
                boolean z = false;
                if (this.count != 0) {
                    E liveEntry = getLiveEntry(obj, i);
                    if (!(liveEntry == null || liveEntry.getValue() == null)) {
                        z = true;
                    }
                    return z;
                }
                postReadCleanup();
                return false;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX INFO: finally extract failed */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (E e = atomicReferenceArray.get(i); e != null; e = e.getNext()) {
                            Object liveValue = getLiveValue(e);
                            if (liveValue != null) {
                                if (this.map.valueEquivalence().equivalent(obj, liveValue)) {
                                    postReadCleanup();
                                    return true;
                                }
                            }
                        }
                    }
                }
                postReadCleanup();
                return false;
            } catch (Throwable th) {
                postReadCleanup();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public E copyEntry(E e, E e2) {
            return this.map.entryHelper.copy(self(), e, e2);
        }

        /* access modifiers changed from: package-private */
        public E copyForTesting(InternalEntry<K, V, ?> internalEntry, @NullableDecl InternalEntry<K, V, ?> internalEntry2) {
            return this.map.entryHelper.copy(self(), castForTesting(internalEntry), castForTesting(internalEntry2));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimKey((InternalEntry) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimValue((WeakValueReference) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i = this.count;
                AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray<E>) newEntryArray(length << 1);
                this.threshold = (atomicReferenceArray2.length() * 3) / 4;
                int length2 = atomicReferenceArray2.length() - 1;
                for (int i2 = 0; i2 < length; i2++) {
                    E e = atomicReferenceArray.get(i2);
                    if (e != null) {
                        InternalEntry next = e.getNext();
                        int hash = e.getHash() & length2;
                        if (next == null) {
                            atomicReferenceArray2.set(hash, e);
                        } else {
                            InternalEntry internalEntry = e;
                            while (next != null) {
                                int hash2 = next.getHash() & length2;
                                if (hash2 != hash) {
                                    internalEntry = next;
                                    hash = hash2;
                                }
                                next = next.getNext();
                            }
                            atomicReferenceArray2.set(hash, internalEntry);
                            while (e != internalEntry) {
                                int hash3 = e.getHash() & length2;
                                InternalEntry copyEntry = copyEntry(e, (InternalEntry) atomicReferenceArray2.get(hash3));
                                if (copyEntry != null) {
                                    atomicReferenceArray2.set(hash3, copyEntry);
                                } else {
                                    i--;
                                }
                                e = e.getNext();
                            }
                        }
                    }
                }
                this.table = atomicReferenceArray2;
                this.count = i;
            }
        }

        /* access modifiers changed from: package-private */
        public V get(Object obj, int i) {
            try {
                E liveEntry = getLiveEntry(obj, i);
                if (liveEntry == null) {
                    return null;
                }
                V v = (V) liveEntry.getValue();
                if (v == null) {
                    tryDrainReferenceQueues();
                }
                postReadCleanup();
                return v;
            } finally {
                postReadCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public E getEntry(Object obj, int i) {
            if (this.count == 0) {
                return null;
            }
            for (E first = getFirst(i); first != null; first = (E) first.getNext()) {
                if (first.getHash() == i) {
                    Object key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public E getFirst(int i) {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        /* access modifiers changed from: package-private */
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public E getLiveEntry(Object obj, int i) {
            return getEntry(obj, i);
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public V getLiveValue(E e) {
            if (e.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = (V) e.getValue();
            if (v != null) {
                return v;
            }
            tryDrainReferenceQueues();
            return null;
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public V getLiveValueForTesting(InternalEntry<K, V, ?> internalEntry) {
            return getLiveValue(castForTesting(internalEntry));
        }

        /* access modifiers changed from: package-private */
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public WeakValueReference<K, V, E> getWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == this.maxSegmentSize) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        /* access modifiers changed from: package-private */
        public void maybeClearReferenceQueues() {
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void maybeDrainReferenceQueues() {
        }

        /* access modifiers changed from: package-private */
        public AtomicReferenceArray<E> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        /* access modifiers changed from: package-private */
        public E newEntryForTesting(K k, int i, @NullableDecl InternalEntry<K, V, ?> internalEntry) {
            return this.map.entryHelper.newEntry(self(), k, i, castForTesting(internalEntry));
        }

        /* access modifiers changed from: package-private */
        public WeakValueReference<K, V, E> newWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, V v) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public V put(K k, int i, V v, boolean z) {
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) internalEntry.getValue();
                        if (v2 == null) {
                            this.modCount++;
                            setValue(internalEntry, v);
                            this.count = this.count;
                            return null;
                        } else if (z) {
                            unlock();
                            return v2;
                        } else {
                            this.modCount++;
                            setValue(internalEntry, v);
                            unlock();
                            return v2;
                        }
                    }
                }
                this.modCount++;
                E newEntry = this.map.entryHelper.newEntry(self(), k, i, e);
                setValue(newEntry, v);
                atomicReferenceArray.set(length, newEntry);
                this.count = i2;
                unlock();
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public boolean reclaimKey(E e, int i) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                E e2 = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e2; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    if (internalEntry == e) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeFromChain(e2, internalEntry));
                        this.count--;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public boolean reclaimValue(K k, int i, WeakValueReference<K, V, E> weakValueReference) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((WeakValueEntry) internalEntry).getValueReference() == weakValueReference) {
                            this.modCount++;
                            atomicReferenceArray.set(length, removeFromChain(e, internalEntry));
                            this.count--;
                            return true;
                        } else {
                            unlock();
                            return false;
                        }
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public V remove(Object obj, int i) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v = (V) internalEntry.getValue();
                        if (v == null) {
                            if (!isCollected(internalEntry)) {
                                unlock();
                                return null;
                            }
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, removeFromChain(e, internalEntry));
                        this.count--;
                        return v;
                    }
                }
                unlock();
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public boolean removeEntryForTesting(E e) {
            int hash = e.getHash();
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = hash & (atomicReferenceArray.length() - 1);
            E e2 = atomicReferenceArray.get(length);
            for (InternalEntry internalEntry = e2; internalEntry != null; internalEntry = internalEntry.getNext()) {
                if (internalEntry == e) {
                    this.modCount++;
                    atomicReferenceArray.set(length, removeFromChain(e2, internalEntry));
                    this.count--;
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public E removeFromChain(E e, E e2) {
            int i = this.count;
            E e3 = (E) e2.getNext();
            while (e != e2) {
                E copyEntry = copyEntry(e, e3);
                if (copyEntry != null) {
                    e3 = copyEntry;
                } else {
                    i--;
                }
                e = (E) e.getNext();
            }
            this.count = i;
            return e3;
        }

        /* access modifiers changed from: package-private */
        public E removeFromChainForTesting(InternalEntry<K, V, ?> internalEntry, InternalEntry<K, V, ?> internalEntry2) {
            return removeFromChain(castForTesting(internalEntry), castForTesting(internalEntry2));
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public boolean removeTableEntryForTesting(InternalEntry<K, V, ?> internalEntry) {
            return removeEntryForTesting(castForTesting(internalEntry));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        Object value = internalEntry.getValue();
                        if (value == null) {
                            if (isCollected(internalEntry)) {
                                this.modCount++;
                                atomicReferenceArray.set(length, removeFromChain(e, internalEntry));
                                this.count--;
                            }
                            return false;
                        } else if (this.map.valueEquivalence().equivalent(v, value)) {
                            this.modCount++;
                            setValue(internalEntry, v2);
                            unlock();
                            return true;
                        } else {
                            unlock();
                            return false;
                        }
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public void runCleanup() {
            runLockedCleanup();
        }

        /* access modifiers changed from: package-private */
        public void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public abstract S self();

        /* access modifiers changed from: package-private */
        public void setTableEntryForTesting(int i, InternalEntry<K, V, ?> internalEntry) {
            this.table.set(i, castForTesting(internalEntry));
        }

        /* access modifiers changed from: package-private */
        public void setValue(E e, V v) {
            this.map.entryHelper.setValue(self(), e, v);
        }

        /* access modifiers changed from: package-private */
        public void setValueForTesting(InternalEntry<K, V, ?> internalEntry, V v) {
            this.map.entryHelper.setValue(self(), castForTesting(internalEntry), v);
        }

        /* access modifiers changed from: package-private */
        public void setWeakValueReferenceForTesting(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public boolean remove(Object obj, int i, Object obj2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                InternalEntry internalEntry = e;
                while (true) {
                    boolean z = false;
                    if (internalEntry != null) {
                        Object key = internalEntry.getKey();
                        if (internalEntry.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(obj, key)) {
                            internalEntry = internalEntry.getNext();
                        } else {
                            if (this.map.valueEquivalence().equivalent(obj2, internalEntry.getValue())) {
                                z = true;
                            } else if (!isCollected(internalEntry)) {
                                unlock();
                                return false;
                            }
                            this.modCount++;
                            atomicReferenceArray.set(length, removeFromChain(e, internalEntry));
                            this.count--;
                            return z;
                        }
                    } else {
                        unlock();
                        return false;
                    }
                }
            } finally {
                unlock();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public V replace(K k, int i, V v) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (InternalEntry internalEntry = e; internalEntry != null; internalEntry = internalEntry.getNext()) {
                    Object key = internalEntry.getKey();
                    if (internalEntry.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) internalEntry.getValue();
                        if (v2 == null) {
                            if (isCollected(internalEntry)) {
                                this.modCount++;
                                atomicReferenceArray.set(length, removeFromChain(e, internalEntry));
                                this.count--;
                            }
                            return null;
                        }
                        this.modCount++;
                        setValue(internalEntry, v);
                        unlock();
                        return v2;
                    }
                }
                unlock();
                return null;
            } finally {
                unlock();
            }
        }
    }
}
