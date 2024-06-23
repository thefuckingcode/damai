package tb;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class l31 {
    @NotNull
    private final hk1 a;
    @NotNull
    private final Collection<AnnotationQualifierApplicabilityType> b;
    private final boolean c;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> */
    /* JADX WARN: Multi-variable type inference failed */
    public l31(@NotNull hk1 hk1, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z) {
        k21.i(hk1, "nullabilityQualifier");
        k21.i(collection, "qualifierApplicabilityTypes");
        this.a = hk1;
        this.b = collection;
        this.c = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: tb.l31 */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ l31 b(l31 l31, hk1 hk1, Collection collection, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            hk1 = l31.a;
        }
        if ((i & 2) != 0) {
            collection = l31.b;
        }
        if ((i & 4) != 0) {
            z = l31.c;
        }
        return l31.a(hk1, collection, z);
    }

    @NotNull
    public final l31 a(@NotNull hk1 hk1, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z) {
        k21.i(hk1, "nullabilityQualifier");
        k21.i(collection, "qualifierApplicabilityTypes");
        return new l31(hk1, collection, z);
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.a.c() == NullabilityQualifier.NOT_NULL && this.c;
    }

    @NotNull
    public final hk1 e() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l31)) {
            return false;
        }
        l31 l31 = (l31) obj;
        return k21.d(this.a, l31.a) && k21.d(this.b, l31.b) && this.c == l31.c;
    }

    @NotNull
    public final Collection<AnnotationQualifierApplicabilityType> f() {
        return this.b;
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
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.a + ", qualifierApplicabilityTypes=" + this.b + ", affectsTypeParameterBasedTypes=" + this.c + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l31(hk1 hk1, Collection collection, boolean z, int i, m40 m40) {
        this(hk1, collection, (i & 4) != 0 ? hk1.c() == NullabilityQualifier.NOT_NULL : z);
    }
}
