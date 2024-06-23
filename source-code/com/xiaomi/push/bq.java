package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.manager.a;
import com.xiaomi.push.al;

/* compiled from: Taobao */
public class bq extends al.a {
    private Context a;

    public bq(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.al.a
    private boolean a() {
        return a.a(this.a).m184a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a  reason: collision with other method in class */
    public String m295a() {
        return "100886";
    }

    public void run() {
        try {
            if (a()) {
                b.c(this.a.getPackageName() + " begin upload event");
                a.a(this.a).m186b();
            }
        } catch (Exception e) {
            b.a(e);
        }
    }
}
