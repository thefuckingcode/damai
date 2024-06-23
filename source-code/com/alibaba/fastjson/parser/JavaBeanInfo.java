package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.gl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class JavaBeanInfo {
    final Constructor<?> creatorConstructor;
    public final String[] creatorConstructorParameters;
    final Constructor<?> defaultConstructor;
    final int defaultConstructorParameterSize;
    final Method factoryMethod;
    final FieldInfo[] fields;
    final JSONType jsonType;
    boolean ordered = false;
    public final int parserFeatures;
    final FieldInfo[] sortedFields;
    final boolean supportBeanToArray;
    public final String typeKey;
    public final long typeKeyHashCode;
    public final String typeName;

    JavaBeanInfo(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2, JSONType jSONType, String[] strArr) {
        int i;
        boolean z;
        int i2 = 0;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.fields = fieldInfoArr;
        this.jsonType = jSONType;
        String str = null;
        if (strArr == null || strArr.length != fieldInfoArr.length) {
            this.creatorConstructorParameters = strArr;
        } else {
            this.creatorConstructorParameters = null;
        }
        if (jSONType != null) {
            String typeName2 = jSONType.typeName();
            this.typeName = typeName2.length() <= 0 ? cls.getName() : typeName2;
            String typeKey2 = jSONType.typeKey();
            this.typeKey = typeKey2.length() > 0 ? typeKey2 : str;
            i = 0;
            for (Feature feature : jSONType.parseFeatures()) {
                i |= feature.mask;
            }
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            i = 0;
        }
        String str2 = this.typeKey;
        if (str2 == null) {
            this.typeKeyHashCode = 0;
        } else {
            this.typeKeyHashCode = TypeUtils.fnv_64_lower(str2);
        }
        this.parserFeatures = i;
        if (jSONType != null) {
            Feature[] parseFeatures = jSONType.parseFeatures();
            z = false;
            for (Feature feature2 : parseFeatures) {
                if (feature2 == Feature.SupportArrayToBean) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        this.supportBeanToArray = z;
        FieldInfo[] computeSortedFields = computeSortedFields(fieldInfoArr, fieldInfoArr2);
        this.sortedFields = !Arrays.equals(fieldInfoArr, computeSortedFields) ? computeSortedFields : fieldInfoArr;
        if (constructor != null) {
            i2 = constructor.getParameterTypes().length;
        } else if (method != null) {
            i2 = method.getParameterTypes().length;
        }
        this.defaultConstructorParameterSize = i2;
    }

    static boolean addField(List<FieldInfo> list, FieldInfo fieldInfo, boolean z) {
        if (!z) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                FieldInfo fieldInfo2 = list.get(i);
                if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                    return false;
                }
            }
        }
        list.add(fieldInfo);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v48, types: [java.lang.reflect.Type[]] */
    /* JADX WARN: Type inference failed for: r0v73, types: [java.lang.reflect.Type[]] */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x07ad, code lost:
        if (r1.length() > 0) goto L_0x07cc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0549  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x057c  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0581  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x05e9  */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static JavaBeanInfo build(Class<?> cls, int i, Type type, boolean z, boolean z2, boolean z3, boolean z4, PropertyNamingStrategy propertyNamingStrategy) {
        Constructor<?> constructor;
        Class<? super Object> cls2;
        Method method;
        Method[] methodArr;
        Method[] methodArr2;
        Field[] fieldArr;
        Constructor<?> constructor2;
        HashMap hashMap;
        Constructor<?> constructor3;
        Field[] fieldArr2;
        Method[] methodArr3;
        Method method2;
        Constructor<?> constructor4;
        int i2;
        int i3;
        String str;
        PropertyNamingStrategy propertyNamingStrategy2;
        int i4;
        int i5;
        Field[] fieldArr3;
        Method[] methodArr4;
        int i6;
        HashMap hashMap2;
        Method method3;
        int i7;
        Constructor<?> constructor5;
        ArrayList arrayList;
        Class<?> returnType;
        Field[] fieldArr4;
        int i8;
        Method method4;
        int i9;
        Field[] fieldArr5;
        String str2;
        Field field;
        PropertyNamingStrategy propertyNamingStrategy3;
        JSONField jSONField;
        int i10;
        Constructor<?> constructor6;
        JSONField jSONField2;
        int i11;
        int i12;
        String str3;
        JSONField jSONField3;
        JSONField jSONField4;
        Method method5;
        Constructor<?> constructor7;
        Class<? super Object> cls3 = Object.class;
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap3 = new HashMap();
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        boolean isKotlin = TypeUtils.isKotlin(cls);
        int i13 = i & 1024;
        if (i13 != 0 || (declaredConstructors.length != 1 && isKotlin)) {
            constructor = null;
        } else {
            try {
                constructor7 = cls.getDeclaredConstructor(new Class[0]);
            } catch (Exception unused) {
                constructor7 = null;
            }
            if (constructor7 == null && cls.isMemberClass() && (i & 8) == 0) {
                int length = declaredConstructors.length;
                int i14 = 0;
                while (true) {
                    if (i14 >= length) {
                        break;
                    }
                    Constructor<?> constructor8 = declaredConstructors[i14];
                    Class<?>[] parameterTypes = constructor8.getParameterTypes();
                    if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                        constructor = constructor8;
                        break;
                    }
                    i14++;
                    constructor7 = constructor7;
                }
            }
            constructor = constructor7;
        }
        String[] strArr = null;
        if (z) {
            cls2 = cls3;
            methodArr = null;
            method = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            Class<? super Object> cls4 = cls;
            Method method6 = null;
            while (cls4 != null && cls4 != cls3) {
                Method[] declaredMethods = cls4.getDeclaredMethods();
                int length2 = declaredMethods.length;
                int i15 = 0;
                while (i15 < length2) {
                    Method method7 = declaredMethods[i15];
                    int modifiers = method7.getModifiers();
                    if ((modifiers & 8) != 0) {
                        if (method7.isAnnotationPresent(JSONCreator.class)) {
                            if (method6 == null) {
                                method6 = method7;
                                i15++;
                                length2 = length2;
                                declaredMethods = declaredMethods;
                            } else {
                                throw new JSONException("multi-json creator");
                            }
                        }
                    } else if ((modifiers & 2) == 0) {
                        method5 = method6;
                        if ((modifiers & 256) == 0 && (modifiers & 4) == 0) {
                            arrayList3.add(method7);
                        }
                        method6 = method5;
                        i15++;
                        length2 = length2;
                        declaredMethods = declaredMethods;
                    }
                    method5 = method6;
                    method6 = method5;
                    i15++;
                    length2 = length2;
                    declaredMethods = declaredMethods;
                }
                cls3 = cls3;
                cls4 = cls4.getSuperclass();
            }
            cls2 = cls3;
            Method[] methodArr5 = new Method[arrayList3.size()];
            arrayList3.toArray(methodArr5);
            methodArr = methodArr5;
            method = method6;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        boolean z5 = cls.isInterface() || i13 != 0;
        if (constructor == null || z5) {
            int length3 = declaredConstructors.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length3) {
                    constructor6 = null;
                    break;
                }
                constructor6 = declaredConstructors[i16];
                if (((JSONCreator) constructor6.getAnnotation(JSONCreator.class)) != null) {
                    break;
                }
                i16++;
                length3 = length3;
            }
            String str4 = "illegal json creator";
            if (constructor6 != null) {
                TypeUtils.setAccessible(cls, constructor6, i);
                Class<?>[] parameterTypes2 = constructor6.getParameterTypes();
                Class<?>[] genericParameterTypes = z4 ? constructor6.getGenericParameterTypes() : parameterTypes2;
                Annotation[][] parameterAnnotations = constructor6.getParameterAnnotations();
                int i17 = 0;
                while (i17 < parameterTypes2.length) {
                    Annotation[] annotationArr = parameterAnnotations[i17];
                    int length4 = annotationArr.length;
                    int i18 = 0;
                    while (true) {
                        if (i18 >= length4) {
                            jSONField4 = null;
                            break;
                        }
                        Annotation annotation = annotationArr[i18];
                        if (annotation instanceof JSONField) {
                            jSONField4 = (JSONField) annotation;
                            break;
                        }
                        i18++;
                        length4 = length4;
                        annotationArr = annotationArr;
                    }
                    if (jSONField4 != null) {
                        Class<?> cls5 = parameterTypes2[i17];
                        Class<?> cls6 = genericParameterTypes[i17];
                        Field field2 = TypeUtils.getField(cls, jSONField4.name(), declaredFields, hashMap3);
                        if (field2 != null) {
                            TypeUtils.setAccessible(cls, field2, i);
                        }
                        addField(arrayList2, new FieldInfo(jSONField4.name(), cls, cls5, cls6, field2, jSONField4.ordinal(), SerializerFeature.of(jSONField4.serialzeFeatures())), z);
                        i17++;
                        str4 = str4;
                        constructor6 = constructor6;
                        hashMap3 = hashMap3;
                        declaredFields = declaredFields;
                        parameterTypes2 = parameterTypes2;
                        methodArr = methodArr;
                        constructor = constructor;
                    } else {
                        throw new JSONException(str4);
                    }
                }
                constructor2 = constructor6;
                methodArr2 = methodArr;
                int size = arrayList2.size();
                FieldInfo[] fieldInfoArr = new FieldInfo[size];
                arrayList2.toArray(fieldInfoArr);
                FieldInfo[] fieldInfoArr2 = new FieldInfo[size];
                System.arraycopy(fieldInfoArr, 0, fieldInfoArr2, 0, size);
                Arrays.sort(fieldInfoArr2);
                if (z2) {
                    JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
                }
                String[] strArr2 = new String[size];
                for (int i19 = 0; i19 < size; i19++) {
                    strArr2[i19] = fieldInfoArr[i19].name;
                }
                strArr = strArr2;
                hashMap = hashMap3;
                fieldArr = declaredFields;
                constructor3 = constructor;
            } else {
                constructor2 = constructor6;
                Field[] fieldArr6 = declaredFields;
                methodArr2 = methodArr;
                HashMap hashMap4 = hashMap3;
                if (method != null) {
                    TypeUtils.setAccessible(cls, method, i);
                    Class<?>[] parameterTypes3 = method.getParameterTypes();
                    if (parameterTypes3.length > 0) {
                        Class<?>[] genericParameterTypes2 = z4 ? method.getGenericParameterTypes() : parameterTypes3;
                        Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
                        int i20 = 0;
                        while (i20 < parameterTypes3.length) {
                            Annotation[] annotationArr2 = parameterAnnotations2[i20];
                            int length5 = annotationArr2.length;
                            int i21 = 0;
                            while (true) {
                                if (i21 >= length5) {
                                    jSONField3 = null;
                                    break;
                                }
                                Annotation annotation2 = annotationArr2[i21];
                                if (annotation2 instanceof JSONField) {
                                    jSONField3 = (JSONField) annotation2;
                                    break;
                                }
                                i21++;
                            }
                            if (jSONField3 != null) {
                                addField(arrayList2, new FieldInfo(jSONField3.name(), cls, parameterTypes3[i20], genericParameterTypes2[i20], TypeUtils.getField(cls, jSONField3.name(), fieldArr6, hashMap4), jSONField3.ordinal(), SerializerFeature.of(jSONField3.serialzeFeatures())), z);
                                i20++;
                                hashMap4 = hashMap4;
                                parameterTypes3 = parameterTypes3;
                                fieldArr6 = fieldArr6;
                            } else {
                                throw new JSONException(str4);
                            }
                        }
                        int size2 = arrayList2.size();
                        FieldInfo[] fieldInfoArr3 = new FieldInfo[size2];
                        arrayList2.toArray(fieldInfoArr3);
                        FieldInfo[] fieldInfoArr4 = new FieldInfo[size2];
                        System.arraycopy(fieldInfoArr3, 0, fieldInfoArr4, 0, size2);
                        Arrays.sort(fieldInfoArr4);
                        return new JavaBeanInfo(cls, null, null, method, fieldInfoArr3, Arrays.equals(fieldInfoArr3, fieldInfoArr4) ? fieldInfoArr3 : fieldInfoArr4, z2 ? (JSONType) cls.getAnnotation(JSONType.class) : null, null);
                    }
                    hashMap = hashMap4;
                    fieldArr = fieldArr6;
                } else {
                    hashMap = hashMap4;
                    Field[] fieldArr7 = fieldArr6;
                    if (z5) {
                        fieldArr = fieldArr7;
                    } else if (!isKotlin || declaredConstructors.length <= 0) {
                        throw new JSONException("default constructor not found. " + cls);
                    } else {
                        String[] koltinConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                        if (koltinConstructorParameters != null) {
                            Constructor<?> constructor9 = constructor2;
                            for (Constructor<?> constructor10 : declaredConstructors) {
                                Class<?>[] parameterTypes4 = constructor10.getParameterTypes();
                                if ((parameterTypes4.length <= 0 || !parameterTypes4[parameterTypes4.length - 1].getName().equals("tb.m40")) && (constructor9 == null || constructor9.getParameterTypes().length < parameterTypes4.length)) {
                                    constructor9 = constructor10;
                                }
                            }
                            constructor9.setAccessible(true);
                            TypeUtils.setAccessible(cls, constructor9, i);
                            Class<?>[] parameterTypes5 = constructor9.getParameterTypes();
                            Class<?>[] genericParameterTypes3 = z4 ? constructor9.getGenericParameterTypes() : parameterTypes5;
                            Annotation[][] parameterAnnotations3 = constructor9.getParameterAnnotations();
                            int i22 = 0;
                            while (i22 < parameterTypes5.length) {
                                String str5 = koltinConstructorParameters[i22];
                                Annotation[] annotationArr3 = parameterAnnotations3[i22];
                                int length6 = annotationArr3.length;
                                int i23 = 0;
                                while (true) {
                                    if (i23 >= length6) {
                                        jSONField2 = null;
                                        break;
                                    }
                                    Annotation annotation3 = annotationArr3[i23];
                                    if (annotation3 instanceof JSONField) {
                                        jSONField2 = (JSONField) annotation3;
                                        break;
                                    }
                                    i23++;
                                }
                                Class<?> cls7 = parameterTypes5[i22];
                                Class<?> cls8 = genericParameterTypes3[i22];
                                Field field3 = TypeUtils.getField(cls, str5, fieldArr7, hashMap);
                                if (field3 != null && jSONField2 == null) {
                                    jSONField2 = (JSONField) field3.getAnnotation(JSONField.class);
                                }
                                if (jSONField2 != null) {
                                    i12 = jSONField2.ordinal();
                                    i11 = SerializerFeature.of(jSONField2.serialzeFeatures());
                                    String name = jSONField2.name();
                                    if (name.length() != 0) {
                                        str5 = name;
                                    }
                                    str3 = str5;
                                } else {
                                    str3 = str5;
                                    i12 = 0;
                                    i11 = 0;
                                }
                                addField(arrayList2, new FieldInfo(str3, cls, cls7, cls8, field3, i12, i11), z);
                                i22++;
                                parameterTypes5 = parameterTypes5;
                                fieldArr7 = fieldArr7;
                            }
                            fieldArr = fieldArr7;
                            int size3 = arrayList2.size();
                            FieldInfo[] fieldInfoArr5 = new FieldInfo[size3];
                            arrayList2.toArray(fieldInfoArr5);
                            FieldInfo[] fieldInfoArr6 = new FieldInfo[size3];
                            System.arraycopy(fieldInfoArr5, 0, fieldInfoArr6, 0, size3);
                            Arrays.sort(fieldInfoArr6);
                            String[] strArr3 = new String[size3];
                            for (int i24 = 0; i24 < size3; i24++) {
                                strArr3[i24] = fieldInfoArr5[i24].name;
                            }
                            strArr = strArr3;
                            constructor2 = constructor9;
                            constructor3 = constructor;
                        } else {
                            throw new JSONException("default constructor not found. " + cls);
                        }
                    }
                }
                constructor3 = constructor;
            }
        } else {
            fieldArr = declaredFields;
            methodArr2 = methodArr;
            hashMap = hashMap3;
            constructor2 = null;
            constructor3 = constructor;
        }
        if (constructor3 != null) {
            TypeUtils.setAccessible(cls, constructor3, i);
        }
        int i25 = 4;
        if (!z) {
            Method[] methodArr6 = methodArr2;
            int length7 = methodArr6.length;
            int i26 = 0;
            while (i26 < length7) {
                Method method8 = methodArr6[i26];
                String name2 = method8.getName();
                if (name2.length() >= i25 && (((returnType = method8.getReturnType()) == Void.TYPE || returnType == method8.getDeclaringClass()) && method8.getParameterTypes().length == 1)) {
                    JSONField jSONField5 = z3 ? (JSONField) method8.getAnnotation(JSONField.class) : null;
                    if (jSONField5 == null && z3) {
                        jSONField5 = TypeUtils.getSupperMethodAnnotation(cls, method8);
                    }
                    if (jSONField5 == null) {
                        i6 = i26;
                        i7 = length7;
                        methodArr4 = methodArr6;
                        constructor5 = constructor3;
                        method3 = method;
                        fieldArr4 = fieldArr;
                        arrayList = arrayList2;
                        method4 = method8;
                        i9 = 0;
                        i8 = 0;
                    } else if (jSONField5.deserialize()) {
                        int ordinal = jSONField5.ordinal();
                        i8 = SerializerFeature.of(jSONField5.serialzeFeatures());
                        if (jSONField5.name().length() != 0) {
                            i6 = i26;
                            i7 = length7;
                            methodArr4 = methodArr6;
                            constructor5 = constructor3;
                            fieldArr4 = fieldArr;
                            method3 = method;
                            arrayList = arrayList2;
                            addField(arrayList, new FieldInfo(jSONField5.name(), method8, null, cls, type, ordinal, i8, jSONField5, null, z4), z);
                            TypeUtils.setAccessible(cls, method8, i);
                            hashMap2 = hashMap;
                            fieldArr3 = fieldArr4;
                            i26 = i6 + 1;
                            arrayList2 = arrayList;
                            constructor3 = constructor5;
                            length7 = i7;
                            method = method3;
                            hashMap = hashMap2;
                            methodArr6 = methodArr4;
                            fieldArr = fieldArr3;
                            i25 = 4;
                        } else {
                            i6 = i26;
                            i7 = length7;
                            methodArr4 = methodArr6;
                            constructor5 = constructor3;
                            method3 = method;
                            fieldArr4 = fieldArr;
                            arrayList = arrayList2;
                            method4 = method8;
                            i9 = ordinal;
                        }
                    }
                    if (name2.startsWith("set")) {
                        char charAt = name2.charAt(3);
                        if (Character.isUpperCase(charAt)) {
                            if (TypeUtils.compatibleWithJavaBean) {
                                str2 = TypeUtils.decapitalize(name2.substring(3));
                                fieldArr5 = fieldArr4;
                                field = TypeUtils.getField(cls, str2, fieldArr5, hashMap);
                                if (field != null) {
                                    if (method4.getParameterTypes()[0] == Boolean.TYPE) {
                                        field = TypeUtils.getField(cls, "is" + Character.toUpperCase(str2.charAt(0)) + str2.substring(1), fieldArr5, hashMap);
                                    }
                                }
                                if (field != null) {
                                    JSONField jSONField6 = z3 ? (JSONField) field.getAnnotation(JSONField.class) : null;
                                    if (jSONField6 != null) {
                                        i9 = jSONField6.ordinal();
                                        i8 = SerializerFeature.of(jSONField6.serialzeFeatures());
                                        if (jSONField6.name().length() != 0) {
                                            hashMap2 = hashMap;
                                            fieldArr3 = fieldArr5;
                                            addField(arrayList, new FieldInfo(jSONField6.name(), method4, field, cls, type, i9, i8, jSONField5, jSONField6, z4), z);
                                            i26 = i6 + 1;
                                            arrayList2 = arrayList;
                                            constructor3 = constructor5;
                                            length7 = i7;
                                            method = method3;
                                            hashMap = hashMap2;
                                            methodArr6 = methodArr4;
                                            fieldArr = fieldArr3;
                                            i25 = 4;
                                        } else {
                                            fieldArr3 = fieldArr5;
                                            hashMap2 = hashMap;
                                            if (jSONField5 == null) {
                                                propertyNamingStrategy3 = propertyNamingStrategy;
                                                i10 = i9;
                                                jSONField = jSONField6;
                                                if (propertyNamingStrategy3 != null) {
                                                    str2 = propertyNamingStrategy3.translate(str2);
                                                }
                                                addField(arrayList, new FieldInfo(str2, method4, null, cls, type, i10, i8, jSONField, null, z4), z);
                                                TypeUtils.setAccessible(cls, method4, i);
                                                i26 = i6 + 1;
                                                arrayList2 = arrayList;
                                                constructor3 = constructor5;
                                                length7 = i7;
                                                method = method3;
                                                hashMap = hashMap2;
                                                methodArr6 = methodArr4;
                                                fieldArr = fieldArr3;
                                                i25 = 4;
                                            }
                                            propertyNamingStrategy3 = propertyNamingStrategy;
                                            i10 = i9;
                                            jSONField = jSONField5;
                                            if (propertyNamingStrategy3 != null) {
                                            }
                                            addField(arrayList, new FieldInfo(str2, method4, null, cls, type, i10, i8, jSONField, null, z4), z);
                                            TypeUtils.setAccessible(cls, method4, i);
                                            i26 = i6 + 1;
                                            arrayList2 = arrayList;
                                            constructor3 = constructor5;
                                            length7 = i7;
                                            method = method3;
                                            hashMap = hashMap2;
                                            methodArr6 = methodArr4;
                                            fieldArr = fieldArr3;
                                            i25 = 4;
                                        }
                                    }
                                }
                                fieldArr3 = fieldArr5;
                                hashMap2 = hashMap;
                                propertyNamingStrategy3 = propertyNamingStrategy;
                                i10 = i9;
                                jSONField = jSONField5;
                                if (propertyNamingStrategy3 != null) {
                                }
                                addField(arrayList, new FieldInfo(str2, method4, null, cls, type, i10, i8, jSONField, null, z4), z);
                                TypeUtils.setAccessible(cls, method4, i);
                                i26 = i6 + 1;
                                arrayList2 = arrayList;
                                constructor3 = constructor5;
                                length7 = i7;
                                method = method3;
                                hashMap = hashMap2;
                                methodArr6 = methodArr4;
                                fieldArr = fieldArr3;
                                i25 = 4;
                            } else {
                                str2 = Character.toLowerCase(name2.charAt(3)) + name2.substring(4);
                            }
                        } else if (charAt == '_') {
                            str2 = name2.substring(4);
                        } else if (charAt == 'f') {
                            str2 = name2.substring(3);
                        } else if (name2.length() >= 5 && Character.isUpperCase(name2.charAt(4))) {
                            str2 = TypeUtils.decapitalize(name2.substring(3));
                        }
                        fieldArr5 = fieldArr4;
                        field = TypeUtils.getField(cls, str2, fieldArr5, hashMap);
                        if (field != null) {
                        }
                        if (field != null) {
                        }
                        fieldArr3 = fieldArr5;
                        hashMap2 = hashMap;
                        propertyNamingStrategy3 = propertyNamingStrategy;
                        i10 = i9;
                        jSONField = jSONField5;
                        if (propertyNamingStrategy3 != null) {
                        }
                        addField(arrayList, new FieldInfo(str2, method4, null, cls, type, i10, i8, jSONField, null, z4), z);
                        TypeUtils.setAccessible(cls, method4, i);
                        i26 = i6 + 1;
                        arrayList2 = arrayList;
                        constructor3 = constructor5;
                        length7 = i7;
                        method = method3;
                        hashMap = hashMap2;
                        methodArr6 = methodArr4;
                        fieldArr = fieldArr3;
                        i25 = 4;
                    }
                    hashMap2 = hashMap;
                    fieldArr3 = fieldArr4;
                    i26 = i6 + 1;
                    arrayList2 = arrayList;
                    constructor3 = constructor5;
                    length7 = i7;
                    method = method3;
                    hashMap = hashMap2;
                    methodArr6 = methodArr4;
                    fieldArr = fieldArr3;
                    i25 = 4;
                }
                i6 = i26;
                i7 = length7;
                methodArr4 = methodArr6;
                constructor5 = constructor3;
                method3 = method;
                fieldArr3 = fieldArr;
                arrayList = arrayList2;
                hashMap2 = hashMap;
                i26 = i6 + 1;
                arrayList2 = arrayList;
                constructor3 = constructor5;
                length7 = i7;
                method = method3;
                hashMap = hashMap2;
                methodArr6 = methodArr4;
                fieldArr = fieldArr3;
                i25 = 4;
            }
            methodArr3 = methodArr6;
            constructor4 = constructor3;
            method2 = method;
            fieldArr2 = fieldArr;
        } else {
            constructor4 = constructor3;
            method2 = method;
            fieldArr2 = fieldArr;
            methodArr3 = methodArr2;
        }
        ArrayList<Field> arrayList4 = new ArrayList(fieldArr2.length);
        for (Field field4 : fieldArr2) {
            int modifiers2 = field4.getModifiers();
            if ((modifiers2 & 8) == 0) {
                if ((modifiers2 & 16) != 0) {
                    Class<?> type2 = field4.getType();
                    if (!(Map.class.isAssignableFrom(type2) || Collection.class.isAssignableFrom(type2))) {
                    }
                }
                if ((field4.getModifiers() & 1) != 0) {
                    arrayList4.add(field4);
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        while (superclass != null && superclass != cls2) {
            Field[] declaredFields2 = superclass.getDeclaredFields();
            for (Field field5 : declaredFields2) {
                int modifiers3 = field5.getModifiers();
                if ((modifiers3 & 8) == 0) {
                    if ((modifiers3 & 16) != 0) {
                        Class<?> type3 = field5.getType();
                        if (!(Map.class.isAssignableFrom(type3) || Collection.class.isAssignableFrom(type3))) {
                        }
                    }
                    if ((modifiers3 & 1) != 0) {
                        arrayList4.add(field5);
                    }
                }
            }
            superclass = superclass.getSuperclass();
            cls2 = cls2;
        }
        for (Field field6 : arrayList4) {
            String name3 = field6.getName();
            int size4 = arrayList2.size();
            boolean z6 = false;
            for (int i27 = 0; i27 < size4; i27++) {
                if (((FieldInfo) arrayList2.get(i27)).name.equals(name3)) {
                    z6 = true;
                }
            }
            if (!z6) {
                JSONField jSONField7 = z3 ? (JSONField) field6.getAnnotation(JSONField.class) : null;
                if (jSONField7 != null) {
                    int ordinal2 = jSONField7.ordinal();
                    int of = SerializerFeature.of(jSONField7.serialzeFeatures());
                    if (jSONField7.name().length() != 0) {
                        name3 = jSONField7.name();
                    }
                    propertyNamingStrategy2 = propertyNamingStrategy;
                    i5 = ordinal2;
                    i4 = of;
                } else {
                    propertyNamingStrategy2 = propertyNamingStrategy;
                    i5 = 0;
                    i4 = 0;
                }
                if (propertyNamingStrategy2 != null) {
                    name3 = propertyNamingStrategy2.translate(name3);
                }
                TypeUtils.setAccessible(cls, field6, i);
                addField(arrayList2, new FieldInfo(name3, null, field6, cls, type, i5, i4, null, jSONField7, z4), z);
            }
        }
        if (!z) {
            int length8 = methodArr3.length;
            int i28 = 0;
            while (i28 < length8) {
                Method method9 = methodArr3[i28];
                String name4 = method9.getName();
                if (name4.length() >= 4 && name4.startsWith(gl1.TYPE_OPEN_URL_METHOD_GET) && Character.isUpperCase(name4.charAt(3)) && method9.getParameterTypes().length == 0) {
                    Class<?> returnType2 = method9.getReturnType();
                    if (Collection.class.isAssignableFrom(returnType2) || Map.class.isAssignableFrom(returnType2)) {
                        JSONField jSONField8 = z3 ? (JSONField) method9.getAnnotation(JSONField.class) : null;
                        if (jSONField8 != null) {
                            str = jSONField8.name();
                        }
                        str = Character.toLowerCase(name4.charAt(3)) + name4.substring(4);
                        i3 = i28;
                        i2 = length8;
                        addField(arrayList2, new FieldInfo(str, method9, null, cls, type, 0, 0, jSONField8, null, z4), z);
                        TypeUtils.setAccessible(cls, method9, i);
                        i28 = i3 + 1;
                        length8 = i2;
                    }
                }
                i3 = i28;
                i2 = length8;
                i28 = i3 + 1;
                length8 = i2;
            }
        }
        int size5 = arrayList2.size();
        FieldInfo[] fieldInfoArr7 = new FieldInfo[size5];
        arrayList2.toArray(fieldInfoArr7);
        FieldInfo[] fieldInfoArr8 = new FieldInfo[size5];
        System.arraycopy(fieldInfoArr7, 0, fieldInfoArr8, 0, size5);
        Arrays.sort(fieldInfoArr8);
        return new JavaBeanInfo(cls, constructor4, constructor2, method2, fieldInfoArr7, fieldInfoArr8, z2 ? (JSONType) cls.getAnnotation(JSONType.class) : null, strArr);
    }

    private FieldInfo[] computeSortedFields(FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2) {
        String[] orders;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        JSONType jSONType = this.jsonType;
        if (!(jSONType == null || (orders = jSONType.orders()) == null || orders.length == 0)) {
            int i = 0;
            while (true) {
                if (i >= orders.length) {
                    z = true;
                    break;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= fieldInfoArr2.length) {
                        z4 = false;
                        break;
                    } else if (fieldInfoArr2[i2].name.equals(orders[i])) {
                        z4 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z4) {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                return fieldInfoArr2;
            }
            if (orders.length == fieldInfoArr.length) {
                int i3 = 0;
                while (true) {
                    if (i3 >= orders.length) {
                        z3 = true;
                        break;
                    } else if (!fieldInfoArr2[i3].name.equals(orders[i3])) {
                        z3 = false;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z3) {
                    return fieldInfoArr2;
                }
                FieldInfo[] fieldInfoArr3 = new FieldInfo[fieldInfoArr2.length];
                for (int i4 = 0; i4 < orders.length; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= fieldInfoArr2.length) {
                            break;
                        } else if (fieldInfoArr2[i5].name.equals(orders[i4])) {
                            fieldInfoArr3[i4] = fieldInfoArr2[i5];
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
                this.ordered = true;
                return fieldInfoArr3;
            }
            int length = fieldInfoArr2.length;
            FieldInfo[] fieldInfoArr4 = new FieldInfo[length];
            for (int i6 = 0; i6 < orders.length; i6++) {
                int i7 = 0;
                while (true) {
                    if (i7 >= fieldInfoArr2.length) {
                        break;
                    } else if (fieldInfoArr2[i7].name.equals(orders[i6])) {
                        fieldInfoArr4[i6] = fieldInfoArr2[i7];
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            int length2 = orders.length;
            for (int i8 = 0; i8 < fieldInfoArr2.length; i8++) {
                int i9 = 0;
                while (true) {
                    if (i9 >= length || i9 >= length2) {
                        z2 = false;
                    } else if (fieldInfoArr4[i8].equals(fieldInfoArr2[i9])) {
                        z2 = true;
                        break;
                    } else {
                        i9++;
                    }
                }
                z2 = false;
                if (!z2) {
                    fieldInfoArr4[length2] = fieldInfoArr2[i8];
                    length2++;
                }
            }
            this.ordered = true;
        }
        return fieldInfoArr2;
    }
}
