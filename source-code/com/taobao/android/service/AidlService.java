package com.taobao.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import tb.jl1;

/* compiled from: Taobao */
public class AidlService<I extends IInterface, Stub extends Binder & IInterface> extends Service {
    private Binder a;

    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
        throw new java.lang.IllegalArgumentException(r5 + " must be either standalone class or inner class of " + getClass() + ", and have a empty constructor.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002c */
    private Binder a(Class<Stub> cls) {
        try {
            return cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (NoSuchMethodException unused) {
            return cls.getDeclaredConstructor(getClass()).newInstance(this);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            throw new RuntimeException(targetException);
        } catch (IllegalAccessException unused2) {
            throw new IllegalArgumentException(cls + " and its empty constructor must be both public.");
        } catch (Exception e2) {
            throw new IllegalArgumentException("Stub " + cls + " of service " + getClass() + " cannot be instantiated.", e2);
        }
    }

    private static Type[] b(Class<?> cls) {
        while (cls != null) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
                if (AidlService.class.equals(parameterizedType.getRawType())) {
                    return parameterizedType.getActualTypeArguments();
                }
            }
            cls = cls.getSuperclass();
        }
        throw new IllegalArgumentException();
    }

    public final IBinder onBind(Intent intent) {
        Binder binder = this.a;
        if (binder != null) {
            return binder;
        }
        throw new IllegalStateException("AidlService is not initialized. Did you forget to call super.onCreate() in onCreate() method of AidlService derived class?");
    }

    public void onCreate() {
        super.onCreate();
        Type[] b = b(getClass());
        if (!(b[0] instanceof Class)) {
            throw new IllegalArgumentException(b[0] + " is not an AIDL interface");
        } else if (b[1] instanceof Class) {
            Class cls = (Class) b[0];
            Class<Stub> cls2 = (Class) b[1];
            if (cls.isAssignableFrom(cls2)) {
                this.a = a(cls2);
                return;
            }
            throw new IllegalArgumentException(cls2 + " is not paired with " + cls);
        } else {
            throw new IllegalArgumentException(b[1] + " is not an AIDL Stub class");
        }
    }

    public void onDestroy() {
        this.a = null;
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        Log.w("AidlService", "Start operation is not allowed for AIDL service.");
        stopSelf(i2);
        return 2;
    }

    public String toString() {
        if (this.a == null) {
            return "AidlService[null]";
        }
        return "AidlService[" + this.a.getInterfaceDescriptor() + jl1.ARRAY_END_STR;
    }
}
