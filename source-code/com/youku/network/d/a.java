package com.youku.network.d;

import android.text.TextUtils;
import com.taobao.orange.OrangeConfig;
import com.youku.network.config.YKNetworkConfig;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class a {
    private static ConcurrentHashMap<String, C0259a> a = new ConcurrentHashMap<>();

    /* access modifiers changed from: private */
    /* renamed from: com.youku.network.d.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0259a {
        double a;
        YKNetworkConfig.CallType b;

        private C0259a() {
        }
    }

    private static YKNetworkConfig.CallType a(String str, double d, YKNetworkConfig.CallType callType) {
        C0259a aVar = a.get(str);
        if (aVar == null) {
            aVar = new C0259a();
        } else if (com.youku.d.b.a.a(aVar.a, d, 1.0E-6d)) {
            return aVar.b;
        }
        aVar.a = d;
        boolean z = false;
        try {
            z = com.youku.d.a.a.a(str, d);
        } catch (Exception e) {
            e.printStackTrace();
            com.youku.httpcommunication.a.c("CallRuleStrategy", "RuleSwitcher switchHit error");
        }
        if (z) {
            aVar.b = YKNetworkConfig.CallType.MTOP;
        } else {
            aVar.b = callType;
        }
        a.put(str, aVar);
        return aVar.b;
    }

    public static YKNetworkConfig.CallType a(String str, YKNetworkConfig.CallType callType) {
        if (TextUtils.isEmpty(str)) {
            return callType;
        }
        double d = 0.0d;
        try {
            d = Double.parseDouble(OrangeConfig.getInstance().getConfig(str, "percentage", "0"));
        } catch (Exception e) {
            e.getMessage();
            com.youku.httpcommunication.a.c("CallRuleStrategy", "orange error");
        }
        return a(str, d, callType);
    }
}
