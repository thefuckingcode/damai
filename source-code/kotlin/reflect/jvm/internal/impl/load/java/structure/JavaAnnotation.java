package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.oi;

/* compiled from: Taobao */
public interface JavaAnnotation extends JavaElement {

    /* compiled from: Taobao */
    public static final class a {
        public static boolean a(@NotNull JavaAnnotation javaAnnotation) {
            k21.i(javaAnnotation, "this");
            return false;
        }

        public static boolean b(@NotNull JavaAnnotation javaAnnotation) {
            k21.i(javaAnnotation, "this");
            return false;
        }
    }

    @NotNull
    Collection<JavaAnnotationArgument> getArguments();

    @Nullable
    oi getClassId();

    boolean isFreshlySupportedTypeUseAnnotation();

    boolean isIdeExternalAnnotation();

    @Nullable
    JavaClass resolve();
}
