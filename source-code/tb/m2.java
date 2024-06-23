package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

public final class m2 {
    public static final m2 INSTANCE = new m2();
    public static boolean a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            iArr[TypeVariance.INV.ordinal()] = 1;
            iArr[TypeVariance.OUT.ordinal()] = 2;
            iArr[TypeVariance.IN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AbstractTypeCheckerContext.LowerCapturedTypePolicy.values().length];
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private m2() {
    }

    private final Boolean a(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        if (!abstractTypeCheckerContext.s(simpleTypeMarker) && !abstractTypeCheckerContext.s(simpleTypeMarker2)) {
            return null;
        }
        if (abstractTypeCheckerContext.s(simpleTypeMarker) && abstractTypeCheckerContext.s(simpleTypeMarker2)) {
            return Boolean.TRUE;
        }
        if (abstractTypeCheckerContext.s(simpleTypeMarker)) {
            if (c(abstractTypeCheckerContext, this, simpleTypeMarker, simpleTypeMarker2, false)) {
                return Boolean.TRUE;
            }
        } else if (abstractTypeCheckerContext.s(simpleTypeMarker2) && (b(abstractTypeCheckerContext, simpleTypeMarker) || c(abstractTypeCheckerContext, this, simpleTypeMarker2, simpleTypeMarker, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    private static final boolean b(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker) {
        boolean z;
        TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker);
        if (typeConstructor instanceof IntersectionTypeConstructorMarker) {
            Collection<KotlinTypeMarker> supertypes = abstractTypeCheckerContext.supertypes(typeConstructor);
            if (!(supertypes instanceof Collection) || !supertypes.isEmpty()) {
                Iterator<T> it = supertypes.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SimpleTypeMarker asSimpleType = abstractTypeCheckerContext.asSimpleType(it.next());
                    if (k21.d(asSimpleType == null ? null : Boolean.valueOf(abstractTypeCheckerContext.s(asSimpleType)), Boolean.TRUE)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static final boolean c(AbstractTypeCheckerContext abstractTypeCheckerContext, m2 m2Var, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2, boolean z) {
        boolean z2;
        Collection<KotlinTypeMarker> possibleIntegerTypes = abstractTypeCheckerContext.possibleIntegerTypes(simpleTypeMarker);
        if (!(possibleIntegerTypes instanceof Collection) || !possibleIntegerTypes.isEmpty()) {
            for (T t : possibleIntegerTypes) {
                if (k21.d(abstractTypeCheckerContext.typeConstructor((KotlinTypeMarker) t), abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2)) || (z && o(m2Var, abstractTypeCheckerContext, simpleTypeMarker2, t, false, 8, null))) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Boolean d(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        KotlinTypeMarker kotlinTypeMarker;
        boolean z = false;
        if (abstractTypeCheckerContext.isError(simpleTypeMarker) || abstractTypeCheckerContext.isError(simpleTypeMarker2)) {
            if (abstractTypeCheckerContext.r()) {
                return Boolean.TRUE;
            }
            if (!abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker) || abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2)) {
                return Boolean.valueOf(i2.INSTANCE.b(abstractTypeCheckerContext, abstractTypeCheckerContext.withNullability(simpleTypeMarker, false), abstractTypeCheckerContext.withNullability(simpleTypeMarker2, false)));
            }
            return Boolean.FALSE;
        } else if (abstractTypeCheckerContext.isStubType(simpleTypeMarker) || abstractTypeCheckerContext.isStubType(simpleTypeMarker2)) {
            return Boolean.valueOf(abstractTypeCheckerContext.u());
        } else {
            DefinitelyNotNullTypeMarker asDefinitelyNotNullType = abstractTypeCheckerContext.asDefinitelyNotNullType(simpleTypeMarker2);
            CapturedTypeMarker asCapturedType = abstractTypeCheckerContext.asCapturedType(asDefinitelyNotNullType == null ? simpleTypeMarker2 : abstractTypeCheckerContext.original(asDefinitelyNotNullType));
            if (asCapturedType == null) {
                kotlinTypeMarker = null;
            } else {
                kotlinTypeMarker = abstractTypeCheckerContext.lowerType(asCapturedType);
            }
            if (!(asCapturedType == null || kotlinTypeMarker == null)) {
                if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2)) {
                    kotlinTypeMarker = abstractTypeCheckerContext.withNullability(kotlinTypeMarker, true);
                } else if (abstractTypeCheckerContext.p(simpleTypeMarker2)) {
                    kotlinTypeMarker = abstractTypeCheckerContext.makeDefinitelyNotNullOrNotNull(kotlinTypeMarker);
                }
                int i = a.$EnumSwitchMapping$1[abstractTypeCheckerContext.i(simpleTypeMarker, asCapturedType).ordinal()];
                if (i == 1) {
                    return Boolean.valueOf(o(this, abstractTypeCheckerContext, simpleTypeMarker, kotlinTypeMarker, false, 8, null));
                }
                if (i == 2 && o(this, abstractTypeCheckerContext, simpleTypeMarker, kotlinTypeMarker, false, 8, null)) {
                    return Boolean.TRUE;
                }
            }
            TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2);
            if (!abstractTypeCheckerContext.isIntersection(typeConstructor)) {
                return null;
            }
            abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2);
            Collection<KotlinTypeMarker> supertypes = abstractTypeCheckerContext.supertypes(typeConstructor);
            if (!(supertypes instanceof Collection) || !supertypes.isEmpty()) {
                Iterator<T> it = supertypes.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!o(this, abstractTypeCheckerContext, simpleTypeMarker, it.next(), false, 8, null)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                return Boolean.valueOf(z);
            }
            z = true;
            return Boolean.valueOf(z);
        }
    }

    private final List<SimpleTypeMarker> e(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        AbstractTypeCheckerContext.a aVar;
        List<SimpleTypeMarker> g = abstractTypeCheckerContext.g(simpleTypeMarker, typeConstructorMarker);
        if (g == null) {
            if (!abstractTypeCheckerContext.isClassTypeConstructor(typeConstructorMarker) && abstractTypeCheckerContext.o(simpleTypeMarker)) {
                return m.g();
            }
            if (!abstractTypeCheckerContext.isCommonFinalClassConstructor(typeConstructorMarker)) {
                g = new ac2<>();
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
                            SimpleTypeMarker captureFromArguments = abstractTypeCheckerContext.captureFromArguments(pop, CaptureStatus.FOR_SUBTYPING);
                            if (captureFromArguments == null) {
                                captureFromArguments = pop;
                            }
                            if (abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(captureFromArguments), typeConstructorMarker)) {
                                g.add(captureFromArguments);
                                aVar = AbstractTypeCheckerContext.a.c.INSTANCE;
                            } else if (abstractTypeCheckerContext.argumentsCount(captureFromArguments) == 0) {
                                aVar = AbstractTypeCheckerContext.a.b.INSTANCE;
                            } else {
                                aVar = abstractTypeCheckerContext.x(captureFromArguments);
                            }
                            if (!(!k21.d(aVar, AbstractTypeCheckerContext.a.c.INSTANCE))) {
                                aVar = null;
                            }
                            if (aVar != null) {
                                for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                                    j.add(aVar.a(abstractTypeCheckerContext, kotlinTypeMarker));
                                }
                            }
                        }
                    } else {
                        throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt___CollectionsKt.Z(k, null, null, null, 0, null, null, 63, null)).toString());
                    }
                }
                abstractTypeCheckerContext.e();
            } else if (!abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructorMarker)) {
                return m.g();
            } else {
                SimpleTypeMarker captureFromArguments2 = abstractTypeCheckerContext.captureFromArguments(simpleTypeMarker, CaptureStatus.FOR_SUBTYPING);
                if (captureFromArguments2 != null) {
                    simpleTypeMarker = captureFromArguments2;
                }
                return l.e(simpleTypeMarker);
            }
        }
        return g;
    }

    private final List<SimpleTypeMarker> f(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        return q(abstractTypeCheckerContext, e(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker));
    }

    private final boolean g(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        Boolean d = d(abstractTypeCheckerContext, abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker), abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker2));
        if (d == null) {
            Boolean c = abstractTypeCheckerContext.c(kotlinTypeMarker, kotlinTypeMarker2, z);
            if (c == null) {
                return p(abstractTypeCheckerContext, abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker), abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker2));
            }
            return c.booleanValue();
        }
        boolean booleanValue = d.booleanValue();
        abstractTypeCheckerContext.c(kotlinTypeMarker, kotlinTypeMarker2, z);
        return booleanValue;
    }

    private final boolean k(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker) {
        AbstractTypeCheckerContext.a aVar;
        TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker);
        if (abstractTypeCheckerContext.isClassTypeConstructor(typeConstructor)) {
            return abstractTypeCheckerContext.isNothingConstructor(typeConstructor);
        }
        if (abstractTypeCheckerContext.isNothingConstructor(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker))) {
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
                    if (abstractTypeCheckerContext.o(pop)) {
                        aVar = AbstractTypeCheckerContext.a.c.INSTANCE;
                    } else {
                        aVar = AbstractTypeCheckerContext.a.b.INSTANCE;
                    }
                    if (!(!k21.d(aVar, AbstractTypeCheckerContext.a.c.INSTANCE))) {
                        aVar = null;
                    }
                    if (aVar == null) {
                        continue;
                    } else {
                        for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                            SimpleTypeMarker a2 = aVar.a(abstractTypeCheckerContext, kotlinTypeMarker);
                            if (abstractTypeCheckerContext.isNothingConstructor(abstractTypeCheckerContext.typeConstructor(a2))) {
                                abstractTypeCheckerContext.e();
                                return true;
                            }
                            j.add(a2);
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

    private final boolean l(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
        return abstractTypeCheckerContext.isDenotable(abstractTypeCheckerContext.typeConstructor(kotlinTypeMarker)) && !abstractTypeCheckerContext.q(kotlinTypeMarker) && !abstractTypeCheckerContext.p(kotlinTypeMarker) && k21.d(abstractTypeCheckerContext.typeConstructor(abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker)), abstractTypeCheckerContext.typeConstructor(abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker)));
    }

    public static /* synthetic */ boolean o(m2 m2Var, AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return m2Var.n(abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cf, code lost:
        if ((r19.getVariance(r5) == kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.INV) != false) goto L_0x00d1;
     */
    private final boolean p(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        boolean z;
        TypeConstructorMarker typeConstructorMarker;
        TypeConstructorMarker typeConstructorMarker2;
        if (a) {
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker) && !abstractTypeCheckerContext.isIntersection(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker))) {
                abstractTypeCheckerContext.n(simpleTypeMarker);
            }
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker2)) {
                abstractTypeCheckerContext.n(simpleTypeMarker2);
            }
        }
        if (!y1.INSTANCE.d(abstractTypeCheckerContext, simpleTypeMarker, simpleTypeMarker2)) {
            return false;
        }
        Boolean a2 = a(abstractTypeCheckerContext, abstractTypeCheckerContext.lowerBoundIfFlexible(simpleTypeMarker), abstractTypeCheckerContext.upperBoundIfFlexible(simpleTypeMarker2));
        if (a2 == null) {
            TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2);
            if ((abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructor) && abstractTypeCheckerContext.parametersCount(typeConstructor) == 0) || abstractTypeCheckerContext.isAnyConstructor(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2))) {
                return true;
            }
            List<SimpleTypeMarker> j = j(abstractTypeCheckerContext, simpleTypeMarker, typeConstructor);
            int size = j.size();
            if (size == 0) {
                return k(abstractTypeCheckerContext, simpleTypeMarker);
            }
            if (size == 1) {
                return m(abstractTypeCheckerContext, abstractTypeCheckerContext.asArgumentList((SimpleTypeMarker) k.P(j)), simpleTypeMarker2);
            }
            ArgumentList argumentList = new ArgumentList(abstractTypeCheckerContext.parametersCount(typeConstructor));
            int parametersCount = abstractTypeCheckerContext.parametersCount(typeConstructor);
            if (parametersCount > 0) {
                int i = 0;
                z = false;
                while (true) {
                    int i2 = i + 1;
                    z = z || abstractTypeCheckerContext.getVariance(abstractTypeCheckerContext.getParameter(typeConstructor, i)) != TypeVariance.OUT;
                    if (z) {
                        typeConstructorMarker = typeConstructor;
                    } else {
                        ArrayList arrayList = new ArrayList(n.q(j, 10));
                        for (T t : j) {
                            TypeArgumentMarker h = abstractTypeCheckerContext.h(t, i);
                            if (h == null) {
                                typeConstructorMarker2 = typeConstructor;
                            } else {
                                typeConstructorMarker2 = typeConstructor;
                            }
                            h = null;
                            if (h != null) {
                                arrayList.add(abstractTypeCheckerContext.getType(h));
                                typeConstructor = typeConstructorMarker2;
                            } else {
                                throw new IllegalStateException(("Incorrect type: " + ((Object) t) + ", subType: " + simpleTypeMarker + ", superType: " + simpleTypeMarker2).toString());
                            }
                        }
                        typeConstructorMarker = typeConstructor;
                        argumentList.add(abstractTypeCheckerContext.asTypeArgument(abstractTypeCheckerContext.intersectTypes(arrayList)));
                    }
                    if (i2 >= parametersCount) {
                        break;
                    }
                    i = i2;
                    typeConstructor = typeConstructorMarker;
                }
            } else {
                z = false;
            }
            if (!z && m(abstractTypeCheckerContext, argumentList, simpleTypeMarker2)) {
                return true;
            }
            if (!j.isEmpty()) {
                Iterator<T> it = j.iterator();
                while (it.hasNext()) {
                    if (m(abstractTypeCheckerContext, abstractTypeCheckerContext.asArgumentList(it.next()), simpleTypeMarker2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        boolean booleanValue = a2.booleanValue();
        AbstractTypeCheckerContext.d(abstractTypeCheckerContext, simpleTypeMarker, simpleTypeMarker2, false, 4, null);
        return booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker> */
    /* JADX WARN: Multi-variable type inference failed */
    private final List<SimpleTypeMarker> q(AbstractTypeCheckerContext abstractTypeCheckerContext, List<? extends SimpleTypeMarker> list) {
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            TypeArgumentListMarker asArgumentList = abstractTypeCheckerContext.asArgumentList((SimpleTypeMarker) next);
            int size = abstractTypeCheckerContext.size(asArgumentList);
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (!(abstractTypeCheckerContext.asFlexibleType(abstractTypeCheckerContext.getType(abstractTypeCheckerContext.get(asArgumentList, i))) == null)) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : list;
    }

    public final TypeVariance h(TypeVariance typeVariance, TypeVariance typeVariance2) {
        k21.i(typeVariance, "declared");
        k21.i(typeVariance2, "useSite");
        TypeVariance typeVariance3 = TypeVariance.INV;
        if (typeVariance == typeVariance3) {
            return typeVariance2;
        }
        if (typeVariance2 == typeVariance3 || typeVariance == typeVariance2) {
            return typeVariance;
        }
        return null;
    }

    public final boolean i(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        k21.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(kotlinTypeMarker, "a");
        k21.i(kotlinTypeMarker2, "b");
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        if (l(abstractTypeCheckerContext, kotlinTypeMarker) && l(abstractTypeCheckerContext, kotlinTypeMarker2)) {
            KotlinTypeMarker w = abstractTypeCheckerContext.w(kotlinTypeMarker);
            KotlinTypeMarker w2 = abstractTypeCheckerContext.w(kotlinTypeMarker2);
            SimpleTypeMarker lowerBoundIfFlexible = abstractTypeCheckerContext.lowerBoundIfFlexible(w);
            if (!abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(w), abstractTypeCheckerContext.typeConstructor(w2))) {
                return false;
            }
            if (abstractTypeCheckerContext.argumentsCount(lowerBoundIfFlexible) == 0) {
                if (abstractTypeCheckerContext.l(w) || abstractTypeCheckerContext.l(w2) || abstractTypeCheckerContext.isMarkedNullable(lowerBoundIfFlexible) == abstractTypeCheckerContext.isMarkedNullable(abstractTypeCheckerContext.lowerBoundIfFlexible(w2))) {
                    return true;
                }
                return false;
            }
        }
        if (!o(this, abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2, false, 8, null) || !o(this, abstractTypeCheckerContext, kotlinTypeMarker2, kotlinTypeMarker, false, 8, null)) {
            return false;
        }
        return true;
    }

    public final List<SimpleTypeMarker> j(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        AbstractTypeCheckerContext.a aVar;
        k21.i(abstractTypeCheckerContext, "<this>");
        k21.i(simpleTypeMarker, "subType");
        k21.i(typeConstructorMarker, "superConstructor");
        if (abstractTypeCheckerContext.o(simpleTypeMarker)) {
            return f(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker);
        }
        if (!(abstractTypeCheckerContext.isClassTypeConstructor(typeConstructorMarker) || abstractTypeCheckerContext.isIntegerLiteralTypeConstructor(typeConstructorMarker))) {
            return e(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker);
        }
        ac2<SimpleTypeMarker> ac2 = new ac2();
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
                    if (abstractTypeCheckerContext.o(pop)) {
                        ac2.add(pop);
                        aVar = AbstractTypeCheckerContext.a.c.INSTANCE;
                    } else {
                        aVar = AbstractTypeCheckerContext.a.b.INSTANCE;
                    }
                    if (!(!k21.d(aVar, AbstractTypeCheckerContext.a.c.INSTANCE))) {
                        aVar = null;
                    }
                    if (aVar != null) {
                        for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                            j.add(aVar.a(abstractTypeCheckerContext, kotlinTypeMarker));
                        }
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt___CollectionsKt.Z(k, null, null, null, 0, null, null, 63, null)).toString());
            }
        }
        abstractTypeCheckerContext.e();
        ArrayList arrayList = new ArrayList();
        for (SimpleTypeMarker simpleTypeMarker2 : ac2) {
            k21.h(simpleTypeMarker2, AdvanceSetting.NETWORK_TYPE);
            boolean unused = r.v(arrayList, f(abstractTypeCheckerContext, simpleTypeMarker2, typeConstructorMarker));
        }
        return arrayList;
    }

    public final boolean m(AbstractTypeCheckerContext abstractTypeCheckerContext, TypeArgumentListMarker typeArgumentListMarker, SimpleTypeMarker simpleTypeMarker) {
        boolean z;
        k21.i(abstractTypeCheckerContext, "<this>");
        k21.i(typeArgumentListMarker, "capturedSubArguments");
        k21.i(simpleTypeMarker, "superType");
        TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker);
        int parametersCount = abstractTypeCheckerContext.parametersCount(typeConstructor);
        if (parametersCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                TypeArgumentMarker argument = abstractTypeCheckerContext.getArgument(simpleTypeMarker, i);
                if (!abstractTypeCheckerContext.isStarProjection(argument)) {
                    KotlinTypeMarker type = abstractTypeCheckerContext.getType(argument);
                    TypeArgumentMarker typeArgumentMarker = abstractTypeCheckerContext.get(typeArgumentListMarker, i);
                    abstractTypeCheckerContext.getVariance(typeArgumentMarker);
                    TypeVariance typeVariance = TypeVariance.INV;
                    KotlinTypeMarker type2 = abstractTypeCheckerContext.getType(typeArgumentMarker);
                    TypeVariance h = h(abstractTypeCheckerContext.getVariance(abstractTypeCheckerContext.getParameter(typeConstructor, i)), abstractTypeCheckerContext.getVariance(argument));
                    if (h == null) {
                        return abstractTypeCheckerContext.r();
                    }
                    if (abstractTypeCheckerContext.a <= 100) {
                        abstractTypeCheckerContext.a = abstractTypeCheckerContext.a + 1;
                        int i3 = a.$EnumSwitchMapping$0[h.ordinal()];
                        if (i3 == 1) {
                            z = i(abstractTypeCheckerContext, type2, type);
                        } else if (i3 == 2) {
                            z = o(this, abstractTypeCheckerContext, type2, type, false, 8, null);
                        } else if (i3 == 3) {
                            z = o(this, abstractTypeCheckerContext, type, type2, false, 8, null);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        abstractTypeCheckerContext.a = abstractTypeCheckerContext.a - 1;
                        if (!z) {
                            return false;
                        }
                    } else {
                        throw new IllegalStateException(k21.r("Arguments depth is too high. Some related argument: ", type2).toString());
                    }
                }
                if (i2 >= parametersCount) {
                    break;
                }
                i = i2;
            }
        }
        return true;
    }

    public final boolean n(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        k21.i(abstractTypeCheckerContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(kotlinTypeMarker, "subType");
        k21.i(kotlinTypeMarker2, "superType");
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        if (!abstractTypeCheckerContext.f(kotlinTypeMarker, kotlinTypeMarker2)) {
            return false;
        }
        return g(abstractTypeCheckerContext, abstractTypeCheckerContext.v(abstractTypeCheckerContext.w(kotlinTypeMarker)), abstractTypeCheckerContext.v(abstractTypeCheckerContext.w(kotlinTypeMarker2)), z);
    }
}
