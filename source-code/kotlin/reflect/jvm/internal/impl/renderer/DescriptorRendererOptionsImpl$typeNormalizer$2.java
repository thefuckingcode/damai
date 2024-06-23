package kotlin.reflect.jvm.internal.impl.renderer;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DescriptorRendererOptionsImpl$typeNormalizer$2 extends Lambda implements Function1<g61, g61> {
    public static final DescriptorRendererOptionsImpl$typeNormalizer$2 INSTANCE = new DescriptorRendererOptionsImpl$typeNormalizer$2();

    DescriptorRendererOptionsImpl$typeNormalizer$2() {
        super(1);
    }

    @NotNull
    public final g61 invoke(@NotNull g61 g61) {
        k21.i(g61, AdvanceSetting.NETWORK_TYPE);
        return g61;
    }
}
