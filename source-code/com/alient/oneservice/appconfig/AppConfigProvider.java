package com.alient.oneservice.appconfig;

import android.app.Activity;

/* compiled from: Taobao */
public interface AppConfigProvider {
    void showToast(Activity activity, String str, int i);

    Activity topActivity();
}
