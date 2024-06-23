package tb;

import androidx.core.app.FrameMetricsAggregator;
import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ro2 {
    @JvmField
    @NotNull
    public static final ro2 CLASS_DECLARATION;
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    @NotNull
    public static final ro2 DEFAULT;
    @JvmField
    @NotNull
    public static final ro2 DEFAULT_UAST;
    @JvmField
    @NotNull
    public static final ro2 GENERIC_ARGUMENT;
    @JvmField
    @NotNull
    public static final ro2 GENERIC_ARGUMENT_UAST;
    @JvmField
    @NotNull
    public static final ro2 RETURN_TYPE_BOXED = new ro2(false, true, false, false, false, null, false, null, null, false, 1021, null);
    @JvmField
    @NotNull
    public static final ro2 SUPER_TYPE;
    @JvmField
    @NotNull
    public static final ro2 SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS;
    @JvmField
    @NotNull
    public static final ro2 VALUE_FOR_ANNOTATION;
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    @Nullable
    private final ro2 f;
    private final boolean g;
    @Nullable
    private final ro2 h;
    @Nullable
    private final ro2 i;
    private final boolean j;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            iArr[Variance.INVARIANT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        ro2 ro2 = new ro2(false, false, false, false, false, null, false, null, null, false, 1023, null);
        GENERIC_ARGUMENT = ro2;
        ro2 ro22 = new ro2(false, false, false, false, false, null, false, null, null, true, FrameMetricsAggregator.EVERY_DURATION, null);
        GENERIC_ARGUMENT_UAST = ro22;
        DEFAULT = new ro2(false, false, false, false, false, ro2, false, null, null, false, 988, null);
        DEFAULT_UAST = new ro2(false, false, false, false, false, ro22, false, null, null, true, 476, null);
        CLASS_DECLARATION = new ro2(false, true, false, false, false, ro2, false, null, null, false, 988, null);
        SUPER_TYPE = new ro2(false, false, false, true, false, ro2, false, null, null, false, 983, null);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new ro2(false, false, false, true, false, ro2, false, null, null, false, 919, null);
        VALUE_FOR_ANNOTATION = new ro2(false, false, true, false, false, ro2, false, null, null, false, 984, null);
    }

    public ro2(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, @Nullable ro2 ro2, boolean z6, @Nullable ro2 ro22, @Nullable ro2 ro23, boolean z7) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = ro2;
        this.g = z6;
        this.h = ro22;
        this.i = ro23;
        this.j = z7;
    }

    public final boolean a() {
        return this.g;
    }

    public final boolean b() {
        return this.j;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean d() {
        return this.a;
    }

    public final boolean e() {
        return this.c;
    }

    @NotNull
    public final ro2 f(@NotNull Variance variance, boolean z) {
        k21.i(variance, "effectiveVariance");
        if (!z || !this.c) {
            int i2 = b.$EnumSwitchMapping$0[variance.ordinal()];
            if (i2 == 1) {
                ro2 ro2 = this.h;
                if (ro2 != null) {
                    return ro2;
                }
            } else if (i2 != 2) {
                ro2 ro22 = this.f;
                if (ro22 != null) {
                    return ro22;
                }
            } else {
                ro2 ro23 = this.i;
                if (ro23 != null) {
                    return ro23;
                }
            }
        }
        return this;
    }

    @NotNull
    public final ro2 g() {
        return new ro2(this.a, true, this.c, this.d, this.e, this.f, this.g, this.h, this.i, false, 512, null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ ro2(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, ro2 ro2, boolean z6, ro2 ro22, ro2 ro23, boolean z7, int i2, m40 m40) {
        this(r1, r3, r4, r6, r7, r8, (i2 & 64) == 0 ? z6 : r2, (i2 & 128) != 0 ? r8 : ro22, (i2 & 256) != 0 ? r8 : ro23, (i2 & 512) == 0 ? z7 : r5);
        boolean z8 = true;
        boolean z9 = (i2 & 1) != 0 ? true : z;
        boolean z10 = (i2 & 2) != 0 ? true : z2;
        boolean z11 = false;
        boolean z12 = (i2 & 4) != 0 ? false : z3;
        boolean z13 = (i2 & 8) != 0 ? false : z4;
        boolean z14 = (i2 & 16) != 0 ? false : z5;
        ro2 ro24 = (i2 & 32) != 0 ? null : ro2;
    }
}
