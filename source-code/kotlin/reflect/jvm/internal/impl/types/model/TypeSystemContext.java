package kotlin.reflect.jvm.internal.impl.types.model;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.tencent.open.SocialConstants;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dz1;
import tb.k21;

/* compiled from: Taobao */
public interface TypeSystemContext extends TypeSystemOptimizationContext {

    /* compiled from: Taobao */
    public static final class a {
        @Nullable
        public static List<SimpleTypeMarker> a(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
            k21.i(typeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            k21.i(typeConstructorMarker, "constructor");
            return null;
        }

        @NotNull
        public static TypeArgumentMarker b(@NotNull TypeSystemContext typeSystemContext, @NotNull TypeArgumentListMarker typeArgumentListMarker, int i) {
            k21.i(typeSystemContext, "this");
            k21.i(typeArgumentListMarker, SocialConstants.PARAM_RECEIVER);
            if (typeArgumentListMarker instanceof SimpleTypeMarker) {
                return typeSystemContext.getArgument((KotlinTypeMarker) typeArgumentListMarker, i);
            }
            if (typeArgumentListMarker instanceof ArgumentList) {
                Object obj = ((ArgumentList) typeArgumentListMarker).get(i);
                k21.h(obj, "get(index)");
                return (TypeArgumentMarker) obj;
            }
            throw new IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeArgumentListMarker.getClass())).toString());
        }

        @Nullable
        public static TypeArgumentMarker c(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, int i) {
            k21.i(typeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            boolean z = false;
            if (i >= 0 && i < typeSystemContext.argumentsCount(simpleTypeMarker)) {
                z = true;
            }
            if (z) {
                return typeSystemContext.getArgument(simpleTypeMarker, i);
            }
            return null;
        }

        public static boolean d(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(typeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return typeSystemContext.isMarkedNullable(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker)) != typeSystemContext.isMarkedNullable(typeSystemContext.upperBoundIfFlexible(kotlinTypeMarker));
        }

        public static boolean e(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            k21.i(typeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            return typeSystemContext.isClassTypeConstructor(typeSystemContext.typeConstructor(simpleTypeMarker));
        }

        public static boolean f(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(typeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
            return (asSimpleType == null ? null : typeSystemContext.asDefinitelyNotNullType(asSimpleType)) != null;
        }

        public static boolean g(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(typeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
            return (asFlexibleType == null ? null : typeSystemContext.asDynamicType(asFlexibleType)) != null;
        }

        public static boolean h(@NotNull TypeSystemContext typeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            k21.i(typeSystemContext, "this");
            k21.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            return typeSystemContext.isIntegerLiteralTypeConstructor(typeSystemContext.typeConstructor(simpleTypeMarker));
        }

        public static boolean i(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(typeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return (kotlinTypeMarker instanceof SimpleTypeMarker) && typeSystemContext.isMarkedNullable((SimpleTypeMarker) kotlinTypeMarker);
        }

        public static boolean j(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(typeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(kotlinTypeMarker)) && !typeSystemContext.isNullableType(kotlinTypeMarker);
        }

        @NotNull
        public static SimpleTypeMarker k(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(typeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
            if (asFlexibleType != null) {
                return typeSystemContext.lowerBound(asFlexibleType);
            }
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
            k21.f(asSimpleType);
            return asSimpleType;
        }

        public static int l(@NotNull TypeSystemContext typeSystemContext, @NotNull TypeArgumentListMarker typeArgumentListMarker) {
            k21.i(typeSystemContext, "this");
            k21.i(typeArgumentListMarker, SocialConstants.PARAM_RECEIVER);
            if (typeArgumentListMarker instanceof SimpleTypeMarker) {
                return typeSystemContext.argumentsCount((KotlinTypeMarker) typeArgumentListMarker);
            }
            if (typeArgumentListMarker instanceof ArgumentList) {
                return ((ArgumentList) typeArgumentListMarker).size();
            }
            throw new IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + AVFSCacheConstants.COMMA_SEP + dz1.b(typeArgumentListMarker.getClass())).toString());
        }

        @NotNull
        public static TypeConstructorMarker m(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(typeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
            if (asSimpleType == null) {
                asSimpleType = typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker);
            }
            return typeSystemContext.typeConstructor(asSimpleType);
        }

        @NotNull
        public static SimpleTypeMarker n(@NotNull TypeSystemContext typeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(typeSystemContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
            if (asFlexibleType != null) {
                return typeSystemContext.upperBound(asFlexibleType);
            }
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
            k21.f(asSimpleType);
            return asSimpleType;
        }
    }

    boolean areEqualTypeConstructors(@NotNull TypeConstructorMarker typeConstructorMarker, @NotNull TypeConstructorMarker typeConstructorMarker2);

    int argumentsCount(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeArgumentListMarker asArgumentList(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Nullable
    CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Nullable
    DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Nullable
    DynamicTypeMarker asDynamicType(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @Nullable
    FlexibleTypeMarker asFlexibleType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @Nullable
    SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeArgumentMarker asTypeArgument(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @Nullable
    SimpleTypeMarker captureFromArguments(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CaptureStatus captureStatus);

    @NotNull
    TypeArgumentMarker get(@NotNull TypeArgumentListMarker typeArgumentListMarker, int i);

    @NotNull
    TypeArgumentMarker getArgument(@NotNull KotlinTypeMarker kotlinTypeMarker, int i);

    @NotNull
    TypeParameterMarker getParameter(@NotNull TypeConstructorMarker typeConstructorMarker, int i);

    @NotNull
    KotlinTypeMarker getType(@NotNull TypeArgumentMarker typeArgumentMarker);

    @NotNull
    TypeVariance getVariance(@NotNull TypeArgumentMarker typeArgumentMarker);

    @NotNull
    TypeVariance getVariance(@NotNull TypeParameterMarker typeParameterMarker);

    @NotNull
    KotlinTypeMarker intersectTypes(@NotNull List<? extends KotlinTypeMarker> list);

    boolean isAnyConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isClassTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isCommonFinalClassConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isDenotable(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isError(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isIntegerLiteralTypeConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isIntersection(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isMarkedNullable(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isMarkedNullable(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isNothingConstructor(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isNullableType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    boolean isPrimitiveType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isProjectionNotNull(@NotNull CapturedTypeMarker capturedTypeMarker);

    boolean isSingleClassifierType(@NotNull SimpleTypeMarker simpleTypeMarker);

    boolean isStarProjection(@NotNull TypeArgumentMarker typeArgumentMarker);

    boolean isStubType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @NotNull
    SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @NotNull
    SimpleTypeMarker lowerBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @Nullable
    KotlinTypeMarker lowerType(@NotNull CapturedTypeMarker capturedTypeMarker);

    @NotNull
    KotlinTypeMarker makeDefinitelyNotNullOrNotNull(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    SimpleTypeMarker original(@NotNull DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker);

    int parametersCount(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull SimpleTypeMarker simpleTypeMarker);

    int size(@NotNull TypeArgumentListMarker typeArgumentListMarker);

    @NotNull
    Collection<KotlinTypeMarker> supertypes(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    TypeConstructorMarker typeConstructor(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker simpleTypeMarker);

    @NotNull
    SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @NotNull
    SimpleTypeMarker upperBoundIfFlexible(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    KotlinTypeMarker withNullability(@NotNull KotlinTypeMarker kotlinTypeMarker, boolean z);

    @NotNull
    SimpleTypeMarker withNullability(@NotNull SimpleTypeMarker simpleTypeMarker, boolean z);
}
