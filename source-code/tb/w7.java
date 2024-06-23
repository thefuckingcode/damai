package tb;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class w7 extends om<List<? extends om<?>>> {
    @NotNull
    private final Function1<ModuleDescriptor, g61> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, ? extends tb.g61> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w7(@NotNull List<? extends om<?>> list, @NotNull Function1<? super ModuleDescriptor, ? extends g61> function1) {
        super(list);
        k21.i(list, "value");
        k21.i(function1, "computeType");
        this.b = function1;
    }

    @Override // tb.om
    @NotNull
    public g61 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        g61 invoke = this.b.invoke(moduleDescriptor);
        if (!b.b0(invoke) && !b.w0(invoke)) {
            b.K0(invoke);
        }
        return invoke;
    }
}
