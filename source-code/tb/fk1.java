package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class fk1 extends om<Void> {
    public fk1() {
        super(null);
    }

    @NotNull
    /* renamed from: c */
    public ib2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ib2 J = moduleDescriptor.getBuiltIns().J();
        k21.h(J, "module.builtIns.nullableNothingType");
        return J;
    }
}
