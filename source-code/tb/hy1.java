package tb;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ry1;

/* compiled from: Taobao */
public final class hy1 extends ry1 implements JavaClassifierType {
    @NotNull
    private final Type a;
    @NotNull
    private final JavaClassifier b;

    public hy1(@NotNull Type type) {
        JavaClassifier javaClassifier;
        k21.i(type, "reflectType");
        this.a = type;
        Type a2 = a();
        if (a2 instanceof Class) {
            javaClassifier = new ReflectJavaClass((Class) a2);
        } else if (a2 instanceof TypeVariable) {
            javaClassifier = new sy1((TypeVariable) a2);
        } else if (a2 instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) a2).getRawType();
            Objects.requireNonNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            javaClassifier = new ReflectJavaClass((Class) rawType);
        } else {
            throw new IllegalStateException("Not a classifier type (" + a2.getClass() + "): " + a2);
        }
        this.b = javaClassifier;
    }

    @Override // tb.ry1
    @NotNull
    public Type a() {
        return this.a;
    }

    @Override // tb.ry1, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    public JavaAnnotation findAnnotation(@NotNull en0 en0) {
        k21.i(en0, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return m.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    @NotNull
    public JavaClassifier getClassifier() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    @NotNull
    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException(k21.r("Type not found: ", a()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    @NotNull
    public String getPresentableText() {
        return a().toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    @NotNull
    public List<JavaType> getTypeArguments() {
        List<Type> e = ReflectClassUtilKt.e(a());
        ry1.a aVar = ry1.Factory;
        ArrayList arrayList = new ArrayList(n.q(e, 10));
        Iterator<T> it = e.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a(it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public boolean isRaw() {
        Type a2 = a();
        if (!(a2 instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) a2).getTypeParameters();
        k21.h(typeParameters, "getTypeParameters()");
        return (typeParameters.length == 0) ^ true;
    }
}
