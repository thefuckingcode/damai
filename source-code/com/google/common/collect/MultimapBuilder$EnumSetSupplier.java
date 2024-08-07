package com.google.common.collect;

import com.google.common.base.Supplier;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumSet;
import java.util.Set;
import tb.ds1;

/* compiled from: Taobao */
final class MultimapBuilder$EnumSetSupplier<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {
    private final Class<V> clazz;

    MultimapBuilder$EnumSetSupplier(Class<V> cls) {
        this.clazz = (Class) ds1.p(cls);
    }

    @Override // com.google.common.base.Supplier
    public Set<V> get() {
        return EnumSet.noneOf(this.clazz);
    }
}
