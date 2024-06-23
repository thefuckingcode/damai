package tb;

import kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class go2 {
    @Nullable
    public static final CustomTypeVariable a(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        es2 f = g61.f();
        CustomTypeVariable customTypeVariable = f instanceof CustomTypeVariable ? (CustomTypeVariable) f : null;
        if (customTypeVariable != null && customTypeVariable.isTypeVariable()) {
            return customTypeVariable;
        }
        return null;
    }

    public static final boolean b(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        es2 f = g61.f();
        CustomTypeVariable customTypeVariable = f instanceof CustomTypeVariable ? (CustomTypeVariable) f : null;
        if (customTypeVariable == null) {
            return false;
        }
        return customTypeVariable.isTypeVariable();
    }
}
