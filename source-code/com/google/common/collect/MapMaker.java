package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.e;
import com.google.common.collect.MapMakerInternalMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import tb.ds1;
import tb.z7;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class MapMaker {
    boolean a;
    int b = -1;
    int c = -1;
    @MonotonicNonNullDecl
    MapMakerInternalMap.Strength d;
    @MonotonicNonNullDecl
    MapMakerInternalMap.Strength e;
    @MonotonicNonNullDecl
    Equivalence<Object> f;

    /* compiled from: Taobao */
    enum Dummy {
        VALUE
    }

    @CanIgnoreReturnValue
    public MapMaker a(int i) {
        int i2 = this.c;
        boolean z = true;
        ds1.y(i2 == -1, "concurrency level was already set to %s", i2);
        if (i <= 0) {
            z = false;
        }
        ds1.d(z);
        this.c = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        int i = this.c;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        int i = this.b;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public Equivalence<Object> d() {
        return (Equivalence) e.a(this.f, e().defaultEquivalence());
    }

    /* access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) e.a(this.d, MapMakerInternalMap.Strength.STRONG);
    }

    /* access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) e.a(this.e, MapMakerInternalMap.Strength.STRONG);
    }

    @CanIgnoreReturnValue
    public MapMaker g(int i) {
        int i2 = this.b;
        boolean z = true;
        ds1.y(i2 == -1, "initial capacity was already set to %s", i2);
        if (i < 0) {
            z = false;
        }
        ds1.d(z);
        this.b = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker h(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f;
        ds1.A(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f = (Equivalence) ds1.p(equivalence);
        this.a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        if (!this.a) {
            return new ConcurrentHashMap(c(), 0.75f, b());
        }
        return MapMakerInternalMap.create(this);
    }

    /* access modifiers changed from: package-private */
    public MapMaker j(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.d;
        ds1.A(strength2 == null, "Key strength was already set to %s", strength2);
        this.d = (MapMakerInternalMap.Strength) ds1.p(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.a = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public MapMaker k(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.e;
        ds1.A(strength2 == null, "Value strength was already set to %s", strength2);
        this.e = (MapMakerInternalMap.Strength) ds1.p(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.a = true;
        }
        return this;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker l() {
        return j(MapMakerInternalMap.Strength.WEAK);
    }

    public String toString() {
        e.b b2 = e.b(this);
        int i = this.b;
        if (i != -1) {
            b2.b("initialCapacity", i);
        }
        int i2 = this.c;
        if (i2 != -1) {
            b2.b("concurrencyLevel", i2);
        }
        MapMakerInternalMap.Strength strength = this.d;
        if (strength != null) {
            b2.d("keyStrength", z7.c(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.e;
        if (strength2 != null) {
            b2.d("valueStrength", z7.c(strength2.toString()));
        }
        if (this.f != null) {
            b2.h("keyEquivalence");
        }
        return b2.toString();
    }
}
