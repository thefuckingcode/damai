package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* compiled from: ReflectJavaConstructor.kt */
public final class ReflectJavaConstructor extends ReflectJavaMember implements JavaConstructor {
    private final Constructor<?> member;

    public ReflectJavaConstructor(Constructor<?> constructor) {
        Intrinsics.checkParameterIsNotNull(constructor, "member");
        this.member = constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Constructor<?> getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor
    public List<JavaValueParameter> getValueParameters() {
        Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        Intrinsics.checkExpressionValueIsNotNull(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            return CollectionsKt.emptyList();
        }
        Class<?> declaringClass = getMember().getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass, "klass");
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) ArraysKt.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        Annotation[][] annotationArr = parameterAnnotations;
        if (annotationArr.length >= genericParameterTypes.length) {
            if (annotationArr.length > genericParameterTypes.length) {
                Intrinsics.checkExpressionValueIsNotNull(parameterAnnotations, "annotations");
                parameterAnnotations = (Annotation[][]) ArraysKt.copyOfRange(annotationArr, annotationArr.length - genericParameterTypes.length, annotationArr.length);
            }
            Intrinsics.checkExpressionValueIsNotNull(genericParameterTypes, "realTypes");
            Intrinsics.checkExpressionValueIsNotNull(parameterAnnotations, "realAnnotations");
            return getValueParameters(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
        }
        throw new IllegalStateException("Illegal generic signature: " + getMember());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = getMember().getTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(typeVariable));
        }
        return arrayList;
    }
}
