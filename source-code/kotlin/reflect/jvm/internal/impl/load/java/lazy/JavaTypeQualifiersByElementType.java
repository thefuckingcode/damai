package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.EnumMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;

/* compiled from: context.kt */
public final class JavaTypeQualifiersByElementType {
    private final EnumMap<AnnotationTypeQualifierResolver.QualifierApplicabilityType, NullabilityQualifierWithMigrationStatus> nullabilityQualifiers;

    public JavaTypeQualifiersByElementType(EnumMap<AnnotationTypeQualifierResolver.QualifierApplicabilityType, NullabilityQualifierWithMigrationStatus> enumMap) {
        Intrinsics.checkParameterIsNotNull(enumMap, "nullabilityQualifiers");
        this.nullabilityQualifiers = enumMap;
    }

    public final EnumMap<AnnotationTypeQualifierResolver.QualifierApplicabilityType, NullabilityQualifierWithMigrationStatus> getNullabilityQualifiers() {
        return this.nullabilityQualifiers;
    }

    public final JavaTypeQualifiers get(AnnotationTypeQualifierResolver.QualifierApplicabilityType qualifierApplicabilityType) {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = this.nullabilityQualifiers.get(qualifierApplicabilityType);
        if (nullabilityQualifierWithMigrationStatus == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(nullabilityQualifierWithMigrationStatus, "nullabilityQualifiers[ap…ilityType] ?: return null");
        return new JavaTypeQualifiers(nullabilityQualifierWithMigrationStatus.getQualifier(), null, false, nullabilityQualifierWithMigrationStatus.isForWarningOnly());
    }
}
