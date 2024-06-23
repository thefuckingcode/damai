package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import com.taobao.android.dinamicx.widget.f;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
public class qy extends a {
    public static final long DX_PARSER_LISTDATA = 4399723831998020670L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext.getWidgetNode() instanceof f) {
            return ((f) dXRuntimeContext.getWidgetNode()).getListData();
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return Constants.Name.Recycler.LIST_DATA;
    }
}
