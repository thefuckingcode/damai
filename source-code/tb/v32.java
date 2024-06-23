package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.utils.Logger;
import com.ta.audid.Constants;
import com.ta.utdid2.device.UTDevice;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class v32 implements SystemConfigMgr.IKVChangeListener {
    private int a = 0;

    public v32() {
        b(SystemConfigMgr.i().h("sample_ipv6"));
    }

    private void b(String str) {
        Logger.f("SampleIpv6Listener", "parseConfig value", str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.a = Integer.parseInt(str);
            } catch (Exception unused) {
                this.a = 0;
            }
        }
    }

    public boolean a() {
        String utdid = UTDevice.getUtdid(Variables.n().j());
        if (utdid == null || utdid.equals(Constants.UTDID_INVALID)) {
            return false;
        }
        int abs = Math.abs(zf2.d(utdid));
        Logger.f("SampleIpv6Listener", "hashcode", Integer.valueOf(abs), "sample", Integer.valueOf(this.a));
        if (abs % 10000 < this.a) {
            return true;
        }
        return false;
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        b(str2);
    }
}
