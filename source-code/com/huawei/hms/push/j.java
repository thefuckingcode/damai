package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
public class j {
    public static final String[] a = {"url", "app", "cosa", "rp"};
    public Context b;
    public k c;

    public j(Context context, k kVar) {
        this.b = context;
        this.c = kVar;
    }

    public static boolean a(String str) {
        for (String str2 : a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00ba, code lost:
        if (com.huawei.hms.push.q.a(r6.b, r6.c.d(), r2).booleanValue() != false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x007a, code lost:
        if (r3 != false) goto L_0x00bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c5  */
    public final void b() {
        Intent intent;
        HMSLog.i("PushSelfShowLog", "run into launchCosaApp");
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("enter launchExistApp cosa, appPackageName =");
            sb.append(this.c.d());
            sb.append(",and msg.intentUri is ");
            sb.append(this.c.n());
            HMSLog.i("PushSelfShowLog", sb.toString());
            Intent b2 = q.b(this.b, this.c.d());
            boolean z = false;
            if (this.c.n() != null) {
                try {
                    intent = Intent.parseUri(this.c.n(), 0);
                    intent.setSelector(null);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Intent.parseUri(msg.intentUri, 0), action:");
                    sb2.append(intent.getAction());
                    HMSLog.i("PushSelfShowLog", sb2.toString());
                    z = q.a(this.b, this.c.d(), intent).booleanValue();
                } catch (Exception e) {
                    HMSLog.w("PushSelfShowLog", "intentUri error." + e.toString());
                }
            } else {
                if (this.c.a() != null) {
                    intent = new Intent(this.c.a());
                }
                if (b2 != null) {
                    HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
                    return;
                }
                b2.setPackage(this.c.d());
                if (z) {
                    b2.addFlags(268435456);
                } else {
                    b2.setFlags(805437440);
                }
                this.b.startActivity(b2);
                return;
            }
            b2 = intent;
            if (b2 != null) {
            }
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "launch Cosa App exception." + e2.toString());
        }
    }

    public void c() {
        k kVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.b == null || (kVar = this.c) == null) {
            HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
        } else if ("app".equals(kVar.i())) {
            a();
        } else if ("cosa".equals(this.c.i())) {
            b();
        } else if ("rp".equals(this.c.i())) {
            HMSLog.w("PushSelfShowLog", this.c.i() + " not support rich message.");
        } else if ("url".equals(this.c.i())) {
            HMSLog.w("PushSelfShowLog", this.c.i() + " not support URL.");
        } else {
            HMSLog.d("PushSelfShowLog", this.c.i() + " is not exist in hShowType");
        }
    }

    public final void a() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("enter launchApp, appPackageName =");
            sb.append(this.c.d());
            HMSLog.i("PushSelfShowLog", sb.toString());
            if (q.c(this.b, this.c.d())) {
                b();
            }
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e.toString());
        }
    }
}
