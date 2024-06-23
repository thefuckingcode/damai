package tb;

public final class fh<T> {
    public static final b Companion = new b(null);
    private static final c b = new c();
    private final Object a;

    public static final class a extends c {
        public final Throwable a;

        public a(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && k21.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // tb.fh.c
        public String toString() {
            return "Closed(" + this.a + ')';
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }

        public final <E> Object a(Throwable th) {
            return fh.c(new a(th));
        }

        public final <E> Object b() {
            return fh.c(fh.b);
        }

        public final <E> Object c(E e) {
            return fh.c(e);
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ fh(Object obj) {
        this.a = obj;
    }

    public static final /* synthetic */ fh b(Object obj) {
        return new fh(obj);
    }

    public static <T> Object c(Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof fh) && k21.d(obj, ((fh) obj2).l());
    }

    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar == null) {
            return null;
        }
        return aVar.a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static final T f(Object obj) {
        if (!(obj instanceof c)) {
            return obj;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static final T g(Object obj) {
        Throwable th;
        if (!(obj instanceof c)) {
            return obj;
        }
        if (!(obj instanceof a) || (th = ((a) obj).a) == null) {
            throw new IllegalStateException(k21.r("Trying to call 'getOrThrow' on a failed channel result: ", obj).toString());
        }
        throw th;
    }

    public static int h(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean i(Object obj) {
        return obj instanceof a;
    }

    public static final boolean j(Object obj) {
        return !(obj instanceof c);
    }

    public static String k(Object obj) {
        if (obj instanceof a) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(l(), obj);
    }

    public int hashCode() {
        return h(l());
    }

    public final /* synthetic */ Object l() {
        return this.a;
    }

    public String toString() {
        return k(l());
    }
}
