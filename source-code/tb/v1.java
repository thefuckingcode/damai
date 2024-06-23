package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Checks;
import org.jetbrains.annotations.NotNull;
import tb.sh;

/* compiled from: Taobao */
public abstract class v1 {
    @NotNull
    public final sh a(@NotNull FunctionDescriptor functionDescriptor) {
        k21.i(functionDescriptor, "functionDescriptor");
        for (Checks checks : b()) {
            if (checks.b(functionDescriptor)) {
                return checks.a(functionDescriptor);
            }
        }
        return sh.a.INSTANCE;
    }

    @NotNull
    public abstract List<Checks> b();
}
