package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class fy1 {
    @Nullable
    public static final Class<?> a(@NotNull ClassLoader classLoader, @NotNull String str) {
        k21.i(classLoader, "<this>");
        k21.i(str, "fqName");
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
