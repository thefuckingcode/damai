package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.b.h;
import com.vivo.push.b.q;
import com.vivo.push.b.x;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.e;
import com.vivo.push.m;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.o;
import com.vivo.push.util.p;
import com.vivo.push.util.t;
import com.vivo.push.util.z;
import java.util.HashMap;

public final class r extends z {

    public interface a {
        void a();

        void b();
    }

    r(o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(o oVar) {
        if (oVar == null) {
            p.a("OnNotificationArrivedTask", "command is null");
            return;
        }
        boolean isEnablePush = ClientConfigManagerImpl.getInstance(this.a).isEnablePush();
        q qVar = (q) oVar;
        Context context = this.a;
        if (!t.d(context, context.getPackageName())) {
            x xVar = new x(2101);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(qVar.f()));
            Context context2 = this.a;
            String b = z.b(context2, context2.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            xVar.a(hashMap);
            e.a().a(xVar);
            return;
        }
        e.a().a(new h(String.valueOf(qVar.f())));
        p.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.a.getPackageName() + " isEnablePush :" + isEnablePush);
        if (!isEnablePush) {
            x xVar2 = new x(1020);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(qVar.f()));
            Context context3 = this.a;
            String b2 = z.b(context3, context3.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap2.put("remoteAppId", b2);
            }
            xVar2.a(hashMap2);
            e.a().a(xVar2);
        } else if (!e.a().g() || a(z.c(this.a), qVar.e(), qVar.i())) {
            InsideNotificationItem d = qVar.d();
            if (d != null) {
                int targetType = d.getTargetType();
                String tragetContent = d.getTragetContent();
                p.d("OnNotificationArrivedTask", "tragetType is " + targetType + " ; target is " + tragetContent);
                m.c(new s(this, d, qVar));
                return;
            }
            p.a("OnNotificationArrivedTask", "notify is null");
            Context context4 = this.a;
            p.c(context4, "通知内容为空，" + qVar.f());
            com.vivo.push.util.e.a(this.a, qVar.f(), 1027);
        } else {
            x xVar3 = new x(1021);
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put("messageID", String.valueOf(qVar.f()));
            Context context5 = this.a;
            String b3 = z.b(context5, context5.getPackageName());
            if (!TextUtils.isEmpty(b3)) {
                hashMap3.put("remoteAppId", b3);
            }
            xVar3.a(hashMap3);
            e.a().a(xVar3);
        }
    }
}
