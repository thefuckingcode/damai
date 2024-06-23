package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.push.bj;
import com.xiaomi.push.cr;
import com.xiaomi.push.cu;
import com.xiaomi.push.cv;
import com.xiaomi.push.dw;
import com.xiaomi.push.dx;
import com.xiaomi.push.ez;
import com.xiaomi.push.fh;
import com.xiaomi.push.fj;
import com.xiaomi.push.fw;
import com.xiaomi.push.gy;
import com.xiaomi.push.service.bv;
import com.xiaomi.push.v;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class bl extends bv.a implements cv.a {
    private long a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f934a;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements cv.b {
        a() {
        }

        @Override // com.xiaomi.push.cv.b
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(48));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", gy.a(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL() + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(v.a()));
            String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = bj.a(v.m879a(), url);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                fj.a(url.getHost() + ":" + port, (int) currentTimeMillis2, null);
                return a;
            } catch (IOException e) {
                fj.a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    /* compiled from: Taobao */
    static class b extends cv {
        protected b(Context context, cu cuVar, cv.b bVar, String str) {
            super(context, cuVar, bVar, str);
        }

        /* access modifiers changed from: protected */
        @Override // com.xiaomi.push.cv
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (fh.m474a().m479a()) {
                    str2 = bv.m837a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e) {
                fj.a(0, ez.GSLB_ERR.a(), 1, null, bj.c(cv.a) ? 1 : 0);
                throw e;
            }
        }
    }

    bl(XMPushService xMPushService) {
        this.f934a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        bl blVar = new bl(xMPushService);
        bv.a().a(blVar);
        synchronized (cv.class) {
            cv.a(blVar);
            cv.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // com.xiaomi.push.cv.a
    public cv a(Context context, cu cuVar, cv.b bVar, String str) {
        return new b(context, cuVar, bVar, str);
    }

    @Override // com.xiaomi.push.service.bv.a
    public void a(dw.a aVar) {
    }

    @Override // com.xiaomi.push.service.bv.a
    public void a(dx.b bVar) {
        cr b2;
        if (bVar.m381b() && bVar.m380a() && System.currentTimeMillis() - this.a > DateUtils.MILLIS_PER_HOUR) {
            com.xiaomi.channel.commonutils.logger.b.m182a("fetch bucket :" + bVar.m380a());
            this.a = System.currentTimeMillis();
            cv a2 = cv.a();
            a2.m341a();
            a2.m344b();
            fw a3 = this.f934a.m755a();
            if (a3 != null && (b2 = a2.b(a3.m498a().c())) != null) {
                ArrayList<String> a4 = b2.m329a();
                boolean z = true;
                Iterator<String> it = a4.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().equals(a3.m499a())) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z && !a4.isEmpty()) {
                    com.xiaomi.channel.commonutils.logger.b.m182a("bucket changed, force reconnect");
                    this.f934a.a(0, (Exception) null);
                    this.f934a.a(false);
                }
            }
        }
    }
}
