package kotlin.collections;

import java.util.Iterator;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.1")
/* compiled from: Taobao */
public interface Grouping<T, K> {
    K keyOf(T t);

    @NotNull
    Iterator<T> sourceIterator();
}
