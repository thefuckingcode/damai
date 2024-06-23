package tb;

import com.taobao.phenix.cache.LruCache;
import java.util.HashMap;

/* compiled from: Taobao */
public class wx0<K, V> implements LruCache<K, V> {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private HashMap<K, qa1<K, V>> f = new HashMap<>();
    private qa1<K, V> g;
    private qa1<K, V> h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    public wx0(int i2, float f2) {
        resize(i2, f2);
    }

    private void b(qa1<K, V> qa1, boolean z, boolean z2, boolean z3) {
        boolean z4;
        synchronized (this) {
            z4 = z != qa1.i;
            if (z4) {
                qa1.i = z;
                if (z) {
                    this.i += qa1.c;
                } else {
                    this.i -= qa1.c;
                }
            }
        }
        if (z4 && z2) {
            l(z, qa1.a, qa1.b, z3);
        }
    }

    private void c() {
        boolean z = this.c < this.a;
        cs1.b(z, "MAX_PRE_EVICTED_SIZE(" + this.c + ") must lower than MAX_LIMIT_SIZE(" + this.a + jl1.BRACKET_END_STR);
    }

    private void f(qa1<K, V> qa1) {
        qa1<K, V> qa12 = this.h;
        if (qa12 != null) {
            qa1.a(qa12);
        }
        r(qa1, true);
    }

    private void g(qa1<K, V> qa1) {
        qa1<K, V> qa12;
        qa1<K, V> qa13 = this.g;
        if (qa13 != null) {
            qa1.a(qa13);
        } else {
            qa1.e = qa1;
            qa1.f = qa1;
        }
        boolean z = this.h == this.g;
        t(qa1, true);
        int i2 = this.e;
        if (i2 > this.b && (qa12 = this.h) != null) {
            if (z && qa12.e != qa12) {
                this.e = i2 - qa12.c;
                qa12.g = true;
            }
            q(qa12.e);
        }
    }

    private void i(qa1<K, V> qa1) {
        if (qa1 != null) {
            this.d += qa1.c;
        }
    }

    private void k(boolean z, qa1<K, V> qa1, boolean z2) {
        b(qa1, false, z2, true);
        j(z, qa1.a, qa1.b);
    }

    private void m(qa1<K, V> qa1) {
        if (qa1 != null) {
            int i2 = this.d;
            int i3 = qa1.c;
            this.d = i2 - i3;
            if (!qa1.g) {
                this.e -= i3;
            }
        }
    }

    private synchronized void n(boolean z) {
        qa1<K, V> qa1 = this.g;
        if (qa1 != null) {
            if (z || this.d > this.m) {
                qa1<K, V> qa12 = qa1.e;
                qa1<K, V> qa13 = qa12;
                while (this.i < this.c) {
                    if (qa13.d < 2) {
                        b(qa13, true, true, false);
                    }
                    qa13 = qa13.e;
                    if (qa13 == qa12) {
                        break;
                    }
                }
                this.m = this.d;
            }
        }
    }

    private void p(qa1<K, V> qa1) {
        qa1<K, V> qa12 = qa1.f;
        if (qa12 == qa1) {
            s(null);
            q(null);
        } else {
            qa12.e = qa1.e;
            qa1.e.f = qa12;
            if (this.g == qa1) {
                s(qa1.f);
            }
            if (this.h == qa1) {
                q(qa1.f);
            }
        }
        m(qa1);
    }

    private boolean q(qa1<K, V> qa1) {
        return r(qa1, false);
    }

    private boolean r(qa1<K, V> qa1, boolean z) {
        this.h = qa1;
        if (qa1 == null || this.g == qa1) {
            return false;
        }
        if (!z && !qa1.g) {
            this.e -= qa1.c;
        }
        qa1.g = true;
        return true;
    }

    private void s(qa1<K, V> qa1) {
        t(qa1, false);
    }

    private void t(qa1<K, V> qa1, boolean z) {
        if (qa1 != null) {
            if (z || qa1.g) {
                this.e += qa1.c;
            }
            qa1.g = false;
        }
        this.g = qa1;
    }

