package tb;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* compiled from: Taobao */
public abstract class zk {
    private static final zk a = new a();
    private static final zk b = new b(-1);
    private static final zk c = new b(1);

    /* compiled from: Taobao */
    static class a extends zk {
        a() {
            super(null);
        }

        @Override // tb.zk
        public zk d(Comparable comparable, Comparable comparable2) {
            return g(comparable.compareTo(comparable2));
        }

        @Override // tb.zk
        public int e() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public zk g(int i) {
            if (i < 0) {
                return zk.b;
            }
            return i > 0 ? zk.c : zk.a;
        }
    }

    /* compiled from: Taobao */
    private static final class b extends zk {
        final int d;

        b(int i) {
            super(null);
            this.d = i;
        }

        @Override // tb.zk
        public zk d(@NullableDecl Comparable comparable, @NullableDecl Comparable comparable2) {
            return this;
        }

        @Override // tb.zk
        public int e() {
            return this.d;
        }
    }

    /* synthetic */ zk(a aVar) {
        this();
    }

    public static zk f() {
        return a;
    }

    public abstract zk d(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract int e();

    private zk() {
    }
}
