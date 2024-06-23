package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
final class CompositeAnnotations$iterator$1 extends Lambda implements Function1<Annotations, Sequence<? extends AnnotationDescriptor>> {
    public static final CompositeAnnotations$iterator$1 INSTANCE = new CompositeAnnotations$iterator$1();

    CompositeAnnotations$iterator$1() {
        super(1);
    }

    @NotNull
    public final Sequence<AnnotationDescriptor> invoke(@NotNull Annotations annotations) {
        k21.i(annotations, AdvanceSetting.NETWORK_TYPE);
        return CollectionsKt___CollectionsKt.I(annotations);
    }
}
