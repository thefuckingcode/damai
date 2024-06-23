package com.taobao.android.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.taobao.android.modular.IAidlServiceBridge;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.va1;

/* compiled from: Taobao */
public class Services {
    private static final Map<Activity, List<ServiceConnection>> a = new HashMap();
    private static final Map<Activity, List<IBinder>> b = new HashMap();
    private static ClassLoader c;

    /* compiled from: Taobao */
    public static class InvocationOnMainThreadException extends RuntimeException {
        private static final long serialVersionUID = -2830620447552102268L;
    }

    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new ComponentName("", "");
    }

    static void a(Activity activity) {
        List<IBinder> remove = b.remove(activity);
        if (!(remove == null || remove.isEmpty())) {
            for (IBinder iBinder : remove) {
                IBinder a2 = AidlBridgeService.a(activity);
                if (a2 != null) {
                    try {
                        Log.d("Services", "cleanupBridgeBinderOnActivityDestroyed :" + a2.toString());
                        IAidlServiceBridge.Stub.asInterface(a2).unbindService(iBinder);
                    } catch (Exception e) {
                        va1.d("Services", "Failed to unbind bridge binder: " + a2, e);
                    }
                }
            }
        }
    }

    static void b(Activity activity) {
        List<ServiceConnection> remove = a.remove(activity);
        if (!(remove == null || remove.isEmpty())) {
            for (ServiceConnection serviceConnection : remove) {
                try {
                    d(activity, serviceConnection);
                } catch (RuntimeException e) {
                    va1.d("Services", "Failed to unbind service: " + serviceConnection, e);
                }
            }
        }
    }

    public static ClassLoader c() {
        return c;
    }

    public static void d(Context context, ServiceConnection serviceConnection) {
        if (!LocalAidlServices.h(context, serviceConnection)) {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException unused) {
                Log.d("Services", "Already unbound: " + serviceConnection.toString());
            }
        }
    }
}
