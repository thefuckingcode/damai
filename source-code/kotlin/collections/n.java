package kotlin.collections;

import java.util.Collection;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class n extends m {
    @PublishedApi
    public static <T> int q(@NotNull Iterable<? extends T> iterable, int i) {
        k21.i(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    @PublishedApi
    @Nullable
    public static final <T> Integer r(@NotNull Iterable<? extends T> iterable) {
        k21.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }
}
