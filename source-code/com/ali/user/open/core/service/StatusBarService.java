package com.ali.user.open.core.service;

import android.app.Activity;

/* compiled from: Taobao */
public interface StatusBarService {
    int getTransparentWebLayout();

    int getWebDialogLayout();

    int getWebLayout();

    void setStatusBar(Activity activity);
}
