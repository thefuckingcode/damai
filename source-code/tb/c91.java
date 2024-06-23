package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
public class c91 implements SystemConfigMgr.IKVChangeListener {
    private static c91 b;
    private Map<String, String> a = Collections.synchronizedMap(new HashMap());

    c91() {
        SystemConfigMgr.i().l("loglevel", this);
        onChange("loglevel", SystemConfigMgr.i().h("loglevel"));
    }

    public static synchronized c91 b() {
        c91 c91;
        synchronized (c91.class) {
            if (b == null) {
                b = new c91();
            }
            c91 = b;
        }
        return c91;
    }

    public String a(String str) {
        return this.a.get(str);
    }

    public String c(String str) {
        String a2 = a(str);
        return !TextUtils.isEmpty(a2) ? a2 : "3";
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        this.a.clear();
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
                        this.a.put(next, optString);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
