package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class l03 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static int c = 5;
    private static String d = "nobelKey";
    private Map<String, String> a;
    private Map<String, String> b;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final l03 a = new l03();
    }

    public static String b(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "390615318")) {
            return (String) ipChange.ipc$dispatch("390615318", new Object[]{str, Integer.valueOf(i), str2});
        }
        return d(str) + o70.DINAMIC_PREFIX_AT + i + o70.DINAMIC_PREFIX_AT + str2;
    }

    public static final l03 c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1009842757") ? (l03) ipChange.ipc$dispatch("-1009842757", new Object[0]) : b.a;
    }

    public static String d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722821793")) {
            return (String) ipChange.ipc$dispatch("722821793", new Object[]{str});
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        return stringTokenizer.nextToken() + "." + stringTokenizer.nextToken();
    }

    public static void e(Map<String, String> map, UTHitBuilders.UTControlHitBuilder uTControlHitBuilder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400943854")) {
            ipChange.ipc$dispatch("400943854", new Object[]{map, uTControlHitBuilder});
        } else if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                uTControlHitBuilder.setProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00dc  */
    public Map<String, String> a(Map<String, String> map) {
        JSONObject jSONObject;
        int i;
        String sb;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1637079081")) {
            return (Map) ipChange.ipc$dispatch("-1637079081", new Object[]{this, map});
        }
        HashMap hashMap = new HashMap(map.size());
        hashMap.putAll(map);
        StringBuilder sb2 = new StringBuilder();
        String str = null;
        try {
            jSONObject = new JSONObject((String) hashMap.get("utparam"));
            try {
                String optString = jSONObject.optString("yk_abtest");
                if (!TextUtils.isEmpty(optString)) {
                    sb2.append(optString);
                    sb2.append("|");
                    jSONObject.remove("yk_abtest");
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                g91.c("TAG", e.getLocalizedMessage());
                while (i <= c) {
                }
                sb = sb2.toString();
                str = sb.substring(0, sb.length() - 1);
                if (!TextUtils.isEmpty(str)) {
                }
                return hashMap;
            }
        } catch (Exception e3) {
            e = e3;
            jSONObject = null;
            e.printStackTrace();
            g91.c("TAG", e.getLocalizedMessage());
            while (i <= c) {
            }
            sb = sb2.toString();
            str = sb.substring(0, sb.length() - 1);
            if (!TextUtils.isEmpty(str)) {
            }
            return hashMap;
        }
        for (i = 1; i <= c; i++) {
            String str2 = d + i;
            if (hashMap.containsKey(str2)) {
                String b2 = b((String) hashMap.get("spm"), i, (String) hashMap.get(str2));
                String str3 = this.a.get(b2);
                String str4 = this.b.get(b2);
                if (!TextUtils.isEmpty(str3)) {
                    sb2.append(str3);
                    sb2.append("|");
                }
                if (!TextUtils.isEmpty(str4)) {
                    sb2.append(str4);
                    sb2.append("|");
                }
                hashMap.remove(str2);
            }
        }
        sb = sb2.toString();
        if (sb.endsWith("|") && sb.length() > 1) {
            str = sb.substring(0, sb.length() - 1);
        }
        if (!TextUtils.isEmpty(str)) {
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    g91.c("YoukuUtil", e4.getLocalizedMessage());
                }
            }
            jSONObject.put("yk_abtest", str);
            hashMap.put("utparam", jSONObject.toString());
            g91.b("YoukuUtil", "addUtparam->" + jSONObject.toString());
        }
        return hashMap;
    }

    private l03() {
        this.a = new HashMap();
        this.b = new HashMap();
        new HashMap();
    }
}
