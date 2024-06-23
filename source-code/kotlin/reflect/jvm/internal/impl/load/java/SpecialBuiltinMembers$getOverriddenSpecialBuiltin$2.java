package kotlin.reflect.jvm.internal.impl.load.java;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public static final SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2 INSTANCE = new SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2();

    SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke(callableMemberDescriptor));
    }

    public final boolean invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, AdvanceSetting.NETWORK_TYPE);
        if (b.e0(callableMemberDescriptor)) {
            BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
            if (BuiltinMethodsWithSpecialGenericSignature.m(callableMemberDescriptor) != null) {
                return true;
            }
        }
        return false;
    }
}
