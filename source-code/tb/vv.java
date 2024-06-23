package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class vv extends a {
    public static final long DX_PARSER_KV = 798575;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        JSONObject jSONObject = new JSONObject();
        if (objArr == null || objArr.length == 0 || objArr.length % 2 != 0) {
            ry.g("DXDataParserKv", "args 键值对数量不符合规范");
            return null;
        }
        for (int i = 0; i < objArr.length; i += 2) {
            if (objArr[i] != null) {
                String obj = objArr[i].toString();
                if (!TextUtils.isEmpty(obj)) {
                    jSONObject.put(obj, objArr[i + 1]);
                }
            }
        }
        return jSONObject;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "kv";
    }
}
