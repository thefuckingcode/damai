package tb;

import java.lang.annotation.Annotation;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class wx1 implements SourceElement {
    @NotNull
    private final Annotation a;

    public wx1(@NotNull Annotation annotation) {
        k21.i(annotation, "annotation");
        this.a = annotation;
    }

    @NotNull
    public final Annotation a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    @NotNull
    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        k21.h(sourceFile, "NO_SOURCE_FILE");
        return sourceFile;
    }
}
