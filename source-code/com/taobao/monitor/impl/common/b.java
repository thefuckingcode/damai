package com.taobao.monitor.impl.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;
import tb.dm2;
import tb.i20;
import tb.lc0;
import tb.ws0;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class b extends Observable implements InvocationHandler {
    private final Object a;

    b(Object obj) {
        this.a = obj;
    }

    private void a() {
        try {
            Throwable th = new Throwable();
            Thread currentThread = Thread.currentThread();
            StringBuilder sb = new StringBuilder();
            StackTraceElement[] stackTrace = th.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append("\tat " + stackTraceElement);
            }
            i20.a("ActivityManagerProxy", currentThread.getName(), sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getName().contains("startActivity")) {
            ws0.m = dm2.a();
            if (lc0.m) {
                a();
            }
        }
        try {
            return method.invoke(this.a, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException != null && (targetException instanceof IllegalArgumentException) && method.getName().equals("reportSizeConfigurations") && lc0.h) {
                setChanged();
                notifyObservers(targetException);
                return null;
            } else if (targetException != null && method.getName().equals("isTopOfTask") && (targetException instanceof IllegalArgumentException) && lc0.h) {
                return Boolean.FALSE;
            } else {
                throw targetException;
            }
        }
    }
}
