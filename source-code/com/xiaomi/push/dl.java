package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: Taobao */
public class dl implements Application.ActivityLifecycleCallbacks {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private String f219a = "";
    private String b;

    public dl(Context context, String str) {
        this.a = context;
        this.f219a = str;
    }

    private void a(String str) {
        hr hrVar = new hr();
        hrVar.a(str);
        hrVar.a(System.currentTimeMillis());
        hrVar.a(hl.ActivityActiveTimeStamp);
        dt.a(this.a, hrVar);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (!TextUtils.isEmpty(this.f219a) && !TextUtils.isEmpty(localClassName)) {
            this.b = "";
            if (TextUtils.isEmpty("") || TextUtils.equals(this.b, localClassName)) {
                a(this.a.getPackageName() + "|" + localClassName + ":" + this.f219a + "," + String.valueOf(System.currentTimeMillis() / 1000));
                this.f219a = "";
                this.b = "";
                return;
            }
            this.f219a = "";
        }
    }

    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = activity.getLocalClassName();
        }
        this.f219a = String.valueOf(System.currentTimeMillis() / 1000);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
