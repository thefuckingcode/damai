package com.vivo.push.util;

import android.content.Context;

/* compiled from: Taobao */
public interface BaseNotifyLayoutAdapter {
    int getNotificationLayout();

    int getSuitIconId();

    int getTitleColor();

    void init(Context context);
}
