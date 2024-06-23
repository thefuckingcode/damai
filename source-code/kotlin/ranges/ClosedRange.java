package kotlin.ranges;

import java.lang.Comparable;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public interface ClosedRange<T extends Comparable<? super T>> {

    /* compiled from: Taobao */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@NotNull ClosedRange<T> closedRange, @NotNull T t) {
            k21.i(t, "value");
            return t.compareTo(closedRange.getStart()) >= 0 && t.compareTo(closedRange.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(@NotNull ClosedRange<T> closedRange) {
            return closedRange.getStart().compareTo(closedRange.getEndInclusive()) > 0;
        }
    }

    boolean contains(@NotNull T t);

    @NotNull
    T getEndInclusive();

    @NotNull
    T getStart();

    boolean isEmpty();
}
