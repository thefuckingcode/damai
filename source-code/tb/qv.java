package tb;

import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class qv extends a {
    /* access modifiers changed from: protected */
    public int a(JSONArray jSONArray, Object obj) {
        int size = jSONArray.size();
        for (int i = 0; i < size; i++) {
            if (jSONArray.get(i) == obj) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        int a;
        if (objArr == null || objArr.length != 2) {
            return null;
        }
        Object obj = objArr[0];
        if ((obj instanceof JSONArray) && (a = a((JSONArray) obj, objArr[1])) != -1) {
            return String.valueOf(a);
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "index_of";
    }
}
