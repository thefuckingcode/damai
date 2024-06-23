package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class zd extends b21<Byte> {
    public zd(byte b) {
        super(Byte.valueOf(b));
    }

    @NotNull
    /* renamed from: c */
    public ib2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ib2 t = moduleDescriptor.getBuiltIns().t();
        k21.h(t, "module.builtIns.byteType");
        return t;
    }

    @Override // tb.om
    @NotNull
    public String toString() {
        return ((Number) b()).intValue() + ".toByte()";
    }
}
