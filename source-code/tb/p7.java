package tb;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class p7 {
    @NotNull
    public static final <T> Iterator<T> a(@NotNull T[] tArr) {
        k21.i(tArr, "array");
        return new o7(tArr);
    }
}
