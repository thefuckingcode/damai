package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.c;
import com.taobao.android.dinamicx.expression.parser.a;
import com.taobao.android.dinamicx.monitor.DXFontSize;

/* compiled from: Taobao */
public class hv extends a {
    public static final long DX_PARSER_SIZEBYFACTOR = 7983029549530032097L;

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser, com.taobao.android.dinamicx.expression.parser.a
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (!(objArr == null || objArr.length == 0)) {
            if (!c.f() || objArr.length != 1 || objArr[0] == null) {
                DXFontSize b = DXFontSize.b();
                if (objArr.length == 1 && (objArr[0] instanceof Number)) {
                    return b.c((Double) objArr[0]);
                }
                if (objArr.length == 2 && (objArr[0] instanceof Number) && (objArr[1] instanceof Number)) {
                    return b.d((Double) objArr[0], (Double) objArr[1]);
                }
                if (objArr.length == 5 && (objArr[0] instanceof Number) && (objArr[1] instanceof Number) && (objArr[2] instanceof Number) && (objArr[3] instanceof Number) && (objArr[4] instanceof Number)) {
                    return b.e((Double) objArr[0], (Double) objArr[1], (Double) objArr[2], (Double) objArr[3], (Double) objArr[4]);
                }
                if (objArr.length == 1 && objArr[0] != null) {
                    return b.f(String.valueOf(objArr[0]));
                }
                if (objArr.length == 2 && objArr[0] != null && objArr[1] != null) {
                    return b.g(String.valueOf(objArr[0]), String.valueOf(objArr[1]));
                }
                if (objArr.length == 5) {
                    return b.h(String.valueOf(objArr[0]), String.valueOf(objArr[1]), String.valueOf(objArr[2]), String.valueOf(objArr[3]), String.valueOf(objArr[4]));
                }
            } else {
                return Integer.valueOf(d00.m(DinamicXEngine.i(), c.c((float) d00.j(DinamicXEngine.i(), String.valueOf(objArr[0]), 0))));
            }
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return o70.SIZE_BY_FACTOR;
    }
}
