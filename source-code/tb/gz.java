package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.f;
import java.util.StringTokenizer;

/* compiled from: Taobao */
public class gz extends a {
    public static final long DX_PARSER_PARENTSUBDATA = -1943779674642760869L;

    private Object a(DXRuntimeContext dXRuntimeContext) {
        DXWidgetNode widgetNode;
        DXWidgetNode parentWidget;
        if (dXRuntimeContext == null || (widgetNode = dXRuntimeContext.getWidgetNode()) == null || (parentWidget = widgetNode.getParentWidget()) == null) {
            return null;
        }
        f fVar = (f) parentWidget;
        if (fVar.isHandleListData()) {
            return fVar.getDXRuntimeContext().getSubData();
        }
        return a(fVar.getDXRuntimeContext());
    }

    private Object b(DXRuntimeContext dXRuntimeContext, Object obj, String str) {
        if (obj == null || str == null) {
            return null;
        }
        return gx.a(dXRuntimeContext, obj, str);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        Object a = a(dXRuntimeContext);
        if (a == null) {
            return null;
        }
        if (!(objArr == null || objArr.length == 0)) {
            if (objArr.length > 1) {
                return null;
            }
            Object obj = objArr[0];
            if (!(obj instanceof String)) {
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer((String) obj, " .[]", false);
            while (stringTokenizer.hasMoreTokens()) {
                a = b(dXRuntimeContext, a, stringTokenizer.nextToken());
            }
        }
        return a;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "parentSubdata";
    }
}
