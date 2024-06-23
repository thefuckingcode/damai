package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Map;

/* compiled from: Taobao */
public class ep extends es {
    private int a = 16777216;
    private Bitmap b;
    private Bitmap c;

    public ep(Context context, String str) {
        super(context, str);
    }

    @Override // com.xiaomi.push.es
    public ep a(Bitmap bitmap) {
        if (m462b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || 184 > bitmap.getHeight() || bitmap.getHeight() > 1678) {
                b.m182a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            } else {
                this.b = bitmap;
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.eq, com.xiaomi.push.eq
    public ep a(String str) {
        if (m462b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                b.m182a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.es
    /* renamed from: a  reason: collision with other method in class */
    public es setLargeIcon(Bitmap bitmap) {
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.eq, com.xiaomi.push.eq, com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es
    public String a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.eq, com.xiaomi.push.eq, com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es
    /* renamed from: a  reason: collision with other method in class */
    public void m447a() {
        Bitmap bitmap;
        RemoteViews remoteViews;
        if (!m462b() || this.b == null) {
            m461b();
            return;
        }
        super.m458a();
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        int a2 = a(resources, "bg", "id", packageName);
        if (m.a(a()) >= 10) {
            remoteViews = m456a();
            bitmap = a(this.b, 30.0f);
        } else {
            remoteViews = m456a();
            bitmap = this.b;
        }
        remoteViews.setImageViewBitmap(a2, bitmap);
        int a3 = a(resources, RemoteMessageConst.Notification.ICON, "id", packageName);
        if (this.c != null) {
            m456a().setImageViewBitmap(a3, this.c);
        } else {
            a(a3);
        }
        int a4 = a(resources, "title", "id", packageName);
        m456a().setTextViewText(a4, ((es) this).f310a);
        Map<String, String> map = ((es) this).f313a;
        if (map != null && this.a == 16777216) {
            a(map.get("notification_image_text_color"));
        }
        RemoteViews a5 = m456a();
        int i = this.a;
        a5.setTextColor(a4, (i == 16777216 || !m460a(i)) ? -1 : -16777216);
        setCustomContentView(m456a());
        Bundle bundle = new Bundle();
        bundle.putBoolean("miui.customHeight", true);
        addExtras(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.eq, com.xiaomi.push.eq, com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es
    /* renamed from: a  reason: collision with other method in class */
    public boolean m448a() {
        if (!m.m734a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        return (a(a().getResources(), "bg", "id", a().getPackageName()) == 0 || a(resources, RemoteMessageConst.Notification.ICON, "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || m.a(a()) < 9) ? false : true;
    }

    public ep b(Bitmap bitmap) {
        if (m462b() && bitmap != null) {
            this.c = bitmap;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es
    public String b() {
        return null;
    }
}
