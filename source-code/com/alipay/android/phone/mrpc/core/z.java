package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.android.phone.mrpc.core.a.d;
import com.alipay.android.phone.mrpc.core.a.e;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public final class z {
    public static final ThreadLocal<Object> a = new ThreadLocal<>();
    public static final ThreadLocal<Map<String, Object>> b = new ThreadLocal<>();
    public byte c = 0;
    public AtomicInteger d;
    public x e;

    public z(x xVar) {
        this.e = xVar;
        this.d = new AtomicInteger();
    }

    public final Object a(Method method, Object[] objArr) {
        if (!(Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper())) {
            OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
            boolean z = method.getAnnotation(ResetCookie.class) != null;
            Type genericReturnType = method.getGenericReturnType();
            method.getAnnotations();
            ThreadLocal<Object> threadLocal = a;
            threadLocal.set(null);
            ThreadLocal<Map<String, Object>> threadLocal2 = b;
            threadLocal2.set(null);
            if (operationType != null) {
                String value = operationType.value();
                int incrementAndGet = this.d.incrementAndGet();
                try {
                    if (this.c == 0) {
                        e eVar = new e(incrementAndGet, value, objArr);
                        if (threadLocal2.get() != null) {
                            eVar.a(threadLocal2.get());
                        }
                        byte[] a2 = eVar.a();
                        threadLocal2.set(null);
                        Object a3 = new d(genericReturnType, (byte[]) new j(this.e.a(), method, incrementAndGet, value, a2, z).a()).a();
                        if (genericReturnType != Void.TYPE) {
                            threadLocal.set(a3);
                        }
                    }
                    return threadLocal.get();
                } catch (RpcException e2) {
                    e2.setOperationType(value);
                    throw e2;
                }
            } else {
                throw new IllegalStateException("OperationType must be set.");
            }
        } else {
            throw new IllegalThreadStateException("can't in main thread call rpc .");
        }
    }
}
