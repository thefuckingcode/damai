package com.alipay.sdk.m.r0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.alipay.sdk.m.q0.a;
import java.util.Objects;

/* compiled from: Taobao */
public class b {
    public static String e = "OpenDeviceId library";
    public static boolean f;
    public Context a = null;
    public com.alipay.sdk.m.q0.a b;
    public ServiceConnection c;
    public AbstractC0133b d = null;

    /* compiled from: Taobao */
    public class a implements ServiceConnection {
        public a() {
        }

        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.b = a.AbstractBinderC0131a.a(iBinder);
            if (b.this.d != null) {
                b.this.d.a("Deviceid Service Connected", b.this);
            }
            b.this.c("Service onServiceConnected");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            b.this.b = null;
            b.this.c("Service onServiceDisconnected");
        }
    }

    /* renamed from: com.alipay.sdk.m.r0.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public interface AbstractC0133b<T> {
        void a(T t, b bVar);
    }

    public String b() {
        if (this.a != null) {
            try {
                com.alipay.sdk.m.q0.a aVar = this.b;
                if (aVar != null) {
                    return aVar.a();
                }
                return null;
            } catch (RemoteException e2) {
                b("getOAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        } else {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public String c() {
        if (this.a != null) {
            try {
                com.alipay.sdk.m.q0.a aVar = this.b;
                if (aVar != null) {
                    return aVar.b();
                }
                return null;
            } catch (RemoteException e2) {
                b("getUDID error, RemoteException!");
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                b("getUDID error, Exception!");
                e3.printStackTrace();
                return null;
            }
        } else {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public String d() {
        Context context = this.a;
        if (context != null) {
            String packageName = context.getPackageName();
            c("liufeng, getVAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                c("input package is null!");
                return null;
            }
            try {
                com.alipay.sdk.m.q0.a aVar = this.b;
                if (aVar != null) {
                    return aVar.b(packageName);
                }
                return null;
            } catch (RemoteException e2) {
                b("getVAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        } else {
            c("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public boolean e() {
        try {
            if (this.b == null) {
                return false;
            }
            c("Device support opendeviceid");
            return this.b.c();
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public void f() {
        try {
            this.a.unbindService(this.c);
            c("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            b("unBind Service exception");
        }
        this.b = null;
    }

    public int a(Context context, AbstractC0133b<String> bVar) {
        Objects.requireNonNull(context, "Context can not be null.");
        this.a = context;
        this.d = bVar;
        this.c = new a();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.a.bindService(intent, this.c, 1)) {
            c("bindService Successful!");
            return 1;
        }
        c("bindService Failed!");
        return -1;
    }

    private void b(String str) {
        if (f) {
            Log.e(e, str);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(String str) {
        if (f) {
            Log.i(e, str);
        }
    }

    public String a() {
        Context context = this.a;
        if (context != null) {
            String packageName = context.getPackageName();
            c("liufeng, getAAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                c("input package is null!");
                return null;
            }
            try {
                com.alipay.sdk.m.q0.a aVar = this.b;
                if (aVar == null) {
                    return null;
                }
                String a2 = aVar.a(packageName);
                if ((a2 == null || "".equals(a2)) && this.b.c(packageName)) {
                    return this.b.a(packageName);
                }
                return a2;
            } catch (RemoteException unused) {
                b("getAAID error, RemoteException!");
                return null;
            }
        } else {
            c("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public void a(boolean z) {
        f = z;
    }
}
