package com.google.common.collect;

import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import tb.ds1;

/* compiled from: Taobao */
final class MultimapBuilder$TreeSetSupplier<V> implements Supplier<SortedSet<V>>, Serializable {
    private final Comparator<? super V> comparator;

    MultimapBuilder$TreeSetSupplier(Comparator<? super V> comparator2) {
        this.comparator = (Comparator) ds1.p(comparator2);
    }

    @Override // com.google.common.base.Supplier
    public SortedSet<V> get() {
        return new TreeSet(this.comparator);
    }
}
