package com.taobao.android.launcher.statistics.common.monitor.zcache;

import android.taobao.windvane.packageapp.WVPackageAppManager;
import android.taobao.windvane.packageapp.adaptive.IZCacheFirstUpdateFinishCallback;

/* compiled from: Taobao */
public class ZCache implements IZCacheFirstUpdateFinishCallback {
    public final Info info = new Info();

    /* compiled from: Taobao */
    public static class Info {
        public int count;
        public String type;
    }

    public void start() {
        WVPackageAppManager.getInstance().registerUpdateFinishCallback(this);
    }

    public void stop() {
        WVPackageAppManager.getInstance().registerUpdateFinishCallback(null);
    }

    @Override // android.taobao.windvane.packageapp.adaptive.IZCacheFirstUpdateFinishCallback
    public void updateCount(String str, int i) {
        Info info2 = this.info;
        info2.type = str;
        info2.count = i;
    }
}
