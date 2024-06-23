package com.xiaomi.push.service;

import com.xiaomi.push.ii;
import com.xiaomi.push.m;
import com.xiaomi.push.v;

/* compiled from: Taobao */
public class i {
    private static a a;

    /* renamed from: a  reason: collision with other field name */
    private static b f972a;

    /* compiled from: Taobao */
    public interface a {
        boolean a(ii iiVar);
    }

    /* compiled from: Taobao */
    public interface b {
    }

    public static void a(b bVar) {
        f972a = bVar;
    }

    public static boolean a(ii iiVar) {
        String str;
        if (a == null || iiVar == null) {
            str = "rc params is null, not cpra";
        } else if (m.m735a(v.m879a())) {
            return a.a(iiVar);
        } else {
            str = "rc app not permission to cpra";
        }
        com.xiaomi.channel.commonutils.logger.b.m182a(str);
        return false;
    }
}
