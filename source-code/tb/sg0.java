package tb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class sg0 {
    @NotNull
    public static final sg0 INSTANCE;
    @NotNull
    private static final HashMap<en0, en0> a = new HashMap<>();

    static {
        sg0 sg0 = new sg0();
        INSTANCE = sg0;
        sg0.c(c.a.mutableList, sg0.a("java.util.ArrayList", "java.util.LinkedList"));
        sg0.c(c.a.mutableSet, sg0.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        sg0.c(c.a.mutableMap, sg0.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        sg0.c(new en0("java.util.function.Function"), sg0.a("java.util.function.UnaryOperator"));
        sg0.c(new en0("java.util.function.BiFunction"), sg0.a("java.util.function.BinaryOperator"));
    }

    private sg0() {
    }

    private final List<en0> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new en0(str));
        }
        return arrayList;
    }

    private final void c(en0 en0, List<en0> list) {
        HashMap<en0, en0> hashMap = a;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            hashMap.put(it.next(), en0);
        }
    }

    @Nullable
    public final en0 b(@NotNull en0 en0) {
        k21.i(en0, "classFqName");
        return a.get(en0);
    }
}
