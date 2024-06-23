package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* access modifiers changed from: package-private */
/* compiled from: JvmBuiltInsSettings.kt */
public final class JvmBuiltInsSettings$isMutabilityViolation$2 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    final /* synthetic */ JvmBuiltInsSettings this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInsSettings$isMutabilityViolation$2(JvmBuiltInsSettings jvmBuiltInsSettings) {
        super(1);
        this.this$0 = jvmBuiltInsSettings;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke(callableMemberDescriptor));
    }

    public final boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkExpressionValueIsNotNull(callableMemberDescriptor, "overridden");
        if (callableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.DECLARATION) {
            JavaToKotlinClassMap javaToKotlinClassMap = this.this$0.j2kClassMap;
            DeclarationDescriptor containingDeclaration = callableMemberDescriptor.getContainingDeclaration();
            if (containingDeclaration == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            } else if (javaToKotlinClassMap.isMutable((ClassDescriptor) containingDeclaration)) {
                return true;
            }
        }
        return false;
    }
}
