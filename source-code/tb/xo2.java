package tb;

import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class xo2 {
    @NotNull
    public static final b Companion = new b(null);
    @JvmField
    @NotNull
    public static final xo2 EMPTY = new a();

    /* compiled from: Taobao */
    public static final class a extends xo2 {
        a() {
        }

        @Override // tb.xo2
        public /* bridge */ /* synthetic */ TypeProjection e(g61 g61) {
            return (TypeProjection) h(g61);
        }

        @Override // tb.xo2
        public boolean f() {
            return true;
        }

        @Nullable
        public Void h(@NotNull g61 g61) {
            k21.i(g61, "key");
            return null;
        }

        @NotNull
        public String toString() {
            return "Empty TypeSubstitution";
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    @NotNull
    public final TypeSubstitutor c() {
        TypeSubstitutor g = TypeSubstitutor.g(this);
        k21.h(g, "create(this)");
        return g;
    }

    @NotNull
    public Annotations d(@NotNull Annotations annotations) {
        k21.i(annotations, "annotations");
        return annotations;
    }

    @Nullable
    public abstract TypeProjection e(@NotNull g61 g61);

    public boolean f() {
        return false;
    }

    @NotNull
    public g61 g(@NotNull g61 g61, @NotNull Variance variance) {
        k21.i(g61, "topLevelType");
        k21.i(variance, "position");
        return g61;
    }
}
