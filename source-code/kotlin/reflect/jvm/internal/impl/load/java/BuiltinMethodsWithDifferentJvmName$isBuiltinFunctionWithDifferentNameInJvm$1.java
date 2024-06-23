package kotlin.reflect.jvm.internal.impl.load.java;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.og1;
import tb.pd1;

/* compiled from: Taobao */
final class BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1 extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    final /* synthetic */ SimpleFunctionDescriptor $functionDescriptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        super(1);
        this.$functionDescriptor = simpleFunctionDescriptor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke(callableMemberDescriptor));
    }

    public final boolean invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, AdvanceSetting.NETWORK_TYPE);
        Map<String, og1> i = SpecialGenericSignatures.Companion.i();
        String d = pd1.d(this.$functionDescriptor);
        Objects.requireNonNull(i, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return i.containsKey(d);
    }
}
