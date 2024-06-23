package com.alibaba.analytics;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: Taobao */
public class AnalyticsService extends Service {
    IAnalytics a = null;

    public IBinder onBind(Intent intent) {
        if (this.a == null) {
            this.a = new AnalyticsImp(getApplication());
        }
        return (IBinder) this.a;
    }

    public void onDestroy() {
        IAnalytics iAnalytics = this.a;
        if (iAnalytics != null) {
            try {
                iAnalytics.triggerUpload();
            } catch (RemoteException unused) {
            }
        }
        super.onDestroy();
    }

    public void onLowMemory() {
        IAnalytics iAnalytics = this.a;
        if (iAnalytics != null) {
            try {
                iAnalytics.triggerUpload();
            } catch (RemoteException unused) {
            }
        }
        super.onLowMemory();
    }
}
