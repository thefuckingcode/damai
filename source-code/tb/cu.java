package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import tb.sy;

/* compiled from: Taobao */
public class cu extends is {
    @Override // tb.is
    public Object a(Object[] objArr, DXRuntimeContext dXRuntimeContext, sy.a aVar, int i) {
        if (yy.d(objArr[i])) {
            return Boolean.TRUE;
        }
        aVar.a = true;
        return Boolean.FALSE;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.expression.parser.a
    public String getDxFunctionName() {
        return o70.AND_PREFIX;
    }
}
