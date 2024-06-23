package tb;

/* compiled from: Taobao */
public class x70 {
    private String a;
    private ew2 b;
    private Object c;
    private Object d;
    private Object e;

    /* compiled from: Taobao */
    public static final class b {
        private String a = "default";
        private ew2 b;
        private Object c;
        private Object d;
        private Object e;

        public x70 f() {
            return new x70(this);
        }

        public b g(Object obj) {
            this.e = obj;
            return this;
        }

        public b h(Object obj) {
            this.c = obj;
            return this;
        }

        public b i(String str) {
            this.a = str;
            return this;
        }

        public b j(Object obj) {
            this.d = obj;
            return this;
        }

        public b k(ew2 ew2) {
            this.b = ew2;
            return this;
        }
    }

    public Object a() {
        return this.e;
    }

    public Object b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public Object d() {
        return this.d;
    }

    public ew2 e() {
        return this.b;
    }

    public void f(Object obj) {
        this.e = obj;
    }

    private x70(b bVar) {
        this.a = "default";
        this.a = bVar.a;
        this.e = bVar.e;
        this.c = bVar.c;
        this.d = bVar.d;
        this.b = bVar.b;
    }
}
