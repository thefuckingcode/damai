package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.b;

/* compiled from: Taobao */
class bu implements ServiceConnection {
    final /* synthetic */ ServiceClient a;

    bu(ServiceClient serviceClient) {
        this.a = serviceClient;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a) {
            ServiceClient.a(this.a, new Messenger(iBinder));
            ServiceClient.a(this.a, false);
            for (Message message : ServiceClient.a(this.a)) {
                try {
                    ServiceClient.a(this.a).send(message);
                } catch (RemoteException e) {
                    b.a(e);
                }
            }
            ServiceClient.a(this.a).clear();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        ServiceClient.a(this.a, (Messenger) null);
        ServiceClient.a(this.a, false);
    }
}
