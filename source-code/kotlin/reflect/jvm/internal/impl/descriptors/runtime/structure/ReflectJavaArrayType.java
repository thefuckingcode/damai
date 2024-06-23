package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;

/* compiled from: ReflectJavaArrayType.kt */
public final class ReflectJavaArrayType extends ReflectJavaType implements JavaArrayType {
    private final ReflectJavaType componentType;
    private final Type reflectType;

    public ReflectJavaArrayType(Type type) {
        ReflectJavaType reflectJavaType;
        Intrinsics.checkParameterIsNotNull(type, "reflectType");
        this.reflectType = type;
        Type reflectType2 = getReflectType();
        if (reflectType2 instanceof GenericArrayType) {
            ReflectJavaType.Factory factory = ReflectJavaType.Factory;
            Type genericComponentType = ((GenericArrayType) reflectType2).getGenericComponentType();
            Intrinsics.checkExpressionValueIsNotNull(genericComponentType, "genericComponentType");
            reflectJavaType = factory.create(genericComponentType);
        } else {
            if (reflectType2 instanceof Class) {
                Class cls = (Class) reflectType2;
                if (cls.isArray()) {
                    ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
                    Class<?> componentType2 = cls.getComponentType();
                    Intrinsics.checkExpressionValueIsNotNull(componentType2, "getComponentType()");
                    reflectJavaType = factory2.create(componentType2);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + getReflectType().getClass() + "): " + getReflectType());
        }
        this.componentType = reflectJavaType;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public Type getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public ReflectJavaType getComponentType() {
        return this.componentType;
    }
}
