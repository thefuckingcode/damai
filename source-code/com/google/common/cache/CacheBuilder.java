package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.e;
import com.google.common.base.j;
import com.google.common.cache.LocalCache;
import com.google.errorprone.annotations.CheckReturnValue;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import tb.ds1;
import tb.ke;
import tb.z7;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class CacheBuilder<K, V> {
    static final Supplier<? extends AbstractCache$StatsCounter> q = Suppliers.a(new a());
    static final ke r = new ke(0, 0, 0, 0, 0, 0);
    static final j s = new c();
    private static final Logger t = Logger.getLogger(CacheBuilder.class.getName());
    boolean a = true;
    int b = -1;
    int c = -1;
    long d = -1;
    long e = -1;
    @MonotonicNonNullDecl
    Weigher<? super K, ? super V> f;
    @MonotonicNonNullDecl
    LocalCache.Strength g;
    @MonotonicNonNullDecl
    LocalCache.Strength h;
    long i = -1;
    long j = -1;
    long k = -1;
    @MonotonicNonNullDecl
    Equivalence<Object> l;
    @MonotonicNonNullDecl
    Equivalence<Object> m;
    @MonotonicNonNullDecl
    RemovalListener<? super K, ? super V> n;
    @MonotonicNonNullDecl
    j o;
    Supplier<? extends AbstractCache$StatsCounter> p = q;

    /* compiled from: Taobao */
    enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.RemovalListener
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    /* compiled from: Taobao */
    enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.Weigher
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    /* compiled from: Taobao */
    static class a implements AbstractCache$StatsCounter {
        a() {
        }

        @Override // com.google.common.cache.AbstractCache$StatsCounter
        public void recordEviction() {
        }

        @Override // com.google.common.cache.AbstractCache$StatsCounter
        public void recordHits(int i) {
        }

        @Override // com.google.common.cache.AbstractCache$StatsCounter
        public void recordLoadException(long j) {
        }

        @Override // com.google.common.cache.AbstractCache$StatsCounter
        public void recordLoadSuccess(long j) {
        }

        @Override // com.google.common.cache.AbstractCache$StatsCounter
        public void recordMisses(int i) {
        }

        @Override // com.google.common.cache.AbstractCache$StatsCounter
        public ke snapshot() {
            return CacheBuilder.r;
        }
    }

    /* compiled from: Taobao */
    static class b implements Supplier<AbstractCache$StatsCounter> {
        b() {
        }

        /* renamed from: a */
        public AbstractCache$StatsCounter get() {
            return new a();
        }
    }

    /* compiled from: Taobao */
    static class c extends j {
        c() {
        }

        @Override // com.google.common.base.j
        public long a() {
            return 0;
        }
    }

    static {
        new b();
    }

    private CacheBuilder() {
    }

    private void c() {
        ds1.x(this.k == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void d() {
        boolean z = true;
        if (this.f == null) {
            if (this.e != -1) {
                z = false;
            }
            ds1.x(z, "maximumWeight requires weigher");
        } else if (this.a) {
            if (this.e == -1) {
                z = false;
            }
            ds1.x(z, "weigher requires maximumWeight");
        } else if (this.e == -1) {
            t.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public static CacheBuilder<Object, Object> y() {
        return new CacheBuilder<>();
    }

    /* access modifiers changed from: package-private */
    public CacheBuilder<K, V> A(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.g;
        ds1.A(strength2 == null, "Key strength was already set to %s", strength2);
        this.g = (LocalCache.Strength) ds1.p(strength);
        return this;
    }

    /* access modifiers changed from: package-private */
    public CacheBuilder<K, V> B(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.h;
        ds1.A(strength2 == null, "Value strength was already set to %s", strength2);
        this.h = (LocalCache.Strength) ds1.p(strength);
        return this;
    }

    public CacheBuilder<K, V> C(j jVar) {
        ds1.w(this.o == null);
        this.o = (j) ds1.p(jVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public CacheBuilder<K, V> D(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.m;
        ds1.A(equivalence2 == null, "value equivalence was already set to %s", equivalence2);
        this.m = (Equivalence) ds1.p(equivalence);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.cache.CacheBuilder<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> E(Weigher<? super K1, ? super V1> weigher) {
        boolean z = true;
        ds1.w(this.f == null);
        if (this.a) {
            long j2 = this.d;
            if (j2 != -1) {
                z = false;
            }
            ds1.z(z, "weigher can not be combined with maximum size", j2);
        }
        this.f = (Weigher) ds1.p(weigher);
        return this;
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> a() {
        d();
        c();
        return new LocalCache.LocalManualCache(this);
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> b(CacheLoader<? super K1, V1> cacheLoader) {
        d();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public CacheBuilder<K, V> e(int i2) {
        int i3 = this.c;
        boolean z = true;
        ds1.y(i3 == -1, "concurrency level was already set to %s", i3);
        if (i2 <= 0) {
            z = false;
        }
        ds1.d(z);
        this.c = i2;
        return this;
    }

    public CacheBuilder<K, V> f(long j2, TimeUnit timeUnit) {
        long j3 = this.j;
        boolean z = true;
        ds1.z(j3 == -1, "expireAfterAccess was already set to %s ns", j3);
        if (j2 < 0) {
            z = false;
        }
        ds1.j(z, "duration cannot be negative: %s %s", j2, timeUnit);
        this.j = timeUnit.toNanos(j2);
        return this;
    }

    public CacheBuilder<K, V> g(long j2, TimeUnit timeUnit) {
        long j3 = this.i;
        boolean z = true;
        ds1.z(j3 == -1, "expireAfterWrite was already set to %s ns", j3);
        if (j2 < 0) {
            z = false;
        }
        ds1.j(z, "duration cannot be negative: %s %s", j2, timeUnit);
        this.i = timeUnit.toNanos(j2);
        return this;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        int i2 = this.c;
        if (i2 == -1) {
            return 4;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public long i() {
        long j2 = this.j;
        if (j2 == -1) {
            return 0;
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public long j() {
        long j2 = this.i;
        if (j2 == -1) {
            return 0;
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        int i2 = this.b;
        if (i2 == -1) {
            return 16;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public Equivalence<Object> l() {
        return (Equivalence) e.a(this.l, m().defaultEquivalence());
    }

    /* access modifiers changed from: package-private */
    public LocalCache.Strength m() {
        return (LocalCache.Strength) e.a(this.g, LocalCache.Strength.STRONG);
    }

    /* access modifiers changed from: package-private */
    public long n() {
        if (this.i == 0 || this.j == 0) {
            return 0;
        }
        return this.f == null ? this.d : this.e;
    }

    /* access modifiers changed from: package-private */
    public long o() {
        long j2 = this.k;
        if (j2 == -1) {
            return 0;
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> p() {
        return (RemovalListener) e.a(this.n, NullListener.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public Supplier<? extends AbstractCache$StatsCounter> q() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public j r(boolean z) {
        j jVar = this.o;
        if (jVar != null) {
            return jVar;
        }
        return z ? j.b() : s;
    }

    /* access modifiers changed from: package-private */
    public Equivalence<Object> s() {
        return (Equivalence) e.a(this.m, t().defaultEquivalence());
    }

    /* access modifiers changed from: package-private */
    public LocalCache.Strength t() {
        return (LocalCache.Strength) e.a(this.h, LocalCache.Strength.STRONG);
    }

    public String toString() {
        e.b b2 = e.b(this);
        int i2 = this.b;
        if (i2 != -1) {
            b2.b("initialCapacity", i2);
        }
        int i3 = this.c;
        if (i3 != -1) {
            b2.b("concurrencyLevel", i3);
        }
        long j2 = this.d;
        if (j2 != -1) {
            b2.c("maximumSize", j2);
        }
        long j3 = this.e;
        if (j3 != -1) {
            b2.c("maximumWeight", j3);
        }
        if (this.i != -1) {
            b2.d("expireAfterWrite", this.i + NotificationStyle.NOTIFICATION_STYLE);
        }
        if (this.j != -1) {
            b2.d("expireAfterAccess", this.j + NotificationStyle.NOTIFICATION_STYLE);
        }
        LocalCache.Strength strength = this.g;
        if (strength != null) {
            b2.d("keyStrength", z7.c(strength.toString()));
        }
        LocalCache.Strength strength2 = this.h;
        if (strength2 != null) {
            b2.d("valueStrength", z7.c(strength2.toString()));
        }
        if (this.l != null) {
            b2.h("keyEquivalence");
        }
        if (this.m != null) {
            b2.h("valueEquivalence");
        }
        if (this.n != null) {
            b2.h("removalListener");
        }
        return b2.toString();
    }

    /* access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> Weigher<K1, V1> u() {
        return (Weigher) e.a(this.f, OneWeigher.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public CacheBuilder<K, V> v(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.l;
        ds1.A(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.l = (Equivalence) ds1.p(equivalence);
        return this;
    }

    public CacheBuilder<K, V> w(long j2) {
        long j3 = this.d;
        boolean z = true;
        ds1.z(j3 == -1, "maximum size was already set to %s", j3);
        long j4 = this.e;
        ds1.z(j4 == -1, "maximum weight was already set to %s", j4);
        ds1.x(this.f == null, "maximum size can not be combined with weigher");
        if (j2 < 0) {
            z = false;
        }
        ds1.e(z, "maximum size must not be negative");
        this.d = j2;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> x(long j2) {
        long j3 = this.e;
        boolean z = true;
        ds1.z(j3 == -1, "maximum weight was already set to %s", j3);
        long j4 = this.d;
        ds1.z(j4 == -1, "maximum size was already set to %s", j4);
        this.e = j2;
        if (j2 < 0) {
            z = false;
        }
        ds1.e(z, "maximum weight must not be negative");
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.cache.CacheBuilder<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> z(RemovalListener<? super K1, ? super V1> removalListener) {
        ds1.w(this.n == null);
        this.n = (RemovalListener) ds1.p(removalListener);
        return this;
    }
}
