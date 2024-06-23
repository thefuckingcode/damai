package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class od1 {
    @NotNull
    public static final String a(@NotNull SignatureBuildingComponents signatureBuildingComponents, @NotNull ClassDescriptor classDescriptor, @NotNull String str) {
        k21.i(signatureBuildingComponents, "<this>");
        k21.i(classDescriptor, "classDescriptor");
        k21.i(str, "jvmDescriptor");
        return signatureBuildingComponents.k(pd1.f(classDescriptor), str);
    }
}
