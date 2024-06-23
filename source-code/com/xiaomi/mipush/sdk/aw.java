package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ba;
import com.xiaomi.push.bp;
import com.xiaomi.push.h;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.iu;
import com.xiaomi.push.j;
import com.xiaomi.push.m;
import com.xiaomi.push.n;
import com.xiaomi.push.service.bd;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class aw implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f59a;

    aw(Context context, boolean z) {
        this.a = context;
        this.f59a = z;
    }

    public void run() {
        String str;
        String str2;
        Map<String, String> map;
        b.m182a("do sync info");
        ii iiVar = new ii(bd.a(), false);
        b a2 = b.m219a(this.a);
        iiVar.c(ht.SyncInfo.f497a);
        iiVar.b(a2.m220a());
        iiVar.d(this.a.getPackageName());
        HashMap hashMap = new HashMap();
        iiVar.f636a = hashMap;
        Context context = this.a;
        n.a(hashMap, "app_version", h.m537a(context, context.getPackageName()));
        Map<String, String> map2 = iiVar.f636a;
        Context context2 = this.a;
        n.a(map2, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(h.a(context2, context2.getPackageName())));
        n.a(iiVar.f636a, "push_sdk_vn", "4_9_1");
        n.a(iiVar.f636a, "push_sdk_vc", Integer.toString(40091));
        n.a(iiVar.f636a, "token", a2.b());
        if (!m.m740d()) {
            String a3 = bp.a(j.d(this.a));
            String f = j.f(this.a);
            if (!TextUtils.isEmpty(f)) {
                a3 = a3 + "," + f;
            }
            if (!TextUtils.isEmpty(a3)) {
                n.a(iiVar.f636a, Constants.EXTRA_KEY_IMEI_MD5, a3);
            }
        }
        ba.a(this.a).a(iiVar.f636a);
        n.a(iiVar.f636a, Constants.EXTRA_KEY_REG_ID, a2.m227c());
        n.a(iiVar.f636a, Constants.EXTRA_KEY_REG_SECRET, a2.d());
        n.a(iiVar.f636a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.a).replace(",", "-"));
        if (this.f59a) {
            n.a(iiVar.f636a, Constants.EXTRA_KEY_ALIASES_MD5, av.c(MiPushClient.getAllAlias(this.a)));
            n.a(iiVar.f636a, Constants.EXTRA_KEY_TOPICS_MD5, av.c(MiPushClient.getAllTopic(this.a)));
            map = iiVar.f636a;
            str2 = av.c(MiPushClient.getAllUserAccount(this.a));
            str = Constants.EXTRA_KEY_ACCOUNTS_MD5;
        } else {
            n.a(iiVar.f636a, Constants.EXTRA_KEY_ALIASES, av.d(MiPushClient.getAllAlias(this.a)));
            n.a(iiVar.f636a, Constants.EXTRA_KEY_TOPICS, av.d(MiPushClient.getAllTopic(this.a)));
            map = iiVar.f636a;
            str2 = av.d(MiPushClient.getAllUserAccount(this.a));
            str = Constants.EXTRA_KEY_ACCOUNTS;
        }
        n.a(map, str, str2);
        ao.a(this.a).a((iu) iiVar, hj.Notification, false, (hw) null);
    }
}
