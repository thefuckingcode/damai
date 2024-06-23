package kotlin.ranges;

import java.lang.Comparable;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.1")
/* compiled from: Taobao */
public interface ClosedFloatingPointRange<T extends Comparable<? super T>> extends ClosedRange<T> {
    @Override // kotlin.ranges.ClosedRange
    boolean contains(@NotNull T t);

    @Override // kotlin.ranges.ClosedRange
    boolean isEmpty();

    boolean lessThanOrEquals(@NotNull T t, @NotNull T t2);
}
