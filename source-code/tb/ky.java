package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXNodePropProvider;

/* compiled from: Taobao */
public class ky extends a {
    public static final long DX_PARSER_GETWIDGETPROPERTYVALUE = 1720632590440773916L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        DXWidgetNode widgetNode;
        Object nodePropByKey;
        Object obj = null;
        if (objArr == null || objArr.length < 2 || objArr[1] == null) {
            return null;
        }
        Object obj2 = objArr[0];
        String str = "";
        String str2 = (!(obj2 instanceof String) || TextUtils.isEmpty((CharSequence) obj2)) ? str : (String) obj2;
        Object obj3 = objArr[1];
        if (obj3 instanceof String) {
            str = (String) obj3;
        }
        if (objArr.length >= 3) {
            obj = objArr[2];
        }
        if (TextUtils.isEmpty(str) || (widgetNode = dXRuntimeContext.getWidgetNode()) == null) {
            return obj;
        }
        DXWidgetNode queryWidgetNodeByUserId = (TextUtils.isEmpty(str2) || str2.equals(widgetNode.getUserId())) ? widgetNode : widgetNode.queryWidgetNodeByUserId(str2);
        if ("root".equals(str2) && queryWidgetNodeByUserId == null) {
            queryWidgetNodeByUserId = widgetNode.queryRootWidgetNode();
        }
        return ((queryWidgetNodeByUserId instanceof IDXNodePropProvider) && (nodePropByKey = ((IDXNodePropProvider) queryWidgetNodeByUserId).getNodePropByKey(str)) != null) ? nodePropByKey : obj;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "getWidgetPropertyValue";
    }
}
