package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class nj0 extends om<Float> {
    public nj0(float f) {
        super(Float.valueOf(f));
    }

    @NotNull
    /* renamed from: c */
    public ib2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ib2 B = moduleDescriptor.getBuiltIns().B();
        k21.h(B, "module.builtIns.floatType");
        return B;
    }

    @Override // tb.om
    @NotNull
    public String toString() {
        return ((Number) b()).floatValue() + ".toFloat()";
    }
}
