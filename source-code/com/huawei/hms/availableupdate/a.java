package com.huawei.hms.availableupdate;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class a {
    public static final a b = new a();
    public WeakReference<Activity> a;

    public boolean a(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityCreate");
        Activity a2 = a();
        if (a2 == null || a2.isFinishing()) {
            this.a = new WeakReference<>(activity);
            return true;
        }
        activity.finish();
        HMSLog.i("UpdateAdapterMgr", "finish one");
        return false;
    }

    public void b(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityDestroy");
        Activity a2 = a();
        if (activity != null && activity.equals(a2)) {
            HMSLog.i("UpdateAdapterMgr", "reset");
            this.a = null;
        }
    }

    public final Activity a() {
        WeakReference<Activity> weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
