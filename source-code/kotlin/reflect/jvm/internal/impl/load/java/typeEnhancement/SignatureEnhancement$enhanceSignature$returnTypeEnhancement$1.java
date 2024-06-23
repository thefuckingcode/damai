package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1 extends Lambda implements Function1<CallableMemberDescriptor, g61> {
    public static final SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1 INSTANCE = new SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1();

    SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1() {
        super(1);
    }

    @NotNull
    public final g61 invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        k21.i(callableMemberDescriptor, AdvanceSetting.NETWORK_TYPE);
        g61 returnType = callableMemberDescriptor.getReturnType();
        k21.f(returnType);
        return returnType;
    }
}
