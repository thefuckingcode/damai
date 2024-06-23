package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* access modifiers changed from: package-private */
/* compiled from: signatureEnhancement.kt */
public final class TypeAndDefaultQualifiers {
    private final JavaTypeQualifiers defaultQualifiers;
    private final KotlinType type;

    public final KotlinType component1() {
        return this.type;
    }

    public final JavaTypeQualifiers component2() {
        return this.defaultQualifiers;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeAndDefaultQualifiers)) {
            return false;
        }
        TypeAndDefaultQualifiers typeAndDefaultQualifiers = (TypeAndDefaultQualifiers) obj;
        return Intrinsics.areEqual(this.type, typeAndDefaultQualifiers.type) && Intrinsics.areEqual(this.defaultQualifiers, typeAndDefaultQualifiers.defaultQualifiers);
    }

    public int hashCode() {
        KotlinType kotlinType = this.type;
        int i = 0;
        int hashCode = (kotlinType != null ? kotlinType.hashCode() : 0) * 31;
        JavaTypeQualifiers javaTypeQualifiers = this.defaultQualifiers;
        if (javaTypeQualifiers != null) {
            i = javaTypeQualifiers.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "TypeAndDefaultQualifiers(type=" + this.type + ", defaultQualifiers=" + this.defaultQualifiers + ")";
    }

    public TypeAndDefaultQualifiers(KotlinType kotlinType, JavaTypeQualifiers javaTypeQualifiers) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "type");
        this.type = kotlinType;
        this.defaultQualifiers = javaTypeQualifiers;
    }

    public final KotlinType getType() {
        return this.type;
    }
}
