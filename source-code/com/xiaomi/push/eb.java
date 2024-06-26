package com.xiaomi.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.l;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class eb implements eg {
    eb() {
    }

    private void a(Activity activity, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String b = dy.b(stringExtra);
            if (!TextUtils.isEmpty(b)) {
                dz.a(activity.getApplicationContext(), b, 1007, "play with activity successfully");
                return;
            }
        }
        dz.a(activity.getApplicationContext(), "activity", 1008, "B get incorrect message");
    }

    private void b(Context context, ec ecVar) {
        String a = ecVar.m438a();
        String b = ecVar.b();
        String d = ecVar.d();
        int a2 = ecVar.a();
        if (context == null || TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                dz.a(context, "activity", 1008, "argument error");
            } else {
                dz.a(context, d, 1008, "argument error");
            }
        } else if (!l.b(context, a, b)) {
            dz.a(context, d, 1003, "B is not ready");
        } else {
            dz.a(context, d, 1002, "B is ready");
            dz.a(context, d, 1004, "A is ready");
            Intent intent = new Intent(b);
            intent.setPackage(a);
            intent.putExtra("awake_info", dy.a(d));
            intent.addFlags(276824064);
            intent.setAction(b);
            if (a2 == 1) {
                try {
                    if (!ed.m439a(context)) {
                        dz.a(context, d, 1008, "A not in foreground");
                        return;
                    }
                } catch (Exception e) {
                    b.a(e);
                    dz.a(context, d, 1008, "A meet a exception when help B's activity");
                    return;
                }
            }
            context.startActivity(intent);
            dz.a(context, d, 1005, "A is successful");
            dz.a(context, d, 1006, "The job is finished");
        }
    }

    @Override // com.xiaomi.push.eg
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Activity) || intent == null) {
            dz.a(context, "activity", 1008, "B receive incorrect message");
        } else {
            a((Activity) context, intent);
        }
    }

    @Override // com.xiaomi.push.eg
    public void a(Context context, ec ecVar) {
        if (ecVar != null) {
            b(context, ecVar);
        } else {
            dz.a(context, "activity", 1008, "A receive incorrect message");
        }
    }
}
