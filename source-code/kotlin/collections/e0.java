package kotlin.collections;

import java.util.LinkedHashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class e0 extends d0 {
    @NotNull
    public static <T> Set<T> d() {
        return EmptySet.INSTANCE;
    }

    @NotNull
    public static <T> LinkedHashSet<T> e(@NotNull T... tArr) {
        k21.i(tArr, "elements");
        return (LinkedHashSet) ArraysKt___ArraysKt.Q(tArr, new LinkedHashSet(w.e(tArr.length)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Set<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Set<T> f(@NotNull Set<? extends T> set) {
        k21.i(set, "<this>");
        int size = set.size();
        if (size == 0) {
            return d();
        }
        if (size != 1) {
            return set;
        }
        return d0.c(set.iterator().next());
    }

    @NotNull
    public static <T> Set<T> g(@NotNull T... tArr) {
        k21.i(tArr, "elements");
        return tArr.length > 0 ? ArraysKt___ArraysKt.j0(tArr) : d();
    }
}
