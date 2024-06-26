package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class f {
    private final Set<Type> a = Sets.d();

    f() {
    }

    public final void a(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null && this.a.add(type)) {
                try {
                    if (type instanceof TypeVariable) {
                        e((TypeVariable) type);
                    } else if (type instanceof WildcardType) {
                        f((WildcardType) type);
                    } else if (type instanceof ParameterizedType) {
                        d((ParameterizedType) type);
                    } else if (type instanceof Class) {
                        b((Class) type);
                    } else if (type instanceof GenericArrayType) {
                        c((GenericArrayType) type);
                    } else {
                        throw new AssertionError("Unknown type: " + type);
                    }
                } catch (Throwable th) {
                    this.a.remove(type);
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Class<?> cls) {
    }

    /* access modifiers changed from: package-private */
    public void c(GenericArrayType genericArrayType) {
    }

    /* access modifiers changed from: package-private */
    public void d(ParameterizedType parameterizedType) {
    }

    /* access modifiers changed from: package-private */
    public abstract void e(TypeVariable<?> typeVariable);

    /* access modifiers changed from: package-private */
    public abstract void f(WildcardType wildcardType);
}
