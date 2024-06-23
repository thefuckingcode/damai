package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class JvmBuiltInsCustomizer$isMutabilityViolation$2 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    final /* synthetic */ JvmBuiltInsCustomizer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInsCustomizer$isMutabilityViolation$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        super(1);
        this.this$0 = jvmBuiltInsCustomizer;
    }

    public final Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(callableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.DECLARATION && this.this$0.b.c((ClassDescriptor) callableMemberDescriptor.getContainingDeclaration()));
    }
}
