package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.k21;
import tb.oi;

/* compiled from: Taobao */
public interface ListBasedJavaAnnotationOwner extends JavaAnnotationOwner {

    /* compiled from: Taobao */
    public static final class a {
        @Nullable
        public static JavaAnnotation a(@NotNull ListBasedJavaAnnotationOwner listBasedJavaAnnotationOwner, @NotNull en0 en0) {
            en0 en02;
            k21.i(listBasedJavaAnnotationOwner, "this");
            k21.i(en0, "fqName");
            Iterator<T> it = listBasedJavaAnnotationOwner.getAnnotations().iterator();
            while (true) {
                en02 = null;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                oi classId = next.getClassId();
                if (classId != null) {
                    en02 = classId.b();
                }
                if (k21.d(en02, en0)) {
                    en02 = next;
                    break;
                }
            }
            return (JavaAnnotation) en02;
        }
    }
}
