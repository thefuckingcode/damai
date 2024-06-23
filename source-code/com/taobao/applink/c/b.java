package com.taobao.applink.c;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.applink.TBAppLinkSDK;
import java.util.HashMap;
import tb.a13;
import tb.rh2;
import tb.th2;
import tb.v43;
import tb.x33;
import tb.z03;

/* compiled from: Taobao */
public class b {
    private static volatile b c;
    private CharSequence a = "unkown";
    private String b;

    /* compiled from: Taobao */
    public interface a {
        void a(a13 a13);
    }

    private b() {
        new HashMap();
        this.a = x33.b(th2.a());
        rh2 rh2 = TBAppLinkSDK.a().a;
        throw null;
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (c == null) {
                c = new b();
            }
            bVar = c;
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        System.currentTimeMillis();
        stringBuffer.append("logtype=2&wappkey=");
        stringBuffer.append(this.b);
        stringBuffer.append("&");
        stringBuffer.append("packagename=");
        stringBuffer.append(z03.a(th2.a()));
        stringBuffer.append("&");
        stringBuffer.append("os=");
        stringBuffer.append("android");
        stringBuffer.append("&");
        stringBuffer.append("imei=");
        stringBuffer.append(this.a);
        stringBuffer.append("&t=");
        stringBuffer.append("&sdkversion=");
        stringBuffer.append(th2.SDKVERSION);
        if (!TextUtils.isEmpty(str3)) {
            stringBuffer.append("&");
            stringBuffer.append(str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append("&type=");
            stringBuffer.append(str2);
        }
        rh2 rh2 = TBAppLinkSDK.a().a;
        throw null;
    }

    public void c(String str, String str2, String str3) {
        if (!v43.a(str)) {
            synchronized (this) {
                try {
                    new a(this, str, str2, str3).execute(new Void[0]);
                } catch (Exception e) {
                    Log.d("flush exception", e.getStackTrace().toString());
                }
            }
        }
    }
}
