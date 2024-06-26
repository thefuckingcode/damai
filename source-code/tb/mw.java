package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
public class mw extends a {
    public static final long DX_PARSER_RECYCLERDATAINDEX = -1158194156417975076L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null || dXRuntimeContext.getWidgetNode() == null) {
            return -1;
        }
        DXWidgetNode widgetNode = dXRuntimeContext.getWidgetNode();
        DXWidgetNode dXWidgetNode = widgetNode;
        while (dXWidgetNode.getParentWidget() != null) {
            dXWidgetNode = dXWidgetNode.getParentWidget();
            if (dXWidgetNode instanceof DXRecyclerLayout) {
                return Integer.valueOf(((DXRecyclerLayout) dXWidgetNode).getDataIndex(widgetNode));
            }
        }
        return -1;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "recyclerDataIndex";
    }
}
