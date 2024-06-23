package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1 extends Lambda implements Function1<CallableMemberDescriptor, g61> {
    public static final SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1 INSTANCE = new SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1();

    SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1() {
        super(1);
    }

    @NotNull
    public final g61 invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, AdvanceSetting.NETWORK_TYPE);
        ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
        k21.f(extensionReceiverParameter);
        g61 type = extensionReceiverParameter.getType();
        k21.h(type, "it.extensionReceiverParameter!!.type");
        return type;
    }
}
