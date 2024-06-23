package tb;

import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class a41 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final a41 e = new a41(null, null, false, false, 8, null);
    @Nullable
    private final NullabilityQualifier a;
    @Nullable
    private final MutabilityQualifier b;
    private final boolean c;
    private final boolean d;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final a41 a() {
            return a41.e;
        }
    }

    public a41(@Nullable NullabilityQualifier nullabilityQualifier, @Nullable MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        this.a = nullabilityQualifier;
        this.b = mutabilityQualifier;
        this.c = z;
        this.d = z2;
    }

    @Nullable
    public final MutabilityQualifier b() {
        return this.b;
    }

    @Nullable
    public final NullabilityQualifier c() {
        return this.a;
    }

    public final boolean d() {
        return this.c;
    }

    public final boolean e() {
        return this.d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a41(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2, int i, m40 m40) {
        this(nullabilityQualifier, mutabilityQualifier, z, (i & 8) != 0 ? false : z2);
    }
}
