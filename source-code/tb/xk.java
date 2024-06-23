package tb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class xk {
    @NotNull
    public static final xk INSTANCE = new xk();
    @NotNull
    private static final Set<oi> a;

    static {
        Set<PrimitiveType> set = PrimitiveType.NUMBER_TYPES;
        c cVar = c.INSTANCE;
        ArrayList arrayList = new ArrayList(n.q(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(c.c(it.next()));
        }
        en0 l = c.a.string.l();
        k21.h(l, "string.toSafe()");
        List list = CollectionsKt___CollectionsKt.l0(arrayList, l);
        en0 l2 = c.a._boolean.l();
        k21.h(l2, "_boolean.toSafe()");
        List list2 = CollectionsKt___CollectionsKt.l0(list, l2);
        en0 l3 = c.a._enum.l();
        k21.h(l3, "_enum.toSafe()");
        List<en0> list3 = CollectionsKt___CollectionsKt.l0(list2, l3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (en0 en0 : list3) {
            linkedHashSet.add(oi.m(en0));
        }
        a = linkedHashSet;
    }

    private xk() {
    }

    @NotNull
    public final Set<oi> a() {
        return a;
    }

    @NotNull
    public final Set<oi> b() {
        return a;
    }
}
