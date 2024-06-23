package tb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.k;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class j21 {
    @NotNull
    public static final es2 a(@NotNull List<? extends es2> list) {
        T t;
        k21.i(list, "types");
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types".toString());
        } else if (size == 1) {
            return (es2) k.o0(list);
        } else {
            ArrayList arrayList = new ArrayList(n.q(list, 10));
            boolean z = false;
            boolean z2 = false;
            for (T t2 : list) {
                z = z || h61.a(t2);
                if (t2 instanceof ib2) {
                    t = t2;
                } else if (!(t2 instanceof dj0)) {
                    throw new NoWhenBranchMatchedException();
                } else if (oc0.a(t2)) {
                    return t2;
                } else {
                    t = t2.k();
                    z2 = true;
                }
                arrayList.add(t);
            }
            if (z) {
                ib2 j = me0.j(k21.r("Intersection of error types: ", list));
                k21.h(j, "createErrorType(\"Intersection of error types: $types\")");
                return j;
            } else if (!z2) {
                return TypeIntersector.INSTANCE.c(arrayList);
            } else {
                ArrayList arrayList2 = new ArrayList(n.q(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(gj0.d(it.next()));
                }
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                TypeIntersector typeIntersector = TypeIntersector.INSTANCE;
                return KotlinTypeFactory.d(typeIntersector.c(arrayList), typeIntersector.c(arrayList2));
            }
        }
    }
}
