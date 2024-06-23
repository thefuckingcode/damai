package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import java.util.Map;

/* compiled from: Taobao */
public class bv extends px {
    public static final long DX_PARSER_DXEVENTPROP = -3357931786827536758L;

    public Object e(lx lxVar, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        JSONObject jSONObject;
        Object evalWithArgs = super.evalWithArgs(objArr, dXRuntimeContext);
        if (evalWithArgs != null) {
            return evalWithArgs;
        }
        if (objArr == null || objArr.length == 0 || !(objArr[0] instanceof String) || lxVar == null) {
            return new JSONObject();
        }
        if (lxVar.a() == null || lxVar.a().isEmpty()) {
            jSONObject = g31.f(lxVar, true, lx.class);
        } else {
            jSONObject = new JSONObject();
            for (Map.Entry<String, ey> entry : lxVar.a().entrySet()) {
                jSONObject.put(entry.getKey(), (Object) entry.getValue());
            }
        }
        return b((String) objArr[0], jSONObject, dXRuntimeContext);
    }
}
