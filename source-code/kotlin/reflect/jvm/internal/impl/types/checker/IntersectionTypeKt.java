package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: IntersectionType.kt */
public final class IntersectionTypeKt {
    public static final UnwrappedType intersectTypes(List<? extends UnwrappedType> list) {
        T t;
        Intrinsics.checkParameterIsNotNull(list, "types");
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types".toString());
        } else if (size == 1) {
            return (UnwrappedType) CollectionsKt.single((List) list);
        } else {
            List<? extends UnwrappedType> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            boolean z = false;
            boolean z2 = false;
            for (T t2 : list2) {
                z = z || KotlinTypeKt.isError(t2);
                if (t2 instanceof SimpleType) {
                    t = t2;
                } else if (!(t2 instanceof FlexibleType)) {
                    throw new NoWhenBranchMatchedException();
                } else if (DynamicTypesKt.isDynamic(t2)) {
                    return t2;
                } else {
                    t = t2.getLowerBound();
                    z2 = true;
                }
                arrayList.add(t);
            }
            ArrayList arrayList2 = arrayList;
            if (z) {
                SimpleType createErrorType = ErrorUtils.createErrorType("Intersection of error types: " + list);
                Intrinsics.checkExpressionValueIsNotNull(createErrorType, "ErrorUtils.createErrorTy… of error types: $types\")");
                return createErrorType;
            } else if (!z2) {
                return TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList2);
            } else {
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(FlexibleTypesKt.upperIfFlexible(it.next()));
                }
                return KotlinTypeFactory.flexibleType(TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList2), TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList3));
            }
        }
    }
}
