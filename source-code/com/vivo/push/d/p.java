package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.b.h;
import com.vivo.push.b.x;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.e;
import com.vivo.push.m;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.o;
import com.vivo.push.util.z;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class p extends z {
    p(o oVar) {
        super(oVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.l
    public final void a(o oVar) {
        com.vivo.push.b.o oVar2 = (com.vivo.push.b.o) oVar;
        e.a().a(new h(String.valueOf(oVar2.f())));
        if (!ClientConfigManagerImpl.getInstance(this.a).isEnablePush()) {
            com.vivo.push.util.p.d("OnMessageTask", "command  " + oVar + " is ignore by disable push ");
            x xVar = new x(1020);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(oVar2.f()));
            Context context = this.a;
            String b = z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            xVar.a(hashMap);
            e.a().a(xVar);
        } else if (!e.a().g() || a(z.c(this.a), oVar2.d(), oVar2.i())) {
            UnvarnishedMessage e = oVar2.e();
            if (e != null) {
                int targetType = e.getTargetType();
                String tragetContent = e.getTragetContent();
                com.vivo.push.util.p.d("OnMessageTask", "tragetType is " + targetType + " ; target is " + tragetContent);
                m.b(new q(this, e));
                return;
            }
            com.vivo.push.util.p.a("OnMessageTask", " message is null");
        } else {
            x xVar2 = new x(1021);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(oVar2.f()));
            Context context2 = this.a;
            String b2 = z.b(context2, context2.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap2.put("remoteAppId", b2);
            }
            xVar2.a(hashMap2);
            e.a().a(xVar2);
        }
    }
}
