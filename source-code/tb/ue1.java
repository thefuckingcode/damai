package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ue1 {
    public static final boolean a(@NotNull ClassDescriptor classDescriptor) {
        k21.i(classDescriptor, "<this>");
        return classDescriptor.getModality() == Modality.FINAL && classDescriptor.getKind() != ClassKind.ENUM_CLASS;
    }
}
