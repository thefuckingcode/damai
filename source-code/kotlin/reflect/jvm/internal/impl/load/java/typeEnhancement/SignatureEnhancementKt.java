package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: signatureEnhancement.kt */
public final class SignatureEnhancementKt {
    public static final JavaTypeQualifiers createJavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        if (!z2 || nullabilityQualifier != NullabilityQualifier.NOT_NULL) {
            return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, false, z);
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, true, z);
    }

    public static final <T> T select(Set<? extends T> set, T t, T t2, T t3, boolean z) {
        Set<? extends T> set2;
        Intrinsics.checkParameterIsNotNull(set, "$this$select");
        Intrinsics.checkParameterIsNotNull(t, "low");
        Intrinsics.checkParameterIsNotNull(t2, "high");
        if (z) {
            T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
            if (!Intrinsics.areEqual((Object) t4, (Object) t) || !Intrinsics.areEqual((Object) t3, (Object) t2)) {
                return t3 != null ? t3 : t4;
            }
            return null;
        }
        if (!(t3 == null || (set2 = CollectionsKt.toSet(SetsKt.plus((Set) set, (Object) t3))) == null)) {
            set = set2;
        }
        return (T) CollectionsKt.singleOrNull(set);
    }

    public static final NullabilityQualifier select(Set<? extends NullabilityQualifier> set, NullabilityQualifier nullabilityQualifier, boolean z) {
        Intrinsics.checkParameterIsNotNull(set, "$this$select");
        if (nullabilityQualifier == NullabilityQualifier.FORCE_FLEXIBILITY) {
            return NullabilityQualifier.FORCE_FLEXIBILITY;
        }
        return (NullabilityQualifier) select(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }
}
