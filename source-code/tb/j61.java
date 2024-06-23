package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class j61 {
    @NotNull
    private static final af1<vx1<i61>> a = new af1<>("KotlinTypeRefiner");

    @NotNull
    public static final af1<vx1<i61>> a() {
        return a;
    }

    @NotNull
    public static final List<g61> b(@NotNull i61 i61, @NotNull Iterable<? extends g61> iterable) {
        k21.i(i61, "<this>");
        k21.i(iterable, "types");
        ArrayList arrayList = new ArrayList(n.q(iterable, 10));
        for (g61 g61 : iterable) {
            arrayList.add(i61.g(g61));
        }
        return arrayList;
    }
}
