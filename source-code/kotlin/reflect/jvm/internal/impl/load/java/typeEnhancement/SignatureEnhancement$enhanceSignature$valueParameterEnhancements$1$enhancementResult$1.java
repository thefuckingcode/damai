package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1 extends Lambda implements Function1<CallableMemberDescriptor, g61> {
    final /* synthetic */ ValueParameterDescriptor $p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1(ValueParameterDescriptor valueParameterDescriptor) {
        super(1);
        this.$p = valueParameterDescriptor;
    }

    @NotNull
    public final g61 invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, AdvanceSetting.NETWORK_TYPE);
        g61 type = callableMemberDescriptor.getValueParameters().get(this.$p.getIndex()).getType();
        k21.h(type, "it.valueParameters[p.index].type");
        return type;
    }
}
