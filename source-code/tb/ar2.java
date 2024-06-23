package tb;

import android.net.Uri;
import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.analytics.core.config.UTClientConfigMgr;
import com.alibaba.analytics.utils.Logger;
import com.alipay.sdk.m.s.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class ar2 {
    private static ar2 d;
    private List<br2> a = new LinkedList();
    private Map<String, String> b = new HashMap();
    private String c = null;

    private ar2() {
    }

    private String a(String str, Uri uri, Map<String, String> map) {
        String str2;
        if (zf2.f(str)) {
            return null;
        }
        if (str.startsWith("${url|") && str.length() > 7) {
            String substring = str.substring(6, str.length() - 1);
            if (!zf2.f(substring) && uri != null) {
                return uri.getQueryParameter(substring);
            }
        } else if (str.startsWith("${ut|") && str.length() > 6) {
            String substring2 = str.substring(5, str.length() - 1);
            if (!zf2.f(substring2) && map != null) {
                return map.get(substring2);
            }
        } else if (!str.startsWith("${") || str.length() <= 3) {
            return str;
        } else {
            String substring3 = str.substring(2, str.length() - 1);
            if (!zf2.f(substring3)) {
                if (map != null && (str2 = map.get(substring3)) != null) {
                    return str2;
                }
                if (uri != null) {
                    return uri.getQueryParameter(substring3);
                }
            }
        }
        return null;
    }

    private void b(String str, String str2) {
        Logger.f("UTMCTPKBiz", "", "pConfName", str, "pConfContent", str2);
        if (!zf2.f(str2)) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null && optJSONObject.has("kn") && !optJSONObject.isNull("kn")) {
                        String string = optJSONObject.getString("kn");
                        if (!"a".equals(string)) {
                            br2 br2 = new br2();
                            String optString = optJSONObject.optString("v");
                            if (zf2.f(optString)) {
                                optString = "${" + string + "}";
                            }
                            String optString2 = optJSONObject.optString(a.s, br2.TYPE_FAR);
                            br2.d(string);
                            br2.e(optString);
                            br2.f(optString2);
                            this.a.add(br2);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized ar2 e() {
        ar2 ar2;
        synchronized (ar2.class) {
            if (d == null) {
                d = new ar2();
            }
            ar2 = d;
        }
        return ar2;
    }

    public synchronized void c(String str, String str2) {
        if (!zf2.f(str)) {
            if (str2 == null) {
                this.b.remove(str);
            } else {
                this.b.put(str, str2);
            }
        }
    }

    public synchronized void d(br2 br2) {
        if (br2 != null) {
            this.a.add(br2);
        }
    }

    public synchronized String f(Uri uri, Map<String, String> map) {
        String K;
        String c2 = UTClientConfigMgr.d().c("tpk_md5");
        Logger.f("UTTPKBiz", "tpk_md5", c2);
        if (!(c2 == null || c2.equals(this.c) || (K = AnalyticsMgr.K("tpk_string")) == null)) {
            b(null, K);
            this.c = "" + K.hashCode();
        }
        for (br2 br2 : this.a) {
            String a2 = br2.a();
            String c3 = br2.c();
            String b2 = br2.b();
            if (zf2.f(a2)) {
                return null;
            }
            if (zf2.f(this.b.get(a2))) {
                String a3 = a(b2, uri, map);
                if (!zf2.f(a3)) {
                    this.b.put(a2, a3);
                }
            } else if (!br2.TYPE_FAR.equals(c3)) {
                String a4 = a(b2, uri, map);
                if (!zf2.f(a4)) {
                    this.b.put(a2, a4);
                }
            }
        }
        if (!this.b.containsKey("ttid") && !zf2.f(yi.c().d())) {
            this.b.put("ttid", yi.c().d());
        }
        if (this.b.size() <= 0) {
            return null;
        }
        return jl1.BLOCK_START_STR + zf2.a(this.b) + "}";
    }

    public synchronized void g() {
        this.b.clear();
    }
}
