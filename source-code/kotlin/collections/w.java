package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.MapBuilder;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class w extends v {
    @SinceKotlin(version = "1.3")
    @NotNull
    @PublishedApi
    public static <K, V> Map<K, V> b(@NotNull Map<K, V> map) {
        k21.i(map, "builder");
        return ((MapBuilder) map).build();
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    @PublishedApi
    public static <K, V> Map<K, V> c() {
        return new MapBuilder();
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    @PublishedApi
    public static <K, V> Map<K, V> d(int i) {
        return new MapBuilder(i);
    }

    @PublishedApi
    public static int e(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @NotNull
    public static <K, V> Map<K, V> f(@NotNull Pair<? extends K, ? extends V> pair) {
        k21.i(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        k21.h(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> g(@NotNull Map<? extends K, ? extends V> map) {
        k21.i(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        k21.h(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    @NotNull
    public static <K, V> SortedMap<K, V> h(@NotNull Map<? extends K, ? extends V> map, @NotNull Comparator<? super K> comparator) {
        k21.i(map, "<this>");
        k21.i(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
