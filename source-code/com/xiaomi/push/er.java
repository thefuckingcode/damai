package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.al;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import java.util.Map;

/* compiled from: Taobao */
public class er extends es {
    private int a = 16777216;

    /* renamed from: a  reason: collision with other field name */
    private PendingIntent f305a;
    private int b = 16777216;

    /* renamed from: b  reason: collision with other field name */
    private Bitmap f306b;
    private int c = 16777216;

    /* renamed from: c  reason: collision with other field name */
    private CharSequence f307c;

    public er(Context context, int i, String str) {
        super(context, i, str);
    }

    private Drawable a(int i, int i2, int i3, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }

    private void a(RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        int a2 = a(6.0f);
        remoteViews.setViewPadding(i, a2, 0, a2, 0);
        int i4 = z ? -1 : -16777216;
        remoteViews.setTextColor(i2, i4);
        remoteViews.setTextColor(i3, i4);
    }

    @Override // com.xiaomi.push.es
    public er a(Bitmap bitmap) {
        if (m462b() && bitmap != null) {
            if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                b.m182a("colorful notification bg image resolution error, must [984*177, 984*207]");
            } else {
                this.f306b = bitmap;
            }
        }
        return this;
    }

    public er a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (m462b()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f307c = charSequence;
            this.f305a = pendingIntent;
        }
        return this;
    }

    @Override // com.xiaomi.push.eq, com.xiaomi.push.eq
    public er a(String str) {
        if (m462b() && !TextUtils.isEmpty(str)) {
            try {
                this.b = Color.parseColor(str);
            } catch (Exception unused) {
                b.m182a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.eq, com.xiaomi.push.eq, com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es
    public String a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.eq, com.xiaomi.push.eq, com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es
    /* renamed from: a  reason: collision with other method in class */
    public void m451a() {
        Bitmap bitmap;
        RemoteViews remoteViews;
        boolean z;
        RemoteViews a2;
        Drawable drawable;
        RemoteViews remoteViews2;
        if (m462b()) {
            super.m458a();
            Resources resources = a().getResources();
            String packageName = a().getPackageName();
            int a3 = a(resources, RemoteMessageConst.Notification.ICON, "id", packageName);
            if (((es) this).f308a == null) {
                a(a3);
            } else {
                m456a().setImageViewBitmap(a3, ((es) this).f308a);
            }
            int a4 = a(resources, "title", "id", packageName);
            int a5 = a(resources, "content", "id", packageName);
            m456a().setTextViewText(a4, ((es) this).f310a);
            m456a().setTextViewText(a5, ((es) this).f315b);
            if (!TextUtils.isEmpty(this.f307c)) {
                int a6 = a(resources, "buttonContainer", "id", packageName);
                int a7 = a(resources, BaseCellItem.TYPE_BUTTON, "id", packageName);
                int a8 = a(resources, "buttonBg", "id", packageName);
                m456a().setViewVisibility(a6, 0);
                m456a().setTextViewText(a7, this.f307c);
                m456a().setOnClickPendingIntent(a6, this.f305a);
                if (this.b != 16777216) {
                    int a9 = a(70.0f);
                    int a10 = a(29.0f);
                    m456a().setImageViewBitmap(a8, al.a(a(this.b, a9, a10, ((float) a10) / 2.0f)));
                    m456a().setTextColor(a7, m460a(this.b) ? -1 : -16777216);
                }
            }
            int a11 = a(resources, "bg", "id", packageName);
            int a12 = a(resources, "container", "id", packageName);
            if (this.a != 16777216) {
                if (m.a(a()) >= 10) {
                    remoteViews2 = m456a();
                    drawable = a(this.a, 984, 192, 30.0f);
                } else {
                    remoteViews2 = m456a();
                    drawable = a(this.a, 984, 192, 0.0f);
                }
                remoteViews2.setImageViewBitmap(a11, al.a(drawable));
                a2 = m456a();
                z = m460a(this.a);
            } else if (this.f306b != null) {
                if (m.a(a()) >= 10) {
                    remoteViews = m456a();
                    bitmap = a(this.f306b, 30.0f);
                } else {
                    remoteViews = m456a();
                    bitmap = this.f306b;
                }
                remoteViews.setImageViewBitmap(a11, bitmap);
                Map<String, String> map = ((es) this).f313a;
                if (map != null && this.c == 16777216) {
                    c(map.get("notification_image_text_color"));
                }
                int i = this.c;
                z = i == 16777216 || !m460a(i);
                a2 = m456a();
            } else {
                if (Build.VERSION.SDK_INT >= 24) {
                    m456a().setViewVisibility(a3, 8);
                    m456a().setViewVisibility(a11, 8);
                    try {
                        bk.a((Object) this, "setStyle", v.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception unused) {
                        b.m182a("load class DecoratedCustomViewStyle failed");
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("miui.customHeight", true);
                addExtras(bundle);
                setCustomContentView(m456a());
                return;
            }
            a(a2, a12, a4, a5, z);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("miui.customHeight", true);
            addExtras(bundle2);
            setCustomContentView(m456a());
            return;
        }
        m461b();
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.eq, com.xiaomi.push.eq, com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es
    /* renamed from: a  reason: collision with other method in class */
    public boolean m452a() {
        if (!m.m734a()) {
            return false;
        }
        Resources resources = a().getResources();
        String packageName = a().getPackageName();
        return (a(resources, RemoteMessageConst.Notification.ICON, "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
    }

    public er b(String str) {
        if (m462b() && !TextUtils.isEmpty(str)) {
            try {
                this.a = Color.parseColor(str);
            } catch (Exception unused) {
                b.m182a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.es, com.xiaomi.push.es, com.xiaomi.push.es
    public String b() {
        return "notification_colorful_copy";
    }

    public er c(String str) {
        if (m462b() && !TextUtils.isEmpty(str)) {
            try {
                this.c = Color.parseColor(str);
            } catch (Exception unused) {
                b.m182a("parse colorful notification image text color error");
            }
        }
        return this;
    }
}
