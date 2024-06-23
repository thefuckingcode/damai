package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.b;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class as implements ServiceConnection {
    final /* synthetic */ ao a;

    as(ao aoVar) {
        this.a = aoVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a) {
            this.a.f51a = new Messenger(iBinder);
            this.a.c = false;
            for (Message message : ao.a(this.a)) {
                try {
                    ao.a(this.a).send(message);
                } catch (RemoteException e) {
                    b.a(e);
                }
            }
            ao.a(this.a).clear();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a.f51a = null;
        this.a.c = false;
    }
}
