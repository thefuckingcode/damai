package com.taobao.android.service;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Debug;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import tb.va1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class LocalAidlServices {
    private static final Map<String, ServiceRecord> a = new HashMap();
    private static final HashMap<ServiceConnection, String> b = new HashMap<>();
    private static final Method c;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class ServiceRecord extends CopyOnWriteArrayList<ServiceConnection> {
        private static final long serialVersionUID = 1;

        /* renamed from: app  reason: collision with root package name */
        final Application f1063app;
        final IBinder binder;
        final Intent intent;
        final Service service;

        ServiceRecord(Application application, Intent intent2, IBinder iBinder, Service service2) {
            this.f1063app = application;
            this.intent = intent2;
            this.binder = iBinder;
            this.service = service2;
        }
    }

    static {
        Method method = null;
        try {
            method = Service.class.getDeclaredMethod("attach", Context.class, Class.forName("android.app.ActivityThread"), String.class, IBinder.class, Application.class, Object.class);
            method.setAccessible(true);
        } catch (ClassNotFoundException e) {
            Log.e("LocalSvc", "Incompatible ROM", e);
        } catch (NoSuchMethodException e2) {
            Log.e("LocalSvc", "Incompatible ROM", e2);
        }
        c = method;
    }

    private static void a(Context context, Class<? extends Service> cls, Service service, Application application) {
        Method method = c;
        if (method != null) {
            try {
                method.invoke(service, context, null, cls.getName(), null, application, null);
            } catch (IllegalAccessException e) {
                va1.b("LocalSvc", "Unexpected exception when attaching service.", e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getTargetException());
            }
        }
    }

    static boolean b(Context context, Intent intent, ServiceConnection serviceConnection) throws ClassNotFoundException {
        ComponentName component = intent.getComponent();
        if (component == null) {
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService == null) {
                return false;
            }
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            component = new ComponentName(serviceInfo.packageName, serviceInfo.name.intern());
        }
        Map<String, ServiceRecord> map = a;
        ServiceRecord serviceRecord = map.get(component.getClassName());
        if (serviceRecord == null) {
            serviceRecord = c(context, intent, component);
            if (serviceRecord == null) {
                return false;
            }
            map.put(component.getClassName(), serviceRecord);
        }
        serviceRecord.add(serviceConnection);
        b.put(serviceConnection, component.getClassName());
        try {
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            serviceConnection.onServiceConnected(component, serviceRecord.binder);
            f(threadCpuTimeNanos + 2000000, serviceConnection, ".onServiceConnected()");
            return true;
        } catch (RuntimeException e) {
            va1.d("LocalSvc", serviceConnection + ".onServiceConnected()", e);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0098 A[SYNTHETIC, Splitter:B:25:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b8  */
    private static ServiceRecord c(Context context, Intent intent, ComponentName componentName) throws ClassNotFoundException {
        IBinder iBinder;
        RuntimeException e;
        Class<? extends Service> e2 = e(context, componentName.getClassName());
        if (e2 == null || !AidlService.class.isAssignableFrom(e2)) {
            return null;
        }
        try {
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            Service service = (Service) e2.newInstance();
            f(threadCpuTimeNanos + 2000000, e2.getName(), "()");
            Application d = d(context);
            a(context, e2, service, d);
            try {
                long threadCpuTimeNanos2 = Debug.threadCpuTimeNanos();
                service.onCreate();
                f(threadCpuTimeNanos2 + 5000000, service, ".onCreate()");
            } catch (RuntimeException e3) {
                va1.d("LocalSvc", service + ".onCreate()", e3);
            }
            try {
                long threadCpuTimeNanos3 = Debug.threadCpuTimeNanos();
                iBinder = service.onBind(intent);
                try {
                    f(threadCpuTimeNanos3 + 2000000, service, ".onBind()");
                    if (iBinder == null) {
                        Log.e("LocalSvc", service + ".onBind() should never return null.");
                    }
                } catch (RuntimeException e4) {
                    e = e4;
                    va1.d("LocalSvc", service + ".onBind()", e);
                    if (iBinder == null) {
                    }
                }
            } catch (RuntimeException e5) {
                e = e5;
                iBinder = null;
                va1.d("LocalSvc", service + ".onBind()", e);
                if (iBinder == null) {
                }
            }
            if (iBinder == null) {
                try {
                    long threadCpuTimeNanos4 = Debug.threadCpuTimeNanos();
                    service.onDestroy();
                    f(threadCpuTimeNanos4 + 5000000, service, ".onDestroy()");
                } catch (RuntimeException e6) {
                    va1.d("LocalSvc", service + ".onDestroy()", e6);
                }
                return null;
            }
            g(d, service);
            return new ServiceRecord(d, intent, iBinder, service);
        } catch (InstantiationException e7) {
            va1.d("LocalSvc", "Failed to instantiate " + componentName.getClassName(), e7);
            return null;
        } catch (IllegalAccessException e8) {
            va1.d("LocalSvc", "Constructor of " + componentName.getClassName() + " is inaccessible", e8);
            return null;
        }
    }

    private static Application d(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getApplication();
        }
        if (context instanceof Service) {
            return ((Service) context).getApplication();
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            return (Application) applicationContext;
        }
        va1.c("LocalSvc", "Cannot discover application from context " + context);
        return null;
    }

    /* JADX DEBUG: Type inference failed for r1v6. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends android.app.Service> */
    private static Class<? extends Service> e(Context context, String str) throws ClassNotFoundException {
        try {
            return (Services.c() != null ? Services.c() : context.getClassLoader()).loadClass(str);
        } catch (ClassCastException unused) {
            va1.a("LocalSvc", "Not a Service derived class: " + str);
            return null;
        }
    }

    private static void f(long j, Object obj, String str) {
        long threadCpuTimeNanos = Debug.threadCpuTimeNanos() - j;
        if (threadCpuTimeNanos > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(obj.toString());
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(" exceed the deadline ");
            sb.append(threadCpuTimeNanos / 1000000);
            sb.append("ms (thread CPU time)");
            Log.w("LocalSvc", sb.toString());
        }
    }

    @TargetApi(14)
    private static void g(Application application, ComponentCallbacks componentCallbacks) {
        if (Build.VERSION.SDK_INT >= 14) {
            application.registerComponentCallbacks(componentCallbacks);
        }
    }

    public static boolean h(Context context, ServiceConnection serviceConnection) {
        ServiceRecord serviceRecord;
        String remove = b.remove(serviceConnection);
        if (remove == null || (serviceRecord = a.get(remove)) == null) {
            return false;
        }
        if (!serviceRecord.remove(serviceConnection)) {
            va1.a("LocalSvc", "Internal inconsistency, please report this to the corresponding dev team: " + serviceConnection + " @ " + remove);
        }
        try {
            serviceConnection.onServiceDisconnected(new ComponentName(context.getPackageName(), serviceRecord.service.getClass().getName()));
        } catch (RuntimeException e) {
            va1.d("LocalSvc", serviceConnection + ".onServiceDisconnected()", e);
        }
        if (!serviceRecord.isEmpty()) {
            return true;
        }
        a.remove(remove);
        i(serviceRecord.f1063app, serviceRecord.service);
        try {
            serviceRecord.service.onUnbind(serviceRecord.intent);
        } catch (RuntimeException e2) {
            va1.d("LocalSvc", serviceRecord.service + ".onUnbind()", e2);
        }
        try {
            serviceRecord.service.onDestroy();
            return true;
        } catch (RuntimeException e3) {
            va1.d("LocalSvc", serviceRecord.service + ".onDestroy()", e3);
            return true;
        }
    }

    @TargetApi(14)
    private static void i(Application application, ComponentCallbacks componentCallbacks) {
        if (application != null && Build.VERSION.SDK_INT >= 14) {
            application.unregisterComponentCallbacks(componentCallbacks);
        }
    }
}
