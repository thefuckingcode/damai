package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import com.ta.audid.Constants;
import com.ut.device.UTDevice;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
public class xq2 extends vq2 {
    private static xq2 e;
    private Map<String, a> a = new HashMap();
    private int b = 10;
    private int c = 0;
    private int d = -1;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private Map<String, String> a = new HashMap();
        private Map<String, String> b = new HashMap();
        private int c = 0;

        private a() {
        }

        private String b(Map<String, String> map, String str) {
            if (str == null) {
                return null;
            }
            for (String str2 : map.keySet()) {
                if (!str2.startsWith("%") || !str2.endsWith("%")) {
                    if (str.equals(str2)) {
                        return map.get(str2);
                    }
                } else if (str.contains(str2.substring(1, str2.length() - 1))) {
                    return map.get(str2);
                }
            }
            return null;
        }

        public static a c(String str) {
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("tp")) {
                    aVar.c = xq2.e(jSONObject.optString("tp"));
                }
                if (jSONObject.has("pg")) {
                    HashMap hashMap = new HashMap();
                    JSONObject optJSONObject = jSONObject.optJSONObject("pg");
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, optJSONObject.optString(next));
                        }
                    }
                    aVar.a = hashMap;
                }
                if (jSONObject.has("arg1")) {
                    HashMap hashMap2 = new HashMap();
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("arg1");
                    if (optJSONObject2 != null) {
                        Iterator<String> keys2 = optJSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            hashMap2.put(next2, optJSONObject2.optString(next2));
                        }
                    }
                    aVar.b = hashMap2;
                }
                return aVar;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int a(String str, String str2) {
            String b2;
            String b3;
            if (!zf2.f(str) && (b3 = b(this.a, str)) != null) {
                return xq2.e(b3);
            }
            if (zf2.f(str2) || (b2 = b(this.b, str2)) == null) {
                return this.c;
            }
            return xq2.e(b2);
        }
    }

    private xq2() {
    }

    /* access modifiers changed from: private */
    public static int e(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e2) {
            Logger.f("", e2);
            return 0;
        }
    }

    public static xq2 g() {
        if (e == null) {
            e = new xq2();
        }
        return e;
    }

    private int h(String str, String str2, String str3) {
        a aVar;
        if (TextUtils.isEmpty(str) || !this.a.containsKey(str) || (aVar = this.a.get(str)) == null) {
            return 0;
        }
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return aVar.a(str2, str3);
        }
        return 0;
    }

    @Override // tb.vq2
    public String[] a() {
        return new String[]{"ut_realtime"};
    }

    @Override // tb.vq2
    public void b(String str) {
        super.b(str);
    }

    @Override // tb.vq2
    public synchronized void c(String str, Map<String, String> map) {
        Logger.f("", "aGroupname", str, "aConfContent", map);
        l();
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (str2.equals("time")) {
                    int e2 = e(str3);
                    if (e2 >= 3 && e2 <= 20) {
                        this.b = e2;
                    }
                } else if (str2.equals("sample")) {
                    int e3 = e(str3);
                    if (e3 >= 0 && e3 <= 10000) {
                        this.c = e3;
                    }
                } else {
                    a c2 = a.c(str3);
                    if (c2 != null) {
                        this.a.put(str2, c2);
                    }
                }
            }
        }
    }

    public int f() {
        return this.b;
    }

    public synchronized int i(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        str = "";
        LogField logField = LogField.EVENTID;
        if (map.containsKey(logField.toString())) {
            str = map.get(logField.toString());
        }
        LogField logField2 = LogField.PAGE;
        str2 = null;
        str3 = map.containsKey(logField2.toString()) ? map.get(logField2.toString()) : null;
        LogField logField3 = LogField.ARG1;
        if (map.containsKey(logField3.toString())) {
            str2 = map.get(logField3.toString());
        }
        return h(str, str3, str2);
    }

    public boolean j() {
        return Variables.n().N() || Variables.n().J() || Variables.n().F();
    }

    public boolean k() {
        if (j()) {
            return false;
        }
        if (Variables.n().m()) {
            return true;
        }
        if (this.d == -1) {
            String utdid = UTDevice.getUtdid(Variables.n().j());
            if (utdid == null || utdid.equals(Constants.UTDID_INVALID)) {
                return false;
            }
            this.d = Math.abs(zf2.d(utdid));
        }
        Logger.r("", "hashcode", Integer.valueOf(this.d), "sample", Integer.valueOf(this.c));
        if (this.d % 10000 < this.c) {
            return true;
        }
        return false;
    }

    public void l() {
        this.a.clear();
        this.b = 10;
        this.c = 0;
    }
}
