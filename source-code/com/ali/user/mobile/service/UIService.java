package com.ali.user.mobile.service;

import android.content.Context;

/* compiled from: Taobao */
public interface UIService {
    boolean finishWebViewActivity(Context context);

    boolean isWebViewActivity(Context context);

    void setWebViewTitleBarVisibility(Context context, boolean z);

    void switchWebViewTitleBarRightButton(Context context, boolean z, String str);
}
