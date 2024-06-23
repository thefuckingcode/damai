package com.vivo.push.d;

import android.text.TextUtils;
import com.vivo.push.d.r;
import com.vivo.push.e;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import java.util.HashMap;

/* compiled from: Taobao */
final class t implements r.a {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    @Override // com.vivo.push.d.r.a
    public final void a() {
        long l = e.a().l();
        if (l >= 1400 || l == 1340) {
            HashMap hashMap = new HashMap();
            hashMap.put("srt", "1");
            hashMap.put("message_id", String.valueOf(this.a.b.f()));
            String b = z.b(this.a.c.a, this.a.c.a.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("app_id", b);
            }
            hashMap.put("type", "1");
            hashMap.put("dtp", "1");
            com.vivo.push.util.e.a(6, hashMap);
            return;
        }
        p.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(l)));
    }

    @Override // com.vivo.push.d.r.a
    public final void b() {
        HashMap hashMap = new HashMap();
        hashMap.put("messageID", String.valueOf(this.a.b.f()));
        String b = z.b(this.a.c.a, this.a.c.a.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        com.vivo.push.util.e.a(2122, hashMap);
    }
}
