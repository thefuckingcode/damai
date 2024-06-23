package com.uc.sandboxExport;

import android.content.ServiceConnection;
import com.uc.sandboxExport.PreStartup;

/* compiled from: Taobao */
final class d implements Runnable {
    final /* synthetic */ PreStartup.a a;

    d(PreStartup.a aVar) {
        this.a = aVar;
    }

    public final void run() {
        PreStartup.a aVar = this.a;
        ServiceConnection serviceConnection = aVar.h;
        if (serviceConnection != null) {
            serviceConnection.onServiceConnected(aVar.f, aVar.g);
        }
    }
}
