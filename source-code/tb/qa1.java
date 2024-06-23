package tb;

/* compiled from: Taobao */
public class qa1<K, V> {
    public K a;
    public V b;
    public int c;
    public int d;
    public qa1<K, V> e;
    public qa1<K, V> f;
    public boolean g;
    public boolean h;
    public boolean i;

    public qa1(K k, V v, int i2) {
        b(k, v, i2);
    }

    public void a(qa1<K, V> qa1) {
        qa1<K, V> qa12 = this.e;
        if (!(qa12 == null || qa12 == this)) {
            qa12.f = this.f;
        }
        qa1<K, V> qa13 = this.f;
        if (!(qa13 == null || qa13 == this)) {
            qa13.e = qa12;
        }
        this.f = qa1;
        qa1<K, V> qa14 = qa1.e;
        if (qa14 != null) {
            qa14.f = this;
        }
        this.e = qa14;
        qa1.e = this;
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
