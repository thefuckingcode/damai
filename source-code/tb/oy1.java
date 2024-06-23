package tb;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ry1;

/* compiled from: Taobao */
public final class oy1 extends ny1 implements JavaMethod {
    @NotNull
    private final Method a;

    public oy1(@NotNull Method method) {
        k21.i(method, "member");
        this.a = method;
    }

    @NotNull
    /* renamed from: f */
    public Method d() {
        return this.a;
    }

    @NotNull
    /* renamed from: g */
    public ry1 getReturnType() {
        ry1.a aVar = ry1.Factory;
        Type genericReturnType = d().getGenericReturnType();
        k21.h(genericReturnType, "member.genericReturnType");
        return aVar.a(genericReturnType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    @Nullable
    public JavaAnnotationArgument getAnnotationParameterDefaultValue() {
        Object defaultValue = d().getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        return zx1.Factory.a(defaultValue, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public boolean getHasAnnotationParameterDefaultValue() {
        return JavaMethod.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    @NotNull
    public List<sy1> getTypeParameters() {
        TypeVariable<Method>[] typeParameters = d().getTypeParameters();
        k21.h(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new sy1(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    @NotNull
    public List<JavaValueParameter> getValueParameters() {
        Type[] genericParameterTypes = d().getGenericParameterTypes();
        k21.h(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = d().getParameterAnnotations();
        k21.h(parameterAnnotations, "member.parameterAnnotations");
        return e(genericParameterTypes, parameterAnnotations, d().isVarArgs());
    }
}
