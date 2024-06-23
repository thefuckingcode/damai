package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class w implements Runnable {
    final /* synthetic */ Context a;

    w(Context context) {
        this.a = context;
    }

    public void run() {
        try {
            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 4612);
            v.c(this.a);
            v.d(this.a, packageInfo);
            v.c(this.a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
