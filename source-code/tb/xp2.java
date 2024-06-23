package tb;

import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class xp2 extends ds2<Integer> {
    public xp2(int i) {
        super(Integer.valueOf(i));
    }

    @Override // tb.om
    @NotNull
    public g61 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ClassDescriptor a = FindClassInModuleKt.a(moduleDescriptor, c.a.uInt);
        ib2 defaultType = a == null ? null : a.getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        ib2 j = me0.j("Unsigned type UInt not found");
        k21.h(j, "createErrorType(\"Unsigned type UInt not found\")");
        return j;
    }

    @Override // tb.om
    @NotNull
    public String toString() {
        return ((Number) b()).intValue() + ".toUInt()";
    }
}
