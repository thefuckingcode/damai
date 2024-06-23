package tb;

import io.flutter.wpkbridge.WPKFactory;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class i2 {
    @NotNull
    public static final i2 INSTANCE = new i2();

    private i2() {
    }

    private final boolean a(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        int argumentsCount;
        if (typeSystemContext.argumentsCount(simpleTypeMarker) == typeSystemContext.argumentsCount(simpleTypeMarker2) && typeSystemContext.isMarkedNullable(simpleTypeMarker) == typeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
            if ((typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker) == null) == (typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker2) == null) && typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker), typeSystemContext.typeConstructor(simpleTypeMarker2))) {
                if (!typeSystemContext.identicalArguments(simpleTypeMarker, simpleTypeMarker2) && (argumentsCount = typeSystemContext.argumentsCount(simpleTypeMarker)) > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        TypeArgumentMarker argument = typeSystemContext.getArgument(simpleTypeMarker, i);
                        TypeArgumentMarker argument2 = typeSystemContext.getArgument(simpleTypeMarker2, i);
                        if (typeSystemContext.isStarProjection(argument) != typeSystemContext.isStarProjection(argument2)) {
                            return false;
                        }
                        if (!typeSystemContext.isStarProjection(argument) && (typeSystemContext.getVariance(argument) != typeSystemContext.getVariance(argument2) || !c(typeSystemContext, typeSystemContext.getType(argument), typeSystemContext.getType(argument2)))) {
                            return false;
                        }
                        if (i2 >= argumentsCount) {
                            break;
                        }
                        i = i2;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean c(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
        SimpleTypeMarker asSimpleType2 = typeSystemContext.asSimpleType(kotlinTypeMarker2);
        if (asSimpleType != null && asSimpleType2 != null) {
            return a(typeSystemContext, asSimpleType, asSimpleType2);
        }
        FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
        FlexibleTypeMarker asFlexibleType2 = typeSystemContext.asFlexibleType(kotlinTypeMarker2);
        if (asFlexibleType == null || asFlexibleType2 == null || !a(typeSystemContext, typeSystemContext.lowerBound(asFlexibleType), typeSystemContext.lowerBound(asFlexibleType2)) || !a(typeSystemContext, typeSystemContext.upperBound(asFlexibleType), typeSystemContext.upperBound(asFlexibleType2))) {
            return false;
        }
        return true;
    }

    public final boolean b(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        k21.i(typeSystemContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(kotlinTypeMarker, "a");
        k21.i(kotlinTypeMarker2, "b");
        return c(typeSystemContext, kotlinTypeMarker, kotlinTypeMarker2);
    }
}
