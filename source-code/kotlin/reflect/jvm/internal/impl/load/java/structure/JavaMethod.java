package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public interface JavaMethod extends JavaMember, JavaTypeParameterListOwner {

    /* compiled from: Taobao */
    public static final class a {
        public static boolean a(@NotNull JavaMethod javaMethod) {
            k21.i(javaMethod, "this");
            return javaMethod.getAnnotationParameterDefaultValue() != null;
        }
    }

    @Nullable
    JavaAnnotationArgument getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    @NotNull
    JavaType getReturnType();

    @NotNull
    List<JavaValueParameter> getValueParameters();
}
