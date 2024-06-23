package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;

/* access modifiers changed from: package-private */
/* compiled from: DescriptorUtils.kt */
public final class DescriptorUtilsKt$computeSealedSubclasses$1 extends Lambda implements Function2<MemberScope, Boolean, Unit> {
    final /* synthetic */ LinkedHashSet $result;
    final /* synthetic */ ClassDescriptor $sealedClass;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DescriptorUtilsKt$computeSealedSubclasses$1(ClassDescriptor classDescriptor, LinkedHashSet linkedHashSet) {
        super(2);
        this.$sealedClass = classDescriptor;
        this.$result = linkedHashSet;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(MemberScope memberScope, Boolean bool) {
        invoke(memberScope, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(MemberScope memberScope, boolean z) {
        Intrinsics.checkParameterIsNotNull(memberScope, "scope");
        for (DeclarationDescriptor declarationDescriptor : ResolutionScope.DefaultImpls.getContributedDescriptors$default(memberScope, DescriptorKindFilter.CLASSIFIERS, null, 2, null)) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                if (DescriptorUtils.isDirectSubclass(classDescriptor, this.$sealedClass)) {
                    this.$result.add(declarationDescriptor);
                }
                if (z) {
                    MemberScope unsubstitutedInnerClassesScope = classDescriptor.getUnsubstitutedInnerClassesScope();
                    Intrinsics.checkExpressionValueIsNotNull(unsubstitutedInnerClassesScope, "descriptor.unsubstitutedInnerClassesScope");
                    invoke(unsubstitutedInnerClassesScope, z);
                }
            }
        }
    }
}
