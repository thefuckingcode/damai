package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
public class kw extends a {
    public static final long DX_PARSER_QUERYRECYCLERCELLINDEXBYUSERID = 2161714594209669644L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        DXWidgetNode dXWidgetNode;
        if (dXRuntimeContext == null || dXRuntimeContext.getWidgetNode() == null) {
            return -1;
        }
        if (objArr == null || objArr.length != 2) {
            return -2;
        }
        if (objArr[0] == null) {
            return -20;
        }
        if (objArr[1] == null) {
            return -21;
        }
        String obj = objArr[0].toString();
        if (TextUtils.isEmpty(obj)) {
            return -3;
        }
        DXRootView rootView = dXRuntimeContext.getRootView();
        if (rootView == null) {
            return -4;
        }
        DXWidgetNode expandWidgetNode = rootView.getExpandWidgetNode();
        if (expandWidgetNode == null) {
            return -5;
        }
        if (at.P0(expandWidgetNode.getDXRuntimeContext())) {
            dXWidgetNode = expandWidgetNode.queryWidgetNodeByUserId(obj);
        } else {
            dXWidgetNode = expandWidgetNode.queryWTByUserId(obj);
        }
        if (!(dXWidgetNode instanceof DXRecyclerLayout)) {
            return -7;
        }
        String obj2 = objArr[1].toString();
        if (TextUtils.isEmpty(obj2)) {
            return -8;
        }
        int cellIndexByTemplateUserId = ((DXRecyclerLayout) dXWidgetNode).getCellIndexByTemplateUserId(obj2);
        if (cellIndexByTemplateUserId < 0) {
            return -9;
        }
        return Integer.valueOf(cellIndexByTemplateUserId);
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "queryRecyclerCellIndexByUserId";
    }
}
