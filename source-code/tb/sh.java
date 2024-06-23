package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class sh {
    private final boolean a;

    /* compiled from: Taobao */
    public static final class a extends sh {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
            super(false, null);
        }
    }

    /* compiled from: Taobao */
    public static final class b extends sh {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull String str) {
            super(false, null);
            k21.i(str, "error");
        }
    }

    /* compiled from: Taobao */
    public static final class c extends sh {
        @NotNull
        public static final c INSTANCE = new c();

        private c() {
            super(true, null);
        }
    }

    private sh(boolean z) {
        this.a = z;
    }

    public /* synthetic */ sh(boolean z, m40 m40) {
        this(z);
    }

    public final boolean a() {
        return this.a;
    }
}
