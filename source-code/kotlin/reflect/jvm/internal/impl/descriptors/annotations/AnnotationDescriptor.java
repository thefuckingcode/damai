package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.g61;
import tb.k21;
import tb.me0;
import tb.og1;
import tb.om;

/* compiled from: Taobao */
public interface AnnotationDescriptor {

    /* compiled from: Taobao */
    public static final class a {
        @Nullable
        public static en0 a(@NotNull AnnotationDescriptor annotationDescriptor) {
            k21.i(annotationDescriptor, "this");
            ClassDescriptor f = DescriptorUtilsKt.f(annotationDescriptor);
            if (f == null) {
                return null;
            }
            if (me0.r(f)) {
                f = null;
            }
            if (f == null) {
                return null;
            }
            return DescriptorUtilsKt.e(f);
        }
    }

    @NotNull
    Map<og1, om<?>> getAllValueArguments();

    @Nullable
    en0 getFqName();

    @NotNull
    SourceElement getSource();

    @NotNull
    g61 getType();
}
