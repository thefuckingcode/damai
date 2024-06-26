package com.google.common.collect;

import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Set;

/* compiled from: Taobao */
final class MultimapBuilder$LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
    private final int expectedValuesPerKey;

    MultimapBuilder$LinkedHashSetSupplier(int i) {
        this.expectedValuesPerKey = k.b(i, "expectedValuesPerKey");
    }

    @Override // com.google.common.base.Supplier
    public Set<V> get() {
        return e0.f(this.expectedValuesPerKey);
    }
}
