package tb;

import kotlin.SinceKotlin;
import kotlin.internal.HidesMembers;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class jf0 {
    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static void a(@NotNull Throwable th, @NotNull Throwable th2) {
        k21.i(th, "<this>");
        k21.i(th2, "exception");
        if (th != th2) {
            sq1.IMPLEMENTATIONS.a(th, th2);
        }
    }
}
