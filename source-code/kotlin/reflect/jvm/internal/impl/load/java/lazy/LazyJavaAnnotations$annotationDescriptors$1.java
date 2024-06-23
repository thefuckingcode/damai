package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i31;
import tb.k21;

/* compiled from: Taobao */
final class LazyJavaAnnotations$annotationDescriptors$1 extends Lambda implements Function1<JavaAnnotation, AnnotationDescriptor> {
    final /* synthetic */ LazyJavaAnnotations this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaAnnotations$annotationDescriptors$1(LazyJavaAnnotations lazyJavaAnnotations) {
        super(1);
        this.this$0 = lazyJavaAnnotations;
    }

    @Nullable
    public final AnnotationDescriptor invoke(@NotNull JavaAnnotation javaAnnotation) {
        k21.i(javaAnnotation, "annotation");
        return i31.INSTANCE.e(javaAnnotation, LazyJavaAnnotations.b(this.this$0), LazyJavaAnnotations.a(this.this$0));
    }
}
