package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.l;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ej implements eg {
    ej() {
    }

    private void a(Service service, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String b = dy.b(stringExtra);
            if (!TextUtils.isEmpty(b)) {
                dz.a(service.getApplicationContext(), b, 1007, "play with service successfully");
                return;
            }
        }
        dz.a(service.getApplicationContext(), "service", 1008, "B get a incorrect message");
    }

    private void b(Context context, ec ecVar) {
        String a = ecVar.m438a();
        String b = ecVar.b();
        String d = ecVar.d();
        int a2 = ecVar.a();
        if (context == null || TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                dz.a(context, "service", 1008, "argument error");
            } else {
                dz.a(context, d, 1008, "argument error");
            }
        } else if (!l.a(context, a, b)) {
            dz.a(context, d, 1003, "B is not ready");
        } else {
            dz.a(context, d, 1002, "B is ready");
            dz.a(context, d, 1004, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setAction(b);
                intent.setPackage(a);
                intent.putExtra("awake_info", dy.a(d));
                if (a2 == 1 && !ed.m439a(context)) {
                    dz.a(context, d, 1008, "A not in foreground");
                } else if (context.startService(intent) != null) {
                    dz.a(context, d, 1005, "A is successful");
                    dz.a(context, d, 1006, "The job is finished");
                } else {
                    dz.a(context, d, 1008, "A is fail to help B's service");
                }
            } catch (Exception e) {
                b.a(e);
                dz.a(context, d, 1008, "A meet a exception when help B's service");
            }
        }
    }

    @Override // com.xiaomi.push.eg
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            dz.a(context, "service", 1008, "A receive incorrect message");
        } else {
            a((Service) context, intent);
        }
    }

    @Override // com.xiaomi.push.eg
    public void a(Context context, ec ecVar) {
        if (ecVar != null) {
            b(context, ecVar);
        } else {
            dz.a(context, "service", 1008, "A receive incorrect message");
        }
    }
}
