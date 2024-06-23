package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class qa2 extends b21<Short> {
    public qa2(short s) {
        super(Short.valueOf(s));
    }

    @NotNull
    /* renamed from: c */
    public ib2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ib2 S = moduleDescriptor.getBuiltIns().S();
        k21.h(S, "module.builtIns.shortType");
        return S;
    }

    @Override // tb.om
    @NotNull
    public String toString() {
        return ((Number) b()).intValue() + ".toShort()";
    }
}
