package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bk;
import com.xiaomi.push.m;
import com.xiaomi.push.service.ay;
import com.xiaomi.push.v;
import com.xiaomi.push.w;
import java.util.ArrayList;
import java.util.List;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class e {
    private static final SparseArray<ay.a<String, String, String>> a = new f(5);

    /* renamed from: a  reason: collision with other field name */
    private static final int[] f971a = {1, 2, 4, 8, 16};
    private static final SparseArray<Integer> b = new g(5);

    e() {
    }

    static int a(String str, String str2) {
        int i = 8;
        if (!a(str, str2, 8)) {
            i = 0;
        }
        if (a(str, str2, 16)) {
            i |= 16;
        }
        if (a(str, str2, 1)) {
            i |= 1;
        }
        if (a(str, str2, 2)) {
            i |= 2;
        }
        return a(str, str2, 4) ? i | 4 : i;
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }

    static void a(Context context, String str) {
        List<NotificationChannel> a2;
        if (!(!m.m735a(context) || TextUtils.isEmpty(str) || (a2 = ax.a(context, str).m815a()) == null)) {
            synchronized (e.class) {
                SharedPreferences a3 = a(context);
                ArrayList arrayList = new ArrayList();
                for (NotificationChannel notificationChannel : a2) {
                    String str2 = (String) bk.a(notificationChannel, "mId");
                    if (!TextUtils.isEmpty(str2) && a3.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                if (arrayList.size() > 0) {
                    a(a3, arrayList);
                }
            }
        }
    }

    static void a(Context context, String str, String str2, int i, String str3, boolean z, int i2) {
        if (m.m735a(context) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            int a2 = w.a(str3, 0);
            boolean a3 = a(i, a2);
            if (z) {
                a(str, str2, a2, i2);
                if (a3) {
                    synchronized (e.class) {
                        a(a(context), a2, str2);
                    }
                    return;
                }
                return;
            }
            synchronized (e.class) {
                SharedPreferences a4 = a(context);
                if (a3 || a4.contains(str2)) {
                    a(a4, a2, str, str2, i2);
                    if (a3) {
                        a(a4, a2, str2);
                    } else {
                        a(a4, str2);
                    }
                }
            }
        } else if (m.m735a(context)) {
            b.m182a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
        }
    }

    private static void a(SharedPreferences sharedPreferences, int i, String str) {
        sharedPreferences.edit().putInt(str, i).commit();
    }

    private static void a(SharedPreferences sharedPreferences, int i, String str, String str2, int i2) {
        if (sharedPreferences.getInt(str2, 0) != i) {
            a(str, str2, i, i2);
        }
    }

    private static void a(SharedPreferences sharedPreferences, String str) {
        a(sharedPreferences, new h(str));
    }

    private static void a(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str : list) {
            edit.remove(str);
        }
        edit.commit();
    }

    static void a(String str, String str2, int i, int i2) {
        int[] iArr = f971a;
        for (int i3 : iArr) {
            if ((b.get(i3).intValue() & i2) == 0) {
                a(str, str2, i3, (i & i3) > 0);
            } else {
                b.m182a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i3 + "> :stoped by userLock");
            }
        }
    }

    private static void a(String str, String str2, int i, boolean z) {
        boolean a2 = ay.a(v.m879a(), str, str2, a.get(i), z);
        b.m182a("ChannelPermissions.grantPermission:" + str + ":" + str2 + ": <" + i + "=" + z + "> :" + a2);
    }

    private static boolean a(int i, int i2) {
        return i >= 4 || (i2 & 2) > 0 || (i2 & 1) > 0 || (i2 & 8) > 0 || (i2 & 16) > 0;
    }

    private static boolean a(String str, String str2, int i) {
        boolean z = true;
        if (ay.a(v.m879a(), str, str2, a.get(i)) != 1) {
            z = false;
        }
        b.m182a("ChannelPermissions.checkPermission:" + str + ":" + str2 + ": <" + i + "=" + z + jl1.G);
        return z;
    }
}
