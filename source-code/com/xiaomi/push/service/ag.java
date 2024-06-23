package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.Cif;
import java.util.Map;

/* compiled from: Taobao */
public class ag {
    private static a a;

    /* renamed from: a  reason: collision with other field name */
    private static b f878a;

    /* compiled from: Taobao */
    public interface a {
        Map<String, String> a(Context context, Cif ifVar);

        /* renamed from: a  reason: collision with other method in class */
        void m789a(Context context, Cif ifVar);

        boolean a(Context context, Cif ifVar, boolean z);
    }

    /* compiled from: Taobao */
    public interface b {
        void a(Cif ifVar);

        void a(String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m790a(Cif ifVar);
    }

    public static Map<String, String> a(Context context, Cif ifVar) {
        a aVar = a;
        if (aVar != null && ifVar != null) {
            return aVar.a(context, ifVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m182a("pepa listener or container is null");
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m787a(Context context, Cif ifVar) {
        a aVar = a;
        if (aVar == null || ifVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m182a("handle msg wrong");
        } else {
            aVar.m789a(context, ifVar);
        }
    }

    public static void a(Cif ifVar) {
        b bVar = f878a;
        if (bVar == null || ifVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m182a("pepa clearMessage is null");
        } else {
            bVar.a(ifVar);
        }
    }

    public static void a(String str) {
        b bVar = f878a;
        if (bVar == null || str == null) {
            com.xiaomi.channel.commonutils.logger.b.m182a("pepa clearMessage is null");
        } else {
            bVar.a(str);
        }
    }

    public static boolean a(Context context, Cif ifVar, boolean z) {
        a aVar = a;
        if (aVar != null && ifVar != null) {
            return aVar.a(context, ifVar, z);
        }
        com.xiaomi.channel.commonutils.logger.b.m182a("pepa judement listener or container is null");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m788a(Cif ifVar) {
        b bVar = f878a;
        if (bVar != null && ifVar != null) {
            return bVar.m790a(ifVar);
        }
        com.xiaomi.channel.commonutils.logger.b.m182a("pepa handleReceiveMessage is null");
        return false;
    }
}
