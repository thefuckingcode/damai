package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.model.DXJSONObjectForVM;
import java.util.List;

/* compiled from: Taobao */
public class gx {
    public static Object a(DXRuntimeContext dXRuntimeContext, Object obj, String str) {
        try {
            if (obj instanceof DXJSONObjectForVM) {
                return a(dXRuntimeContext, ((DXJSONObjectForVM) obj).getData(), str);
            }
            if (obj instanceof JSONObject) {
                return ((JSONObject) obj).get(str);
            }
            if (obj instanceof JSONArray) {
                try {
                    return ((JSONArray) obj).get(Integer.parseInt(str));
                } catch (Exception unused) {
                    ry.s("DXExpressionParser list index is not number");
                    return null;
                }
            } else {
                if (dXRuntimeContext != null && dXRuntimeContext.supportDataProxy()) {
                    dXRuntimeContext.getDataProxy();
                    throw null;
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean b(DXRuntimeContext dXRuntimeContext, Object obj) {
        if (dXRuntimeContext == null || !dXRuntimeContext.supportDataProxy() || (obj instanceof JSONArray) || !(obj instanceof List)) {
            return false;
        }
        return true;
    }
}
