package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bk;
import com.xiaomi.push.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Taobao */
public class ay {
    public static final a<String, String, String> a = new a<>("setSound", "canSound", "canSound");

    /* renamed from: a  reason: collision with other field name */
    private static String f908a = null;

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f909a = {"com.mi.globalbrowser", "com.android.browser"};
    public static final a<String, String, String> b = new a<>("setVibrate", "canVibrate", "canVibrate");
    public static final a<String, String, String> c = new a<>("setLights", "canLights", "canLights");
    public static final a<String, String, String> d = new a<>("setShowOnKeyguard", "canShowOnKeyguard", "canShowOnKeyguard");
    public static final a<String, String, String> e = new a<>("setFloat", "canFloat", "canShowFloat");
    public static final a<String, String, String> f = new a<>("setShowBadge", "canShowBadge", "canShowBadge");

    /* compiled from: Taobao */
    public static class a<F, S, T> {
        F a;
        S b;
        T c;

        private a(F f, S s, T t) {
            this.a = f;
            this.b = s;
            this.c = t;
        }
    }

    public static int a(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (Exception e2) {
            b.m182a("get user aggregate failed, " + e2);
            return 0;
        }
    }

    static int a(Context context, String str) {
        return h.b(context, str);
    }

    public static int a(Context context, String str, String str2, a<String, String, String> aVar) {
        if (aVar == null) {
            return -1;
        }
        try {
            Bundle a2 = a(context, aVar.b, str, str2, (Bundle) null);
            if (a2 == null || !a2.containsKey(aVar.c)) {
                return -1;
            }
            return a2.getBoolean(aVar.c) ? 1 : 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    private static Bundle a(Context context, String str, String str2, String str3, Bundle bundle) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("call notification provider failed!");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("package", str2);
        if (!TextUtils.isEmpty(str3)) {
            bundle2.putString("channel_id", str3);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        return context.getContentResolver().call(Uri.parse("content://statusbar.notification"), str, (String) null, bundle2);
    }

    public static <T> T a(Notification notification, String str) {
        Bundle bundle = notification.extras;
        if (bundle == null) {
            return null;
        }
        try {
            return (T) bundle.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    public static <T> T a(Object obj, String str, T t) {
        T t2;
        T t3 = null;
        try {
            if (obj instanceof Notification) {
                t2 = a((Notification) obj, str);
            } else if (obj instanceof Map) {
                t2 = ((Map) obj).get(str);
            } else if (obj instanceof Bundle) {
                t2 = ((Bundle) obj).get(str);
            } else {
                b.m182a("not support get value from classType:" + obj);
                return t3 != null ? t : t3;
            }
            t3 = t2;
        } catch (Exception e2) {
            b.m182a("get value error " + e2);
        }
        if (t3 != null) {
        }
    }

    public static String a(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static String a(Object obj) {
        return (String) a(obj, "msg_busi_type", "");
    }

    static void a(Notification notification, int i) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putInt("miui.messageCount", i);
            }
            Object a2 = bk.a(notification, "extraNotification");
            if (a2 != null) {
                bk.a(a2, "setMessageCount", Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
    }

    static void a(Notification notification, int i, int i2) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i);
            notification.extras.putInt("mipush_class", i2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    static void m818a(Notification notification, String str) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, str);
            }
            Object a2 = bk.a(notification, "extraNotification");
            if (a2 != null) {
                bk.a(a2, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    static void a(Notification notification, boolean z) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableFloat", z);
            }
            Object a2 = bk.a(notification, "extraNotification");
            if (a2 != null) {
                bk.a(a2, "setEnableFloat", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    static void a(Context context, String str, Intent intent) {
        if (intent != null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
            arrayList.addAll(Arrays.asList(f909a));
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                String str2 = (String) arrayList.get(i);
                if (!TextUtils.isEmpty(str2)) {
                    Intent intent2 = new Intent(intent);
                    intent2.setPackage(str2);
                    try {
                        if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                            intent.setPackage(str2);
                            break;
                        }
                    } catch (Exception e2) {
                        b.m182a("can't match url intent. " + e2);
                    }
                }
                i++;
            }
            intent.setPackage(intent.getPackage());
        }
    }

    public static void a(Map<String, String> map, Bundle bundle, String str) {
        if (map == null || bundle == null || TextUtils.isEmpty(str)) {
            b.m182a("cp map to b fail:" + str);
        } else if (TextUtils.isEmpty(map.get(str))) {
            bundle.remove(str);
        } else {
            bundle.putString(str, map.get(str));
        }
    }

    public static boolean a(Notification.Builder builder, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        b.b("not support setGroupAlertBehavior");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m819a(ContentResolver contentResolver) {
        int a2 = a(contentResolver);
        return a2 == 1 || a2 == 2;
    }

    public static boolean a(Context context, String str, String str2, a<String, String, String> aVar, boolean z) {
        if (aVar != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean(aVar.c, z);
                a(context, aVar.a, str, str2, bundle);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(Map<String, String> map) {
        return Boolean.parseBoolean((String) a(map, "not_suppress", "true"));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Notification.Action[] m820a(Notification notification) {
        Parcelable[] parcelableArray;
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr;
        }
        Bundle bundle = notification.extras;
        if (bundle == null || (parcelableArray = bundle.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
    }

    public static String b(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
            if (TextUtils.isEmpty(charSequence) && Build.VERSION.SDK_INT >= 21) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static void b(Notification notification, boolean z) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableKeyguard", z);
            }
            Object a2 = bk.a(notification, "extraNotification");
            if (a2 != null) {
                bk.a(a2, "setEnableKeyguard", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    public static String c(Notification notification) {
        Object a2;
        String str = null;
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                str = bundle.getString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE);
            }
            return (!TextUtils.isEmpty(str) || (a2 = bk.a(notification, "extraNotification")) == null) ? str : (String) bk.a(a2, "getTargetPkg", new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
