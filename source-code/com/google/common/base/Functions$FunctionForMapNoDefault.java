package com.google.common.base;

import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

/* compiled from: Taobao */
class Functions$FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    final Map<K, V> map;

    Functions$FunctionForMapNoDefault(Map<K, V> map2) {
        this.map = (Map) ds1.p(map2);
    }

    @Override // com.google.common.base.Function
    public V apply(@NullableDecl K k) {
        V v = this.map.get(k);
        ds1.k(v != null || this.map.containsKey(k), "Key '%s' not present in map", k);
        return v;
    }

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof Functions$FunctionForMapNoDefault) {
            return this.map.equals(((Functions$FunctionForMapNoDefault) obj).map);
        }
        return false;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return "Functions.forMap(" + this.map + jl1.BRACKET_END_STR;
    }
}
