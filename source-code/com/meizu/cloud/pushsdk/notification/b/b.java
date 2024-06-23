package com.meizu.cloud.pushsdk.notification.b;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.c.c;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;

/* compiled from: Taobao */
public class b extends c {
    public b(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.notification.a
    public void a(Notification notification, MessageV3 messageV3, PendingIntent pendingIntent) {
        if (MinSdkChecker.isSupportNotificationBuild()) {
            RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), c.b(this.a));
            remoteViews.setTextViewText(c.d(this.a), messageV3.getTitle());
            remoteViews.setLong(c.f(this.a), "setTime", System.currentTimeMillis());
            a(remoteViews, messageV3);
            if (messageV3.getNotificationStyle() != null && !TextUtils.isEmpty(messageV3.getNotificationStyle().getExpandableText())) {
                remoteViews.setViewVisibility(c.h(this.a), 0);
                remoteViews.setTextViewText(c.h(this.a), messageV3.getNotificationStyle().getExpandableText());
            }
            notification.bigContentView = remoteViews;
        }
    }
}
