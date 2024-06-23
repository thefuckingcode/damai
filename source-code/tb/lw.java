package tb;

import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
public class lw extends a {
    public static final long DX_DATA_PARSER_RECYCLER_CURRENT_POSITION = -4732527849534416472L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        DXWidgetNode expandWidgetNode;
        int i = -1;
        if (objArr == null || objArr.length < 2 || dXRuntimeContext == null) {
            return -1;
        }
        Object obj = objArr[1];
        if (obj instanceof String) {
            String str = (String) obj;
            DXRootView rootView = dXRuntimeContext.getRootView();
            if (!(rootView == null || (expandWidgetNode = rootView.getExpandWidgetNode()) == null)) {
                DXWidgetNode queryWidgetNodeByUserId = expandWidgetNode.queryWidgetNodeByUserId(str);
                if (queryWidgetNodeByUserId instanceof DXRecyclerLayout) {
                    i = ((DXRecyclerLayout) queryWidgetNodeByUserId).getScrollPosition();
                }
            }
        }
        return Integer.valueOf(i);
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "recyclerCurrentPosition";
    }
}
