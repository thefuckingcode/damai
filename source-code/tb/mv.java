package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;

/* compiled from: Taobao */
public class mv extends a {
    public static final long DX_PARSER_GETTEMPLATEINFO = -4081992190257812457L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        DXTemplateItem dxTemplateItem;
        if (dXRuntimeContext == null || (dxTemplateItem = dXRuntimeContext.getDxTemplateItem()) == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", (Object) dxTemplateItem.name);
        jSONObject.put("version", (Object) (dxTemplateItem.version + ""));
        jSONObject.put("url", (Object) dxTemplateItem.templateUrl);
        return (objArr == null || objArr.length != 1) ? jSONObject : jSONObject.get(String.valueOf(objArr[0]));
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "getTemplateInfo";
    }
}
