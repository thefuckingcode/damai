package com.amap.api.mapcore.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: Taobao */
public class fe {
    ArrayList<a> a = new ArrayList<>();
    private boolean b = false;

    /* compiled from: Taobao */
    public static class a {
        private String a;
        private Object b;
        private Class<?>[] c;
        private Object[] d;

        public a(Object obj, String str, Object... objArr) {
            this.b = obj;
            this.a = str;
            if (objArr != null && objArr.length > 0) {
                this.c = new Class[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    this.c[i] = objArr[i].getClass();
                }
                this.d = new Object[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    this.d[i2] = objArr[i2];
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        if (r3.c.length > 0) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        r5 = new java.lang.Class[r3.c.length];
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        if (r6 < r3.c.length) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        if (r3.c[r6].getInterfaces().length > 0) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        r5[r6] = r3.c[r6].getInterfaces()[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006b, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006e, code lost:
        r5 = r4.getDeclaredMethod(r3.a, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0087, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0088, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008d, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0091, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0092, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0096, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0097, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087 A[ExcHandler: InvocationTargetException (r3v9 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE]), Splitter:B:11:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008c A[ExcHandler: IllegalArgumentException (r3v8 'e' java.lang.IllegalArgumentException A[CUSTOM_DECLARE]), Splitter:B:11:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0091 A[ExcHandler: IllegalAccessException (r3v7 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:11:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0096 A[ExcHandler: SecurityException (r3v6 'e' java.lang.SecurityException A[CUSTOM_DECLARE]), Splitter:B:11:0x001c] */
    public synchronized void a() {
        if (!this.b) {
            this.b = true;
            for (int i = 0; i < this.a.size(); i++) {
                a aVar = this.a.get(i);
                try {
                    if (aVar.b != null) {
                        Class<?> cls = aVar.b.getClass();
                        Method method = null;
                        method = cls.getDeclaredMethod(aVar.a, aVar.c);
                        if (method != null) {
                            method.setAccessible(true);
                            method.invoke(aVar.b, aVar.d);
                        }
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (SecurityException e2) {
                } catch (IllegalAccessException e3) {
                } catch (IllegalArgumentException e4) {
                } catch (InvocationTargetException e5) {
                }
            }
            this.a.clear();
        }
    }

    public synchronized void a(Object obj, Object... objArr) {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 3) {
                this.a.add(new a(obj, stackTrace[3].getMethodName(), objArr));
            }
        } catch (Throwable unused) {
        }
        this.b = false;
    }
}
