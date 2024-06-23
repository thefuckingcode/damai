package kotlin.reflect.jvm.internal.impl.renderer;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;

/* compiled from: Taobao */
final class DescriptorRendererImpl$renderSuperTypes$1 extends Lambda implements Function1<g61, CharSequence> {
    final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DescriptorRendererImpl$renderSuperTypes$1(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.this$0 = descriptorRendererImpl;
    }

    @NotNull
    public final CharSequence invoke(g61 g61) {
        DescriptorRendererImpl descriptorRendererImpl = this.this$0;
        k21.h(g61, AdvanceSetting.NETWORK_TYPE);
        return descriptorRendererImpl.g(g61);
    }
}
