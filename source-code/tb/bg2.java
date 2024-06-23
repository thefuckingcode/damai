package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class bg2 extends om<String> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bg2(@NotNull String str) {
        super(str);
        k21.i(str, "value");
    }

    @NotNull
    /* renamed from: c */
    public ib2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ib2 V = moduleDescriptor.getBuiltIns().V();
        k21.h(V, "module.builtIns.stringType");
        return V;
    }

    @Override // tb.om
    @NotNull
    public String toString() {
        return jl1.QUOTE + ((String) b()) + jl1.QUOTE;
    }
}
