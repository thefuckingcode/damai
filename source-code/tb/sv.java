package tb;

import com.taobao.android.dinamicx.DXDarkModeCenter;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.a;

/* compiled from: Taobao */
public class sv extends a {
    public static final long DX_PARSER_ISDARKMODE = 8991544260901901805L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        return Boolean.valueOf(DXDarkModeCenter.d() && DXDarkModeCenter.c());
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return "isDarkMode";
    }
}
