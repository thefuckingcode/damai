package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.e2;
import tb.ke;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final Logger w = Logger.getLogger(LocalCache.class.getName());
    static final ValueReference<Object, Object> x = new a();
    static final Queue<?> y = new b();
    final int a;
    final int b;
    final Segment<K, V>[] c;
    final int d;
    final Equivalence<Object> e;
    final Equivalence<Object> f;
    final Strength g;
    final Strength h;
    final long i;
    final Weigher<K, V> j;
    final long k;
    final long l;
    final long m;
    final Queue<RemovalNotification<K, V>> n;
    final RemovalListener<K, V> o;
    final com.google.common.base.j p;
    final EntryFactory q;
    final AbstractCache$StatsCounter r;
    @NullableDecl
    final CacheLoader<? super K, V> s;
    @MonotonicNonNullDecl
    Set<K> t;
    @MonotonicNonNullDecl
    Collection<V> u;
    @MonotonicNonNullDecl
    Set<Map.Entry<K, V>> v;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum EntryFactory {
        STRONG {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new o(obj, i, referenceEntry);
            }
        },
        STRONG_ACCESS {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> copyEntry(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, ReferenceEntry<Object, Object> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new m(obj, i, referenceEntry);
            }
        },
        STRONG_WRITE {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> copyEntry(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, ReferenceEntry<Object, Object> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new q(obj, i, referenceEntry);
            }
        },
        STRONG_ACCESS_WRITE {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> copyEntry(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, ReferenceEntry<Object, Object> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new n(obj, i, referenceEntry);
            }
        },
        WEAK {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new v(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        },
        WEAK_ACCESS {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> copyEntry(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, ReferenceEntry<Object, Object> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new t(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        },
        WEAK_WRITE {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> copyEntry(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, ReferenceEntry<Object, Object> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new x(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        },
        WEAK_ACCESS_WRITE {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> copyEntry(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, ReferenceEntry<Object, Object> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> ReferenceEntry<Object, Object> newEntry(Segment<Object, Object> segment, Object obj, int i, @NullableDecl ReferenceEntry<Object, Object> referenceEntry) {
                return new u(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        };
        
        static final int ACCESS_MASK = 1;
        static final int WEAK_MASK = 4;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories;

        static {
            AnonymousClass1 r0;
            AnonymousClass2 r1;
            AnonymousClass3 r3;
            AnonymousClass4 r5;
            AnonymousClass5 r7;
            AnonymousClass6 r9;
            AnonymousClass7 r11;
            AnonymousClass8 r13;
            factories = new EntryFactory[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            int i = 0;
            int i2 = (strength == Strength.WEAK ? 4 : 0) | (z ? 1 : 0);
            if (z2) {
                i = 2;
            }
            return factories[i2 | i];
        }

        /* access modifiers changed from: package-private */
        public <K, V> void copyAccessEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
            LocalCache.c(referenceEntry.getPreviousInAccessQueue(), referenceEntry2);
            LocalCache.c(referenceEntry2, referenceEntry.getNextInAccessQueue());
            LocalCache.x(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        /* access modifiers changed from: package-private */
        public <K, V> void copyWriteEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
            LocalCache.d(referenceEntry.getPreviousInWriteQueue(), referenceEntry2);
            LocalCache.d(referenceEntry2, referenceEntry.getNextInWriteQueue());
            LocalCache.y(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry);

        /* synthetic */ EntryFactory(a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;
        @MonotonicNonNullDecl
        transient LoadingCache<K, V> autoDelegate;

        LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: com.google.common.cache.CacheLoader<? super K, V>, com.google.common.cache.CacheLoader<? super K1 extends K, V1 extends V> */
        /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: com.google.common.cache.LoadingCache<K1 extends K, V1 extends V>, com.google.common.cache.LoadingCache<K, V> */
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = (LoadingCache<K1, V1>) recreateCacheBuilder().b((CacheLoader<? super K, V>) this.loader);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return this.autoDelegate.apply(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws ExecutionException {
            return this.autoDelegate.get(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            return this.autoDelegate.getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.autoDelegate.refresh(k);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new LocalCache(cacheBuilder, (CacheLoader) ds1.p(cacheLoader)), null);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) throws ExecutionException {
            return this.localCache.p(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.localCache.l(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            try {
                return get(k);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.localCache.F(k);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.cache.LocalCache.LocalManualCache
        public Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        /* compiled from: Taobao */
        class a extends CacheLoader<Object, V> {
            final /* synthetic */ Callable a;

            a(LocalManualCache localManualCache, Callable callable) {
                this.a = callable;
            }

            @Override // com.google.common.cache.CacheLoader
            public V load(Object obj) throws Exception {
                return (V) this.a.call();
            }
        }

        /* synthetic */ LocalManualCache(LocalCache localCache2, a aVar) {
            this(localCache2);
        }

        @Override // com.google.common.cache.Cache
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            this.localCache.b();
        }

        @Override // com.google.common.cache.Cache
        public V get(K k, Callable<? extends V> callable) throws ExecutionException {
            ds1.p(callable);
            return this.localCache.k(k, new a(this, callable));
        }

        @Override // com.google.common.cache.Cache
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.localCache.m(iterable);
        }

        @Override // com.google.common.cache.Cache
        @NullableDecl
        public V getIfPresent(Object obj) {
            return this.localCache.n(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidate(Object obj) {
            ds1.p(obj);
            this.localCache.remove(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll(Iterable<?> iterable) {
            this.localCache.r(iterable);
        }

        @Override // com.google.common.cache.Cache
        public void put(K k, V v) {
            this.localCache.put(k, v);
        }

        @Override // com.google.common.cache.Cache
        public void putAll(Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.localCache.u();
        }

        @Override // com.google.common.cache.Cache
        public ke stats() {
            a aVar = new a();
            aVar.a(this.localCache.r);
            for (Segment<K, V> segment : this.localCache.c) {
                aVar.a(segment.statsCounter);
            }
            return aVar.snapshot();
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.localCache.clear();
        }

        private LocalManualCache(LocalCache<K, V> localCache2) {
            this.localCache = localCache2;
        }
    }

    /* compiled from: Taobao */
    static class ManualSerializationProxy<K, V> extends b<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;
        @MonotonicNonNullDecl
        transient Cache<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final RemovalListener<? super K, ? super V> removalListener;
        @NullableDecl
        final com.google.common.base.j ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final Weigher<K, V> weigher;

        ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(localCache.g, localCache.h, localCache.e, localCache.f, localCache.l, localCache.k, localCache.i, localCache.j, localCache.d, localCache.o, localCache.p, localCache.s);
        }

        /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: com.google.common.cache.Cache<K1 extends K, V1 extends V>, com.google.common.cache.Cache<K, V> */
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = (Cache<K1, V1>) recreateCacheBuilder().a();
        }

        private Object readResolve() {
            return this.delegate;
        }

        /* JADX DEBUG: Type inference failed for r1v5. Raw type applied. Possible types: com.google.common.cache.RemovalListener<? super K, ? super V>, com.google.common.cache.RemovalListener<? super K1 extends K, ? super V1 extends V> */
        /* access modifiers changed from: package-private */
        public CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder cacheBuilder = (CacheBuilder<K1, V1>) CacheBuilder.y().A(this.keyStrength).B(this.valueStrength).v(this.keyEquivalence).D(this.valueEquivalence).e(this.concurrencyLevel).z((RemovalListener<? super K, ? super V>) this.removalListener);
            cacheBuilder.a = false;
            long j = this.expireAfterWriteNanos;
            if (j > 0) {
                cacheBuilder.g(j, TimeUnit.NANOSECONDS);
            }
            long j2 = this.expireAfterAccessNanos;
            if (j2 > 0) {
                cacheBuilder.f(j2, TimeUnit.NANOSECONDS);
            }
            Weigher<K, V> weigher2 = this.weigher;
            if (weigher2 != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilder.E(weigher2);
                long j3 = this.maxWeight;
                if (j3 != -1) {
                    cacheBuilder.x(j3);
                }
            } else {
                long j4 = this.maxWeight;
                if (j4 != -1) {
                    cacheBuilder.w(j4);
                }
            }
            com.google.common.base.j jVar = this.ticker;
            if (jVar != null) {
                cacheBuilder.C(jVar);
            }
            return cacheBuilder;
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, long j3, Weigher<K, V> weigher2, int i, RemovalListener<? super K, ? super V> removalListener2, com.google.common.base.j jVar, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maxWeight = j3;
            this.weigher = weigher2;
            this.concurrencyLevel = i;
            this.removalListener = removalListener2;
            this.ticker = (jVar == com.google.common.base.j.b() || jVar == CacheBuilder.s) ? null : jVar;
            this.loader = cacheLoader;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.cache.b, com.google.common.cache.b, com.google.common.collect.t
        public Cache<K, V> delegate() {
            return this.delegate;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<Object, Object> valueReference) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum Strength {
        STRONG {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> ValueReference<Object, Object> referenceValue(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, Object obj, int i) {
                return i == 1 ? new p(obj) : new z(obj, i);
            }
        },
        SOFT {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> ValueReference<Object, Object> referenceValue(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, Object obj, int i) {
                return i == 1 ? new l(segment.valueReferenceQueue, obj, referenceEntry) : new y(segment.valueReferenceQueue, obj, referenceEntry, i);
            }
        },
        WEAK {
            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> ValueReference<Object, Object> referenceValue(Segment<Object, Object> segment, ReferenceEntry<Object, Object> referenceEntry, Object obj, int i) {
                return i == 1 ? new w(segment.valueReferenceQueue, obj, referenceEntry) : new a0(segment.valueReferenceQueue, obj, referenceEntry, i);
            }
        };

        /* access modifiers changed from: package-private */
        public abstract Equivalence<Object> defaultEquivalence();

        /* access modifiers changed from: package-private */
        public abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i);

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface ValueReference<K, V> {
        ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @NullableDecl V v, ReferenceEntry<K, V> referenceEntry);

        @NullableDecl
        V get();

        @NullableDecl
        ReferenceEntry<K, V> getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();

        void notifyNewValue(@NullableDecl V v);

        V waitForValue() throws ExecutionException;
    }

    /* compiled from: Taobao */
    static class a implements ValueReference<Object, Object> {
        a() {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<Object, Object> copyFor(ReferenceQueue<Object> referenceQueue, @NullableDecl Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<Object, Object> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object waitForValue() {
            return null;
        }
    }

    /* compiled from: Taobao */
    static final class a0<K, V> extends w<K, V> {
        final int b;

        a0(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.b = i;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new a0(referenceQueue, v, referenceEntry, this.b);
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.b;
        }
    }

    /* compiled from: Taobao */
    static class b extends AbstractQueue<Object> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        public int size() {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class b0<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> a = new a(this);

        /* compiled from: Taobao */
        class a extends d<Object, Object> {
            ReferenceEntry<Object, Object> a = this;
            ReferenceEntry<Object, Object> b = this;

            a(b0 b0Var) {
            }

            @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
            public ReferenceEntry<Object, Object> getNextInWriteQueue() {
                return this.a;
            }

            @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
            public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
                return this.b;
            }

            @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
            public long getWriteTime() {
                return AbsPerformance.LONG_NIL;
            }

            @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
            public void setNextInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
                this.a = referenceEntry;
            }

            @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
            public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
                this.b = referenceEntry;
            }

            @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
            public void setWriteTime(long j) {
            }
        }

        /* compiled from: Taobao */
        class b extends e2<ReferenceEntry<K, V>> {
            b(ReferenceEntry referenceEntry) {
                super(referenceEntry);
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
                if (nextInWriteQueue == b0.this.a) {
                    return null;
                }
                return nextInWriteQueue;
            }
        }

        b0() {
        }

        /* renamed from: a */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.d(referenceEntry.getPreviousInWriteQueue(), referenceEntry.getNextInWriteQueue());
            LocalCache.d(this.a.getPreviousInWriteQueue(), referenceEntry);
            LocalCache.d(referenceEntry, this.a);
            return true;
        }

        /* renamed from: b */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInWriteQueue = this.a.getNextInWriteQueue();
            if (nextInWriteQueue == this.a) {
                return null;
            }
            return nextInWriteQueue;
        }

        /* renamed from: c */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInWriteQueue = this.a.getNextInWriteQueue();
            if (nextInWriteQueue == this.a) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        public void clear() {
            ReferenceEntry<K, V> nextInWriteQueue = this.a.getNextInWriteQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.a;
                if (nextInWriteQueue != referenceEntry) {
                    ReferenceEntry<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.y(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                } else {
                    referenceEntry.setNextInWriteQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.a;
                    referenceEntry2.setPreviousInWriteQueue(referenceEntry2);
                    return;
                }
            }
        }

        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.a.getNextInWriteQueue() == this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new b(peek());
        }

        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry<K, V> previousInWriteQueue = referenceEntry.getPreviousInWriteQueue();
            ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
            LocalCache.d(previousInWriteQueue, nextInWriteQueue);
            LocalCache.y(referenceEntry);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInWriteQueue = this.a.getNextInWriteQueue(); nextInWriteQueue != this.a; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }
    }

    /* compiled from: Taobao */
    abstract class c<T> extends AbstractSet<T> {
        @Weak
        final ConcurrentMap<?, ?> a;

        c(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.a = concurrentMap;
        }

        public void clear() {
            this.a.clear();
        }

        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        public int size() {
            return this.a.size();
        }

        public Object[] toArray() {
            return LocalCache.J(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.J(this).toArray(eArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class c0 implements Map.Entry<K, V> {
        final K a;
        V b;

        c0(K k, V v) {
            this.a = k;
            this.b = v;
        }

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

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) LocalCache.this.put(this.a, v);
            this.b = v;
            return v2;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* compiled from: Taobao */
    static abstract class d<K, V> implements ReferenceEntry<K, V> {
        d() {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class e<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> a = new a(this);

        /* compiled from: Taobao */
        class a extends d<Object, Object> {
            ReferenceEntry<Object, Object> a = this;
            ReferenceEntry<Object, Object> b = this;

            a(e eVar) {
            }

            @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
            public long getAccessTime() {
                return AbsPerformance.LONG_NIL;
            }

            @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
            public ReferenceEntry<Object, Object> getNextInAccessQueue() {
                return this.a;
            }

            @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
            public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
                return this.b;
            }

            @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
            public void setAccessTime(long j) {
            }

            @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
            public void setNextInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
                this.a = referenceEntry;
            }

            @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
            public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
                this.b = referenceEntry;
            }
        }

        /* compiled from: Taobao */
        class b extends e2<ReferenceEntry<K, V>> {
            b(ReferenceEntry referenceEntry) {
                super(referenceEntry);
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
                if (nextInAccessQueue == e.this.a) {
                    return null;
                }
                return nextInAccessQueue;
            }
        }

        e() {
        }

        /* renamed from: a */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.c(referenceEntry.getPreviousInAccessQueue(), referenceEntry.getNextInAccessQueue());
            LocalCache.c(this.a.getPreviousInAccessQueue(), referenceEntry);
            LocalCache.c(referenceEntry, this.a);
            return true;
        }

        /* renamed from: b */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInAccessQueue = this.a.getNextInAccessQueue();
            if (nextInAccessQueue == this.a) {
                return null;
            }
            return nextInAccessQueue;
        }

        /* renamed from: c */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInAccessQueue = this.a.getNextInAccessQueue();
            if (nextInAccessQueue == this.a) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        public void clear() {
            ReferenceEntry<K, V> nextInAccessQueue = this.a.getNextInAccessQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.a;
                if (nextInAccessQueue != referenceEntry) {
                    ReferenceEntry<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.x(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                } else {
                    referenceEntry.setNextInAccessQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.a;
                    referenceEntry2.setPreviousInAccessQueue(referenceEntry2);
                    return;
                }
            }
        }

        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.a.getNextInAccessQueue() == this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new b(peek());
        }

        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry<K, V> previousInAccessQueue = referenceEntry.getPreviousInAccessQueue();
            ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
            LocalCache.c(previousInAccessQueue, nextInAccessQueue);
            LocalCache.x(referenceEntry);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInAccessQueue = this.a.getNextInAccessQueue(); nextInAccessQueue != this.a; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }
    }

    /* compiled from: Taobao */
    final class f extends LocalCache<K, V>.h {
        f(LocalCache localCache) {
            super();
        }

        /* renamed from: f */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* compiled from: Taobao */
    final class g extends LocalCache<K, V>.c {
        g(ConcurrentMap<?, ?> concurrentMap) {
            super(LocalCache.this, concurrentMap);
        }

        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            if ((obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.f.equivalent(entry.getValue(), obj2)) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(LocalCache.this);
        }

        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            if ((obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue())) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public abstract class h<T> implements Iterator<T> {
        int a;
        int b = -1;
        @MonotonicNonNullDecl
        Segment<K, V> c;
        @MonotonicNonNullDecl
        AtomicReferenceArray<ReferenceEntry<K, V>> d;
        @NullableDecl
        ReferenceEntry<K, V> e;
        @NullableDecl
        LocalCache<K, V>.c0 f;
        @NullableDecl
        LocalCache<K, V>.c0 g;

        h() {
            this.a = LocalCache.this.c.length - 1;
            a();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f = null;
            if (!d() && !e()) {
                while (true) {
                    int i = this.a;
                    if (i >= 0) {
                        Segment<K, V>[] segmentArr = LocalCache.this.c;
                        this.a = i - 1;
                        Segment<K, V> segment = segmentArr[i];
                        this.c = segment;
                        if (segment.count != 0) {
                            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.c.table;
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
        public boolean b(ReferenceEntry<K, V> referenceEntry) {
            boolean z;
            try {
                long a2 = LocalCache.this.p.a();
                K key = referenceEntry.getKey();
                Object o = LocalCache.this.o(referenceEntry, a2);
                if (o != null) {
                    this.f = new c0(key, o);
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
        public LocalCache<K, V>.c0 c() {
            LocalCache<K, V>.c0 c0Var = this.f;
            if (c0Var != null) {
                this.g = c0Var;
                a();
                return this.g;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            ReferenceEntry<K, V> referenceEntry = this.e;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.e = referenceEntry.getNext();
                ReferenceEntry<K, V> referenceEntry2 = this.e;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (b(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.e;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            while (true) {
                int i = this.b;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.d;
                this.b = i - 1;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i);
                this.e = referenceEntry;
                if (referenceEntry != null && (b(referenceEntry) || d())) {
                    return true;
                }
            }
        }

        public boolean hasNext() {
            return this.f != null;
        }

        public void remove() {
            ds1.w(this.g != null);
            LocalCache.this.remove(this.g.getKey());
            this.g = null;
        }
    }

    /* compiled from: Taobao */
    final class i extends LocalCache<K, V>.h {
        i(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) c().getKey();
        }
    }

    /* compiled from: Taobao */
    final class j extends LocalCache<K, V>.c {
        j(ConcurrentMap<?, ?> concurrentMap) {
            super(LocalCache.this, concurrentMap);
        }

        public boolean contains(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new i(LocalCache.this);
        }

        public boolean remove(Object obj) {
            return this.a.remove(obj) != null;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class k<K, V> implements ValueReference<K, V> {
        volatile ValueReference<K, V> a;
        final com.google.common.util.concurrent.p<V> b;
        final com.google.common.base.g c;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a implements Function<V, V> {
            a() {
            }

            @Override // com.google.common.base.Function
            public V apply(V v) {
                k.this.e(v);
                return v;
            }
        }

        public k() {
            this(LocalCache.K());
        }

        private ListenableFuture<V> b(Throwable th) {
            return Futures.e(th);
        }

        public long a() {
            return this.c.e(TimeUnit.NANOSECONDS);
        }

        public ValueReference<K, V> c() {
            return this.a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @NullableDecl V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public ListenableFuture<V> d(K k, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.c.g();
                V v = this.a.get();
                if (v == null) {
                    V load = cacheLoader.load(k);
                    return e(load) ? this.b : Futures.f(load);
                }
                ListenableFuture<V> reload = cacheLoader.reload(k, v);
                if (reload == null) {
                    return Futures.f(null);
                }
                return Futures.g(reload, new a(), MoreExecutors.a());
            } catch (Throwable th) {
                ListenableFuture<V> b2 = f(th) ? this.b : b(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return b2;
            }
        }

        public boolean e(@NullableDecl V v) {
            return this.b.set(v);
        }

        public boolean f(Throwable th) {
            return this.b.setException(th);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.a.get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.a.getWeight();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return this.a.isActive();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(@NullableDecl V v) {
            if (v != null) {
                e(v);
            } else {
                this.a = LocalCache.K();
            }
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() throws ExecutionException {
            return (V) com.google.common.util.concurrent.q.a(this.b);
        }

        public k(ValueReference<K, V> valueReference) {
            this.b = com.google.common.util.concurrent.p.a();
            this.c = com.google.common.base.g.d();
            this.a = valueReference;
        }
    }

    /* compiled from: Taobao */
    static class l<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> a;

        l(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new l(referenceQueue, v, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return (V) get();
        }
    }

    /* compiled from: Taobao */
    static final class m<K, V> extends o<K, V> {
        volatile long e = AbsPerformance.LONG_NIL;
        ReferenceEntry<K, V> f = LocalCache.w();
        ReferenceEntry<K, V> g = LocalCache.w();

        m(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public long getAccessTime() {
            return this.e;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.g;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public void setAccessTime(long j) {
            this.e = j;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.g = referenceEntry;
        }
    }

    /* compiled from: Taobao */
    static final class n<K, V> extends o<K, V> {
        volatile long e = AbsPerformance.LONG_NIL;
        ReferenceEntry<K, V> f = LocalCache.w();
        ReferenceEntry<K, V> g = LocalCache.w();
        volatile long h = AbsPerformance.LONG_NIL;
        ReferenceEntry<K, V> i = LocalCache.w();
        ReferenceEntry<K, V> j = LocalCache.w();

        n(K k, int i2, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, i2, referenceEntry);
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public long getAccessTime() {
            return this.e;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.i;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.g;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.j;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public long getWriteTime() {
            return this.h;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public void setAccessTime(long j2) {
            this.e = j2;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.i = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.g = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.j = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public void setWriteTime(long j2) {
            this.h = j2;
        }
    }

    /* compiled from: Taobao */
    static class o<K, V> extends d<K, V> {
        final K a;
        final int b;
        @NullableDecl
        final ReferenceEntry<K, V> c;
        volatile ValueReference<K, V> d = LocalCache.K();

        o(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            this.a = k;
            this.b = i;
            this.c = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public int getHash() {
            return this.b;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public K getKey() {
            return this.a;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public ReferenceEntry<K, V> getNext() {
            return this.c;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public ValueReference<K, V> getValueReference() {
            return this.d;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public void setValueReference(ValueReference<K, V> valueReference) {
            this.d = valueReference;
        }
    }

    /* compiled from: Taobao */
    static class p<K, V> implements ValueReference<K, V> {
        final V a;

        p(V v) {
            this.a = v;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    /* compiled from: Taobao */
    static final class q<K, V> extends o<K, V> {
        volatile long e = AbsPerformance.LONG_NIL;
        ReferenceEntry<K, V> f = LocalCache.w();
        ReferenceEntry<K, V> g = LocalCache.w();

        q(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.g;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public long getWriteTime() {
            return this.e;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.g = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.d
        public void setWriteTime(long j) {
            this.e = j;
        }
    }

    /* compiled from: Taobao */
    final class r extends LocalCache<K, V>.h {
        r(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) c().getValue();
        }
    }

    /* compiled from: Taobao */
    final class s extends AbstractCollection<V> {
        private final ConcurrentMap<?, ?> a;

        s(ConcurrentMap<?, ?> concurrentMap) {
            this.a = concurrentMap;
        }

        public void clear() {
            this.a.clear();
        }

        public boolean contains(Object obj) {
            return this.a.containsValue(obj);
        }

        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new r(LocalCache.this);
        }

        public int size() {
            return this.a.size();
        }

        public Object[] toArray() {
            return LocalCache.J(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.J(this).toArray(eArr);
        }
    }

    /* compiled from: Taobao */
    static final class t<K, V> extends v<K, V> {
        volatile long d = AbsPerformance.LONG_NIL;
        ReferenceEntry<K, V> e = LocalCache.w();
        ReferenceEntry<K, V> f = LocalCache.w();

        t(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public long getAccessTime() {
            return this.d;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public void setAccessTime(long j) {
            this.d = j;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.e = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }
    }

    /* compiled from: Taobao */
    static final class u<K, V> extends v<K, V> {
        volatile long d = AbsPerformance.LONG_NIL;
        ReferenceEntry<K, V> e = LocalCache.w();
        ReferenceEntry<K, V> f = LocalCache.w();
        volatile long g = AbsPerformance.LONG_NIL;
        ReferenceEntry<K, V> h = LocalCache.w();
        ReferenceEntry<K, V> i = LocalCache.w();

        u(ReferenceQueue<K> referenceQueue, K k, int i2, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i2, referenceEntry);
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public long getAccessTime() {
            return this.d;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.h;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.i;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public long getWriteTime() {
            return this.g;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public void setAccessTime(long j) {
            this.d = j;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.e = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.h = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.i = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public void setWriteTime(long j) {
            this.g = j;
        }
    }

    /* compiled from: Taobao */
    static class v<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int a;
        @NullableDecl
        final ReferenceEntry<K, V> b;
        volatile ValueReference<K, V> c = LocalCache.K();

        v(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.a = i;
            this.b = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.a;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            return (K) get();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.b;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.c;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            this.c = valueReference;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: Taobao */
    static class w<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> a;

        w(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new w(referenceQueue, v, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return (V) get();
        }
    }

    /* compiled from: Taobao */
    static final class x<K, V> extends v<K, V> {
        volatile long d = AbsPerformance.LONG_NIL;
        ReferenceEntry<K, V> e = LocalCache.w();
        ReferenceEntry<K, V> f = LocalCache.w();

        x(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public long getWriteTime() {
            return this.d;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.e = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry, com.google.common.cache.LocalCache.v
        public void setWriteTime(long j) {
            this.d = j;
        }
    }

    /* compiled from: Taobao */
    static final class y<K, V> extends l<K, V> {
        final int b;

        y(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.b = i;
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new y(referenceQueue, v, referenceEntry, this.b);
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.b;
        }
    }

    /* compiled from: Taobao */
    static final class z<K, V> extends p<K, V> {
        final int b;

        z(V v, int i) {
            super(v);
            this.b = i;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference, com.google.common.cache.LocalCache.p
        public int getWeight() {
            return this.b;
        }
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: com.google.common.cache.Weigher<K1 extends K, V1 extends V>, com.google.common.cache.Weigher<K, V> */
    /* JADX DEBUG: Type inference failed for r3v4. Raw type applied. Possible types: com.google.common.cache.RemovalListener<K1 extends K, V1 extends V>, com.google.common.cache.RemovalListener<K, V> */
    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, @NullableDecl CacheLoader<? super K, V> cacheLoader) {
        this.d = Math.min(cacheBuilder.h(), 65536);
        Strength m2 = cacheBuilder.m();
        this.g = m2;
        this.h = cacheBuilder.t();
        this.e = cacheBuilder.l();
        this.f = cacheBuilder.s();
        long n2 = cacheBuilder.n();
        this.i = n2;
        this.j = (Weigher<K1, V1>) cacheBuilder.u();
        this.k = cacheBuilder.i();
        this.l = cacheBuilder.j();
        this.m = cacheBuilder.o();
        RemovalListener removalListener = (RemovalListener<K1, V1>) cacheBuilder.p();
        this.o = removalListener;
        this.n = removalListener == CacheBuilder.NullListener.INSTANCE ? g() : new ConcurrentLinkedQueue<>();
        this.p = cacheBuilder.r(D());
        this.q = EntryFactory.getFactory(m2, L(), P());
        this.r = (AbstractCache$StatsCounter) cacheBuilder.q().get();
        this.s = cacheLoader;
        int min = Math.min(cacheBuilder.k(), 1073741824);
        if (h() && !f()) {
            min = (int) Math.min((long) min, n2);
        }
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.d && (!h() || ((long) (i4 * 20)) <= this.i)) {
            i5++;
            i4 <<= 1;
        }
        this.b = 32 - i5;
        this.a = i4 - 1;
        this.c = v(i4);
        int i6 = min / i4;
        while (i3 < (i6 * i4 < min ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        if (h()) {
            long j2 = this.i;
            long j3 = (long) i4;
            long j4 = (j2 / j3) + 1;
            long j5 = j2 % j3;
            while (true) {
                Segment<K, V>[] segmentArr = this.c;
                if (i2 < segmentArr.length) {
                    if (((long) i2) == j5) {
                        j4--;
                    }
                    segmentArr[i2] = e(i3, j4, (AbstractCache$StatsCounter) cacheBuilder.q().get());
                    i2++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                Segment<K, V>[] segmentArr2 = this.c;
                if (i2 < segmentArr2.length) {
                    segmentArr2[i2] = e(i3, -1, (AbstractCache$StatsCounter) cacheBuilder.q().get());
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    static int H(int i2) {
        int i3 = i2 + ((i2 << 15) ^ -12931);
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    /* access modifiers changed from: private */
    public static <E> ArrayList<E> J(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V> ValueReference<K, V> K() {
        return (ValueReference<K, V>) x;
    }

    static <K, V> void c(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    static <K, V> void d(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    static <E> Queue<E> g() {
        return (Queue<E>) y;
    }

    static <K, V> ReferenceEntry<K, V> w() {
        return NullEntry.INSTANCE;
    }

    static <K, V> void x(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> w2 = w();
        referenceEntry.setNextInAccessQueue(w2);
        referenceEntry.setPreviousInAccessQueue(w2);
    }

    static <K, V> void y(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> w2 = w();
        referenceEntry.setNextInWriteQueue(w2);
        referenceEntry.setPreviousInWriteQueue(w2);
    }

    /* access modifiers changed from: package-private */
    public void A(ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        I(hash).reclaimKey(referenceEntry, hash);
    }

    /* access modifiers changed from: package-private */
    public void B(ValueReference<K, V> valueReference) {
        ReferenceEntry<K, V> entry = valueReference.getEntry();
        int hash = entry.getHash();
        I(hash).reclaimValue(entry.getKey(), hash, valueReference);
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        return i();
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        return E() || C();
    }

    /* access modifiers changed from: package-private */
    public boolean E() {
        return j() || G();
    }

    /* access modifiers changed from: package-private */
    public void F(K k2) {
        int q2 = q(ds1.p(k2));
        I(q2).refresh(k2, q2, this.s, false);
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        return this.m > 0;
    }

    /* access modifiers changed from: package-private */
    public Segment<K, V> I(int i2) {
        return this.c[(i2 >>> this.b) & this.a];
    }

    /* access modifiers changed from: package-private */
    public boolean L() {
        return M() || C();
    }

    /* access modifiers changed from: package-private */
    public boolean M() {
        return i() || h();
    }

    /* access modifiers changed from: package-private */
    public boolean N() {
        return this.g != Strength.STRONG;
    }

    /* access modifiers changed from: package-private */
    public boolean O() {
        return this.h != Strength.STRONG;
    }

    /* access modifiers changed from: package-private */
    public boolean P() {
        return Q() || E();
    }

    /* access modifiers changed from: package-private */
    public boolean Q() {
        return j();
    }

    public void b() {
        for (Segment<K, V> segment : this.c) {
            segment.cleanUp();
        }
    }

    public void clear() {
        for (Segment<K, V> segment : this.c) {
            segment.clear();
        }
    }

    public boolean containsKey(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        int q2 = q(obj);
        return I(q2).containsKey(obj, q2);
    }

    public boolean containsValue(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        long a2 = this.p.a();
        Segment<K, V>[] segmentArr = this.c;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            int length = segmentArr.length;
            int i3 = 0;
            while (i3 < length) {
                Segment<K, V> segment = segmentArr[i3];
                int i4 = segment.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.table;
                for (int i5 = 0; i5 < atomicReferenceArray.length(); i5++) {
                    ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i5);
                    while (referenceEntry != null) {
                        V liveValue = segment.getLiveValue(referenceEntry, a2);
                        if (liveValue != null && this.f.equivalent(obj, liveValue)) {
                            return true;
                        }
                        referenceEntry = referenceEntry.getNext();
                        segmentArr = segmentArr;
                        a2 = a2;
                    }
                }
                j3 += (long) segment.modCount;
                i3++;
                a2 = a2;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
            segmentArr = segmentArr;
            a2 = a2;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Segment<K, V> e(int i2, long j2, AbstractCache$StatsCounter abstractCache$StatsCounter) {
        return new Segment<>(this, i2, j2, abstractCache$StatsCounter);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @GwtIncompatible
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.v;
        if (set != null) {
            return set;
        }
        g gVar = new g(this);
        this.v = gVar;
        return gVar;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.j != CacheBuilder.OneWeigher.INSTANCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int q2 = q(obj);
        return I(q2).get(obj, q2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @NullableDecl
    public V getOrDefault(@NullableDecl Object obj, @NullableDecl V v2) {
        V v3 = get(obj);
        return v3 != null ? v3 : v2;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.i >= 0;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.k > 0;
    }

    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.c;
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
    public boolean j() {
        return this.l > 0;
    }

    /* access modifiers changed from: package-private */
    public V k(K k2, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int q2 = q(ds1.p(k2));
        return I(q2).get(k2, q2, cacheLoader);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.t;
        if (set != null) {
            return set;
        }
        j jVar = new j(this);
        this.t = jVar;
        return jVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.cache.LocalCache<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public ImmutableMap<K, V> l(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap s2 = Maps.s();
        LinkedHashSet g2 = Sets.g();
        int i2 = 0;
        int i3 = 0;
        for (Object obj : iterable) {
            Object obj2 = get(obj);
            if (!s2.containsKey(obj)) {
                s2.put(obj, obj2);
                if (obj2 == null) {
                    i3++;
                    g2.add(obj);
                } else {
                    i2++;
                }
            }
        }
        try {
            if (!g2.isEmpty()) {
                try {
                    Map t2 = t(g2, this.s);
                    for (Object obj3 : g2) {
                        Object obj4 = t2.get(obj3);
                        if (obj4 != null) {
                            s2.put(obj3, obj4);
                        } else {
                            throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + obj3);
                        }
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj5 : g2) {
                        i3--;
                        s2.put(obj5, k(obj5, this.s));
                    }
                }
            }
            ImmutableMap<K, V> copyOf = ImmutableMap.copyOf(s2);
            return copyOf;
        } finally {
            this.r.recordHits(i2);
            this.r.recordMisses(i3);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public ImmutableMap<K, V> m(Iterable<?> iterable) {
        LinkedHashMap s2 = Maps.s();
        int i2 = 0;
        int i3 = 0;
        for (Object obj : iterable) {
            V v2 = get(obj);
            if (v2 == null) {
                i3++;
            } else {
                s2.put(obj, v2);
                i2++;
            }
        }
        this.r.recordHits(i2);
        this.r.recordMisses(i3);
        return ImmutableMap.copyOf(s2);
    }

    @NullableDecl
    public V n(Object obj) {
        int q2 = q(ds1.p(obj));
        V v2 = I(q2).get(obj, q2);
        if (v2 == null) {
            this.r.recordMisses(1);
        } else {
            this.r.recordHits(1);
        }
        return v2;
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public V o(ReferenceEntry<K, V> referenceEntry, long j2) {
        V v2;
        if (referenceEntry.getKey() == null || (v2 = referenceEntry.getValueReference().get()) == null || s(referenceEntry, j2)) {
            return null;
        }
        return v2;
    }

    /* access modifiers changed from: package-private */
    public V p(K k2) throws ExecutionException {
        return k(k2, this.s);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        ds1.p(k2);
        ds1.p(v2);
        int q2 = q(k2);
        return I(q2).put(k2, q2, v2, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.cache.LocalCache<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v2) {
        ds1.p(k2);
        ds1.p(v2);
        int q2 = q(k2);
        return I(q2).put(k2, q2, v2, true);
    }

    /* access modifiers changed from: package-private */
    public int q(@NullableDecl Object obj) {
        return H(this.e.hash(obj));
    }

    /* access modifiers changed from: package-private */
    public void r(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int q2 = q(obj);
        return I(q2).remove(obj, q2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, @NullableDecl V v2, V v3) {
        ds1.p(k2);
        ds1.p(v3);
        if (v2 == null) {
            return false;
        }
        int q2 = q(k2);
        return I(q2).replace(k2, q2, v2, v3);
    }

    /* access modifiers changed from: package-private */
    public boolean s(ReferenceEntry<K, V> referenceEntry, long j2) {
        ds1.p(referenceEntry);
        if (i() && j2 - referenceEntry.getAccessTime() >= this.k) {
            return true;
        }
        if (!j() || j2 - referenceEntry.getWriteTime() < this.l) {
            return false;
        }
        return true;
    }

    public int size() {
        return Ints.j(u());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.cache.LocalCache<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    @NullableDecl
    public Map<K, V> t(Set<? extends K> set, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        Throwable th;
        ds1.p(cacheLoader);
        ds1.p(set);
        com.google.common.base.g c2 = com.google.common.base.g.c();
        boolean z2 = true;
        boolean z3 = false;
        try {
            Map map = (Map<? super K, V>) cacheLoader.loadAll(set);
            if (map != null) {
                c2.h();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    V value = entry.getValue();
                    if (key == null || value == null) {
                        z3 = true;
                    } else {
                        put(key, value);
                    }
                }
                if (!z3) {
                    this.r.recordLoadSuccess(c2.e(TimeUnit.NANOSECONDS));
                    return map;
                }
                this.r.recordLoadException(c2.e(TimeUnit.NANOSECONDS));
                throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null keys or values from loadAll");
            }
            this.r.recordLoadException(c2.e(TimeUnit.NANOSECONDS));
            throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null map from loadAll");
        } catch (CacheLoader.UnsupportedLoadingOperationException e2) {
            throw e2;
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            throw new ExecutionException(e3);
        } catch (RuntimeException e4) {
            throw new UncheckedExecutionException(e4);
        } catch (Exception e5) {
            throw new ExecutionException(e5);
        } catch (Error e6) {
            throw new ExecutionError(e6);
        } catch (Throwable th2) {
            th = th2;
        }
        if (!z2) {
            this.r.recordLoadException(c2.e(TimeUnit.NANOSECONDS));
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public long u() {
        Segment<K, V>[] segmentArr;
        long j2 = 0;
        for (Segment<K, V> segment : this.c) {
            j2 += (long) Math.max(0, segment.count);
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public final Segment<K, V>[] v(int i2) {
        return new Segment[i2];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.u;
        if (collection != null) {
            return collection;
        }
        s sVar = new s(this);
        this.u = sVar;
        return sVar;
    }

    /* access modifiers changed from: package-private */
    public void z() {
        while (true) {
            RemovalNotification<K, V> poll = this.n.poll();
            if (poll != null) {
                try {
                    this.o.onRemoval(poll);
                } catch (Throwable th) {
                    w.log(Level.WARNING, "Exception thrown by removal listener", th);
                }
            } else {
                return;
            }
        }
    }

    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int q2 = q(obj);
        return I(q2).remove(obj, q2, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v2) {
        ds1.p(k2);
        ds1.p(v2);
        int q2 = q(k2);
        return I(q2).replace(k2, q2, v2);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class Segment<K, V> extends ReentrantLock {
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> accessQueue;
        volatile int count;
        @NullableDecl
        final ReferenceQueue<K> keyReferenceQueue;
        @Weak
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        final AbstractCache$StatsCounter statsCounter;
        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;
        @GuardedBy("this")
        long totalWeight;
        @NullableDecl
        final ReferenceQueue<V> valueReferenceQueue;
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> writeQueue;

        Segment(LocalCache<K, V> localCache, int i, long j, AbstractCache$StatsCounter abstractCache$StatsCounter) {
            Queue<ReferenceEntry<K, V>> queue;
            Queue<ReferenceEntry<K, V>> queue2;
            Queue<ReferenceEntry<K, V>> queue3;
            this.map = localCache;
            this.maxSegmentWeight = j;
            this.statsCounter = (AbstractCache$StatsCounter) ds1.p(abstractCache$StatsCounter);
            initTable(newEntryArray(i));
            ReferenceQueue<V> referenceQueue = null;
            this.keyReferenceQueue = localCache.N() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.O() ? new ReferenceQueue<>() : referenceQueue;
            if (localCache.M()) {
                queue = new ConcurrentLinkedQueue<>();
            } else {
                queue = LocalCache.g();
            }
            this.recencyQueue = queue;
            if (localCache.Q()) {
                queue2 = new b0<>();
            } else {
                queue2 = LocalCache.g();
            }
            this.writeQueue = queue2;
            if (localCache.M()) {
                queue3 = new e<>();
            } else {
                queue3 = LocalCache.g();
            }
            this.accessQueue = queue3;
        }

        /* access modifiers changed from: package-private */
        public void cleanUp() {
            runLockedCleanup(this.map.p.a());
            runUnlockedCleanup();
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            RemovalCause removalCause;
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.p.a());
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            if (referenceEntry.getValueReference().isActive()) {
                                K key = referenceEntry.getKey();
                                V v = referenceEntry.getValueReference().get();
                                if (key != null) {
                                    if (v != null) {
                                        removalCause = RemovalCause.EXPLICIT;
                                        enqueueNotification(key, referenceEntry.getHash(), v, referenceEntry.getValueReference().getWeight(), removalCause);
                                    }
                                }
                                removalCause = RemovalCause.COLLECTED;
                                enqueueNotification(key, referenceEntry.getHash(), v, referenceEntry.getValueReference().getWeight(), removalCause);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void clearKeyReferenceQueue() {
            do {
            } while (this.keyReferenceQueue.poll() != null);
        }

        /* access modifiers changed from: package-private */
        public void clearReferenceQueues() {
            if (this.map.N()) {
                clearKeyReferenceQueue();
            }
            if (this.map.O()) {
                clearValueReferenceQueue();
            }
        }

        /* access modifiers changed from: package-private */
        public void clearValueReferenceQueue() {
            do {
            } while (this.valueReferenceQueue.poll() != null);
        }

        /* access modifiers changed from: package-private */
        public boolean containsKey(Object obj, int i) {
            try {
                boolean z = false;
                if (this.count != 0) {
                    ReferenceEntry<K, V> liveEntry = getLiveEntry(obj, i, this.map.p.a());
                    if (liveEntry == null) {
                        return false;
                    }
                    if (liveEntry.getValueReference().get() != null) {
                        z = true;
                    }
                    postReadCleanup();
                    return z;
                }
                postReadCleanup();
                return false;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    long a = this.map.p.a();
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            V liveValue = getLiveValue(referenceEntry, a);
                            if (liveValue != null) {
                                if (this.map.f.equivalent(obj, liveValue)) {
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
        @GuardedBy("this")
        public ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            V v = valueReference.get();
            if (v == null && valueReference.isActive()) {
                return null;
            }
            ReferenceEntry<K, V> copyEntry = this.map.q.copyEntry(this, referenceEntry, referenceEntry2);
            copyEntry.setValueReference(valueReference.copyFor(this.valueReferenceQueue, v, copyEntry));
            return copyEntry;
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void drainKeyReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll != null) {
                    this.map.A((ReferenceEntry) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void drainRecencyQueue() {
            while (true) {
                ReferenceEntry<K, V> poll = this.recencyQueue.poll();
                if (poll == null) {
                    return;
                }
                if (this.accessQueue.contains(poll)) {
                    this.accessQueue.add(poll);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void drainReferenceQueues() {
            if (this.map.N()) {
                drainKeyReferenceQueue();
            }
            if (this.map.O()) {
                drainValueReferenceQueue();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void drainValueReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll != null) {
                    this.map.B((ValueReference) poll);
                    i++;
                } else {
                    return;
                }
            } while (i != 16);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void enqueueNotification(@NullableDecl K k, int i, @NullableDecl V v, int i2, RemovalCause removalCause) {
            this.totalWeight -= (long) i2;
            if (removalCause.wasEvicted()) {
                this.statsCounter.recordEviction();
            }
            if (this.map.n != LocalCache.y) {
                this.map.n.offer(RemovalNotification.create(k, v, removalCause));
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void evictEntries(ReferenceEntry<K, V> referenceEntry) {
            if (this.map.h()) {
                drainRecencyQueue();
                if (((long) referenceEntry.getValueReference().getWeight()) <= this.maxSegmentWeight || removeEntry(referenceEntry, referenceEntry.getHash(), RemovalCause.SIZE)) {
                    while (this.totalWeight > this.maxSegmentWeight) {
                        ReferenceEntry<K, V> nextEvictable = getNextEvictable();
                        if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                            throw new AssertionError();
                        }
                    }
                    return;
                }
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i = this.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray = newEntryArray(length << 1);
                this.threshold = (newEntryArray.length() * 3) / 4;
                int length2 = newEntryArray.length() - 1;
                for (int i2 = 0; i2 < length; i2++) {
                    ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i2);
                    if (referenceEntry != null) {
                        ReferenceEntry<K, V> next = referenceEntry.getNext();
                        int hash = referenceEntry.getHash() & length2;
                        if (next == null) {
                            newEntryArray.set(hash, referenceEntry);
                        } else {
                            ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                            while (next != null) {
                                int hash2 = next.getHash() & length2;
                                if (hash2 != hash) {
                                    referenceEntry2 = next;
                                    hash = hash2;
                                }
                                next = next.getNext();
                            }
                            newEntryArray.set(hash, referenceEntry2);
                            while (referenceEntry != referenceEntry2) {
                                int hash3 = referenceEntry.getHash() & length2;
                                ReferenceEntry<K, V> copyEntry = copyEntry(referenceEntry, newEntryArray.get(hash3));
                                if (copyEntry != null) {
                                    newEntryArray.set(hash3, copyEntry);
                                } else {
                                    removeCollectedEntry(referenceEntry);
                                    i--;
                                }
                                referenceEntry = referenceEntry.getNext();
                            }
                        }
                    }
                }
                this.table = newEntryArray;
                this.count = i;
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void expireEntries(long j) {
            ReferenceEntry<K, V> peek;
            ReferenceEntry<K, V> peek2;
            drainRecencyQueue();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.s(peek, j)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.s(peek2, j)) {
                            return;
                        }
                    } while (removeEntry(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public V get(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            ReferenceEntry<K, V> entry;
            ds1.p(k);
            ds1.p(cacheLoader);
            try {
                if (!(this.count == 0 || (entry = getEntry(k, i)) == null)) {
                    long a = this.map.p.a();
                    V liveValue = getLiveValue(entry, a);
                    if (liveValue != null) {
                        recordRead(entry, a);
                        this.statsCounter.recordHits(1);
                        V scheduleRefresh = scheduleRefresh(entry, k, i, liveValue, a, cacheLoader);
                        postReadCleanup();
                        return scheduleRefresh;
                    }
                    ValueReference<K, V> valueReference = entry.getValueReference();
                    if (valueReference.isLoading()) {
                        V waitForLoadingValue = waitForLoadingValue(entry, k, valueReference);
                        postReadCleanup();
                        return waitForLoadingValue;
                    }
                }
                V lockedGetOrLoad = lockedGetOrLoad(k, i, cacheLoader);
                postReadCleanup();
                return lockedGetOrLoad;
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause instanceof Error) {
                    throw new ExecutionError((Error) cause);
                } else if (cause instanceof RuntimeException) {
                    throw new UncheckedExecutionException(cause);
                } else {
                    throw e;
                }
            } catch (Throwable th) {
                postReadCleanup();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
        public V getAndRecordStats(K k, int i, k<K, V> kVar, ListenableFuture<V> listenableFuture) throws ExecutionException {
            V v;
            Throwable th;
            try {
                v = (V) com.google.common.util.concurrent.q.a(listenableFuture);
                if (v != null) {
                    try {
                        this.statsCounter.recordLoadSuccess(kVar.a());
                        storeLoadedValue(k, i, kVar, v);
                        return v;
                    } catch (Throwable th2) {
                        th = th2;
                        if (v == null) {
                        }
                        throw th;
                    }
                } else {
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + ((Object) k) + ".");
                }
            } catch (Throwable th3) {
                th = th3;
                v = null;
                if (v == null) {
                    this.statsCounter.recordLoadException(kVar.a());
                    removeLoadingValue(k, i, kVar);
                }
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public ReferenceEntry<K, V> getEntry(Object obj, int i) {
            for (ReferenceEntry<K, V> first = getFirst(i); first != null; first = first.getNext()) {
                if (first.getHash() == i) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.e.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public ReferenceEntry<K, V> getFirst(int i) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public ReferenceEntry<K, V> getLiveEntry(Object obj, int i, long j) {
            ReferenceEntry<K, V> entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (!this.map.s(entry, j)) {
                return entry;
            }
            tryExpireEntries(j);
            return null;
        }

        /* access modifiers changed from: package-private */
        public V getLiveValue(ReferenceEntry<K, V> referenceEntry, long j) {
            if (referenceEntry.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = referenceEntry.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            } else if (!this.map.s(referenceEntry, j)) {
                return v;
            } else {
                tryExpireEntries(j);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public ReferenceEntry<K, V> getNextEvictable() {
            for (ReferenceEntry<K, V> referenceEntry : this.accessQueue) {
                if (referenceEntry.getValueReference().getWeight() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.f()) {
                int i = this.threshold;
                if (((long) i) == this.maxSegmentWeight) {
                    this.threshold = i + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public k<K, V> insertLoadingValueReference(K k, int i, boolean z) {
            lock();
            try {
                long a = this.map.p.a();
                preWriteCleanup(a);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.e.equivalent(k, key)) {
                        ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                        if (!valueReference.isLoading()) {
                            if (!z || a - referenceEntry2.getWriteTime() >= this.map.m) {
                                this.modCount++;
                                k<K, V> kVar = new k<>(valueReference);
                                referenceEntry2.setValueReference(kVar);
                                unlock();
                                postWriteCleanup();
                                return kVar;
                            }
                        }
                        return null;
                    }
                }
                this.modCount++;
                k<K, V> kVar2 = new k<>();
                ReferenceEntry<K, V> newEntry = newEntry(k, i, referenceEntry);
                newEntry.setValueReference(kVar2);
                atomicReferenceArray.set(length, newEntry);
                unlock();
                postWriteCleanup();
                return kVar2;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public ListenableFuture<V> loadAsync(final K k, final int i, final k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) {
            final ListenableFuture<V> d = kVar.d(k, cacheLoader);
            d.addListener(new Runnable() {
                /* class com.google.common.cache.LocalCache.Segment.AnonymousClass1 */

                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.cache.LocalCache$Segment */
                /* JADX WARN: Multi-variable type inference failed */
                public void run() {
                    try {
                        Segment.this.getAndRecordStats(k, i, kVar, d);
                    } catch (Throwable th) {
                        LocalCache.w.log(Level.WARNING, "Exception thrown during refresh", th);
                        kVar.f(th);
                    }
                }
            }, MoreExecutors.a());
            return d;
        }

        /* access modifiers changed from: package-private */
        public V loadSync(K k, int i, k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k, i, kVar, kVar.d(k, cacheLoader));
        }

        /* access modifiers changed from: package-private */
        public V lockedGetOrLoad(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            k<K, V> kVar;
            ValueReference<K, V> valueReference;
            boolean z;
            V loadSync;
            lock();
            try {
                long a = this.map.p.a();
                preWriteCleanup(a);
                int i2 = this.count - 1;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    kVar = null;
                    if (referenceEntry2 == null) {
                        valueReference = null;
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.e.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference<K, V> valueReference2 = referenceEntry2.getValueReference();
                        if (valueReference2.isLoading()) {
                            z = false;
                            valueReference = valueReference2;
                        } else {
                            V v = valueReference2.get();
                            if (v == null) {
                                enqueueNotification(key, i, v, valueReference2.getWeight(), RemovalCause.COLLECTED);
                            } else if (this.map.s(referenceEntry2, a)) {
                                enqueueNotification(key, i, v, valueReference2.getWeight(), RemovalCause.EXPIRED);
                            } else {
                                recordLockedRead(referenceEntry2, a);
                                this.statsCounter.recordHits(1);
                                unlock();
                                postWriteCleanup();
                                return v;
                            }
                            this.writeQueue.remove(referenceEntry2);
                            this.accessQueue.remove(referenceEntry2);
                            this.count = i2;
                            valueReference = valueReference2;
                        }
                    }
                }
                z = true;
                if (z) {
                    kVar = new k<>();
                    if (referenceEntry2 == null) {
                        referenceEntry2 = newEntry(k, i, referenceEntry);
                        referenceEntry2.setValueReference(kVar);
                        atomicReferenceArray.set(length, referenceEntry2);
                    } else {
                        referenceEntry2.setValueReference(kVar);
                    }
                }
                if (!z) {
                    return waitForLoadingValue(referenceEntry2, k, valueReference);
                }
                try {
                    synchronized (referenceEntry2) {
                        loadSync = loadSync(k, i, kVar, cacheLoader);
                    }
                    return loadSync;
                } finally {
                    this.statsCounter.recordMisses(1);
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.cache.LocalCache$EntryFactory */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public ReferenceEntry<K, V> newEntry(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            return this.map.q.newEntry(this, ds1.p(k), i, referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        /* access modifiers changed from: package-private */
        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        /* access modifiers changed from: package-private */
        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void preWriteCleanup(long j) {
            runLockedCleanup(j);
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public V put(K k, int i, V v, boolean z) {
            int i2;
            lock();
            try {
                long a = this.map.p.a();
                preWriteCleanup(a);
                if (this.count + 1 > this.threshold) {
                    expand();
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        this.modCount++;
                        ReferenceEntry<K, V> newEntry = newEntry(k, i, referenceEntry);
                        setValue(newEntry, k, v, a);
                        atomicReferenceArray.set(length, newEntry);
                        this.count++;
                        evictEntries(newEntry);
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.e.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                        V v2 = valueReference.get();
                        if (v2 == null) {
                            this.modCount++;
                            if (valueReference.isActive()) {
                                enqueueNotification(k, i, v2, valueReference.getWeight(), RemovalCause.COLLECTED);
                                setValue(referenceEntry2, k, v, a);
                                i2 = this.count;
                            } else {
                                setValue(referenceEntry2, k, v, a);
                                i2 = this.count + 1;
                            }
                            this.count = i2;
                            evictEntries(referenceEntry2);
                        } else {
                            if (z) {
                                recordLockedRead(referenceEntry2, a);
                            } else {
                                this.modCount++;
                                enqueueNotification(k, i, v2, valueReference.getWeight(), RemovalCause.REPLACED);
                                setValue(referenceEntry2, k, v, a);
                                evictEntries(referenceEntry2);
                            }
                            unlock();
                            postWriteCleanup();
                            return v2;
                        }
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean reclaimKey(ReferenceEntry<K, V> referenceEntry, int i) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                    if (referenceEntry3 == referenceEntry) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), RemovalCause.COLLECTED));
                        this.count--;
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean reclaimValue(K k, int i, ValueReference<K, V> valueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.map.e.equivalent(k, key)) {
                        if (referenceEntry2.getValueReference() == valueReference) {
                            this.modCount++;
                            atomicReferenceArray.set(length, removeValueFromChain(referenceEntry, referenceEntry2, key, i, valueReference.get(), valueReference, RemovalCause.COLLECTED));
                            this.count--;
                            return true;
                        } else {
                            unlock();
                            if (!isHeldByCurrentThread()) {
                                postWriteCleanup();
                            }
                            return false;
                        }
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void recordLockedRead(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.C()) {
                referenceEntry.setAccessTime(j);
            }
            this.accessQueue.add(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public void recordRead(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.map.C()) {
                referenceEntry.setAccessTime(j);
            }
            this.recencyQueue.add(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void recordWrite(ReferenceEntry<K, V> referenceEntry, int i, long j) {
            drainRecencyQueue();
            this.totalWeight += (long) i;
            if (this.map.C()) {
                referenceEntry.setAccessTime(j);
            }
            if (this.map.E()) {
                referenceEntry.setWriteTime(j);
            }
            this.accessQueue.add(referenceEntry);
            this.writeQueue.add(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public V refresh(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
            k<K, V> insertLoadingValueReference = insertLoadingValueReference(k, i, z);
            if (insertLoadingValueReference == null) {
                return null;
            }
            ListenableFuture<V> loadAsync = loadAsync(k, i, insertLoadingValueReference, cacheLoader);
            if (loadAsync.isDone()) {
                try {
                    return (V) com.google.common.util.concurrent.q.a(loadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public V remove(Object obj, int i) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.p.a());
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.e.equivalent(obj, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                        V v = valueReference.get();
                        if (v != null) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (valueReference.isActive()) {
                            removalCause = RemovalCause.COLLECTED;
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(referenceEntry, referenceEntry2, key, i, v, valueReference, removalCause));
                        this.count--;
                        return v;
                    }
                }
                unlock();
                postWriteCleanup();
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void removeCollectedEntry(ReferenceEntry<K, V> referenceEntry) {
            enqueueNotification(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), referenceEntry.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(referenceEntry);
            this.accessQueue.remove(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        @GuardedBy("this")
        public boolean removeEntry(ReferenceEntry<K, V> referenceEntry, int i, RemovalCause removalCause) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
            for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.modCount++;
                    atomicReferenceArray.set(length, removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), removalCause));
                    this.count--;
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        @GuardedBy("this")
        public ReferenceEntry<K, V> removeEntryFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            int i = this.count;
            ReferenceEntry<K, V> next = referenceEntry2.getNext();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = copyEntry(referenceEntry, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(referenceEntry);
                    i--;
                }
                referenceEntry = referenceEntry.getNext();
            }
            this.count = i;
            return next;
        }

        /* access modifiers changed from: package-private */
        public boolean removeLoadingValue(K k, int i, k<K, V> kVar) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.e.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == kVar) {
                        if (kVar.isActive()) {
                            referenceEntry2.setValueReference(kVar.c());
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(referenceEntry, referenceEntry2));
                        }
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        @GuardedBy("this")
        public ReferenceEntry<K, V> removeValueFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, @NullableDecl K k, int i, V v, ValueReference<K, V> valueReference, RemovalCause removalCause) {
            enqueueNotification(k, i, v, valueReference.getWeight(), removalCause);
            this.writeQueue.remove(referenceEntry2);
            this.accessQueue.remove(referenceEntry2);
            if (!valueReference.isLoading()) {
                return removeEntryFromChain(referenceEntry, referenceEntry2);
            }
            valueReference.notifyNewValue(null);
            return referenceEntry;
        }

        /* access modifiers changed from: package-private */
        public boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                long a = this.map.p.a();
                preWriteCleanup(a);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null) {
                        if (this.map.e.equivalent(k, key)) {
                            ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                            V v3 = valueReference.get();
                            if (v3 == null) {
                                if (valueReference.isActive()) {
                                    this.modCount++;
                                    atomicReferenceArray.set(length, removeValueFromChain(referenceEntry, referenceEntry2, key, i, v3, valueReference, RemovalCause.COLLECTED));
                                    this.count--;
                                }
                            } else if (this.map.f.equivalent(v, v3)) {
                                this.modCount++;
                                enqueueNotification(k, i, v3, valueReference.getWeight(), RemovalCause.REPLACED);
                                setValue(referenceEntry2, k, v2, a);
                                evictEntries(referenceEntry2);
                                unlock();
                                postWriteCleanup();
                                return true;
                            } else {
                                recordLockedRead(referenceEntry2, a);
                            }
                        }
                    }
                    referenceEntry2 = referenceEntry2.getNext();
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public void runLockedCleanup(long j) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void runUnlockedCleanup() {
            if (!isHeldByCurrentThread()) {
                this.map.z();
            }
        }

        /* access modifiers changed from: package-private */
        public V scheduleRefresh(ReferenceEntry<K, V> referenceEntry, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
            V refresh;
            return (!this.map.G() || j - referenceEntry.getWriteTime() <= this.map.m || referenceEntry.getValueReference().isLoading() || (refresh = refresh(k, i, cacheLoader, true)) == null) ? v : refresh;
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void setValue(ReferenceEntry<K, V> referenceEntry, K k, V v, long j) {
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            int weigh = this.map.j.weigh(k, v);
            ds1.x(weigh >= 0, "Weights must be non-negative");
            referenceEntry.setValueReference(this.map.h.referenceValue(this, referenceEntry, v, weigh));
            recordWrite(referenceEntry, weigh, j);
            valueReference.notifyNewValue(v);
        }

        /* access modifiers changed from: package-private */
        public boolean storeLoadedValue(K k, int i, k<K, V> kVar, V v) {
            lock();
            try {
                long a = this.map.p.a();
                preWriteCleanup(a);
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                int i3 = i2;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        this.modCount++;
                        ReferenceEntry<K, V> newEntry = newEntry(k, i, referenceEntry);
                        setValue(newEntry, k, v, a);
                        atomicReferenceArray.set(length, newEntry);
                        this.count = i3;
                        evictEntries(newEntry);
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.e.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                        V v2 = valueReference.get();
                        if (kVar != valueReference) {
                            if (v2 != null || valueReference == LocalCache.x) {
                                enqueueNotification(k, i, v, 0, RemovalCause.REPLACED);
                                unlock();
                                postWriteCleanup();
                                return false;
                            }
                        }
                        this.modCount++;
                        if (kVar.isActive()) {
                            enqueueNotification(k, i, v2, kVar.getWeight(), v2 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            i3--;
                        }
                        setValue(referenceEntry2, k, v, a);
                        this.count = i3;
                        evictEntries(referenceEntry2);
                    }
                }
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void tryExpireEntries(long j) {
            if (tryLock()) {
                try {
                    expireEntries(j);
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public V waitForLoadingValue(ReferenceEntry<K, V> referenceEntry, K k, ValueReference<K, V> valueReference) throws ExecutionException {
            if (valueReference.isLoading()) {
                ds1.A(!Thread.holdsLock(referenceEntry), "Recursive load of: %s", k);
                try {
                    V waitForValue = valueReference.waitForValue();
                    if (waitForValue != null) {
                        recordRead(referenceEntry, this.map.p.a());
                        return waitForValue;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + ((Object) k) + ".");
                } finally {
                    this.statsCounter.recordMisses(1);
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public V get(Object obj, int i) {
            try {
                if (this.count != 0) {
                    long a = this.map.p.a();
                    ReferenceEntry<K, V> liveEntry = getLiveEntry(obj, i, a);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v = liveEntry.getValueReference().get();
                    if (v != null) {
                        recordRead(liveEntry, a);
                        V scheduleRefresh = scheduleRefresh(liveEntry, liveEntry.getKey(), i, v, a, this.map.s);
                        postReadCleanup();
                        return scheduleRefresh;
                    }
                    tryDrainReferenceQueues();
                }
                postReadCleanup();
                return null;
            } finally {
                postReadCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean remove(Object obj, int i, Object obj2) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.p.a());
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                boolean z = true;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.map.e.equivalent(obj, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                        V v = valueReference.get();
                        if (this.map.f.equivalent(obj2, v)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (v == null && valueReference.isActive()) {
                            removalCause = RemovalCause.COLLECTED;
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(referenceEntry, referenceEntry2, key, i, v, valueReference, removalCause));
                        this.count--;
                        if (removalCause != RemovalCause.EXPLICIT) {
                            z = false;
                        }
                        return z;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public V replace(K k, int i, V v) {
            lock();
            try {
                long a = this.map.p.a();
                preWriteCleanup(a);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null) {
                        if (this.map.e.equivalent(k, key)) {
                            ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                            V v2 = valueReference.get();
                            if (v2 != null) {
                                this.modCount++;
                                enqueueNotification(k, i, v2, valueReference.getWeight(), RemovalCause.REPLACED);
                                setValue(referenceEntry2, k, v, a);
                                evictEntries(referenceEntry2);
                                unlock();
                                postWriteCleanup();
                                return v2;
                            } else if (valueReference.isActive()) {
                                this.modCount++;
                                atomicReferenceArray.set(length, removeValueFromChain(referenceEntry, referenceEntry2, key, i, v2, valueReference, RemovalCause.COLLECTED));
                                this.count--;
                            }
                        }
                    }
                    referenceEntry2 = referenceEntry2.getNext();
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }
    }
}
