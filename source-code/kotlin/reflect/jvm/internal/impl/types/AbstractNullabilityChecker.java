package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;

/* compiled from: AbstractTypeChecker.kt */
public final class AbstractNullabilityChecker {
    public static final AbstractNullabilityChecker INSTANCE = new AbstractNullabilityChecker();

    private AbstractNullabilityChecker() {
    }

    public final boolean isPossibleSubtype(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        Intrinsics.checkParameterIsNotNull(abstractTypeCheckerContext, "context");
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "subType");
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker2, "superType");
        return runIsPossibleSubtype(abstractTypeCheckerContext, simpleTypeMarker, simpleTypeMarker2);
    }

    private final boolean runIsPossibleSubtype(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS) {
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker) && !abstractTypeCheckerContext.isIntersection(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker))) {
                abstractTypeCheckerContext.isAllowedTypeVariable(simpleTypeMarker);
            }
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker2)) {
                abstractTypeCheckerContext.isAllowedTypeVariable(simpleTypeMarker2);
            }
        }
        if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2) || abstractTypeCheckerContext.isDefinitelyNotNullType(simpleTypeMarker) || hasNotNullSupertype(abstractTypeCheckerContext, simpleTypeMarker, AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE)) {
            return true;
        }
        if (!abstractTypeCheckerContext.isDefinitelyNotNullType(simpleTypeMarker2) && !hasNotNullSupertype(abstractTypeCheckerContext, simpleTypeMarker2, AbstractTypeCheckerContext.SupertypesPolicy.UpperIfFlexible.INSTANCE) && !abstractTypeCheckerContext.isClassType(simpleTypeMarker)) {
            return hasPathByNotMarkedNullableNodes(abstractTypeCheckerContext, simpleTypeMarker, abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2));
        }
        return false;
    }

    public final boolean hasNotNullSupertype(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy) {
        Intrinsics.checkParameterIsNotNull(abstractTypeCheckerContext, "$this$hasNotNullSupertype");
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "type");
        Intrinsics.checkParameterIsNotNull(supertypesPolicy, "supertypesPolicy");
        if (!((abstractTypeCheckerContext.isClassType(simpleTypeMarker) && !abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker)) || abstractTypeCheckerContext.isDefinitelyNotNullType(simpleTypeMarker))) {
            abstractTypeCheckerContext.initialize();
            ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
            if (supertypesDeque == null) {
                Intrinsics.throwNpe();
            }
            Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
            if (supertypesSet == null) {
                Intrinsics.throwNpe();
            }
            supertypesDeque.push(simpleTypeMarker);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() <= 1000) {
                    SimpleTypeMarker pop = supertypesDeque.pop();
                    Intrinsics.checkExpressionValueIsNotNull(pop, "current");
                    if (supertypesSet.add(pop)) {
                        AbstractTypeCheckerContext.SupertypesPolicy.None none = abstractTypeCheckerContext.isMarkedNullable(pop) ? AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE : supertypesPolicy;
                        if (!(!Intrinsics.areEqual(none, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                            none = null;
                        }
                        if (none != null) {
                            for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                                SimpleTypeMarker transformType = none.transformType(abstractTypeCheckerContext, kotlinTypeMarker);
                                if ((abstractTypeCheckerContext.isClassType(transformType) && !abstractTypeCheckerContext.isMarkedNullable(transformType)) || abstractTypeCheckerContext.isDefinitelyNotNullType(transformType)) {
                                    abstractTypeCheckerContext.clear();
                                } else {
                                    supertypesDeque.add(transformType);
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                } else {
                    throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null)).toString());
                }
            }
            abstractTypeCheckerContext.clear();
            return false;
        }
        return true;
    }

    public final boolean hasPathByNotMarkedNullableNodes(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkParameterIsNotNull(abstractTypeCheckerContext, "$this$hasPathByNotMarkedNullableNodes");
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "start");
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "end");
        if (INSTANCE.isApplicableAsEndNode(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker)) {
            return true;
        }
        abstractTypeCheckerContext.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
        if (supertypesDeque == null) {
            Intrinsics.throwNpe();
        }
        Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
        if (supertypesSet == null) {
            Intrinsics.throwNpe();
        }
        supertypesDeque.push(simpleTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker pop = supertypesDeque.pop();
                Intrinsics.checkExpressionValueIsNotNull(pop, "current");
                if (supertypesSet.add(pop)) {
                    AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy = abstractTypeCheckerContext.isMarkedNullable(pop) ? AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE : AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    if (!(!Intrinsics.areEqual(supertypesPolicy, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy != null) {
                        for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                            SimpleTypeMarker transformType = supertypesPolicy.transformType(abstractTypeCheckerContext, kotlinTypeMarker);
                            if (INSTANCE.isApplicableAsEndNode(abstractTypeCheckerContext, transformType, typeConstructorMarker)) {
                                abstractTypeCheckerContext.clear();
                                return true;
                            }
                            supertypesDeque.add(transformType);
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null)).toString());
            }
        }
        abstractTypeCheckerContext.clear();
        return false;
    }

    private final boolean isApplicableAsEndNode(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        if (abstractTypeCheckerContext.isNothing(simpleTypeMarker)) {
            return true;
        }
        if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker)) {
            return false;
        }
        if (!abstractTypeCheckerContext.isStubTypeEqualsToAnything() || !abstractTypeCheckerContext.isStubType(simpleTypeMarker)) {
            return abstractTypeCheckerContext.isEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructorMarker);
        }
        return true;
    }
}