    public void a(String str) {
        if (kg0.g(3)) {
            int i2 = this.j;
            vr2.a(str, "%K(%K)/%K, pre-evicted:%K/%K, rate:%.1f%%, count:%d, hits:%d, misses:%d, evicts:%d", Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.a), Integer.valueOf(this.i), Integer.valueOf(this.c), Float.valueOf((((float) i2) * 100.0f) / ((float) (i2 + this.k))), Integer.valueOf(count()), Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l));
        }
    }

    @Override // com.taobao.phenix.cache.LruCache
    public synchronized void clear() {
        this.f.clear();
        s(null);
        q(null);
        this.d = 0;
        this.e = 0;
        this.i = 0;
        this.m = 0;
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final synchronized int count() {
        return this.f.size();
    }

    public final synchronized boolean d(K k2) {
        return this.f.containsKey(k2);
    }

    /* access modifiers changed from: protected */
    public int e(V v) {
        throw null;
    }

    @Override // com.taobao.phenix.cache.LruCache
    public V get(K k2) {
        qa1<K, V> qa1;
        synchronized (this) {
            qa1 = this.f.get(k2);
            if (qa1 != null) {
                int i2 = qa1.d;
                qa1.d = i2 < 0 ? 1 : i2 + 1;
            }
        }
        if (qa1 != null) {
            b(qa1, false, true, false);
            this.j++;
            return qa1.b;
        }
        this.k++;
        return null;
    }

    /* access modifiers changed from: protected */
    public final synchronized int h() {
        return this.c;
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final synchronized float hotPercent() {
        return ((float) this.b) / ((float) this.a);
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final synchronized boolean isEmpty() {
        return this.g == null;
    }

    /* access modifiers changed from: protected */
    public void j(boolean z, K k2, V v) {
    }

    /* access modifiers changed from: protected */
    public void l(boolean z, K k2, V v, boolean z2) {
        throw null;
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final synchronized int maxSize() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public V o(K k2, boolean z) {
        qa1<K, V> remove;
        synchronized (this) {
            remove = this.f.remove(k2);
            if (remove != null) {
                remove.d = -1;
                if (remove.e != null) {
                    p(remove);
                }
            }
        }
        if (remove == null) {
            return null;
        }
        k(false, remove, z);
        return remove.b;
    }

    @Override // com.taobao.phenix.cache.LruCache
    public boolean put(K k2, V v) {
        return put(17, k2, v);
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final V remove(K k2) {
        return o(k2, true);
    }

    @Override // com.taobao.phenix.cache.LruCache
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
        c();
        trimTo(this.a);
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final synchronized int size() {
        return this.d;
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final boolean trimTo(int i2) {
        qa1<K, V> qa1 = null;
        while (true) {
            synchronized (this) {
                boolean z = false;
                if (this.d <= i2) {
                    if (qa1 != null) {
                        z = true;
                    }
                    return z;
                }
                while (true) {
                    qa1 = this.g.e;
                    if (qa1.d < 2) {
                        break;
                    }
                    qa1.d = 1;
                    s(qa1);
                    while (true) {
                        int i3 = this.b;
                        if (i3 <= 0 || this.e <= i3 || !q(this.h.e)) {
                        }
                    }
                }
                this.f.remove(qa1.a);
                p(qa1);
                this.l++;
            }
            k(false, qa1, true);
        }
    }

    public synchronized void u(int i2) {
        this.c = i2;
        c();
        n(true);
    }

    @Override // com.taobao.phenix.cache.LruCache
    public boolean put(int i2, K k2, V v) {
        qa1<K, V> put;
        if (k2 == null || v == null) {
            return false;
        }
        qa1<K, V> qa1 = new qa1<>(k2, v, e(v));
        if (i2 == 34) {
            qa1.d = 2;
        }
        if (qa1.c > this.a) {
            return false;
        }
        synchronized (this) {
            put = this.f.put(k2, qa1);
            if (put != null) {
                int i3 = put.d;
                p(put);
                qa1.d = i3 + 1;
            }
        }
        if (put != null) {
            k(true, put, true);
        }
        boolean trimTo = trimTo(this.a - qa1.c);
        synchronized (this) {
            if (!(this.g == null || this.h == null)) {
                if (trimTo) {
                    f(qa1);
                    i(qa1);
                }
            }
            g(qa1);
            i(qa1);
            if (this.h == null && this.d > this.b) {
                q(this.g.e);
            }
        }
        n(trimTo);
        return true;
    }
}
