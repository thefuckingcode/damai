package com.uc.sandboxExport;

import android.os.IBinder;
import com.uc.sandboxExport.PreStartup;

/* compiled from: Taobao */
final class e implements Runnable {
    final /* synthetic */ IBinder a;
    final /* synthetic */ PreStartup.a b;

    e(PreStartup.a aVar, IBinder iBinder) {
        this.b = aVar;
        this.a = iBinder;
    }

    public final void run() {
        PreStartup.a.a(this.b, this.a);
    }
}
