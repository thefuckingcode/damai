package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.b;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.e;
import kotlin.collections.n;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import tb.dz1;
import tb.k21;
import tb.z41;

public final class AnnotationConstructorCallerKt {

    public static final class a implements InvocationHandler {
        final /* synthetic */ Class a;
        final /* synthetic */ Lazy b;
        final /* synthetic */ KProperty c;
        final /* synthetic */ Lazy d;
        final /* synthetic */ KProperty e;
        final /* synthetic */ AnnotationConstructorCallerKt$createAnnotationInstance$2 f;
        final /* synthetic */ Map g;

        a(Class cls, Lazy lazy, KProperty kProperty, Lazy lazy2, KProperty kProperty2, AnnotationConstructorCallerKt$createAnnotationInstance$2 annotationConstructorCallerKt$createAnnotationInstance$2, Map map) {
            this.a = cls;
            this.b = lazy;
            this.c = kProperty;
            this.d = lazy2;
            this.e = kProperty2;
            this.f = annotationConstructorCallerKt$createAnnotationInstance$2;
            this.g = map;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            k21.h(method, "method");
            String name = method.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != -1776922004) {
                    if (hashCode != 147696667) {
                        if (hashCode == 1444986633 && name.equals("annotationType")) {
                            return this.a;
                        }
                    } else if (name.equals("hashCode")) {
                        return this.d.getValue();
                    }
                } else if (name.equals("toString")) {
                    return this.b.getValue();
                }
            }
            if (k21.d(name, "equals") && objArr != null && objArr.length == 1) {
                return Boolean.valueOf(this.f.invoke(e.L(objArr)));
            }
            if (this.g.containsKey(name)) {
                return this.g.get(name);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Method is not supported: ");
            sb.append(method);
            sb.append(" (args: ");
            if (objArr == null) {
                objArr = new Object[0];
            }
            sb.append(ArraysKt___ArraysKt.X(objArr));
            sb.append(')');
            throw new KotlinReflectionInternalError(sb.toString());
        }
    }

    public static final <T> T c(Class<T> cls, Map<String, ? extends Object> map, List<Method> list) {
        k21.i(cls, "annotationClass");
        k21.i(map, "values");
        k21.i(list, "methods");
        AnnotationConstructorCallerKt$createAnnotationInstance$2 annotationConstructorCallerKt$createAnnotationInstance$2 = new AnnotationConstructorCallerKt$createAnnotationInstance$2(cls, list, map);
        Lazy lazy = b.b(new AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2(map));
        Lazy lazy2 = b.b(new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(cls, map));
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls, lazy2, null, lazy, null, annotationConstructorCallerKt$createAnnotationInstance$2, map));
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }

    public static /* synthetic */ Object d(Class cls, Map map, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            Set<String> keySet = map.keySet();
            ArrayList arrayList = new ArrayList(n.q(keySet, 10));
            for (String str : keySet) {
                arrayList.add(cls.getDeclaredMethod(str, new Class[0]));
            }
            list = arrayList;
        }
        return c(cls, map, list);
    }

    public static final Void e(int i, String str, Class<?> cls) {
        KClass kClass;
        String str2;
        if (k21.d(cls, Class.class)) {
            kClass = dz1.b(KClass.class);
        } else if (!cls.isArray() || !k21.d(cls.getComponentType(), Class.class)) {
            kClass = z41.e(cls);
        } else {
            kClass = dz1.b(KClass[].class);
        }
        if (k21.d(kClass.getQualifiedName(), dz1.b(Object[].class).getQualifiedName())) {
            StringBuilder sb = new StringBuilder();
            sb.append(kClass.getQualifiedName());
            sb.append('<');
            Class<?> componentType = z41.b(kClass).getComponentType();
            k21.h(componentType, "kotlinClass.java.componentType");
            sb.append(z41.e(componentType).getQualifiedName());
            sb.append('>');
            str2 = sb.toString();
        } else {
            str2 = kClass.getQualifiedName();
        }
        throw new IllegalArgumentException("Argument #" + i + ' ' + str + " is not of the required type " + str2);
    }

    public static final Object f(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof KClass) {
            obj = z41.b((KClass) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof KClass[]) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                KClass[] kClassArr = (KClass[]) obj;
                ArrayList arrayList = new ArrayList(kClassArr.length);
                for (KClass kClass : kClassArr) {
                    arrayList.add(z41.b(kClass));
                }
                obj = arrayList.toArray(new Class[0]);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T>");
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}
