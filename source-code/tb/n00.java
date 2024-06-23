package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import java.util.Map;

/* compiled from: Taobao */
public class n00 {
    public static final String NAME = "name";
    public static final String TYPE = "t";
    public static final int TYPE_CONSTANT = 0;
    public static final int TYPE_EXPR = 1;
    public static final String URL = "url";
    public static final String VALUE = "v";
    public static final String VERSION = "version";

    public static String a(DXRuntimeContext dXRuntimeContext, String str, JSONObject jSONObject) {
        ay ayVar;
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        int intValue = jSONObject2.getIntValue("t");
        if (intValue == 0) {
            return jSONObject2.getString("v");
        }
        if (1 != intValue) {
            return null;
        }
        long longValue = jSONObject2.getLong("v").longValue();
        DXLongSparseArray<ay> d = uw.d(dXRuntimeContext.getWidgetNode());
        if (d == null || (ayVar = d.get(longValue)) == null) {
            return null;
        }
        String valueOf = String.valueOf(ayVar.b(null, dXRuntimeContext));
        ry.a("DXSlotLoaderUtil evaluateValue 的结果为: " + valueOf);
        return valueOf;
    }

    public static JSONObject b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < jSONArray.size(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getJSONObject("pTplName").getString("v");
            String string2 = jSONObject2.getJSONObject("bindSlot").getString("v");
            JSONObject jSONObject3 = jSONObject.getJSONObject(string);
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
                jSONObject.put(string, (Object) jSONObject3);
            }
            if (!jSONObject3.containsKey(string2)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject3.put(string2, (Object) jSONObject4);
                for (Map.Entry<String, Object> entry : jSONObject2.entrySet()) {
                    if (!entry.getKey().equals("pTplName") && !entry.getKey().equals("bindSlot")) {
                        jSONObject4.put(entry.getKey(), ((JSONObject) entry.getValue()).clone());
                    }
                }
            }
        }
        return jSONObject;
    }
}
