package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.SetBuilder;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class d0 {
    @SinceKotlin(version = "1.3")
    @NotNull
    @PublishedApi
    public static <E> Set<E> a(@NotNull Set<E> set) {
        k21.i(set, "builder");
        return ((SetBuilder) set).build();
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    @PublishedApi
    public static <E> Set<E> b(int i) {
        return new SetBuilder(i);
    }

    @NotNull
    public static <T> Set<T> c(T t) {
        Set<T> singleton = Collections.singleton(t);
        k21.h(singleton, "singleton(element)");
        return singleton;
    }
}
