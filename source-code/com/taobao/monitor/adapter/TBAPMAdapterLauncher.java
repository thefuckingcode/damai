package com.taobao.monitor.adapter;

import android.app.Application;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
public class TBAPMAdapterLauncher implements Serializable {
    public void init(Application application, HashMap<String, Object> hashMap) {
        new TBAPMInitiator().init(application, hashMap);
    }
}
