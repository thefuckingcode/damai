package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;

/* compiled from: Taobao */
public class om2 {
    private mm2 a;
    private boolean b = false;

    public om2() {
        mm2 mm2 = new mm2();
        this.a = mm2;
        mm2.e("v6-adashx.ut.taobao.com");
        this.a.h(1);
        try {
            Context j = Variables.n().j();
            String f = t6.f(j, "utanalytics_tnet_host_port_ipv6");
            if (!TextUtils.isEmpty(f)) {
                this.b = true;
            }
            b(f);
            String a2 = zc2.a(j, "utanalytics_tnet_host_port_ipv6");
            if (!TextUtils.isEmpty(a2)) {
                this.b = true;
            }
            b(a2);
        } catch (Throwable unused) {
        }
    }

    private synchronized void b(String str) {
        String trim;
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = (trim = str.trim()).indexOf(":")) != -1) {
            String substring = trim.substring(0, indexOf);
            int parseInt = Integer.parseInt(trim.substring(indexOf + 1, trim.length()));
            if (!TextUtils.isEmpty(substring) && parseInt > 0) {
                this.a.e(substring);
                this.a.f(parseInt);
            }
        }
    }

    public mm2 a() {
        if (this.b) {
            return this.a;
        }
        if (nm2.a().e()) {
            return null;
        }
        return this.a;
    }
}
