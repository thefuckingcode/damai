package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface PropertyAccessorDescriptor extends VariableAccessorDescriptor {
    @NotNull
    PropertyDescriptor getCorrespondingProperty();

    boolean isDefault();
}
