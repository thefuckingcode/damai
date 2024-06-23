package com.efs.sdk.base.a.e;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import tb.g63;
import tb.n13;
import tb.t43;

public final class f {
    volatile int a;

    public static class a {
        private static final f a = new f((byte) 0);
    }

    private f() {
        this.a = 0;
        a(com.efs.sdk.base.a.d.a.a().c);
    }

    /* synthetic */ f(byte b) {
        this();
    }

    private synchronized void a(final Context context) {
        t43.b("efs.send_log", "tryFileLock start! ", null);
        this.a = 1;
        new Thread(new Runnable() {
            /* class com.efs.sdk.base.a.e.f.AnonymousClass1 */

            public final void run() {
                try {
                    File a2 = n13.a(context);
                    if (!a2.exists()) {
                        a2.mkdirs();
                    }
                    File file = new File(a2.getPath() + File.separator + "sendlock");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    do {
                    } while (!new FileOutputStream(file).getChannel().lock().isValid());
                    StringBuilder sb = new StringBuilder("tryFileLock sendlock sucess! processname: ");
                    String str = g63.a;
                    if (TextUtils.isEmpty(str)) {
                        str = g63.a(Process.myPid());
                        g63.a = str;
                    }
                    sb.append(str);
                    t43.b("efs.send_log", sb.toString(), null);
                    f.this.a = 2;
                } catch (Exception e) {
                    t43.b("efs.send_log", "tryFileLock fail! " + e.getMessage(), null);
                    f.this.a = 0;
                }
            }
        }).start();
    }

    public final boolean b() {
        if (this.a == 2) {
            return true;
        }
        if (this.a != 0) {
            return false;
        }
        a(com.efs.sdk.base.a.d.a.a().c);
        return false;
    }
}
