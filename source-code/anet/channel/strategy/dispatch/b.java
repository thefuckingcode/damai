package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import anet.channel.util.c;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.accs.antibrush.CookieMgr;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import tb.a90;
import tb.h9;
import tb.ju2;
import tb.ss0;

/* compiled from: Taobao */
class b {
    public static final String TAG = "amdc.DispatchParamBuilder";

    public static Map a(Map<String, Object> map) {
        IAmdcSign c = AmdcRuntimeInfo.c();
        if (c == null || TextUtils.isEmpty(c.getAppkey())) {
            ALog.e(TAG, "amdc sign is null or appkey is empty", null, new Object[0]);
            return null;
        }
        NetworkStatusHelper.NetworkStatus i = NetworkStatusHelper.i();
        if (!NetworkStatusHelper.n()) {
            ALog.e(TAG, "no network, don't send amdc request", null, new Object[0]);
            return null;
        }
        boolean h = h9.h();
        map.put("appkey", c.getAppkey());
        if (h9.N()) {
            map.put("v", a90.VER_CODE_UPGRADE);
        } else {
            map.put("v", !h ? a90.VER_CODE : a90.VER_CODE_OLD);
        }
        map.put("platform", "android");
        map.put(a90.PLATFORM_VERSION, Build.VERSION.getRELEASE());
        if (!TextUtils.isEmpty(ss0.g())) {
            map.put("sid", ss0.g());
        }
        if (!TextUtils.isEmpty(ss0.h())) {
            map.put("deviceId", ss0.h());
        }
        map.put("netType", i.toString());
        if (i.isWifi()) {
            map.put(a90.BSSID, NetworkStatusHelper.k());
        }
        map.put(a90.CARRIER, NetworkStatusHelper.c());
        map.put(a90.MNC, NetworkStatusHelper.h());
        map.put("lat", String.valueOf(AmdcRuntimeInfo.d));
        map.put("lng", String.valueOf(AmdcRuntimeInfo.e));
        if (!h) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : AmdcRuntimeInfo.b().entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                if (jSONObject.length() > 0) {
                    map.put("other", jSONObject.toString());
                }
            } catch (Exception unused) {
                ALog.e(TAG, "other set error.", null, new Object[0]);
            }
        } else {
            map.putAll(AmdcRuntimeInfo.b());
        }
        map.put("channel", AmdcRuntimeInfo.f);
        map.put("appName", AmdcRuntimeInfo.g);
        map.put("appVersion", AmdcRuntimeInfo.h);
        map.put(a90.STACK_TYPE, Integer.toString(d()));
        map.put("domain", b(map));
        String a = c.a();
        if (!TextUtils.isEmpty(a)) {
            map.put(a90.AB_STRATEGY, a);
        }
        map.put(a90.SIGNTYPE, c.useSecurityGuard() ? CookieMgr.KEY_SEC : "noSec");
        map.put("t", String.valueOf(System.currentTimeMillis()));
        String c2 = c(c, map, h);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        map.put("sign", c2);
        map.put(a90.NETWORK_ID, NetworkStatusHelper.j(i));
        return map;
    }

    private static String b(Map map) {
        StringBuilder sb = new StringBuilder();
        for (String str : (Set) map.remove("hosts")) {
            sb.append(str);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    static String c(IAmdcSign iAmdcSign, Map<String, String> map, boolean z) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(ju2.f(map.get("appkey")));
        sb.append("&");
        sb.append(ju2.f(map.get("domain")));
        sb.append("&");
        sb.append(ju2.f(map.get("appName")));
        sb.append("&");
        sb.append(ju2.f(map.get("appVersion")));
        sb.append("&");
        sb.append(ju2.f(map.get(a90.BSSID)));
        sb.append("&");
        sb.append(ju2.f(map.get("channel")));
        sb.append("&");
        sb.append(ju2.f(map.get("deviceId")));
        sb.append("&");
        sb.append(ju2.f(map.get("lat")));
        sb.append("&");
        sb.append(ju2.f(map.get("lng")));
        sb.append("&");
        sb.append(ju2.f(map.get(a90.MACHINE)));
        sb.append("&");
        sb.append(ju2.f(map.get("netType")));
        sb.append("&");
        sb.append(ju2.f(map.get("other")));
        sb.append("&");
        sb.append(ju2.f(map.get("platform")));
        sb.append("&");
        sb.append(ju2.f(map.get(a90.PLATFORM_VERSION)));
        sb.append("&");
        sb.append(ju2.f(map.get(a90.PRE_IP)));
        sb.append("&");
        sb.append(ju2.f(map.get("sid")));
        sb.append("&");
        sb.append(ju2.f(map.get("t")));
        sb.append("&");
        sb.append(ju2.f(map.get("v")));
        sb.append("&");
        sb.append(ju2.f(map.get(a90.SIGNTYPE)));
        if (!z) {
            sb.append("&");
            sb.append(ju2.f(map.get(a90.CONFIG_VERSION)));
            sb.append("&");
            sb.append(ju2.f(map.get(a90.CARRIER)));
            sb.append("&");
            sb.append(ju2.f(map.get(a90.MNC)));
            sb.append("&");
            sb.append(ju2.f(map.get(a90.STACK_TYPE)));
            sb.append("&");
            sb.append(ju2.f(map.get(a90.AB_STRATEGY)));
        }
        try {
            return iAmdcSign.sign(sb.toString());
        } catch (Exception e) {
            ALog.d(TAG, "get sign failed", null, e, new Object[0]);
            return null;
        }
    }

    private static int d() {
        int n = Inet64Util.n();
        if (n != 2) {
            return n != 3 ? 4 : 1;
        }
        return 2;
    }
}
