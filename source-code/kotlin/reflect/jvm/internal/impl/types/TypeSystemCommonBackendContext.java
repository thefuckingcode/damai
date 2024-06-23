package kotlin.reflect.jvm.internal.impl.types;

import com.tencent.open.SocialConstants;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.fn0;
import tb.k21;

/* compiled from: Taobao */
public interface TypeSystemCommonBackendContext extends TypeSystemContext {

    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        public static KotlinTypeMarker a(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            k21.i(typeSystemCommonBackendContext, "this");
            k21.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            SimpleTypeMarker asSimpleType = typeSystemCommonBackendContext.asSimpleType(kotlinTypeMarker);
            return asSimpleType == null ? kotlinTypeMarker : typeSystemCommonBackendContext.withNullability(asSimpleType, true);
        }
    }

    @Nullable
    fn0 getClassFqNameUnsafe(@NotNull TypeConstructorMarker typeConstructorMarker);

    @Nullable
    PrimitiveType getPrimitiveArrayType(@NotNull TypeConstructorMarker typeConstructorMarker);

    @Nullable
    PrimitiveType getPrimitiveType(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    KotlinTypeMarker getRepresentativeUpperBound(@NotNull TypeParameterMarker typeParameterMarker);

    @Nullable
    KotlinTypeMarker getSubstitutedUnderlyingType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @Nullable
    TypeParameterMarker getTypeParameterClassifier(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean hasAnnotation(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull en0 en0);

    boolean isInlineClass(@NotNull TypeConstructorMarker typeConstructorMarker);

    boolean isUnderKotlinPackage(@NotNull TypeConstructorMarker typeConstructorMarker);

    @NotNull
    KotlinTypeMarker makeNullable(@NotNull KotlinTypeMarker kotlinTypeMarker);
}
