package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* compiled from: utils.kt */
public final class EnumEntry extends JavaDefaultValue {
    private final ClassDescriptor descriptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnumEntry(ClassDescriptor classDescriptor) {
        super(null);
        Intrinsics.checkParameterIsNotNull(classDescriptor, "descriptor");
        this.descriptor = classDescriptor;
    }
}
