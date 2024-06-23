package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.manager.a;
import com.xiaomi.push.al;

/* compiled from: Taobao */
public class br extends al.a {
    private Context a;

    public br(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.al.a
    private boolean a() {
        return a.a(this.a).m184a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a  reason: collision with other method in class */
    public String m296a() {
        return "100887";
    }

    public void run() {
        try {
            if (a()) {
                a.a(this.a).c();
                b.c(this.a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e) {
            b.d("fail to send perf data. " + e);
        }
    }
}
