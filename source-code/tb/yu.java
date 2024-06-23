package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;
import com.taobao.weex.ui.component.WXBasicComponentType;

/* compiled from: Taobao */
public class yu extends a {
    public static final long DX_PARSER_DIV = 518002038;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        return wy.a(objArr, 4);
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return WXBasicComponentType.DIV;
    }
}
