package tb;

import android.app.Application;
import android.taobao.windvane.connect.api.ApiConstants;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.common.Constants;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.staticdatastore.IStaticDataStoreComponent;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class zm1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static SecurityGuardManager a;

    public static String a(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-855005243")) {
            return (String) ipChange.ipc$dispatch("-855005243", new Object[]{map});
        } else if (map == null) {
            return "";
        } else {
            new HashMap().putAll(map);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(map.keySet());
            Collections.sort(arrayList);
            return y10.c(arrayList, map).toLowerCase();
        }
    }

    public static String b(String str) {
        IStaticDataStoreComponent staticDataStoreComp;
        String extraData;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "305041476")) {
            return (String) ipChange.ipc$dispatch("305041476", new Object[]{str});
        }
        if (a == null) {
            a = SecurityGuardManager.getInstance(xs0.a());
        }
        SecurityGuardManager securityGuardManager = a;
        if (securityGuardManager == null || (staticDataStoreComp = securityGuardManager.getStaticDataStoreComp()) == null || (extraData = staticDataStoreComp.getExtraData(str)) == null) {
            return "";
        }
        PrintStream printStream = System.out;
        printStream.println("Get extra data: " + extraData);
        return extraData;
    }

    public static Map<String, String> c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-158926633")) {
            return (Map) ipChange.ipc$dispatch("-158926633", new Object[]{str});
        }
        Application a2 = xs0.a();
        HashMap hashMap = new HashMap();
        try {
            hashMap.clear();
            hashMap.put("id", str);
            hashMap.put("appClientKey", b("appClientKey"));
            hashMap.put("channelFrom", n6.a(a2));
            hashMap.put("systemVersion", g70.e());
            hashMap.put("phoneModels", g70.b());
            hashMap.put("appType", "1");
            hashMap.put("clientGUID", g70.a(xs0.a()) + "1");
            hashMap.put("timestamp", (System.currentTimeMillis() / 1000) + "");
            hashMap.put("loginKey", d20.q());
            hashMap.put("source", "10101");
            hashMap.put("apiVersion", AppConfig.r() + "");
            hashMap.put(Constants.KEY_OS_TYPE, "2");
            hashMap.put(ApiConstants.APPSECRET, y10.b());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
