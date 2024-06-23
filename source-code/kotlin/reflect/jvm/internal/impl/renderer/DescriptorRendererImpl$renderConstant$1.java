package kotlin.reflect.jvm.internal.impl.renderer;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.om;

/* compiled from: Taobao */
final class DescriptorRendererImpl$renderConstant$1 extends Lambda implements Function1<om<?>, CharSequence> {
    final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DescriptorRendererImpl$renderConstant$1(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.this$0 = descriptorRendererImpl;
    }

    @NotNull
    public final CharSequence invoke(@NotNull om<?> omVar) {
        k21.i(omVar, AdvanceSetting.NETWORK_TYPE);
        return this.this$0.M0(omVar);
    }
}
