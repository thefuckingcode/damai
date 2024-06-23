package kotlin.reflect.jvm.internal.impl.renderer;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.jl1;
import tb.k21;

/* compiled from: Taobao */
final class DescriptorRendererImpl$appendTypeProjections$1 extends Lambda implements Function1<TypeProjection, CharSequence> {
    final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DescriptorRendererImpl$appendTypeProjections$1(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.this$0 = descriptorRendererImpl;
    }

    @NotNull
    public final CharSequence invoke(@NotNull TypeProjection typeProjection) {
        k21.i(typeProjection, AdvanceSetting.NETWORK_TYPE);
        if (typeProjection.isStarProjection()) {
            return jl1.MUL;
        }
        DescriptorRendererImpl descriptorRendererImpl = this.this$0;
        g61 type = typeProjection.getType();
        k21.h(type, "it.type");
        String g = descriptorRendererImpl.g(type);
        if (typeProjection.getProjectionKind() == Variance.INVARIANT) {
            return g;
        }
        return typeProjection.getProjectionKind() + ' ' + g;
    }
}
