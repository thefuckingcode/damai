package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: NewCapturedType.kt */
public final class NewCapturedTypeKt {
    public static final SimpleType captureFromArguments(SimpleType simpleType, CaptureStatus captureStatus) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(simpleType, "type");
        Intrinsics.checkParameterIsNotNull(captureStatus, "status");
        if (simpleType.getArguments().size() != simpleType.getConstructor().getParameters().size()) {
            return null;
        }
        List<TypeProjection> arguments = simpleType.getArguments();
        List<TypeProjection> list = arguments;
        boolean z2 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().getProjectionKind() == Variance.INVARIANT) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    z2 = false;
                    break;
                }
            }
        }
        if (z2) {
            return null;
        }
        List<TypeParameterDescriptor> parameters = simpleType.getConstructor().getParameters();
        Intrinsics.checkExpressionValueIsNotNull(parameters, "type.constructor.parameters");
        List<Pair> zip = CollectionsKt.zip(list, parameters);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(zip, 10));
        for (Pair pair : zip) {
            TypeProjection typeProjection = (TypeProjection) pair.component1();
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) pair.component2();
            if (typeProjection.getProjectionKind() != Variance.INVARIANT) {
                UnwrappedType unwrap = (typeProjection.isStarProjection() || typeProjection.getProjectionKind() != Variance.IN_VARIANCE) ? null : typeProjection.getType().unwrap();
                Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor, "parameter");
                typeProjection = TypeUtilsKt.asTypeProjection(new NewCapturedType(captureStatus, unwrap, typeProjection, typeParameterDescriptor));
            }
            arrayList.add(typeProjection);
        }
        ArrayList arrayList2 = arrayList;
        TypeSubstitutor buildSubstitutor = TypeConstructorSubstitution.Companion.create(simpleType.getConstructor(), arrayList2).buildSubstitutor();
        int size = arguments.size();
        for (int i = 0; i < size; i++) {
            TypeProjection typeProjection2 = arguments.get(i);
            TypeProjection typeProjection3 = (TypeProjection) arrayList2.get(i);
            if (typeProjection2.getProjectionKind() != Variance.INVARIANT) {
                TypeParameterDescriptor typeParameterDescriptor2 = simpleType.getConstructor().getParameters().get(i);
                Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor2, "type.constructor.parameters[index]");
                List<KotlinType> upperBounds = typeParameterDescriptor2.getUpperBounds();
                Intrinsics.checkExpressionValueIsNotNull(upperBounds, "type.constructor.parameters[index].upperBounds");
                ArrayList arrayList3 = new ArrayList();
                Iterator<T> it2 = upperBounds.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(NewKotlinTypeChecker.Companion.getDefault().transformToNewType(buildSubstitutor.safeSubstitute(it2.next(), Variance.INVARIANT).unwrap()));
                }
                ArrayList arrayList4 = arrayList3;
                if (!typeProjection2.isStarProjection() && typeProjection2.getProjectionKind() == Variance.OUT_VARIANCE) {
                    arrayList4.add(NewKotlinTypeChecker.Companion.getDefault().transformToNewType(typeProjection2.getType().unwrap()));
                }
                KotlinType type = typeProjection3.getType();
                if (type != null) {
                    ((NewCapturedType) type).getConstructor().initializeSupertypes(arrayList4);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                }
            }
        }
        return KotlinTypeFactory.simpleType$default(simpleType.getAnnotations(), simpleType.getConstructor(), arrayList2, simpleType.isMarkedNullable(), null, 16, null);
    }
}
