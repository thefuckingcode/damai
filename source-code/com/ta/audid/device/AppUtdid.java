package com.ta.audid.device;

import android.content.Context;
import com.ut.device.UTDevice;

@Deprecated
/* compiled from: Taobao */
public class AppUtdid {
    private static final AppUtdid mInstance = new AppUtdid();

    private AppUtdid() {
    }

    public static AppUtdid getInstance() {
        return mInstance;
    }

    @Deprecated
    public synchronized String getUtdid() {
        return com.ta.utdid2.device.AppUtdid.getInstance().getUtdidCache();
    }

    @Deprecated
    public synchronized String getUtdid(Context context) {
        return UTDevice.getUtdid(context);
    }
}
