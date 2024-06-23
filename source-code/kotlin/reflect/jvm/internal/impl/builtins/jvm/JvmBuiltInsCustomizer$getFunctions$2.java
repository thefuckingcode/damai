package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.og1;

/* compiled from: Taobao */
final class JvmBuiltInsCustomizer$getFunctions$2 extends Lambda implements Function1<MemberScope, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ og1 $name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInsCustomizer$getFunctions$2(og1 og1) {
        super(1);
        this.$name = og1;
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> */
    @NotNull
    public final Collection<SimpleFunctionDescriptor> invoke(@NotNull MemberScope memberScope) {
        k21.i(memberScope, AdvanceSetting.NETWORK_TYPE);
        return memberScope.getContributedFunctions(this.$name, NoLookupLocation.FROM_BUILTINS);
    }
}
