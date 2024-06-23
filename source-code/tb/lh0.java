package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class lh0 extends w5 implements FieldDescriptor {
    @NotNull
    private final PropertyDescriptor b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public lh0(@NotNull Annotations annotations, @NotNull PropertyDescriptor propertyDescriptor) {
        super(annotations);
        k21.i(annotations, "annotations");
        k21.i(propertyDescriptor, "correspondingProperty");
        this.b = propertyDescriptor;
    }
}
