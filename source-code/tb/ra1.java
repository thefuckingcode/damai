package tb;

/* compiled from: Taobao */
public class ra1<K, V> {
    public K a;
    public V b;
    public int c;
    public int d;
    public ra1<K, V> e;
    public ra1<K, V> f;
    public boolean g;
    public boolean h;
    public boolean i;

    public ra1(K k, V v, int i2) {
        b(k, v, i2);
    }

    public void a(ra1<K, V> ra1) {
        ra1<K, V> ra12 = this.e;
        if (!(ra12 == null || ra12 == this)) {
            ra12.f = this.f;
        }
        ra1<K, V> ra13 = this.f;
        if (!(ra13 == null || ra13 == this)) {
            ra13.e = ra12;
        }
        this.f = ra1;
        ra1<K, V> ra14 = ra1.e;
        if (ra14 != null) {
            ra14.f = this;
        }
        this.e = ra14;
        ra1.e = this;
    }

    public void b(K k, V v, int i2) {
        this.a = k;
        this.b = v;
        this.d = 1;
        this.c = i2;
    }

    public String toString() {
        return "LruNode@" + hashCode() + "[key:" + ((Object) this.a) + ", value:" + ((Object) this.b) + ", visitCount:" + this.d + ", size:" + this.c + ", isColdNode:" + this.g + ", unlinked:" + this.h + jl1.ARRAY_END_STR;
    }
}
