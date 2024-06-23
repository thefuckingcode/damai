package tb;

import com.taobao.aranger.constant.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class nd {
    @NotNull
    public static final nd INSTANCE = new nd();
    @NotNull
    private static final Map<en0, og1> a;
    @NotNull
    private static final Map<og1, List<og1>> b;
    @NotNull
    private static final Set<en0> c;
    @NotNull
    private static final Set<og1> d;

    static {
        fn0 fn0 = c.a._enum;
        en0 en0 = c.a.map;
        Map<en0, og1> map = x.l(do2.a(od.b(fn0, "name"), og1.f("name")), do2.a(od.b(fn0, "ordinal"), og1.f("ordinal")), do2.a(od.a(c.a.collection, "size"), og1.f("size")), do2.a(od.a(en0, "size"), og1.f("size")), do2.a(od.b(c.a.charSequence, "length"), og1.f("length")), do2.a(od.a(en0, Constants.PARAM_KEYS), og1.f("keySet")), do2.a(od.a(en0, "values"), og1.f("values")), do2.a(od.a(en0, "entries"), og1.f("entrySet")));
        a = map;
        Set<Map.Entry<en0, og1>> entrySet = map.entrySet();
        ArrayList<Pair> arrayList = new ArrayList(n.q(entrySet, 10));
        for (T t : entrySet) {
            arrayList.add(new Pair(((en0) t.getKey()).g(), t.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            og1 og1 = (og1) pair.getSecond();
            Object obj = linkedHashMap.get(og1);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(og1, obj);
            }
            ((List) obj).add((og1) pair.getFirst());
        }
        b = linkedHashMap;
        Set<en0> keySet = a.keySet();
        c = keySet;
        ArrayList arrayList2 = new ArrayList(n.q(keySet, 10));
        Iterator<T> it = keySet.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().g());
        }
        d = CollectionsKt___CollectionsKt.C0(arrayList2);
    }

    private nd() {
    }

    @NotNull
    public final Map<en0, og1> a() {
        return a;
    }

    @NotNull
    public final List<og1> b(@NotNull og1 og1) {
        k21.i(og1, "name1");
        List<og1> list = b.get(og1);
        return list == null ? m.g() : list;
    }

    @NotNull
    public final Set<en0> c() {
        return c;
    }

    @NotNull
    public final Set<og1> d() {
        return d;
    }
}
