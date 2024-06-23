package tb;

import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class y1 {
    @NotNull
    public static final y1 INSTANCE = new y1();

    private y1() {
    }

    private final boolean c(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        if (abstractTypeCheckerContext.t(simpleTypeMarker)) {
            return true;
        }
        if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker)) {
            return false;
        }
        if (!abstractTypeCheckerContext.u() || !abstractTypeCheckerContext.isStubType(simpleTypeMarker)) {
            return abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructorMarker);
        }
        return true;
    }

    private final boolean e(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        if (m2.a) {
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker) && !abstractTypeCheckerContext.isIntersection(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker))) {
                abstractTypeCheckerContext.n(simpleTypeMarker);
            }
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker2)) {
                abstractTypeCheckerContext.n(simpleTypeMarker2);
            }
        }
        if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2) || abstractTypeCheckerContext.p(simpleTypeMarker)) {
            return true;
        }
        if (((simpleTypeMarker instanceof CapturedTypeMarker) && abstractTypeCheckerContext.isProjectionNotNull((CapturedTypeMarker) simpleTypeMarker)) || a(abstractTypeCheckerContext, simpleTypeMarker, AbstractTypeCheckerContext.a.b.INSTANCE)) {
            return true;
        }
        if (!abstractTypeCheckerContext.p(simpleTypeMarker2) && !a(abstractTypeCheckerContext, simpleTypeMarker2, AbstractTypeCheckerContext.a.d.INSTANCE) && !abstractTypeCheckerContext.o(simpleTypeMarker)) {
            return b(abstractTypeCheckerContext, simpleTypeMarker, abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2));
        }
        return false;
    }

    public final boolean a(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull AbstractTypeCheckerContext.a aVar) {
        k21.i(abstractTypeCheckerContext, "<this>");
        k21.i(simpleTypeMarker, "type");
        k21.i(aVar, "supertypesPolicy");
        if (!((abstractTypeCheckerContext.o(simpleTypeMarker) && !abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker)) || abstractTypeCheckerContext.p(simpleTypeMarker))) {
            abstractTypeCheckerContext.m();
            ArrayDeque<SimpleTypeMarker> j = abstractTypeCheckerContext.j();
            k21.f(j);
            Set<SimpleTypeMarker> k = abstractTypeCheckerContext.k();
            k21.f(k);
            j.push(simpleTypeMarker);
            while (!j.isEmpty()) {
                if (k.size() <= 1000) {
                    SimpleTypeMarker pop = j.pop();
                    k21.h(pop, "current");
                    if (k.add(pop)) {
                        AbstractTypeCheckerContext.a aVar2 = abstractTypeCheckerContext.isMarkedNullable(pop) ? AbstractTypeCheckerContext.a.c.INSTANCE : aVar;
                        if (!(!k21.d(aVar2, AbstractTypeCheckerContext.a.c.INSTANCE))) {
                            aVar2 = null;
                        }
                        if (aVar2 == null) {
                            continue;
                        } else {
                            for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                                SimpleTypeMarker a = aVar2.a(abstractTypeCheckerContext, kotlinTypeMarker);
                                if ((abstractTypeCheckerContext.o(a) && !abstractTypeCheckerContext.isMarkedNullable(a)) || abstractTypeCheckerContext.p(a)) {
                                    abstractTypeCheckerContext.e();
                                } else {
                                    j.add(a);
                                }
                            }
                            continue;
                        }
                    }
                } else {
                    throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt___CollectionsKt.Z(k, null, null, null, 0, null, null, 63, null)).toString());
                }
            }
            abstractTypeCheckerContext.e();
            return false;
        }
        return true;
    }

    public final boolean b(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
        k21.i(abstractTypeCheckerContext, "<this>");
        k21.i(simpleTypeMarker, "start");
        k21.i(typeConstructorMarker, "end");
        if (c(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker)) {
            return true;
        }
        abstractTypeCheckerContext.m();
        ArrayDeque<SimpleTypeMarker> j = abstractTypeCheckerContext.j();
        k21.f(j);
        Set<SimpleTypeMarker> k = abstractTypeCheckerContext.k();
        k21.f(k);
        j.push(simpleTypeMarker);
        while (!j.isEmpty()) {
            if (k.size() <= 1000) {
                SimpleTypeMarker pop = j.pop();
                k21.h(pop, "current");
                if (k.add(pop)) {
                    AbstractTypeCheckerContext.a aVar = abstractTypeCheckerContext.isMarkedNullable(pop) ? AbstractTypeCheckerContext.a.c.INSTANCE : AbstractTypeCheckerContext.a.b.INSTANCE;
                    if (!(!k21.d(aVar, AbstractTypeCheckerContext.a.c.INSTANCE))) {
                        aVar = null;
                    }
                    if (aVar == null) {
                        continue;
                    } else {
                        for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                            SimpleTypeMarker a = aVar.a(abstractTypeCheckerContext, kotlinTypeMarker);
                            if (c(abstractTypeCheckerContext, a, typeConstructorMarker)) {
                                abstractTypeCheckerContext.e();
                                return true;
                            }
                            j.add(a);
                        }
                        continue;
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt___CollectionsKt.Z(k, null, null, null, 0, null, null, 63, null)).toString());
            }
        }
        abstractTypeCheckerContext.e();
        return false;
    }

    public final boolean d(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
        k21.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(simpleTypeMarker, "subType");
        k21.i(simpleTypeMarker2, "superType");
        return e(abstractTypeCheckerContext, simpleTypeMarker, simpleTypeMarker2);
    }
}
