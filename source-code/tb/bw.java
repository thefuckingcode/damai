package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class bw extends a {
    public static final long DX_PARSER_MERGEOBJ = 4689616238216008755L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        JSONObject jSONObject = new JSONObject();
        if (objArr == null || objArr.length == 0) {
            ry.g("DXDataParserMergeObj", "operationList 键值对数量不符合规范");
            return null;
        }
        for (Object obj : objArr) {
            if (obj instanceof JSONObject) {
                jSONObject.putAll((JSONObject) obj);
            }
        }
        return jSONObject;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "mergeObj";
    }
}
