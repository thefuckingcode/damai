package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
final class DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1 implements KotlinTypeChecker.TypeConstructorEquality {
    final /* synthetic */ DescriptorEquivalenceForOverrides a;
    final /* synthetic */ boolean b;
    final /* synthetic */ CallableDescriptor c;
    final /* synthetic */ CallableDescriptor d;

    DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, boolean z, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        this.a = descriptorEquivalenceForOverrides;
        this.b = z;
        this.c = callableDescriptor;
        this.d = callableDescriptor2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
    public final boolean equals(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2) {
        k21.i(typeConstructor, "c1");
        k21.i(typeConstructor2, "c2");
        if (k21.d(typeConstructor, typeConstructor2)) {
            return true;
        }
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        ClassifierDescriptor declarationDescriptor2 = typeConstructor2.getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof TypeParameterDescriptor) || !(declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return false;
        }
        boolean z = this.b;
        final CallableDescriptor callableDescriptor = this.c;
        final CallableDescriptor callableDescriptor2 = this.d;
        return this.a.g((TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z, new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>() {
            /* class kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
                return Boolean.valueOf(invoke(declarationDescriptor, declarationDescriptor2));
            }

            public final boolean invoke(@Nullable DeclarationDescriptor declarationDescriptor, @Nullable DeclarationDescriptor declarationDescriptor2) {
                return k21.d(declarationDescriptor, callableDescriptor) && k21.d(declarationDescriptor2, callableDescriptor2);
            }
        });
    }
}
