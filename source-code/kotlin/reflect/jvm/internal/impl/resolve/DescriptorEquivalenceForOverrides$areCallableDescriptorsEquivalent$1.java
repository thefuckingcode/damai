package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
final class DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1 extends Lambda implements Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean> {
    public static final DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1 INSTANCE = new DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1();

    DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        return Boolean.valueOf(invoke(declarationDescriptor, declarationDescriptor2));
    }

    public final boolean invoke(@Nullable DeclarationDescriptor declarationDescriptor, @Nullable DeclarationDescriptor declarationDescriptor2) {
        return false;
    }
}
