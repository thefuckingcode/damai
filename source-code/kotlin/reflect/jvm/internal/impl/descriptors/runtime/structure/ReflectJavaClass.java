package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.en0;
import tb.hy1;
import tb.iy1;
import tb.jy1;
import tb.k21;
import tb.ld2;
import tb.ly1;
import tb.og1;
import tb.oy1;
import tb.qw2;
import tb.sy1;
import tb.yx1;

/* compiled from: Taobao */
public final class ReflectJavaClass extends jy1 implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaClass {
    @NotNull
    private final Class<?> a;

    public ReflectJavaClass(@NotNull Class<?> cls) {
        k21.i(cls, "klass");
        this.a = cls;
    }

    /* access modifiers changed from: private */
    public final boolean j(Method method) {
        String name = method.getName();
        if (k21.d(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            k21.h(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
        } else if (k21.d(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    @Nullable
    /* renamed from: b */
    public yx1 findAnnotation(@NotNull en0 en0) {
        return ReflectJavaAnnotationOwner.a.a(this, en0);
    }

    @NotNull
    /* renamed from: c */
    public List<yx1> getAnnotations() {
        return ReflectJavaAnnotationOwner.a.b(this);
    }

    @NotNull
    /* renamed from: d */
    public List<iy1> getConstructors() {
        Constructor<?>[] declaredConstructors = this.a.getDeclaredConstructors();
        k21.h(declaredConstructors, "klass.declaredConstructors");
        return SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.v(SequencesKt___SequencesKt.p(ArraysKt___ArraysKt.o(declaredConstructors), ReflectJavaClass$constructors$1.INSTANCE), ReflectJavaClass$constructors$2.INSTANCE));
    }

    @NotNull
    /* renamed from: e */
    public Class<?> getElement() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ReflectJavaClass) && k21.d(this.a, ((ReflectJavaClass) obj).a);
    }

    @NotNull
    /* renamed from: f */
    public List<ly1> getFields() {
        Field[] declaredFields = this.a.getDeclaredFields();
        k21.h(declaredFields, "klass.declaredFields");
        return SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.v(SequencesKt___SequencesKt.p(ArraysKt___ArraysKt.o(declaredFields), ReflectJavaClass$fields$1.INSTANCE), ReflectJavaClass$fields$2.INSTANCE));
    }

    @NotNull
    /* renamed from: g */
    public List<og1> getInnerClassNames() {
        Class<?>[] declaredClasses = this.a.getDeclaredClasses();
        k21.h(declaredClasses, "klass.declaredClasses");
        return SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.w(SequencesKt___SequencesKt.p(ArraysKt___ArraysKt.o(declaredClasses), ReflectJavaClass$innerClassNames$1.INSTANCE), ReflectJavaClass$innerClassNames$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @NotNull
    public en0 getFqName() {
        en0 b = ReflectClassUtilKt.b(this.a).b();
        k21.h(b, "klass.classId.asSingleFqName()");
        return b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @Nullable
    public LightClassOriginKind getLightClassOriginKind() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return this.a.getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    @NotNull
    public og1 getName() {
        og1 f = og1.f(this.a.getSimpleName());
        k21.h(f, "identifier(klass.simpleName)");
        return f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @NotNull
    public Collection<JavaClassifierType> getPermittedTypes() {
        return m.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @NotNull
    public Collection<JavaRecordComponent> getRecordComponents() {
        return m.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    @NotNull
    public Collection<JavaClassifierType> getSupertypes() {
        Object obj = Object.class;
        if (k21.d(this.a, obj)) {
            return m.g();
        }
        ld2 ld2 = new ld2(2);
        Object genericSuperclass = this.a.getGenericSuperclass();
        if (genericSuperclass != null) {
            obj = genericSuperclass;
        }
        ld2.a(obj);
        Type[] genericInterfaces = this.a.getGenericInterfaces();
        k21.h(genericInterfaces, "klass.genericInterfaces");
        ld2.b(genericInterfaces);
        List<Type> list = m.j(ld2.d(new Type[ld2.c()]));
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (Type type : list) {
            arrayList.add(new hy1(type));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    @NotNull
    public List<sy1> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.a.getTypeParameters();
        k21.h(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new sy1(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    @NotNull
    public qw2 getVisibility() {
        return ReflectJavaModifierListOwner.a.a(this);
    }

    @NotNull
    /* renamed from: h */
    public List<oy1> getMethods() {
        Method[] declaredMethods = this.a.getDeclaredMethods();
        k21.h(declaredMethods, "klass.declaredMethods");
        return SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.v(SequencesKt___SequencesKt.o(ArraysKt___ArraysKt.o(declaredMethods), new ReflectJavaClass$methods$1(this)), ReflectJavaClass$methods$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean hasDefaultConstructor() {
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Nullable
    /* renamed from: i */
    public ReflectJavaClass getOuterClass() {
        Class<?> declaringClass = this.a.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new ReflectJavaClass(declaringClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isAnnotationType() {
        return this.a.isAnnotation();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isEnum() {
        return this.a.isEnum();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isInterface() {
        return this.a.isInterface();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isRecord() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isSealed() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.a.d(this);
    }

    @NotNull
    public String toString() {
        return ReflectJavaClass.class.getName() + ": " + this.a;
    }
}
