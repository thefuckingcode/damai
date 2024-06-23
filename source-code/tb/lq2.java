package tb;

import com.alibaba.analytics.core.Variables;
import java.util.Map;

/* compiled from: Taobao */
public class lq2 extends vq2 {
    @Override // tb.vq2
    public String[] a() {
        return new String[]{"ut_bussiness"};
    }

    @Override // tb.vq2
    public void b(String str) {
        super.b(str);
    }

    @Override // tb.vq2
    public void c(String str, Map<String, String> map) {
        String str2;
        if (map.containsKey("tpk") && (str2 = map.get("tpk")) != null) {
            Variables.n().e0(str2);
            mq2.b("tpk_md5", Variables.n().z());
        }
    }
}
