package tb;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.e;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class iy1 extends ny1 implements JavaConstructor {
    @NotNull
    private final Constructor<?> a;

    public iy1(@NotNull Constructor<?> constructor) {
        k21.i(constructor, "member");
        this.a = constructor;
    }

    @NotNull
    /* renamed from: f */
    public Constructor<?> d() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    @NotNull
    public List<sy1> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = d().getTypeParameters();
        k21.h(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new sy1(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor
    @NotNull
    public List<JavaValueParameter> getValueParameters() {
        Type[] genericParameterTypes = d().getGenericParameterTypes();
        k21.h(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            return m.g();
        }
        Class<?> declaringClass = d().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) e.h(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = d().getParameterAnnotations();
        if (parameterAnnotations.length >= genericParameterTypes.length) {
            if (parameterAnnotations.length > genericParameterTypes.length) {
                k21.h(parameterAnnotations, "annotations");
                parameterAnnotations = (Annotation[][]) e.h(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
            }
            k21.h(genericParameterTypes, "realTypes");
            k21.h(parameterAnnotations, "realAnnotations");
            return e(genericParameterTypes, parameterAnnotations, d().isVarArgs());
        }
        throw new IllegalStateException(k21.r("Illegal generic signature: ", d()));
    }
}
