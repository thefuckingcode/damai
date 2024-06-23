package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
public class uo1 {
    public boolean a = true;
    public String b;
    public boolean c = true;
    public long d;
    public String e;
    public int f;
    public String g;
    public int h;
    public int i = 1;
    public boolean j = true;
    public String k;
    public int l;
    public boolean m = false;
    public h70 n;

    public uo1(boolean z) {
        this.a = z;
    }

    public static uo1 a(JSONObject jSONObject) {
        Exception e2;
        uo1 uo1 = null;
        try {
            if (jSONObject.containsKey("patches")) {
                JSONArray jSONArray = jSONObject.getJSONArray("patches");
                if (jSONArray == null || jSONArray.size() <= 0) {
                    return null;
                }
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(0);
                uo1 uo12 = new uo1(true);
                try {
                    uo12.c = true;
                    String string = jSONObject2.getString("type");
                    if ("andfix".equals(string)) {
                        String string2 = jSONObject2.getString("md5");
                        String string3 = jSONObject2.getString("patchUrl");
                        int intValue = jSONObject2.getInteger("pri").intValue();
                        long longValue = jSONObject2.getLong("size").longValue();
                        String string4 = jSONObject2.getString("mainVersion");
                        int intValue2 = jSONObject2.getInteger("version").intValue();
                        boolean booleanValue = jSONObject2.getBoolean("useSupport").booleanValue();
                        if (jSONObject2.containsKey(AgooConstants.MESSAGE_EXT)) {
                            uo12.i = jSONObject2.getInteger(AgooConstants.MESSAGE_EXT).intValue();
                        }
                        if ((uo12.i & 1) == 1) {
                            uo12.j = true;
                        } else {
                            uo12.j = false;
                        }
                        uo12.k = string;
                        uo12.g = string2;
                        uo12.b = string3;
                        uo12.h = intValue;
                        uo12.d = longValue;
                        uo12.e = string4;
                        uo12.f = intValue2;
                        uo12.c = booleanValue;
                        uo12.k = "andfix";
                    } else if (js2.DEXPATCH.equals(string)) {
                        h70 h70 = new h70();
                        uo12.n = h70;
                        h70.d = jSONObject2.getString("md5");
                        h70 h702 = uo12.n;
                        uo12.g = h702.d;
                        h702.a = jSONObject2.getLong("size").longValue();
                        h70 h703 = uo12.n;
                        uo12.d = h703.a;
                        h703.e = jSONObject2.getLong("version").longValue();
                        uo12.k = js2.DEXPATCH;
                        uo12.f = (int) uo12.n.e;
                        uo12.e = jSONObject2.getString("mainVersion");
                        if (jSONObject2.containsKey("httpsUrl")) {
                            uo12.n.b = jSONObject2.getString("httpsUrl");
                        }
                        if (jSONObject2.containsKey("patchUrl")) {
                            uo12.n.c = jSONObject2.getString("patchUrl");
                        }
                        uo12.n.f = jSONObject2.getJSONArray("updateBundles");
                    }
                    return uo12;
                } catch (Exception e3) {
                    e2 = e3;
                    uo1 = uo12;
                    e2.printStackTrace();
                    return uo1;
                }
            } else if (!jSONObject.containsKey("rollback")) {
                return null;
            } else {
                JSONObject jSONObject3 = jSONObject.getJSONObject("rollback");
                uo1 uo13 = new uo1(true);
                try {
                    uo13.m = true;
                    if (jSONObject3.containsKey("patchVersion")) {
                        uo13.l = jSONObject3.getInteger("patchVersion").intValue();
                    }
                    return uo13;
                } catch (Exception e4) {
                    e2 = e4;
                    uo1 = uo13;
                    e2.printStackTrace();
                    return uo1;
                }
            }
        } catch (Exception e5) {
            e2 = e5;
            e2.printStackTrace();
            return uo1;
        }
    }

    public String b() {
        if (this.k.equals(js2.DEXPATCH)) {
            return this.n.a();
        }
        return this.b;
    }

    public String toString() {
        return "Patch的版本为：" + this.f + " ---  " + "Patch的MD5值为：" + this.g + " ---  " + "Patch的size为：" + this.d + " ---  " + "Patch的存储路径为：" + this.b + " ---  " + "Patch优先级：" + this.h;
    }
}
