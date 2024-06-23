package tb;

import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class yk {
    public static final boolean a(@NotNull xk xkVar, @NotNull ClassDescriptor classDescriptor) {
        k21.i(xkVar, "<this>");
        k21.i(classDescriptor, "classDescriptor");
        if (f60.x(classDescriptor)) {
            Set<oi> b = xkVar.b();
            oi h = DescriptorUtilsKt.h(classDescriptor);
            if (CollectionsKt___CollectionsKt.J(b, h == null ? null : h.g())) {
                return true;
            }
        }
        return false;
    }
}
