package com.meizu.cloud.pushsdk.notification.a;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;

/* compiled from: Taobao */
public class c extends a {
    public c(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.notification.a
    public void b(Notification.Builder builder, MessageV3 messageV3) {
        AppIconSetting appIconSetting;
        Bitmap bitmap;
        String str;
        if ((!MzSystemUtils.isInternational() || MzSystemUtils.isMeizuAndFlyme()) && (appIconSetting = messageV3.getAppIconSetting()) != null) {
            if (appIconSetting.isDefaultLargeIcon()) {
                PushNotificationBuilder pushNotificationBuilder = this.b;
                if (pushNotificationBuilder == null || pushNotificationBuilder.getLargeIcon() == 0) {
                    PushNotificationBuilder pushNotificationBuilder2 = this.b;
                    if (pushNotificationBuilder2 == null || pushNotificationBuilder2.getAppLargeIcon() == null) {
                        bitmap = a(this.a, messageV3.getUploadDataPackageName());
                        str = "set largeIcon by package default large icon";
                    } else {
                        bitmap = this.b.getAppLargeIcon();
                        str = "set largeIcon by bitmap provided by user setting";
                    }
                } else {
                    bitmap = BitmapFactory.decodeResource(this.a.getResources(), this.b.getLargeIcon());
                    str = "set largeIcon by resource id";
                }
                DebugLogger.i("AbstractPushNotification", str);
            } else if (Thread.currentThread() != this.a.getMainLooper().getThread()) {
                Bitmap a = a(appIconSetting.getLargeIconUrl());
                if (a != null) {
                    DebugLogger.i("AbstractPushNotification", "On other Thread down load largeIcon image success");
                    builder.setLargeIcon(a);
                    return;
                }
                bitmap = a(this.a, messageV3.getUploadDataPackageName());
            } else {
                return;
            }
            builder.setLargeIcon(bitmap);
        }
    }
}
