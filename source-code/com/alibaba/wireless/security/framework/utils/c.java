package com.alibaba.wireless.security.framework.utils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* compiled from: Taobao */
public class c {
    private final Object a;
    private final boolean b = false;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private a() {
        }
    }

    private c(Object obj) {
        this.a = obj;
    }

    public static c a(Object obj) {
        return new c(obj);
    }

    private static c a(Method method, Object obj, Object... objArr) throws d {
        try {
            a((AccessibleObject) method);
            if (method.getReturnType() != Void.TYPE) {
                return a(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return a(obj);
        } catch (Exception e) {
            throw new d(e);
        }
    }

    public static Class<?> a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    public static <T extends AccessibleObject> T a(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0009 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0004 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.reflect.Method] */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:4|5|12|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        throw new java.lang.NoSuchMethodException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        return r0.getDeclaredMethod(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r0 = r0.getSuperclass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0 != null) goto L_0x0009;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
    private Method a(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> b2 = b();
        str = b2.getMethod(str, clsArr);
        return str;
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != a.class && !a(clsArr[i]).isAssignableFrom(a(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    private static Class<?>[] a(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? a.class : obj.getClass();
        }
        return clsArr;
    }

    private Method b(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> b2 = b();
        Method[] methods = b2.getMethods();
        for (Method method : methods) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            Method[] declaredMethods = b2.getDeclaredMethods();
            for (Method method2 : declaredMethods) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            b2 = b2.getSuperclass();
        } while (b2 != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + b() + ".");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0004 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.alibaba.wireless.security.framework.utils.c] */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        return a(b(r4, r0), r3.a, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        throw new com.alibaba.wireless.security.framework.utils.d(r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000f */
    public c a(String str, Object... objArr) throws d {
        Class<?>[] a2 = a(objArr);
        str = a(a(str, a2), this.a, objArr);
        return str;
    }

    public <T> T a() {
        return (T) this.a;
    }

    public Class<?> b() {
        return this.b ? (Class) this.a : this.a.getClass();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.a.equals(((c) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
