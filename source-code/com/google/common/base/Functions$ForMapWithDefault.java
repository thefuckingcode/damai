package com.google.common.base;

import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;
import tb.rk1;

/* compiled from: Taobao */
class Functions$ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    @NullableDecl
    final V defaultValue;
    final Map<K, ? extends V> map;

    Functions$ForMapWithDefault(Map<K, ? extends V> map2, @NullableDecl V v) {
        this.map = (Map) ds1.p(map2);
        this.defaultValue = v;
    }

    @Override // com.google.common.base.Function
    public V apply(@NullableDecl K k) {
        V v = (V) this.map.get(k);
        return (v != null || this.map.containsKey(k)) ? v : this.defaultValue;
    }

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof Functions$ForMapWithDefault)) {
            return false;
        }
        Functions$ForMapWithDefault functions$ForMapWithDefault = (Functions$ForMapWithDefault) obj;
        if (!this.map.equals(functions$ForMapWithDefault.map) || !rk1.a(this.defaultValue, functions$ForMapWithDefault.defaultValue)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return rk1.b(this.map, this.defaultValue);
    }

    public String toString() {
        return "Functions.forMap(" + this.map + ", defaultValue=" + ((Object) this.defaultValue) + jl1.BRACKET_END_STR;
    }
}
