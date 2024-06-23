package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import org.jetbrains.annotations.NotNull;
import tb.en0;
import tb.k21;

/* compiled from: Taobao */
public interface DescriptorRendererOptions {

    /* compiled from: Taobao */
    public static final class a {
        public static boolean a(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
            k21.i(descriptorRendererOptions, "this");
            return descriptorRendererOptions.getAnnotationArgumentsRenderingPolicy().getIncludeAnnotationArguments();
        }

        public static boolean b(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
            k21.i(descriptorRendererOptions, "this");
            return descriptorRendererOptions.getAnnotationArgumentsRenderingPolicy().getIncludeEmptyAnnotationArguments();
        }
    }

    @NotNull
    AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy();

    boolean getDebugMode();

    boolean getEnhancedTypes();

    @NotNull
    Set<en0> getExcludedTypeAnnotationClasses();

    void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy);

    void setClassifierNamePolicy(@NotNull ClassifierNamePolicy classifierNamePolicy);

    void setDebugMode(boolean z);

    void setExcludedTypeAnnotationClasses(@NotNull Set<en0> set);

    void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> set);

    void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy);

    void setReceiverAfterName(boolean z);

    void setRenderCompanionObjectName(boolean z);

    void setStartFromName(boolean z);

    void setTextFormat(@NotNull RenderingFormat renderingFormat);

    void setVerbose(boolean z);

    void setWithDefinedIn(boolean z);

    void setWithoutSuperTypes(boolean z);

    void setWithoutTypeParameters(boolean z);
}
