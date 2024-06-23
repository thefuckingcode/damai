package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ii1 implements NewKotlinTypeChecker {
    @NotNull
    private final i61 a;
    @NotNull
    private final OverridingUtil b;

    public ii1(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        this.a = i61;
        OverridingUtil p = OverridingUtil.p(getKotlinTypeRefiner());
        k21.h(p, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.b = p;
    }

    public final boolean a(@NotNull ti tiVar, @NotNull es2 es2, @NotNull es2 es22) {
        k21.i(tiVar, "<this>");
        k21.i(es2, "a");
        k21.i(es22, "b");
        return m2.INSTANCE.i(tiVar, es2, es22);
    }

    public final boolean b(@NotNull ti tiVar, @NotNull es2 es2, @NotNull es2 es22) {
        k21.i(tiVar, "<this>");
        k21.i(es2, "subType");
        k21.i(es22, "superType");
        return m2.o(m2.INSTANCE, tiVar, es2, es22, false, 8, null);
    }

    @NotNull
    public final ib2 c(@NotNull ib2 ib2) {
        g61 type;
        k21.i(ib2, "type");
        TypeConstructor c = ib2.c();
        boolean z = true;
        boolean z2 = false;
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        r6 = null;
        es2 f = null;
        g61 g61 = null;
        if (c instanceof sf) {
            sf sfVar = (sf) c;
            TypeProjection projection = sfVar.getProjection();
            if (projection.getProjectionKind() != Variance.IN_VARIANCE) {
                z = false;
            }
            if (!z) {
                projection = null;
            }
            if (!(projection == null || (type = projection.getType()) == null)) {
                f = type.f();
            }
            if (sfVar.b() == null) {
                TypeProjection projection2 = sfVar.getProjection();
                Collection<g61> supertypes = sfVar.getSupertypes();
                ArrayList arrayList = new ArrayList(n.q(supertypes, 10));
                Iterator<T> it = supertypes.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().f());
                }
                sfVar.d(new NewCapturedTypeConstructor(projection2, arrayList, null, 4, null));
            }
            CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
            NewCapturedTypeConstructor b2 = sfVar.b();
            k21.f(b2);
            return new ai1(captureStatus, b2, f, ib2.getAnnotations(), ib2.d(), false, 32, null);
        } else if (c instanceof c21) {
            Collection<g61> supertypes2 = ((c21) c).getSupertypes();
            ArrayList arrayList2 = new ArrayList(n.q(supertypes2, 10));
            Iterator<T> it2 = supertypes2.iterator();
            while (it2.hasNext()) {
                g61 p = bp2.p(it2.next(), ib2.d());
                k21.h(p, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList2.add(p);
            }
            IntersectionTypeConstructor intersectionTypeConstructor2 = new IntersectionTypeConstructor(arrayList2);
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return KotlinTypeFactory.j(ib2.getAnnotations(), intersectionTypeConstructor2, m.g(), false, ib2.getMemberScope());
        } else if (!(c instanceof IntersectionTypeConstructor) || !ib2.d()) {
            return ib2;
        } else {
            IntersectionTypeConstructor intersectionTypeConstructor3 = (IntersectionTypeConstructor) c;
            Collection<g61> supertypes3 = intersectionTypeConstructor3.getSupertypes();
            ArrayList arrayList3 = new ArrayList(n.q(supertypes3, 10));
            Iterator<T> it3 = supertypes3.iterator();
            while (it3.hasNext()) {
                arrayList3.add(TypeUtilsKt.k(it3.next()));
                z2 = true;
            }
            if (z2) {
                g61 c2 = intersectionTypeConstructor3.c();
                if (c2 != null) {
                    g61 = TypeUtilsKt.k(c2);
                }
                intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList3).f(g61);
            }
            if (intersectionTypeConstructor != null) {
                intersectionTypeConstructor3 = intersectionTypeConstructor;
            }
            return intersectionTypeConstructor3.b();
        }
    }

    @NotNull
    public es2 d(@NotNull es2 es2) {
        es2 es22;
        k21.i(es2, "type");
        if (es2 instanceof ib2) {
            es22 = c((ib2) es2);
        } else if (es2 instanceof dj0) {
            dj0 dj0 = (dj0) es2;
            ib2 c = c(dj0.k());
            ib2 c2 = c(dj0.l());
            if (c == dj0.k() && c2 == dj0.l()) {
                es22 = es2;
            } else {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                es22 = KotlinTypeFactory.d(c, c2);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return cp2.b(es22, es2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean equalTypes(@NotNull g61 g61, @NotNull g61 g612) {
        k21.i(g61, "a");
        k21.i(g612, "b");
        return a(new ti(false, false, false, getKotlinTypeRefiner(), 6, null), g61.f(), g612.f());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    @NotNull
    public i61 getKotlinTypeRefiner() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    @NotNull
    public OverridingUtil getOverridingUtil() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean isSubtypeOf(@NotNull g61 g61, @NotNull g61 g612) {
        k21.i(g61, "subtype");
        k21.i(g612, "supertype");
        return b(new ti(true, false, false, getKotlinTypeRefiner(), 6, null), g61.f(), g612.f());
    }
}
