package tb;

import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class j51 {
    @NotNull
    public static final b Companion = new b(null);
    @NotNull
    private static final d a = new d(JvmPrimitiveType.BOOLEAN);
    @NotNull
    private static final d b = new d(JvmPrimitiveType.CHAR);
    @NotNull
    private static final d c = new d(JvmPrimitiveType.BYTE);
    @NotNull
    private static final d d = new d(JvmPrimitiveType.SHORT);
    @NotNull
    private static final d e = new d(JvmPrimitiveType.INT);
    @NotNull
    private static final d f = new d(JvmPrimitiveType.FLOAT);
    @NotNull
    private static final d g = new d(JvmPrimitiveType.LONG);
    @NotNull
    private static final d h = new d(JvmPrimitiveType.DOUBLE);

    /* compiled from: Taobao */
    public static final class a extends j51 {
        @NotNull
        private final j51 i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull j51 j51) {
            super(null);
            k21.i(j51, "elementType");
            this.i = j51;
        }

        @NotNull
        public final j51 i() {
            return this.i;
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }

        @NotNull
        public final d a() {
            return j51.a;
        }

        @NotNull
        public final d b() {
            return j51.c;
        }

        @NotNull
        public final d c() {
            return j51.b;
        }

        @NotNull
        public final d d() {
            return j51.h;
        }

        @NotNull
        public final d e() {
            return j51.f;
        }

        @NotNull
        public final d f() {
            return j51.e;
        }

        @NotNull
        public final d g() {
            return j51.g;
        }

        @NotNull
        public final d h() {
            return j51.d;
        }
    }

    /* compiled from: Taobao */
    public static final class c extends j51 {
        @NotNull
        private final String i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(@NotNull String str) {
            super(null);
            k21.i(str, "internalName");
            this.i = str;
        }

        @NotNull
        public final String i() {
            return this.i;
        }
    }

    /* compiled from: Taobao */
    public static final class d extends j51 {
        @Nullable
        private final JvmPrimitiveType i;

        public d(@Nullable JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.i = jvmPrimitiveType;
        }

        @Nullable
        public final JvmPrimitiveType i() {
            return this.i;
        }
    }

    private j51() {
    }

    public /* synthetic */ j51(m40 m40) {
        this();
    }

    @NotNull
    public String toString() {
        return k51.INSTANCE.toString(this);
    }
}
