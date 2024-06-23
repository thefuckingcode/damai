package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface TypeSystemInferenceExtensionContext extends TypeSystemCommonSuperTypesContext, TypeSystemContext {

    /* compiled from: Taobao */
    public static final class a {
        @NotNull
        public static TypeArgumentMarker a(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull TypeArgumentListMarker typeArgumentListMarker, int i) {
            return TypeSystemContext.a.b(typeSystemInferenceExtensionContext, typeArgumentListMarker, i);
        }

        public static boolean b(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.a.i(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        @NotNull
        public static SimpleTypeMarker c(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.a.k(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        public static int d(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull TypeArgumentListMarker typeArgumentListMarker) {
            return TypeSystemContext.a.l(typeSystemInferenceExtensionContext, typeArgumentListMarker);
        }

        @NotNull
        public static TypeConstructorMarker e(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.a.m(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }

        @NotNull
        public static SimpleTypeMarker f(@NotNull TypeSystemInferenceExtensionContext typeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemContext.a.n(typeSystemInferenceExtensionContext, kotlinTypeMarker);
        }
    }
}
