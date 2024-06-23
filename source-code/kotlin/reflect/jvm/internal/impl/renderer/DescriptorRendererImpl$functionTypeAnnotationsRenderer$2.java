package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
final class DescriptorRendererImpl$functionTypeAnnotationsRenderer$2 extends Lambda implements Function0<DescriptorRendererImpl> {
    final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(DescriptorRendererImpl descriptorRendererImpl) {
        super(0);
        this.this$0 = descriptorRendererImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final DescriptorRendererImpl invoke() {
        return (DescriptorRendererImpl) this.this$0.i(AnonymousClass1.INSTANCE);
    }
}
