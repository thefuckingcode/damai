package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.al;
import com.xiaomi.push.service.ax;
import com.xiaomi.push.service.ay;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public abstract class es extends eq {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    protected Bitmap f308a;

    /* renamed from: a  reason: collision with other field name */
    private RemoteViews f309a;

    /* renamed from: a  reason: collision with other field name */
    protected CharSequence f310a;

    /* renamed from: a  reason: collision with other field name */
    private String f311a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<Notification.Action> f312a;

    /* renamed from: a  reason: collision with other field name */
    protected Map<String, String> f313a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f314a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    protected CharSequence f315b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f316b;

    public es(Context context, int i, String str) {
        super(context);
        this.f312a = new ArrayList<>();
        this.b = 0;
        this.f311a = str;
        this.a = i;
        m453c();
    }

    public es(Context context, String str) {
        this(context, 0, str);
    }

    @Override // com.xiaomi.push.eq, com.xiaomi.push.eq
    private Bitmap a() {
        return al.a(h.m536a(a(), this.f311a));
    }

    private String c() {
        boolean e = e();
        this.f316b = e;
        return e ? b() : m457a();
    }

    /* renamed from: c  reason: collision with other method in class */
    private void m453c() {
        int a2 = a(a().getResources(), c(), "layout", a().getPackageName());
        if (a2 != 0) {
            this.f309a = new RemoteViews(a().getPackageName(), a2);
            this.f314a = m459a();
            return;
        }
        b.m182a("create RemoteViews failed, no such layout resource was found");
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m454c() {
        Map<String, String> map = this.f313a;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void d() {
        super.setContentTitle(this.f310a);
        super.setContentText(this.f315b);
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m455d() {
        return !TextUtils.isEmpty(b()) && !TextUtils.isEmpty(this.f311a);
    }

    private boolean e() {
        return m455d() && f();
    }

    private boolean f() {
        List<StatusBarNotification> b2;
        if (Build.VERSION.SDK_INT >= 20 && (b2 = ax.a(a(), this.f311a).m817b()) != null && !b2.isEmpty()) {
            for (StatusBarNotification statusBarNotification : b2) {
                if (statusBarNotification.getId() == this.a) {
                    Notification notification = statusBarNotification.getNotification();
                    if (notification == null) {
                        return false;
                    }
                    return !notification.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int a(float f) {
        return (int) ((f * a().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* access modifiers changed from: protected */
    public Bitmap a(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    @Override // com.xiaomi.push.eq, com.xiaomi.push.eq
    /* renamed from: a  reason: collision with other method in class */
    public final RemoteViews m456a() {
        return this.f309a;
    }

    @Override // com.xiaomi.push.eq
    public eq a(Map<String, String> map) {
        this.f313a = map;
        return this;
    }

    /* renamed from: a */
    public es addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i, charSequence, pendingIntent));
        return this;
    }

    /* renamed from: a */
    public es addAction(Notification.Action action) {
        if (action != null) {
            this.f312a.add(action);
        }
        int i = this.b;
        this.b = i + 1;
        a(i, action);
        return this;
    }

    /* renamed from: a */
    public es setLargeIcon(Bitmap bitmap) {
        this.f308a = bitmap;
        return this;
    }

    /* renamed from: a */
    public es setContentTitle(CharSequence charSequence) {
        this.f310a = charSequence;
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.eq, com.xiaomi.push.eq
    /* renamed from: a  reason: collision with other method in class */
    public abstract String m457a();

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.eq, com.xiaomi.push.eq
    /* renamed from: a  reason: collision with other method in class */
    public void m458a() {
        super.m450a();
        Bundle bundle = new Bundle();
        if (m455d()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f316b);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", a("large_icon"));
        if (this.f312a.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f312a.size()];
            this.f312a.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (m454c() || !ay.m819a(a().getContentResolver())) {
            d();
        } else {
            bundle.putCharSequence("mipush.customTitle", this.f310a);
            bundle.putCharSequence("mipush.customContent", this.f315b);
        }
        addExtras(bundle);
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        Bitmap a2 = a();
        if (a2 != null) {
            m456a().setImageViewBitmap(i, a2);
            return;
        }
        int b2 = h.b(a(), this.f311a);
        if (b2 != 0) {
            m456a().setImageViewResource(i, b2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i, Notification.Action action) {
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.push.eq, com.xiaomi.push.eq
    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m459a();

    /* access modifiers changed from: protected */
    /* renamed from: a  reason: collision with other method in class */
    public final boolean m460a(int i) {
        return ((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d) < 192.0d;
    }

    /* renamed from: b */
    public es setContentText(CharSequence charSequence) {
        this.f315b = charSequence;
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract String b();

    /* access modifiers changed from: protected */
    /* renamed from: b  reason: collision with other method in class */
    public final void m461b() {
        super.setContentTitle(this.f310a);
        super.setContentText(this.f315b);
        Bitmap bitmap = this.f308a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b  reason: collision with other method in class */
    public final boolean m462b() {
        return this.f314a;
    }
}
