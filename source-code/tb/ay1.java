package tb;

import java.lang.annotation.Annotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ay1 extends zx1 implements JavaAnnotationAsAnnotationArgument {
    @NotNull
    private final Annotation b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ay1(@Nullable og1 og1, @NotNull Annotation annotation) {
        super(og1);
        k21.i(annotation, "annotation");
        this.b = annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument
    @NotNull
    public JavaAnnotation getAnnotation() {
        return new yx1(this.b);
    }
}
