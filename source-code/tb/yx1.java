package tb;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.zx1;

/* compiled from: Taobao */
public final class yx1 extends jy1 implements JavaAnnotation {
    @NotNull
    private final Annotation a;

    public yx1(@NotNull Annotation annotation) {
        k21.i(annotation, "annotation");
        this.a = annotation;
    }

    @NotNull
    public final Annotation a() {
        return this.a;
    }

    @NotNull
    /* renamed from: b */
    public ReflectJavaClass resolve() {
        return new ReflectJavaClass(z41.b(z41.a(this.a)));
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof yx1) && k21.d(this.a, ((yx1) obj).a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    @NotNull
    public Collection<JavaAnnotationArgument> getArguments() {
        Method[] declaredMethods = z41.b(z41.a(this.a)).getDeclaredMethods();
        k21.h(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            zx1.a aVar = zx1.Factory;
            Object invoke = method.invoke(a(), new Object[0]);
            k21.h(invoke, "method.invoke(annotation)");
            arrayList.add(aVar.a(invoke, og1.f(method.getName())));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    @NotNull
    public oi getClassId() {
        return ReflectClassUtilKt.b(z41.b(z41.a(this.a)));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public boolean isFreshlySupportedTypeUseAnnotation() {
        return JavaAnnotation.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public boolean isIdeExternalAnnotation() {
        return JavaAnnotation.a.b(this);
    }

    @NotNull
    public String toString() {
        return yx1.class.getName() + ": " + this.a;
    }
}
