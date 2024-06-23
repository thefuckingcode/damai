package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class y31 {
    @NotNull
    private final TypeUsage a;
    @NotNull
    private final JavaTypeFlexibility b;
    private final boolean c;
    @Nullable
    private final TypeParameterDescriptor d;

    public y31(@NotNull TypeUsage typeUsage, @NotNull JavaTypeFlexibility javaTypeFlexibility, boolean z, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        k21.i(typeUsage, "howThisTypeIsUsed");
        k21.i(javaTypeFlexibility, "flexibility");
        this.a = typeUsage;
        this.b = javaTypeFlexibility;
        this.c = z;
        this.d = typeParameterDescriptor;
    }

    public static /* synthetic */ y31 b(y31 y31, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, TypeParameterDescriptor typeParameterDescriptor, int i, Object obj) {
        if ((i & 1) != 0) {
            typeUsage = y31.a;
        }
        if ((i & 2) != 0) {
            javaTypeFlexibility = y31.b;
        }
        if ((i & 4) != 0) {
            z = y31.c;
        }
        if ((i & 8) != 0) {
            typeParameterDescriptor = y31.d;
        }
        return y31.a(typeUsage, javaTypeFlexibility, z, typeParameterDescriptor);
    }

    @NotNull
    public final y31 a(@NotNull TypeUsage typeUsage, @NotNull JavaTypeFlexibility javaTypeFlexibility, boolean z, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        k21.i(typeUsage, "howThisTypeIsUsed");
        k21.i(javaTypeFlexibility, "flexibility");
        return new y31(typeUsage, javaTypeFlexibility, z, typeParameterDescriptor);
    }

    @NotNull
    public final JavaTypeFlexibility c() {
        return this.b;
    }

    @NotNull
    public final TypeUsage d() {
        return this.a;
    }

    @Nullable
    public final TypeParameterDescriptor e() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y31)) {
            return false;
        }
        y31 y31 = (y31) obj;
        return this.a == y31.a && this.b == y31.b && this.c == y31.c && k21.d(this.d, y31.d);
    }

    public final boolean f() {
        return this.c;
    }

    @NotNull
    public final y31 g(@NotNull JavaTypeFlexibility javaTypeFlexibility) {
        k21.i(javaTypeFlexibility, "flexibility");
        return b(this, null, javaTypeFlexibility, false, null, 13, null);
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = (hashCode + i) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.d;
        return i4 + (typeParameterDescriptor == null ? 0 : typeParameterDescriptor.hashCode());
    }

    @NotNull
    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.a + ", flexibility=" + this.b + ", isForAnnotationParameter=" + this.c + ", upperBoundOfTypeParameter=" + this.d + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y31(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, TypeParameterDescriptor typeParameterDescriptor, int i, m40 m40) {
        this(typeUsage, (i & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : typeParameterDescriptor);
    }
}
