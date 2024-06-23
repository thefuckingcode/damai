package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class yd0 extends m31 {
    @NotNull
    private final ClassDescriptor a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yd0(@NotNull ClassDescriptor classDescriptor) {
        super(null);
        k21.i(classDescriptor, "descriptor");
        this.a = classDescriptor;
    }
}
