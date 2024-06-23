package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: Taobao */
public interface BaseNotifyDataAdapter {
    int getDefaultNotifyIcon();

    int getDefaultSmallIconId();

    int getNotifyMode(InsideNotificationItem insideNotificationItem);

    void init(Context context);
}
