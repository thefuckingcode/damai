package tb;

import cn.damai.common.app.ShareperfenceConstants;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class v80 extends xo2 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final xo2 a;
    @NotNull
    private final xo2 b;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @JvmStatic
        @NotNull
        public final xo2 a(@NotNull xo2 xo2, @NotNull xo2 xo22) {
            k21.i(xo2, ShareperfenceConstants.FIRST);
            k21.i(xo22, "second");
            if (xo2.f()) {
                return xo22;
            }
            if (xo22.f()) {
                return xo2;
            }
            return new v80(xo2, xo22, null);
        }
    }

    private v80(xo2 xo2, xo2 xo22) {
        this.a = xo2;
        this.b = xo22;
    }

    public /* synthetic */ v80(xo2 xo2, xo2 xo22, m40 m40) {
        this(xo2, xo22);
    }

    @JvmStatic
    @NotNull
    public static final xo2 h(@NotNull xo2 xo2, @NotNull xo2 xo22) {
        return Companion.a(xo2, xo22);
    }

    @Override // tb.xo2
    public boolean a() {
        return this.a.a() || this.b.a();
    }

    @Override // tb.xo2
    public boolean b() {
        return this.a.b() || this.b.b();
    }

    @Override // tb.xo2
    @NotNull
    public Annotations d(@NotNull Annotations annotations) {
        k21.i(annotations, "annotations");
        return this.b.d(this.a.d(annotations));
    }

    @Override // tb.xo2
    @Nullable
    public TypeProjection e(@NotNull g61 g61) {
        k21.i(g61, "key");
        TypeProjection e = this.a.e(g61);
        return e == null ? this.b.e(g61) : e;
    }

    @Override // tb.xo2
    public boolean f() {
        return false;
    }

    @Override // tb.xo2
    @NotNull
    public g61 g(@NotNull g61 g61, @NotNull Variance variance) {
        k21.i(g61, "topLevelType");
        k21.i(variance, "position");
        return this.b.g(this.a.g(g61, variance), variance);
    }
}
