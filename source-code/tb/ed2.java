package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ed2 {
    @Nullable
    public static final m0 a(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        es2 f = g61.f();
        if (f instanceof m0) {
            return (m0) f;
        }
        return null;
    }

    @Nullable
    public static final ib2 b(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        m0 a = a(g61);
        if (a == null) {
            return null;
        }
        return a.o();
    }

    public static final boolean c(@NotNull g61 g61) {
        k21.i(g61, "<this>");
        return g61.f() instanceof l50;
    }

    private static final IntersectionTypeConstructor d(IntersectionTypeConstructor intersectionTypeConstructor) {
        g61 g61;
        Collection<g61> supertypes = intersectionTypeConstructor.getSupertypes();
        ArrayList arrayList = new ArrayList(n.q(supertypes, 10));
        Iterator<T> it = supertypes.iterator();
        boolean z = false;
        while (true) {
            g61 = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (bp2.l(next)) {
                next = (T) f(next.f(), false, 1, null);
                z = true;
            }
            arrayList.add(next);
        }
        if (!z) {
            return null;
        }
        g61 c = intersectionTypeConstructor.c();
        if (c != null) {
            if (bp2.l(c)) {
                c = f(c.f(), false, 1, null);
            }
            g61 = c;
        }
        return new IntersectionTypeConstructor(arrayList).f(g61);
    }

    @NotNull
    public static final es2 e(@NotNull es2 es2, boolean z) {
        k21.i(es2, "<this>");
        l50 b = l50.Companion.b(es2, z);
        if (b != null) {
            return b;
        }
        ib2 g = g(es2);
        return g == null ? es2.g(false) : g;
    }

    public static /* synthetic */ es2 f(es2 es2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return e(es2, z);
    }

    private static final ib2 g(g61 g61) {
        IntersectionTypeConstructor d;
        TypeConstructor c = g61.c();
        IntersectionTypeConstructor intersectionTypeConstructor = c instanceof IntersectionTypeConstructor ? (IntersectionTypeConstructor) c : null;
        if (intersectionTypeConstructor == null || (d = d(intersectionTypeConstructor)) == null) {
            return null;
        }
        return d.b();
    }

    @NotNull
    public static final ib2 h(@NotNull ib2 ib2, boolean z) {
        k21.i(ib2, "<this>");
        l50 b = l50.Companion.b(ib2, z);
        if (b != null) {
            return b;
        }
        ib2 g = g(ib2);
        return g == null ? ib2.j(false) : g;
    }

    public static /* synthetic */ ib2 i(ib2 ib2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return h(ib2, z);
    }

    @NotNull
    public static final ib2 j(@NotNull ib2 ib2, @NotNull ib2 ib22) {
        k21.i(ib2, "<this>");
        k21.i(ib22, "abbreviatedType");
        if (h61.a(ib2)) {
            return ib2;
        }
        return new m0(ib2, ib22);
    }

    @NotNull
    public static final ai1 k(@NotNull ai1 ai1) {
        k21.i(ai1, "<this>");
        return new ai1(ai1.l(), ai1.c(), ai1.n(), ai1.getAnnotations(), ai1.d(), true);
    }
}
