package tb;

import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class ao0 {
    @NotNull
    public static final b Companion = new b(null);

    /* compiled from: Taobao */
    public static final class a extends ao0 {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }

        @Nullable
        public final ao0 a(@NotNull String str) {
            k21.i(str, "backdropFilter");
            if (k21.d(str, "none")) {
                return c.INSTANCE;
            }
            if (StringsKt__StringsKt.Q(str, "blur", false, 2, null)) {
                return a.INSTANCE;
            }
            return null;
        }
    }

    /* compiled from: Taobao */
    public static final class c extends ao0 {
        @NotNull
        public static final c INSTANCE = new c();

        private c() {
            super(null);
        }
    }

    private ao0() {
    }

    public /* synthetic */ ao0(m40 m40) {
        this();
    }
}
