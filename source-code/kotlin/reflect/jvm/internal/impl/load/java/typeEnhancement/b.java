package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;
import tb.k21;
import tb.l31;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class b {
    @NotNull
    private final g61 a;
    @Nullable
    private final l31 b;
    @Nullable
    private final TypeParameterDescriptor c;
    private final boolean d;

    public b(@NotNull g61 g61, @Nullable l31 l31, @Nullable TypeParameterDescriptor typeParameterDescriptor, boolean z) {
        k21.i(g61, "type");
        this.a = g61;
        this.b = l31;
        this.c = typeParameterDescriptor;
        this.d = z;
    }

    @NotNull
    public final g61 a() {
        return this.a;
    }

    @Nullable
    public final l31 b() {
        return this.b;
    }

    @Nullable
    public final TypeParameterDescriptor c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    @NotNull
    public final g61 e() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k21.d(this.a, bVar.a) && k21.d(this.b, bVar.b) && k21.d(this.c, bVar.c) && this.d == bVar.d;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        l31 l31 = this.b;
        int i = 0;
        int hashCode2 = (hashCode + (l31 == null ? 0 : l31.hashCode())) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.c;
        if (typeParameterDescriptor != null) {
            i = typeParameterDescriptor.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.d;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    @NotNull
    public String toString() {
        return "TypeAndDefaultQualifiers(type=" + this.a + ", defaultQualifiers=" + this.b + ", typeParameterForArgument=" + this.c + ", isFromStarProjection=" + this.d + ')';
    }
}
