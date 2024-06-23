package com.taobao.application.common;

import android.app.Application;

/* compiled from: Taobao */
public interface Apm {

    /* compiled from: Taobao */
    public interface OnActivityLifecycleCallbacks extends Application.ActivityLifecycleCallbacks {
    }

    /* compiled from: Taobao */
    public interface OnApmEventListener extends IApmEventListener {
    }

    /* compiled from: Taobao */
    public interface OnAppLaunchListener extends IAppLaunchListener {
    }

    /* compiled from: Taobao */
    public interface OnPageListener extends IPageListener {
    }
}
