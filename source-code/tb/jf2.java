package tb;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.android.sopatch.transfer.Transfer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class jf2 implements Transfer<String, jc2> {
    private final c a = new c();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b implements Transfer<JSONArray, List<pc2>> {
        private b() {
        }

        /* renamed from: a */
        public JSONArray antiTransfer(List<pc2> list) {
            JSONArray jSONArray = new JSONArray();
            for (pc2 pc2 : list) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", pc2.b());
                    jSONObject.put("md5", pc2.a());
                    jSONObject.put("size", pc2.d());
                    jSONObject.put("patchVersion", pc2.c());
                    jSONArray.put(jSONObject);
                } catch (Exception e) {
                    s91.e(e);
                }
            }
            return jSONArray;
        }

        /* renamed from: b */
        public List<pc2> transfer(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("name");
                    String string2 = jSONObject.getString("md5");
                    arrayList.add(kc2.c(string, string2.toLowerCase(), jSONObject.getLong("size"), jSONObject.getInt("patchVersion")));
                } catch (Exception e) {
                    s91.e(e);
                }
            }
            return arrayList;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c implements Transfer<JSONArray, List<sc2>> {
        private b a;

        private c() {
            this.a = new b();
        }

        /* renamed from: a */
        public JSONArray antiTransfer(List<sc2> list) {
            JSONArray jSONArray = new JSONArray();
            for (sc2 sc2 : list) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("patchUrl", sc2.g());
                    jSONObject.put("md5", sc2.c());
                    jSONObject.put("size", sc2.f());
                    jSONObject.put("patchVersion", sc2.d());
                    List<pc2> b = sc2.b();
                    if (b != null && b.size() > 0) {
                        jSONObject.put("soLastValidPatch", this.a.antiTransfer(b));
                    }
                    jSONArray.put(jSONObject);
                } catch (Exception e) {
                    s91.e(e);
                }
            }
            return jSONArray;
        }

        /* renamed from: b */
        public List<sc2> transfer(JSONArray jSONArray) {
            List<pc2> b;
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    sc2 sc2 = new sc2(jSONObject.getString("patchUrl"), jSONObject.getInt("patchVersion"), jSONObject.getString("md5").toLowerCase(), jSONObject.getLong("size"));
                    JSONArray optJSONArray = jSONObject.optJSONArray("soLastValidPatch");
                    if (optJSONArray != null && optJSONArray.length() > 0 && (b = this.a.transfer(optJSONArray)) != null && b.size() > 0) {
                        sc2.e(b);
                    }
                    arrayList.add(sc2);
                } catch (JSONException e) {
                    s91.e(e);
                }
            }
            return arrayList;
        }
    }

    /* renamed from: a */
    public String antiTransfer(jc2 jc2) {
        if (jc2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, jc2.a());
            jSONObject.put("beta", jc2.c());
            jSONObject.put("priority", jc2.f());
            jSONObject.put("type", jc2.j());
            List<sc2> b2 = jc2.b();
            if (b2 != null && b2.size() > 0) {
                jSONObject.put("solist", this.a.antiTransfer(jc2.b()));
            }
            jSONObject.put("md5", jc2.d());
        } catch (Exception e) {
            s91.e(e);
        }
        return jSONObject.toString();
    }

    /* renamed from: b */
    public jc2 transfer(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION);
            boolean optBoolean = jSONObject.optBoolean("beta");
            int i = jSONObject.getInt("priority");
            String string2 = jSONObject.getString("type");
            List<sc2> b2 = this.a.transfer(jSONObject.getJSONArray("solist"));
            jc2 jc2 = new jc2(string, string2, i, optBoolean);
            jc2.i(b2);
            String optString = jSONObject.optString("md5");
            if (!TextUtils.isEmpty(optString)) {
                jc2.g(optString.toLowerCase());
            }
            return jc2;
        } catch (Exception e) {
            s91.e(e);
            return null;
        }
    }
}
