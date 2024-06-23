package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class x extends w {
    @NotNull
    public static <K, V> Map<K, V> i() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        k21.g(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    @SinceKotlin(version = "1.1")
    public static <K, V> V j(@NotNull Map<K, ? extends V> map, K k) {
        k21.i(map, "<this>");
        return (V) v.a(map, k);
    }

    @NotNull
    public static <K, V> HashMap<K, V> k(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        k21.i(pairArr, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(w.e(pairArr.length));
        q(hashMap, pairArr);
        return hashMap;
    }

    @NotNull
    public static <K, V> Map<K, V> l(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        k21.i(pairArr, "pairs");
        return pairArr.length > 0 ? u(pairArr, new LinkedHashMap(w.e(pairArr.length))) : i();
    }

    @NotNull
    public static <K, V> Map<K, V> m(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        k21.i(pairArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(w.e(pairArr.length));
        q(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<K, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> n(@NotNull Map<K, ? extends V> map) {
        k21.i(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return i();
        }
        if (size != 1) {
            return map;
        }
        return w.g(map);
    }

    @NotNull
    public static <K, V> Map<K, V> o(@NotNull Map<? extends K, ? extends V> map, @NotNull Map<? extends K, ? extends V> map2) {
        k21.i(map, "<this>");
        k21.i(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final <K, V> void p(@NotNull Map<? super K, ? super V> map, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        k21.i(map, "<this>");
        k21.i(iterable, "pairs");
        Iterator<? extends Pair<? extends K, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            map.put((Object) pair.component1(), (Object) pair.component2());
        }
    }

    public static final <K, V> void q(@NotNull Map<? super K, ? super V> map, @NotNull Pair<? extends K, ? extends V>[] pairArr) {
        k21.i(map, "<this>");
        k21.i(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put((Object) pair.component1(), (Object) pair.component2());
        }
    }

    @NotNull
    public static <K, V> Map<K, V> r(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        k21.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return n(s(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return i();
        }
        if (size != 1) {
            return s(iterable, new LinkedHashMap(w.e(collection.size())));
        }
        return w.f((Pair) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M s(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable, @NotNull M m) {
        k21.i(iterable, "<this>");
        k21.i(m, "destination");
        p(m, iterable);
        return m;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <K, V> Map<K, V> t(@NotNull Map<? extends K, ? extends V> map) {
        k21.i(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return i();
        }
        if (size != 1) {
            return v(map);
        }
        return w.g(map);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M u(@NotNull Pair<? extends K, ? extends V>[] pairArr, @NotNull M m) {
        k21.i(pairArr, "<this>");
        k21.i(m, "destination");
        q(m, pairArr);
        return m;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <K, V> Map<K, V> v(@NotNull Map<? extends K, ? extends V> map) {
        k21.i(map, "<this>");
        return new LinkedHashMap(map);
    }
}
