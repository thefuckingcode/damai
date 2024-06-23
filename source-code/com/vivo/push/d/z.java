package com.vivo.push.d;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.e;
import com.vivo.push.l;
import com.vivo.push.o;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.NotifyAdapterUtil;
import com.vivo.push.util.p;
import com.vivo.push.util.u;
import java.security.PublicKey;

/* compiled from: Taobao */
public abstract class z extends l {
    protected PushMessageCallback b;

    z(o oVar) {
        super(oVar);
    }

    public final void a(PushMessageCallback pushMessageCallback) {
        this.b = pushMessageCallback;
    }

    public final int b() {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            return 0;
        }
        NotificationManager notificationManager = (NotificationManager) this.a.getSystemService("notification");
        if (notificationManager != null && !notificationManager.areNotificationsEnabled()) {
            return 2104;
        }
        if (i < 26 || notificationManager == null) {
            return 0;
        }
        try {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(NotifyAdapterUtil.PRIMARY_CHANNEL);
            if (notificationChannel == null || notificationChannel.getImportance() != 0) {
                return 0;
            }
            return 2121;
        } catch (Exception unused) {
            p.b("OnVerifyCallBackCommand", "判断通知通道出现系统错误");
            return 0;
        }
    }

    public final boolean a(PublicKey publicKey, String str, String str2) {
        if (!e.a().d()) {
            p.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
            return true;
        } else if (publicKey == null) {
            p.d("OnVerifyCallBackCommand", "vertify key is null");
            return false;
        } else if (TextUtils.isEmpty(str)) {
            p.d("OnVerifyCallBackCommand", "contentTag is null");
            return false;
        } else if (!TextUtils.isEmpty(str2)) {
            try {
                p.d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
                if (u.a(str.getBytes("UTF-8"), publicKey, Base64.decode(str2, 2))) {
                    p.d("OnVerifyCallBackCommand", "vertify id is success");
                    return true;
                }
                p.d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(str));
                p.c(this.a, "vertify fail srcDigest is ".concat(str));
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                p.d("OnVerifyCallBackCommand", "vertify exception");
                return false;
            }
        } else {
            p.d("OnVerifyCallBackCommand", "vertify id is null");
            return false;
        }
    }
}
