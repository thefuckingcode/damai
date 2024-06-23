package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtCompatible
/* compiled from: Taobao */
public abstract class w<K, V> extends q<K, V> implements SortedMap<K, V> {
    protected w() {
    }

    private int unsafeCompare(Object obj, Object obj2) {
        Comparator<? super K> comparator = comparator();
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Object delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Map delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
    public abstract SortedMap<K, V> delegate();

    @Override // java.util.SortedMap
    public K firstKey() {
        return delegate().firstKey();
    }

    @Override // java.util.SortedMap
    public abstract SortedMap<K, V> headMap(K k);

    @Override // java.util.SortedMap
    public K lastKey() {
        return delegate().lastKey();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.q
    @Beta
    public boolean standardContainsKey(@NullableDecl Object obj) {
        try {
            if (unsafeCompare(tailMap(obj).firstKey(), obj) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Beta
    public SortedMap<K, V> standardSubMap(K k, K k2) {
        ds1.e(unsafeCompare(k, k2) <= 0, "fromKey must be <= toKey");
        return tailMap(k).headMap(k2);
    }

    @Override // java.util.SortedMap
    public abstract SortedMap<K, V> subMap(K k, K k2);

    @Override // java.util.SortedMap
    public abstract SortedMap<K, V> tailMap(K k);
}
