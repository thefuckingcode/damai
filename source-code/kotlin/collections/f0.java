package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class f0 extends e0 {
    @NotNull
    public static <T> Set<T> h(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> iterable) {
        k21.i(set, "<this>");
        k21.i(iterable, "elements");
        Collection<?> a = j.a(iterable, set);
        if (a.isEmpty()) {
            return CollectionsKt___CollectionsKt.C0(set);
        }
        if (a instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : set) {
                if (!a.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(a);
        return linkedHashSet2;
    }

    @NotNull
    public static <T> Set<T> i(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> iterable) {
        int i;
        k21.i(set, "<this>");
        k21.i(iterable, "elements");
        Integer r = n.r(iterable);
        if (r != null) {
            i = set.size() + r.intValue();
        } else {
            i = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(w.e(i));
        linkedHashSet.addAll(set);
        boolean unused = r.v(linkedHashSet, iterable);
        return linkedHashSet;
    }

    @NotNull
    public static <T> Set<T> j(@NotNull Set<? extends T> set, T t) {
        k21.i(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(w.e(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }
}
