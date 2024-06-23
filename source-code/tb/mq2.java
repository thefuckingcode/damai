package tb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class mq2 {
    private static Map<String, String> a = new HashMap();

    public static synchronized void a() {
        synchronized (mq2.class) {
            for (Map.Entry<String, String> entry : a.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
        }
    }

    public static synchronized void b(String str, String str2) {
        synchronized (mq2.class) {
            try {
                Context j = Variables.n().j();
                if (j == null) {
                    j = yi.c().b();
                }
                if (j != null) {
                    if (TextUtils.isEmpty(str2) || str2.length() <= 100000) {
                        a.put(str, str2);
                        String packageName = j.getPackageName();
                        Logger.f("UTConfigMgr", "postServerConfig packageName", packageName, "key", str, "value", str2);
                        Intent intent = new Intent("com.alibaba.analytics.config.change");
                        intent.setPackage(packageName);
                        intent.putExtra("key", str);
                        intent.putExtra("value", str2);
                        j.sendBroadcast(intent);
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                Logger.h("UTConfigMgr", th, new Object[0]);
            }
        }
    }
}
