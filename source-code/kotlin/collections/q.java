package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class q extends p {
    public static final <T extends Comparable<? super T>> void t(@NotNull List<T> list) {
        k21.i(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static <T> void u(@NotNull List<T> list, @NotNull Comparator<? super T> comparator) {
        k21.i(list, "<this>");
        k21.i(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
