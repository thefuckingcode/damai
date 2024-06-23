package kotlin.reflect.jvm.internal.pcollections;

/* compiled from: Taobao */
final class d<V> {
    private static final d<Object> b = new d<>(c.f);
    private final c<V> a;

    private d(c<V> cVar) {
        this.a = cVar;
    }

    public static <V> d<V> a() {
        return (d<V>) b;
    }

    private d<V> d(c<V> cVar) {
        if (cVar == this.a) {
            return this;
        }
        return new d<>(cVar);
    }

    public V b(int i) {
        return this.a.a((long) i);
    }

    public d<V> c(int i, V v) {
        return d(this.a.b((long) i, v));
    }
}
