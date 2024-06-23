package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class o31 {
    public static final boolean a(@NotNull PropertyDescriptor propertyDescriptor) {
        k21.i(propertyDescriptor, "<this>");
        return propertyDescriptor.getGetter() == null;
    }
}
