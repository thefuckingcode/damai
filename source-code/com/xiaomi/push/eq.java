package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Map;

@SuppressLint({"NewApi"})
/* compiled from: Taobao */
public class eq extends Notification.Builder {
    private Context a;

    public eq(Context context) {
        super(context);
        this.a = context;
    }

    public int a(Resources resources, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            return resources.getIdentifier(str, str2, str3);
        }
        return 0;
    }

    public final int a(String str) {
        return a(a().getResources(), str, "id", a().getPackageName());
    }

    /* access modifiers changed from: protected */
    public Context a() {
        return this.a;
    }

    /* renamed from: a */
    public eq addExtras(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 20) {
            super.addExtras(bundle);
        }
        return this;
    }

    /* renamed from: a */
    public eq setCustomContentView(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public eq m449a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                bk.a((Object) this, "setColor", Integer.valueOf(Color.parseColor(str)));
            } catch (Exception e) {
                b.d("fail to set color. " + e);
            }
        }
        return this;
    }

    public eq a(Map<String, String> map) {
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a  reason: collision with other method in class */
    public void m450a() {
    }

    public Notification build() {
        m450a();
        return super.build();
    }
}
