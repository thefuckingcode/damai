package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dy;
import com.xiaomi.push.ed;
import com.xiaomi.push.eh;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.iu;
import com.xiaomi.push.service.bd;
import java.util.HashMap;

/* compiled from: Taobao */
public class c implements eh {
    @Override // com.xiaomi.push.eh
    public void a(Context context, HashMap<String, String> hashMap) {
        ii iiVar = new ii();
        iiVar.b(ed.a(context).m441a());
        iiVar.d(ed.a(context).b());
        iiVar.c(ht.AwakeAppResponse.f497a);
        iiVar.a(bd.a());
        iiVar.f636a = hashMap;
        ao.a(context).a((iu) iiVar, hj.Notification, true, (hw) null, true);
        b.m182a("MoleInfo：　send data in app layer");
    }

    @Override // com.xiaomi.push.eh
    public void b(Context context, HashMap<String, String> hashMap) {
        MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1, dy.a(hashMap));
        b.m182a("MoleInfo：　send data in app layer");
    }

    @Override // com.xiaomi.push.eh
    public void c(Context context, HashMap<String, String> hashMap) {
        b.m182a("MoleInfo：　" + dy.b(hashMap));
        String str = hashMap.get("awake_info");
        if (String.valueOf(1007).equals(hashMap.get("event_type"))) {
            o.a(context, str);
        }
    }
}
