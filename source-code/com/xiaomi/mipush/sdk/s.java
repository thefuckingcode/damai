package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import com.xiaomi.push.m;
import java.util.HashMap;

/* compiled from: Taobao */
public class s {
    private static volatile s a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f77a;

    private s(Context context) {
        this.f77a = context.getApplicationContext();
    }

    private static s a(Context context) {
        if (a == null) {
            synchronized (s.class) {
                if (a == null) {
                    a = new s(context);
                }
            }
        }
        return a;
    }

    public static void a(Context context, Cif ifVar) {
        a(context).a(ifVar, 0, true);
    }

    public static void a(Context context, Cif ifVar, boolean z) {
        a(context).a(ifVar, 1, z);
    }

    private void a(Cif ifVar, int i, boolean z) {
        if (!m.m735a(this.f77a) && m.m734a() && ifVar != null && ifVar.f617a == hj.SendMessage && ifVar.m617a() != null && z) {
            b.m182a("click to start activity result:" + String.valueOf(i));
            ii iiVar = new ii(ifVar.m617a().m583a(), false);
            iiVar.c(ht.SDK_START_ACTIVITY.f497a);
            iiVar.b(ifVar.m618a());
            iiVar.d(ifVar.f624b);
            HashMap hashMap = new HashMap();
            iiVar.f636a = hashMap;
            hashMap.put("result", String.valueOf(i));
            ao.a(this.f77a).a(iiVar, hj.Notification, false, false, null, true, ifVar.f624b, ifVar.f620a, true, false);
        }
    }

    public static void b(Context context, Cif ifVar, boolean z) {
        a(context).a(ifVar, 2, z);
    }

    public static void c(Context context, Cif ifVar, boolean z) {
        a(context).a(ifVar, 3, z);
    }

    public static void d(Context context, Cif ifVar, boolean z) {
        a(context).a(ifVar, 4, z);
    }

    public static void e(Context context, Cif ifVar, boolean z) {
        s sVar;
        int i;
        b a2 = b.m219a(context);
        if (TextUtils.isEmpty(a2.m227c()) || TextUtils.isEmpty(a2.d())) {
            sVar = a(context);
            i = 6;
        } else {
            boolean f = a2.m231f();
            sVar = a(context);
            i = f ? 7 : 5;
        }
        sVar.a(ifVar, i, z);
    }
}
