package com.huawei.hms.push;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
public class l {
    public static int a(Context context) {
        int i = context.getApplicationInfo().icon;
        if (i != 0) {
            return i;
        }
        int identifier = context.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
        HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
        if (identifier != 0) {
            return identifier;
        }
        HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
        return 17301651;
    }

    public static int b(Context context, k kVar) {
        int i = 0;
        if (context == null || kVar == null) {
            HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
            return 0;
        }
        if (!TextUtils.isEmpty(kVar.m())) {
            String[] split = kVar.m().split("/");
            if (split.length == 3) {
                i = r.a(context, split[1], split[2]);
            }
        }
        if (i == 0) {
            i = r.a(context, "com.huawei.messaging.default_notification_icon");
        }
        return i != 0 ? i : a(context);
    }

    public static Bitmap a(Context context, k kVar) {
        if (context == null || kVar == null) {
            return null;
        }
        try {
            if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                return null;
            } else if ("com.huawei.android.pushagent".equals(kVar.k())) {
                return null;
            } else {
                HMSLog.i("PushSelfShowLog", "get left bitmap from " + kVar.k());
                return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(kVar.k())).getBitmap();
            }
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("PushSelfShowLog", "build left icon occur NameNotFoundException.");
            return null;
        } catch (Exception unused2) {
            HMSLog.e("PushSelfShowLog", "build left icon occur Exception.");
            return null;
        }
    }

    @TargetApi(23)
    public static void a(Context context, Notification.Builder builder, k kVar) {
        if (context == null || builder == null || kVar == null) {
            HMSLog.e("PushSelfShowLog", "msg is null");
        } else {
            builder.setSmallIcon(b(context, kVar));
        }
    }
}
