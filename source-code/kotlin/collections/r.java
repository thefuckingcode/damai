package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.po2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class r extends q {
    public static final <T> boolean A(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        k21.i(collection, "<this>");
        k21.i(iterable, "elements");
        return po2.a(collection).retainAll(j.a(iterable, collection));
    }

    public static <T> boolean v(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        k21.i(collection, "<this>");
        k21.i(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add((Object) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static <T> boolean w(@NotNull Collection<? super T> collection, @NotNull T[] tArr) {
        k21.i(collection, "<this>");
        k21.i(tArr, "elements");
        return collection.addAll(h.d(tArr));
    }

    private static final <T> boolean x(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (function1.invoke((Object) it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static <T> T y(@NotNull List<T> list) {
        k21.i(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(m.i(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> boolean z(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        k21.i(iterable, "<this>");
        k21.i(function1, "predicate");
        return x(iterable, function1, false);
    }
}
