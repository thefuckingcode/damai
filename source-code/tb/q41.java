package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class q41 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static JSONObject a(Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "576548758")) {
            return (JSONObject) ipChange.ipc$dispatch("576548758", new Object[]{obj, obj2});
        } else if (obj == null && obj2 == null) {
            return null;
        } else {
            if (obj == null) {
                try {
                    return new JSONObject(Boolean.parseBoolean(obj2.toString()));
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            } else if (obj2 == null) {
                return new JSONObject(Boolean.parseBoolean(obj.toString()));
            } else {
                JSONObject parseObject = JSON.parseObject(obj.toString());
                JSONObject parseObject2 = JSON.parseObject(obj2.toString());
                for (String str : parseObject2.keySet()) {
                    Object obj3 = parseObject2.get(str);
                    if (parseObject.containsKey(str)) {
                        Object obj4 = parseObject.get(str);
                        if (obj4 instanceof JSONObject) {
                            parseObject.put(str, (Object) a(obj4, obj3));
                        } else if (!(obj4 instanceof JSONArray) || !(obj3 instanceof JSONArray)) {
                            parseObject.put(str, obj3);
                        } else {
                            ((JSONArray) obj4).addAll((JSONArray) obj3);
                        }
                    } else {
                        parseObject.put(str, obj3);
                    }
                }
                return parseObject;
            }
        }
    }
}
