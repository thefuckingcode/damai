package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bk;
import com.xiaomi.push.ho;
import com.xiaomi.push.j;
import com.xiaomi.push.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: Taobao */
public class ax {
    private static Context a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f904a;

    /* renamed from: a  reason: collision with other field name */
    private static WeakHashMap<Integer, ax> f905a = new WeakHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static boolean f906a;

    /* renamed from: a  reason: collision with other field name */
    private String f907a;
    private String b;

    private ax(String str) {
        this.f907a = str;
    }

    private static int a(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            return a.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    private static NotificationManager a() {
        return (NotificationManager) a.getSystemService("notification");
    }

    public static ax a(Context context, String str) {
        a(context);
        int hashCode = str.hashCode();
        ax axVar = f905a.get(Integer.valueOf(hashCode));
        if (axVar != null) {
            return axVar;
        }
        ax axVar2 = new ax(str);
        f905a.put(Integer.valueOf(hashCode), axVar2);
        return axVar2;
    }

    private static <T> T a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = a("mipush|%s|%s", str2, "");
        return str.startsWith(a2) ? a("mipush_%s_%s", str2, str.replace(a2, "")) : str;
    }

    private static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.format(str, str2, str3);
    }

    private static void a(Context context) {
        if (a == null) {
            a = context.getApplicationContext();
            NotificationManager a2 = a();
            Boolean bool = (Boolean) bk.a((Object) a2, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m807a("fwk is support.init:" + bool);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f906a = booleanValue;
            if (booleanValue) {
                f904a = bk.a((Object) a2, "getService", new Object[0]);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    static void m807a(String str) {
        b.m182a("NMHelper:" + str);
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m808a() {
        if (m.m734a() && ba.a(a).a(ho.NotificationBelongToAppSwitch.a(), true)) {
            return f906a;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m809a(Context context) {
        a(context);
        return m808a();
    }

    /* renamed from: a  reason: collision with other method in class */
    private StatusBarNotification[] m810a() {
        if (!m.m735a(m812a())) {
            return null;
        }
        try {
            String packageName = m812a().getPackageName();
            Object a2 = bk.a(f904a, "getActiveNotifications", packageName);
            if (a2 instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) a2;
            }
            return null;
        } catch (Throwable th) {
            m807a("getAllNotifications error " + th);
            return null;
        }
    }

    private String b(String str) {
        return a(m808a() ? "mipush|%s|%s" : "mipush_%s_%s", this.f907a, str);
    }

    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public NotificationChannel m811a(String str) {
        try {
            if (!m808a()) {
                return a().getNotificationChannel(str);
            }
            List<NotificationChannel> a2 = m815a();
            if (a2 == null) {
                return null;
            }
            for (NotificationChannel notificationChannel : a2) {
                if (str.equals(notificationChannel.getId())) {
                    return notificationChannel;
                }
            }
            return null;
        } catch (Exception e) {
            m807a("getNotificationChannel error" + e);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public Context m812a() {
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m813a() {
        return this.f907a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m814a(String str) {
        return TextUtils.isEmpty(str) ? b() : m.m735a(m812a()) ? b(str) : str;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public List<NotificationChannel> m815a() {
        String str;
        String str2 = this.f907a;
        List<NotificationChannel> list = null;
        try {
            if (m808a()) {
                int a2 = a(str2);
                if (a2 != -1) {
                    Object obj = f904a;
                    Object[] objArr = {str2, Integer.valueOf(a2), Boolean.FALSE};
                    str = "mipush|%s|%s";
                    list = (List) a(bk.a(obj, "getNotificationChannelsForPackage", objArr));
                } else {
                    str = null;
                }
            } else {
                list = a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!m.m734a() || list == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            String a3 = a(str, str2, "");
            for (NotificationChannel notificationChannel : list) {
                if (notificationChannel.getId().startsWith(a3)) {
                    arrayList.add(notificationChannel);
                }
            }
            return arrayList;
        } catch (Exception e) {
            m807a("getNotificationChannels error " + e);
            return null;
        }
    }

    public void a(int i) {
        String str = this.f907a;
        try {
            if (m808a()) {
                int a2 = j.a();
                String packageName = m812a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    bk.b(f904a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(a2));
                } else {
                    bk.b(f904a, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(a2));
                }
                m807a("cancel succ:" + i);
                return;
            }
            a().cancel(i);
        } catch (Exception e) {
            m807a("cancel error" + e);
        }
    }

    public void a(int i, Notification notification) {
        String str = this.f907a;
        NotificationManager a2 = a();
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (m808a()) {
                if (i2 >= 19) {
                    notification.extras.putString("xmsf_target_package", str);
                }
                if (i2 >= 29) {
                    a2.notifyAsPackage(str, null, i, notification);
                    return;
                }
            }
            a2.notify(i, notification);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        String str = this.f907a;
        try {
            if (m808a()) {
                int a2 = a(str);
                if (a2 != -1) {
                    Object a3 = a(Arrays.asList(notificationChannel));
                    bk.b(f904a, "createNotificationChannelsForPackage", str, Integer.valueOf(a2), a3);
                    return;
                }
                return;
            }
            a().createNotificationChannel(notificationChannel);
        } catch (Exception e) {
            m807a("createNotificationChannel error" + e);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f907a;
        if (z) {
            try {
                int a2 = a(str);
                if (a2 != -1) {
                    bk.b(f904a, "updateNotificationChannelForPackage", str, Integer.valueOf(a2), notificationChannel);
                }
            } catch (Exception e) {
                m807a("updateNotificationChannel error " + e);
            }
        } else {
            a(notificationChannel);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m816a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith(b(""));
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = b("default");
        }
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public String b(String str, String str2) {
        return m808a() ? str : str2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public List<StatusBarNotification> m817b() {
        Object th;
        String str = this.f907a;
        NotificationManager a2 = a();
        ArrayList arrayList = null;
        try {
            if (m808a()) {
                int a3 = j.a();
                if (a3 == -1) {
                    return null;
                }
                return (List) a(bk.a(f904a, "getAppActiveNotifications", str, Integer.valueOf(a3)));
            }
            StatusBarNotification[] activeNotifications = Build.VERSION.SDK_INT >= 23 ? a2.getActiveNotifications() : m810a();
            boolean a4 = m.m734a();
            if (activeNotifications == null || activeNotifications.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (!a4 || str.equals(ay.c(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Throwable th2) {
                th = th2;
                arrayList = arrayList2;
                m807a("getActiveNotifications error " + th);
                return arrayList;
            }
        } catch (Throwable th3) {
            th = th3;
            m807a("getActiveNotifications error " + th);
            return arrayList;
        }
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f907a + "}";
    }
}
