package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;

/* compiled from: Taobao */
public interface JavaAnnotationOwner extends JavaElement {
    @Nullable
    JavaAnnotation findAnnotation(@NotNull en0 en0);

    @NotNull
    Collection<JavaAnnotation> getAnnotations();

    boolean isDeprecatedInJavaDoc();
}
