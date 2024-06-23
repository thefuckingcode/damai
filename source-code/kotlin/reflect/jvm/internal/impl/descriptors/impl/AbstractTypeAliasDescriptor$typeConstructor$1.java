package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: AbstractTypeAliasDescriptor.kt */
public final class AbstractTypeAliasDescriptor$typeConstructor$1 implements TypeConstructor {
    final /* synthetic */ AbstractTypeAliasDescriptor this$0;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AbstractTypeAliasDescriptor$typeConstructor$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        this.this$0 = abstractTypeAliasDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeAliasDescriptor getDeclarationDescriptor() {
        return this.this$0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return this.this$0.getTypeConstructorTypeParameters();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public Collection<KotlinType> getSupertypes() {
        Collection<KotlinType> supertypes = getDeclarationDescriptor().getUnderlyingType().getConstructor().getSupertypes();
        Intrinsics.checkExpressionValueIsNotNull(supertypes, "declarationDescriptor.un…pe.constructor.supertypes");
        return supertypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        return DescriptorUtilsKt.getBuiltIns(getDeclarationDescriptor());
    }

    public String toString() {
        return "[typealias " + getDeclarationDescriptor().getName().asString() + ']';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
