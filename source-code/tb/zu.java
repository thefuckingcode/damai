package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import com.taobao.android.dinamicx.widget.IDXAbTestInterface;

/* compiled from: Taobao */
public class zu extends a {
    public static final long DX_PARSER_DXAB = 33582044307L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        JSONObject jSONObject = new JSONObject();
        if (objArr != null && objArr.length > 1) {
            String obj = objArr[0].toString();
            String obj2 = objArr[1].toString();
            IDXAbTestInterface a = DXGlobalCenter.a();
            if (a != null) {
                try {
                    jSONObject.putAll(a.getClientABInfo(obj, obj2));
                } catch (Throwable th) {
                    ry.g("DXDataParserDxAB", "获取ABTest信息错误: \n" + th.getMessage());
                }
            }
        }
        return jSONObject;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "dxAB";
    }
}
