package com.meizu.cloud.pushsdk.notification.b;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.c.c;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;

/* compiled from: Taobao */
public class a extends c {
    public a(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    private void b(RemoteViews remoteViews, MessageV3 messageV3) {
        Bitmap a;
        if (messageV3.getNotificationStyle() != null && !a()) {
            if (TextUtils.isEmpty(messageV3.getNotificationStyle().getExpandableImageUrl()) || (a = a(messageV3.getNotificationStyle().getExpandableImageUrl())) == null) {
                remoteViews.setViewVisibility(c.g(this.a), 8);
                return;
            }
            remoteViews.setViewVisibility(c.g(this.a), 0);
            remoteViews.setImageViewBitmap(c.g(this.a), a);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.notification.a
    public void a(Notification notification, MessageV3 messageV3, PendingIntent pendingIntent) {
        if (MinSdkChecker.isSupportNotificationBuild()) {
            RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), c.a(this.a));
            remoteViews.setTextViewText(c.d(this.a), messageV3.getTitle());
            remoteViews.setTextViewText(c.e(this.a), messageV3.getContent());
            remoteViews.setLong(c.f(this.a), "setTime", System.currentTimeMillis());
            a(remoteViews, messageV3);
            b(remoteViews, messageV3);
            notification.bigContentView = remoteViews;
        }
    }
}
