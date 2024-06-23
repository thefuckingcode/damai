package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.StrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* compiled from: KotlinType.kt */
public abstract class KotlinType implements Annotated, KotlinTypeMarker {
    private int cachedHashCode;

    public abstract List<TypeProjection> getArguments();

    public abstract TypeConstructor getConstructor();

    public abstract MemberScope getMemberScope();

    public abstract boolean isMarkedNullable();

    public abstract KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner);

    public abstract UnwrappedType unwrap();

    private KotlinType() {
    }

    public /* synthetic */ KotlinType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final int computeHashCode() {
        if (KotlinTypeKt.isError(this)) {
            return super.hashCode();
        }
        return (((getConstructor().hashCode() * 31) + getArguments().hashCode()) * 31) + (isMarkedNullable() ? 1 : 0);
    }

    public final int hashCode() {
        int i = this.cachedHashCode;
        if (i != 0) {
            return i;
        }
        int computeHashCode = computeHashCode();
        this.cachedHashCode = computeHashCode;
        return computeHashCode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KotlinType)) {
            return false;
        }
        KotlinType kotlinType = (KotlinType) obj;
        if (isMarkedNullable() != kotlinType.isMarkedNullable() || !StrictEqualityTypeChecker.INSTANCE.strictEqualTypes(unwrap(), kotlinType.unwrap())) {
            return false;
        }
        return true;
    }
}
