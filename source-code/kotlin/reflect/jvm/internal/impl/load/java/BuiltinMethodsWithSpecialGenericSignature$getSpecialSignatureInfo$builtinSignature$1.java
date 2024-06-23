package kotlin.reflect.jvm.internal.impl.load.java;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    final /* synthetic */ BuiltinMethodsWithSpecialGenericSignature this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1(BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature) {
        super(1);
        this.this$0 = builtinMethodsWithSpecialGenericSignature;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke(callableMemberDescriptor));
    }

    public final boolean invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, AdvanceSetting.NETWORK_TYPE);
        return (callableMemberDescriptor instanceof FunctionDescriptor) && BuiltinMethodsWithSpecialGenericSignature.i(this.this$0, callableMemberDescriptor);
    }
}
