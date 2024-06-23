package tb;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.k;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class ny1 extends jy1 implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember {
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
    public ReflectJavaClass getContainingClass() {
        Class<?> declaringClass = d().getDeclaringClass();
        k21.h(declaringClass, "member.declaringClass");
        return new ReflectJavaClass(declaringClass);
    }

    @NotNull
    public abstract Member d();

    /* access modifiers changed from: protected */
    @NotNull
    public final List<JavaValueParameter> e(@NotNull Type[] typeArr, @NotNull Annotation[][] annotationArr, boolean z) {
        Integer num;
        String str;
        k21.i(typeArr, "parameterTypes");
        k21.i(annotationArr, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        List<String> b = h31.INSTANCE.b(d());
        if (b == null) {
            num = null;
        } else {
            num = Integer.valueOf(b.size());
        }
        int intValue = num == null ? 0 : num.intValue() - typeArr.length;
        int length = typeArr.length - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                ry1 a = ry1.Factory.a(typeArr[i]);
                if (b == null) {
                    str = null;
                } else {
                    str = (String) k.S(b, i + intValue);
                    if (str == null) {
                        throw new IllegalStateException(("No parameter with index " + i + '+' + intValue + " (name=" + getName() + " type=" + a + ") in " + b + "@ReflectJavaMember").toString());
                    }
                }
                arrayList.add(new ty1(a, annotationArr[i], str, z && i == ArraysKt___ArraysKt.x(typeArr)));
                if (i2 > length) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ny1) && k21.d(d(), ((ny1) obj).d());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    @NotNull
    public AnnotatedElement getElement() {
        return (AnnotatedElement) d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return d().getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    @NotNull
    public og1 getName() {
        String name = d().getName();
        og1 f = name == null ? null : og1.f(name);
        if (f != null) {
            return f;
        }
        og1 og1 = dd2.NO_NAME_PROVIDED;
        k21.h(og1, "NO_NAME_PROVIDED");
        return og1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    @NotNull
    public qw2 getVisibility() {
        return ReflectJavaModifierListOwner.a.a(this);
    }

    public int hashCode() {
        return d().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.a.d(this);
    }

    @NotNull
    public String toString() {
        return getClass().getName() + ": " + d();
    }
}
