package com.taobao.weex.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: Taobao */
public class WXInterception {

    /* compiled from: Taobao */
    private interface Intercepted {
    }

    /* compiled from: Taobao */
    public static abstract class InterceptionHandler<T> implements InvocationHandler {
        private T a;

        /* access modifiers changed from: protected */
        public T a() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public void b(T t) {
            this.a = t;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return method.invoke(a(), objArr);
            } catch (IllegalArgumentException e) {
                WXLogUtils.e("", e);
                return null;
            } catch (IllegalAccessException e2) {
                WXLogUtils.e("", e2);
                return null;
            } catch (InvocationTargetException e3) {
                throw e3.getTargetException();
            }
        }
    }

    private WXInterception() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T proxy(Object obj, Class<T> cls, InterceptionHandler<T> interceptionHandler) throws IllegalArgumentException {
        if (obj instanceof Intercepted) {
            return obj;
        }
        interceptionHandler.b(obj);
        return (T) Proxy.newProxyInstance(WXInterception.class.getClassLoader(), new Class[]{cls, Intercepted.class}, interceptionHandler);
    }

    public static <T> T proxy(Object obj, InterceptionHandler<T> interceptionHandler, Class<?>... clsArr) throws IllegalArgumentException {
        interceptionHandler.b(obj);
        return (T) Proxy.newProxyInstance(WXInterception.class.getClassLoader(), clsArr, interceptionHandler);
    }
}
