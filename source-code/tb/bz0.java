package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.utils.Logger;

/* compiled from: Taobao */
public class bz0 implements SystemConfigMgr.IKVChangeListener {
    public static final String TAG_HTTPS_HOST_PORT = "utanalytics_https_host";
    public static bz0 b;
    private String a = "https://h-adashx.ut.taobao.com/upload";

    bz0() {
        try {
            Context j = Variables.n().j();
            if (j != null) {
                c(t6.f(j, TAG_HTTPS_HOST_PORT));
                c(zc2.a(j, TAG_HTTPS_HOST_PORT));
            }
            c(SystemConfigMgr.i().h(TAG_HTTPS_HOST_PORT));
            SystemConfigMgr.i().l(TAG_HTTPS_HOST_PORT, this);
        } catch (Throwable unused) {
        }
    }

    public static synchronized bz0 b() {
        bz0 bz0;
        synchronized (bz0.class) {
            if (b == null) {
                b = new bz0();
            }
            bz0 = b;
        }
        return bz0;
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a = "https://" + str + "/upload";
        }
    }

    public String a() {
        Logger.f("", "mHttpsUrl", this.a);
        return this.a;
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        c(str2);
    }
}
