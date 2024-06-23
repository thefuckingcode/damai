package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
final class CapturedTypeApproximationKt$toTypeProjection$1$descriptorRenderer$1 extends Lambda implements Function1<DescriptorRendererOptions, ur2> {
    public static final CapturedTypeApproximationKt$toTypeProjection$1$descriptorRenderer$1 INSTANCE = new CapturedTypeApproximationKt$toTypeProjection$1$descriptorRenderer$1();

    CapturedTypeApproximationKt$toTypeProjection$1$descriptorRenderer$1() {
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
        descriptorRendererOptions.setClassifierNamePolicy(ClassifierNamePolicy.a.INSTANCE);
    }
}
