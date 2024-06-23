package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;

/* compiled from: inlineClassMapping.kt */
public final class InlineClassMappingKt {
    public static final KotlinTypeMarker computeExpandedTypeForInlineClass(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkParameterIsNotNull(typeSystemCommonBackendContext, "$this$computeExpandedTypeForInlineClass");
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "inlineClassType");
        return computeExpandedTypeInner(typeSystemCommonBackendContext, kotlinTypeMarker, new HashSet());
    }

    private static final KotlinTypeMarker computeExpandedTypeInner(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker, HashSet<TypeConstructorMarker> hashSet) {
        KotlinTypeMarker kotlinTypeMarker2;
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (!hashSet.add(typeConstructor)) {
            return null;
        }
        TypeParameterMarker typeParameterClassifier = typeSystemCommonBackendContext.getTypeParameterClassifier(typeConstructor);
        if (typeParameterClassifier != null) {
            kotlinTypeMarker2 = computeExpandedTypeInner(typeSystemCommonBackendContext, typeSystemCommonBackendContext.getRepresentativeUpperBound(typeParameterClassifier), hashSet);
            if (kotlinTypeMarker2 == null) {
                return null;
            }
            if (!typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker2) && typeSystemCommonBackendContext.isMarkedNullable(kotlinTypeMarker)) {
                return typeSystemCommonBackendContext.makeNullable(kotlinTypeMarker2);
            }
        } else if (!typeSystemCommonBackendContext.isInlineClass(typeConstructor)) {
            return kotlinTypeMarker;
        } else {
            KotlinTypeMarker substitutedUnderlyingType = typeSystemCommonBackendContext.getSubstitutedUnderlyingType(kotlinTypeMarker);
            if (substitutedUnderlyingType == null || (kotlinTypeMarker2 = computeExpandedTypeInner(typeSystemCommonBackendContext, substitutedUnderlyingType, hashSet)) == null) {
                return null;
            }
            if (typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker)) {
                if (typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker2)) {
                    return kotlinTypeMarker;
                }
                return (!(kotlinTypeMarker2 instanceof SimpleTypeMarker) || !typeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker) kotlinTypeMarker2)) ? typeSystemCommonBackendContext.makeNullable(kotlinTypeMarker2) : kotlinTypeMarker;
            }
        }
        return kotlinTypeMarker2;
    }
}
