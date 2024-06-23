package tb;

import android.text.TextUtils;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import com.youku.middlewareservice.provider.analytics.TrackerConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.json.JSONObject;

/* compiled from: Taobao */
public class pt2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SPMCNT = "spm-cnt";
    public static final String SPMURL = "spm-url";
    public static final String UTPARAM = "utparam";
    public static final String UTPARAM_CNT = "utparam-cnt";
    public static final String UTPARAM_URL = "utparam-url";
    private static HashMap<String, String> a = new HashMap<>();
    private static HashMap<String, String> b = new HashMap<>();
    private static String c = "";

    private static void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870999660")) {
            ipChange.ipc$dispatch("870999660", new Object[]{str, str2});
        } else if (!TextUtils.isEmpty(str2)) {
            a.put(str, str2);
        }
    }

    public static Map<String, String> b(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "935341657")) {
            return (Map) ipChange.ipc$dispatch("935341657", new Object[]{map});
        }
        String str = map.get("spm-cnt");
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        if (str.indexOf("/") != -1) {
            str.substring(0, str.indexOf("/"));
        }
        HashMap hashMap = new HashMap(map.size());
        hashMap.putAll(map);
        String str2 = (String) hashMap.get("utparam-cnt");
        if (TextUtils.isEmpty(null)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "{\"abtest\":\"0\"}";
            }
            hashMap.put("utparam-cnt", str2);
            return hashMap;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "{}";
            }
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("yk_abtest");
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put("yk_abtest", (Object) null);
            } else {
                StringBuilder sb = new StringBuilder();
                if (optString.contains("|")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(optString, "|");
                    if (!stringTokenizer.hasMoreTokens()) {
                        sb.append((String) null);
                        jSONObject.put("yk_abtest", sb.toString());
                    } else {
                        stringTokenizer.nextToken();
                        throw null;
                    }
                } else {
                    throw null;
                }
            }
            hashMap.put("utparam-cnt", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1360889896")) {
            ipChange.ipc$dispatch("-1360889896", new Object[0]);
        } else {
            a.clear();
        }
    }

    public static HashMap<String, String> d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2040825874") ? (HashMap) ipChange.ipc$dispatch("2040825874", new Object[0]) : a;
    }

    public static void e(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1033483842")) {
            ipChange.ipc$dispatch("1033483842", new Object[]{map});
            return;
        }
        b.put("spm-url", d().get("spm-url"));
        b.put(TrackerConstants.VVLINK, d().get(TrackerConstants.VVLINK));
        b.put(TrackerConstants.TRACK_INFO, d().get(TrackerConstants.TRACK_INFO));
        b.put("scg_id", d().get("scg_id"));
        b.put("scm", d().get("scm"));
        b.put("utparam-url", d().get("utparam-url"));
        String str11 = "";
        if (map != null) {
            str8 = map.get(UTDataCollectorNodeColumn.OBJECT_TYPE);
            str7 = map.get(UTDataCollectorNodeColumn.OBJECT_ID);
            str6 = map.get("object_num");
            str5 = map.get(RetryMonitorDbHelper.COLUMN_GROUP_ID);
            str4 = map.get("group_num");
            str3 = map.get(TrackerConstants.TRACK_INFO);
            str2 = map.get("scg_id");
            String str12 = map.get("scm");
            str10 = map.get("utparam");
            str9 = map.get("spm");
            str = str11;
            str11 = str12;
        } else {
            str10 = str11;
            str9 = str10;
            str8 = str9;
            str7 = str8;
            str6 = str7;
            str5 = str6;
            str4 = str5;
            str3 = str4;
            str2 = str3;
            str = str2;
        }
        c();
        a("spm-url", str9);
        a(TrackerConstants.TRACK_INFO, str3);
        a("scm", str11);
        a("utparam-url", str10);
        a("r_object_type", str8);
        a("r_object_id", str7);
        a("r_object_num", str6);
        a("r_group_id", str5);
        a("r_group_num", str4);
        a("scg_id", str2);
        if (!TextUtils.isEmpty(c)) {
            a.put(TrackerConstants.VVLINK, c);
            g(str);
        } else if (!TextUtils.isEmpty(b.get(TrackerConstants.VVLINK))) {
            a.put(TrackerConstants.VVLINK, b.get(TrackerConstants.VVLINK));
        }
    }

    public static void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-751958550")) {
            ipChange.ipc$dispatch("-751958550", new Object[]{str});
        }
    }

    public static void g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108192971")) {
            ipChange.ipc$dispatch("2108192971", new Object[]{str});
            return;
        }
        c = str;
    }
}
