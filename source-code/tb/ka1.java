package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ka1 extends b21<Long> {
    public ka1(long j) {
        super(Long.valueOf(j));
    }

    @NotNull
    /* renamed from: c */
    public ib2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ib2 F = moduleDescriptor.getBuiltIns().F();
        k21.h(F, "module.builtIns.longType");
        return F;
    }

    @Override // tb.om
    @NotNull
    public String toString() {
        return ((Number) b()).longValue() + ".toLong()";
    }
}
