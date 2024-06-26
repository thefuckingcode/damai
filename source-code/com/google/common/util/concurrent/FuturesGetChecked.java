package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtIncompatible
/* compiled from: Taobao */
final class FuturesGetChecked {
    private static final Ordering<Constructor<?>> a = Ordering.natural().onResultOf(new a()).reverse();

    @VisibleForTesting
    /* compiled from: Taobao */
    interface GetCheckedTypeValidator {
        void validateClass(Class<? extends Exception> cls);
    }

    /* compiled from: Taobao */
    static class a implements Function<Constructor<?>, Boolean> {
        a() {
        }

        /* renamed from: a */
        public Boolean apply(Constructor<?> constructor) {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
        }
    }

    @VisibleForTesting
    static void a(Class<? extends Exception> cls) {
        ds1.k(c(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        ds1.k(b(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    private static boolean b(Class<? extends Exception> cls) {
        try {
            e(cls, new Exception());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @VisibleForTesting
    static boolean c(Class<? extends Exception> cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    @NullableDecl
    private static <X> X d(Constructor<X> constructor, Throwable th) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> cls = parameterTypes[i];
            if (cls.equals(String.class)) {
                objArr[i] = th.toString();
            } else if (!cls.equals(Throwable.class)) {
                return null;
            } else {
                objArr[i] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static <X extends Exception> X e(Class<X> cls, Throwable th) {
        for (Constructor constructor : f(Arrays.asList(cls.getConstructors()))) {
            X x = (X) ((Exception) d(constructor, th));
            if (x != null) {
                if (x.getCause() == null) {
                    x.initCause(th);
                }
                return x;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    private static <X extends Exception> List<Constructor<X>> f(List<Constructor<X>> list) {
        return a.sortedCopy(list);
    }
}
