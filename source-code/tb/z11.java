package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class z11 extends b21<Integer> {
    public z11(int i) {
        super(Integer.valueOf(i));
    }

    @NotNull
    /* renamed from: c */
    public ib2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ib2 D = moduleDescriptor.getBuiltIns().D();
        k21.h(D, "module.builtIns.intType");
        return D;
    }
}
