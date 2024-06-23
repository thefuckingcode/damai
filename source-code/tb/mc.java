package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class mc extends om<Boolean> {
    public mc(boolean z) {
        super(Boolean.valueOf(z));
    }

    @NotNull
    /* renamed from: c */
    public ib2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ib2 n = moduleDescriptor.getBuiltIns().n();
        k21.h(n, "module.builtIns.booleanType");
        return n;
    }
}
