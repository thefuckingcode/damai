package tb;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class cl extends bl {
    @SinceKotlin(version = "1.1")
    @NotNull
    public static <T extends Comparable<? super T>> T b(@NotNull T t, @NotNull T t2) {
        k21.i(t, "a");
        k21.i(t2, "b");
        return t.compareTo(t2) >= 0 ? t : t2;
    }
}
