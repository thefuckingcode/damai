package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class pb0 extends om<Double> {
    public pb0(double d) {
        super(Double.valueOf(d));
    }

    @NotNull
    /* renamed from: c */
    public ib2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ib2 z = moduleDescriptor.getBuiltIns().z();
        k21.h(z, "module.builtIns.doubleType");
        return z;
    }

    @Override // tb.om
    @NotNull
    public String toString() {
        return ((Number) b()).doubleValue() + ".toDouble()";
    }
}
