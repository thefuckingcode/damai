package org.apache.commons.lang3.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Validate;

/* compiled from: Taobao */
public class MethodUtils {
    private static int distance(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (!ClassUtils.isAssignable(clsArr, clsArr2, true)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (!clsArr[i2].equals(clsArr2[i2])) {
                i = (!ClassUtils.isAssignable(clsArr[i2], clsArr2[i2], true) || ClassUtils.isAssignable(clsArr[i2], clsArr2[i2], false)) ? i + 2 : i + 1;
            }
        }
        return i;
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return getAccessibleMethod(cls.getMethod(str, clsArr));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            Class<?>[] interfaces = cls.getInterfaces();
            for (Class<?> cls2 : interfaces) {
                if (Modifier.isPublic(cls2.getModifiers())) {
                    try {
                        return cls2.getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(cls2, str, clsArr);
                        if (accessibleMethodFromInterfaceNest != null) {
                            return accessibleMethodFromInterfaceNest;
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static Method getAccessibleMethodFromSuperclass(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (Modifier.isPublic(superclass.getModifiers())) {
                try {
                    return superclass.getMethod(str, clsArr);
                } catch (NoSuchMethodException unused) {
                    return null;
                }
            }
        }
        return null;
    }

    private static List<Class<?>> getAllSuperclassesAndInterfaces(Class<?> cls) {
        int i;
        Class<?> cls2;
        int i2;
        Class<?> cls3;
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<Class<?>> allSuperclasses = ClassUtils.getAllSuperclasses(cls);
        List<Class<?>> allInterfaces = ClassUtils.getAllInterfaces(cls);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= allInterfaces.size() && i4 >= allSuperclasses.size()) {
                return arrayList;
            }
            if (i3 >= allInterfaces.size()) {
                i = i4 + 1;
                cls2 = allSuperclasses.get(i4);
            } else {
                if (i4 >= allSuperclasses.size()) {
                    i2 = i3 + 1;
                    cls3 = allInterfaces.get(i3);
                } else if (i3 < i4) {
                    i2 = i3 + 1;
                    cls3 = allInterfaces.get(i3);
                } else if (i4 < i3) {
                    i = i4 + 1;
                    cls2 = allSuperclasses.get(i4);
                } else {
                    i2 = i3 + 1;
                    cls3 = allInterfaces.get(i3);
                }
                cls2 = cls3;
                i3 = i2;
                i = i4;
            }
            arrayList.add(cls2);
            i4 = i;
        }
    }

    public static <A extends Annotation> A getAnnotation(Method method, Class<A> cls, boolean z, boolean z2) {
        Method method2;
        boolean z3 = true;
        Validate.isTrue(method != null, "The method must not be null", new Object[0]);
        if (cls == null) {
            z3 = false;
        }
        Validate.isTrue(z3, "The annotation class must not be null", new Object[0]);
        if (!(z2 || MemberUtils.isAccessible(method))) {
            return null;
        }
        A a = (A) method.getAnnotation(cls);
        if (a == null && z) {
            for (Class<?> cls2 : getAllSuperclassesAndInterfaces(method.getDeclaringClass())) {
                if (z2) {
                    try {
                        method2 = cls2.getDeclaredMethod(method.getName(), method.getParameterTypes());
                    } catch (NoSuchMethodException unused) {
                        continue;
                    }
                } else {
                    method2 = cls2.getMethod(method.getName(), method.getParameterTypes());
                }
                a = (A) method2.getAnnotation(cls);
                if (a != null) {
                    break;
                }
            }
        }
        return a;
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method accessibleMethod;
        try {
            Method method = cls.getMethod(str, clsArr);
            MemberUtils.setAccessibleWorkaround(method);
            return method;
        } catch (NoSuchMethodException unused) {
            Method[] methods = cls.getMethods();
            Method method2 = null;
            for (Method method3 : methods) {
                if (method3.getName().equals(str) && MemberUtils.isMatchingMethod(method3, clsArr) && (accessibleMethod = getAccessibleMethod(method3)) != null && (method2 == null || MemberUtils.compareMethodFit(accessibleMethod, method2, clsArr) < 0)) {
                    method2 = accessibleMethod;
                }
            }
            if (method2 != null) {
                MemberUtils.setAccessibleWorkaround(method2);
            }
            if (method2 != null && method2.isVarArgs() && method2.getParameterTypes().length > 0 && clsArr.length > 0) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                String name = ClassUtils.primitiveToWrapper(parameterTypes[parameterTypes.length - 1].getComponentType()).getName();
                String name2 = clsArr[clsArr.length - 1].getName();
                String name3 = clsArr[clsArr.length - 1].getSuperclass().getName();
                if (name.equals(name2) || name.equals(name3)) {
                    return method2;
                }
                return null;
            }
            return method2;
        }
    }

    public static Method getMatchingMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Validate.notNull(cls, "Null class not allowed.", new Object[0]);
        Validate.notEmpty(str, "Null or blank methodName not allowed.", new Object[0]);
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Class<?> cls2 : ClassUtils.getAllSuperclasses(cls)) {
            declaredMethods = (Method[]) ArrayUtils.addAll(declaredMethods, cls2.getDeclaredMethods());
        }
        Method method = null;
        for (Method method2 : declaredMethods) {
            if (str.equals(method2.getName()) && Objects.deepEquals(clsArr, method2.getParameterTypes())) {
                return method2;
            }
            if (str.equals(method2.getName()) && ClassUtils.isAssignable(clsArr, method2.getParameterTypes(), true) && (method == null || distance(clsArr, method2.getParameterTypes()) < distance(clsArr, method.getParameterTypes()))) {
                method = method2;
            }
        }
        return method;
    }

    public static List<Method> getMethodsListWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        return getMethodsListWithAnnotation(cls, cls2, false, false);
    }

    public static Method[] getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        return getMethodsWithAnnotation(cls, cls2, false, false);
    }

    public static Set<Method> getOverrideHierarchy(Method method, ClassUtils.Interfaces interfaces) {
        Validate.notNull(method);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(method);
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> declaringClass = method.getDeclaringClass();
        Iterator<Class<?>> it = ClassUtils.hierarchy(declaringClass, interfaces).iterator();
        it.next();
        while (it.hasNext()) {
            Method matchingAccessibleMethod = getMatchingAccessibleMethod(it.next(), method.getName(), parameterTypes);
            if (matchingAccessibleMethod != null) {
                if (!Arrays.equals(matchingAccessibleMethod.getParameterTypes(), parameterTypes)) {
                    Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(declaringClass, matchingAccessibleMethod.getDeclaringClass());
                    int i = 0;
                    while (true) {
                        if (i >= parameterTypes.length) {
                            linkedHashSet.add(matchingAccessibleMethod);
                            break;
                        } else if (!TypeUtils.equals(TypeUtils.unrollVariables(typeArguments, method.getGenericParameterTypes()[i]), TypeUtils.unrollVariables(typeArguments, matchingAccessibleMethod.getGenericParameterTypes()[i]))) {
                            break;
                        } else {
                            i++;
                        }
                    }
                } else {
                    linkedHashSet.add(matchingAccessibleMethod);
                }
            }
        }
        return linkedHashSet;
    }

    static Object[] getVarArgs(Object[] objArr, Class<?>[] clsArr) {
        if (objArr.length == clsArr.length && objArr[objArr.length - 1].getClass().equals(clsArr[clsArr.length - 1])) {
            return objArr;
        }
        Object[] objArr2 = new Object[clsArr.length];
        System.arraycopy(objArr, 0, objArr2, 0, clsArr.length - 1);
        Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
        int length = (objArr.length - clsArr.length) + 1;
        Object newInstance = Array.newInstance(ClassUtils.primitiveToWrapper(componentType), length);
        System.arraycopy(objArr, clsArr.length - 1, newInstance, 0, length);
        if (componentType.isPrimitive()) {
            newInstance = ArrayUtils.toPrimitive(newInstance);
        }
        objArr2[clsArr.length - 1] = newInstance;
        return objArr2;
    }

    public static Object invokeExactMethod(Object obj, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeExactMethod(obj, str, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(null, nullToEmpty);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
    }

    public static Object invokeMethod(Object obj, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(obj, str, ArrayUtils.EMPTY_OBJECT_ARRAY, (Class<?>[]) null);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeStaticMethod(cls, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    private static Object[] toVarArgs(Method method, Object[] objArr) {
        return method.isVarArgs() ? getVarArgs(objArr, method.getParameterTypes()) : objArr;
    }

    public static Method getAccessibleMethod(Method method) {
        if (!MemberUtils.isAccessible(method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (Modifier.isPublic(declaringClass.getModifiers())) {
            return method;
        }
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(declaringClass, name, parameterTypes);
        return accessibleMethodFromInterfaceNest == null ? getAccessibleMethodFromSuperclass(declaringClass, name, parameterTypes) : accessibleMethodFromInterfaceNest;
    }

    public static List<Method> getMethodsListWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2, boolean z, boolean z2) {
        boolean z3 = true;
        Validate.isTrue(cls != null, "The class must not be null", new Object[0]);
        if (cls2 == null) {
            z3 = false;
        }
        Validate.isTrue(z3, "The annotation class must not be null", new Object[0]);
        List<Class> allSuperclassesAndInterfaces = z ? getAllSuperclassesAndInterfaces(cls) : new ArrayList();
        allSuperclassesAndInterfaces.add(0, cls);
        ArrayList arrayList = new ArrayList();
        for (Class cls3 : allSuperclassesAndInterfaces) {
            Method[] declaredMethods = z2 ? cls3.getDeclaredMethods() : cls3.getMethods();
            for (Method method : declaredMethods) {
                if (method.getAnnotation(cls2) != null) {
                    arrayList.add(method);
                }
            }
        }
        return arrayList;
    }

    public static Method[] getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2, boolean z, boolean z2) {
        List<Method> methodsListWithAnnotation = getMethodsListWithAnnotation(cls, cls2, z, z2);
        return (Method[]) methodsListWithAnnotation.toArray(new Method[methodsListWithAnnotation.size()]);
    }

    public static Object invokeExactMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactMethod(obj, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Object invokeMethod(Object obj, boolean z, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(obj, z, str, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeMethod(obj, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke(null, toVarArgs(matchingAccessibleMethod, nullToEmpty));
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, ArrayUtils.nullToEmpty(clsArr));
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(obj, nullToEmpty);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactStaticMethod(cls, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Object invokeMethod(Object obj, boolean z, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeMethod(obj, z, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Object invokeMethod(Object obj, boolean z, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String str2;
        Method method;
        Class<?>[] nullToEmpty = ArrayUtils.nullToEmpty(clsArr);
        Object[] nullToEmpty2 = ArrayUtils.nullToEmpty(objArr);
        if (z) {
            method = getMatchingMethod(obj.getClass(), str, nullToEmpty);
            if (method != null && !method.isAccessible()) {
                method.setAccessible(true);
            }
            str2 = "No such method: ";
        } else {
            method = getMatchingAccessibleMethod(obj.getClass(), str, nullToEmpty);
            str2 = "No such accessible method: ";
        }
        if (method != null) {
            return method.invoke(obj, toVarArgs(method, nullToEmpty2));
        }
        throw new NoSuchMethodException(str2 + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(obj, false, str, objArr, clsArr);
    }
}
