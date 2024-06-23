package tb;

import com.taobao.alivfssdk.cache.LruCache;
import java.util.HashMap;

/* compiled from: Taobao */
public class xx0<K, V> implements LruCache<K, V> {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private final HashMap<K, ra1<K, V>> f = new HashMap<>();
    private ra1<K, V> g;
    private ra1<K, V> h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    public xx0(int i2, float f2) {
        resize(i2, f2);
    }

    private void a() {
    }

    private void c(ra1<K, V> ra1) {
        ra1<K, V> ra12 = this.h;
        if (ra12 != null) {
            ra1.a(ra12);
        }
        o(ra1, true);
    }

    private void d(ra1<K, V> ra1) {
        ra1<K, V> ra12;
        ra1<K, V> ra13 = this.g;
        if (ra13 != null) {
            ra1.a(ra13);
        } else {
            ra1.e = ra1;
            ra1.f = ra1;
        }
        boolean z = this.h == this.g;
        q(ra1, true);
        int i2 = this.e;
        if (i2 > this.b && (ra12 = this.h) != null) {
            if (z && ra12.e != ra12) {
                this.e = i2 - ra12.c;
                ra12.g = true;
            }
            n(ra12.e);
        }
    }

    private void e(ra1<K, V> ra1) {
        if (ra1 != null) {
            this.d += ra1.c;
        }
    }

    private void g(boolean z, ra1<K, V> ra1, boolean z2) {
        i(false, ra1, z2);
        f(z, ra1.a, ra1.b);
    }

    private void i(boolean z, ra1<K, V> ra1, boolean z2) {
        boolean z3;
        synchronized (this) {
            z3 = z != ra1.i;
            if (z3) {
                ra1.i = z;
                if (z) {
                    this.i += ra1.c;
                } else {
                    this.i -= ra1.c;
                }
            }
        }
        if (z3 && z2) {
            h(z, ra1.a, ra1.b);
        }
    }

    private void j(ra1<K, V> ra1) {
        if (ra1 != null) {
            int i2 = this.d;
            int i3 = ra1.c;
            this.d = i2 - i3;
            if (!ra1.g) {
                this.e -= i3;
            }
        }
    }

    private synchronized void k(boolean z) {
        ra1<K, V> ra1 = this.g;
        if (ra1 != null) {
            if (z || this.d > this.m) {
                ra1<K, V> ra12 = ra1.e;
                ra1<K, V> ra13 = ra12;
                while (this.i < this.c) {
                    if (ra13.d < 2) {
                        i(true, ra13, true);
                    }
                    ra13 = ra13.e;
                    if (ra13 == ra12) {
                        break;
                    }
                }
                this.m = this.d;
            }
        }
    }

    private void m(ra1<K, V> ra1) {
        ra1<K, V> ra12 = ra1.f;
        if (ra12 == ra1) {
            p(null);
            n(null);
        } else {
            ra12.e = ra1.e;
            ra1.e.f = ra12;
            if (this.g == ra1) {
                p(ra1.f);
            }
            if (this.h == ra1) {
                n(ra1.f);
            }
        }
        j(ra1);
    }

    private boolean n(ra1<K, V> ra1) {
        return o(ra1, false);
    }

    private boolean o(ra1<K, V> ra1, boolean z) {
        this.h = ra1;
        if (ra1 == null || this.g == ra1) {
            return false;
        }
        if (!z && !ra1.g) {
            this.e -= ra1.c;
        }
        ra1.g = true;
        return true;
    }

    private void p(ra1<K, V> ra1) {
        q(ra1, false);
    }

    private void q(ra1<K, V> ra1, boolean z) {
        if (ra1 != null) {
            if (z || ra1.g) {
                this.e += ra1.c;
            }
            ra1.g = false;
        }
        this.g = ra1;
    }

    /* access modifiers changed from: protected */
    public int b(V v) {
        throw null;
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public synchronized void clear() {
        this.f.clear();
        p(null);
        n(null);
        this.d = 0;
        this.e = 0;
        this.i = 0;
        this.m = 0;
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final synchronized int count() {
        return this.f.size();
    }

    /* access modifiers changed from: protected */
    public void f(boolean z, K k2, V v) {
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public V get(K k2) {
        ra1<K, V> ra1;
        synchronized (this) {
            ra1 = this.f.get(k2);
            if (ra1 != null) {
                int i2 = ra1.d;
                ra1.d = i2 < 0 ? 1 : i2 + 1;
            }
        }
        if (ra1 != null) {
            i(false, ra1, true);
            this.j++;
            return ra1.b;
        }
        this.k++;
        return null;
    }

    /* access modifiers changed from: protected */
    public void h(boolean z, K k2, V v) {
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final synchronized float hotPercent() {
        return ((float) this.b) / ((float) this.a);
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final synchronized boolean isEmpty() {
        return this.g == null;
    }

    /* access modifiers changed from: protected */
    public V l(K k2, boolean z) {
        ra1<K, V> remove;
        synchronized (this) {
            remove = this.f.remove(k2);
            if (remove != null) {
                remove.d = -1;
                if (remove.e != null) {
                    m(remove);
                }
            }
        }
        if (remove == null) {
            return null;
        }
        g(false, remove, z);
        return remove.b;
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final synchronized int maxSize() {
        return this.a;
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public boolean put(K k2, V v) {
        return put(17, k2, v);
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final V remove(K k2) {
        return l(k2, true);
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public void resize(int i2, float f2) {
        if (i2 < 2 || f2 < 0.0f || f2 >= 1.0f) {
            throw new RuntimeException("HotEndLruCache size parameters error");
        }
        synchronized (this) {
            this.a = i2;
            int i3 = (int) (((float) i2) * f2);
            this.b = i3;
            if (i3 < 1) {
                this.b = 1;
            } else if (i2 - i3 < 1) {
                this.b = i2 - 1;
            }
        }
        a();
        trimTo(this.a);
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final synchronized int size() {
        return this.d;
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final boolean trimTo(int i2) {
        ra1<K, V> ra1 = null;
        while (true) {
            synchronized (this) {
                boolean z = false;
                if (this.d <= i2) {
                    if (ra1 != null) {
                        z = true;
                    }
                    return z;
                }
                while (true) {
                    ra1 = this.g.e;
                    if (ra1.d < 2) {
                        break;
                    }
                    ra1.d = 1;
                    p(ra1);
                    while (true) {
                        int i3 = this.b;
                        if (i3 <= 0 || this.e <= i3 || !n(this.h.e)) {
                        }
                    }
                }
                this.f.remove(ra1.a);
                m(ra1);
                this.l++;
            }
            g(false, ra1, true);
        }
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public boolean put(int i2, K k2, V v) {
        ra1<K, V> put;
        if (k2 == null || v == null) {
            return false;
        }
        ra1<K, V> ra1 = new ra1<>(k2, v, b(v));
        if (i2 == 34) {
            ra1.d = 2;
        }
        if (ra1.c > this.a) {
            return false;
        }
        synchronized (this) {
            put = this.f.put(k2, ra1);
            if (put != null) {
                int i3 = put.d;
                m(put);
                ra1.d = i3 + 1;
            }
        }
        if (put != null) {
            g(true, put, true);
        }
        boolean trimTo = trimTo(this.a - ra1.c);
        synchronized (this) {
            if (!(this.g == null || this.h == null)) {
                if (trimTo) {
                    c(ra1);
                    e(ra1);
                }
            }
            d(ra1);
            e(ra1);
            if (this.h == null && this.d > this.b) {
                n(this.g.e);
            }
        }
        k(trimTo);
        return true;
    }
}
