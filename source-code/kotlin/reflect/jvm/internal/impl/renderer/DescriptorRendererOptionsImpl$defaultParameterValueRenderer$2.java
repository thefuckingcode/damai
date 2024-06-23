package kotlin.reflect.jvm.internal.impl.renderer;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2 extends Lambda implements Function1<ValueParameterDescriptor, String> {
    public static final DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2 INSTANCE = new DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2();

    DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull ValueParameterDescriptor valueParameterDescriptor) {
        k21.i(valueParameterDescriptor, AdvanceSetting.NETWORK_TYPE);
        return "...";
    }
}
