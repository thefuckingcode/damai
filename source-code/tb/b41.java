package tb;

import java.util.EnumMap;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class b41 {
    @NotNull
    private final EnumMap<AnnotationQualifierApplicabilityType, l31> a;

    public b41(@NotNull EnumMap<AnnotationQualifierApplicabilityType, l31> enumMap) {
        k21.i(enumMap, "defaultQualifiers");
        this.a = enumMap;
    }

    @Nullable
    public final l31 a(@Nullable AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return this.a.get(annotationQualifierApplicabilityType);
    }

    @NotNull
    public final EnumMap<AnnotationQualifierApplicabilityType, l31> b() {
        return this.a;
    }
}
