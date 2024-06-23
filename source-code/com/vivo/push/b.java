package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.vivo.push.util.p;
import com.vivo.push.util.t;
import com.vivo.push.util.z;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class b implements ServiceConnection {
    private static final Object a = new Object();
    private static Map<String, b> b = new HashMap();
    private boolean c;
    private String d = null;
    private Context e;
    private AtomicInteger f;
    private volatile IPCInvoke g;
    private Object h = new Object();
    private String i;
    private Handler j = null;

    private b(Context context, String str) {
        this.e = context;
        this.i = str;
        boolean z = true;
        this.f = new AtomicInteger(1);
        this.j = new Handler(Looper.getMainLooper(), new c(this));
        String b2 = t.b(context);
        this.d = b2;
        if (TextUtils.isEmpty(b2) || TextUtils.isEmpty(this.i)) {
            Context context2 = this.e;
            p.c(context2, "init error : push pkgname is " + this.d + " ; action is " + this.i);
            this.c = false;
            return;
        }
        this.c = z.a(context, this.d) < 1260 ? false : z;
        b();
    }

    private void d() {
        this.j.removeMessages(1);
        this.j.sendEmptyMessageDelayed(1, 3000);
    }

    private void e() {
        this.j.removeMessages(1);
    }

    /* access modifiers changed from: public */
    private void f() {
        try {
            this.e.unbindService(this);
        } catch (Exception e2) {
            p.a("AidlManager", "On unBindServiceException:" + e2.getMessage());
        }
    }

    public final void onBindingDied(ComponentName componentName) {
        p.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e();
        this.g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.g == null) {
            p.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            f();
            this.f.set(1);
            return;
        }
        if (this.f.get() == 2) {
            a(4);
        } else if (this.f.get() != 4) {
            f();
        }
        synchronized (this.h) {
            this.h.notifyAll();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.g = null;
        a(1);
    }

    public static b a(Context context, String str) {
        b bVar = b.get(str);
        if (bVar == null) {
            synchronized (a) {
                bVar = b.get(str);
                if (bVar == null) {
                    bVar = new b(context, str);
                    b.put(str, bVar);
                }
            }
        }
        return bVar;
    }

    private void b() {
        int i2 = this.f.get();
        p.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i2)));
        if (i2 != 4 && i2 != 2 && i2 != 3 && i2 != 5 && this.c) {
            a(2);
            if (!c()) {
                a(1);
                p.a("AidlManager", "bind core service fail");
                return;
            }
            d();
        }
    }

    private boolean c() {
        Intent intent = new Intent(this.i);
        intent.setPackage(this.d);
        try {
            return this.e.bindService(intent, this, 1);
        } catch (Exception e2) {
            p.a("AidlManager", "bind core error", e2);
            return false;
        }
    }

    public final boolean a() {
        String b2 = t.b(this.e);
        this.d = b2;
        boolean z = false;
        if (TextUtils.isEmpty(b2)) {
            p.c(this.e, "push pkgname is null");
            return false;
        }
        if (z.a(this.e, this.d) >= 1260) {
            z = true;
        }
        this.c = z;
        return z;
    }

    /* access modifiers changed from: public */
    private void a(int i2) {
        this.f.set(i2);
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f.get() == 2) {
            synchronized (this.h) {
                try {
                    this.h.wait(2000);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            int i2 = this.f.get();
            if (i2 == 4) {
                this.j.removeMessages(2);
                this.j.sendEmptyMessageDelayed(2, 30000);
                this.g.asyncCall(bundle, null);
                return true;
            }
            p.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i2)));
            return false;
        } catch (Exception e3) {
            p.a("AidlManager", "invoke error ", e3);
            int i3 = this.f.get();
            p.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i3)));
            if (i3 == 2) {
                e();
                a(1);
                return false;
            } else if (i3 == 3) {
                a(1);
                return false;
            } else if (i3 != 4) {
                return false;
            } else {
                a(1);
                f();
                return false;
            }
        }
    }
}
