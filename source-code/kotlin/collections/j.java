package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.oj;

/* compiled from: Taobao */
public final class j {
    @NotNull
    public static final <T> Collection<T> a(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        k21.i(iterable, "<this>");
        k21.i(iterable2, "source");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (!(iterable instanceof Collection)) {
            return oj.brittleContainsOptimizationEnabled ? CollectionsKt___CollectionsKt.w0(iterable) : CollectionsKt___CollectionsKt.y0(iterable);
        }
        if ((iterable2 instanceof Collection) && ((Collection) iterable2).size() < 2) {
            return (Collection) iterable;
        }
        Collection<T> collection = (Collection) iterable;
        if (b(collection)) {
            return CollectionsKt___CollectionsKt.w0(iterable);
        }
        return collection;
    }

    private static final <T> boolean b(Collection<? extends T> collection) {
        return oj.brittleContainsOptimizationEnabled && collection.size() > 2 && (collection instanceof ArrayList);
    }
}
