package com.heytap.mcssdk.b;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.pushsdk.R$string;
import tb.l53;
import tb.r43;

/* compiled from: Taobao */
public class a {
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @TargetApi(26)
    private boolean b(Context context, String str, String str2, int i) {
        NotificationManager notificationManager;
        if (context == null || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
            return false;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, i));
        return true;
    }

    public void a(final Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            l53.a(new Runnable() {
                /* class com.heytap.mcssdk.b.a.AnonymousClass1 */

                public void run() {
                    if (!r43.f().c()) {
                        String string = context.getString(R$string.system_default_channel);
                        if (TextUtils.isEmpty(string)) {
                            string = "System Default Channel";
                        }
                        r43.f().b(a.this.b(context, "Heytap PUSH", string, 3));
                    }
                }
            });
        }
    }
}
