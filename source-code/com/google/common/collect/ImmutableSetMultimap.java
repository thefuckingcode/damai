package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.e;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.f0;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.wr2;

@GwtCompatible(emulated = true, serializable = true)
/* compiled from: Taobao */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> emptySet;
    @MonotonicNonNullDecl
    private transient ImmutableSet<Map.Entry<K, V>> entries;
    @RetainedWith
    @LazyInit
    @MonotonicNonNullDecl
    private transient ImmutableSetMultimap<V, K> inverse;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        @Weak
        private final transient ImmutableSetMultimap<K, V> multimap;

        EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.multimap = immutableSetMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        public int size() {
            return this.multimap.size();
        }

        @Override // java.util.AbstractCollection, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableSet, java.util.Collection, com.google.common.collect.ImmutableCollection, com.google.common.collect.ImmutableCollection, java.util.Set, java.lang.Iterable
        public wr2<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
    }

    /* compiled from: Taobao */
    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMultimap.c
        public Collection<V> b() {
            return e0.g();
        }

        public ImmutableSetMultimap<K, V> f() {
            Collection entrySet = this.a.entrySet();
            Comparator<? super K> comparator = this.b;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(entrySet);
            }
            return ImmutableSetMultimap.fromMapEntries(entrySet, this.c);
        }

        @CanIgnoreReturnValue
        /* renamed from: g */
        public a<K, V> c(K k, V v) {
            super.c(k, v);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: h */
        public a<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            super.d(entry);
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public a<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.e(iterable);
            return this;
        }
    }

    @GwtIncompatible
    /* compiled from: Taobao */
    private static final class b {
        static final f0.b<ImmutableSetMultimap> a = f0.a(ImmutableSetMultimap.class, "emptySet");
    }

    ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i, @NullableDecl Comparator<? super V> comparator) {
        super(immutableMap, i);
        this.emptySet = emptySet(comparator);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        return copyOf(multimap, null);
    }

    private static <V> ImmutableSet<V> emptySet(@NullableDecl Comparator<? super V> comparator) {
        if (comparator == null) {
            return ImmutableSet.of();
        }
        return ImmutableSortedSet.emptySet(comparator);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.collect.ImmutableMap$b */
    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, @NullableDecl Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int i = 0;
        Iterator<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> it = collection.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            ImmutableSet valueSet = valueSet(comparator, (Collection) entry.getValue());
            if (!valueSet.isEmpty()) {
                bVar.c(key, valueSet);
                i += valueSet.size();
            }
        }
        return new ImmutableSetMultimap<>(bVar.a(), i, comparator);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableSetMultimap<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableSetMultimap$a */
    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> invert() {
        a builder = builder();
        wr2 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.c(entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> f = builder.f();
        f.inverse = this;
        return f;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.google.common.collect.ImmutableMap$b */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            ImmutableMap.b builder = ImmutableMap.builder();
            int i = 0;
            for (int i2 = 0; i2 < readInt; i2++) {
                Object readObject = objectInputStream.readObject();
                int readInt2 = objectInputStream.readInt();
                if (readInt2 > 0) {
                    ImmutableSet.a valuesBuilder = valuesBuilder(comparator);
                    for (int i3 = 0; i3 < readInt2; i3++) {
                        valuesBuilder.a(objectInputStream.readObject());
                    }
                    ImmutableSet l = valuesBuilder.l();
                    if (l.size() == readInt2) {
                        builder.c(readObject, l);
                        i += readInt2;
                    } else {
                        throw new InvalidObjectException("Duplicate key-value pairs exist for key " + readObject);
                    }
                } else {
                    throw new InvalidObjectException("Invalid value count " + readInt2);
                }
            }
            try {
                ImmutableMultimap.d.a.b(this, builder.a());
                ImmutableMultimap.d.b.a(this, i);
                b.a.b(this, emptySet(comparator));
            } catch (IllegalArgumentException e) {
                throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
            }
        } else {
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
    }

    private static <V> ImmutableSet<V> valueSet(@NullableDecl Comparator<? super V> comparator, Collection<? extends V> collection) {
        if (comparator == null) {
            return ImmutableSet.copyOf((Collection) collection);
        }
        return ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) collection);
    }

    private static <V> ImmutableSet.a<V> valuesBuilder(@NullableDecl Comparator<? super V> comparator) {
        return comparator == null ? new ImmutableSet.a<>() : new ImmutableSortedSet.a(comparator);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        f0.j(this, objectOutputStream);
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public Comparator<? super V> valueComparator() {
        ImmutableSet<V> immutableSet = this.emptySet;
        if (immutableSet instanceof ImmutableSortedSet) {
            return ((ImmutableSortedSet) immutableSet).comparator();
        }
        return null;
    }

    private static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap, Comparator<? super V> comparator) {
        ds1.p(multimap);
        if (multimap.isEmpty() && comparator == null) {
            return of();
        }
        if (multimap instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) multimap;
            if (!immutableSetMultimap.isPartialView()) {
                return immutableSetMultimap;
            }
        }
        return fromMapEntries(multimap.asMap().entrySet(), comparator);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v) {
        a builder = builder();
        builder.c(k, v);
        return builder.f();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.inverse;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<V, K> invert = invert();
        this.inverse = invert;
        return invert;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entries;
        if (immutableSet != null) {
            return immutableSet;
        }
        EntrySet entrySet = new EntrySet(this);
        this.entries = entrySet;
        return entrySet;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public ImmutableSet<V> get(@NullableDecl K k) {
        return (ImmutableSet) e.a((ImmutableSet) this.map.get(k), this.emptySet);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableSet<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2) {
        a builder = builder();
        builder.c(k, v);
        builder.c(k2, v2);
        return builder.f();
    }

    @Beta
    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().i(iterable).f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        a builder = builder();
        builder.c(k, v);
        builder.c(k2, v2);
        builder.c(k3, v3);
        return builder.f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        a builder = builder();
        builder.c(k, v);
        builder.c(k2, v2);
        builder.c(k3, v3);
        builder.c(k4, v4);
        return builder.f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        a builder = builder();
        builder.c(k, v);
        builder.c(k2, v2);
        builder.c(k3, v3);
        builder.c(k4, v4);
        builder.c(k5, v5);
        return builder.f();
    }
}
