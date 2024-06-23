package tb;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

public final class yo2 {
    public static final ib2 a(g61 g61) {
        k21.i(g61, "<this>");
        es2 f = g61.f();
        ib2 ib2 = f instanceof ib2 ? (ib2) f : null;
        if (ib2 != null) {
            return ib2;
        }
        throw new IllegalStateException(k21.r("This is should be simple type: ", g61).toString());
    }

    public static final g61 b(g61 g61, List<? extends TypeProjection> list, Annotations annotations) {
        k21.i(g61, "<this>");
        k21.i(list, "newArguments");
        k21.i(annotations, "newAnnotations");
        return e(g61, list, annotations, null, 4, null);
    }

    public static final g61 c(g61 g61, List<? extends TypeProjection> list, Annotations annotations, List<? extends TypeProjection> list2) {
        k21.i(g61, "<this>");
        k21.i(list, "newArguments");
        k21.i(annotations, "newAnnotations");
        k21.i(list2, "newArgumentsForUpperBound");
        if ((list.isEmpty() || list == g61.b()) && annotations == g61.getAnnotations()) {
            return g61;
        }
        es2 f = g61.f();
        if (f instanceof dj0) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            dj0 dj0 = (dj0) f;
            return KotlinTypeFactory.d(d(dj0.k(), list, annotations), d(dj0.l(), list2, annotations));
        } else if (f instanceof ib2) {
            return d((ib2) f, list, annotations);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final ib2 d(ib2 ib2, List<? extends TypeProjection> list, Annotations annotations) {
        k21.i(ib2, "<this>");
        k21.i(list, "newArguments");
        k21.i(annotations, "newAnnotations");
        if (list.isEmpty() && annotations == ib2.getAnnotations()) {
            return ib2;
        }
        if (list.isEmpty()) {
            return ib2.k(annotations);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.i(annotations, ib2.c(), list, ib2.d(), null, 16, null);
    }

    public static /* synthetic */ g61 e(g61 g61, List list, Annotations annotations, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = g61.b();
        }
        if ((i & 2) != 0) {
            annotations = g61.getAnnotations();
        }
        if ((i & 4) != 0) {
            list2 = list;
        }
        return c(g61, list, annotations, list2);
    }

    public static /* synthetic */ ib2 f(ib2 ib2, List list, Annotations annotations, int i, Object obj) {
        if ((i & 1) != 0) {
            list = ib2.b();
        }
        if ((i & 2) != 0) {
            annotations = ib2.getAnnotations();
        }
        return d(ib2, list, annotations);
    }
}
