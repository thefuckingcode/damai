package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.annotation.JSONField;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: Taobao */
public class FieldInfo implements Comparable<FieldInfo> {
    public final String[] alternateNames;
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    private final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final Method method;
    private final JSONField methodAnnotation;
    public final String name;
    public final long nameHashCode;
    private int ordinal = 0;
    public final int serialzeFeatures;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field2, int i, int i2) {
        i = i < 0 ? 0 : i;
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field2;
        this.ordinal = i;
        this.serialzeFeatures = i2;
        this.isEnum = cls2.isEnum() && !JSONAware.class.isAssignableFrom(cls2);
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        if (field2 != null) {
            int modifiers = field2.getModifiers();
            int i3 = modifiers & 1;
            this.fieldAccess = true;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        this.getOnly = false;
        long j = -3750763034362895579L;
        for (int i4 = 0; i4 < str.length(); i4++) {
            j = (j ^ ((long) str.charAt(i4))) * 1099511628211L;
        }
        this.nameHashCode = j;
        this.format = null;
        this.alternateNames = new String[0];
    }

    public static Type getFieldType(Class<?> cls, Type type, Type type2) {
        ParameterizedType parameterizedType;
        TypeVariable<Class<? super Object>>[] typeVariableArr;
        if (!(cls == null || type == null)) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type fieldType2 = getFieldType(cls, type, genericComponentType);
                return genericComponentType != fieldType2 ? Array.newInstance(TypeUtils.getClass(fieldType2), 0).getClass() : type2;
            } else if (!TypeUtils.isGenericParamType(type)) {
                return type2;
            } else {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.getGenericParamType(type);
                    Class<?> cls2 = TypeUtils.getClass(parameterizedType2);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    for (int i = 0; i < cls2.getTypeParameters().length; i++) {
                        if (cls2.getTypeParameters()[i].getName().equals(typeVariable.getName())) {
                            return parameterizedType2.getActualTypeArguments()[i];
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                    Type[] typeArr = null;
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                        typeVariableArr = cls.getTypeParameters();
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        typeVariableArr = cls.getSuperclass().getTypeParameters();
                    } else {
                        typeVariableArr = null;
                        parameterizedType = null;
                    }
                    boolean z = false;
                    for (int i2 = 0; i2 < actualTypeArguments.length && parameterizedType != null; i2++) {
                        Type type3 = actualTypeArguments[i2];
                        if (type3 instanceof TypeVariable) {
                            TypeVariable typeVariable2 = (TypeVariable) type3;
                            for (int i3 = 0; i3 < typeVariableArr.length; i3++) {
                                if (typeVariableArr[i3].getName().equals(typeVariable2.getName())) {
                                    if (typeArr == null) {
                                        typeArr = parameterizedType.getActualTypeArguments();
                                    }
                                    actualTypeArguments[i2] = typeArr[i3];
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        return new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                    }
                }
            }
        }
        return type2;
    }

    public boolean equals(FieldInfo fieldInfo) {
        return fieldInfo == this || compareTo(fieldInfo) == 0;
    }

    public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
        if (this.fieldAccess) {
            return this.field.get(obj);
        }
        return this.method.invoke(obj, new Object[0]);
    }

    public JSONField getAnnotation() {
        JSONField jSONField = this.fieldAnnotation;
        if (jSONField != null) {
            return jSONField;
        }
        return this.methodAnnotation;
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method2 = this.method;
        if (method2 != null) {
            method2.invoke(obj, obj2);
            return;
        }
        this.field.set(obj, obj2);
    }

    public String toString() {
        return this.name;
    }

    public int compareTo(FieldInfo fieldInfo) {
        int i = this.ordinal;
        int i2 = fieldInfo.ordinal;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return this.name.compareTo(fieldInfo.name);
    }

    public FieldInfo(String str, Method method2, Field field2, Class<?> cls, Type type, int i, int i2, JSONField jSONField, JSONField jSONField2, boolean z) {
        String str2;
        boolean z2;
        Type type2;
        Class<?> cls2;
        Type type3 = type;
        int i3 = i < 0 ? 0 : i;
        this.name = str;
        this.method = method2;
        this.field = field2;
        this.ordinal = i3;
        this.methodAnnotation = jSONField;
        this.fieldAnnotation = jSONField2;
        this.serialzeFeatures = i2;
        JSONField annotation = getAnnotation();
        Type type4 = null;
        if (annotation != null) {
            str2 = annotation.format();
            str2 = str2.trim().length() == 0 ? null : str2;
            this.alternateNames = annotation.alternateNames();
        } else {
            this.alternateNames = new String[0];
            str2 = null;
        }
        this.format = str2;
        if (field2 != null) {
            int modifiers = field2.getModifiers();
            this.fieldAccess = method2 == null || ((modifiers & 1) != 0 && method2.getReturnType() == field2.getType());
            this.fieldTransient = (modifiers & 128) != 0;
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        long j = -3750763034362895579L;
        for (int i4 = 0; i4 < str.length(); i4++) {
            j = 1099511628211L * (((long) str.charAt(i4)) ^ j);
        }
        this.nameHashCode = j;
        if (method2 != null) {
            Class<?>[] parameterTypes = method2.getParameterTypes();
            if (parameterTypes.length == 1) {
                z2 = false;
                cls2 = parameterTypes[0];
                type2 = (cls2 == Class.class || cls2 == String.class || cls2.isPrimitive() || !z) ? cls2 : method2.getGenericParameterTypes()[0];
                this.getOnly = false;
            } else {
                z2 = false;
                cls2 = method2.getReturnType();
                if (cls2 != Class.class && z) {
                    type2 = method2.getGenericReturnType();
                } else {
                    type2 = cls2;
                }
                this.getOnly = true;
            }
            this.declaringClass = method2.getDeclaringClass();
        } else {
            z2 = false;
            cls2 = field2.getType();
            Type genericType = (cls2.isPrimitive() || cls2 == String.class || cls2.isEnum() || !z) ? cls2 : field2.getGenericType();
            this.declaringClass = field2.getDeclaringClass();
            this.getOnly = Modifier.isFinal(field2.getModifiers());
            type2 = genericType;
        }
        if (cls != null && cls2 == Object.class && (type2 instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type[] actualTypeArguments = type3 instanceof ParameterizedType ? ((ParameterizedType) type3).getActualTypeArguments() : null;
            Class<?> cls3 = cls;
            while (cls3 != null && cls3 != Object.class && cls3 != this.declaringClass) {
                Type genericSuperclass = cls3.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    TypeUtils.getArgument(actualTypeArguments2, cls3.getTypeParameters(), actualTypeArguments);
                    actualTypeArguments = actualTypeArguments2;
                }
                cls3 = cls3.getSuperclass();
            }
            if (actualTypeArguments != null) {
                TypeVariable<Class<?>>[] typeParameters = this.declaringClass.getTypeParameters();
                int i5 = 0;
                while (true) {
                    if (i5 >= typeParameters.length) {
                        break;
                    } else if (typeVariable.equals(typeParameters[i5])) {
                        type4 = actualTypeArguments[i5];
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            if (type4 != null) {
                this.fieldClass = TypeUtils.getClass(type4);
                this.fieldType = type4;
                if (cls2.isEnum() && !JSONAware.class.isAssignableFrom(cls2)) {
                    z2 = true;
                }
                this.isEnum = z2;
                return;
            }
        }
        if (!(type2 instanceof Class)) {
            Type fieldType2 = getFieldType(cls, type3 == null ? cls : type3, type2);
            if (fieldType2 != type2) {
                if (fieldType2 instanceof ParameterizedType) {
                    cls2 = TypeUtils.getClass(fieldType2);
                } else if (fieldType2 instanceof Class) {
                    cls2 = TypeUtils.getClass(fieldType2);
                }
            }
            type2 = fieldType2;
        }
        this.fieldType = type2;
        this.fieldClass = cls2;
        if (!cls2.isArray() && cls2.isEnum() && !JSONAware.class.isAssignableFrom(cls2)) {
            z2 = true;
        }
        this.isEnum = z2;
    }
}
