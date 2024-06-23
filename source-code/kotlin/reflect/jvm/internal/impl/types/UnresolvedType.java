package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ErrorType.kt */
public final class UnresolvedType extends ErrorType {
    private final String presentableName;

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.ErrorType, kotlin.reflect.jvm.internal.impl.types.ErrorType, kotlin.reflect.jvm.internal.impl.types.ErrorType
    public UnresolvedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErrorType
    public String getPresentableName() {
        return this.presentableName;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnresolvedType(String str, TypeConstructor typeConstructor, MemberScope memberScope, List<? extends TypeProjection> list, boolean z) {
        super(typeConstructor, memberScope, list, z, null, 16, null);
        Intrinsics.checkParameterIsNotNull(str, "presentableName");
        Intrinsics.checkParameterIsNotNull(typeConstructor, "constructor");
        Intrinsics.checkParameterIsNotNull(memberScope, "memberScope");
        Intrinsics.checkParameterIsNotNull(list, "arguments");
        this.presentableName = str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.ErrorType, kotlin.reflect.jvm.internal.impl.types.ErrorType, kotlin.reflect.jvm.internal.impl.types.SimpleType
    public SimpleType makeNullableAsSpecified(boolean z) {
        return new UnresolvedType(getPresentableName(), getConstructor(), getMemberScope(), getArguments(), z);
    }
}
