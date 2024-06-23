package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class w61 {
    @NotNull
    public static final Annotations a(@NotNull x61 x61, @NotNull JavaAnnotationOwner javaAnnotationOwner) {
        k21.i(x61, "<this>");
        k21.i(javaAnnotationOwner, "annotationsOwner");
        return new LazyJavaAnnotations(x61, javaAnnotationOwner, false, 4, null);
    }
}
