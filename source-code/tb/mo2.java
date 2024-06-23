package tb;

import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.f0;
import kotlin.collections.k;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class mo2 {
    @NotNull
    public static final a41 a(@Nullable NullabilityQualifier nullabilityQualifier, @Nullable MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        if (!z2 || nullabilityQualifier != NullabilityQualifier.NOT_NULL) {
            return new a41(nullabilityQualifier, mutabilityQualifier, false, z);
        }
        return new a41(nullabilityQualifier, mutabilityQualifier, true, z);
    }

    public static final boolean b(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
        k21.i(typeSystemCommonBackendContext, "<this>");
        k21.i(kotlinTypeMarker, "type");
        en0 en0 = u41.ENHANCED_NULLABILITY_ANNOTATION;
        k21.h(en0, "ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(kotlinTypeMarker, en0);
    }

    @Nullable
    public static final <T> T c(@NotNull Set<? extends T> set, @NotNull T t, @NotNull T t2, @Nullable T t3, boolean z) {
        Set<? extends T> set2;
        k21.i(set, "<this>");
        k21.i(t, "low");
        k21.i(t2, "high");
        if (z) {
            T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
            if (!k21.d(t4, t) || !k21.d(t3, t2)) {
                return t3 == null ? t4 : t3;
            }
            return null;
        }
        if (!(t3 == null || (set2 = CollectionsKt___CollectionsKt.C0(f0.j(set, t3))) == null)) {
            set = set2;
        }
        return (T) k.p0(set);
    }

    @Nullable
    public static final NullabilityQualifier d(@NotNull Set<? extends NullabilityQualifier> set, @Nullable NullabilityQualifier nullabilityQualifier, boolean z) {
        k21.i(set, "<this>");
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) c(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }
}
