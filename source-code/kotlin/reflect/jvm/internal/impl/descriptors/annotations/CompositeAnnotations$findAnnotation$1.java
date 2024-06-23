package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.k21;

/* compiled from: Taobao */
final class CompositeAnnotations$findAnnotation$1 extends Lambda implements Function1<Annotations, AnnotationDescriptor> {
    final /* synthetic */ en0 $fqName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CompositeAnnotations$findAnnotation$1(en0 en0) {
        super(1);
        this.$fqName = en0;
    }

    @Nullable
    public final AnnotationDescriptor invoke(@NotNull Annotations annotations) {
        k21.i(annotations, AdvanceSetting.NETWORK_TYPE);
        return annotations.findAnnotation(this.$fqName);
    }
}
