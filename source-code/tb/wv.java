package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import java.util.List;

/* compiled from: Taobao */
public class wv extends a {
    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null && objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                return String.valueOf(((String) obj).length());
            }
            if (obj instanceof JSONArray) {
                return String.valueOf(((JSONArray) obj).size());
            }
            if (obj instanceof JSONObject) {
                return String.valueOf(((JSONObject) obj).size());
            }
            if (obj instanceof List) {
                dXRuntimeContext.getDataProxy();
            }
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "len";
    }
}
