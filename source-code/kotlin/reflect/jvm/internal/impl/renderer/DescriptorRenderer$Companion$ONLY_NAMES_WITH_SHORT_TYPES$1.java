package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.collections.e0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
final class DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1 extends Lambda implements Function1<DescriptorRendererOptions, ur2> {
    public static final DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1 INSTANCE = new DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1();

    DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(DescriptorRendererOptions descriptorRendererOptions) {
        invoke(descriptorRendererOptions);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
        k21.i(descriptorRendererOptions, "<this>");
        descriptorRendererOptions.setWithDefinedIn(false);
        descriptorRendererOptions.setModifiers(e0.d());
        descriptorRendererOptions.setClassifierNamePolicy(ClassifierNamePolicy.b.INSTANCE);
        descriptorRendererOptions.setWithoutTypeParameters(true);
        descriptorRendererOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.NONE);
        descriptorRendererOptions.setReceiverAfterName(true);
        descriptorRendererOptions.setRenderCompanionObjectName(true);
        descriptorRendererOptions.setWithoutSuperTypes(true);
        descriptorRendererOptions.setStartFromName(true);
    }
}
