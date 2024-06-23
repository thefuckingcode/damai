package com.efs.sdk.base.a.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.a.b.a;
import java.io.File;
import org.apache.commons.lang3.time.DateUtils;
import tb.n13;
import tb.o13;
import tb.t43;
import tb.u33;
import tb.w23;

/* compiled from: Taobao */
public final class c extends Handler implements Runnable {
    public boolean a;

    /* compiled from: Taobao */
    static class a {
        private static final c a = new c((byte) 0);
    }

    private c() {
        super(o13.a.getLooper());
        this.a = true;
        sendEmptyMessageDelayed(2, DateUtils.MILLIS_PER_MINUTE);
    }

    /* synthetic */ c(byte b) {
        this();
    }

    public static c a() {
        return a.a;
    }

    public final void handleMessage(Message message) {
        if (message.what != 2) {
            t43.b("efs.cache", "disk listener not support command: " + message.what, null);
            return;
        }
        u33.a(this);
    }

    public final void run() {
        a unused = a.b.a;
        File g = n13.g(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a);
        if (g.exists()) {
            for (File file : w23.k(g)) {
                if (a.c(file.getName())) {
                    a.e(file);
                }
            }
        }
        com.efs.sdk.base.a.c.a.c a2 = com.efs.sdk.base.a.c.a.c.a();
        String str = "4194304";
        String str2 = a2.e.f.containsKey("disk_bytes") ? a2.e.f.get("disk_bytes") : str;
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        long parseLong = Long.parseLong(str);
        long j = w23.j(n13.g(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a)) + w23.j(n13.e(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a));
        boolean z = j < parseLong;
        this.a = z;
        if (!z) {
            t43.b("efs.cache", "Cache Limited! curr " + j + "byte, max " + parseLong + " byte.", null);
        }
        sendEmptyMessageDelayed(2, 600000);
    }
}
