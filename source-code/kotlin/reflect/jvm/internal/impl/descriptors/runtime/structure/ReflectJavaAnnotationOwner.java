package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.by1;
import tb.en0;
import tb.k21;
import tb.yx1;

/* compiled from: Taobao */
public interface ReflectJavaAnnotationOwner extends JavaAnnotationOwner {

    /* compiled from: Taobao */
    public static final class a {
        @Nullable
        public static yx1 a(@NotNull ReflectJavaAnnotationOwner reflectJavaAnnotationOwner, @NotNull en0 en0) {
            Annotation[] declaredAnnotations;
            k21.i(reflectJavaAnnotationOwner, "this");
            k21.i(en0, "fqName");
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
                return null;
            }
            return by1.a(declaredAnnotations, en0);
        }

        @NotNull
        public static List<yx1> b(@NotNull ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            k21.i(reflectJavaAnnotationOwner, "this");
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            Annotation[] declaredAnnotations = element == null ? null : element.getDeclaredAnnotations();
            return declaredAnnotations == null ? m.g() : by1.b(declaredAnnotations);
        }

        public static boolean c(@NotNull ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            k21.i(reflectJavaAnnotationOwner, "this");
            return false;
        }
    }

    @Nullable
    AnnotatedElement getElement();
}
