package tb;

import com.alibaba.analytics.core.store.LogStoreMgr;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class o21 {
    private static boolean a;
    private static int b;

    public static void a(long j) {
        if (yq2.d().f(19999, "IPV6_DETECT")) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "" + b);
            hashMap.put("time", "" + j);
            LogStoreMgr.l().d(new u81("UT_ANALYTICS", "19999", "IPV6_DETECT", "", "", hashMap));
        }
    }

    public static void b(int i, long j) {
        if (yq2.d().f(19999, "IPV6_ERROR")) {
            HashMap hashMap = new HashMap();
            hashMap.put("errorCode", "" + i);
            hashMap.put("time", "" + j);
            hashMap.put("type", "" + b);
            LogStoreMgr.l().d(new u81("UT_ANALYTICS", "19999", "IPV6_ERROR", "", "", hashMap));
        }
    }

    public static void c(boolean z, int i, long j) {
        if (!a) {
            a = true;
            if (yq2.d().f(19999, "IPV6_INIT")) {
                HashMap hashMap = new HashMap();
                if (z) {
                    hashMap.put("success", "1");
                } else {
                    hashMap.put("success", "0");
                    hashMap.put("errorCode", "" + i);
                }
                hashMap.put("time", "" + j);
                hashMap.put("type", "" + b);
                LogStoreMgr.l().d(new u81("UT_ANALYTICS", "19999", "IPV6_INIT", "", "", hashMap));
            }
        }
    }

    public static void d(int i) {
        b = i;
    }
}
