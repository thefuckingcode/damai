package tb;

import java.util.HashSet;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class vf0 {
    @Nullable
    public static final KotlinTypeMarker a(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
        k21.i(typeSystemCommonBackendContext, "<this>");
        k21.i(kotlinTypeMarker, "inlineClassType");
        return b(typeSystemCommonBackendContext, kotlinTypeMarker, new HashSet());
    }

    private static final KotlinTypeMarker b(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker, HashSet<TypeConstructorMarker> hashSet) {
        KotlinTypeMarker kotlinTypeMarker2;
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (!hashSet.add(typeConstructor)) {
            return null;
        }
        TypeParameterMarker typeParameterClassifier = typeSystemCommonBackendContext.getTypeParameterClassifier(typeConstructor);
        if (typeParameterClassifier != null) {
            kotlinTypeMarker2 = b(typeSystemCommonBackendContext, typeSystemCommonBackendContext.getRepresentativeUpperBound(typeParameterClassifier), hashSet);
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
            if (substitutedUnderlyingType == null || (kotlinTypeMarker2 = b(typeSystemCommonBackendContext, substitutedUnderlyingType, hashSet)) == null) {
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
