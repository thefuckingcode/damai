package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
/* compiled from: Taobao */
abstract class AbstractSortedKeySortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
    AbstractSortedKeySortedSetMultimap(SortedMap<K, Collection<V>> sortedMap) {
        super(sortedMap);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
    public Set<K> createKeySet() {
        return createMaybeNavigableKeySet();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.SortedSetMultimap, com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.c, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public SortedMap<K, Collection<V>> asMap() {
        return (SortedMap) super.asMap();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public SortedMap<K, Collection<V>> backingMap() {
        return (SortedMap) super.backingMap();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    public SortedSet<K> keySet() {
        return (SortedSet) super.keySet();
    }
}
