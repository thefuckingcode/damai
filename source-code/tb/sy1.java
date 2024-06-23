package tb;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class sy1 extends jy1 implements ReflectJavaAnnotationOwner, JavaTypeParameter {
    @NotNull
    private final TypeVariable<?> a;

    public sy1(@NotNull TypeVariable<?> typeVariable) {
        k21.i(typeVariable, "typeVariable");
        this.a = typeVariable;
    }

    @Nullable
    /* renamed from: a */
    public yx1 findAnnotation(@NotNull en0 en0) {
        return ReflectJavaAnnotationOwner.a.a(this, en0);
    }

    @NotNull
    /* renamed from: b */
    public List<yx1> getAnnotations() {
        return ReflectJavaAnnotationOwner.a.b(this);
    }

    @NotNull
    /* renamed from: c */
    public List<hy1> getUpperBounds() {
        Type[] bounds = this.a.getBounds();
        k21.h(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new hy1(type));
        }
        hy1 hy1 = (hy1) k.q0(arrayList);
        return k21.d(hy1 == null ? null : hy1.a(), Object.class) ? m.g() : arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof sy1) && k21.d(this.a, ((sy1) obj).a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    @Nullable
    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable = this.a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    @NotNull
    public og1 getName() {
        og1 f = og1.f(this.a.getName());
        k21.h(f, "identifier(typeVariable.name)");
        return f;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.a.c(this);
    }

    @NotNull
    public String toString() {
        return sy1.class.getName() + ": " + this.a;
    }
}
