package com.taobao.android.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import com.taobao.android.modular.IAidlServiceBridge;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class AidlBridgeService extends Service {
    private static final String b = AidlBridgeService.class.getName();
    private static final BroadcastReceiver c = new BroadcastReceiver() {
        /* class com.taobao.android.service.AidlBridgeService.AnonymousClass2 */

        public void onReceive(Context context, Intent intent) {
        }
    };
    private IAidlServiceBridge a = new IAidlServiceBridge.Stub() {
        /* class com.taobao.android.service.AidlBridgeService.AnonymousClass1 */
        private Map<ComponentName, a> mServices = new HashMap();

        @Override // com.taobao.android.modular.IAidlServiceBridge
        public synchronized IBinder bindService(Intent intent) {
            ComponentName component = intent.getComponent();
            boolean z = false;
            if (component == null) {
                ResolveInfo resolveService = AidlBridgeService.this.getPackageManager().resolveService(intent, 0);
                if (resolveService == null) {
                    return null;
                }
                ServiceInfo serviceInfo = resolveService.serviceInfo;
                component = new ComponentName(serviceInfo.packageName, serviceInfo.name);
            }
            a aVar = this.mServices.get(component);
            if (aVar != null) {
                return aVar.a;
            }
            intent.setComponent(component);
            a aVar2 = new a();
            try {
                z = LocalAidlServices.b(AidlBridgeService.this, intent, aVar2);
            } catch (ClassNotFoundException unused) {
            }
            if (!z) {
                return null;
            }
            this.mServices.put(component, aVar2);
            return aVar2.a;
        }

        @Override // com.taobao.android.modular.IAidlServiceBridge
        public synchronized void unbindService(IBinder iBinder) {
            Iterator<Map.Entry<ComponentName, a>> it = this.mServices.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value.a == iBinder) {
                    LocalAidlServices.h(AidlBridgeService.this, value);
                    it.remove();
                }
            }
        }
    };

    /* compiled from: Taobao */
    private static class a implements ServiceConnection {
        IBinder a;

        private a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.a = iBinder;
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static IBinder a(Context context) {
        return c.peekService(context, new Intent(context, AidlBridgeService.class));
    }

    public IBinder onBind(Intent intent) {
        if (intent.getAction() == null) {
            return (IBinder) this.a;
        }
        intent.setComponent(null).setPackage(getPackageName());
        List<ResolveInfo> queryIntentServices = getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (!b.equals(resolveInfo.serviceInfo.name)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    intent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
                    try {
                        IBinder bindService = this.a.bindService(intent);
                        intent.setComponent(null);
                        return bindService;
                    } catch (RemoteException unused) {
                    }
                }
            }
        }
        return null;
    }
}
