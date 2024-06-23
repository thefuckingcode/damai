package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;

/* compiled from: context.kt */
public final class NullabilityQualifierWithApplicability {
    private final NullabilityQualifierWithMigrationStatus nullabilityQualifier;
    private final Collection<AnnotationTypeQualifierResolver.QualifierApplicabilityType> qualifierApplicabilityTypes;

    public final NullabilityQualifierWithMigrationStatus component1() {
        return this.nullabilityQualifier;
    }

    public final Collection<AnnotationTypeQualifierResolver.QualifierApplicabilityType> component2() {
        return this.qualifierApplicabilityTypes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NullabilityQualifierWithApplicability)) {
            return false;
        }
        NullabilityQualifierWithApplicability nullabilityQualifierWithApplicability = (NullabilityQualifierWithApplicability) obj;
        return Intrinsics.areEqual(this.nullabilityQualifier, nullabilityQualifierWithApplicability.nullabilityQualifier) && Intrinsics.areEqual(this.qualifierApplicabilityTypes, nullabilityQualifierWithApplicability.qualifierApplicabilityTypes);
    }

    public int hashCode() {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = this.nullabilityQualifier;
        int i = 0;
        int hashCode = (nullabilityQualifierWithMigrationStatus != null ? nullabilityQualifierWithMigrationStatus.hashCode() : 0) * 31;
        Collection<AnnotationTypeQualifierResolver.QualifierApplicabilityType> collection = this.qualifierApplicabilityTypes;
        if (collection != null) {
            i = collection.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "NullabilityQualifierWithApplicability(nullabilityQualifier=" + this.nullabilityQualifier + ", qualifierApplicabilityTypes=" + this.qualifierApplicabilityTypes + ")";
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$QualifierApplicabilityType> */
    /* JADX WARN: Multi-variable type inference failed */
    public NullabilityQualifierWithApplicability(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<? extends AnnotationTypeQualifierResolver.QualifierApplicabilityType> collection) {
        Intrinsics.checkParameterIsNotNull(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics.checkParameterIsNotNull(collection, "qualifierApplicabilityTypes");
        this.nullabilityQualifier = nullabilityQualifierWithMigrationStatus;
        this.qualifierApplicabilityTypes = collection;
    }
}
