package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.weex.annotation.JSMethod;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bk;
import com.xiaomi.push.eo;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import com.xiaomi.push.er;
import com.xiaomi.push.h;
import com.xiaomi.push.hj;
import com.xiaomi.push.hw;
import com.xiaomi.push.m;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.w;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class al {
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile as f881a;

    /* renamed from: a  reason: collision with other field name */
    private static final LinkedList<Pair<Integer, Cif>> f882a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f883a = Executors.newCachedThreadPool();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a implements Callable<Bitmap> {
        private Context a;

        /* renamed from: a  reason: collision with other field name */
        private String f884a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f885a;

        public a(String str, Context context, boolean z) {
            this.a = context;
            this.f884a = str;
            this.f885a = z;
        }

        /* renamed from: a */
        public Bitmap call() {
            Bitmap bitmap = null;
            if (!TextUtils.isEmpty(this.f884a)) {
                if (this.f884a.startsWith("http")) {
                    aw.b a2 = aw.a(this.a, this.f884a, this.f885a);
                    if (a2 != null) {
                        return a2.f903a;
                    }
                } else {
                    bitmap = aw.a(this.a, this.f884a);
                    if (bitmap != null) {
                        return bitmap;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.m182a("Failed get online picture/icon resource");
                return bitmap;
            }
            com.xiaomi.channel.commonutils.logger.b.m182a("Failed get online picture/icon resource cause picUrl is empty");
            return null;
        }
    }

    /* compiled from: Taobao */
    public static class b {
        long a = 0;

        /* renamed from: a  reason: collision with other field name */
        Notification f886a;
    }

    /* compiled from: Taobao */
    public static class c {
        public long a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f887a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f888a = false;
    }

    static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    private static int a(Context context, String str, Map<String, String> map, int i) {
        ComponentName a2;
        Intent b2 = b(context, str, map, i);
        if (b2 == null || (a2 = l.a(context, b2)) == null) {
            return 0;
        }
        return a2.hashCode();
    }

    private static int a(Map<String, String> map) {
        String str = map == null ? null : map.get("timeout");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static Notification a(Notification notification) {
        Object a2 = bk.a(notification, "extraNotification");
        if (a2 != null) {
            bk.a(a2, "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    private static PendingIntent a(Context context, Cif ifVar, String str, byte[] bArr, int i) {
        return a(context, ifVar, str, bArr, i, 0, a(context, ifVar, str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
    private static PendingIntent a(Context context, Cif ifVar, String str, byte[] bArr, int i, int i2, boolean z) {
        Intent intent;
        int i3 = c(ifVar) ? 1000 : m796a(ifVar) ? 3000 : -1;
        hw a2 = ifVar.m617a();
        String a3 = a2 != null ? a2.m583a() : "";
        boolean a4 = m796a(ifVar);
        if (a2 == null || TextUtils.isEmpty(a2.f541e)) {
            if (a4) {
                intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            } else {
                intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent.setComponent(new ComponentName(str, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            }
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i));
            intent.addCategory(String.valueOf(a3));
            intent.putExtra("notification_click_button", i2);
            intent.putExtra("messageId", a3);
            intent.putExtra("eventMessageType", i3);
            if (a4 || !z) {
                a(context, intent, ifVar, a2, a3, i2);
                return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getService(context, 0, intent, 167772160) : PendingIntent.getService(context, 0, intent, 134217728);
            }
            Intent intent2 = new Intent();
            intent2.setComponent(a(str));
            intent2.addFlags(276824064);
            intent2.putExtra("mipush_serviceIntent", intent);
            intent2.addCategory(String.valueOf(i));
            intent2.addCategory(String.valueOf(a3));
            intent2.addCategory(String.valueOf(i2));
            a(context, intent2, ifVar, a2, a3, i2);
            a(intent2);
            return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getActivity(context, 0, intent2, 167772160) : PendingIntent.getActivity(context, 0, intent2, 134217728);
        }
        Intent intent3 = new Intent("android.intent.action.VIEW");
        intent3.setData(Uri.parse(a2.f541e));
        try {
            String protocol = new URL(a2.f541e).getProtocol();
            if (!"http".equals(protocol)) {
                if (!"https".equals(protocol)) {
                    intent3.setPackage(str);
                    intent3.addFlags(268435456);
                    intent3.putExtra("messageId", a3);
                    intent3.putExtra("eventMessageType", i3);
                    return Build.VERSION.SDK_INT < 31 ? PendingIntent.getActivity(context, 0, intent3, 167772160) : PendingIntent.getActivity(context, 0, intent3, 134217728);
                }
            }
            ay.a(context, str, intent3);
        } catch (MalformedURLException unused) {
            com.xiaomi.channel.commonutils.logger.b.m182a("meet URL exception : " + a2.f541e);
            intent3.setPackage(str);
        }
        intent3.addFlags(268435456);
        intent3.putExtra("messageId", a3);
        intent3.putExtra("eventMessageType", i3);
        if (Build.VERSION.SDK_INT < 31) {
        }
    }

    private static PendingIntent a(Context context, String str, Cif ifVar, byte[] bArr, int i, int i2) {
        Map<String, String> a2 = ifVar.m617a().m584a();
        if (a2 == null) {
            return null;
        }
        boolean a3 = a(context, ifVar, str);
        if (a3) {
            return a(context, ifVar, str, bArr, i, i2, a3);
        }
        Intent a4 = m791a(context, str, a2, i2);
        if (a4 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, 0, a4, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Intent m791a(Context context, String str, Map<String, String> map, int i) {
        if (m801b(map)) {
            return a(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i)), String.format("cust_btn_%s_iu", Integer.valueOf(i)), String.format("cust_btn_%s_ic", Integer.valueOf(i)), String.format("cust_btn_%s_wu", Integer.valueOf(i)));
        } else if (i == 1) {
            return a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
        } else {
            if (i == 2) {
                return a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
            }
            if (i == 3) {
                return a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
            }
            if (i != 4) {
                return null;
            }
            return a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0114  */
    private static Intent a(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5) {
        Intent intent;
        Intent intent2;
        MalformedURLException e;
        Intent intent3;
        URISyntaxException e2;
        String str6 = map.get(str2);
        if (TextUtils.isEmpty(str6)) {
            return null;
        }
        if (bk.a.equals(str6)) {
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e3) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e3.getMessage());
            }
        } else {
            if (bk.b.equals(str6)) {
                if (map.containsKey(str3)) {
                    String str7 = map.get(str3);
                    if (str7 != null) {
                        try {
                            intent3 = Intent.parseUri(str7, 1);
                            try {
                                intent3.setPackage(str);
                            } catch (URISyntaxException e4) {
                                e2 = e4;
                            }
                        } catch (URISyntaxException e5) {
                            e2 = e5;
                            intent3 = null;
                            com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e2.getMessage());
                            intent = intent3;
                            if (intent != null) {
                            }
                            return null;
                        }
                        intent = intent3;
                    }
                } else if (map.containsKey(str4)) {
                    intent2 = new Intent();
                    intent2.setComponent(new ComponentName(str, map.get(str4)));
                }
                intent = null;
            } else {
                if (bk.c.equals(str6)) {
                    String str8 = map.get(str5);
                    if (!TextUtils.isEmpty(str8)) {
                        String trim = str8.trim();
                        if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                            trim = "http://" + trim;
                        }
                        try {
                            String protocol = new URL(trim).getProtocol();
                            if ("http".equals(protocol) || "https".equals(protocol)) {
                                intent2 = new Intent("android.intent.action.VIEW");
                                try {
                                    intent2.setData(Uri.parse(trim));
                                    ay.a(context, str, intent2);
                                } catch (MalformedURLException e6) {
                                    e = e6;
                                }
                            }
                        } catch (MalformedURLException e7) {
                            e = e7;
                            intent2 = null;
                            com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                            intent = intent2;
                            if (intent != null) {
                            }
                            return null;
                        }
                    }
                }
                intent = null;
            }
            intent = intent2;
        }
        if (intent != null) {
            intent.addFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                    return intent;
                }
                if (Build.VERSION.SDK_INT >= 30 && !m.m735a(context) && bk.c.equals(str6)) {
                    return intent;
                }
                com.xiaomi.channel.commonutils.logger.b.m182a("not resolve activity:" + intent + "for buttons");
            } catch (Exception e8) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e8.getMessage());
            }
        }
        return null;
    }

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    /* JADX INFO: finally extract failed */
    private static Bitmap a(Context context, String str, boolean z) {
        Future submit = f883a.submit(new a(str, context, z));
        try {
            Bitmap bitmap = (Bitmap) submit.get(180, TimeUnit.SECONDS);
            if (bitmap != null) {
                return bitmap;
            }
            submit.cancel(true);
            return bitmap;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            submit.cancel(true);
            return null;
        } catch (Throwable th) {
            submit.cancel(true);
            throw th;
        }
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i = 1;
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static RemoteViews a(Context context, Cif ifVar, byte[] bArr) {
        hw a2 = ifVar.m617a();
        String a3 = a(ifVar);
        if (!(a2 == null || a2.m584a() == null)) {
            Map<String, String> a4 = a2.m584a();
            String str = a4.get("layout_name");
            String str2 = a4.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a3);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", a3);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(a3, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", a3);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has("image")) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                            Iterator<String> keys2 = jSONObject3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a3);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a3);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has("time")) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                            Iterator<String> keys3 = jSONObject4.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a3);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
        }
        return null;
    }

    @TargetApi(16)
    private static eq a(Context context, Cif ifVar, byte[] bArr, String str, int i) {
        PendingIntent a2;
        String a3 = a(ifVar);
        Map<String, String> a4 = ifVar.m617a().m584a();
        String str2 = a4.get("notification_style_type");
        eq a5 = (!m.m735a(context) || f881a == null) ? null : f881a.a(context, i, a3, a4);
        if (a5 != null) {
            a5.a(a4);
            return a5;
        } else if ("2".equals(str2)) {
            eq eqVar = new eq(context);
            Bitmap a6 = TextUtils.isEmpty(a4.get("notification_bigPic_uri")) ? null : a(context, a4.get("notification_bigPic_uri"), false);
            if (a6 == null) {
                com.xiaomi.channel.commonutils.logger.b.m182a("can not get big picture.");
                return eqVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(eqVar);
            bigPictureStyle.bigPicture(a6);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            eqVar.setStyle(bigPictureStyle);
            return eqVar;
        } else if ("1".equals(str2)) {
            eq eqVar2 = new eq(context);
            eqVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return eqVar2;
        } else if ("4".equals(str2) && m.m734a()) {
            ep epVar = new ep(context, a3);
            if (!TextUtils.isEmpty(a4.get("notification_banner_image_uri"))) {
                epVar.a(a(context, a4.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(a4.get("notification_banner_icon_uri"))) {
                epVar.b(a(context, a4.get("notification_banner_icon_uri"), false));
            }
            epVar.a(a4);
            return epVar;
        } else if (!"3".equals(str2) || !m.m734a()) {
            return new eq(context);
        } else {
            er erVar = new er(context, i, a3);
            if (!TextUtils.isEmpty(a4.get("notification_colorful_button_text")) && (a2 = a(context, a3, ifVar, bArr, i, 4)) != null) {
                erVar.a(a4.get("notification_colorful_button_text"), a2).a(a4.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(a4.get("notification_colorful_bg_color"))) {
                erVar.b(a4.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(a4.get("notification_colorful_bg_image_uri"))) {
                erVar.a(a(context, a4.get("notification_colorful_bg_image_uri"), false));
            }
            erVar.a(a4);
            return erVar;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v40, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02e3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0435  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x027a  */
    @SuppressLint({"NewApi"})
    private static b a(Context context, Cif ifVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent, int i) {
        eq eqVar;
        boolean z;
        Bitmap a2;
        boolean z2;
        boolean z3;
        String str;
        long currentTimeMillis;
        String str2;
        boolean z4;
        b bVar;
        int i2;
        String str3;
        Notification notification;
        Bitmap bitmap;
        Bitmap bitmap2;
        int i3;
        String str4;
        StringBuilder sb;
        boolean z5;
        int a3;
        b bVar2 = new b();
        hw a4 = ifVar.m617a();
        String a5 = a(ifVar);
        Map<String, String> a6 = a4.m584a();
        String[] a7 = a(context, a4);
        if (remoteViews != null) {
            eqVar = new eq(context);
            eqVar.setCustomContentView(remoteViews);
        } else {
            eqVar = (a6 == null || !a6.containsKey("notification_style_type")) ? new eq(context) : a(context, ifVar, bArr, a7[1], i);
        }
        a(eqVar, context, ifVar.b(), ifVar, bArr, i);
        eqVar.setContentTitle(a7[0]);
        eqVar.setContentText(a7[1]);
        long currentTimeMillis2 = System.currentTimeMillis();
        eqVar.setWhen(currentTimeMillis2);
        String a8 = a(a6, "notification_show_when");
        if (!TextUtils.isEmpty(a8)) {
            eqVar.setShowWhen(Boolean.parseBoolean(a8));
        } else if (Build.VERSION.SDK_INT >= 24) {
            eqVar.setShowWhen(true);
        }
        eqVar.setContentIntent(pendingIntent);
        int a9 = a(context, a5, "mipush_notification");
        int a10 = a(context, a5, "mipush_small_notification");
        if (a9 <= 0 || a10 <= 0) {
            if (!m.m735a(context)) {
                String a11 = a(a6, "fcm_icon_uri");
                String a12 = a(a6, "fcm_icon_color");
                if (!TextUtils.isEmpty(a11) && !TextUtils.isEmpty(a12) && (a3 = a(context, a5, a11)) > 0) {
                    eqVar.setSmallIcon(a3);
                    eqVar.m449a(a12);
                    z5 = true;
                    if (!z5) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            eqVar.setSmallIcon(Icon.createWithResource(a5, ay.a(context, a5)));
                        } else {
                            eqVar.setSmallIcon(b(context, a5));
                        }
                    }
                }
            }
            z5 = false;
            if (!z5) {
            }
        } else {
            eqVar.setLargeIcon(a(context, a9));
            eqVar.setSmallIcon(a10);
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            if (a6 == null) {
                i3 = 1;
                bitmap2 = null;
            } else {
                i3 = 1;
                bitmap2 = a(context, a6.get("notification_small_icon_uri"), true);
            }
            if (bitmap2 != null) {
                Object[] objArr = new Object[i3];
                objArr[0] = bitmap2;
                Object a13 = bk.a("android.graphics.drawable.Icon", "createWithBitmap", objArr);
                if (a13 != null) {
                    Object[] objArr2 = new Object[i3];
                    objArr2[0] = a13;
                    bk.a((Object) eqVar, "setSmallIcon", objArr2);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("miui.isGrayscaleIcon", i3);
                    eqVar.addExtras(bundle);
                    eqVar.m449a(a(a6, "notification_small_icon_color"));
                } else {
                    sb = new StringBuilder();
                    sb.append("failed te get small icon with url:");
                    str4 = a6.get("notification_small_icon_uri");
                }
            } else {
                sb = new StringBuilder();
                sb.append("failed to get small icon url:");
                str4 = a(a6, "notification_small_icon_uri");
            }
            sb.append(str4);
            com.xiaomi.channel.commonutils.logger.b.m182a(sb.toString());
            eqVar.m449a(a(a6, "notification_small_icon_color"));
        }
        String a14 = a(a6, "__dynamic_icon_uri");
        boolean z6 = Boolean.parseBoolean(a(a6, "__adiom")) || !m.m734a();
        if (!TextUtils.isEmpty(a14) && z6) {
            if (a14.startsWith("http")) {
                aw.b a15 = aw.a(context, a14, true);
                if (a15 != null) {
                    bitmap = a15.f903a;
                    bVar2.a = a15.a;
                } else {
                    bitmap = null;
                }
            } else {
                bitmap = aw.a(context, a14);
            }
            if (bitmap != null) {
                eqVar.setLargeIcon(bitmap);
                z = true;
                a2 = a6 != null ? null : a(context, a6.get("notification_large_icon_uri"), true);
                if (a2 != null) {
                    eqVar.setLargeIcon(a2);
                }
                if (a6 != null || i4 < 24) {
                    str = null;
                    z3 = false;
                } else {
                    String str5 = a6.get("notification_group");
                    z3 = Boolean.parseBoolean(a6.get("notification_is_summary"));
                    boolean parseBoolean = Boolean.parseBoolean(a6.get("notification_group_disable_default"));
                    if (TextUtils.isEmpty(str5) && (m.m734a() || !parseBoolean)) {
                        str5 = a(ifVar);
                    }
                    bk.a((Object) eqVar, "setGroupSummary", Boolean.valueOf(z3));
                    String str6 = a6.get("notification_style_type");
                    if (!"com.xiaomi.xmsf".equals(context.getPackageName()) || (!"4".equals(str6) && !"3".equals(str6))) {
                        str = str5;
                    } else {
                        str = a(ifVar) + "_custom_" + currentTimeMillis2;
                        z2 = true;
                        eqVar.setAutoCancel(true);
                        currentTimeMillis = System.currentTimeMillis();
                        if (a6 != null && a6.containsKey(RemoteMessageConst.Notification.TICKER)) {
                            eqVar.setTicker(a6.get(RemoteMessageConst.Notification.TICKER));
                        }
                        if (currentTimeMillis - a > 10000) {
                            a = currentTimeMillis;
                            i2 = a4.f528a;
                            if (m799b(context, a5)) {
                                i2 = a(context, a5);
                            }
                            eqVar.setDefaults(i2);
                            if (a6 == null || (i2 & 1) == 0) {
                                str2 = "com.xiaomi.xmsf";
                                z4 = z;
                                bVar = bVar2;
                            } else {
                                bVar = bVar2;
                                String str7 = a6.get("sound_uri");
                                if (!TextUtils.isEmpty(str7)) {
                                    z4 = z;
                                    StringBuilder sb2 = new StringBuilder();
                                    str2 = "com.xiaomi.xmsf";
                                    sb2.append("android.resource://");
                                    sb2.append(a5);
                                    if (str7.startsWith(sb2.toString())) {
                                        eqVar.setDefaults(i2 ^ 1);
                                        eqVar.setSound(Uri.parse(str7));
                                    }
                                } else {
                                    str2 = "com.xiaomi.xmsf";
                                    z4 = z;
                                }
                            }
                        } else {
                            str2 = "com.xiaomi.xmsf";
                            z4 = z;
                            bVar = bVar2;
                            i2 = -100;
                        }
                        if (a6 != null || i4 < 26) {
                            str3 = "0";
                            if (a6 != null && i4 < 26) {
                                bk.a((Object) eqVar, "setPriority", Integer.valueOf(c(a6)));
                            }
                        } else {
                            ax a16 = ax.a(context, a5);
                            int a17 = a(a6);
                            if (a17 > 0) {
                                str3 = "0";
                                bk.a((Object) eqVar, "setTimeoutAfter", Long.valueOf((long) (a17 * 1000)));
                            } else {
                                str3 = "0";
                            }
                            at.a(a4);
                            String str8 = a6.get("channel_id");
                            if (!TextUtils.isEmpty(str8) || context.getApplicationInfo().targetSdkVersion >= 26) {
                                String a18 = a(context, a5, a6);
                                int b2 = b(a6);
                                int i5 = a4.f528a;
                                cc.a(context, a6, eqVar, currentTimeMillis2);
                                bk.a((Object) eqVar, "setChannelId", at.a(a16, str8, a18, a6.get("channel_description"), i5, b2, a6.get("sound_uri"), a6.get("channel_perm")));
                                if (i2 == -100 && ay.a(a6)) {
                                    ay.a(eqVar, z3);
                                }
                                if ("pulldown".equals(ay.a((Object) a6)) && ay.a(a6) && Objects.equals(a6.get("pull_down_pop_type"), str3)) {
                                    ay.a(eqVar, z3);
                                }
                                if ("tts".equals(ay.a((Object) a6)) && ay.a(a6)) {
                                    ay.a(eqVar, z3);
                                }
                            }
                            String str9 = a6.get("background_color");
                            if (!TextUtils.isEmpty(str9)) {
                                try {
                                    int parseInt = Integer.parseInt(str9);
                                    eqVar.setOngoing(true);
                                    eqVar.setColor(parseInt);
                                    bk.a((Object) eqVar, "setColorized", Boolean.TRUE);
                                } catch (Exception e) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e);
                                }
                            }
                        }
                        if (str != null) {
                            if (!z2) {
                                str = au.a().a(context, eqVar, str);
                            }
                            bk.a((Object) eqVar, "setGroup", str);
                        }
                        if (m.m739c() && str2.equals(context.getPackageName())) {
                            bk.a("miui.util.NotificationHelper", "setTargetPkg", context, eqVar, a(ifVar));
                        }
                        notification = eqVar.getNotification();
                        if (z4 && m.m734a()) {
                            a(notification);
                        }
                        if (a6 != null) {
                            if (notification.extras == null) {
                                notification.extras = new Bundle();
                            }
                            if (!TextUtils.isEmpty(a6.get("enable_keyguard"))) {
                                ay.b(notification, Boolean.parseBoolean(a6.get("enable_keyguard")));
                            }
                            if (!TextUtils.isEmpty(a6.get("enable_float"))) {
                                ay.a(notification, Boolean.parseBoolean(a6.get("enable_float")));
                            }
                            if (!TextUtils.isEmpty(a6.get("float_small_win")) && str3.equals(a6.get("float_small_win")) && h.d(context, a5)) {
                                ay.a(notification, false);
                            }
                            int a19 = w.a(a6.get("section_is_prr"), -1);
                            int a20 = w.a(a6.get("section_prr_cl"), -1);
                            if (a19 >= 0 && a20 >= 0) {
                                ay.a(notification, a19, a20);
                            }
                        }
                        bVar.f886a = notification;
                        return bVar;
                    }
                }
                z2 = false;
                eqVar.setAutoCancel(true);
                currentTimeMillis = System.currentTimeMillis();
                eqVar.setTicker(a6.get(RemoteMessageConst.Notification.TICKER));
                if (currentTimeMillis - a > 10000) {
                }
                if (a6 != null) {
                }
                str3 = "0";
                bk.a((Object) eqVar, "setPriority", Integer.valueOf(c(a6)));
                if (str != null) {
                }
                bk.a("miui.util.NotificationHelper", "setTargetPkg", context, eqVar, a(ifVar));
                notification = eqVar.getNotification();
                a(notification);
                if (a6 != null) {
                }
                bVar.f886a = notification;
                return bVar;
            }
        }
        z = false;
        if (a6 != null) {
        }
        if (a2 != null) {
        }
        if (a6 != null) {
        }
        str = null;
        z3 = false;
        z2 = false;
        eqVar.setAutoCancel(true);
        currentTimeMillis = System.currentTimeMillis();
        eqVar.setTicker(a6.get(RemoteMessageConst.Notification.TICKER));
        if (currentTimeMillis - a > 10000) {
        }
        if (a6 != null) {
        }
        str3 = "0";
        bk.a((Object) eqVar, "setPriority", Integer.valueOf(c(a6)));
        if (str != null) {
        }
        bk.a("miui.util.NotificationHelper", "setTargetPkg", context, eqVar, a(ifVar));
        notification = eqVar.getNotification();
        a(notification);
        if (a6 != null) {
        }
        bVar.f886a = notification;
        return bVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static c m792a(Context context, Cif ifVar, byte[] bArr) {
        Map<String, String> map;
        int i;
        String str;
        c cVar = new c();
        h.a a2 = h.a(context, a(ifVar), true);
        hw a3 = ifVar.m617a();
        String str2 = null;
        if (a3 != null) {
            i = a3.c();
            map = a3.m584a();
        } else {
            i = 0;
            map = null;
        }
        int b2 = w.b(a(ifVar), i);
        if (m.m735a(context) && a2 == h.a.NOT_ALLOWED) {
            if (a3 != null) {
                eo.a(context.getApplicationContext()).a(ifVar.b(), b(ifVar), a3.m583a(), "10:" + a(ifVar));
            }
            str = "Do not notify because user block " + a(ifVar) + "‘s notification";
        } else if (!m.m735a(context) || f881a == null || !f881a.m802a(context, b2, a(ifVar), map)) {
            RemoteViews a4 = a(context, ifVar, bArr);
            PendingIntent a5 = a(context, ifVar, ifVar.b(), bArr, b2);
            if (a5 == null) {
                if (a3 != null) {
                    eo.a(context.getApplicationContext()).a(ifVar.b(), b(ifVar), a3.m583a(), "11");
                }
                str = "The click PendingIntent is null. ";
            } else {
                b a6 = a(context, ifVar, bArr, a4, a5, b2);
                cVar.a = a6.a;
                cVar.f887a = a(ifVar);
                Notification notification = a6.f886a;
                if (m.m734a()) {
                    if (!TextUtils.isEmpty(a3.m583a())) {
                        notification.extras.putString("message_id", a3.m583a());
                    }
                    notification.extras.putString("local_paid", ifVar.m618a());
                    ay.a(map, notification.extras, "msg_busi_type");
                    ay.a(map, notification.extras, "disable_notification_flags");
                    String str3 = a3.m589b() == null ? null : a3.m589b().get("score_info");
                    if (!TextUtils.isEmpty(str3)) {
                        notification.extras.putString("score_info", str3);
                    }
                    notification.extras.putString("pushUid", a(a3.f532a, "n_stats_expose"));
                    int i2 = -1;
                    if (c(ifVar)) {
                        i2 = 1000;
                    } else if (m796a(ifVar)) {
                        i2 = 3000;
                    }
                    notification.extras.putString("eventMessageType", String.valueOf(i2));
                    notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, a(ifVar));
                }
                if (a3.m584a() != null) {
                    str2 = a3.m584a().get("message_count");
                }
                if (m.m734a() && str2 != null) {
                    try {
                        ay.a(notification, Integer.parseInt(str2));
                    } catch (NumberFormatException e) {
                        eo.a(context.getApplicationContext()).b(ifVar.b(), b(ifVar), a3.m583a(), "8");
                        com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. " + e);
                    }
                }
                String a7 = a(ifVar);
                if (!m.m739c() && m.m735a(context)) {
                    ay.m818a(notification, a7);
                }
                ax a8 = ax.a(context, a7);
                if (m.m735a(context) && f881a != null) {
                    f881a.a(ifVar, a3.m584a(), b2, notification);
                }
                if (!m.m735a(context) || f881a == null || !f881a.a(a3.m584a(), b2, notification)) {
                    a8.a(b2, notification);
                    cVar.f888a = true;
                    com.xiaomi.channel.commonutils.logger.b.m182a("notification: " + a3.m583a() + " is notifyied");
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
                }
                if (m.m734a() && m.m735a(context)) {
                    au.a().a(context, b2, notification);
                    cc.m842a(context, a7, b2, a3.m583a(), notification);
                }
                if (m796a(ifVar)) {
                    eo.a(context.getApplicationContext()).a(ifVar.b(), b(ifVar), a3.m583a(), 3002, null);
                }
                if (c(ifVar)) {
                    eo.a(context.getApplicationContext()).a(ifVar.b(), b(ifVar), a3.m583a(), 1002, null);
                }
                if (Build.VERSION.SDK_INT < 26) {
                    String a9 = a3.m583a();
                    com.xiaomi.push.al a10 = com.xiaomi.push.al.a(context);
                    int a11 = a(a3.m584a());
                    if (a11 > 0 && !TextUtils.isEmpty(a9)) {
                        String str4 = "n_timeout_" + a9;
                        a10.m252a(str4);
                        a10.b(new am(str4, a8, b2), a11);
                    }
                }
                Pair<Integer, Cif> pair = new Pair<>(Integer.valueOf(b2), ifVar);
                LinkedList<Pair<Integer, Cif>> linkedList = f882a;
                synchronized (linkedList) {
                    linkedList.add(pair);
                    if (linkedList.size() > 100) {
                        linkedList.remove();
                    }
                }
                return cVar;
            }
        } else {
            if (a3 != null) {
                eo.a(context.getApplicationContext()).a(ifVar.b(), b(ifVar), a3.m583a(), "14:" + a(ifVar));
            }
            str = "Do not notify because card notification is canceled or sequence incorrect";
        }
        com.xiaomi.channel.commonutils.logger.b.m182a(str);
        return cVar;
    }

    private static String a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? h.m540b(context, str) : map.get("channel_name");
    }

    public static String a(Cif ifVar) {
        hw a2;
        if (!(!"com.xiaomi.xmsf".equals(ifVar.f624b) || (a2 = ifVar.m617a()) == null || a2.m584a() == null)) {
            String str = a2.m584a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return ifVar.f624b;
    }

    public static String a(Map<String, String> map, int i) {
        String format = i == 0 ? "notify_effect" : m801b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i)) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
        if (map == null || format == null) {
            return null;
        }
        return map.get(format);
    }

    private static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private static void a(Context context, Intent intent, Cif ifVar, hw hwVar, String str, int i) {
        if (ifVar != null && hwVar != null && !TextUtils.isEmpty(str)) {
            String a2 = a(hwVar.m584a(), i);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            if (bk.a.equals(a2) || bk.b.equals(a2) || bk.c.equals(a2)) {
                intent.putExtra("messageId", str);
                intent.putExtra("local_paid", ifVar.f620a);
                if (!TextUtils.isEmpty(ifVar.f624b)) {
                    intent.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, ifVar.f624b);
                }
                intent.putExtra("job_key", a(hwVar.m584a(), "jobkey"));
                intent.putExtra(i + JSMethod.NOT_SET + "target_component", a(context, ifVar.f624b, hwVar.m584a(), i));
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m793a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i) {
        a(context, str, i, -1);
    }

    public static void a(Context context, String str, int i, int i2) {
        int i3;
        if (context != null && !TextUtils.isEmpty(str) && i >= -1) {
            ax a2 = ax.a(context, str);
            List<StatusBarNotification> b2 = a2.m817b();
            if (!w.a(b2)) {
                LinkedList linkedList = new LinkedList();
                boolean z = false;
                if (i == -1) {
                    i3 = 0;
                    z = true;
                } else {
                    i3 = ((str.hashCode() / 10) * 10) + i;
                }
                Iterator<StatusBarNotification> it = b2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    StatusBarNotification next = it.next();
                    if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                        int id = next.getId();
                        if (z) {
                            linkedList.add(next);
                            a2.a(id);
                        } else if (i3 == id) {
                            d.a(context, next, i2);
                            linkedList.add(next);
                            a2.a(id);
                            break;
                        }
                    }
                }
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (!(context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3))) {
            ax a2 = ax.a(context, str);
            List<StatusBarNotification> b2 = a2.m817b();
            if (!w.a(b2)) {
                LinkedList linkedList = new LinkedList();
                for (StatusBarNotification statusBarNotification : b2) {
                    Notification notification = statusBarNotification.getNotification();
                    if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                        int id = statusBarNotification.getId();
                        String a3 = ay.a(notification);
                        String b3 = ay.b(notification);
                        if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b3) && a(a3, str2) && a(b3, str3)) {
                            linkedList.add(statusBarNotification);
                            a2.a(id);
                        }
                    }
                }
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            bz.a(context, "category_clear_notification", "clear_notification", (long) linkedList.size(), "");
        }
    }

    private static void a(Intent intent) {
        try {
            Method declaredMethod = intent.getClass().getDeclaredMethod("addMiuiFlags", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(intent, 2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.b("insert flags error " + e);
        }
    }

    @TargetApi(16)
    private static void a(eq eqVar, Context context, String str, Cif ifVar, byte[] bArr, int i) {
        PendingIntent a2;
        PendingIntent a3;
        PendingIntent a4;
        PendingIntent a5;
        Map<String, String> a6 = ifVar.m617a().m584a();
        if (!(TextUtils.equals("3", a6.get("notification_style_type")) || TextUtils.equals("4", a6.get("notification_style_type")))) {
            if (m801b(a6)) {
                for (int i2 = 1; i2 <= 3; i2++) {
                    String str2 = a6.get(String.format("cust_btn_%s_n", Integer.valueOf(i2)));
                    if (!TextUtils.isEmpty(str2) && (a5 = a(context, str, ifVar, bArr, i, i2)) != null) {
                        eqVar.addAction(0, str2, a5);
                    }
                }
                return;
            }
            if (!TextUtils.isEmpty(a6.get("notification_style_button_left_name")) && (a4 = a(context, str, ifVar, bArr, i, 1)) != null) {
                eqVar.addAction(0, a6.get("notification_style_button_left_name"), a4);
            }
            if (!TextUtils.isEmpty(a6.get("notification_style_button_mid_name")) && (a3 = a(context, str, ifVar, bArr, i, 2)) != null) {
                eqVar.addAction(0, a6.get("notification_style_button_mid_name"), a3);
            }
            if (!(TextUtils.isEmpty(a6.get("notification_style_button_right_name")) || (a2 = a(context, str, ifVar, bArr, i, 3)) == null)) {
                eqVar.addAction(0, a6.get("notification_style_button_right_name"), a2);
            }
        }
    }

    private static boolean a(Context context, Cif ifVar, String str) {
        if (ifVar != null && ifVar.m617a() != null && ifVar.m617a().m584a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(ifVar.m617a().m584a().get("use_clicked_activity")) && l.a(context, a(str));
        }
        com.xiaomi.channel.commonutils.logger.b.m182a("should clicked activity params are null.");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m794a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m795a(Context context, String str, boolean z) {
        return m.m734a() && !z && m794a(context, str);
    }

    private static boolean a(hw hwVar) {
        if (hwVar == null) {
            return false;
        }
        String a2 = hwVar.m583a();
        return !TextUtils.isEmpty(a2) && a2.length() == 22 && "satuigmo".indexOf(a2.charAt(0)) >= 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m796a(Cif ifVar) {
        hw a2 = ifVar.m617a();
        return a(a2) && a2.l();
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m797a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0074, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0051, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0076;
     */
    private static String[] a(Context context, hw hwVar) {
        String str;
        String c2 = hwVar.m591c();
        String d = hwVar.d();
        Map<String, String> a2 = hwVar.m584a();
        if (a2 != null) {
            int intValue = Float.valueOf((((float) DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics())) / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str2 = a2.get("title_short");
                if (!TextUtils.isEmpty(str2)) {
                    c2 = str2;
                }
                str = a2.get("description_short");
            } else if (intValue > 360) {
                String str3 = a2.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    c2 = str3;
                }
                str = a2.get("description_long");
            }
            d = str;
        }
        return new String[]{c2, d};
    }

    private static int b(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return a2 == 0 ? context.getApplicationInfo().logo : a2;
    }

    private static int b(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("importance=" + str);
            return Integer.parseInt(str);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: " + e);
            return 3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0150  */
    public static Intent b(Context context, String str, Map<String, String> map, int i) {
        Intent intent;
        String str2;
        MalformedURLException e;
        Intent intent2;
        Intent intent3;
        URISyntaxException e2;
        if (map == null) {
            return null;
        }
        if (i != 0) {
            return m791a(context, str, map, i);
        }
        if (!map.containsKey("notify_effect")) {
            return null;
        }
        String str3 = map.get("notify_effect");
        int i2 = -1;
        String str4 = map.get("intent_flag");
        try {
            if (!TextUtils.isEmpty(str4)) {
                i2 = Integer.parseInt(str4);
            }
        } catch (NumberFormatException e3) {
            com.xiaomi.channel.commonutils.logger.b.d("Cause by intent_flag: " + e3.getMessage());
        }
        if (bk.a.equals(str3)) {
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e4) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e4.getMessage());
            }
        } else {
            if (bk.b.equals(str3)) {
                if (map.containsKey("intent_uri")) {
                    String str5 = map.get("intent_uri");
                    if (str5 != null) {
                        try {
                            intent3 = Intent.parseUri(str5, 1);
                            try {
                                intent3.setPackage(str);
                            } catch (URISyntaxException e5) {
                                e2 = e5;
                            }
                        } catch (URISyntaxException e6) {
                            e2 = e6;
                            intent3 = null;
                            com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e2.getMessage());
                            intent = intent3;
                            if (intent != null) {
                            }
                            return null;
                        }
                        intent = intent3;
                    }
                } else if (map.containsKey("class_name")) {
                    intent2 = new Intent();
                    intent2.setComponent(new ComponentName(str, map.get("class_name")));
                }
                intent = null;
            } else {
                if (bk.c.equals(str3) && (str2 = map.get("web_uri")) != null) {
                    String trim = str2.trim();
                    if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                        trim = "http://" + trim;
                    }
                    try {
                        String protocol = new URL(trim).getProtocol();
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            intent2 = new Intent("android.intent.action.VIEW");
                            try {
                                intent2.setData(Uri.parse(trim));
                                ay.a(context, str, intent2);
                            } catch (MalformedURLException e7) {
                                e = e7;
                            }
                        }
                    } catch (MalformedURLException e8) {
                        e = e8;
                        intent2 = null;
                        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                        intent = intent2;
                        if (intent != null) {
                        }
                        return null;
                    }
                }
                intent = null;
            }
            intent = intent2;
        }
        if (intent != null) {
            if (i2 >= 0) {
                intent.setFlags(i2);
            }
            b(intent);
            intent.addFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                    return intent;
                }
                if (Build.VERSION.SDK_INT >= 30 && !m.m735a(context) && bk.c.equals(str3)) {
                    return intent;
                }
                com.xiaomi.channel.commonutils.logger.b.m182a("not resolve activity:" + intent);
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e9.getMessage());
            }
        }
        return null;
    }

    public static String b(Cif ifVar) {
        return m796a(ifVar) ? "E100002" : c(ifVar) ? "E100000" : m800b(ifVar) ? "E100001" : d(ifVar) ? "E100003" : "";
    }

    /* renamed from: b  reason: collision with other method in class */
    public static void m798b(Context context, String str) {
        if (m.m735a(context) && f881a != null && !TextUtils.isEmpty(str)) {
            f881a.a(str);
        }
    }

    static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    private static void b(Intent intent) {
        if (intent != null) {
            int flags = intent.getFlags() & -2 & -3 & -65;
            if (Build.VERSION.SDK_INT >= 21) {
                flags &= -129;
            }
            intent.setFlags(flags);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    static boolean m799b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m800b(Cif ifVar) {
        hw a2 = ifVar.m617a();
        return a(a2) && a2.f534b == 1 && !m796a(ifVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    private static boolean m801b(Map<String, String> map) {
        if (map != null) {
            return "6".equals(map.get("notification_style_type"));
        }
        com.xiaomi.channel.commonutils.logger.b.m182a("meta extra is null");
        return false;
    }

    private static int c(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: " + e);
            return 0;
        }
    }

    static void c(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean c(Cif ifVar) {
        hw a2 = ifVar.m617a();
        return a(a2) && a2.f534b == 0 && !m796a(ifVar);
    }

    public static boolean d(Cif ifVar) {
        return ifVar.a() == hj.Registration;
    }

    public static boolean e(Cif ifVar) {
        return m796a(ifVar) || c(ifVar) || m800b(ifVar);
    }
}
