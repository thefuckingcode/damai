package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.load.java.structure.ListBasedJavaAnnotationOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;

/* compiled from: Taobao */
public interface JavaType extends ListBasedJavaAnnotationOwner {

    /* compiled from: Taobao */
    public static final class a {
        @Nullable
        public static JavaAnnotation a(@NotNull JavaType javaType, @NotNull en0 en0) {
            return ListBasedJavaAnnotationOwner.a.a(javaType, en0);
        }
    }
}
