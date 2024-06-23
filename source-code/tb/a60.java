package tb;

import org.jetbrains.annotations.NotNull;
import tb.b60;

/* compiled from: Taobao */
public abstract class a60 {

    /* compiled from: Taobao */
    public static final class a extends a60 {
        @NotNull
        public static final a INSTANCE = new a();
        private static final int a;

        static {
            b60.a aVar = b60.Companion;
            a = (~(aVar.k() | aVar.e())) & aVar.b();
        }

        private a() {
        }

        @Override // tb.a60
        public int a() {
            return a;
        }
    }

    /* compiled from: Taobao */
    public static final class b extends a60 {
        @NotNull
        public static final b INSTANCE = new b();

        private b() {
        }

        @Override // tb.a60
        public int a() {
            return 0;
        }
    }

    public abstract int a();

    public String toString() {
        return getClass().getSimpleName();
    }
}
