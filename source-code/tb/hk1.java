package tb;

import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class hk1 {
    @NotNull
    private final NullabilityQualifier a;
    private final boolean b;

    public hk1(@NotNull NullabilityQualifier nullabilityQualifier, boolean z) {
        k21.i(nullabilityQualifier, "qualifier");
        this.a = nullabilityQualifier;
        this.b = z;
    }

    public static /* synthetic */ hk1 b(hk1 hk1, NullabilityQualifier nullabilityQualifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifier = hk1.a;
        }
        if ((i & 2) != 0) {
            z = hk1.b;
        }
        return hk1.a(nullabilityQualifier, z);
    }

    @NotNull
    public final hk1 a(@NotNull NullabilityQualifier nullabilityQualifier, boolean z) {
        k21.i(nullabilityQualifier, "qualifier");
        return new hk1(nullabilityQualifier, z);
    }

    @NotNull
    public final NullabilityQualifier c() {
        return this.a;
    }

    public final boolean d() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hk1)) {
            return false;
        }
        hk1 hk1 = (hk1) obj;
        return this.a == hk1.a && this.b == hk1.b;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.a + ", isForWarningOnly=" + this.b + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hk1(NullabilityQualifier nullabilityQualifier, boolean z, int i, m40 m40) {
        this(nullabilityQualifier, (i & 2) != 0 ? false : z);
    }
}
