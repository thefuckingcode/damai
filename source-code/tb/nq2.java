package tb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class nq2 {
    public static final Map<String, String> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String string = jSONObject.getString(next);
                if (!(next == null || string == null)) {
                    hashMap.put(next, string);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static final qq2 b(String str, Map<String, String> map, long j) {
        qq2 qq2 = new qq2();
        qq2.f(zf2.h(map));
        qq2.h(str);
        qq2.g(j);
        return qq2;
    }

    public static final List<qq2> c(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        if (jSONObject == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.startsWith("B02N")) {
                try {
                    jSONObject2 = jSONObject.getJSONObject(next);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject2 = null;
                }
                if (next.length() > 5) {
                    next = next.substring(5);
                }
                if (jSONObject2 != null) {
                    String optString = jSONObject2.optString("content");
                    if (optString == null || !optString.equals("gc_304")) {
                        try {
                            jSONObject3 = jSONObject2.getJSONObject("content");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            jSONObject3 = null;
                        }
                        long j = 0;
                        if (jSONObject2.has("t")) {
                            try {
                                j = jSONObject2.getLong("t");
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (jSONObject3 != null) {
                            linkedList.add(b(next, a(jSONObject3), j));
                        }
                    } else {
                        qq2 qq2 = new qq2();
                        qq2.h(next);
                        qq2.e();
                        linkedList.add(qq2);
                    }
                }
            }
        }
        return linkedList;
    }
}
