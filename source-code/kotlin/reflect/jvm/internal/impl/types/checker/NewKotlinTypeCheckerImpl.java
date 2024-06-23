package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: NewKotlinTypeChecker.kt */
public final class NewKotlinTypeCheckerImpl implements NewKotlinTypeChecker {
    private final KotlinTypeRefiner kotlinTypeRefiner;
    private final OverridingUtil overridingUtil;

    public NewKotlinTypeCheckerImpl(KotlinTypeRefiner kotlinTypeRefiner2) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeRefiner2, "kotlinTypeRefiner");
        this.kotlinTypeRefiner = kotlinTypeRefiner2;
        OverridingUtil createWithTypeRefiner = OverridingUtil.createWithTypeRefiner(getKotlinTypeRefiner());
        Intrinsics.checkExpressionValueIsNotNull(createWithTypeRefiner, "OverridingUtil.createWit…efiner(kotlinTypeRefiner)");
        this.overridingUtil = createWithTypeRefiner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public KotlinTypeRefiner getKotlinTypeRefiner() {
        return this.kotlinTypeRefiner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public OverridingUtil getOverridingUtil() {
        return this.overridingUtil;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "subtype");
        Intrinsics.checkParameterIsNotNull(kotlinType2, "supertype");
        return isSubtypeOf(new ClassicTypeCheckerContext(true, false, false, getKotlinTypeRefiner(), 6, null), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean equalTypes(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "a");
        Intrinsics.checkParameterIsNotNull(kotlinType2, "b");
        return equalTypes(new ClassicTypeCheckerContext(false, false, false, getKotlinTypeRefiner(), 6, null), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    public final boolean equalTypes(ClassicTypeCheckerContext classicTypeCheckerContext, UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        Intrinsics.checkParameterIsNotNull(classicTypeCheckerContext, "$this$equalTypes");
        Intrinsics.checkParameterIsNotNull(unwrappedType, "a");
        Intrinsics.checkParameterIsNotNull(unwrappedType2, "b");
        return AbstractTypeChecker.INSTANCE.equalTypes(classicTypeCheckerContext, unwrappedType, unwrappedType2);
    }

    public final boolean isSubtypeOf(ClassicTypeCheckerContext classicTypeCheckerContext, UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        Intrinsics.checkParameterIsNotNull(classicTypeCheckerContext, "$this$isSubtypeOf");
        Intrinsics.checkParameterIsNotNull(unwrappedType, "subType");
        Intrinsics.checkParameterIsNotNull(unwrappedType2, "superType");
        return AbstractTypeChecker.INSTANCE.isSubtypeOf(classicTypeCheckerContext, unwrappedType, unwrappedType2);
    }

    public final SimpleType transformToNewType(SimpleType simpleType) {
        KotlinType type;
        Intrinsics.checkParameterIsNotNull(simpleType, "type");
        TypeConstructor constructor = simpleType.getConstructor();
        boolean z = true;
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        r4 = null;
        UnwrappedType unwrappedType = null;
        boolean z2 = false;
        if (constructor instanceof CapturedTypeConstructorImpl) {
            CapturedTypeConstructorImpl capturedTypeConstructorImpl = (CapturedTypeConstructorImpl) constructor;
            TypeProjection projection = capturedTypeConstructorImpl.getProjection();
            if (projection.getProjectionKind() != Variance.IN_VARIANCE) {
                z = false;
            }
            if (!z) {
                projection = null;
            }
            if (!(projection == null || (type = projection.getType()) == null)) {
                unwrappedType = type.unwrap();
            }
            if (capturedTypeConstructorImpl.getNewTypeConstructor() == null) {
                TypeProjection projection2 = capturedTypeConstructorImpl.getProjection();
                Collection<KotlinType> supertypes = capturedTypeConstructorImpl.getSupertypes();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(supertypes, 10));
                Iterator<T> it = supertypes.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().unwrap());
                }
                capturedTypeConstructorImpl.setNewTypeConstructor(new NewCapturedTypeConstructor(projection2, arrayList, null, 4, null));
            }
            CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
            NewCapturedTypeConstructor newTypeConstructor = capturedTypeConstructorImpl.getNewTypeConstructor();
            if (newTypeConstructor == null) {
                Intrinsics.throwNpe();
            }
            return new NewCapturedType(captureStatus, newTypeConstructor, unwrappedType, simpleType.getAnnotations(), simpleType.isMarkedNullable());
        } else if (constructor instanceof IntegerValueTypeConstructor) {
            Collection<KotlinType> supertypes2 = ((IntegerValueTypeConstructor) constructor).getSupertypes();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(supertypes2, 10));
            Iterator<T> it2 = supertypes2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(TypeUtils.makeNullableAsSpecified(it2.next(), simpleType.isMarkedNullable()));
            }
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(simpleType.getAnnotations(), new IntersectionTypeConstructor(arrayList2), CollectionsKt.emptyList(), false, simpleType.getMemberScope());
        } else if (!(constructor instanceof IntersectionTypeConstructor) || !simpleType.isMarkedNullable()) {
            return simpleType;
        } else {
            IntersectionTypeConstructor intersectionTypeConstructor2 = (IntersectionTypeConstructor) constructor;
            Collection<KotlinType> supertypes3 = intersectionTypeConstructor2.getSupertypes();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(supertypes3, 10));
            Iterator<T> it3 = supertypes3.iterator();
            while (it3.hasNext()) {
                arrayList3.add(TypeUtilsKt.makeNullable(it3.next()));
                z2 = true;
            }
            ArrayList arrayList4 = arrayList3;
            if (z2) {
                intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList4);
            }
            if (intersectionTypeConstructor != null) {
                intersectionTypeConstructor2 = intersectionTypeConstructor;
            }
            return intersectionTypeConstructor2.createType();
        }
    }

    public UnwrappedType transformToNewType(UnwrappedType unwrappedType) {
        SimpleType simpleType;
        Intrinsics.checkParameterIsNotNull(unwrappedType, "type");
        if (unwrappedType instanceof SimpleType) {
            simpleType = transformToNewType((SimpleType) unwrappedType);
        } else if (unwrappedType instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrappedType;
            SimpleType transformToNewType = transformToNewType(flexibleType.getLowerBound());
            SimpleType transformToNewType2 = transformToNewType(flexibleType.getUpperBound());
            if (transformToNewType == flexibleType.getLowerBound() && transformToNewType2 == flexibleType.getUpperBound()) {
                simpleType = unwrappedType;
            } else {
                simpleType = KotlinTypeFactory.flexibleType(transformToNewType, transformToNewType2);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(simpleType, unwrappedType);
    }
}
