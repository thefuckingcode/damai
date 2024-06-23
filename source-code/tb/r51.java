package tb;

import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.KType;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.1")
/* compiled from: Taobao */
public final class r51 {
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    @NotNull
    public static final r51 star = new r51(null, null);
    @Nullable
    private final KVariance a;
    @Nullable
    private final KType b;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @JvmStatic
        @NotNull
        public final r51 a(@NotNull KType kType) {
            k21.i(kType, "type");
            return new r51(KVariance.IN, kType);
        }

        @JvmStatic
        @NotNull
        public final r51 b(@NotNull KType kType) {
            k21.i(kType, "type");
            return new r51(KVariance.OUT, kType);
        }

        @NotNull
        public final r51 c() {
            return r51.star;
        }

        @JvmStatic
        @NotNull
        public final r51 d(@NotNull KType kType) {
            k21.i(kType, "type");
            return new r51(KVariance.INVARIANT, kType);
        }
    }

    /* compiled from: Taobao */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public r51(@Nullable KVariance kVariance, @Nullable KType kType) {
        String str;
        this.a = kVariance;
        this.b = kType;
        if (!((kVariance == null) != (kType == null) ? false : true)) {
            if (kVariance == null) {
                str = "Star projection must have no type specified.";
            } else {
                str = "The projection variance " + kVariance + " requires type to be specified.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    @Nullable
    public final KVariance a() {
        return this.a;
    }

    @Nullable
    public final KType b() {
        return this.b;
    }

    @Nullable
    public final KType c() {
        return this.b;
    }

    @Nullable
    public final KVariance d() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r51)) {
            return false;
        }
        r51 r51 = (r51) obj;
        return this.a == r51.a && k21.d(this.b, r51.b);
    }

    public int hashCode() {
        KVariance kVariance = this.a;
        int i = 0;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        KType kType = this.b;
        if (kType != null) {
            i = kType.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        KVariance kVariance = this.a;
        int i = kVariance == null ? -1 : b.$EnumSwitchMapping$0[kVariance.ordinal()];
        if (i == -1) {
            return jl1.MUL;
        }
        if (i == 1) {
            return String.valueOf(this.b);
        }
        if (i == 2) {
            return "in " + this.b;
        } else if (i == 3) {
            return "out " + this.b;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
