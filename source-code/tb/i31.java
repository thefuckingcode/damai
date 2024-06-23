package tb;

import java.util.Map;
import kotlin.collections.x;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaDeprecatedAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class i31 {
    @NotNull
    public static final i31 INSTANCE = new i31();
    @NotNull
    private static final og1 a;
    @NotNull
    private static final og1 b;
    @NotNull
    private static final og1 c;
    @NotNull
    private static final Map<en0, en0> d;
    @NotNull
    private static final Map<en0, en0> e;

    static {
        og1 f = og1.f("message");
        k21.h(f, "identifier(\"message\")");
        a = f;
        og1 f2 = og1.f("allowedTargets");
        k21.h(f2, "identifier(\"allowedTargets\")");
        b = f2;
        og1 f3 = og1.f("value");
        k21.h(f3, "identifier(\"value\")");
        c = f3;
        en0 en0 = c.a.target;
        en0 en02 = u41.TARGET_ANNOTATION;
        en0 en03 = c.a.retention;
        en0 en04 = u41.RETENTION_ANNOTATION;
        en0 en05 = c.a.repeatable;
        en0 en06 = u41.REPEATABLE_ANNOTATION;
        en0 en07 = c.a.mustBeDocumented;
        en0 en08 = u41.DOCUMENTED_ANNOTATION;
        d = x.l(do2.a(en0, en02), do2.a(en03, en04), do2.a(en05, en06), do2.a(en07, en08));
        e = x.l(do2.a(en02, en0), do2.a(en04, en03), do2.a(u41.DEPRECATED_ANNOTATION, c.a.deprecated), do2.a(en06, en05), do2.a(en08, en07));
    }

    private i31() {
    }

    public static /* synthetic */ AnnotationDescriptor f(i31 i31, JavaAnnotation javaAnnotation, x61 x61, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return i31.e(javaAnnotation, x61, z);
    }

    @Nullable
    public final AnnotationDescriptor a(@NotNull en0 en0, @NotNull JavaAnnotationOwner javaAnnotationOwner, @NotNull x61 x61) {
        JavaAnnotation findAnnotation;
        k21.i(en0, "kotlinName");
        k21.i(javaAnnotationOwner, "annotationOwner");
        k21.i(x61, com.huawei.hms.opendevice.c.a);
        if (k21.d(en0, c.a.deprecated)) {
            en0 en02 = u41.DEPRECATED_ANNOTATION;
            k21.h(en02, "DEPRECATED_ANNOTATION");
            JavaAnnotation findAnnotation2 = javaAnnotationOwner.findAnnotation(en02);
            if (findAnnotation2 != null || javaAnnotationOwner.isDeprecatedInJavaDoc()) {
                return new JavaDeprecatedAnnotationDescriptor(findAnnotation2, x61);
            }
        }
        en0 en03 = d.get(en0);
        if (en03 == null || (findAnnotation = javaAnnotationOwner.findAnnotation(en03)) == null) {
            return null;
        }
        return f(this, findAnnotation, x61, false, 4, null);
    }

    @NotNull
    public final og1 b() {
        return a;
    }

    @NotNull
    public final og1 c() {
        return c;
    }

    @NotNull
    public final og1 d() {
        return b;
    }

    @Nullable
    public final AnnotationDescriptor e(@NotNull JavaAnnotation javaAnnotation, @NotNull x61 x61, boolean z) {
        k21.i(javaAnnotation, "annotation");
        k21.i(x61, com.huawei.hms.opendevice.c.a);
        oi classId = javaAnnotation.getClassId();
        if (k21.d(classId, oi.m(u41.TARGET_ANNOTATION))) {
            return new JavaTargetAnnotationDescriptor(javaAnnotation, x61);
        }
        if (k21.d(classId, oi.m(u41.RETENTION_ANNOTATION))) {
            return new JavaRetentionAnnotationDescriptor(javaAnnotation, x61);
        }
        if (k21.d(classId, oi.m(u41.REPEATABLE_ANNOTATION))) {
            return new JavaAnnotationDescriptor(x61, javaAnnotation, c.a.repeatable);
        }
        if (k21.d(classId, oi.m(u41.DOCUMENTED_ANNOTATION))) {
            return new JavaAnnotationDescriptor(x61, javaAnnotation, c.a.mustBeDocumented);
        }
        if (k21.d(classId, oi.m(u41.DEPRECATED_ANNOTATION))) {
            return null;
        }
        return new LazyJavaAnnotationDescriptor(x61, javaAnnotation, z);
    }
}
