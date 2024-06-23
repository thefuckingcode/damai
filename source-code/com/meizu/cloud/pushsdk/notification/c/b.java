package com.meizu.cloud.pushsdk.notification.c;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class b {
    private static Field a;
    private static Field b;
    private static Field c;
    private static final Object d = new Object();
    private static final Map<String, Set<String>> e = new ConcurrentHashMap();
    private static Map<String, Uri> f;

    static {
        try {
            a = Notification.class.getDeclaredField("mFlymeNotification");
            Field declaredField = Class.forName("android.app.NotificationExt").getDeclaredField("internalApp");
            b = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = Notification.class.getDeclaredField("replyIntent");
            c = declaredField2;
            declaredField2.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            DebugLogger.e("NotificationUtils", "init NotificationUtils error " + e2.getMessage());
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
        }
    }

    public static void a(Notification notification, PendingIntent pendingIntent) {
        Field field = c;
        if (field != null) {
            try {
                field.set(notification, pendingIntent);
            } catch (IllegalAccessException e2) {
                DebugLogger.e("NotificationUtils", "setReplyIntent error " + e2.getMessage());
            }
        }
    }

    public static void a(Notification notification, boolean z) {
        Field field = a;
        if (field != null && b != null) {
            try {
                b.set(field.get(notification), Integer.valueOf(z ? 1 : 0));
            } catch (IllegalAccessException e2) {
                DebugLogger.e("NotificationUtils", "setInternalApp error " + e2.getMessage());
            }
        }
    }

    public static void a(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
    }

    public static void a(Context context, String str) {
        Set<String> set;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (!(notificationManager == null || TextUtils.isEmpty(str) || (set = e.get(str)) == null)) {
            for (String str2 : set) {
                DebugLogger.i("NotificationUtils", "clear notifyId " + str2 + " notification");
                notificationManager.cancel(Integer.parseInt(str2));
            }
            set.clear();
        }
    }

    public static void a(Context context, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            DebugLogger.i("NotificationUtils", "clear clearNotification notifyId " + i);
            notificationManager.cancel(i);
            Set<String> set = e.get(str);
            if (set != null) {
                set.remove(String.valueOf(i));
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        synchronized (d) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            int i = com.meizu.cloud.pushsdk.util.b.i(context, str, str2);
            DebugLogger.e("NotificationUtils", "removeNotifyKey " + str2 + " notifyId " + i);
            c(context, str, i);
            return com.meizu.cloud.pushsdk.util.b.j(context, str, str2);
        }
    }

    public static Uri b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || RingtoneManager.getActualDefaultRingtoneUri(context, 2) == null) {
            return null;
        }
        if (f == null) {
            b(context);
        }
        Map<String, Uri> map = f;
        if (!(map == null || map.size() == 0)) {
            return f.get(str.toLowerCase());
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007e, code lost:
        if (0 == 0) goto L_0x0081;
     */
    private static synchronized void b(Context context) {
        synchronized (b.class) {
            if (f == null) {
                Cursor cursor = null;
                try {
                    RingtoneManager ringtoneManager = new RingtoneManager(context);
                    ringtoneManager.setType(2);
                    cursor = ringtoneManager.getCursor();
                    if (cursor == null) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return;
                    }
                    f = new HashMap(cursor.getCount());
                    for (boolean moveToFirst = cursor.moveToFirst(); moveToFirst; moveToFirst = cursor.moveToNext()) {
                        String string = cursor.getString(1);
                        Uri withAppendedId = ContentUris.withAppendedId(Uri.parse(cursor.getString(2)), cursor.getLong(0));
                        if (!TextUtils.isEmpty(string) && withAppendedId != null) {
                            f.put(string.toLowerCase(), withAppendedId);
                        }
                    }
                    cursor.close();
                } catch (Exception e2) {
                    DebugLogger.e("NotificationUtils", "get ringtone info error, " + e2.getMessage());
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        }
    }

    public static void b(Context context, String str, int i) {
        Map<String, Set<String>> map = e;
        Set<String> set = map.get(str);
        DebugLogger.i("NotificationUtils", "store notifyId " + i);
        if (set == null) {
            HashSet hashSet = new HashSet();
            hashSet.add(String.valueOf(i));
            map.put(str, hashSet);
            return;
        }
        set.add(String.valueOf(i));
    }

    public static void c(Context context, String str, int i) {
        Set<String> set = e.get(str);
        if (set != null) {
            set.remove(String.valueOf(i));
            DebugLogger.i("NotificationUtils", "remove notifyId " + i);
        }
    }
}
