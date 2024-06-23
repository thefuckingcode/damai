package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.utils.Logger;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class aj implements SystemConfigMgr.IKVChangeListener {
    private boolean a = false;

    public aj() {
        b(SystemConfigMgr.i().h("close_detect_ipv6"));
    }

    private void b(String str) {
        Logger.f("CloseDetectIpv6Listener", "parseConfig value", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("1".equalsIgnoreCase(str)) {
            this.a = true;
        } else {
            this.a = false;
        }
    }

    public boolean a() {
        return this.a;
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        b(str2);
    }
}
