package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;

/* compiled from: Taobao */
public final class ki extends Handler {
    kg a = null;

    public ki(Looper looper, kg kgVar) {
        super(looper);
        this.a = kgVar;
    }

    public ki(kg kgVar) {
        this.a = kgVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            try {
                kg kgVar = this.a;
                if (kgVar != null) {
                    kgVar.a((Inner_3dMap_location) message.obj);
                }
            } catch (Throwable th) {
                jy.a(th, "ClientResultHandler", "RESULT_LOCATION_FINISH");
            }
        }
    }
}
