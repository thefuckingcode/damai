package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class iv extends a {
    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null && objArr.length == 2) {
            Object obj = objArr[0];
            if (obj instanceof JSONObject) {
                return ((JSONObject) obj).get(objArr[1]);
            } else if (obj instanceof JSONArray) {
                Object obj2 = objArr[1];
                if (!(obj2 instanceof String)) {
                    return null;
                }
                JSONArray jSONArray = (JSONArray) obj;
                int f = yy.f((String) obj2);
                if (f < 0 || f >= jSONArray.size()) {
                    return null;
                }
                return jSONArray.get(f);
            } else {
                dXRuntimeContext.getDataProxy();
            }
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "dict_get";
    }
}
