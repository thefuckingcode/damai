package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class qj {
    public static final <T> void a(@NotNull Collection<T> collection, @Nullable T t) {
        k21.i(collection, "<this>");
        if (t != null) {
            collection.add(t);
        }
    }

    private static final int b(int i) {
        if (i < 3) {
            return 3;
        }
        return i + (i / 3) + 1;
    }

    @NotNull
    public static final <T> List<T> c(@NotNull ArrayList<T> arrayList) {
        k21.i(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return m.g();
        }
        if (size == 1) {
            return l.e(k.P(arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K> Map<K, Integer> d(@NotNull Iterable<? extends K> iterable) {
        k21.i(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends K> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i));
            i++;
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> HashMap<K, V> e(int i) {
        return new HashMap<>(b(i));
    }

    @NotNull
    public static final <E> HashSet<E> f(int i) {
        return new HashSet<>(b(i));
    }

    @NotNull
    public static final <E> LinkedHashSet<E> g(int i) {
        return new LinkedHashSet<>(b(i));
    }
}
