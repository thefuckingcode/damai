package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.al;
import com.xiaomi.push.hj;
import com.xiaomi.push.hp;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.ib;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bb;

/* compiled from: Taobao */
public class ae extends al.a {
    private Context a;

    public ae(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.al.a
    public String a() {
        return "2";
    }

    public void run() {
        ba a2 = ba.a(this.a);
        ib ibVar = new ib();
        ibVar.a(bb.a(a2, hp.MISC_CONFIG));
        ibVar.b(bb.a(a2, hp.PLUGIN_CONFIG));
        ii iiVar = new ii("-1", false);
        iiVar.c(ht.DailyCheckClientConfig.f497a);
        iiVar.a(it.a(ibVar));
        ao.a(this.a).a(iiVar, hj.Notification, (hw) null);
    }
}
